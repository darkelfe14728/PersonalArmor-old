/**
 * 
 */
package personalarmor.armor.part;

import personalarmor.material.IMaterial;

/**
 * Abstract armor part
 *
 * @author soludev1
 */
public abstract class AbstractPart
    implements IPart
{
    /**
     * Part material.
     */
    protected IMaterial material;
    
    public AbstractPart (IMaterial material)
    {
        this.material = material;
    }
    
    /**
     * @return Armor part material.
     */
    public IMaterial getMaterial ()
    {
        return material;
    }
    
    /**
     * Get number of "base points" : value used to calculate armor part space, energy and weight.
     * 
     * @return Base points.
     */
    protected abstract float getBasePoint ();
    @Override
    public float getSpace  ()
    {
        return getBasePoint() * material.getFactorSpace();
    }
    @Override
    public float getEnergy ()
    {
        return getBasePoint() * material.getFactorEnergy();
    }
    @Override
    public float getWeight ()
    {
        return getBasePoint() * material.getFactorWeight();
    }

    @Override
    public String getUnlocalizedName ()
    {
        return this.getClass().getName().toLowerCase() + "." + material.getUnlocalizedName();
    }
}
