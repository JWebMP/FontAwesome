package com.jwebmp.plugins.fontawesome5.options;

import com.jwebmp.core.base.interfaces.*;

import static com.guicedee.guicedinjection.json.StaticStrings.*;

public enum FontAwesomeSizes
		implements ICssClassName
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
		return name().replaceAll(STRING_DOLLAR_ESCAPED, STRING_EMPTY)
		             .toLowerCase();
	}
}
