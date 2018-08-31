package com.mcmoddev.examplemod.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms.IMCEvent;
//import net.minecraftforge.fml.common.event.FMLMissingMappingsEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 *
 */
public abstract class CommonProxy {

	/**
	 *
	 * @param event The Event.
	 */
	public void preInit(final FMLPreInitializationEvent event) {
		//
	}

	/**
	 *
	 * @param event The Event.
	 */
	public void init(final FMLInitializationEvent event) {
		//
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

	/*
 	// Before 1.12
	public void onRemap(final FMLMissingMappingsEvent event) {
		//
	}
	*/
}
