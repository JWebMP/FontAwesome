package com.jwebmp.plugins.fontawesome5;

import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.plugins.fontawesome5.options.FontAwesomeTransforms;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.StringUtils;

import java.util.Set;

import static com.guicedee.services.jsonrepresentation.json.StaticStrings.STRING_SPACE;

@NgImportReference(value = "FaLayersCounterComponent", reference = "@fortawesome/angular-fontawesome")
public class FontAwesomeLayerCounter extends DivSimple<FontAwesomeLayerCounter> implements INgComponent<FontAwesomeLayerCounter>
{
    public FontAwesomeLayerCounter()
    {
        setTag("fa-layers-counter");
    }


    @Override
    public Set<String> moduleImports()
    {
        var s = INgComponent.super.moduleImports();
        s.add("FaLayersCounterComponent");
        return s;
    }

    @Override
    public @NotNull FontAwesomeLayerCounter setText(String text)
    {
        addAttribute("content", text);
        return this;
    }

    public FontAwesomeLayerCounter transform(FontAwesomeTransforms... transforms)
    {
        StringBuilder attributeValue = new StringBuilder(StringUtils.trimToEmpty(getAttributes().get("data-fa-transform")));
        for (FontAwesomeTransforms transform : transforms)
        {
            attributeValue.append(transform)
                          .append(STRING_SPACE);
        }
        addAttribute("transform", attributeValue.toString());
        return this;
    }

}
