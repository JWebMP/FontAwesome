package com.jwebmp.plugins.fontawesome5.options;

import com.jwebmp.core.base.interfaces.ICssClassName;

public enum FontAwesomeStyles
		implements ICssClassName
{
	Brand("fab"),
	Solid("fas"),
	/**
	 * The duo tone is set for pro only
	 * Configure with FontAwesomePageConfigurator
	 */
	Duotone("fad"),
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
