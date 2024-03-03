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
package com.jwebmp.plugins.fontawesome5;

import com.guicedee.guicedinjection.*;
import com.jwebmp.core.Page;
import com.jwebmp.core.base.angular.client.services.interfaces.*;
import com.jwebmp.core.base.angular.services.compiler.*;
import com.jwebmp.plugins.fontawesome5.icons.FontAwesomeIcons;
import com.jwebmp.plugins.fontawesome5.options.FontAwesomeSizes;
import com.jwebmp.plugins.fontawesome5.options.FontAwesomeStyles;
import com.jwebmp.plugins.fontawesome5.options.FontAwesomeTransforms;
import org.junit.jupiter.api.Test;

import java.io.*;

import static com.jwebmp.core.base.angular.client.services.interfaces.AnnotationUtils.*;
import static com.jwebmp.core.base.angular.client.services.interfaces.IComponent.*;

/**
 * @author GedMarc
 */
public class FontAwesomeTest

{

    public FontAwesomeTest()
    {
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testIcon_FontAwesomeIcons()
    {
        FontAwesome fa = new FontAwesome(FontAwesomeStyles.Regular, FontAwesomeIcons.cog);
        FontAwesome faSolid = IFontAwesome.createIcon(FontAwesomeIcons.cog, FontAwesomeStyles.Solid);
        FontAwesome faLight = IFontAwesome.createIcon(FontAwesomeIcons.cog, FontAwesomeStyles.Light);

        FontAwesome faMask = IFontAwesome.createMaskIcon(FontAwesomeIcons.cog, FontAwesomeStyles.Light, FontAwesomeIcons.comment_alt, FontAwesomeStyles.Regular);

        faSolid.spin()
               .transform(FontAwesomeTransforms.Grow_3, FontAwesomeTransforms.Up_4)
               .setStyle(FontAwesomeStyles.Regular)
               .setSize(FontAwesomeSizes.$4x)
               .setIcon(FontAwesomeIcons.cogs);

        System.out.println(fa.toString(true));
        System.out.println(faSolid.toString(true));
        System.out.println(faLight.toString(true));
        System.out.println(faMask.toString(true));

        Page<?> p = new Page();
        p.getBody()
         .add(fa);
        System.out.println(p.toString(true));
    }

    @Test
    public void testAppSearch() throws IOException
    {
        GuiceContext.instance()
                    .inject();
        for (INgApp<?> app : JWebMPTypeScriptCompiler.getAllApps())
        {
            JWebMPTypeScriptCompiler compiler = new JWebMPTypeScriptCompiler(app);

            System.out.println("Generating @NgApp (" + getTsFilename(app.getClass()) + ") " +
                    "in folder " + getClassDirectory(app.getClass()));
            System.out.println("================");
            //	compiler.renderAppTS(app);
            System.out.println("================");
        }
    }
}
