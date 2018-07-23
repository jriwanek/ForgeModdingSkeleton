package com.mcmoddev.examplemod.proxy;

import com.mcmoddev.examplemod.ExampleMod;
import com.mcmoddev.examplemod.block.ExampleBlock;
import com.mcmoddev.examplemod.init.Blocks;
import com.mcmoddev.examplemod.item.ExampleItem;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms.IMCEvent;
//import net.minecraftforge.fml.common.event.FMLMissingMappingsEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value = {Side.CLIENT, Side.SERVER}, modid = ExampleMod.NAME)
public class CommonProxy {

	public void preInit(final FMLPreInitializationEvent event) {
		//
	}

	public void init(final FMLInitializationEvent event) {
		//
	}

	public void recieveIMC(final IMCEvent event) {
		//
	}

	public void postInit(final FMLPostInitializationEvent event) {
		//
	}

	/*
 	// Before 1.12
	public void onRemap(final FMLMissingMappingsEvent event) {
		//
	}
	*/

	@SubscribeEvent
	public void onRemapBlock(final RegistryEvent.MissingMappings<Block> event) {
		for (final RegistryEvent.MissingMappings.Mapping<Block> mapping : event.getMappings()) {
			mapping.ignore();
		}
	}

	@SubscribeEvent
	public void onRemapItem(final RegistryEvent.MissingMappings<Item> event) {
		for (final RegistryEvent.MissingMappings.Mapping<Item> mapping : event.getMappings()) {
			mapping.ignore();
		}
	}

	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().register(new ExampleBlock());
	}

	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry().register(new ItemBlock(Blocks.exampleBlock).setRegistryName(Blocks.exampleBlock.getRegistryName()));
		event.getRegistry().register(new ExampleItem());
	}

	@SubscribeEvent
	public static void registerRecipes(final RegistryEvent.Register<IRecipe> event) {
		//
	}
}
