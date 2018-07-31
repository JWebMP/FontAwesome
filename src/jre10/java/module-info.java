import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.guicedservlets.services.IGuiceSiteBinder;
import com.jwebmp.plugins.fontawesome5.config.FontAwesome5BinderIGuiceSiteBinder;
import com.jwebmp.plugins.fontawesome5.config.FontAwesome5PageConfigurator;

module com.jwebmp.plugins.fontawesome5 {
	exports com.jwebmp.plugins.fontawesome5;
	exports com.jwebmp.plugins.fontawesome5.config;
	exports com.jwebmp.plugins.fontawesome5.icons;
	exports com.jwebmp.plugins.fontawesome5.options;

	requires com.jwebmp.core;
	requires com.jwebmp.logmaster;
	requires com.fasterxml.jackson.annotation;

	requires java.validation;
	requires java.logging;
	requires commons.lang3;
	requires com.jwebmp.guicedservlets;

	provides IGuiceSiteBinder with FontAwesome5BinderIGuiceSiteBinder;
	provides IPageConfigurator with FontAwesome5PageConfigurator;

	opens com.jwebmp.plugins.fontawesome5.options to com.fasterxml.jackson.databind,com.google.guice, com.jwebmp.core;
	opens com.jwebmp.plugins.fontawesome5 to com.fasterxml.jackson.databind,com.google.guice, com.jwebmp.core;
	opens com.jwebmp.plugins.fontawesome5.icons to com.fasterxml.jackson.databind,com.google.guice, com.jwebmp.core;

}
