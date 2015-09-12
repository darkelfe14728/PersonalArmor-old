package personalarmor.armor.part;

import personalarmor.material.IMaterial;

/**
 * A generic armor part.
 *
 * @author soludev1
 */
public interface IPart
{
    public abstract class ShapedRecipe
    {
        /** 
         * Get the part shaped recipe model : 1 to 3 string(s) designing crafting model.
         * Use strictly positive integer (1 to ∞) values for materials. 
         * 
         * @return Shaped recipe model
         */
        public abstract String[] getModel ();
        
        /**
         * @return The part amount produced in shaped recipes.
         */
        public int getAmount ()
        {
            return 1;
        }
    }
    
    /**
     * @return Get available space.
     */
    public float getSpace ();
    /**
     * @return Get available energy.
     */
    public float getEnergy ();
    /**
     * @return Get available weight.
     */
    public float getWeight ();
    
    /**
     * @return Armor part material.
     */
    public IMaterial getMaterial ();

    /**
     * @return Unlocalized name.
     */
    public String getUnlocalizedName ();

    public ShapedRecipe[] getShapedRecipes ();
}
