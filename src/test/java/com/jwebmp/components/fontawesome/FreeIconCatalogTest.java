package com.jwebmp.components.fontawesome;

import com.jwebmp.plugins.fontawesome5.FontAwesome;
import com.jwebmp.plugins.fontawesome5.icons.*;
import com.jwebmp.plugins.fontawesome5.options.FontAwesomeStyles;
import com.jwebmp.plugins.fontawesome5.options.IconFamily;
import com.jwebmp.plugins.fontawesome5.options.IconVariant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FreeIconCatalogTest
{
    @Test
    void freeCatalogsHaveDistinctMembership()
    {
        assertEquals(1422, FontAwesomeFreeSolidIcons.values().length);
        assertEquals(169, FontAwesomeFreeRegularIcons.values().length);
        assertEquals(572, FontAwesomeFreeBrandsIcons.values().length);
        assertNotNull(FontAwesomeFreeSolidIcons.hexagon);
        assertThrows(IllegalArgumentException.class, () -> FontAwesomeFreeRegularIcons.valueOf("hexagon"));
        assertThrows(IllegalArgumentException.class, () -> FontAwesomeFreeSolidIcons.valueOf("abacus"));
        assertThrows(IllegalArgumentException.class, () -> FontAwesomeFreeSolidIcons.heart.requireVariant(IconVariant.Regular));
    }

    @Test
    void oldEnumsIncludeNewNamesAndRetainOldAliases()
    {
        assertNotNull(FontAwesomeIcons.hexagon);
        assertNotNull(FontAwesomeIcons.alarm_clock);
        assertNotNull(FontAwesomeIcons.check_circle);
        assertNotNull(FontAwesomeBrandIcons.bluesky);
        assertNotNull(FontAwesomeBrandIcons.claude);
        assertNotNull(FontAwesomeBrandIcons.twitter_square);
        assertEquals("fa-0", FontAwesomeIcons.$0.toString());
        assertEquals("0", FontAwesomeIcons.$0.toAngularIconAttributeName());
        assertEquals("fa0", FontAwesomeIcons.$0.toAngularIcon());
    }

    @Test
    void freeMetadataSelectsTheCorrectAssets()
    {
        assertEquals("@fortawesome/free-regular-svg-icons", FontAwesomeFreeRegularIcons.heart.getNpmPackage());
        assertEquals("fab", FontAwesomeFreeBrandsIcons.bluesky.getAngularPrefix());
        assertEquals(IconFamily.Brands, FontAwesomeFreeBrandsIcons.bluesky.getFamily());
        assertEquals("0", FontAwesomeFreeSolidIcons.$0.toAngularIconAttributeName());
        assertEquals("fa0", FontAwesomeFreeSolidIcons.$0.toAngularIcon());
    }

    @Test
    void angularComponentUsesFreeCatalogStyle()
    {
        var icon = new FontAwesome<>(FontAwesomeStyles.Classic, FontAwesomeFreeRegularIcons.heart);
        String html = icon.toString(true);
        assertTrue(html.contains("['far','heart']"), html);
        assertEquals("farfaHeart", icon.getFieldIdentifier());
        assertTrue(icon.getConfigurations().toString().contains("@fortawesome/free-regular-svg-icons"));
    }
}
