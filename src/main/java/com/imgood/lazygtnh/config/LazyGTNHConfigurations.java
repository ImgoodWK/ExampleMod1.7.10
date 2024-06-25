package com.imgood.lazygtnh.config;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.imgood.lazygtnh.LazyGTNH;

import net.minecraftforge.common.config.Configuration;

import org.apache.commons.lang3.StringUtils;

import com.imgood.lazygtnh.LazyGTNHFeatures;

import java.io.File;
import java.math.BigInteger;


public class LazyGTNHConfigurations {

    public static Configuration config;
    public static boolean activateCombatStats;
    public static final String HyperdimensionalResonanceEvolver = "HyperdimensionalResonanceEvolver";
    public static double secondsOfHyperdimensionalResonanceProgressCycleTime = 64.0;
    public static boolean EnableRenderDefaultHyperdimensionalResonanceEvolver = true;

    //common blocks
    public static Map<String, Boolean> features = new HashMap<>();
    public static byte Mode_Default_HyperdimensionalResonanceEvolver;
    public static int Parallel_HighSpeedMode_HyperdimensionalResonanceEvolver;
    public static int Parallel_HighParallelMode_HyperdimensionalResonanceEvolver;
    public static int TickPerProgressing_WirelessMode_HyperdimensionalResonanceEvolver;

    //common blocks
    public static boolean refreshConfig() {

            /* features */
        LazyGTNH.logger.info("Put block feature in config file...");
        for (LazyGTNHFeatures feature : LazyGTNHFeatures.values()) {
            LazyGTNH.logger.info("Put" + feature + "in config file.");
            features.put(
                featureName(feature),
                config.get("features", featureName(feature), true)
                    .getBoolean(true));
        }

        if (config.hasChanged()) {
            LazyGTNH.logger.info("Config file has changed,saving config...");
            config.save();
        }
        return true;
    }
    //common blocks
    public static boolean featureEnabled(LazyGTNHFeatures feature) {
        boolean enabled = features.getOrDefault(featureName(feature), false);
        LazyGTNH.logger.info(feature + " is " + (enabled ? "enabled" : "disabled."));
        return enabled;
    }
//common blocks
    /**
     * Makes the old camelCase names from the new CONSTANT_CASE names
     */
    public static String featureName(LazyGTNHFeatures feature) {
        String[] words = feature.name()
            .toLowerCase(Locale.ENGLISH)
            .split("_");
        if (words.length == 1) {
            return words[0];
        }

        String ret = words[0];
        for (int i = 1; i < words.length; i++) {
            ret += StringUtils.capitalize(words[i]);
        }
        return ret;
    }
//common blocks
    @Deprecated
    public static boolean featureEnabled(String feature) {
        return false;
    }

    public static void synchronizeConfiguration(File configFile) {
        LazyGTNH.logger.info("Synchronizing configuration...");
        Configuration configuration = new Configuration(configFile);
        secondsOfHyperdimensionalResonanceProgressCycleTime = Double.parseDouble(configuration.getString("secondsOfHyperdimensionalResonanceProgressCycleTime",
            HyperdimensionalResonanceEvolver,String.valueOf(secondsOfHyperdimensionalResonanceProgressCycleTime),"Seconds of HyperdimensionalResonance one progress time. Type: double, turn to tick time."));
        EnableRenderDefaultHyperdimensionalResonanceEvolver = configuration.getBoolean("EnableRenderDefaultHyperdimensionalResonanceEvolver", HyperdimensionalResonanceEvolver, EnableRenderDefaultHyperdimensionalResonanceEvolver, "Enable Render of Hyperdimensional Resonance Evolver when placing a new one.");

        activateCombatStats = configuration.getBoolean("activateCombatStats", "CombatStats", activateCombatStats, "decide whether to enable the combatstats system(WIP).DO NOT USE IT FOR NOW!");
        Mode_Default_HyperdimensionalResonanceEvolver = (byte)configuration.getInt("Mode_Default_HyperdimensionalResonanceEvolver", "HyperdimensionalResonanceEvolver", Mode_Default_HyperdimensionalResonanceEvolver, 0, 1, "The default mode when deploy HyperdimensionalResonanceEvolver. 0=HighSpeedMode, 1=HighParallelMode. Type: byte");
        if (Mode_Default_HyperdimensionalResonanceEvolver < 0 || Mode_Default_HyperdimensionalResonanceEvolver > 1) {
            Mode_Default_HyperdimensionalResonanceEvolver = 0;
        }
        Parallel_HighSpeedMode_HyperdimensionalResonanceEvolver = configuration.getInt("Parallel_HighSpeedMode_HyperdimensionalResonanceEvolver", "HyperdimensionalResonanceEvolver", Parallel_HighSpeedMode_HyperdimensionalResonanceEvolver, 1, Integer.MAX_VALUE, "Max Parallel of Hyperdimensional Resonance Evolver high speed mode. Type: int");
        TickPerProgressing_WirelessMode_HyperdimensionalResonanceEvolver = configuration.getInt("TickPerProgressing_WirelessMode_HyperdimensionalResonanceEvolver", "HyperdimensionalResonanceEvolver", TickPerProgressing_WirelessMode_HyperdimensionalResonanceEvolver, 1, 16384, "How many ticks per progressing cost in Wireless mode of Hyperdimensional Resonance Evolver. Type: int");
        LazyGTNH.logger.info("Synchronize configuration finished.");
        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
    static {
        activateCombatStats = false;
        Mode_Default_HyperdimensionalResonanceEvolver = 0;
        Parallel_HighSpeedMode_HyperdimensionalResonanceEvolver = 1024;
        Parallel_HighParallelMode_HyperdimensionalResonanceEvolver = Integer.MAX_VALUE;
        TickPerProgressing_WirelessMode_HyperdimensionalResonanceEvolver = 128;
    }
}
