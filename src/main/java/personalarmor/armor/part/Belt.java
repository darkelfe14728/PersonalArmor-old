package personalarmor.armor.part;

import personalarmor.material.IMaterial;
import personalarmor.module.IModule;
import personalarmor.module.part.IApplicablePartBelt;

/**
 * Belt armor part
 *
 * @author soludev1
 */
public class Belt
    extends AbstractPart
{
    public Belt (IMaterial material)
    {
        super(material);
    }

    @Override
    protected float getBasePoint ()
    {
        return 90;
    }

    @Override
    public boolean moduleIsApplicable (IModule module)
    {
        return (module instanceof IApplicablePartBelt);
    }
    
    @Override
    public ShapedRecipe[] getShapedRecipes ()
    {
        return new ShapedRecipe[] {
        };
    }
}
