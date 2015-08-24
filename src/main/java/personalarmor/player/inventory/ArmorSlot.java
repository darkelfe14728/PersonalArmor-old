package personalarmor.player.inventory;

import personalarmor.PersonalArmor;
import personalarmor.armor.part.IArmorPart;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

/**
 * @author soludev1
 *
 * Slot about armor part
 */
public class ArmorSlot
    extends Slot
{
    private Class<? extends Item> type;
    
    /**
     * Create an armor slot
     * 
     * @param inventory Inventory that contains the slot
     * @param index     Index of slot in inventory
     * @param xPos      X position of slot
     * @param yPos      Y position of slot
     */
    public ArmorSlot (Class<? extends Item> type, IInventory inventory, int index, int xPos, int yPos)
    {
        super(inventory, index, xPos, yPos);
        this.type = type;
     
        /*setBackgroundIconTexture(
            new ResourceLocation(
                PersonalArmor.modMetadata.modId,
                "textures/gui/player/armor/" + type.getName().toLowerCase() + "/empty_slot.png"
            )
        );*/
    }
    
    @Override
    public boolean isItemValid (ItemStack stack)
    {
        return type.isAssignableFrom(stack.getItem().getClass());
    }
}
 