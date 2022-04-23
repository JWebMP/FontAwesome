package com.jwebmp.plugins.fontawesome5;

import com.jwebmp.core.base.angular.services.*;
import com.jwebmp.core.base.angular.services.annotations.*;

@NgApp(name = "fontawesome", bootComponent = FontAwesomeKitchenSink.class)
public class FontAwesomeApp extends NGApplication<FontAwesomeApp>
{
	public FontAwesomeApp()
	{
		getOptions().setTitle("FontAwesome Kitchen Sink");
	}
	
}
