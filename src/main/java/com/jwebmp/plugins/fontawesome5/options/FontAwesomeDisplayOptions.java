package com.jwebmp.plugins.fontawesome5.options;

import com.jwebmp.base.interfaces.ICSSClassName;

public enum FontAwesomeDisplayOptions
		implements ICSSClassName
{
	/**
	 * Fixed Width Icons
	 * <p>
	 * Use fa-fw to set icons to the same fixed width. Great to use when varying icon widths would throw off vertical alignment. Especially useful
	 * in things like nav lists &amp; list groups. For clarity in the example, we’ve added a background color on the icon so you can see the fixed width.
	 */
	FixedWidth("fw"),
	/**
	 * Use fa-ul and fa-li to replace default bullets in unordered lists.
	 */
	ListItem("li"),
	/**
	 * Use fa-ul and fa-li to replace default bullets in unordered lists.
	 */
	List("ul"),
	/**
	 * Use the fa-spin class to get any icon to rotate, and use fa-pulse to have it rotate with 8 steps. Works especially well with fa-spinner &amp;
	 * everything in the spinner icons category.
	 */
	Spin("spin"),
	/**
	 * Use the fa-spin class to get any icon to rotate, and use fa-pulse to have it rotate with 8 steps. Works especially well with fa-spinner &amp;
	 * everything in the spinner icons category.
	 */
	Pulse("pulse"),
	/**
	 * Use fa-border and fa-pull-right or fa-pull-left for easy pull quotes or article icons.
	 */
	Border("border"),
	/**
	 * Use fa-border and fa-pull-right or fa-pull-left for easy pull quotes or article icons.
	 */
	PullLeft("pull-left"),
	/**
	 * Use fa-border and fa-pull-right or fa-pull-left for easy pull quotes or article icons.
	 */
	PullRight("pull-right"),
	;

	private String text;

	FontAwesomeDisplayOptions(String text)
	{
		this.text = text;
	}

	@Override
	public String toString()
	{
		return "fa-" + text;
	}
}
