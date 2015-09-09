package personalarmor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import personalarmor.network.PacketDispatcher;
import personalarmor.network.server.PacketOpenServerGui;
import personalarmor.player.PlayerModule;
import personalarmor.proxy.CommonProxy;

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
	 * Mod internal GUI id generator
	 */
	public static int _gui_generator = 0;
	
	/**
	 * List of modules.
	 */
	@SuppressWarnings("serial")
    public static final Map<String, AbstractModule> modules = new HashMap<String, AbstractModule>() {{
	    put("Player", new PlayerModule());
	}};
	
    /**
     * Function called before mod initialization.
     * 
     * @param event Some data about this event.
     */
    @Mod.EventHandler
    public void preInit (FMLPreInitializationEvent event)
    {
    	LogHelper.info("Initialising mod metadata");
        PersonalArmor.modMetadata = event.getModMetadata();
        PersonalArmor.modMetadata.modId = "personalarmor";
        PersonalArmor.modMetadata.name  = "PersonalArmor";
        PersonalArmor.modMetadata.version = "0.0.1";
        PersonalArmor.modMetadata.description = "A powerful and modular armor";
        PersonalArmor.modMetadata.authorList = Arrays.asList(new String[] {"Julien Rosset"});
        PersonalArmor.modMetadata.credits = "";
        
        LogHelper.info("Pre-Initialising sub-modules");
        LogHelper.startBlock("Pre-Initialization");
        for(Entry<String, AbstractModule> module : modules.entrySet())
        {
            LogHelper.startBlock(module.getKey());
                LogHelper.info(module.getKey());
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
        LogHelper.info("Initialising sub-modules");
        LogHelper.startBlock("Initialization");
        for(Entry<String, AbstractModule> module : modules.entrySet())
        {
            LogHelper.startBlock(module.getKey());
                LogHelper.info(module.getKey());
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
        LogHelper.info("Register GUI handler");
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new CommonProxy());
        
        LogHelper.info("Register GUI message");
        PacketDispatcher.registerMessages(PacketOpenServerGui.class, PacketOpenServerGui.class);
        
        LogHelper.info("Post-Initialising sub-modules");
        LogHelper.startBlock("Post-Initialization");
        for(Entry<String, AbstractModule> module : modules.entrySet())
        {
            LogHelper.startBlock(module.getKey());
                LogHelper.info(module.getKey());
                module.getValue().postInit(event);
            LogHelper.stopBlock();
        }
        LogHelper.stopBlock();
    }
}
