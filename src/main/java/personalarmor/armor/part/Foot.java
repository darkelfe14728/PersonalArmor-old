package personalarmor.armor.part;

import personalarmor.material.IMaterial;

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
    public ShapedRecipe[] getShapedRecipes ()
    {
        return new ShapedRecipe[] {
        };
    }
}
