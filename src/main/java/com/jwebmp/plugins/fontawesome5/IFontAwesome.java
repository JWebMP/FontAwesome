package com.jwebmp.plugins.fontawesome5;

import com.jwebmp.plugins.fontawesome5.options.FontAwesomeDisplayOptions;
import com.jwebmp.plugins.fontawesome5.options.FontAwesomeSizes;
import com.jwebmp.plugins.fontawesome5.options.FontAwesomeStyles;
import com.jwebmp.plugins.fontawesome5.options.FontAwesomeTransforms;

import jakarta.validation.constraints.NotNull;

import static com.guicedee.guicedinjection.json.StaticStrings.STRING_SPACE;
import static com.jwebmp.core.utilities.StaticStrings.*;

public interface IFontAwesome<J extends FontAwesome<J>>
{

	/**
	 * Masking
	 * * NEW
	 * * <p>
	 * * Combine two icons create one single-color shape, thanks to the power of SVG in Font Awesome 5! Use it with our new Power Transforms for
	 * some
	 * * really awesome effects.
	 * * <p>
	 * * Masks are great when you do want your background color to show through. For clarity in the example, we’ve added a background color on the
	 * icon
	 * * so you can see the effect.
	 *
	 * @param icon
	 * 		The icon to use, brands or standard
	 * @param iconStyle
	 * 		the style to apply to the icon, regular solid or light
	 * @param mask
	 * 		The mask to apply behind the icon
	 * @param maskIconStyle
	 * 		The style of the icon behind the icon
	 * @param displayOptions
	 * 		Any display options or transformations you may want
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	static FontAwesome<?> createMaskIcon(
			@NotNull IFontAwesomeIcon icon,
			@NotNull FontAwesomeStyles iconStyle, @NotNull IFontAwesomeIcon mask, @NotNull FontAwesomeStyles maskIconStyle, FontAwesomeDisplayOptions... displayOptions)
	{

		FontAwesome<?> maskedIcon = new FontAwesome<>(iconStyle, icon);
		if (displayOptions != null && displayOptions.length > 0)
		{
			StringBuilder transformClasses = new StringBuilder();
			for (FontAwesomeDisplayOptions displayOption : displayOptions)
			{
				transformClasses.append(displayOption)
				                .append(STRING_SPACE);
			}
			maskedIcon.addAttribute("data-fa-transform", transformClasses.toString());
		}

		maskedIcon.addAttribute("data-fa-mask", maskIconStyle + STRING_SPACE + mask);
		return maskedIcon;
	}

	/**
	 * Creates a new icon with the given style
	 *
	 * @param icon
	 * @param iconStyle
	 *
	 * @return
	 */
	static FontAwesome<?> createIcon(@NotNull IFontAwesomeIcon icon, @NotNull FontAwesomeStyles iconStyle)
	{
		return new FontAwesome<>(iconStyle, icon);
	}

	@SuppressWarnings("unchecked")
	@NotNull
	J setSize(FontAwesomeSizes size);

	@SuppressWarnings("unchecked")
	@NotNull
	J spin();

	@SuppressWarnings("unchecked")
	@NotNull
	J pulse();

	@SuppressWarnings("unchecked")
	@NotNull
	J pullRight();

	@SuppressWarnings("unchecked")
	@NotNull
	J pullLeft();

	@SuppressWarnings("unchecked")
	@NotNull
	J border();

	@SuppressWarnings("unchecked")
	@NotNull
	J fixedWidth();

	@SuppressWarnings("unchecked")
	@NotNull
	J transform(FontAwesomeTransforms... transforms);

	FontAwesomeStyles getStyle();

	@SuppressWarnings("unchecked")
	@NotNull
	J setStyle(FontAwesomeStyles style);

	IFontAwesomeIcon getIcon();

	@SuppressWarnings("unchecked")
	@NotNull
	J setIcon(IFontAwesomeIcon icon);
}
