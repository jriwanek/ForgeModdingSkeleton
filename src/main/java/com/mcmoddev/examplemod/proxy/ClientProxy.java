package com.mcmoddev.examplemod.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 *
 */
public final class ClientProxy extends Proxy {

	/**
	 *
	 */
	@Override
	public void preInit(final FMLPreInitializationEvent event) {
		super.preInit(event);
	}

	/**
	 *
	 */
	@Override
	public void init(final FMLInitializationEvent event) {
		super.init(event);
	}

	/**
	 *
	 */
	@Override
	public void postInit(final FMLPostInitializationEvent event) {
		super.postInit(event);
	}

	/**
	 *
	 */
	@Override
	public World getWorld() {
		return Minecraft.getMinecraft().world;
	}
}
