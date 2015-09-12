package personalarmor.armor.part;

import personalarmor.material.IMaterial;

/**
 * Head armor part.
 *
 * @author soludev1
 */
public class Head
    extends AbstractPart
{
    public Head (IMaterial material)
    {
        super(material);
    }

    @Override
    protected float getBasePoint ()
    {
        return 50;
    }
    
    @Override
    public ShapedRecipe[] getShapedRecipes ()
    {
        return new ShapedRecipe[] {
        };
    }
}
