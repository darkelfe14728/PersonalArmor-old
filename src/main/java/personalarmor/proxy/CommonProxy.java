package personalarmor.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class CommonProxy implements IGuiHandler
{
	public void registerRenderers () {}
	
	@Override
	public Object getServerGuiElement (int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}
	@Override
	public Object getClientGuiElement (int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}

	public EntityPlayer getEntityPlayer (MessageContext context)
	{
		return context.getServerHandler().playerEntity;
	}
}
