package com.mcmoddev.examplemod.item;

import com.mcmoddev.examplemod.ExampleMod;

import net.minecraft.item.Item;

public class ExampleItem extends Item {

	public ExampleItem() {
		setRegistryName("example_item");
		setTranslationKey(ExampleMod.MODID + getRegistryName());
	}
}
