package com.jwebmp.plugins.fontawesome5.options;

import com.jwebmp.core.base.interfaces.ICSSClassName;

public enum FontAwesomeStyles
		implements ICSSClassName
{
	Brand("fab"),
	Solid("fas"),
	Regular("far"),
	Light("fal");

	private String text;

	FontAwesomeStyles(String text)
	{
		this.text = text;
	}

	@Override
	public String toString()
	{
		return text;
	}
}
