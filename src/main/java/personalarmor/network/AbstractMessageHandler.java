package personalarmor.network;

import personalarmor.PersonalArmor;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Generic message handler.
 * 
 * @author soludev1
 */
public abstract class AbstractMessageHandler<T extends IMessage>
	implements IMessageHandler<T, IMessage>
{
	/**
	 * Override to define reaction and response to message (client side)
	 * 
	 * @param player	The player entity, target of message
	 * @param message	The receive message
	 * @param context	Context for message
	 * 
	 * @return The answer message (if exists else null)
	 */
	@SideOnly(Side.CLIENT)
	public abstract IMessage handleClientMessage (EntityPlayer player, T message, MessageContext context);
	/**
	 * Override to define reaction and response to message (server side)
	 * 
	 * @param player	The player entity, target of message
	 * @param message	The receive message
	 * @param context	Context for message
	 * 
	 * @return The answer message (if exists else null)
	 */
	public abstract IMessage handleServerMessage (EntityPlayer player, T message, MessageContext context);

	@Override
	public IMessage onMessage (T message, MessageContext context)
	{
		if(context.side.isClient())
			return handleClientMessage(PersonalArmor.proxy.getEntityPlayer(context), message, context);
		else
			return handleServerMessage(PersonalArmor.proxy.getEntityPlayer(context), message, context);
	}
}
