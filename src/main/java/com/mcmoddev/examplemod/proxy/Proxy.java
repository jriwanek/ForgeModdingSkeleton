package com.mcmoddev.examplemod.proxy;

import com.mcmoddev.examplemod.init.ExampleModFluids;

import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms.IMCEvent;
//import net.minecraftforge.fml.common.event.FMLMissingMappingsEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 *
 */
public abstract class Proxy {
	// uncomment this if you have ore generation
	// private static WorldGenerator worldGen = new WorldGenerator();

	/**
	 *
	 * @param event The Event.
	 */
	public void preInit(final FMLPreInitializationEvent event) {
		ExampleModFluids.init();
		// if you've got any Ore Generation uncomment the following line
		// and import the "oregen.WorldGenerator" class
		// GameRegistry.registerWorldGenerator(new WorldGenerator(), 100);
	}

	/**
	 *
	 * @param event The Event.
	 */
	public void init(final FMLInitializationEvent event) {
		// if you have any ore generation, you want to do something like the following
		// for all of your ores:
		// worldGen.addBlock( block, minHeight, maxHeight, dimension, spawn-size );
		// 'dimension'should be one of:
		// WorldGenerator.DIMENSION_OVERWORLD
		// WorldGenerator.DIMENSION_NETHER
		// WorldGenerator.DIMENSION_END
		//   or
		// WorldGenerator.DIMENSION_ANY_OVERWORLD
		// -- the first three are specific to the named dimensions - the last will
		// spawn in any "Overworld" type dimension.
	}

	/**
	 *
	 * @param event The Event.
	 */
	public void receiveIMC(final IMCEvent event) {
		//
	}

	/**
	 *
	 * @param event The Event.
	 */
	public void postInit(final FMLPostInitializationEvent event) {
		//
	}

	/**
	 *
	 * @return World The World
	 */
	public World getWorld() {
		return null;
	}

	/*
 	// Before 1.12
	public void onRemap(final FMLMissingMappingsEvent event) {
		//
	}
	*/
}
