package personalarmor.armor.part;

import personalarmor.material.IMaterial;
import personalarmor.module.IModule;
import personalarmor.module.part.IApplicablePartForearm;

/**
 * Forearm armor part.
 *
 * @author soludev1
 */
public class Forearm
    extends AbstractPart
{
    public Forearm (IMaterial material)
    {
        super(material);
    }

    @Override
    protected float getBasePoint ()
    {
        return 40;
    }

    @Override
    public boolean moduleIsApplicable (IModule module)
    {
        return (module instanceof IApplicablePartForearm);
    }
    
    @Override
    public ShapedRecipe[] getShapedRecipes ()
    {
        return new ShapedRecipe[] {
        };
    }
}
