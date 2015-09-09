package personalarmor.armor.part;

import personalarmor.material.IMaterial;

/**
 * Leg up armor part.
 *
 * @author soludev1
 */
public class LegUp
    extends AbstractPart
{
    public LegUp (IMaterial material)
    {
        super(material);
    }

    @Override
    protected float getBasePoint ()
    {
        return 3;
    }
}
