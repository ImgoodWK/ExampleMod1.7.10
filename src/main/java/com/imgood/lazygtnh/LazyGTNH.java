package com.imgood.lazygtnh;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.imgood.lazygtnh.loader.MachineLoader;
import com.imgood.lazygtnh.loader.RecipeLoader;
import com.imgood.lazygtnh.nei.NEIHandler;
import com.imgood.lazygtnh.utils.LZGTTextHandler;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid = LazyGTNH.MODID, version = Tags.VERSION, name = "LazyGTNH", acceptedMinecraftVersions = "[1.7.10]")
public class LazyGTNH {

    public static final String MOD_NAME = "LazyGTNH";
    public static final String MODID = "lazygtnh";
    public static final Logger LOG = LogManager.getLogger(MODID);
    public static final Logger logger = LogManager.getLogger(MOD_NAME);
    public static String DevResource = "";
    public static final boolean isInDevMode = false;
    @SidedProxy(clientSide = "com.imgood.lazygtnh.ClientProxy", serverSide = "com.imgood.lazygtnh.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        LOG.info("Lazy GTNH preinitialization");
        LazyGTNHFeatures.preInit();
        LZGTTextHandler.initLangMap(isInDevMode);
        proxy.preInit(event);
    }

    @Mod.EventHandler
    // load "Do your mod setup. Build whatever data structures you care about. Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {
        LOG.info("Lazy GTNH initialization");
        LazyGTNHFeatures.init();
        MachineLoader.loadMachines();
        RecipeLoader.loadRecipes();
        NEIHandler.IMCSender();
        proxy.init(event);
    }

    @Mod.EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {
        MachineLoader.loadMachinePostInit();
        LZGTTextHandler.serializeLangMap(isInDevMode);
        proxy.postInit(event);
    }

    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
    }
}
