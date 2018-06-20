/*
 * Copyright (C) 2017 Marc Magon
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

import com.jwebmp.Page;
import com.jwebmp.PageConfigurator;
import com.jwebmp.base.references.CSSReference;
import com.jwebmp.base.references.JavascriptReference;
import com.jwebmp.plugins.PluginInformation;
import com.jwebmp.plugins.fontawesome5.options.FontAwesomeConfigOptions;

/**
 * @author GedMarc
 * @since 15 Feb 2017
 */
@PluginInformation(pluginName = "Font Awesome 5",
		pluginUniqueName = "font-awesome5",
		pluginDescription = "Font Awesome gives you scalable vector icons that can instantly be customized — size, color, drop shadow, " + "and" + " anything that can be done with the power of CSS. ",
		pluginVersion = "5.0.13",
		pluginDependancyUniqueIDs = "",
		pluginCategories = "fonts, icons",
		pluginSubtitle = "In a single collection, Font Awesome is a pictographic language of web-related actions. ",
		pluginGitUrl = "https://github.com/GedMarc/JWebSwing-FontAwesomePlugin",
		pluginSourceUrl = "",
		pluginWikiUrl = "https://github.com/GedMarc/JWebSwing-FontAwesomePlugin/wiki",
		pluginOriginalHomepage = "http://fontawesome.io/",
		pluginDownloadUrl = "https://sourceforge.net/projects/jwebswing/files/plugins/FontAwesomePlugin.jar/download",
		pluginIconUrl = "bower_components/font-awesome/icon.png",
		pluginIconImageUrl = "bower_components/font-awesome/icon.png",
		pluginLastUpdatedDate = "2017/03/04")
public class FontAwesomePageConfigurator
		extends PageConfigurator
{

	private static final long serialVersionUID = 1L;
	private static final FontAwesomeConfigOptions configOptions = new FontAwesomeConfigOptions();
	private static String rootReferenceDir = "bower-components/font-awesome5/";
	private static FontAwesomeReferenceType fontAwesomeReferenceType = FontAwesomeReferenceType.JS;
	private static boolean includeRegular;
	private static boolean includeSolid;
	private static boolean includeLight;
	private static boolean includeBrands;
	private static boolean includeAll;

	private static boolean includeShim;

	public FontAwesomePageConfigurator()
	{
		//Nothing Needed
	}

	/**
	 * Updates the referenced root (from bower_components/fontawesome5) to a reference in resources/META-INF/resources
	 *
	 * @return
	 */
	public static String getRootReferenceDir()
	{
		return rootReferenceDir;
	}

	/**
	 * Updates the referenced root (from bower_components/fontawesome5) to a reference in resources/META-INF/resources
	 *
	 * @param rootReferenceDir
	 */
	public static void setRootReferenceDir(String rootReferenceDir)
	{
		FontAwesomePageConfigurator.rootReferenceDir = rootReferenceDir;
	}

	/**
	 * Which rendering engine should it use
	 *
	 * @return
	 */
	public static FontAwesomeReferenceType getFontAwesomeReferenceType()
	{
		return fontAwesomeReferenceType;
	}

	/**
	 * Which rendering engine to use
	 *
	 * @param fontAwesomeReferenceType
	 */
	public static void setFontAwesomeReferenceType(FontAwesomeReferenceType fontAwesomeReferenceType)
	{
		FontAwesomePageConfigurator.fontAwesomeReferenceType = fontAwesomeReferenceType;
	}

	/**
	 * Returns the configuration options for font awesome at a javascript level
	 *
	 * @return
	 */
	public static FontAwesomeConfigOptions getConfigOptions()
	{
		return configOptions;
	}

	/**
	 * Is regular should be included
	 *
	 * @return
	 */
	public static boolean isIncludeRegular()
	{
		return includeRegular;
	}

	/**
	 * If the regular library should be included
	 *
	 * @param includeRegular
	 */
	public static void setIncludeRegular(boolean includeRegular)
	{
		FontAwesomePageConfigurator.includeRegular = includeRegular;
	}

	/**
	 * If the solid library should be included
	 *
	 * @return
	 */
	public static boolean isIncludeSolid()
	{
		return includeSolid;
	}

	/**
	 * If the solid library should be included
	 *
	 * @param includeSolid
	 */
	public static void setIncludeSolid(boolean includeSolid)
	{
		FontAwesomePageConfigurator.includeSolid = includeSolid;
	}

	/**
	 * If the light library should be included
	 *
	 * @return
	 */
	public static boolean isIncludeLight()
	{
		return includeLight;
	}

	/**
	 * If the light library should be used
	 *
	 * @param includeLight
	 */
	public static void setIncludeLight(boolean includeLight)
	{
		FontAwesomePageConfigurator.includeLight = includeLight;
	}

	/**
	 * If the brands library should be used
	 *
	 * @return
	 */
	public static boolean isIncludeBrands()
	{
		return includeBrands;
	}

	/**
	 * If the brands library should be used
	 *
	 * @param includeBrands
	 */
	public static void setIncludeBrands(boolean includeBrands)
	{
		FontAwesomePageConfigurator.includeBrands = includeBrands;
	}

	/**
	 * If all libraries should be included
	 *
	 * @return
	 */
	public static boolean isIncludeAll()
	{
		return includeAll;
	}

	/**
	 * If all libraries should be included
	 *
	 * @param includeAll
	 */
	public static void setIncludeAll(boolean includeAll)
	{
		FontAwesomePageConfigurator.includeAll = includeAll;
	}

	/**
	 * If the shim library should be included (Defaults to solid)
	 *
	 * @return
	 */
	public static boolean isIncludeShim()
	{
		return includeShim;
	}

	/**
	 * If the shim library should be included (Defaults to solid)
	 *
	 * @param includeShim
	 */
	public static void setIncludeShim(boolean includeShim)
	{
		FontAwesomePageConfigurator.includeShim = includeShim;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Page configure(Page page)
	{

		if (!page.isConfigured())
		{

			switch (fontAwesomeReferenceType)
			{
				case WebFontCSS:
				{

					if (includeAll)
					{
						page.addCssReference(new CSSReference("FontAwesome5CSSWebFontsAll", 5.013, rootReferenceDir + "web-fonts-with-css/css/fontawesome-all.min.css"));
					}
					else
					{
						if (includeBrands)
						{
							page.addCssReference(new CSSReference("FontAwesome5CSSWebFontsBrands", 5.013, rootReferenceDir + "web-fonts-with-css/css/fa-brands.min.css"));
						}
						if (includeLight)
						{
							page.addCssReference(new CSSReference("FontAwesome5CSSWebFontsLight", 5.013, rootReferenceDir + "web-fonts-with-css/css/fa-light.min.css"));
						}
						if (includeRegular)
						{
							page.addCssReference(new CSSReference("FontAwesome5CSSWebFontsRegular", 5.013, rootReferenceDir + "web-fonts-with-css/css/fa-regular.min.css"));
						}
						if (includeSolid)
						{
							page.addCssReference(new CSSReference("FontAwesome5CSSWebFontsSolid", 5.013, rootReferenceDir + "web-fonts-with-css/css/fa-solid.min.css"));
						}
					}

					break;
				}
				case JS:
				{
					if (!configOptions.toString(true)
					                  .replace("\\{", "")
					                  .replace("\\}", "")
					                  .trim()
					                  .isEmpty())
					{
						page.addJavaScriptReference(new JavascriptReference("FontAwesome5Configuration", 1.0, FontAwesome5Binder.getFontAwesome5SiteBinding()
						                                                                                                        .replace("/", "")).setSortOrder(5));
					}

					if (includeAll)
					{
						page.addJavaScriptReference(new JavascriptReference("FontAwesome5All", 5.013, rootReferenceDir + "svg-with-js/js/fontawesome-all.min.js").setSortOrder(6)
						                                                                                                                                         .setDefer(true));
					}
					else
					{
						page.addJavaScriptReference(new JavascriptReference("FontAwesome5Core", 5.013, rootReferenceDir + "svg-with-js/js/fontawesome.min.js").setSortOrder(8)
						                                                                                                                                      .setDefer(true));
						if (includeRegular)
						{
							page.addJavaScriptReference(new JavascriptReference("FontAwesome5Regular", 5.013, rootReferenceDir + "svg-with-js/js/fa-regular.min.js").setSortOrder(7)
							                                                                                                                                        .setDefer(
									                                                                                                                                        true));
						}
						if (includeSolid)
						{
							page.addJavaScriptReference(new JavascriptReference("FontAwesome5Solid", 5.013, rootReferenceDir + "svg-with-js/js/fa-solid.min.js").setSortOrder(7)
							                                                                                                                                    .setDefer(true));
						}
						if (includeLight)
						{
							page.addJavaScriptReference(new JavascriptReference("FontAwesome5Light", 5.013, rootReferenceDir + "svg-with-js/js/fa-light.min.js").setSortOrder(7)
							                                                                                                                                    .setDefer(true));
						}
						if (includeBrands)
						{
							page.addJavaScriptReference(new JavascriptReference("FontAwesome5Brands", 5.013, rootReferenceDir + "svg-with-js/js/fa-brands.min.js").setSortOrder(7)
							                                                                                                                                      .setDefer(true));
						}
					}

					break;
				}
			}
		}
		return page;

	}
}
