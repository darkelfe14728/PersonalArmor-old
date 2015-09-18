package personalarmor.armor.part;

import personalarmor.material.IMaterial;
import personalarmor.module.IModule;
import personalarmor.module.part.IApplicablePartArm;

/**
 * Arm armor part.
 *
 * @author soludev1
 */
public class Arm
    extends AbstractPart
{
    public Arm (IMaterial material)
    {
        super(material);
    }

    @Override
    protected float getBasePoint ()
    {
        return 30;
    }
    
    @Override
    public boolean moduleIsApplicable (IModule module)
    {
        return (module instanceof IApplicablePartArm);
    }
    
    @Override
    public ShapedRecipe[] getShapedRecipes ()
    {
        return new ShapedRecipe[] {
        };
    }
}
