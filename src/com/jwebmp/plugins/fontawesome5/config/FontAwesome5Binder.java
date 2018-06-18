package com.jwebmp.plugins.fontawesome5.config;

import java.util.logging.Level;

import com.jwebmp.guiceinjection.abstractions.GuiceSiteInjectorModule;
import com.jwebmp.guiceinjection.interfaces.GuiceSiteBinder;
import com.jwebmp.logger.LogFactory;

import static com.jwebmp.utilities.StaticStrings.QUERY_PARAMETERS_REGEX;

@SuppressWarnings("unused")
public class FontAwesome5Binder extends GuiceSiteBinder {
	private static final java.util.logging.Logger log = LogFactory.getLog("FontAwesome5Binder");

	private static final String FontAwesome5SiteBinding = "/fontawesome5configservlet";
	
	@Override
	public void onBind(GuiceSiteInjectorModule guiceSiteInjectorModule) {
		guiceSiteInjectorModule.serveRegex$("(" + FontAwesome5SiteBinding + ")" + QUERY_PARAMETERS_REGEX)
			.with(FontAwesome5ConfigServlet.class);
		log.log(Level.INFO, "Serving Font Awesome 5 Configuration at {0}", FontAwesome5SiteBinding);
	}

	public static String getFontAwesome5SiteBinding() {
		return FontAwesome5SiteBinding;
	}
}
