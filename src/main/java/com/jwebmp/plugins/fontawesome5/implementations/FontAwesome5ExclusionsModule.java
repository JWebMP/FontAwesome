package com.jwebmp.plugins.fontawesome5.implementations;

import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions;

import jakarta.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class FontAwesome5ExclusionsModule
		implements IGuiceScanModuleExclusions<FontAwesome5ExclusionsModule>
{
	@Override
	public @NotNull Set<String> excludeModules()
	{
		Set<String> strings = new HashSet<>();
		strings.add("com.jwebmp.plugins.fontawesome5");
		return strings;
	}
}
