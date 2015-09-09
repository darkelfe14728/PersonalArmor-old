package personalarmor.armor.part;

import personalarmor.material.IMaterial;

/**
 * Arm armor part.
 *
 * @author soludev1
 */
public class Arm
    extends AbstractPart
{
    public Arm (IMaterial material)
    {
        super(material);
    }

    @Override
    protected float getBasePoint ()
    {
        return 3;
    }
}
