package com.imgood.lazygtnh;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

    // region ThermalEnergyDevourer
    public static byte Mode_Default_HyperdimensionalResonanceEvolver = 0;
    public static int Parallel_HighSpeedMode_HyperdimensionalResonanceEvolver = 1024;
    public static int Parallel_HighParallelMode_HyperdimensionalResonanceEvolver = Integer.MAX_VALUE;
    public static int TickPerProgressing_WirelessMode_THyperdimensionalResonanceEvolver = 128;
    // endregion

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
