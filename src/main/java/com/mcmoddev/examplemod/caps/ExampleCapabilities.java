package com.mcmoddev.examplemod.caps;

import com.mcmoddev.examplemod.caps.ExampleCapabilities.DefaultImpl;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class ExampleCapabilities {
	@CapabilityInject(IExampleCapability.class)
	public static final Capability<IExampleCapability> EXAMPLE_CAPABILITY = null;

	public static class DefaultImpl implements IExampleCapability {
		private PotionEffect effect = null;

		@Override
		public NBTTagCompound serializeNBT() {
			NBTTagCompound nbt = new NBTTagCompound();
			return this.effect != null? effect.writeCustomPotionEffectToNBT(nbt) : nbt;
		}

		@Override
		public void deserializeNBT(NBTTagCompound nbt) {
			this.effect = PotionEffect.readCustomPotionEffectFromNBT(nbt);
		}

		@Override
		public void applyPotion(Potion potion, int duration, int amplifier) {
			this.effect = new PotionEffect(potion, duration, amplifier);
		}

		@Override
		public PotionEffect getEffect() {
			return this.effect;
		}
	}

	public static void init() {
		CapabilityManager.INSTANCE.register(IExampleCapability.class, 
				new IStorage<IExampleCapability>() {
					@Override
					public NBTBase writeNBT(Capability<IExampleCapability> capability, IExampleCapability instance, EnumFacing side) {
						return instance.serializeNBT();
					}

					@Override
					public void readNBT(Capability<IExampleCapability> capability, IExampleCapability instance, EnumFacing side,
							NBTBase nbt) {
						if(nbt instanceof NBTTagCompound) instance.deserializeNBT((NBTTagCompound)nbt);
					}
		}, DefaultImpl::new);
	}
}
