package personalarmor.proxy;

import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class ClientProxy
	extends CommonProxy
{
	 @Override
	 public void registerRenderers() {}

	 @Override
	 public EntityPlayer getEntityPlayer (MessageContext context)
	 {
		 if(context.side.isClient())
			 return Minecraft.getMinecraft().thePlayer;
		 else
			 return super.getEntityPlayer(context);
	 }
}
