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

import com.google.common.base.Strings;
import com.jwebmp.core.base.angular.client.annotations.boot.NgBootModuleImport;
import com.jwebmp.core.base.angular.client.services.interfaces.AnnotationUtils;
import com.jwebmp.core.plugins.PluginInformation;
import com.jwebmp.core.plugins.PluginStatus;
import com.jwebmp.core.services.IPage;
import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.plugins.fontawesome5.options.FontAwesomeConfigOptions;
import com.jwebmp.plugins.fontawesome5.options.FontAwesomeStyles;
import com.jwebmp.plugins.fontawesome5.options.IconFamily;
import jakarta.validation.constraints.NotNull;

import java.util.*;

/**
 * Page configurator for Font Awesome (free).
 * <p>
 * When no Kit code is configured, the free SVG icon packages ({@code free-solid-svg-icons},
 * {@code free-brands-svg-icons}) and the Angular integration packages ({@code fontawesome-svg-core},
 * {@code angular-fontawesome}) are added as npm dependencies based on enabled families.
 * <p>
 * When a Kit code IS configured (via {@link #setKitCode(String)}), no npm icon packages are
 * added — the Kit script fetches all icons from the cloud.
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
        pluginVersion = "7.2.0",
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
@NgBootModuleImport("FontAwesomeModule")
public class FontAwesome5PageConfigurator
        implements IPageConfigurator<FontAwesome5PageConfigurator>
{
    private static final String FA_VERSION = "^7.2.0";

    /**
     * Field configOptions
     */
    private static FontAwesomeConfigOptions<?> configOptions = new FontAwesomeConfigOptions<>();

    /**
     * Maps FontAwesomeStyles to their npm package names.
     * Used by {@link com.jwebmp.plugins.fontawesome5.FontAwesome} to generate correct Angular import references.
     */
    public static final Map<FontAwesomeStyles, String> tsDependencies = new HashMap<>();

    static
    {
        tsDependencies.put(FontAwesomeStyles.Classic, "@fortawesome/free-solid-svg-icons");
        tsDependencies.put(FontAwesomeStyles.Brand, "@fortawesome/free-brands-svg-icons");
    }

    /**
     * Enabled free icon families. Only enabled families will have their npm packages added.
     * Defaults to Classic and Brands for backward compatibility.
     */
    private static final Set<IconFamily> enabledFamilies = new LinkedHashSet<>();

    /**
     * Kit code shared between free and pro configurators.
     * When set, no npm icon packages are added — the Kit script handles everything.
     */
    private static String kitCode = "";

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
    public IPage<?> configure(IPage<?> page)
    {
        return page;
    }

    /**
     * Adds Font Awesome free npm dependencies based on enabled families.
     * Skipped entirely when Kit mode is active.
     */
    @Override
    public IPage<?> configureAngular(IPage<?> page)
    {
        if (!Strings.isNullOrEmpty(kitCode))
        {
            return page;
        }

        // Core packages always needed when using npm-based icons
        page.getBody().addConfiguration(
                AnnotationUtils.getTsDependency("@fortawesome/fontawesome-svg-core", FA_VERSION, "fontawesome-svg-core"));
        page.getBody().addConfiguration(
                AnnotationUtils.getTsDependency("@fortawesome/angular-fontawesome", "^4.0.0", "fontawesome-angular"));

        // Free icon family packages — only add what's enabled
        if (enabledFamilies.contains(IconFamily.Classic))
        {
            page.getBody().addConfiguration(
                    AnnotationUtils.getTsDependency("@fortawesome/free-solid-svg-icons", FA_VERSION, "fontawesome-svg-solid"));
        }
        if (enabledFamilies.contains(IconFamily.Brands))
        {
            page.getBody().addConfiguration(
                    AnnotationUtils.getTsDependency("@fortawesome/free-brands-svg-icons", FA_VERSION, "fontawesome-svg-brands"));
        }

        return page;
    }

    @Override
    public boolean enabled()
    {
        return true;
    }

    // ── Family flags ─────────────────────────────────────────

    /**
     * Enables a free icon family so its npm package will be added.
     *
     * @param family the icon family to enable
     */
    public static void enableFamily(IconFamily family)
    {
        enabledFamilies.add(family);
    }

    /**
     * Disables a free icon family so its npm package will not be added.
     *
     * @param family the icon family to disable
     */
    public static void disableFamily(IconFamily family)
    {
        enabledFamilies.remove(family);
    }

    /**
     * Returns whether the given icon family is enabled.
     */
    public static boolean isFamilyEnabled(IconFamily family)
    {
        return enabledFamilies.contains(family);
    }

    /**
     * Returns the set of currently enabled icon families.
     */
    public static Set<IconFamily> getEnabledFamilies()
    {
        return EnumSet.copyOf(enabledFamilies);
    }

    // ── Kit code ─────────────────────────────────────────────

    public static String getKitCode()
    {
        return kitCode;
    }

    /**
     * Sets the Font Awesome Kit code. When set, no npm icon packages will be
     * added by this (free) configurator — the Kit script handles all icon delivery.
     * <p>
     * This is also called by the Pro configurator's {@code setKitCode} to ensure
     * both free and pro packages are skipped when using Kit mode.
     *
     * @param kitCode the kit identifier, e.g. "cf4534f35c"
     */
    public static void setKitCode(String kitCode)
    {
        FontAwesome5PageConfigurator.kitCode = kitCode;
    }

    // ── Config options ───────────────────────────────────────

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
