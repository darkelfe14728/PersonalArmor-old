package personalarmor.network.server;

import personalarmor.network.AbstractMessageHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public abstract class AbstractServerMessageHandler<T extends IMessage>
	extends AbstractMessageHandler<T>
{
	public final IMessage handleClientMessage (EntityPlayer player, T message, MessageContext context)
	{
		return null;
	}
}
