package personalarmor.module;

import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import personalarmor.module.event.ILivingHurtEvent;
import personalarmor.module.part.IApplicablePartFoot;
import personalarmor.module.part.IApplicablePartFullLeg;

/**
 * A module to absorb fall damage.
 *
 * @author soludev1
 */
public class FallAbsorber
    implements IModule,
               ILivingHurtEvent,
               IApplicablePartFullLeg, IApplicablePartFoot
{
    @Override
    public float getUseSpace ()
    {
        return 0;
    }
    @Override
    public float getUseEnergy ()
    {
        return 0;
    }
    @Override
    public float getUseWeight ()
    {
        return 0;
    }
    
    @Override
    public void onLivingHurt (LivingHurtEvent event)
    {
        if(event.source == DamageSource.fall)
            event.setCanceled(true);
    }
}
