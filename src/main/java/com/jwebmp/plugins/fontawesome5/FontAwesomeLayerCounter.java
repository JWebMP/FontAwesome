package com.jwebmp.plugins.fontawesome5;

import com.jwebmp.core.base.html.*;
import com.jwebmp.plugins.fontawesome5.options.*;
import jakarta.validation.constraints.*;
import org.apache.commons.lang3.*;

import static com.guicedee.guicedinjection.json.StaticStrings.*;

public class FontAwesomeLayerCounter extends DivSimple<FontAwesomeLayerCounter>
{
	public FontAwesomeLayerCounter()
	{
		setTag("fa-layers-counter");
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
