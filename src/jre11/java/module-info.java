import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.guicedinjection.interfaces.IGuiceScanJarExclusions;
import com.jwebmp.guicedinjection.interfaces.IGuiceScanModuleExclusions;
import com.jwebmp.plugins.fontawesome5.config.FontAwesome5PageConfigurator;
import com.jwebmp.plugins.fontawesome5.implementations.FontAwesome5ExclusionsModule;

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

	requires com.jwebmp.guicedservlets;
	requires org.apache.commons.lang3;
	requires com.jwebmp.guicedinjection;

	provides IPageConfigurator with FontAwesome5PageConfigurator;

	provides IGuiceScanModuleExclusions with FontAwesome5ExclusionsModule;
	provides IGuiceScanJarExclusions with FontAwesome5ExclusionsModule;

	opens com.jwebmp.plugins.fontawesome5.options to com.fasterxml.jackson.databind, com.google.guice, com.jwebmp.core;
	opens com.jwebmp.plugins.fontawesome5 to com.fasterxml.jackson.databind, com.google.guice, com.jwebmp.core;
	opens com.jwebmp.plugins.fontawesome5.icons to com.fasterxml.jackson.databind, com.google.guice, com.jwebmp.core;

}