package personalarmor.module;

/**
 * A generic armor module.
 *
 * @author soludev1
 */
public interface IModule
{
    /**
     * @return Get use space.
     */
    public float getUseSpace ();
    /**
     * @return Get use energy (by tick).
     */
    public float getUseEnergy ();
    /**
     * @return Get use weight.
     */
    public float getUseWeight ();
}
