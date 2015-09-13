package personalarmor.proxy;

import java.util.Map.Entry;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import personalarmor.AbstractModule;
import personalarmor.LogHelper;
import personalarmor.PersonalArmor;

public class ClientProxy
	extends CommonProxy
{
	 @Override
	 public void registerRenderers()
	 {
	     for(Entry<String, AbstractModule> module : PersonalArmor.modules.entrySet())
	     {
	         LogHelper.startBlock(module.getKey());
	         module.getValue().registerRenderers();
	         LogHelper.stopBlock();
	     }
	 }

	 @Override
	 public EntityPlayer getEntityPlayer (MessageContext context)
	 {
		 if(context.side.isClient())
			 return Minecraft.getMinecraft().thePlayer;
		 else
			 return super.getEntityPlayer(context);
	 }
}
