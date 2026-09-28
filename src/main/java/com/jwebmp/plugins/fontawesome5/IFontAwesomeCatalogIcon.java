package com.jwebmp.plugins.fontawesome5;

import com.jwebmp.plugins.fontawesome5.options.IconFamily;
import com.jwebmp.plugins.fontawesome5.options.IconVariant;

import java.util.Set;

/** An icon from a versioned family catalog, including its available styles. */
public interface IFontAwesomeCatalogIcon extends IFontAwesomeIcon
{
    IconFamily getFamily();

    IconVariant getVariant();

    Set<IconVariant> getSupportedVariants();

    default IconVariant requireVariant(IconVariant variant)
    {
        if (!getSupportedVariants().contains(variant))
        {
            throw new IllegalArgumentException(getFamily() + " does not contain " + name() + " in " + variant);
        }
        return variant;
    }

    @Override
    default String toAngularIconAttributeName()
    {
        return name().replace("$", "").replace('_', '-');
    }

    @Override
    default String toAngularIcon()
    {
        StringBuilder result = new StringBuilder("fa");
        for (String part : toAngularIconAttributeName().split("-"))
        {
            result.append(Character.toUpperCase(part.charAt(0))).append(part.substring(1));
        }
        return result.toString();
    }
}
