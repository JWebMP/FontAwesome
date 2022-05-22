package com.jwebmp.plugins.fontawesome5;

import com.jwebmp.core.base.interfaces.ICssClassName;

import java.io.Serializable;
import java.util.regex.*;

public interface IFontAwesomeIcon
		extends ICssClassName
{
	String name();
	
	default String toAngularIcon()
	{
		String str = name();
		str = Pattern.compile("_([a-z])")
		             .matcher(str)
		             .replaceAll(m -> m.group(1).toUpperCase());
		
		str = str.substring(0, 1)
		         .toUpperCase() + str.substring(1);
		
		return "fa" + str;
	}
	
	
	default String toAngularIconAttributeName()
	{
		String str = name();
		str = str.replace('_', '-');
		return str;
	}
}
