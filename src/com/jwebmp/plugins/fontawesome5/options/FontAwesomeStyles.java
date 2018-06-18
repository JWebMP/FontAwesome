package com.jwebmp.plugins.fontawesome5.options;

import com.jwebmp.base.interfaces.ICSSClassName;

public enum FontAwesomeStyles implements ICSSClassName {
	Solid("fas"),
	Regular("far"),
	Light("fal");
	
	private String text;

	FontAwesomeStyles(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
