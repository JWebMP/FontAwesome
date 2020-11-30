package com.jwebmp.plugins.fontawesome5;

import com.jwebmp.core.Feature;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.interfaces.ICssClassName;

public class FontAwesomeSwapOnClick
		extends Feature
{
	private ICssClassName icon1;
	private ICssClassName icon2;

	public FontAwesomeSwapOnClick(ComponentHierarchyBase component, ICssClassName icon1, ICssClassName icon2)
	{
		super("FontAwesomeSwapOnClick", component);
		this.icon1 = icon1;
		this.icon2 = icon2;
	}

	@Override
	protected void assignFunctionsToComponent()
	{
		String feature = "$('" + getComponent().getID(true) + "').on('click', function () {" + getNewLine() +
		        "$(this)" + getNewLine() +
				"\t.find('[data-fa-i2svg]')" + getNewLine() +
				"\t.toggleClass('" + icon1.toString() + "')" + getNewLine() +
				"\t.toggleClass('" + icon2.toString() + "');" + getNewLine() +
				"});";
		addQuery(feature);

	}
}
