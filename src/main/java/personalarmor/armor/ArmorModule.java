package personalarmor.armor;

import java.util.HashMap;
import java.util.Map.Entry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import personalarmor.AbstractModule;
import personalarmor.LogHelper;
import personalarmor.armor.part.Chest;

/**
 * Armor sub-module.
 *
 * @author soludev1
 */
public class ArmorModule
    extends AbstractModule
{
    /**
     * Creative tabs;
     */
    public static HashMap<String, CreativeTabs> tabs = new HashMap<String, CreativeTabs>();
    /**
     * Items.
     */
    public static HashMap<String, Item> items = new HashMap<String, Item>(); 

    static {
        tabs.put("armor", new ArmorTab());
        
        items.put("", new ArmorItem<Chest>(null));
    }
    
    @Override
    public void preInit (FMLPreInitializationEvent event)
    {
        LogHelper.info("Register " + items.size() + " items");
        for(Entry<String, Item> item : items.entrySet())
            GameRegistry.registerItem(item.getValue(), item.getKey());
    }
    @Override
    public void init (FMLInitializationEvent event)
    {}
    @Override
    public void postInit (FMLPostInitializationEvent event)
    {}
}
