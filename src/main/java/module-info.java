import com.guicedee.client.services.config.IGuiceScanModuleInclusions;
import com.jwebmp.plugins.fontawesome5.implementations.FA5InclusionModule;

module com.jwebmp.plugins.fontawesome5 {
    exports com.jwebmp.plugins.fontawesome5;
    exports com.jwebmp.plugins.fontawesome5.config;
    exports com.jwebmp.plugins.fontawesome5.icons;
    exports com.jwebmp.plugins.fontawesome5.options;

    requires transitive com.jwebmp.core.base.angular.client;
    requires static com.jwebmp.core.angular;
    requires transitive com.jwebmp.core;


    provides com.jwebmp.core.services.IPageConfigurator with com.jwebmp.plugins.fontawesome5.config.FontAwesome5PageConfigurator;

    provides IGuiceScanModuleInclusions with FA5InclusionModule;

    opens com.jwebmp.plugins.fontawesome5.options to tools.jackson.databind, com.google.guice, com.jwebmp.core, com.jwebmp.core.angular;
    opens com.jwebmp.plugins.fontawesome5 to tools.jackson.databind, com.google.guice, com.jwebmp.core, com.jwebmp.core.angular;
    opens com.jwebmp.plugins.fontawesome5.icons to tools.jackson.databind, com.google.guice, com.jwebmp.core, com.jwebmp.core.angular;
    opens com.jwebmp.plugins.fontawesome5.implementations to tools.jackson.databind, com.google.guice, com.jwebmp.core, com.jwebmp.core.angular;

}
