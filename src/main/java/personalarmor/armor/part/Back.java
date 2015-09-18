package personalarmor.armor.part;

import personalarmor.material.IMaterial;
import personalarmor.module.IModule;
import personalarmor.module.part.IApplicablePartBack;

/**
 * Back armor part.
 *
 * @author soludev1
 */
public class Back
    extends AbstractPart
{
    public Back (IMaterial material)
    {
        super(material);
    }

    @Override
    protected float getBasePoint ()
    {
        return 100;
    }

    @Override
    public boolean moduleIsApplicable (IModule module)
    {
        return (module instanceof IApplicablePartBack);
    }
    
    @Override
    public ShapedRecipe[] getShapedRecipes ()
    {
        return new ShapedRecipe[] {
        };
    }
}
