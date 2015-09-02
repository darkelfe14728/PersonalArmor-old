package personalarmor.player;

import personalarmor.LogHelper;
import personalarmor.network.PacketDispatcher;
import personalarmor.network.server.PacketOpenServerGui;
import personalarmor.player.inventory.ArmorContainer;
import personalarmor.player.inventory.ArmorGui;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.GuiScreenEvent;
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
	    LogHelper.info("GUI open event");
	    	    
	    if(event.gui instanceof GuiInventory)
	    {
	        LogHelper.info("Standard Inventory GUI");
            PacketDispatcher.sendToServer(new PacketOpenServerGui(PlayerModule.GUI_ARMOR));
	    }
	    /*else if(event.gui instanceof ArmorGui)
	    {
	        LogHelper.info("PersonalArmor Inventory GUI");
	        
	        EntityPlayer player = event.gui.mc.thePlayer;
	        LogHelper.info("Involved player : " + player.getName());
	        
	        player.closeScreen();
	    }*/
	}
	/*@SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void guiPostAction (GuiScreenEvent.ActionPerformedEvent.Post event)
    {
        LogHelper.info("Post GUI action");
        if(!(event.gui instanceof ArmorGui))
        {
            LogHelper.warn("Not a ArmorGUI");
            return;
        }
        
        EntityPlayer player = event.gui.mc.thePlayer;
        LogHelper.info("Involved player : " + player.getName());
        LogHelper.info("Must close ? " + (player.openContainer != null && player.openContainer instanceof ArmorContainer ? "Yes" : "No"));
        if(player.openContainer != null && player.openContainer instanceof ArmorContainer)
            player.closeScreen();                          // ArmorGui open => close it
        else
            PacketDispatcher.sendToPlayer(new PacketOpenServerGui(PlayerModule.GUI_ARMOR), (EntityPlayerMP)player);
    }*/
}
