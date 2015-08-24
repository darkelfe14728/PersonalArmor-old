package personalarmor.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

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
}
