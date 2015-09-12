package personalarmor.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import personalarmor.PersonalArmor;
import personalarmor.network.bidirectional.AbstractBidirectionalMessageHandler;
import personalarmor.network.client.AbstractClientMessageHandler;
import personalarmor.network.server.AbstractServerMessageHandler;

/**
 * Helper class for packet registration and sending.
 * 
 * @author soludev1
 */
public class PacketDispatcher
{
	/**
	 * Global counter for automatic packet ID at registration time.
	 */
	private static byte packetID = 0;
	
	/**
	 * The real dispatcher.
	 * Hidden from external because we don't need us directly.
	 */
	private static final SimpleNetworkWrapper dispatcher =
		NetworkRegistry.INSTANCE.newSimpleChannel(PersonalArmor.MODID);
	
	/**
	 * Register the message handler.
	 * Auto packet ID generation and guess side from context.
	 */
	public static final	<REQ extends IMessage> void registerMessages (
			Class<? extends AbstractMessageHandler<REQ>> handlerClass,
			Class<REQ> messageClass
		)
	{
		if(AbstractClientMessageHandler.class.isAssignableFrom(handlerClass) ||
			AbstractBidirectionalMessageHandler.class.isAssignableFrom(handlerClass))
			PacketDispatcher.dispatcher.registerMessage(handlerClass, messageClass, PacketDispatcher.packetID++, Side.CLIENT);
		
		if(AbstractServerMessageHandler.class.isAssignableFrom(handlerClass) ||
			AbstractBidirectionalMessageHandler.class.isAssignableFrom(handlerClass))
				PacketDispatcher.dispatcher.registerMessage(handlerClass, messageClass, PacketDispatcher.packetID++, Side.SERVER);
	}

	/* ==========================
	 * Convenient sending methods
	 * ==========================
	 */
	/**
	 * Send a message to a specific player
	 * 
	 * @param message The message.
	 * @param player  The player.
	 */
	public static final void sendToPlayer (IMessage message, EntityPlayerMP player)
	{
	    dispatcher.sendTo(message, player);
	}
	/**
	 * Send a message to everyone.
	 * 
	 * @param message The message.
	 */
	public static final void sendToAll (IMessage message)
	{
	    dispatcher.sendToAll(message);
	}
	/**
	 * Send a message to everyone around a point.
	 * 
	 * @param message The message.
	 * @param point   The target point.
	 */
	public static final void sendToAllAround (IMessage message, NetworkRegistry.TargetPoint point)
	{
	    dispatcher.sendToAllAround(message, point);
	}
	/**
	 * Send a message to everyone around a point.
	 * 
	 * @param message   The message.
	 * @param dimension The dimension.
	 * @param x         X coordinate inside dimension.
	 * @param y         Y coordinate inside dimension.
	 * @param z         Z coordinate inside dimension.
	 * @param range     Range around the point.
	 */
	public static final void sendToAllAround (IMessage message, int dimension, double x, double y, double z, double range)
	{
	    dispatcher.sendToAllAround(message, new NetworkRegistry.TargetPoint(dimension, x, y, z, range));
	}
	/**
	 * Send a message to everyone around a player.
	 * 
	 * @param message The message.
	 * @param player  The player.
	 * @param range   The range around the player.
	 */
	public static final void sendToAllAroundPlayer (IMessage message, EntityPlayer player, double range)
	{
	    sendToAllAround(
	        message,
	        player.worldObj.provider.getDimensionId(), 
	        player.posX, 
	        player.posY, 
	        player.posZ, 
	        range
	    );
	}
	/**
	 * Send a message to a specific dimension.
	 * 
	 * @param message   The message.
	 * @param dimension The dimension.
	 */
	public static final void sendToDimension (IMessage message, int dimension)
	{
	    dispatcher.sendToDimension(message, dimension);
	}
	/**
	 * Send a message to server side.
	 * 
	 * @param message The message.
	 */
	public static final void sendToServer (IMessage message)
	{
	    dispatcher.sendToServer(message);
	}
}
