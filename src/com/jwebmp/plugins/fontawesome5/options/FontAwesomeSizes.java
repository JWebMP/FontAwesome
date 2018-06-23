package com.jwebmp.plugins.fontawesome5.options;

import com.jwebmp.base.interfaces.ICSSClassName;

import static com.jwebmp.utilities.StaticStrings.*;

public enum FontAwesomeSizes
		implements ICSSClassName
{
	Xs,
	Sm,
	Lg,
	$2x,
	$3x,
	$4x,
	$5x,
	$6x,
	$7x,
	$8x,
	$9x,
	$10x;

	@Override
	public String toString()
	{
		return "fa-" + name().replaceAll("\\$", STRING_EMPTY)
		                     .toLowerCase();
	}
}
