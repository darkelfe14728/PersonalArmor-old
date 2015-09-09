package personalarmor.armor;

import net.minecraft.item.Item;
import personalarmor.armor.part.IPart;

/**
 * An armor part item.
 *
 * @author soludev1
 */
public class ArmorItem<TPart extends IPart>
    extends Item
{
    protected final TPart part;

    public ArmorItem (TPart part)
    {
        this.part = part;

        this.setMaxStackSize(1);
        this.setCreativeTab(ArmorModule.tabs.get("armor"));
        this.setUnlocalizedName("armor." + part.getUnlocalizedName());
    }
}
