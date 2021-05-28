package com.mcmoddev.examplemod.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

/**
 *
 * @author
 *
 */
public class ExampleTileEntity extends TileEntity {

	/**
	 *
	 */
	@Override
	public boolean hasCapability(final Capability<?> capability, final EnumFacing facing) {
		return super.hasCapability(capability, facing);
	}

	/**
	 *
	 */
	@Override
	public <T> T getCapability(final Capability<T> capability, final EnumFacing facing) {
		return super.getCapability(capability, facing);
	}
}
