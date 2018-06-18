package com.jwebmp.plugins.fontawesome5;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

import com.jwebmp.base.html.DivSimple;
import com.jwebmp.base.html.Italic;
import com.jwebmp.plugins.fontawesome5.options.FontAwesomeDisplayOptions;
import com.jwebmp.plugins.fontawesome5.options.FontAwesomeSizes;
import com.jwebmp.plugins.fontawesome5.options.FontAwesomeStyles;

import static com.jwebmp.utilities.StaticStrings.STRING_EMPTY;
import static com.jwebmp.utilities.StaticStrings.STRING_SPACE;

/**
 * Masking
 * NEW
 * <p>
 * Combine two icons create one single-color shape, thanks to the power of SVG in Font Awesome 5! Use it with our new Power Transforms for some
 * really awesome effects.
 * <p>
 * Masks are great when you do want your background color to show through. For clarity in the example, we’ve added a background color on the icon
 * so you can see the effect.
 *
 * @param <J>
 */
public class FontAwesomeMaskGroup<J extends FontAwesomeMaskGroup<J>> extends DivSimple<J> {

	@SuppressWarnings("unchecked")
	@NotNull
	public J addIcon(@NotNull IFontAwesomeIcon icon, @NotNull FontAwesomeStyles iconStyle, @NotNull IFontAwesomeIcon mask, @NotNull 
		FontAwesomeStyles maskIconStyle, @Nullable FontAwesomeDisplayOptions...displayOptions) {
		Italic<?> maskedIcon = new Italic<>();
		maskedIcon.addClass(iconStyle).addClass(icon);

		if (displayOptions != null && displayOptions.length > 0) {
			StringBuilder transformClasses = new StringBuilder();
			for (FontAwesomeDisplayOptions displayOption : displayOptions) {
				transformClasses.append(displayOption).append(STRING_SPACE);
			}
			maskedIcon.addAttribute("data-fa-transform", transformClasses.toString());
		}

		maskedIcon.addAttribute("data-fa-mask", maskIconStyle + STRING_EMPTY + mask);

		add(maskedIcon);
		return (J) this;
	}
	
	@SuppressWarnings("unchecked")
	@NotNull
	public J setSize(FontAwesomeSizes size)
	{
		addClass(size);
		return (J)this;
	}
}
