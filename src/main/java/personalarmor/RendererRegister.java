package personalarmor;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

/**
 * A convenient class for renderer registers.
 *
 * @author soludev1
 */
public final class RendererRegister
{
    public static void registerItem (Item item)
    {
        registerItem(item, 0);
    }
    public static void registerItem (Item item, int meta)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(
            item,
            meta,
            new ModelResourceLocation(PersonalArmor.MODID + ":" + Utils.getItemName(item), "inventory")
        );
    }
}
