package personalarmor.player.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

/**
 * @author soludev1
 *
 * The container for the personal armor inventory
 */
public class PAContainer
    extends Container
{
    /**
     * 
     */
    public PAContainer ()
    {
        // TODO Auto-generated constructor stub
        
    }

    /* (non-Javadoc)
     * @see net.minecraft.inventory.Container#canInteractWith(net.minecraft.entity.player.EntityPlayer)
     */
    @Override
    public boolean canInteractWith (EntityPlayer p_75145_1_)
    {
        // TODO Auto-generated method stub
        return false;
    }

}
