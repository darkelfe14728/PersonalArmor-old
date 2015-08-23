package personalarmor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import personalarmor.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * @author Julien Rosset
 *
 * Mod entry point.
 */
@Mod(
     modid                     = "personalarmor",
     name                      = "PersonalArmor",
     version                   = "0.0.1",
     dependencies              = "required-after:Forge@[10.13.2.1291,)",
     acceptedMinecraftVersions = "[1.7.10,)",
     canBeDeactivated          = true
)
public class PersonalArmor
{
	/**
	 * Mod instance.
	 */
	@Mod.Instance("personalarmor")
	public static PersonalArmor instance = new PersonalArmor();
	/**
     * Mod metadata.
     */
	@Mod.Metadata("personalarmor")
    public static ModMetadata modMetadata;
	
	/**
	 * Proxy instantiation.
	 */
	@SidedProxy(
			clientSide = "personalarmor.proxy.ClientProxy",
			serverSide = "personalarmor.proxy.CommonProxy"
		)
	public static CommonProxy proxy;
    
	/**
	 * List of modules.
	 */
	@SuppressWarnings("serial")
    public static final Map<String, IModule> modules = new HashMap<String, IModule>() {{
	    put("Player", null);
	}};
	
    /**
     * Function called before mod initialization.
     * 
     * @param event Some data about this event.
     */
    @Mod.EventHandler
    public void preInit (FMLPreInitializationEvent event)
    {
    	LogHelper.debug("Initialising mod metadata");
        PersonalArmor.modMetadata = event.getModMetadata();
        PersonalArmor.modMetadata.modId = "personalarmor";
        PersonalArmor.modMetadata.name  = "PersonalArmor";
        PersonalArmor.modMetadata.version = "0.0.1";
        PersonalArmor.modMetadata.description = "A powerfull and modular armor";
        PersonalArmor.modMetadata.authorList = Arrays.asList(new String[] {"Julien Rosset"});
        PersonalArmor.modMetadata.credits = "";
        
        LogHelper.debug("Pre-Initialising sub-modules");
        LogHelper.startBlock("Pre-Initialization");
        for(Entry<String, IModule> module : modules.entrySet())
        {
            LogHelper.startBlock(module.getKey());
                LogHelper.debug(module.getKey());
                module.getValue().preInit(event);
            LogHelper.stopBlock();
        }
        LogHelper.stopBlock();
    }

    /**
     * Function called about mod initialization.
     * 
     * @param event Some data about this event.
     */
    @Mod.EventHandler
    public void init (FMLInitializationEvent event)
    {
        LogHelper.debug("Initialising sub-modules");
        LogHelper.startBlock("Initialization");
        for(Entry<String, IModule> module : modules.entrySet())
        {
            LogHelper.startBlock(module.getKey());
                LogHelper.debug(module.getKey());
                module.getValue().init(event);
            LogHelper.stopBlock();
        }
        LogHelper.stopBlock();
    }
    
    /**
     * Function called after mod initialization.
     * 
     * @param event Some data about this event.
     */
    @Mod.EventHandler
    public void postInit (FMLPostInitializationEvent event)
    {
        LogHelper.debug("Pre-Initialising sub-modules");
        LogHelper.startBlock("Post-Initialization");
        for(Entry<String, IModule> module : modules.entrySet())
        {
            LogHelper.startBlock(module.getKey());
                LogHelper.debug(module.getKey());
                module.getValue().postInit(event);
            LogHelper.stopBlock();
        }
        LogHelper.stopBlock();
    }
}
