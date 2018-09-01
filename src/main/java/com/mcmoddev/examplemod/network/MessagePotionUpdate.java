package com.mcmoddev.examplemod.network;

import com.mcmoddev.examplemod.ExampleMod;
import com.mcmoddev.examplemod.caps.ExampleCapabilities;
import com.mcmoddev.examplemod.caps.IExampleCapability;

import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessagePotionUpdate implements IMessage {
	private BlockPos pos;
	private NBTTagCompound potionUpdateData;

	public MessagePotionUpdate() { }

	public static MessagePotionUpdate createUpdatePacket(TileEntity te) {
		IExampleCapability caps = te.getCapability(ExampleCapabilities.EXAMPLE_CAPABILITY, null);
		if(caps != null)
			return new MessagePotionUpdate(te.getPos(), caps.serializeNBT());
		else throw new IllegalArgumentException("Should only sync TileEntity.");
	}

	private MessagePotionUpdate(BlockPos pos, NBTTagCompound nbt) {
		this.pos = pos;
		this.potionUpdateData = nbt;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.pos = BlockPos.fromLong(buf.readLong());
		this.potionUpdateData = ByteBufUtils.readTag(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeLong(pos.toLong());
		ByteBufUtils.writeTag(buf, this.potionUpdateData);
	}

	public static class MessageHandlerPotionUpdate implements IMessageHandler<MessagePotionUpdate, IMessage> {
		@Override
		public IMessage onMessage(MessagePotionUpdate message, MessageContext ctx) {
			final FMLCommonHandler handler = FMLCommonHandler.instance();
			handler.getWorldThread(ctx.getClientHandler()).addScheduledTask(
					() -> {
						TileEntity te = ExampleMod.getWorld().getTileEntity(message.pos);
						IExampleCapability caps = te.getCapability(ExampleCapabilities.EXAMPLE_CAPABILITY, null);
						if(caps != null)
							caps.deserializeNBT(message.potionUpdateData);
					});
			return null;
		}
	}
}
