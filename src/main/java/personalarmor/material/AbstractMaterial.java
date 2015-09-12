package personalarmor.material;

/**
 * Abstract material.
 *
 * @author soludev1
 */
public abstract class AbstractMaterial
    implements IMaterial
{
    @Override
    public String getUnlocalizedName ()
    {
        return this.getClass().getSimpleName().toLowerCase();
    }
}
