package com.jwebmp.plugins.fontawesome5.config;

import com.google.inject.Singleton;
import com.jwebmp.core.base.servlets.JWDefaultServlet;
import com.jwebmp.logger.LogFactory;
import com.jwebmp.plugins.fontawesome5.options.FontAwesomeConfigOptions;

import java.util.logging.Logger;

import static com.jwebmp.core.utilities.StaticStrings.*;

@Singleton
public class FontAwesome5ConfigServlet
		extends JWDefaultServlet
{

	private static final Logger log = LogFactory.getInstance()
	                                            .getLogger("FontAwesome5ConfiguratorServlet");
	private static final long serialVersionUID = 1L;
	private static final String SetString = "window.FontAwesomeConfig = ";

	@Override
	public void perform()
	{
		FontAwesomeConfigOptions<?> configOptions = FontAwesome5PageConfigurator.getConfigOptions();
		String config = configOptions.toString(true);
		if (!config.replace("\\{", STRING_EMPTY)
		           .replace("\\}", STRING_EMPTY)
		           .trim()
		           .isEmpty())
		{
			writeOutput(new StringBuilder(SetString + config), HTML_HEADER_JAVASCRIPT, UTF8_CHARSET);
		}
	}

}
