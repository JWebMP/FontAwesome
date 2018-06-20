package com.jwebmp.plugins.fontawesome5.config;

import com.jwebmp.guiceinjection.abstractions.GuiceSiteInjectorModule;
import com.jwebmp.guiceinjection.interfaces.GuiceSiteBinder;
import com.jwebmp.logger.LogFactory;

import java.util.logging.Level;

import static com.jwebmp.utilities.StaticStrings.*;

@SuppressWarnings("unused")
public class FontAwesome5Binder
		extends GuiceSiteBinder
{
	private static final java.util.logging.Logger log = LogFactory.getLog("FontAwesome5Binder");

	private static final String FontAwesome5SiteBinding = "/fontawesome5configservlet";

	public static String getFontAwesome5SiteBinding()
	{
		return FontAwesome5SiteBinding;
	}

	@Override
	public void onBind(GuiceSiteInjectorModule guiceSiteInjectorModule)
	{
		guiceSiteInjectorModule.serveRegex$("(" + FontAwesome5SiteBinding + ")" + QUERY_PARAMETERS_REGEX)
		                       .with(FontAwesome5ConfigServlet.class);
		log.log(Level.INFO, "Serving Font Awesome 5 Configuration at {0}", FontAwesome5SiteBinding);
	}
}
