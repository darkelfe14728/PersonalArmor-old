package personalarmor;

import personalarmor.player.PAPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PAHandler
{
	/**
	 * Occurs when an entity is build.
	 * Here, register {@link PAPlayer} has extended properties (for players only)
	 */
	@SubscribeEvent
	public void onEntityConstructing (EntityConstructing event)
	{
		// Only if building a player entity
		if(event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.entity;
			
			// Only if player doesn't already have PersonalArmorPlayer properties
			if(PAPlayer.get(player) == null)
				PAPlayer.register(player);
		}
	}
}
