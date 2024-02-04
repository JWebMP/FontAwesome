/*
 * Copyright (C) 2017 GedMarc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jwebmp.plugins.fontawesome5;

import com.jwebmp.core.base.*;
import com.jwebmp.core.base.angular.client.annotations.references.*;
import com.jwebmp.core.base.angular.client.services.interfaces.*;
import com.jwebmp.core.base.html.*;
import com.jwebmp.core.base.interfaces.*;
import com.jwebmp.core.htmlbuilder.css.*;
import com.jwebmp.core.plugins.*;
import com.jwebmp.plugins.fontawesome5.icons.*;
import com.jwebmp.plugins.fontawesome5.options.*;
import jakarta.validation.constraints.*;
import org.apache.commons.lang3.*;

import java.util.List;
import java.util.Map;
import java.util.*;

import static com.guicedee.services.jsonrepresentation.json.StaticStrings.*;
import static com.jwebmp.core.base.angular.client.services.interfaces.AnnotationUtils.*;
import static com.jwebmp.plugins.fontawesome5.config.FontAwesome5PageConfigurator.*;

/**
 * The FontAwesome project.
 * <p>
 *
 * @author GedMarc
 * @version 1.0
 * @since 21 May 2016
 */
@SuppressWarnings("unused")
@ComponentInformation(name = "Font Awesome 5",
                      description = "The font awesome tag",
                      url = "www.fontawesome.com")

@NgImportReference(value = "FaIconLibrary",reference = "@fortawesome/angular-fontawesome",onParent = true)
public class FontAwesome<J extends FontAwesome<J>>
		extends Italic<J>
		implements IFontAwesome<J>, IIcon<IComponentHierarchyBase<?, ?>, J>, INgComponent<J>
{
	private FontAwesomeStyles style;
	private IFontAwesomeIcon icon;
	
	/**
	 * Construct a new instant of a font awesome icon
	 *
	 * @param icon
	 */
	public FontAwesome(FontAwesomeStyles style, IFontAwesomeIcon icon)
	{
		this();
		this.style = style;
		this.icon = icon;
	}
	
	/**
	 * A blank no icon italic tag
	 */
	public FontAwesome()
	{
		setTag("fa-icon");
	}
	
	@Override
	public List<NgImportReference> getAllImportAnnotations()
	{
		List<NgImportReference> out = INgComponent.super.getAllImportAnnotations();
		out.add(getNgImportReference(icon.toAngularIcon() + " as " + getFieldIdentifier(), tsDependencies.get(style)));
		return out;
	}
	
	public String getFieldIdentifier()
	{
		return style.getText() + icon.toAngularIcon();
	}
	
	@Override
	public List<String> constructorParameters()
	{
		List<String> out = INgComponent.super.constructorParameters();
		out.add("library: FaIconLibrary");
		return out;
	}
	
	@Override
	public List<String> constructorBody()
	{
		List<String> out = INgComponent.super.constructorBody();
		out.add(" library.addIcons(" + getFieldIdentifier() + ");");
		return out;
	}
	/**
	 * Inserts the icon and style classes
	 */
	@Override
	public void preConfigure()
	{
		if (!isConfigured())
		{
			if (icon != null && FontAwesomeBrandIcons.class.isAssignableFrom(icon.getClass()) && style == null)
			{
				style = FontAwesomeStyles.Brand;
			}
			if (style == null)
			{
				style = FontAwesomeStyles.Solid;
			}
			if (icon != null)
			{
				addAttribute("[icon]", "['" + style.getText() + "','" + icon.toAngularIconAttributeName() + "']");
				//addAttribute("[icon]", icon.toAngularIcon());
			}
		}
		super.preConfigure();
	}
	
	/**
	 * Creates a new icon with the given icon and size in the solid format
	 *
	 * @param icon The icon to apply
	 * @param size The size to use
	 * @return The new font awesome icon
	 */
	public static FontAwesome<?> icon(IFontAwesomeIcon icon, FontAwesomeSizes size)
	{
		return new FontAwesome<>().setSize(size)
		                          .setIcon(icon)
		                          .setStyle(FontAwesomeStyles.Solid);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J setSize(FontAwesomeSizes size)
	{
		addAttribute("size", size.toString());
		return (J) this;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J spin()
	{
		addAttribute("[spin]", "true");
		return (J) this;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J pulse()
	{
		addAttribute("[pulse]", "true");
		return (J) this;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J pullRight()
	{
		addAttribute("pull", "right");
		return (J) this;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J pullLeft()
	{
		addAttribute("pull", "left");
		return (J) this;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J border()
	{
		addAttribute("[border]", "true");
		return (J) this;
	}
	
	public J inverse()
	{
		addAttribute("[inverse]", "true");
		return (J) this;
	}
	
	public J style(CSSImpl css)
	{
		addAttribute("[styles]", "{" + css.toString() + "}");
		return (J) this;
	}
	
	public J primaryColour(String primary)
	{
		addAttribute("primaryColor", primary);
		return (J) this;
	}
	
	public J secondaryColour(String secondary)
	{
		addAttribute("secondaryColor", secondary);
		return (J) this;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J fixedWidth()
	{
		addAttribute("[fixedWidth]", "true");
		return (J) this;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
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
	
	@Override
	public FontAwesomeStyles getStyle()
	{
		return style;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J setStyle(FontAwesomeStyles style)
	{
		this.style = style;
		return (J) this;
	}
	
	@Override
	public IFontAwesomeIcon getIcon()
	{
		return icon;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J setIcon(IFontAwesomeIcon icon)
	{
		this.icon = icon;
		return (J) this;
	}
	
	/**
	 * Creates a new icon with the given icon and size in the solid format
	 *
	 * @param icon   The icon to apply
	 * @param styles The size to use
	 * @return The new font awesome icon
	 */
	public static FontAwesome<?> icon(IFontAwesomeIcon icon, FontAwesomeStyles styles)
	{
		return new FontAwesome<>().setIcon(icon)
		                          .setStyle(styles);
	}
	
	/**
	 * Creates a new icon with the given icon and size in the solid format
	 *
	 * @param icon The icon to apply
	 * @param size The size to use
	 * @return The new font awesome icon
	 */
	public static FontAwesome<?> icon(IFontAwesomeIcon icon, FontAwesomeSizes size, FontAwesomeStyles styles)
	{
		return new FontAwesome<>().setSize(size)
		                          .setIcon(icon)
		                          .setStyle(styles);
	}
	
	/**
	 * Creates a new icon with the given icon and size in the solid format
	 *
	 * @param icon The icon to apply
	 * @return The new font awesome icon
	 */
	public static String iconString(IFontAwesomeIcon icon)
	{
		return new FontAwesome<>().setIcon(icon)
		                          .setStyle(FontAwesomeStyles.Solid)
		                          .setTiny(true)
		                          .toString(0);
	}
	
	/**
	 * Creates a new icon with the given icon and size in the solid format
	 *
	 * @param icon   The icon to apply
	 * @param styles The size to use
	 * @return The new font awesome icon
	 */
	public static String iconString(IFontAwesomeIcon icon, FontAwesomeStyles styles)
	{
		return new FontAwesome<>().setIcon(icon)
		                          .setStyle(styles)
		                          .setTiny(true)
		                          .toString(0);
	}
	
	/**
	 * Creates a new icon with the given icon and size in the solid format
	 *
	 * @param icon The icon to apply
	 * @param size The size to use
	 * @return The new font awesome icon
	 */
	public static String iconString(IFontAwesomeIcon icon, FontAwesomeSizes size, FontAwesomeStyles styles)
	{
		return new FontAwesome<>().setSize(size)
		                          .setIcon(icon)
		                          .setStyle(styles)
		                          .setTiny(true)
		                          .toString(0);
	}
	
	/**
	 * Creates a new icon with the given icon and size in the solid format
	 *
	 * @param icon The icon to apply
	 * @return The new font awesome icon
	 */
	public static FontAwesome<?> icon(IFontAwesomeIcon icon)
	{
		return new FontAwesome<>().setIcon(icon)
		                          .setStyle(FontAwesomeStyles.Solid);
	}
	
	
	/**
	 * A smaller neater option for Font Awesome
	 *
	 * @return
	 */
	public IFontAwesome<?> asMe()
	{
		return this;
	}
	
	@Override
	public int hashCode()
	{
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object o)
	{
		return false;
	}
	
	@Override
	public String getClassName()
	{
		return this.style + " " + this.icon;
	}
	
	@Override
	public ComponentHierarchyBase<?, ?, ?, ?, ?> getIconComponent()
	{
		return this;
	}
}
