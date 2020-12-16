package com.jwebmp.plugins.fontawesome5;

import com.jwebmp.core.Feature;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.interfaces.ICssClassName;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

public class FontAwesomeSwapOnClick
		extends Feature<GlobalFeatures, JavaScriptPart<?>, FontAwesomeSwapOnClick>
{
	private final ICssClassName icon1;
	private final ICssClassName icon2;
	
	public FontAwesomeSwapOnClick(ComponentHierarchyBase component, ICssClassName icon1, ICssClassName icon2)
	{
		super("FontAwesomeSwapOnClick", component);
		this.icon1 = icon1;
		this.icon2 = icon2;
	}
	
	@Override
	protected void assignFunctionsToComponent()
	{
		String feature = "$('" + getComponent().asBase()
		                                       .getID(true) + "').on('click', function () {" + getNewLine() +
				"$(this)" + getNewLine() +
				"\t.find('[data-fa-i2svg]')" + getNewLine() +
				"\t.toggleClass('" + icon1.toString() + "')" + getNewLine() +
				"\t.toggleClass('" + icon2.toString() + "');" + getNewLine() +
				"});";
		addQuery(feature);
		
	}
}
