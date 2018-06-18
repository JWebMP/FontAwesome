package com.jwebmp.plugins.fontawesome5.config;

import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Singleton;
import com.jwebmp.base.servlets.JWDefaultServlet;
import com.jwebmp.logger.LogFactory;
import com.jwebmp.plugins.fontawesome5.options.FontAwesomeConfigOptions;
import com.jwebmp.utilities.StaticStrings;

@Singleton
public class FontAwesome5ConfigServlet extends JWDefaultServlet {

	private static final Logger log = LogFactory.getInstance()
		.getLogger("FontAwesome5ConfiguratorServlet");
	private static final long serialVersionUID = 1L;
	private static final String SetString = "window.FontAwesomeConfig = ";

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/javascript");
		FontAwesomeConfigOptions<?> configOptions = FontAwesomePageConfigurator.getConfigOptions();
		String config = configOptions.toString(true);
		if (!config.replace("\\{", "").replace("\\}", "").trim().isEmpty()) {
			writeOutput(new StringBuilder(SetString + config), StaticStrings.HTML_HEADER_JAVASCRIPT, Charset.forName("UTF-8"));
		}
	}

	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request  Servlet request
	 * @param response Servlet response
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		super.doGet(request, response);
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request  Servlet request
	 * @param response Servlet response
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			doGet(request, response);
		}
		catch (Exception ex) {
			log.log(Level.SEVERE, null, ex);
		}
	}

}
