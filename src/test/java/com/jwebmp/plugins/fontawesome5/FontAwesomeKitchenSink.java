package com.jwebmp.plugins.fontawesome5;

import com.jwebmp.core.base.angular.services.annotations.*;
import com.jwebmp.core.base.angular.services.interfaces.*;
import com.jwebmp.core.base.html.*;
import com.jwebmp.plugins.fontawesome5.icons.*;
import com.jwebmp.plugins.fontawesome5.options.*;

@NgComponent(value = "fontawesome-kitchen-sink")
public class FontAwesomeKitchenSink
		extends DivSimple<FontAwesomeKitchenSink>
		implements INgComponent<FontAwesomeKitchenSink>
{
	@Override
	public void init()
	{
		add(FontAwesome.icon(FontAwesomeIcons.star));
		add(FontAwesome.icon(FontAwesomeBrandIcons.twitch, FontAwesomeStyles.Brand));
		add(FontAwesome.icon(FontAwesomeIcons.star, FontAwesomeSizes.Lg));
		add(FontAwesome.icon(FontAwesomeIcons.star, FontAwesomeSizes.$5x)
		               .spin());
		add(FontAwesome.icon(FontAwesomeIcons.star, FontAwesomeSizes.$4x)
		               .pullRight());
		add(FontAwesome.icon(FontAwesomeIcons.star, FontAwesomeSizes.$3x)
		               .border());
		add(FontAwesome.icon(FontAwesomeIcons.star, FontAwesomeSizes.$2x)
		               .fixedWidth());
		
		
		add(new FontAwesomeLayers()
				.addIcon(FontAwesome.icon(FontAwesomeBrandIcons.twitch, FontAwesomeStyles.Brand))
				.addText(new FontAwesomeLayerText().setText("Yo")
				                                   .addStyle("color", "white")
				                                   .transform(FontAwesomeTransforms.Shrink_4))
		);
		
		add(new FontAwesomeLayers()
				.fixedWidth()
				.setSize(FontAwesomeSizes.Lg)
				.addIcon(FontAwesome.icon(FontAwesomeBrandIcons.twitch, FontAwesomeStyles.Brand))
				.addCounter(new FontAwesomeLayerCounter().setText("99+")
				                                         .addStyle("color", "white")
				                                         .addStyle("background", "black")
				)
		);
		
		
		super.init();
	}
}
