package com.mcmoddev.examplemod.proxy;

import com.mcmoddev.examplemod.ExampleMod;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = ExampleMod.NAME)
public final class ClientProxy extends CommonProxy {

	@Override
	public void preInit(final FMLPreInitializationEvent event) {
		super.preInit(event);
	}

	@Override
	public void init(final FMLInitializationEvent event) {
		super.init(event);
	}

	@Override
	public void postInit(final FMLPostInitializationEvent event) {
		super.postInit(event);
	}

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
    	//
    }
}
