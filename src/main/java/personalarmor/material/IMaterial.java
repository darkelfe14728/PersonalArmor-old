package personalarmor.material;

import net.minecraft.item.ItemStack;

/**
 * A generic material.
 * 
 * @author soludev1
 */
public interface IMaterial
{
    public float getFactorEnergy ();
    public float getFactorSpace  ();
    public float getFactorWeight ();
    
    /**
     * @return Unlocalized name.
     */
    public String getUnlocalizedName ();

    public ItemStack[] getShapedRecipeMaterials ();
}
