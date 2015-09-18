package personalarmor.armor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import personalarmor.AbstractModule;
import personalarmor.IShapedCrafting;
import personalarmor.LogHelper;
import personalarmor.RendererRegister;
import personalarmor.Utils;
import personalarmor.armor.part.Chest;
import personalarmor.armor.part.IPart;
import personalarmor.material.IMaterial;
import personalarmor.material.Wood;
import personalarmor.module.event.ModuleEventHandler;

/**
 * Armor sub-module.
 *
 * @author soludev1
 */
public class ArmorModule
    extends AbstractModule
{
    /**
     * List of creative tabs;
     */
    public static final HashMap<String, CreativeTabs> tabs = new HashMap<String, CreativeTabs>();
    /**
     * List of items.
     */
    public static final ArrayList<Item> items = new ArrayList<Item>();

    /**
     * List of armor parts.
     */
    public static final ArrayList<Class<? extends IPart>> parts = new ArrayList<Class<? extends IPart>>();
    /**
     * List of materials.
     */
    public static final ArrayList<IMaterial> materials = new ArrayList<IMaterial>();
    
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
                    items.add(new ArmorItem<IPart>((IPart)construct.newInstance(material)));
                }
                catch (NoSuchMethodException     exception) {LogHelper.error(exception.getMessage());}
                catch (SecurityException         exception) {LogHelper.error(exception.getMessage());}
                catch (InvocationTargetException exception) {LogHelper.error(exception.getMessage());}
                catch (IllegalAccessException    exception) {LogHelper.error(exception.getMessage());}
                catch (InstantiationException    exception) {LogHelper.error(exception.getMessage());}
            }
        }
    }
    
    @Override
    public void preInit (FMLPreInitializationEvent event)
    {
        LogHelper.info("Register " + items.size() + " items");
        for(Item item : items)
            GameRegistry.registerItem(item, Utils.getItemName(item));
    }
    @Override
    public void init (FMLInitializationEvent event)
    {
        LogHelper.info("Register shaped recipes");
        for(Item item : items)
        {
            if(item instanceof IShapedCrafting)
                ((IShapedCrafting)item).registerShapedRecipes();
        }
    }
    @Override
    public void postInit (FMLPostInitializationEvent event)
    {
        LogHelper.info("Register modules event handler");
        MinecraftForge.EVENT_BUS.register(new ModuleEventHandler());
    }

    @Override
    public void registerRenderers ()
    {
        LogHelper.info("Registring renderers");
        for(Item item : items)
            RendererRegister.registerItem(item);
    }
}
