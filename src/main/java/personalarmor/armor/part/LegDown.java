package personalarmor.armor.part;

import personalarmor.material.IMaterial;

/**
 * Leg down armor part.
 *
 * @author soludev1
 */
public class LegDown
    extends AbstractPart
{
    public LegDown (IMaterial material)
    {
        super(material);
    }

    @Override
    protected float getBasePoint ()
    {
        return 40;
    }
    
    @Override
    public ShapedRecipe[] getShapedRecipes ()
    {
        return new ShapedRecipe[] {
        };
    }
}
