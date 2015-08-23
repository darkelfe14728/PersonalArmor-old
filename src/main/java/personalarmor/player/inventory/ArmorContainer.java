package personalarmor.player.inventory;

import personalarmor.armor.part.HeadPart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

/**
 * @author soludev1
 *
 * The container for the personal armor inventory
 */
public class ArmorContainer
    extends Container
{
    /**
     * Initialize slots.
     */
    public ArmorContainer (EntityPlayer player, InventoryPlayer playerInventory, CustomInventory customInventory)
    {
        // Slots about armor (custom inventory)
        this.addSlotToContainer(new ArmorSlot(HeadPart.class, customInventory, CustomInventory.SLOT_HEAD          , 38,   7));
        this.addSlotToContainer(new ArmorSlot(HeadPart.class, customInventory, CustomInventory.SLOT_CHEST         , 38,  25));
        this.addSlotToContainer(new ArmorSlot(HeadPart.class, customInventory, CustomInventory.SLOT_BACK          , 56,  25));
        this.addSlotToContainer(new ArmorSlot(HeadPart.class, customInventory, CustomInventory.SLOT_ARM_LEFT      , 20,  25));
        this.addSlotToContainer(new ArmorSlot(HeadPart.class, customInventory, CustomInventory.SLOT_ARM_RIGHT     , 74,  25));
        this.addSlotToContainer(new ArmorSlot(HeadPart.class, customInventory, CustomInventory.SLOT_FOREARM_LEFT  , 20,  43));
        this.addSlotToContainer(new ArmorSlot(HeadPart.class, customInventory, CustomInventory.SLOT_FOREARM_RIGHT , 74,  43));
        this.addSlotToContainer(new ArmorSlot(HeadPart.class, customInventory, CustomInventory.SLOT_HAND_LEFT     , 20,  61));
        this.addSlotToContainer(new ArmorSlot(HeadPart.class, customInventory, CustomInventory.SLOT_HAND_RIGHT    , 74,  61));
        this.addSlotToContainer(new ArmorSlot(HeadPart.class, customInventory, CustomInventory.SLOT_BELT          , 38,  61));
        this.addSlotToContainer(new ArmorSlot(HeadPart.class, customInventory, CustomInventory.SLOT_LEG_UP_LEFT   , 38,  79));
        this.addSlotToContainer(new ArmorSlot(HeadPart.class, customInventory, CustomInventory.SLOT_LEG_UP_RIGHT  , 56,  79));
        this.addSlotToContainer(new ArmorSlot(HeadPart.class, customInventory, CustomInventory.SLOT_LEG_DOWN_LEFT , 38,  97));
        this.addSlotToContainer(new ArmorSlot(HeadPart.class, customInventory, CustomInventory.SLOT_LEG_DOWN_RIGHT, 56,  97));
        this.addSlotToContainer(new ArmorSlot(HeadPart.class, customInventory, CustomInventory.SLOT_FOOT_LEFT     , 38, 115));
        this.addSlotToContainer(new ArmorSlot(HeadPart.class, customInventory, CustomInventory.SLOT_FOOT_RIGHT    , 56, 115));
        
        // Slots about standard inventory (except armor slots)
            // Inventory slots
        for(int line = 0; line < 4; line++)
        {
            for(int column = 0; column < 9; column++)
            {
                this.addSlotToContainer(new Slot(
                    playerInventory,
                    CustomInventory.INVENTORY_SIZE + line * 9 + column,
                    7 + column * 18, 
                    138 + line * 18
                 ));
            }
        }
            // Hotbar slots
        for(int column = 0; column < 9; column++)
        {
            this.addSlotToContainer(new Slot(
                playerInventory,
                CustomInventory.INVENTORY_SIZE + 9 * 4,
                7 + column * 18,
                196
            ));
        }
    }
    
    @Override
    public boolean canInteractWith (EntityPlayer p_75145_1_)
    {
        // TODO Auto-generated method stub
        return false;
    }

}
