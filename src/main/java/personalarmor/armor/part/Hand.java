package personalarmor.armor.part;

import personalarmor.material.IMaterial;

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
    public ShapedRecipe[] getShapedRecipes ()
    {
        return new ShapedRecipe[] {
        };
    }
}
