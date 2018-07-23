package com.mcmoddev.examplemod.block;

import com.mcmoddev.examplemod.ExampleMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ExampleBlock extends Block {

	public ExampleBlock() {
		super(Material.ROCK);
		setRegistryName("example_block");
		setTranslationKey(ExampleMod.MODID + getRegistryName());
	}
}
