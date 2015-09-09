package personalarmor.player;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import personalarmor.AbstractModule;
import personalarmor.LogHelper;
import personalarmor.PersonalArmor;

/**
 * @author soludev1
 *
 *         Player sub-module entry point.
 */
public class PlayerModule
    extends AbstractModule
{
    public static final int GUI_ARMOR = PersonalArmor._gui_generator++;

    @Override
    public void preInit (FMLPreInitializationEvent event)
    {}

    @Override
    public void init (FMLInitializationEvent event)
    {
        LogHelper.info("Register event handler");
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }

    @Override
    public void postInit (FMLPostInitializationEvent event)
    {}
}
