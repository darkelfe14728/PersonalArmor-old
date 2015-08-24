package personalarmor.network.client;

import personalarmor.network.AbstractMessageHandler;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public abstract class AbstractClientMessageHandler<T extends IMessage>
	extends AbstractMessageHandler<T>
{
	public final IMessage handleServerMessage (EntityPlayer player, T message, MessageContext context)
	{
		return null;
	}
}
