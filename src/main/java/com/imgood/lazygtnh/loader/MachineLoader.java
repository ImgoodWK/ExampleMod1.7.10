package com.imgood.lazygtnh.loader;

import net.minecraft.item.ItemStack;

import com.imgood.lazygtnh.LZGT_ItemList;
import com.imgood.lazygtnh.machines.LZGT_HyperdimensionalResonanceEvolver;
import com.imgood.lazygtnh.utils.LZGTTextLocalization;

public class MachineLoader {

    public static ItemStack HyperdimensionalResonanceEvolver;

    public static void loadMachines() {

        HyperdimensionalResonanceEvolver = new LZGT_HyperdimensionalResonanceEvolver(
            10000,
            "NameHyperdimensionalResonanceEvolver",
            LZGTTextLocalization.NameHyperdimensionalResonanceEvolver).getStackForm(1);
        LZGT_ItemList.HyperdimensionalResonanceEvolver.set(HyperdimensionalResonanceEvolver);

    }

    public static void loadMachinePostInit() {

    }
}
