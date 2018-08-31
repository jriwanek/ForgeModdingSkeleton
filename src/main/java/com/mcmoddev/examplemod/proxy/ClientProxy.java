package com.mcmoddev.examplemod.proxy;

import com.mcmoddev.examplemod.ExampleMod;
import com.mcmoddev.examplemod.fluid.FluidStateMapper;
import com.mcmoddev.examplemod.init.ExampleModBlocks;
import com.mcmoddev.examplemod.init.ExampleModFluids;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 *
 */
public final class ClientProxy extends Proxy {

	@Override
	public void preInit(final FMLPreInitializationEvent event) {
		super.preInit(event);
	}

	@Override
	public void init(final FMLInitializationEvent event) {
		super.init(event);
		registerFluidRender(ExampleModBlocks.EXAMPLE_FLUID, ExampleModFluids.EXAMPLE_FLUID);
	}

	@Override
	public void postInit(final FMLPostInitializationEvent event) {
		super.postInit(event);
	}

	/**
	 *
	 * @param block The Block.
	 * @param fluid The Fluid.
	 */
	@SideOnly(Side.CLIENT)
	private static void registerFluidRender(final Block block, final Fluid fluid) {
		// final Block block = fluid.getBlock(); // Unfortunately this breaks when
		// another mod registered it's fluid before us.
		final Item item = Item.getItemFromBlock(block);
		final ResourceLocation resourceLocation = new ResourceLocation(ExampleMod.MODID, fluid.getName());
		final FluidStateMapper mapper = new FluidStateMapper(
				resourceLocation.getNamespace() + ":" + fluid.getName());

		if (item != null) {
			ModelBakery.registerItemVariants(item);
			ModelLoader.setCustomMeshDefinition(item, mapper);
		}
		ModelLoader.setCustomStateMapper(block, mapper);
	}
}
