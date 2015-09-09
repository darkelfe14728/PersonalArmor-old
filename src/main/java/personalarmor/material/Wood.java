package personalarmor.material;

/**
 * Basic wood.
 *
 * @author soludev1
 */
public class Wood
    extends AbstractMaterial
{
    @Override
    public float getFactorEnergy ()
    {
        return 0;
    }
    @Override
    public float getFactorSpace ()
    {
        return 1;
    }
    @Override
    public float getFactorWeight ()
    {
        return 1;
    }
}
