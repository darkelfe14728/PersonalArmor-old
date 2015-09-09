package personalarmor.armor.part;

/**
 * A generic armor part.
 * 
 * @author soludev1
 */
public interface IPart
{
    /**
     * @return Get available space.
     */
    public float getSpace  ();
    /**
     * @return Get available energy.
     */
    public float getEnergy ();
    /**
     * @return Get available weight.
     */
    public float getWeight ();
}
