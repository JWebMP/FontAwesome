import com.jwebmp.core.databind.IOnComponentAdded;
import com.jwebmp.plugins.fontawesome5.implementations.FA5InclusionModule;

module com.jwebmp.plugins.fontawesome5 {
    exports com.jwebmp.plugins.fontawesome5;
    exports com.jwebmp.plugins.fontawesome5.config;
    exports com.jwebmp.plugins.fontawesome5.icons;
    exports com.jwebmp.plugins.fontawesome5.options;

    requires transitive com.jwebmp.core.base.angular.client;
    requires com.jwebmp.core.angular;
    requires com.jwebmp.client;
    requires com.jwebmp.core;

    requires org.apache.commons.lang3;
    requires com.guicedee.jsonrepresentation;

    provides com.jwebmp.core.services.IPageConfigurator with com.jwebmp.plugins.fontawesome5.config.FontAwesome5PageConfigurator;

    provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions with FA5InclusionModule;

    opens com.jwebmp.plugins.fontawesome5.options to com.fasterxml.jackson.databind, com.google.guice, com.jwebmp.core, com.jwebmp.core.angular;
    opens com.jwebmp.plugins.fontawesome5 to com.fasterxml.jackson.databind, com.google.guice, com.jwebmp.core, com.jwebmp.core.angular;
    opens com.jwebmp.plugins.fontawesome5.icons to com.fasterxml.jackson.databind, com.google.guice, com.jwebmp.core, com.jwebmp.core.angular;
    opens com.jwebmp.plugins.fontawesome5.implementations to com.fasterxml.jackson.databind, com.google.guice, com.jwebmp.core, com.jwebmp.core.angular;

}
