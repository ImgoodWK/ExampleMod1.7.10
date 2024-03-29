package com.imgood.lazygtnh;

import net.minecraft.block.material.Material;
import net.minecraft.item.ItemDye;
import net.minecraftforge.oredict.OreDictionary;

import com.cricketcraft.chisel.api.ChiselTabs;
import com.imgood.lazygtnh.client.render.SubmapManagerAntiblockFrameless;
import com.imgood.lazygtnh.config.LazyGTNHConfigurations;

import cpw.mods.fml.common.Loader;
import team.chisel.Chisel;
import team.chisel.block.BlockCarvable;
import team.chisel.block.BlockCarvableGlowie;
import team.chisel.config.Configurations;

public enum LazyGTNHFeatures {

    ANTIBLOCKFRAMELESS {

        @Override
        void addBlocks() {
            LazyGTNH.logger.info("Adding blocks:AntiblockFrameless");
            BlockCarvable antiBlockFrameless = (BlockCarvable) new BlockCarvableGlowie(Material.rock)
                .setCreativeTab(ChiselTabs.tabOtherChiselBlocks);

            if (!Configurations.allowChiselCrossColors) {
                antiBlockFrameless.carverHelper.forbidChiseling = true;
            }

            for (int i = 0; i < 16; i++) {
                LazyGTNH.logger.info("Adding blocks:AntiblockFrameless" + ItemDye.field_150921_b[i] + ".desc");
                antiBlockFrameless.carverHelper.addVariation(
                    "tile.antiBlockFrameLess." + ItemDye.field_150921_b[i] + ".desc",
                    i,
                    new SubmapManagerAntiblockFrameless(ItemDye.field_150921_b[i]));
            }
            LazyGTNH.logger.info("register blocks:AntiblockFrameless");
            antiBlockFrameless.carverHelper.registerAll(antiBlockFrameless, "antiBlockFrameless");
            OreDictionary.registerOre("antiBlockFrameless", antiBlockFrameless);
        }
    };

    private LazyGTNHFeatures parent;

    private String requiredMod;

    static void preInit() {
        LazyGTNH.logger.info("Starting pre-init...");
        loadBlocks();
        loadItems();
        LazyGTNH.logger.info("Pre-init finished.");
    }

    static void init() {
        LazyGTNH.logger.info("Starting init...");
        loadRecipes();
        LazyGTNH.logger.info("Init finished.");
    }

    void addBlocks() {
        ;
    }

    private static void loadBlocks() {
        LazyGTNH.logger.info("Loading blocks...");
        int num = 0;
        for (LazyGTNHFeatures f : values()) {
            LazyGTNH.logger.info("if enabled check");
            LazyGTNH.logger.info(f.enabled());
            LazyGTNH.logger.info(f);
            f.addBlocks();
            ++num;
        }
        LazyGTNH.logger.info(num + " Feature's blocks loaded.");
        LazyGTNH.logger.info("Loading Tile Entities...");
        // 。。。
        LazyGTNH.logger.info("Tile Entities loaded.");
    }

    private static void loadItems() {
        Chisel.logger.info("Loading items...");
        int num = 0;
        for (LazyGTNHFeatures f : values()) {
            if (f.enabled()) {
                f.addItems();
                ++num;
            } else {
                logDisabled(f);
            }
        }
        Chisel.logger.info(num + " Feature's items loaded.");
    }

    private static void logDisabled(LazyGTNHFeatures f) {
        if (!f.hasParentFeature() && f.parent != null) {
            Chisel.logger.info(
                "Skipping feature {} as its parent feature {} was disabled.",
                LazyGTNHConfigurations.featureName(f),
                LazyGTNHConfigurations.featureName(f.parent));
        } else if (!f.hasRequiredMod() && f.getRequiredMod() != null) {
            Chisel.logger.info(
                "Skipping feature {} as its required mod {} was missing.",
                LazyGTNHConfigurations.featureName(f),
                f.getRequiredMod());
        } else {
            Chisel.logger
                .info("Skipping feature {} as it was disabled in the config.", LazyGTNHConfigurations.featureName(f));
        }
    }

    void addItems() {
        ;
    }

    private final boolean hasParentFeature() {
        return parent == null || parent.enabled();
    }

    public boolean enabled() {
        return LazyGTNHConfigurations.featureEnabled(this) && hasRequiredMod() && hasParentFeature();
    }

    private final boolean hasRequiredMod() {
        return getRequiredMod() == null || Loader.isModLoaded(getRequiredMod());
    }

    private String getRequiredMod() {
        return requiredMod;
    }

    private static int meta = 0;

    private static void loadRecipes() {
        Chisel.logger.info("Loading recipes...");
        int num = 0;
        for (LazyGTNHFeatures f : values()) {
            if (f.enabled()) {
                if (f.needsMetaRecipes()) {
                    for (int i = 0; i < 16; i++) {
                        meta = i;
                        f.addRecipes();
                    }
                    meta = 0;
                } else {
                    f.addRecipes();
                }
                ++num;
            } else {
                logDisabled(f);
            }
        }
        Chisel.logger.info(num + " Feature's recipes loaded.");
    }

    void addRecipes() {
        ;
    }

    boolean needsMetaRecipes() {
        return false;
    }
}
