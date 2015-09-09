package personalarmor.material;

/**
 * A generic material.
 * 
 * @author soludev1
 */
public interface IMaterial
{
    public float getFactorEnergy ();
    public float getFactorSpace  ();
    public float getFactorWeight ();
    
    /**
     * @return Unlocalized name.
     */
    public String getUnlocalizedName ();
}
