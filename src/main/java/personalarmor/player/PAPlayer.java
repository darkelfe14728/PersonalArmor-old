package personalarmor.player;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class PAPlayer
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
	private final EntityPlayer player;
	
	/**
	 * Create extended properties for the given player.
	 * 
	 * @param player The referenced player for the extended properties.
	 */
	public PAPlayer (EntityPlayer player)
	{
		this.player = player;
	}
	@Override
	public void init(Entity entity, World world)
	{
		//player = (EntityPlayer)entity;   => done in constructor
	}
	
	/**
	 * Register {@link PAPlayer} has extended properties for the given player.
	 * 
	 * @param player The player to extends.
	 */
	public static final void register (EntityPlayer player)
	{
		player.registerExtendedProperties(PAPlayer.PROP_NAME, new PAPlayer(player));
	}
	/**
	 * Get the {@link PAPlayer} extended properties of the given player.
	 * 
	 * @param player The extended player.
	 * 
	 * @return The {@link PAPlayer} extended properties.
	 */
	public static final PAPlayer get (EntityPlayer player)
	{
		return (PAPlayer)player.getExtendedProperties(PAPlayer.PROP_NAME);
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
		
		compound.setTag(PAPlayer.PROP_NAME, properties);
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
