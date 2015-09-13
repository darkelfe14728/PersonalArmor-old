package personalarmor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import personalarmor.armor.ArmorModule;
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
     acceptedMinecraftVersions = "[1.8,)",
     canBeDeactivated          = true
)
public class PersonalArmor
{
    public static final String MODID = "personalarmor";
    
	/**
	 * Mod instance.
	 */
	@Mod.Instance("personalarmor")
	public static PersonalArmor instance = new PersonalArmor();
	
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
    public static final HashMap<String, AbstractModule> modules = new HashMap<String, AbstractModule>();
	
	static {
	    modules.put("Player", new PlayerModule());
	    modules.put("Armor" , new ArmorModule());
	}
	
    /**
     * Function called before mod initialization.
     * 
     * @param event Some data about this event.
     */
    @Mod.EventHandler
    public void preInit (FMLPreInitializationEvent event)
    {
    	LogHelper.info("Initialising mod metadata");
    	ModMetadata metadata = event.getModMetadata();
    	metadata.modId = MODID;
    	metadata.name  = "PersonalArmor";
    	metadata.version = "0.0.1";
    	metadata.description = "A powerful and modular armor";
    	metadata.authorList = Arrays.asList(new String[] {"Julien Rosset"});
    	metadata.credits = "";
        
        LogHelper.info("Pre-Initialising " + modules.size() + " sub-modules");
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
        LogHelper.info("Initialising " + modules.size() + " sub-modules");
        LogHelper.startBlock("Initialization");
        
        for(Entry<String, AbstractModule> module : modules.entrySet())
        {
            LogHelper.startBlock(module.getKey());
                LogHelper.info(module.getKey());
                module.getValue().init(event);
            LogHelper.stopBlock();
        }
        
        proxy.registerRenderers();
        
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
        
        LogHelper.info("Post-Initialising " + modules.size() + " sub-modules");
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
