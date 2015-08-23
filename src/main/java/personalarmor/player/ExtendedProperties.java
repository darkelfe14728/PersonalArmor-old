package personalarmor.player;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedProperties
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
	 * Create extended properties for the given player.
	 * 
	 * @param player The referenced player for the extended properties.
	 */
	public ExtendedProperties (EntityPlayer player)
	{
		this.player = player;
	}
	@Override
	public void init(Entity entity, World world)
	{
		//player = (EntityPlayer)entity;   => done in constructor
	}
	
	/**
	 * Register {@link ExtendedProperties} has extended properties for the given player.
	 * 
	 * @param player The player to extends.
	 */
	public static final void register (EntityPlayer player)
	{
		player.registerExtendedProperties(ExtendedProperties.PROP_NAME, new ExtendedProperties(player));
	}
	/**
	 * Get the {@link ExtendedProperties} extended properties of the given player.
	 * 
	 * @param player The extended player.
	 * 
	 * @return The {@link ExtendedProperties} extended properties.
	 */
	public static final ExtendedProperties get (EntityPlayer player)
	{
		return (ExtendedProperties)player.getExtendedProperties(ExtendedProperties.PROP_NAME);
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
		
		compound.setTag(ExtendedProperties.PROP_NAME, properties);
	}
	/**
	 * Load properties from player NBT tag.
	 * 
	 * @param compound The player NBT tag.
	 */
	@Override
	public void loadNBTData(NBTTagCompound compound) 
	{
		//NBTTagCompound properties = (NBTTagCompound)compound.getTag(PersonalArmorPlayer.PROP_NAME);
		
	}
}
