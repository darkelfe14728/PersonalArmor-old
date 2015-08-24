package personalarmor.network;

import personalarmor.PersonalArmor;
import personalarmor.network.bidirectional.AbstractBidirectionalMessageHandler;
import personalarmor.network.client.AbstractClientMessageHandler;
import personalarmor.network.server.AbstractServerMessageHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

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
		NetworkRegistry.INSTANCE.newSimpleChannel(PersonalArmor.modMetadata.modId);
	
	/**
	 * Register all packets used by mod.
	 */
	public static final void registerPackets ()
	{
		
	}
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
}
