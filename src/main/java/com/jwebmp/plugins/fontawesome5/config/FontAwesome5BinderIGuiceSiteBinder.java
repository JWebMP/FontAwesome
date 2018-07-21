package com.jwebmp.plugins.fontawesome5.config;

import com.jwebmp.guicedservlets.GuiceSiteInjectorModule;
import com.jwebmp.guicedservlets.services.IGuiceSiteBinder;
import com.jwebmp.logger.LogFactory;

import java.util.logging.Level;

import static com.jwebmp.core.utilities.StaticStrings.*;

@SuppressWarnings("unused")
public class FontAwesome5BinderIGuiceSiteBinder
		implements IGuiceSiteBinder<GuiceSiteInjectorModule>
{
	private static final java.util.logging.Logger log = LogFactory.getLog("FontAwesome5BinderIGuiceSiteBinder");

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
		log.log(Level.CONFIG, "Serving Font Awesome 5 Configuration at {0}", FontAwesome5SiteBinding);
	}
}
