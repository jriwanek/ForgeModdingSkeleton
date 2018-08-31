package com.mcmoddev.examplemod.fluid;

import javax.annotation.Nonnull;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

/**
 *
 */
public final class FluidStateMapper extends StateMapperBase implements ItemMeshDefinition {

	/**
	 *
	 */
	private final ModelResourceLocation location;

	/**
	 *
	 * @param resourceLocation The ResourceLocation.
	 */
	public FluidStateMapper(final String resourceLocation) {
		this.location = new ModelResourceLocation(resourceLocation, "fluid");
	}

	/**
	 *
	 * @param resourceLocation The ResourceLocation.
	 */
	public FluidStateMapper(final ResourceLocation resourceLocation) {
		this.location = new ModelResourceLocation(resourceLocation, "fluid");
	}

	/**
	 *
	 * @param modelResourceLocation The ModelResourceLocation.
	 */
	public FluidStateMapper(final ModelResourceLocation modelResourceLocation) {
		this.location = modelResourceLocation;
	}

	/**
	 *
	 * @param state The BlockState.
	 * @return The ModelResourceLocation.
	 */
	@Nonnull
	@Override
	protected ModelResourceLocation getModelResourceLocation(@Nonnull final IBlockState state) {
		return this.location;
	}

	/**
	 *
	 * @param stack The ItemStack.
	 * @return The ModelResourceLocation.
	 */
	@Nonnull
	@Override
	public ModelResourceLocation getModelLocation(@Nonnull final ItemStack stack) {
		return this.location;
	}
}
