package personalarmor.armor;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import personalarmor.IShapedCrafting;
import personalarmor.armor.part.IPart;
import personalarmor.armor.part.IPart.ShapedRecipe;

/**
 * An armor part item.
 *
 * @author soludev1
 */
public class ArmorItem<TPart extends IPart>
    extends Item
    implements IShapedCrafting
{
    protected final TPart part;

    public ArmorItem (TPart part)
    {
        this.part = part;

        this.setMaxStackSize(1);
        this.setCreativeTab(ArmorModule.tabs.get("armor"));
        this.setUnlocalizedName("armor." + part.getUnlocalizedName());
    }

    @Override
    public void registerShapedRecipes ()
    {
        for(ShapedRecipe recipe : part.getShapedRecipes())
        {
            ItemStack[] materials = part.getMaterial().getShapedRecipeMaterials();
            
            GameRegistry.addShapedRecipe(
                new ItemStack(this, recipe.getAmount()),
                recipe.getModel(),
                "1", materials[0]
            );
        }
    }
}
