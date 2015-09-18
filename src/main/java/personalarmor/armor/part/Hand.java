package personalarmor.armor.part;

import personalarmor.material.IMaterial;
import personalarmor.module.IModule;
import personalarmor.module.part.IApplicablePartHand;

/**
 * Hand armor part.
 *
 * @author soludev1
 */
public class Hand
    extends AbstractPart
{
    public Hand (IMaterial material)
    {
        super(material);
    }

    @Override
    protected float getBasePoint ()
    {
        return 20;
    }

    @Override
    public boolean moduleIsApplicable (IModule module)
    {
        return (module instanceof IApplicablePartHand);
    }
    
    @Override
    public ShapedRecipe[] getShapedRecipes ()
    {
        return new ShapedRecipe[] {
        };
    }
}
