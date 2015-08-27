package personalarmor.player;

import personalarmor.network.PacketDispatcher;
import personalarmor.network.server.PacketOpenServerGui;
import personalarmor.player.inventory.ArmorContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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
	public void guiPostAction (GuiScreenEvent.ActionPerformedEvent event)
	{
	    // Game is not focus ? => stop here
	    if(!FMLClientHandler.instance().getClient().inGameHasFocus)
	        return;
	    
	    EntityPlayer player = event.gui.mc.thePlayer;
	    if(player.openContainer != null && player.openContainer instanceof ArmorContainer)
	        player.closeScreen();                          // ArmorGui open => close it
	    else
	        PacketDispatcher.sendToPlayer(new PacketOpenServerGui(PlayerModule.GUI_ARMOR), (EntityPlayerMP)player);
	}
}
