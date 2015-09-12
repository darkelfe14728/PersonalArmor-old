package personalarmor.armor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import personalarmor.AbstractModule;
import personalarmor.IShapedCrafting;
import personalarmor.LogHelper;
import personalarmor.armor.part.Chest;
import personalarmor.armor.part.IPart;
import personalarmor.material.IMaterial;
import personalarmor.material.Wood;

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

    public static ArrayList<Class<? extends IPart>> parts = new ArrayList<Class<? extends IPart>>();
    public static ArrayList<IMaterial> materials = new ArrayList<IMaterial>();
    
    static {
        // Tabs
        tabs.put("armor", new ArmorTab());
        
        // Armor parts
        parts.add(Chest.class);
        // Materials
        materials.add(new Wood());
        
        // Items
        // Armor parts items
        for (Class<? extends IPart> part : parts)
        {
            for (IMaterial material : materials)
            {
                try
                {
                    Constructor<?> construct = part.getConstructor(new Class[] {IMaterial.class});
                    items.put(
                        part.getName() + "_" + material.getClass().getName(),
                        new ArmorItem<IPart>((IPart)construct.newInstance(material))
                    );
                }
                catch (
                    NoSuchMethodException | 
                    SecurityException | 
                    InvocationTargetException | 
                    IllegalAccessException | 
                    InstantiationException 
                    exception
                )
                {
                    LogHelper.error(exception.getMessage());
                }
            }
        }
    }
    
    @Override
    public void preInit (FMLPreInitializationEvent event)
    {
        LogHelper.info(items.size() + " items");
        for(Entry<String, Item> item : items.entrySet())
        {
            GameRegistry.registerItem(item.getValue(), item.getKey());
            
            if(item.getValue() instanceof IShapedCrafting)
                ((IShapedCrafting)item.getValue()).registerShapedRecipes();
        }
    }
    @Override
    public void init (FMLInitializationEvent event)
    {}
    @Override
    public void postInit (FMLPostInitializationEvent event)
    {}
}
