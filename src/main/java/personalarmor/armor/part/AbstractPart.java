/**
 * 
 */
package personalarmor.armor.part;

import personalarmor.material.IMaterial;

/**
 * @author soludev1
 *
 * Abstract armor part
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
    
    public IMaterial getMaterial ()
    {
        return material;
    }
    
    /**
     * Get number of "base points" : value used to calculate armor part space, energy and weight.
     * 
     * @return Base points.
     */
    public abstract float getBasePoint ();
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
}
