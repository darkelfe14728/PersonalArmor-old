package personalarmor.armor.part;

import personalarmor.material.IMaterial;

/**
 * Back armor part.
 *
 * @author soludev1
 */
public class Back
    extends AbstractPart
{
    public Back (IMaterial material)
    {
        super(material);
    }

    @Override
    protected float getBasePoint ()
    {
        return 10;
    }
}
