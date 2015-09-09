package personalarmor.armor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Armor creative tab.
 *
 * @author soludev1
 */
public class ArmorTab
    extends CreativeTabs
{
    public ArmorTab ()
    {
        super("armor");
    }

    @Override
    public Item getTabIconItem ()
    {
        return null;
    }
}
