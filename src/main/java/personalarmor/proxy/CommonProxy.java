package personalarmor.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import personalarmor.player.ExtendedPlayer;
import personalarmor.player.PlayerModule;
import personalarmor.player.inventory.ArmorContainer;
import personalarmor.player.inventory.ArmorGui;

public class CommonProxy
    implements IGuiHandler
{
	public void registerRenderers () {}

    public EntityPlayer getEntityPlayer (MessageContext context)
    {
        return context.getServerHandler().playerEntity;
    }
	
	@Override
	public Object getServerGuiElement (int guiID, EntityPlayer player, World world, int x, int y, int z)
	{
	    if(guiID == PlayerModule.GUI_ARMOR)
	        return new ArmorContainer(player, player.inventory, ExtendedPlayer.get(player).armorInventory);
	    else
	        return null;
	}
	@Override
	public Object getClientGuiElement (int guiID, EntityPlayer player, World world, int x, int y, int z)
	{
	    if(guiID == PlayerModule.GUI_ARMOR)
	        return new ArmorGui(player, player.inventory, ExtendedPlayer.get(player).armorInventory);
	    else
	        return null;
	}
}
