package personalarmor.player.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

/**
 * @author soludev1
 *
 * The "inventory" containing personal armor parts.
 */
public class ArmorInventory
    implements IInventory
{
    /**
     * Inventory name.
     */
    private final String name     = "PersonalArmor Inventory";
    /**
     * Inventory NBT tag name.
     */
    private final String name_tag = "PersonalArmorInventory";
    
    private static final String NBT_SLOT = "Slot";
    
    /**
     * Inventory size.
     */
    public static final int INVENTORY_SIZE = 16;
    
    /**
     * Slot ID for head armor.
     */
    public static final int SLOT_HEAD           =  0;
    /**
     * Slot ID for chest armor.
     */
    public static final int SLOT_CHEST          =  1;
    /**
     * Slot ID for back armor.
     */
    public static final int SLOT_BACK           = 15;
    /**
     * Slot ID for left arm armor.
     */
    public static final int SLOT_ARM_LEFT       =  2;
    /**
     * Slot ID for right arm armor.
     */
    public static final int SLOT_ARM_RIGHT      =  3;
    /**
     * Slot ID for left forearm armor.
     */
    public static final int SLOT_FOREARM_LEFT   =  4;
    /**
     * Slot ID for right forearm armor.
     */
    public static final int SLOT_FOREARM_RIGHT  =  5;
    /**
     * Slot ID for left hand armor.
     */
    public static final int SLOT_HAND_LEFT      =  6;
    /**
     * Slot ID for right hand armor.
     */
    public static final int SLOT_HAND_RIGHT     =  7;
    /**
     * Slot ID for belt armor.
     */
    public static final int SLOT_BELT           =  8;
    /**
     * Slot ID for left up leg armor.
     */
    public static final int SLOT_LEG_UP_LEFT    =  9;
    /**
     * Slot ID for right up leg armor.
     */
    public static final int SLOT_LEG_UP_RIGHT   = 10;
    /**
     * Slot ID for left down leg armor.
     */
    public static final int SLOT_LEG_DOWN_LEFT  = 11;
    /**
     * Slot ID for right down leg armor.
     */
    public static final int SLOT_LEG_DOWN_RIGHT = 12;
    /**
     * Slot ID for left foot armor.
     */
    public static final int SLOT_FOOT_LEFT      = 13;
    /**
     * Slot ID for right foot armor.
     */
    public static final int SLOT_FOOT_RIGHT     = 14;
    
    /**
     * The underlined inventory.
     */
    private ItemStack[] inventory = new ItemStack[ArmorInventory.INVENTORY_SIZE];
 
    public ArmorInventory ()
    {}
    
    @Override
    public int getSizeInventory ()
    {
        return this.inventory.length;
    }

    @Override
    public ItemStack getStackInSlot (int slot)
    {
        return this.inventory[slot];
    }
    @Override
    public ItemStack decrStackSize (int slot, int amount)
    {
        ItemStack stack = this.getStackInSlot(slot);
        if(stack != null)
        {
            if(stack.stackSize > amount)
                stack = stack.splitStack(amount);
            else
                this.setInventorySlotContents(slot, null);
            
            this.markDirty();
        }
        
        return stack;
    }
    @Override
    public ItemStack getStackInSlotOnClosing (int slot)
    {
        ItemStack stack = this.getStackInSlot(slot);
        if(stack != null)
            this.setInventorySlotContents(slot, null);
        
        return stack;
    }
    @Override
    public void setInventorySlotContents (int slot, ItemStack stack)
    {
        this.inventory[slot] = stack;
        
        if(stack != null && stack.stackSize > this.getInventoryStackLimit())
            stack.stackSize = this.getInventoryStackLimit();
        
        this.markDirty();
    }

    @Override
    public String getName ()
    {
        return this.name;
    }
    @Override
    public boolean hasCustomName ()
    {
        return this.name.length() > 0;
    }
    @Override
    public IChatComponent getDisplayName ()
    {
        return new ChatComponentText(this.name);
    }

    @Override
    public int getInventoryStackLimit ()
    {
        return 1;
    }

    @Override
    public void markDirty ()
    {
        for(int slot = 0; slot < this.getSizeInventory(); slot++)
        {
            if(this.getStackInSlot(slot) != null && this.getStackInSlot(slot).stackSize == 0)
                this.setInventorySlotContents(slot, null);
        }
    }

    @Override
    public boolean isUseableByPlayer (EntityPlayer player)
    {
        return true;
    }

    @Override
    public boolean isItemValidForSlot (int slot, ItemStack stack)
    {
        switch(slot)
        {
            case ArmorInventory.SLOT_HEAD:
                return (stack.getItem() instanceof Item);
                
            case ArmorInventory.SLOT_CHEST:
                return (stack.getItem() instanceof Item);
                
            case ArmorInventory.SLOT_BACK:
                return (stack.getItem() instanceof Item);
                
            case ArmorInventory.SLOT_ARM_LEFT:
            case ArmorInventory.SLOT_ARM_RIGHT:
                return (stack.getItem() instanceof Item);
                
            case ArmorInventory.SLOT_FOREARM_LEFT:
            case ArmorInventory.SLOT_FOREARM_RIGHT:
                return (stack.getItem() instanceof Item);
                
            case ArmorInventory.SLOT_HAND_LEFT:
            case ArmorInventory.SLOT_HAND_RIGHT:
                return (stack.getItem() instanceof Item);
                
            case ArmorInventory.SLOT_BELT:
                return (stack.getItem() instanceof Item);
                
            case ArmorInventory.SLOT_LEG_UP_LEFT:
            case ArmorInventory.SLOT_LEG_UP_RIGHT:
                return (stack.getItem() instanceof Item);
                
            case ArmorInventory.SLOT_LEG_DOWN_LEFT:
            case ArmorInventory.SLOT_LEG_DOWN_RIGHT:
                return (stack.getItem() instanceof Item);
                
            case ArmorInventory.SLOT_FOOT_LEFT:
            case ArmorInventory.SLOT_FOOT_RIGHT:
                return (stack.getItem() instanceof Item);
        }
        
        return false;
    }

    /**
     * Save inventory in the container NBT tag
     * 
     * @param compound The container NBT tag
     */
    public void writeToNBT (NBTTagCompound compound)
    {
        NBTTagList items = new NBTTagList();
        
        for(int slot = 0; slot < this.getSizeInventory(); slot++)
        {
            if(this.getStackInSlot(slot) != null)
            {
                NBTTagCompound item = new NBTTagCompound();
                item.setByte(NBT_SLOT, (byte)slot);
                this.getStackInSlot(slot).writeToNBT(item);
                
                items.appendTag(item);
            }
        }
        
        compound.setTag(this.name_tag, items);
    }
    /**
     * Load properties from container NBT tag.
     * 
     * @param compound The container NBT tag.
     */
    public void loadNBTData(NBTTagCompound compound) 
    {
        NBTTagList items = compound.getTagList(this.name_tag, compound.getId());
        for(int item_id = 0; item_id < items.tagCount(); item_id++)
        {
            NBTTagCompound item =  items.getCompoundTagAt(item_id);
            int slot = item.getByte(NBT_SLOT);
            if(slot >= 0 && slot < this.getSizeInventory())
                this.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
        }
    }

    


    @Override
    public void openInventory (EntityPlayer player) {}

    @Override
    public void closeInventory (EntityPlayer player) {}

    
    @Override
    public int getField (int id)
    {
        return 0;
    }

    @Override
    public void setField (int id, int value){}

    @Override
    public int getFieldCount ()
    {
        return 0;
    }

    @Override
    public void clear ()
    {
        for(int slot = 0; slot < inventory.length; slot++)
            inventory[slot] = null;
    }
}
