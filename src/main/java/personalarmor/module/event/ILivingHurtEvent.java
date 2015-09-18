package personalarmor.module.event;

import net.minecraftforge.event.entity.living.LivingHurtEvent;

/**
 * Module event fire when LivingHurtEvent occurs
 *
 * @author soludev1
 */
public interface ILivingHurtEvent
{
    public void onLivingHurt (LivingHurtEvent event);
}
