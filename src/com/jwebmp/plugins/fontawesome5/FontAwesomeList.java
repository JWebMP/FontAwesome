package com.jwebmp.plugins.fontawesome5;

import com.jwebmp.base.html.List;
import com.jwebmp.base.html.ListItem;
import com.jwebmp.base.html.Span;
import com.jwebmp.base.html.interfaces.GlobalChildren;
import com.jwebmp.plugins.fontawesome5.options.FontAwesomeDisplayOptions;

public class FontAwesomeList extends List {

	public FontAwesomeList() {
		this(false);
	}

	public FontAwesomeList(boolean orderedList) {
		super(orderedList);
		addClass(FontAwesomeDisplayOptions.List);
	}
	
	public ListItem<?> addItem(String textToAdd,FontAwesome<?> icon) {
		ListItem<?> li = new ListItem<>();
		Span<GlobalChildren,?,?> span = new Span<>();
		span.addClass(FontAwesomeDisplayOptions.ListItem);
		span.add(icon);
		li.add(span);
		li.setRenderTextBeforeChildren(false);
		li.setText(textToAdd);
		return li;
	}
}
