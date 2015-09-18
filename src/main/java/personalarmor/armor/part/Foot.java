package personalarmor.armor.part;

import personalarmor.material.IMaterial;
import personalarmor.module.IModule;
import personalarmor.module.part.IApplicablePartFoot;

/**
 * Foot armor part.
 *
 * @author soludev1
 */
public class Foot
    extends AbstractPart
{
    public Foot (IMaterial material)
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
        return (module instanceof IApplicablePartFoot);
    }
    
    @Override
    public ShapedRecipe[] getShapedRecipes ()
    {
        return new ShapedRecipe[] {
        };
    }
}
