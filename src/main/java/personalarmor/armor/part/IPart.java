package personalarmor.armor.part;

import personalarmor.material.IMaterial;
import personalarmor.module.IModule;

/**
 * A generic armor part.
 *
 * @author soludev1
 */
public interface IPart
{
    /**
     * Internal class for shaped crafting recipe informations
     *
     * @author soludev1
     */
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
     * @return List of applied modules.
     */
    public IModule[] getModules ();
    /**
     * Apply a new module to armor part.
     * Use {@link moduleIsApplicable} to check if module is valid for this armor part
     * 
     * @param module The module to apply.
     */
    public void addModule (IModule module);
    /**
     * Check if a module is applicable to the armor part.
     * 
     * @param module The module to check.
     * @return True if module is applicable, else False.
     */
    public boolean moduleIsApplicable (IModule module);
    
    /**
     * @return Unlocalized name.
     */
    public String getUnlocalizedName ();

    /**
     * @return List of shaped recipes for armor part.
     */
    public ShapedRecipe[] getShapedRecipes ();
}
