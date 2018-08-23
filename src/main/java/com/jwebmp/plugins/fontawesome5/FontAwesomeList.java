package com.jwebmp.plugins.fontawesome5;

import com.jwebmp.core.base.html.List;
import com.jwebmp.core.base.html.ListItem;
import com.jwebmp.core.base.html.Span;
import com.jwebmp.core.base.html.interfaces.AttributeDefinitions;
import com.jwebmp.core.base.html.interfaces.children.ListChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.plugins.fontawesome5.options.FontAwesomeDisplayOptions;

/**
 * A List styled with Font Awesome Icons
 */
public class FontAwesomeList<J extends FontAwesomeList<J, A, E>, A extends Enum & AttributeDefinitions, E extends GlobalEvents>
		extends List<ListChildren, A, E, J>
{

	public FontAwesomeList()
	{
		this(false);
	}

	public FontAwesomeList(boolean orderedList)
	{
		super(orderedList);
		addClass(FontAwesomeDisplayOptions.List);
		addStyle("margin-bottom:0px;");
	}

	public ListItem<?> addItem(String textToAdd, FontAwesome<?> icon)
	{
		ListItem<?> li = new ListItem<>();
		Span<IComponentHierarchyBase, ?, ?> span = new Span<>();
		span.addClass(FontAwesomeDisplayOptions.ListItem);
		span.add(icon);
		li.add(span);
		li.setRenderTextBeforeChildren(false);
		li.setText(textToAdd);
		add(li);
		return li;
	}
}
