package com.imgood.lazygtnh;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    @SidedProxy(clientSide = "com.imgood.lazygtnh.ClientProxy", serverSide = "com.imgood.lazygtnh.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        LOG.info("LAZY preinitialization");
        LazyGTNHFeatures.preInit();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    // load "Do your mod setup. Build whatever data structures you care about. Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {
        LOG.info("LAZY  initialization");
        LazyGTNHFeatures.init();
        proxy.init(event);
    }

    @Mod.EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
    }
}
