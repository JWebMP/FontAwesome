"""Refresh free catalogs and append missing names to the legacy enums.

python scripts/generate-icon-enums.py --version 7.3.1
python scripts/generate-icon-enums.py --catalog scripts/icon-catalog.json --check
"""
import argparse
import json
from pathlib import Path
import re
import urllib.request

ROOT = Path(__file__).resolve().parent.parent
PACKAGE = ROOT / 'src/main/java/com/jwebmp/plugins/fontawesome5/icons'


def query(text):
    request = urllib.request.Request('https://api.fontawesome.com', json.dumps({'query': text}).encode(),
                                    {'Content-Type': 'application/json', 'User-Agent': 'Mozilla/5.0 JWebMP-Catalog-Generator'})
    with urllib.request.urlopen(request, timeout=60) as response:
        data = json.load(response)
    if data.get('errors'):
        raise ValueError(data['errors'])
    return data['data']['release']


def download(version):
    version = query('{release(version:' + json.dumps(version) + '){version}}')['version']
    icons = []
    page = 1
    while True:
        data = query('{release(version:' + json.dumps(version) + '){iconsPaginated(page:' + str(page)
                     + ',pageSize:500){totalPageCount totalIconCount icons{id familyStylesByLicense{free{family style}}}}}}')['iconsPaginated']
        icons.extend(data['icons'])
        if page == data['totalPageCount']:
            break
        page += 1
    if len(icons) != data['totalIconCount'] or len({i['id'] for i in icons}) != len(icons):
        raise ValueError('Incomplete or duplicate metadata')
    return compact({'version': version, 'icons': icons})


def compact(data):
    styles = {'solid': [], 'regular': [], 'brands': []}
    for icon in data['icons']:
        for pair in icon['familyStylesByLicense']['free']:
            if pair['family'] != 'classic' or pair['style'] not in styles:
                raise ValueError(f'Unexpected free family/style: {pair}')
            styles[pair['style']].append(icon['id'])
    return {'version': data['version'], 'source': 'https://api.fontawesome.com',
            'styles': {style: sorted(set(names)) for style, names in styles.items()}}


def identifier(name):
    # Font Awesome currently has no Java keyword names in its free catalogs.
    value = ('$' if name[0].isdigit() else '') + name.replace('-', '_')
    if not re.fullmatch(r'[$a-zA-Z_][$a-zA-Z_0-9]*', value):
        raise ValueError(name)
    return value


def generate(catalog):
    outputs = {}
    for style, names in catalog['styles'].items():
        if not names or len(set(names)) != len(names):
            raise ValueError(f'Empty or duplicate {style} catalog')
        class_name = 'FontAwesomeFree' + style.title() + 'Icons'
        body = ',\n'.join('    ' + identifier(n) for n in names) + ';'
        family = 'Brands' if style == 'brands' else 'Classic'
        outputs[PACKAGE / (class_name + '.java')] = f'''package com.jwebmp.plugins.fontawesome5.icons;

import com.jwebmp.plugins.fontawesome5.IFontAwesomeFreeIcon;
import com.jwebmp.plugins.fontawesome5.options.IconFamily;
import com.jwebmp.plugins.fontawesome5.options.IconVariant;
import java.util.Set;

/**
 * Free {style} icons in Font Awesome {catalog['version']} ({len(names)} canonical names).
 * Generated from public metadata by scripts/generate-icon-enums.py. No aliases.
 */
public enum {class_name} implements IFontAwesomeFreeIcon
{{
{body}

    @Override
    public IconFamily getFamily() {{ return IconFamily.{family}; }}

    @Override
    public IconVariant getVariant() {{ return IconVariant.{style.title()}; }}

    @Override
    public Set<IconVariant> getSupportedVariants() {{ return Set.of(getVariant()); }}

    @Override
    public String toString() {{ return "fa-" + toAngularIconAttributeName(); }}
}}
'''
    for file, styles in [('FontAwesomeIcons.java', ['solid', 'regular']), ('FontAwesomeBrandIcons.java', ['brands'])]:
        path = PACKAGE / file
        text = path.read_text(encoding='utf-8')
        # Preserve existing constants, aliases and ordinals; append only missing names.
        start = text.index('{', text.index('public enum')) + 1
        end = text.index(';', start)
        old = set(re.findall(r'^\s*([$\w]+)\s*,', text[start:end], re.M))
        missing = sorted({identifier(n) for s in styles for n in catalog['styles'][s]} - old)
        if missing:
            text = text[:end].rstrip() + '\n    ' + ',\n    '.join(missing) + ',\n\n    ' + text[end:]
        outputs[path] = text
    return outputs


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--version', default='7.3.1')
    parser.add_argument('--catalog', type=Path)
    parser.add_argument('--check', action='store_true')
    args = parser.parse_args()
    catalog = json.loads(args.catalog.read_text(encoding='utf-8')) if args.catalog else download(args.version)
    if 'icons' in catalog:
        catalog = compact(catalog)
    outputs = generate(catalog)
    outputs[ROOT / 'scripts/icon-catalog.json'] = json.dumps(catalog, indent=2) + '\n'
    for path, text in outputs.items():
        if args.check:
            if not path.exists() or path.read_text(encoding='utf-8') != text:
                raise SystemExit(f'Generated file differs: {path}')
        else:
            path.write_text(text, encoding='utf-8', newline='\n')
    print(f"{'Checked' if args.check else 'Updated'} free and legacy catalogs for {catalog['version']}: "
          + ', '.join(f'{s}={len(n)}' for s, n in catalog['styles'].items()))


if __name__ == '__main__':
    main()
