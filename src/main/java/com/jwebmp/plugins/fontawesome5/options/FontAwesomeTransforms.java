package com.jwebmp.plugins.fontawesome5.options;

import com.jwebmp.core.base.interfaces.ICssClassName;

import static com.jwebmp.core.utilities.StaticStrings.*;

/**
 * Power Transforms: Scaling
 * <p>
 * Power Transform scaling effects icon size without changing or moving the container. To scale icons up or down, use grow-# and shrink-# with any
 * arbitrary value, including decimals. Units are 1/16em. For clarity in the example, we’ve added a background color on the icon so you can see the
 * effect.
 * <p>
 * Power Transforms: Positioning
 * <p>
 * Power Transform positioning effects icon location without changing or moving the container. To move icons up, down, left, or right, use up-#,
 * down-#, left-#, and right-# with any arbitrary value, including decimals. Units are 1/16em. For clarity in the example, we’ve added a background
 * color on the icon so you can see the effect.
 * <p>
 * Power Transforms: Rotating &amp; Flipping
 * <p>
 * Power Transform rotating &amp; flipping effects icon angle and reflection without changing or moving the container. To rotate or flip icons use any
 * combination of rotate-#, flip-v, and flip-h with any arbitrary value. Units are degrees with negative numbers allowed (see fifth icon in the
 * example). For clarity in the example, we’ve added a background color on the icon so you can see the effect.
 */
public enum FontAwesomeTransforms
		implements ICssClassName
{

	Grow_1,
	Grow_2,
	Grow_3,
	Grow_4,
	Grow_5,
	Grow_6,
	Grow_7,
	Grow_8,

	Shrink_1,
	Shrink_2,
	Shrink_3,
	Shrink_4,
	Shrink_5,
	Shrink_6,
	Shrink_7,
	Shrink_8,

	Up_1,
	Up_2,
	Up_3,
	Up_4,
	Up_5,
	Up_6,
	Up_7,
	Up_8,

	Down_1,
	Down_2,
	Down_3,
	Down_4,
	Down_5,
	Down_6,
	Down_7,
	Down_8,

	Left_1,
	Left_2,
	Left_3,
	Left_4,
	Left_5,
	Left_6,
	Left_7,
	Left_8,

	Right_1,
	Right_2,
	Right_3,
	Right_4,
	Right_5,
	Right_6,
	Right_7,
	Right_8,

	Rotate_45,
	Rotate_90,
	Rotate_120,
	Rotate_180,
	Rotate_270,

	Flip_V,
	Flip_H;

	@Override
	public String toString()
	{
		return name().toLowerCase()
		             .replace(CHAR_UNDERSCORE, CHAR_DASH);
	}
}
