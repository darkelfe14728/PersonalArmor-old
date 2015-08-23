package personalarmor;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * @author soludev1
 *
 * Interface for mod modules entry point
 */
public interface IModule
{
    public void preInit (FMLPreInitializationEvent event);
    public void init (FMLInitializationEvent event);
    public void postInit (FMLPostInitializationEvent event);
}
