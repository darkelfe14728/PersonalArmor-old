package personalarmor.module.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import personalarmor.module.IModule;
import personalarmor.player.ExtendedPlayer;

/**
 * The event handler for module events
 *
 * @author soludev1
 */
public class ModuleEventHandler
{
    @SubscribeEvent(priority = EventPriority.LOWEST, receiveCanceled = true)
    public void onLivingHurtEvent (LivingHurtEvent event)
    {
        if(!(event.entityLiving instanceof EntityPlayer))
            return;
        
        EntityPlayer player = (EntityPlayer)event.entityLiving;
        ExtendedPlayer inventory = ExtendedPlayer.get(player);
        
        IModule[] modules = inventory.getEventCatchModules(ILivingHurtEvent.class);
        for(IModule module : modules)
            ((ILivingHurtEvent)module).onLivingHurt(event);
    }
}
