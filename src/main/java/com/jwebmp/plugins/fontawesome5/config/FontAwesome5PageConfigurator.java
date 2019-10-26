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

import com.jwebmp.core.Page;
import com.jwebmp.core.base.references.CSSReference;
import com.jwebmp.core.base.references.JavascriptReference;
import com.jwebmp.core.plugins.PluginInformation;
import com.jwebmp.core.services.IPageConfigurator;
import com.guicedee.logger.LogFactory;
import com.jwebmp.plugins.fontawesome5.options.FontAwesomeConfigOptions;

import javax.validation.constraints.NotNull;
import java.util.logging.Level;

/**
 * The page configurator for Font Awesome 5
 *
 * @author GedMarc
 * @since 15 Feb 2017
 */
@SuppressWarnings("unused")
@PluginInformation(pluginName = "Font Awesome 5",
		pluginUniqueName = "font-awesome5",
		pluginDescription = "Font Awesome gives you scalable vector icons that can instantly be customized — size, color, drop shadow, " +
		                    "and" +
		                    " anything that can be done with the power of CSS. ",
		pluginVersion = "5.0.13",
		pluginCategories = "fonts, icons",
		pluginSubtitle = "In a single collection, Font Awesome is a pictographic language of web-related actions. ",
		pluginGitUrl = "https://github.com/GedMarc/JWebMP-FontAwesome5Plugin",
		pluginWikiUrl = "https://github.com/GedMarc/JWebMP-FontAwesome5Plugin/wiki",
		pluginOriginalHomepage = "http://fontawesome.io/",
		pluginDownloadUrl = "https://sourceforge.net/projects/jwebswing/files/plugins/FontAwesomePlugin.jar/download",
		pluginIconUrl = "bower_components/font-awesome/icon.png",
		pluginIconImageUrl = "bower_components/font-awesome/icon.png",
		pluginLastUpdatedDate = "2018/07/04")
public class FontAwesome5PageConfigurator
		implements IPageConfigurator<FontAwesome5PageConfigurator>
{
	/**
	 * Field configOptions
	 */
	private static FontAwesomeConfigOptions configOptions = new FontAwesomeConfigOptions();
	/**
	 * If this configurator is enabled
	 */
	private static boolean enabled = true;
	/**
	 * Field rootReferenceDir
	 */
	private static String rootReferenceDir = "bower_components/font-awesome5/js/";
	/**
	 * Field rootCssReferenceDir
	 */
	private static String rootCssReferenceDir = "bower_components/font-awesome5/css/";
	/**
	 * Field fontAwesomeReferenceType
	 */
	private static FontAwesomeReferenceType fontAwesomeReferenceType = FontAwesomeReferenceType.JS;
	/**
	 * Field includeRegular
	 */
	private static boolean includeRegular;
	/**
	 * Field includeSolid
	 */
	private static boolean includeSolid;
	/**
	 * Field includeSolid
	 */
	private static boolean includeDuotone;
	/**
	 * Field includeLight
	 */
	private static boolean includeLight;
	/**
	 * Field includeBrands
	 */
	private static boolean includeBrands;
	/**
	 * Field includeAll
	 */
	private static boolean includeAll;
	/**
	 * Field includeShim
	 */
	private static boolean includeShim;

	/**
	 * Constructor FontAwesome5PageConfigurator creates a new FontAwesome5PageConfigurator instance.
	 */
	public FontAwesome5PageConfigurator()
	{
		//Nothing Needed
	}

	/**
	 * Method isEnabled returns the enabled of this AngularAnimatedChangePageConfigurator object.
	 * <p>
	 * If this configurator is enabled
	 *
	 * @return the enabled (type boolean) of this AngularAnimatedChangePageConfigurator object.
	 */
	public static boolean isEnabled()
	{
		return FontAwesome5PageConfigurator.enabled;
	}

	/**
	 * Method setEnabled sets the enabled of this AngularAnimatedChangePageConfigurator object.
	 * <p>
	 * If this configurator is enabled
	 *
	 * @param mustEnable
	 * 		the enabled of this AngularAnimatedChangePageConfigurator object.
	 */
	public static void setEnabled(boolean mustEnable)
	{
		FontAwesome5PageConfigurator.enabled = mustEnable;
	}

	/**
	 * Updates the referenced root (from bower_components/fontawesome5) to a reference in resources/META-INF/resources
	 *
	 * @return The reference path to the library. files are reference as fa-regular etc
	 */
	public static String getRootReferenceDir()
	{
		return FontAwesome5PageConfigurator.rootReferenceDir;
	}

	/**
	 * Updates the referenced root (from bower_components/fontawesome5) to a reference in resources/META-INF/resources
	 *
	 * @param rootReferenceDir
	 * 		The reference path to the library. files are reference as fa-regular etc
	 */
	public static void setRootReferenceDir(String rootReferenceDir)
	{
		FontAwesome5PageConfigurator.rootReferenceDir = rootReferenceDir;
	}

	/**
	 * Which rendering engine should it use
	 *
	 * @return The reference type going to use
	 */
	public static FontAwesomeReferenceType getFontAwesomeReferenceType()
	{
		return FontAwesome5PageConfigurator.fontAwesomeReferenceType;
	}

	/**
	 * Which rendering engine to use
	 *
	 * @param fontAwesomeReferenceType
	 * 		The reference type to use
	 */
	public static void setFontAwesomeReferenceType(FontAwesomeReferenceType fontAwesomeReferenceType)
	{
		FontAwesome5PageConfigurator.fontAwesomeReferenceType = fontAwesomeReferenceType;
	}

	/**
	 * Is regular should be included
	 *
	 * @return if regular must be included
	 */
	public static boolean isIncludeRegular()
	{
		return FontAwesome5PageConfigurator.includeRegular;
	}

	/**
	 * If the regular library should be included
	 *
	 * @param includeRegular
	 * 		if regular must be included
	 */
	public static void setIncludeRegular(boolean includeRegular)
	{
		FontAwesome5PageConfigurator.includeRegular = includeRegular;
	}

	/**
	 * If the solid library should be included
	 *
	 * @return if solid must be included
	 */
	public static boolean isIncludeSolid()
	{
		return FontAwesome5PageConfigurator.includeSolid;
	}

	/**
	 * If the solid library should be included
	 *
	 * @param includeSolid
	 * 		if solid must be included
	 */
	public static void setIncludeSolid(boolean includeSolid)
	{
		FontAwesome5PageConfigurator.includeSolid = includeSolid;
	}

	/**
	 * If the light library should be included
	 *
	 * @return if light must be included
	 */
	public static boolean isIncludeLight()
	{
		return FontAwesome5PageConfigurator.includeLight;
	}

	/**
	 * If the light library should be used
	 *
	 * @param includeLight
	 * 		if light must be included
	 */
	public static void setIncludeLight(boolean includeLight)
	{
		FontAwesome5PageConfigurator.includeLight = includeLight;
	}

	/**
	 * If the brands library should be used
	 *
	 * @return if remote must be included
	 */
	public static boolean isIncludeBrands()
	{
		return FontAwesome5PageConfigurator.includeBrands;
	}

	/**
	 * If the brands library should be used
	 *
	 * @param includeBrands
	 * 		if brands must be inlcuded
	 */
	public static void setIncludeBrands(boolean includeBrands)
	{
		FontAwesome5PageConfigurator.includeBrands = includeBrands;
	}

	/**
	 * If all libraries should be included
	 *
	 * @return if all must be included
	 */
	public static boolean isIncludeAll()
	{
		return FontAwesome5PageConfigurator.includeAll;
	}

	/**
	 * If all libraries should be included
	 *
	 * @param includeAll
	 * 		if all must be included
	 */
	public static void setIncludeAll(boolean includeAll)
	{
		FontAwesome5PageConfigurator.includeAll = includeAll;
	}

	/**
	 * If the shim library should be included (Defaults to solid)
	 *
	 * @return if the v4shim library must be included
	 */
	public static boolean isIncludeShim()
	{
		return FontAwesome5PageConfigurator.includeShim;
	}

	/**
	 * If the shim library should be included (Defaults to solid)
	 *
	 * @param includeShim
	 * 		If the v4 shim library must be included
	 */
	public static void setIncludeShim(boolean includeShim)
	{
		FontAwesome5PageConfigurator.includeShim = includeShim;
	}

	/**
	 * Returns the root reference for the css files if in css mode
	 *
	 * @return The root directory for the css references
	 */
	public static String getRootCssReferenceDir()
	{
		return FontAwesome5PageConfigurator.rootCssReferenceDir;
	}

	/**
	 * Sets the css root reference dir for when in css mode
	 *
	 * @param rootCssReferenceDir
	 * 		The root directory for the css references
	 */
	public static void setRootCssReferenceDir(String rootCssReferenceDir)
	{
		FontAwesome5PageConfigurator.rootCssReferenceDir = rootCssReferenceDir;
	}

	/**
	 * Whether or not to include the duotone font awesome set
	 *
	 * @return if it is enabled (false by default)
	 */
	public static boolean isIncludeDuotone()
	{
		return includeDuotone;
	}

	/**
	 * Whether or not to include the duotone set
	 *
	 * @param includeDuotone
	 * 		Sets if duotone should be included
	 */
	public static void setIncludeDuotone(boolean includeDuotone)
	{
		FontAwesome5PageConfigurator.includeDuotone = includeDuotone;
	}

	/**
	 * Method configure ...
	 *
	 * @param page
	 * 		of type Page
	 *
	 * @return Page
	 */
	@NotNull
	@Override
	public Page configure(Page<?> page)
	{
		switch (FontAwesome5PageConfigurator.fontAwesomeReferenceType)
		{
			case WebFontCSS:
			{
				configureWebCSS(page);
				break;
			}
			case JS:
			{
				configureJS(page);
				break;
			}
		}
		return page;
	}

	@Override
	public boolean enabled()
	{
		return FontAwesome5PageConfigurator.enabled;
	}

	private void configureWebCSS(Page<?> page)
	{

		if (FontAwesome5PageConfigurator.includeAll)
		{
			page.addCssReference(new CSSReference("FontAwesome5CSSWebFontsAll", 5.013, FontAwesome5PageConfigurator.rootCssReferenceDir + "all.min.css"));
		}
		else
		{
			page.addCssReference(new CSSReference("FontAwesome5CSSWebFontsCore", 5.013, FontAwesome5PageConfigurator.rootCssReferenceDir + "fontawesome.min.css"));

			if (FontAwesome5PageConfigurator.includeBrands)
			{
				page.addCssReference(new CSSReference("FontAwesome5CSSWebFontzBrands", 5.013, FontAwesome5PageConfigurator.rootCssReferenceDir + "brands.min.css"));
			}
			if (FontAwesome5PageConfigurator.includeLight)
			{
				page.addCssReference(new CSSReference("FontAwesome5CSSWebFontsLight", 5.013, FontAwesome5PageConfigurator.rootCssReferenceDir + "light.min.css"));
			}
			if (FontAwesome5PageConfigurator.includeRegular)
			{
				page.addCssReference(new CSSReference("FontAwesome5CSSWebFontsRegular", 5.013, FontAwesome5PageConfigurator.rootCssReferenceDir + "regular.min.css"));
			}
			if (FontAwesome5PageConfigurator.includeSolid)
			{
				page.addCssReference(new CSSReference("FontAwesome5CSSWebFontsSolid", 5.013, FontAwesome5PageConfigurator.rootCssReferenceDir + "solid.min.css"));
			}
			if (FontAwesome5PageConfigurator.includeDuotone)
			{
				page.addCssReference(new CSSReference("FontAwesome5CSSWebFontsDuotone", 5.013, FontAwesome5PageConfigurator.rootCssReferenceDir + "duotone.min.css"));
			}
			if (FontAwesome5PageConfigurator.includeShim)
			{
				page.addCssReference(new CSSReference("FontAwesome5CSSWebFontsShim", 5.013, FontAwesome5PageConfigurator.rootCssReferenceDir + "v4-shims.min.css"));
			}
		}
	}

	/**
	 * Copy the fontawesome.js loader and whatever icon styles’ .js files you’d like to use into your project’s static assets directory (or where ever you prefer to keep front end assets or vendor stuff). We recommend referencing the fontawesome.js loader last.
	 *https://fontawesome.com/how-to-use/on-the-web/setup/hosting-font-awesome-yourself
	 *
	 */
	private void configureJS(Page<?> page)
	{
		if (FontAwesome5PageConfigurator.includeAll)
		{
			JavascriptReference coreReference = new JavascriptReference("FontAwesome5All", 5.013,
			                                                            FontAwesome5PageConfigurator.rootReferenceDir + "all.min.js").setSortOrder(6)
			                                                                                                                         .setDefer(true);
			configureCoreReference(coreReference);
			page.addJavaScriptReference(coreReference);
		}
		else
		{
			JavascriptReference coreReference = new JavascriptReference("FontAwesome5Core", 5.013,
			                                                            FontAwesome5PageConfigurator.rootReferenceDir + "fontawesome.min.js").setSortOrder(8)
			                                                                                                                                 .setDefer(true);
			configureCoreReference(coreReference);

			page.addJavaScriptReference(coreReference);
			if (FontAwesome5PageConfigurator.includeRegular)
			{
				page.addJavaScriptReference(
						new JavascriptReference("FontAwesome5Regular", 5.013, FontAwesome5PageConfigurator.rootReferenceDir + "regular.min.js").setSortOrder(7)
						                                                                                                                       .setDefer(
								                                                                                                                       true));
			}
			if (FontAwesome5PageConfigurator.includeSolid)
			{
				page.addJavaScriptReference(
						new JavascriptReference("FontAwesome5Solid", 5.013, FontAwesome5PageConfigurator.rootReferenceDir + "solid.min.js").setSortOrder(7)
						                                                                                                                   .setDefer(true));
			}
			if (FontAwesome5PageConfigurator.includeLight)
			{
				page.addJavaScriptReference(
						new JavascriptReference("FontAwesome5Light", 5.013, FontAwesome5PageConfigurator.rootReferenceDir + "light.min.js").setSortOrder(7)
						                                                                                                                   .setDefer(true));
			}
			if (FontAwesome5PageConfigurator.includeBrands)
			{
				page.addJavaScriptReference(
						new JavascriptReference("FontAwesome5Brands", 5.013, FontAwesome5PageConfigurator.rootReferenceDir + "brands.min.js").setSortOrder(7)
						                                                                                                                     .setDefer(true));
			}
			if (FontAwesome5PageConfigurator.includeDuotone)
			{
				page.addJavaScriptReference(
						new JavascriptReference("FontAwesome5DuotonesJS", 5.013, FontAwesome5PageConfigurator.rootReferenceDir + "duotone.min.js").setSortOrder(7)
						                                                                                                                          .setDefer(true));
			}
			if (FontAwesome5PageConfigurator.includeShim)
			{
				page.addJavaScriptReference(
						new JavascriptReference("FontAwesome5ShimsJS", 5.013, FontAwesome5PageConfigurator.rootReferenceDir + "v4-shims.min.js").setSortOrder(7)
						                                                                                                                        .setDefer(true));
			}
		}
	}

	/**
	 * Method configureCoreReference ...
	 *
	 * @param ref
	 * 		of type JavascriptReference
	 */
	private void configureCoreReference(JavascriptReference ref)
	{
			if (FontAwesome5PageConfigurator.getConfigOptions()
			                                .getSearchPseudoElements())
			{
				ref.getAdditionalOptions()
				   .add("data-search-pseudo-elements");
			}
			if (FontAwesome5PageConfigurator.getConfigOptions()
			                                .getAutoReplaceSvg() != null &&
			    FontAwesome5PageConfigurator.getConfigOptions().getAutoReplaceSvg().isEmpty())
			{
				ref.getAdditionalOptions()
				   .add("data-auto-replace-svg");
			}
			else if (FontAwesome5PageConfigurator.getConfigOptions()
			                                .getAutoReplaceSvg() != null &&
			    FontAwesome5PageConfigurator.getConfigOptions().getAutoReplaceSvg().equals("nest"))
			{
				ref.getAdditionalOptions()
				   .add("data-auto-replace-svg=\"nest\"");
			}

			if(!FontAwesome5PageConfigurator.getConfigOptions()
			                                .getAutoAddCss())
			{
				ref.getAdditionalOptions()
				   .add("autoAddCss=\"false\"");
			}
	}

	/**
	 * Returns the configuration options for font awesome at a javascript level
	 *
	 * @return The config options currently set (only search pseudo currently enabled)
	 */
	public static FontAwesomeConfigOptions getConfigOptions()
	{
		if (FontAwesome5PageConfigurator.configOptions == null)
		{
			FontAwesome5PageConfigurator.configOptions = new FontAwesomeConfigOptions();
		}
		return FontAwesome5PageConfigurator.configOptions;
	}
}
