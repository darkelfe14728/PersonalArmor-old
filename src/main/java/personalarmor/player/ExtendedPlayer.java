package personalarmor.player;

import java.util.ArrayList;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import personalarmor.armor.ArmorItem;
import personalarmor.module.IModule;
import personalarmor.player.inventory.ArmorInventory;

public class ExtendedPlayer
    implements IExtendedEntityProperties
{
    /**
     * Unique name for this extended properties.
     * Also use as NBT Compound Tag name.
     */
    public static final String PROP_NAME = "PersonalArmor";
    
    /**
     * The entity witch extend properties.
     * This class apply to a player, so it's a player entity. 
     */
    @SuppressWarnings("unused")
    private final EntityPlayer player;
    
    /**
     * Armor parts
     */
    public final ArmorInventory armorInventory = new ArmorInventory();
    
    /**
     * Create extended properties for the given player.
     * 
     * @param player The referenced player for the extended properties.
     */
    public ExtendedPlayer (EntityPlayer player)
    {
        this.player = player;
    }
    @Override
    public void init(Entity entity, World world)
    {
        //player = (EntityPlayer)entity;   => done in constructor
    }
    
    /**
     * Register {@link ExtendedPlayer} has extended properties for the given player.
     * 
     * @param player The player to extends.
     */
    public static final void register (EntityPlayer player)
    {
        player.registerExtendedProperties(ExtendedPlayer.PROP_NAME, new ExtendedPlayer(player));
    }
    /**
     * Get the {@link ExtendedPlayer} extended properties of the given player.
     * 
     * @param player The extended player.
     * 
     * @return The {@link ExtendedPlayer} extended properties.
     */
    public static final ExtendedPlayer get (EntityPlayer player)
    {
        return (ExtendedPlayer)player.getExtendedProperties(ExtendedPlayer.PROP_NAME);
    }
 
    /**
     * Get list of modules (present in any armor part of the player) witch catch the given event.
     * 
     * @param event The event type to catch.
     * @return List of matching modules.
     */
    public IModule[] getEventCatchModules (Class<?> event)
    {
        ArrayList<IModule> validModules = new ArrayList<IModule>();
        
        for(int slot = 0; slot < armorInventory.getSizeInventory(); slot++)
        {
            ArmorItem<?> item = (ArmorItem<?>)(armorInventory.getStackInSlot(slot).getItem());
            IModule[] modules = item.getPart().getModules();
            
            for(IModule module : modules)
            {
                if(event.isAssignableFrom(module.getClass()))
                    validModules.add(module);
            }
        }
        
        return validModules.toArray(new IModule[validModules.size()]);
    }
    
    /**
     * Save properties in player NBT tag.
     * 
     * @param compound The player NBT tag.
     */
    @Override
    public void saveNBTData(NBTTagCompound compound)
    {
        NBTTagCompound properties = new NBTTagCompound();
        armorInventory.writeToNBT(properties);
        
        compound.setTag(ExtendedPlayer.PROP_NAME, properties);
    }
    /**
     * Load properties from player NBT tag.
     * 
     * @param compound The player NBT tag.
     */
    @Override
    public void loadNBTData(NBTTagCompound compound) 
    {
        NBTTagCompound properties = (NBTTagCompound)compound.getTag(PROP_NAME);
        armorInventory.loadNBTData(properties);
    }
}
