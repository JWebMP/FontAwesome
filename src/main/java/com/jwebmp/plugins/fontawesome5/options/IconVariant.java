package com.jwebmp.plugins.fontawesome5.options;

/**
 * Defines the possible style variants for icons.
 * <p>
 * These represent the weight/style of the icon within a given family.
 */
public enum IconVariant
{
    /**
     * Thin variant
     */
    Thin,

    /**
     * Light variant
     */
    Light,

    /**
     * Regular variant
     */
    Regular,

    /**
     * Solid variant
     */
    Solid,

    /**
     * Semibold variant
     */
    Semibold,

    /** Brand logos, available in the free Brands family. */
    Brands;

    @Override
    public String toString()
    {
        return name().replace('_', '-')
                     .toLowerCase();
    }
}

