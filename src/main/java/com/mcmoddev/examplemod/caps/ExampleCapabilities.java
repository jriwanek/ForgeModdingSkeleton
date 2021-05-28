package com.mcmoddev.examplemod.caps;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

/**
 *
 * @author
 *
 */
public class ExampleCapabilities {

	/**
	 *
	 */
	@CapabilityInject(IExampleCapability.class)
	public static final Capability<IExampleCapability> EXAMPLE_CAPABILITY = null;

	/**
	 *
	 */
	private ExampleCapabilities() {
		//
	};

	/**
	 *
	 * @author
	 *
	 */
	public static class DefaultImpl implements IExampleCapability {

		/**
		 *
		 */
		private PotionEffect effect = null;

		/**
		 *
		 */
		@Override
		public NBTTagCompound serializeNBT() {
			final NBTTagCompound nbt = new NBTTagCompound();
			if (this.effect == null) {
				return nbt;
			} else {
				return effect.writeCustomPotionEffectToNBT(nbt);
			}
		}

		/**
		 *
		 */
		@Override
		public void deserializeNBT(final NBTTagCompound nbt) {
			this.effect = PotionEffect.readCustomPotionEffectFromNBT(nbt);
		}

		/**
		 *
		 */
		@Override
		public void applyPotion(final Potion potion, final int duration, final int amplifier) {
			this.effect = new PotionEffect(potion, duration, amplifier);
		}

		/**
		 *
		 */
		@Override
		public PotionEffect getEffect() {
			return this.effect;
		}
	}

	/**
	 *
	 */
	public static void init() {
		CapabilityManager.INSTANCE.register(IExampleCapability.class,
				new IStorage<IExampleCapability>() {
					/**
					 *
					 */
					@Override
					public NBTBase writeNBT(final Capability<IExampleCapability> capability,
							final IExampleCapability instance, final EnumFacing side) {
						return instance.serializeNBT();
					}

					/**
					 *
					 */
					@Override
					public void readNBT(final Capability<IExampleCapability> capability,
							final IExampleCapability instance, final EnumFacing side, final NBTBase nbt) {
						if (nbt instanceof NBTTagCompound) {
							instance.deserializeNBT((NBTTagCompound) nbt);
						}
					}
		}, DefaultImpl::new);
	}
}
