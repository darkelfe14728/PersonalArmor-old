/**
 * 
 */
package personalarmor.armor.part;

import java.util.HashSet;

import personalarmor.material.IMaterial;
import personalarmor.module.IModule;

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
    protected final IMaterial material;
    /**
     * Part modules.
     */
    protected HashSet<IModule> modules;
    
    public AbstractPart (IMaterial material)
    {
        this.material = material;
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
    public IMaterial getMaterial ()
    {
        return material;
    }

    @Override
    public IModule[] getModules ()
    {
        return modules.toArray(new IModule[modules.size()]);
    }
    public void addModule (IModule module)
    {
        modules.add(module);
    }
    
    @Override
    public String getUnlocalizedName ()
    {
        return this.getClass().getSimpleName().toLowerCase() + "." + material.getUnlocalizedName();
    }
}
