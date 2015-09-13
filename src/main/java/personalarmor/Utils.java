package personalarmor;

import net.minecraft.item.Item;

/**
 *
 *
 * @author soludev1
 */
public final class Utils
{
    public static String getItemName (Item item)
    {
        String name = item.getUnlocalizedName().substring(5);        // Skip the "item." at beginning
        
        // Also skip mod ID if present
        if(name.substring(0, PersonalArmor.MODID.length()).equalsIgnoreCase(PersonalArmor.MODID))
            name = name.substring(PersonalArmor.MODID.length() + 1);
        
        name = name.replace('.', '_');
        
        return name;
    }
}
