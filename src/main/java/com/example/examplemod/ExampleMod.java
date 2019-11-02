package com.example.examplemod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod {

	public static final String MODID = "examplemod";
	public static final String VERSION = "1.0.0";

	public static final Logger LOGGER = LogManager.getLogger(ExampleMod.MODID);    

	@EventHandler
	public void init(final FMLInitializationEvent event) {
		// some example code
		LOGGER.info("DIRT BLOCK >> " + Blocks.dirt.getUnlocalizedName());
	}
}
