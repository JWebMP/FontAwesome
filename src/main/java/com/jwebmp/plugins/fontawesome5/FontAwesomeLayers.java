package com.jwebmp.plugins.fontawesome5;

import com.jwebmp.core.base.html.*;
import com.jwebmp.core.htmlbuilder.css.*;
import com.jwebmp.plugins.fontawesome5.options.*;
import jakarta.validation.constraints.*;
import org.apache.commons.lang3.*;

import static com.guicedee.guicedinjection.json.StaticStrings.*;

public class FontAwesomeLayers extends DivSimple<FontAwesomeLayers>
{
	public FontAwesomeLayers()
	{
		setTag("fa-layers");
	}
	
	public FontAwesomeLayers addIcon(FontAwesome<?> icon)
	{
		add(icon);
		return this;
	}
	
	public FontAwesomeLayers addCounter(FontAwesomeLayerCounter icon)
	{
		add(icon);
		return this;
	}
	
	public FontAwesomeLayers addText(FontAwesomeLayerText icon)
	{
		add(icon);
		return this;
	}
	
	@NotNull
	public FontAwesomeLayers setSize(FontAwesomeSizes size)
	{
		addAttribute("size", size.toString());
		return this;
	}
	
	@NotNull
	public FontAwesomeLayers spin()
	{
		addAttribute("[spin]", "true");
		return this;
	}
	
	
	@NotNull
	public FontAwesomeLayers pulse()
	{
		addAttribute("[pulse]", "true");
		return this;
	}
	
	
	@NotNull
	public FontAwesomeLayers pullRight()
	{
		addAttribute("pull", "right");
		return this;
	}
	
	
	@NotNull
	public FontAwesomeLayers pullLeft()
	{
		addAttribute("pull", "left");
		return this;
	}
	
	
	@NotNull
	public FontAwesomeLayers border()
	{
		addAttribute("[border]", "true");
		return this;
	}
	
	public FontAwesomeLayers inverse()
	{
		addAttribute("[inverse]", "true");
		return this;
	}
	
	public FontAwesomeLayers style(CSSImpl css)
	{
		addAttribute("[styles]", "{" + css.toString() + "}");
		return this;
	}
	
	public FontAwesomeLayers primaryColour(String primary)
	{
		addAttribute("primaryColor", primary);
		return this;
	}
	
	public FontAwesomeLayers secondaryColour(String secondary)
	{
		addAttribute("secondaryColor", secondary);
		return this;
	}
	
	
	@NotNull
	public FontAwesomeLayers fixedWidth()
	{
		addAttribute("[fixedWidth]", "true");
		return this;
	}
	
	public FontAwesomeLayers transform(FontAwesomeTransforms... transforms)
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
