package personalarmor.player;

import personalarmor.network.PacketDispatcher;
import personalarmor.network.server.PacketOpenServerGui;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author soludev1
 *
 * Event handler about player sub-module.
 */
public class EventHandler
{
	/**
	 * Occurs when an entity is build.
	 * Here, register {@link ExtendedPlayer} has extended properties (for players only)
	 */
	@SubscribeEvent
	public void onEntityConstructing (EntityConstructing event)
	{
		// Only if building a player entity
		if(event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.entity;
			
			// Only if player doesn't already have PersonalArmorPlayer properties
			if(ExtendedPlayer.get(player) == null)
				ExtendedPlayer.register(player);
		}
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onGuiOpen (GuiOpenEvent event)
	{	    	    
	    if(event.gui instanceof GuiInventory)
	    {
            PacketDispatcher.sendToServer(new PacketOpenServerGui(PlayerModule.GUI_ARMOR));
	    }
	}
}
