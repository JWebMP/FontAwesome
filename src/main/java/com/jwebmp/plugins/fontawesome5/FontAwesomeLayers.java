package com.jwebmp.plugins.fontawesome5;

import com.jwebmp.core.base.angular.client.annotations.references.NgImportModule;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.htmlbuilder.css.CSSImpl;
import com.jwebmp.plugins.fontawesome5.options.FontAwesomeSizes;
import com.jwebmp.plugins.fontawesome5.options.FontAwesomeTransforms;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.StringUtils;

import java.util.Set;

import static com.guicedee.modules.services.jsonrepresentation.json.StaticStrings.STRING_SPACE;

@NgImportReference(value = "FaLayersComponent", reference = "@fortawesome/angular-fontawesome")
@NgImportModule("FaLayersComponent")
public class FontAwesomeLayers<J extends FontAwesomeLayers<J>> extends DivSimple<J> implements INgComponent<J>
{
    public FontAwesomeLayers()
    {
        setTag("fa-layers");
    }

    @SuppressWarnings("unchecked")
    public J addIcon(FontAwesome<?> icon)
    {
        add(icon);
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J addCounter(FontAwesomeLayerCounter icon)
    {
        add(icon);
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J addText(FontAwesomeLayerText icon)
    {
        add(icon);
        return (J) this;
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public J setSize(FontAwesomeSizes size)
    {
        addAttribute("size", size.toString());
        return (J) this;
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public J spin()
    {
        addAttribute("[spin]", "true");
        return (J) this;
    }


    @NotNull
    @SuppressWarnings("unchecked")
    public J pulse()
    {
        addAttribute("[pulse]", "true");
        return (J) this;
    }


    @NotNull
    @SuppressWarnings("unchecked")
    public J pullRight()
    {
        addAttribute("pull", "right");
        return (J) this;
    }


    @NotNull
    @SuppressWarnings("unchecked")
    public J pullLeft()
    {
        addAttribute("pull", "left");
        return (J) this;
    }


    @NotNull
    @SuppressWarnings("unchecked")
    public J border()
    {
        addAttribute("[border]", "true");
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J inverse()
    {
        addAttribute("[inverse]", "true");
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J style(CSSImpl css)
    {
        addAttribute("[styles]", "{" + css.toString() + "}");
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J primaryColour(String primary)
    {
        addAttribute("primaryColor", primary);
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J secondaryColour(String secondary)
    {
        addAttribute("secondaryColor", secondary);
        return (J) this;
    }


    @NotNull
    @SuppressWarnings("unchecked")
    public J fixedWidth()
    {
        addAttribute("[fixedWidth]", "true");
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J transform(FontAwesomeTransforms... transforms)
    {
        StringBuilder attributeValue = new StringBuilder(StringUtils.trimToEmpty(getAttributes().get("data-fa-transform")));
        for (FontAwesomeTransforms transform : transforms)
        {
            attributeValue.append(transform)
                    .append(STRING_SPACE);
        }
        addAttribute("transform", attributeValue.toString());
        return (J) this;
    }
}
