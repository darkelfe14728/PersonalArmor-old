package personalarmor.player;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import personalarmor.IModule;
import personalarmor.LogHelper;

/**
 * @author soludev1
 *
 * Player sub-module entry point.
 */
public class PlayerModule
    implements IModule
{
    @Override
    public void preInit (FMLPreInitializationEvent event)
    {}
    @Override
    public void init (FMLInitializationEvent event)
    {}
    @Override
    public void postInit (FMLPostInitializationEvent event)
    {
        LogHelper.debug("Register event handler");
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }
}
