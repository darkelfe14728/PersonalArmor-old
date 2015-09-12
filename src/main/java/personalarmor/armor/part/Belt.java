package personalarmor.armor.part;

import personalarmor.material.IMaterial;

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
    public ShapedRecipe[] getShapedRecipes ()
    {
        return new ShapedRecipe[] {
        };
    }
}
