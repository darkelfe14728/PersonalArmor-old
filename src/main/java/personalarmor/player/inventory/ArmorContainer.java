package personalarmor.player.inventory;

//import personalarmor.armor.part.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * @author soludev1
 *
 * The container for the personal armor inventory
 */
public class ArmorContainer
    extends Container
{
    /**
     * Number of slot in one line.
     */
    private static final int LINE_SIZE = 9;
    
    /**
     * Number of line in standard inventory.
     */
    private static final int INV_LINE    = 4;
    /**
     * Number of slot in standard inventory.
     */
    private static final int INV_SIZE    = INV_LINE * LINE_SIZE;
    /**
     * Number of line in hotbar.
     */
    private static final int HOTBAR_LINE = 1;
    /**
     * Number of slot in hotbar.
     */
    private static final int HOTBAR_SIZE = HOTBAR_LINE * LINE_SIZE;
    
    /**
     * Armor inventory : start slot ID.
     */
    private static final int ARMOR_START = 0;
    /**
     * Armor inventory : end slot ID.
     */
    private static final int ARMOR_END = ARMOR_START + ArmorInventory.INVENTORY_SIZE -1;
    /**
     * Standard inventory : start slot ID.
     */
    private static final int INV_START = ARMOR_END + 1;
    /**
     * Standard inventory : end slot ID.
     */
    private static final int INV_END = INV_START + INV_SIZE - 1;
    /**
     * Hotbar inventory : start slot ID.
     */
    private static final int HOTBAR_START = INV_END + 1;
    /**
     * Hotbar inventory : end slot ID.
     */
    private static final int HOTBAR_END = HOTBAR_START + HOTBAR_SIZE - 1;
    
    /**
     * Initialize slots.
     */
    public ArmorContainer (EntityPlayer player, InventoryPlayer playerInventory, ArmorInventory armorInventory)
    {
        // Slots about armor (armor inventory)
        this.addSlotToContainer(new ArmorSlot(Item.class, armorInventory, ArmorInventory.SLOT_HEAD          , 38,   7));
        this.addSlotToContainer(new ArmorSlot(Item.class, armorInventory, ArmorInventory.SLOT_CHEST         , 38,  25));
        this.addSlotToContainer(new ArmorSlot(Item.class, armorInventory, ArmorInventory.SLOT_BACK          , 56,  25));
        this.addSlotToContainer(new ArmorSlot(Item.class, armorInventory, ArmorInventory.SLOT_ARM_LEFT      , 20,  25));
        this.addSlotToContainer(new ArmorSlot(Item.class, armorInventory, ArmorInventory.SLOT_ARM_RIGHT     , 74,  25));
        this.addSlotToContainer(new ArmorSlot(Item.class, armorInventory, ArmorInventory.SLOT_FOREARM_LEFT  , 20,  43));
        this.addSlotToContainer(new ArmorSlot(Item.class, armorInventory, ArmorInventory.SLOT_FOREARM_RIGHT , 74,  43));
        this.addSlotToContainer(new ArmorSlot(Item.class, armorInventory, ArmorInventory.SLOT_HAND_LEFT     , 20,  61));
        this.addSlotToContainer(new ArmorSlot(Item.class, armorInventory, ArmorInventory.SLOT_HAND_RIGHT    , 74,  61));
        this.addSlotToContainer(new ArmorSlot(Item.class, armorInventory, ArmorInventory.SLOT_BELT          , 38,  61));
        this.addSlotToContainer(new ArmorSlot(Item.class, armorInventory, ArmorInventory.SLOT_LEG_UP_LEFT   , 38,  79));
        this.addSlotToContainer(new ArmorSlot(Item.class, armorInventory, ArmorInventory.SLOT_LEG_UP_RIGHT  , 56,  79));
        this.addSlotToContainer(new ArmorSlot(Item.class, armorInventory, ArmorInventory.SLOT_LEG_DOWN_LEFT , 38,  97));
        this.addSlotToContainer(new ArmorSlot(Item.class, armorInventory, ArmorInventory.SLOT_LEG_DOWN_RIGHT, 56,  97));
        this.addSlotToContainer(new ArmorSlot(Item.class, armorInventory, ArmorInventory.SLOT_FOOT_LEFT     , 38, 115));
        this.addSlotToContainer(new ArmorSlot(Item.class, armorInventory, ArmorInventory.SLOT_FOOT_RIGHT    , 56, 115));
        
        // Slots about standard inventory (except armor slots)
            // Inventory slots
        for(int line = 0; line < INV_LINE; line++)
        {
            for(int column = 0; column < LINE_SIZE; column++)
            {
                this.addSlotToContainer(new Slot(
                    playerInventory,
                    ArmorInventory.INVENTORY_SIZE + line * 9 + column,
                    7 + column * 18, 
                    138 + line * 18
                 ));
            }
        }
            // Hotbar slots
        for(int line = 0; line < HOTBAR_LINE; line++)
        {
            for(int column = 0; column < LINE_SIZE; column++)
            {
                this.addSlotToContainer(new Slot(
                    playerInventory,
                    ArmorInventory.INVENTORY_SIZE + INV_SIZE + 9 * 4,
                    7 + column * 18,
                    196 + line * 18
                ));
            }
        }
    }
    
    @Override
    public boolean canInteractWith (EntityPlayer player)
    {
        return true;
    }
    /**
     * Occurs when a player shift-click on a slot.
     * Here perform transfer slot content from armor inventory to standard inventory or hotbar and reverse.
     * 
     * @param player  The player who shift-click.
     * @param slot_id The shit-clicked slot ID
     */
    @Override
    public ItemStack transferStackInSlot (EntityPlayer player, int slot_id)
    {
        ItemStack stack = null;
        Slot slot = (Slot)this.inventorySlots.get(slot_id);
        
        // Only if something to transfer
        if(slot != null & slot.getHasStack())
        {
            ItemStack stack_transfer = slot.getStack();
            stack = stack_transfer.copy();
            
            if(slot_id >= ARMOR_START && slot_id <= ARMOR_END)
            {
                // Original slot in armor inventory => transfer to standard inventory or hotbar
                // The fourth parameter is set to true to transfer to hotbar prior to standard inventory
                if(this.mergeItemStack(stack_transfer, INV_START, HOTBAR_END, true))
                    return null;
                
                slot.onSlotChange(stack_transfer, stack);
            }
            else
            {
                // Original slot in standard inventory or hotbar
                boolean find = false;
                
                // First, try to transfer to armor inventory
                for(int armor_slot_id = ARMOR_START; armor_slot_id <= ARMOR_END; armor_slot_id++)
                {
                    ArmorSlot armor_slot = (ArmorSlot)this.inventorySlots.get(armor_slot_id);
                    
                    if(armor_slot.isItemValid(stack_transfer))
                    {
                        if(!this.mergeItemStack(stack_transfer, armor_slot_id, armor_slot_id, false))
                            return null;
                        
                        find = true;
                    }
                }
                
                if(!find)           // No valid slot in armor inventory
                {
                    if(slot_id >= INV_START && slot_id <= INV_END)
                    {
                        // Original slot in standard inventory => transfer to hotbar
                        if(!this.mergeItemStack(stack_transfer, HOTBAR_START, HOTBAR_END, false))
                            return null;
                    }
                    else if(slot_id >= HOTBAR_START && slot_id <= HOTBAR_END)
                    {
                        // Original slot in hotbar => transfer to standard inventory
                        if(!this.mergeItemStack(stack_transfer, INV_START, INV_END, false))
                            return null;
                    }
                    else
                        return null;        // Impossible : slot is out bound
                }
            }
            
            if(stack_transfer.stackSize == 0)
                slot.putStack((ItemStack)null);     // All the stack is transfer, ensure original slot is NULL
            else
                slot.onSlotChanged();
            
            if(stack_transfer.stackSize == stack.stackSize)
                return null;                        // Nothing transfered
            
            slot.onPickupFromSlot(player, stack_transfer);
        }
        
        return stack;
    }
}
