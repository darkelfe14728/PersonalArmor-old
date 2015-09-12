package personalarmor.armor.part;

import personalarmor.material.IMaterial;

/**
 * Chest armor part.
 *
 * @author soludev1
 */
public class Chest
    extends AbstractPart
{
    public Chest (IMaterial material)
    {
        super(material);
    }

    @Override
    protected float getBasePoint ()
    {
        return 8;
    }
    
    @Override
    public ShapedRecipe[] getShapedRecipes ()
    {
        return new ShapedRecipe[] {
            new ShapedRecipe()
            {
                @Override
                public String[] getModel ()
                {
                    return new String[] {
                        "1 1",
                        "111",
                        "111"
                    };
                }
            }
        };
    }
}
