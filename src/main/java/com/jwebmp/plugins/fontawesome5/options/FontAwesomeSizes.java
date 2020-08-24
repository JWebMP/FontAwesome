package com.jwebmp.plugins.fontawesome5.options;

import com.guicedee.guicedinjection.json.StaticStrings;
import com.jwebmp.core.base.interfaces.ICssClassName;

import static com.guicedee.guicedinjection.json.StaticStrings.STRING_DOLLAR_ESCAPED;
import static com.guicedee.guicedinjection.json.StaticStrings.STRING_EMPTY;
import static com.jwebmp.core.utilities.StaticStrings.*;

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
		return "fa-" + name().replaceAll(STRING_DOLLAR_ESCAPED, STRING_EMPTY)
		                     .toLowerCase();
	}
}
