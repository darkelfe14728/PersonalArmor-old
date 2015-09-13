package personalarmor;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author soludev1
 *
 * Interface for mod modules entry point
 */
public abstract class AbstractModule
{
    public void preInit (FMLPreInitializationEvent event) {}
    public void init (FMLInitializationEvent event) {}
    public void postInit (FMLPostInitializationEvent event) {}

    public void registerRenderers () {}
}
