package com.mcmoddev.examplemod.events;

import com.mcmoddev.examplemod.ExampleMod;
import com.mcmoddev.examplemod.init.ExampleModBlocks;
import com.mcmoddev.examplemod.init.ExampleModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

/**
 *
 */
@Mod.EventBusSubscriber(value = Side.CLIENT, modid = ExampleMod.NAME)
public final class ClientEventHandler {

	/**
	 *
	 * @param event The Event.
	 */
	@SubscribeEvent
	public static void registerModels(final ModelRegistryEvent event) {
		registerModel(Item.getItemFromBlock(ExampleModBlocks.EXAMPLE_BLOCK));
		registerModel(ExampleModItems.EXAMPLE_ITEM);
	}

	/**
	 *
	 * @param item The Item.
	 */
	private static void registerModel(final Item item) {
		ModelLoader.setCustomModelResourceLocation(item,
				0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
