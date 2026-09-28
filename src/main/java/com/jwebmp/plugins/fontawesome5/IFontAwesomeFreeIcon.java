package com.jwebmp.plugins.fontawesome5;

/** Exact membership in one of the free Solid, Regular or Brands catalogs. */
public interface IFontAwesomeFreeIcon extends IFontAwesomeCatalogIcon
{
    default String getAngularPrefix()
    {
        return switch (getVariant())
        {
            case Solid -> "fas";
            case Regular -> "far";
            case Brands -> "fab";
            default -> throw new IllegalStateException("Not a free style: " + getVariant());
        };
    }

    default String getNpmPackage()
    {
        return "@fortawesome/free-" + getVariant() + "-svg-icons";
    }
}
