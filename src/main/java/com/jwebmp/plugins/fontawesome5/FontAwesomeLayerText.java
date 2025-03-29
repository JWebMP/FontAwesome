package com.jwebmp.plugins.fontawesome5;

import com.jwebmp.core.base.angular.client.annotations.references.NgImportModule;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.html.*;
import com.jwebmp.plugins.fontawesome5.options.*;
import jakarta.validation.constraints.*;
import org.apache.commons.lang3.*;

import static com.guicedee.services.jsonrepresentation.json.StaticStrings.*;

@NgImportReference(value = "FaLayersCounterComponent", reference = "@fortawesome/angular-fontawesome")
@NgImportModule("FaLayersTextComponent")

public class FontAwesomeLayerText extends DivSimple<FontAwesomeLayerText>
{
    public FontAwesomeLayerText()
    {
        setTag("fa-layers-text");
    }

    @Override
    public @NotNull FontAwesomeLayerText setText(String text)
    {
        addAttribute("content", text);
        return this;
    }

    public FontAwesomeLayerText transform(FontAwesomeTransforms... transforms)
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
