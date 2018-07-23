package com.mcmoddev.examplemod.init;

import com.mcmoddev.examplemod.item.ExampleItem;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class Items {

	@GameRegistry.ObjectHolder("examplemod:example_item")
	public static ExampleItem exampleItem;
}
