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

/**
 *
 */
public class MessagePotionUpdate implements IMessage {

	/**
	 *
	 */
	private BlockPos pos;

	/**
	 *
	 */
	private NBTTagCompound potionUpdateData;

	/**
	 *
	 */
	public MessagePotionUpdate() {
		//
	}

	/**
	 *
	 * @param te TileEntity
	 * @return MessagePotionUpdate
	 */
	public static MessagePotionUpdate createUpdatePacket(final TileEntity te) {
		final IExampleCapability caps = te.getCapability(ExampleCapabilities.EXAMPLE_CAPABILITY, null);
		if (caps == null) {
			throw new IllegalArgumentException("Should only sync TileEntity.");
		} else {
			return new MessagePotionUpdate(te.getPos(), caps.serializeNBT());
		}
	}

	/**
	 *
	 * @param posIn BlockPos
	 * @param nbt NBTTagCompound
	 */
	private MessagePotionUpdate(final BlockPos posIn, final NBTTagCompound nbt) {
		this.pos = posIn;
		this.potionUpdateData = nbt;
	}

	/**
	 * Convert from the supplied buffer into your specific message type.
	 *
	 * @param buf buffer
	 */
	@Override
	public void fromBytes(final ByteBuf buf) {
		this.pos = BlockPos.fromLong(buf.readLong());
		this.potionUpdateData = ByteBufUtils.readTag(buf);
	}

    /**
     * Deconstruct your message into the supplied byte buffer.
     *
     * @param buf buffer
     */
	@Override
	public void toBytes(final ByteBuf buf) {
		buf.writeLong(pos.toLong());
		ByteBufUtils.writeTag(buf, this.potionUpdateData);
	}

	/**
	 *
	 */
	public static class MessageHandlerPotionUpdate implements IMessageHandler<MessagePotionUpdate, IMessage> {

		/**
		 *
		 */
		@Override
		public IMessage onMessage(final MessagePotionUpdate message, final MessageContext ctx) {
			final FMLCommonHandler handler = FMLCommonHandler.instance();
			handler.getWorldThread(ctx.getClientHandler()).addScheduledTask(
					() -> {
						final TileEntity te = ExampleMod.getWorld().getTileEntity(message.pos);
						final IExampleCapability caps = te.getCapability(ExampleCapabilities.EXAMPLE_CAPABILITY, null);
						if (caps != null) {
							caps.deserializeNBT(message.potionUpdateData);
						}
					});
			return null;
		}
	}
}
