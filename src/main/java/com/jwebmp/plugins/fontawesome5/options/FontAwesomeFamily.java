package com.jwebmp.plugins.fontawesome5.options;

import com.jwebmp.core.base.interfaces.ICssClassName;

public enum FontAwesomeFamily
        implements ICssClassName, IFontAwesomeFamilies<FontAwesomeFamily>
{
    Brand("fab", "brands"),
    Classic("fac", "classic");

    private String angularText;
    private String familyName;

    FontAwesomeFamily(String angularText, String familyName)
    {
        this.angularText = angularText;
        this.familyName = familyName;
    }

    @Override
    public String getAngularText()
    {
        return angularText;
    }

    @Override
    public String getFamilyName()
    {
        return familyName;
    }

    @Override
    public String toString()
    {
        return angularText;
    }
}
