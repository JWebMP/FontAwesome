/*
 * Copyright (C) 2017 GedMarc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jwebmp.plugins.fontawesome5.config;

import com.jwebmp.core.*;
import com.jwebmp.core.base.angular.client.annotations.boot.*;
import com.jwebmp.core.base.angular.client.annotations.typescript.*;
import com.jwebmp.core.plugins.*;
import com.jwebmp.core.services.*;
import com.jwebmp.plugins.fontawesome5.options.*;
import jakarta.validation.constraints.*;

import java.util.*;

/**
 * The page configurator for Font Awesome 5
 *
 * @author GedMarc
 * @since 15 Feb 2017
 */
@SuppressWarnings("unused")
@PluginInformation(pluginName = "Font Awesome",
                   pluginUniqueName = "font-awesome",
                   pluginDescription = "Font Awesome gives you scalable vector icons that can instantly be customized — size, color, drop shadow, " +
                                       "and" +
                                       " anything that can be done with the power of CSS. ",
                   pluginVersion = "5.15.1",
                   pluginCategories = "fonts, icons",
                   pluginSubtitle = "In a single collection, Font Awesome is a pictographic language of web-related actions. ",
                   pluginGitUrl = "https://github.com/GedMarc/JWebMP-FontAwesome5Plugin",
                   pluginWikiUrl = "https://github.com/GedMarc/JWebMP-FontAwesome5Plugin/wiki",
                   pluginOriginalHomepage = "http://fontawesome.io/",
                   pluginDownloadUrl = "https://mvnrepository.com/artifact/com.jwebmp.plugins.iconsets/jwebmp-font-awesome5",
                   pluginIconUrl = "",
                   pluginIconImageUrl = "",
                   pluginLastUpdatedDate = "2020/11/24",
                   pluginGroupId = "com.jwebmp.plugins.iconsets",
                   pluginArtifactId = "jwebmp-font-awesome5",
                   pluginModuleName = "com.jwebmp.plugins.fontawesome5",
                   pluginStatus = PluginStatus.Released
)


@TsDependency(value = "@fortawesome/fontawesome-svg-core", version = "^6.0.0")
@TsDependency(value = "@fortawesome/free-solid-svg-icons", version = "^6.0.0", name = "fontawesome-svg-solid")
@TsDependency(value = "@fortawesome/free-brands-svg-icons", version = "^6.0.0", name = "fontawesome-svg-brands")
@TsDependency(value = "@fortawesome/angular-fontawesome", version = "^0.10.0", name = "fontawesome-angular")


@NgBootImportReference(name = "FontAwesomeModule, FaIconLibrary, FaConfig", reference = "@fortawesome/angular-fontawesome")

//@NgBootImportReference(name = "fas", reference = "@fortawesome/free-solid-svg-icons")
//@NgBootImportReference(name = "fab", reference = "@fortawesome/free-brands-svg-icons")

@NgBootConstructorParameter("library: FaIconLibrary")
@NgBootConstructorParameter("faConfig: FaConfig")

//@NgBootConstructorBody("library.addIconPacks(fas);")
//@NgBootConstructorBody("library.addIconPacks(fab);")

@NgBootModuleImport("FontAwesomeModule")

public class FontAwesome5PageConfigurator
		implements IPageConfigurator<FontAwesome5PageConfigurator>
{
	/**
	 * Field configOptions
	 */
	private static FontAwesomeConfigOptions<?> configOptions = new FontAwesomeConfigOptions<>();
	
	public static Map<FontAwesomeStyles, String> tsDependencies = new HashMap<>();
	static {
		tsDependencies.putIfAbsent(FontAwesomeStyles.Solid,"@fortawesome/free-solid-svg-icons");
		tsDependencies.putIfAbsent(FontAwesomeStyles.Brand,"@fortawesome/free-brands-svg-icons");
	}
	
	/**
	 * Constructor FontAwesome5PageConfigurator creates a new FontAwesome5PageConfigurator instance.
	 */
	public FontAwesome5PageConfigurator()
	{
		//Nothing Needed
	}
	
	/**
	 * Method configure ...
	 *
	 * @param page of type Page
	 * @return Page
	 */
	@NotNull
	@Override
	public Page<?> configure(Page<?> page)
	{
		return page;
	}
	
	@Override
	public boolean enabled()
	{
		return true;
	}
	
	/**
	 * Returns the configuration options for font awesome at a javascript level
	 *
	 * @return The config options currently set (only search pseudo currently enabled)
	 */
	public static FontAwesomeConfigOptions<?> getConfigOptions()
	{
		if (FontAwesome5PageConfigurator.configOptions == null)
		{
			FontAwesome5PageConfigurator.configOptions = new FontAwesomeConfigOptions<>();
		}
		return FontAwesome5PageConfigurator.configOptions;
	}
}
