package personalarmor.material;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Basic wood.
 *
 * @author soludev1
 */
public class Wood
    extends AbstractMaterial
{
    @Override
    public float getFactorEnergy ()
    {
        return 0;
    }
    @Override
    public float getFactorSpace ()
    {
        return 1;
    }
    @Override
    public float getFactorWeight ()
    {
        return 1;
    }
    
    @Override
    public ItemStack[] getShapedRecipeMaterials ()
    {
        return new ItemStack[] {
            new ItemStack(Blocks.planks, 1, OreDictionary.WILDCARD_VALUE)
        };
    }
}
