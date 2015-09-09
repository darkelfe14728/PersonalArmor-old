package personalarmor.armor.part;

import personalarmor.material.IMaterial;

/**
 * Forearm armor part.
 *
 * @author soludev1
 */
public class Forearm
    extends AbstractPart
{
    public Forearm (IMaterial material)
    {
        super(material);
    }

    @Override
    protected float getBasePoint ()
    {
        return 4;
    }

}
