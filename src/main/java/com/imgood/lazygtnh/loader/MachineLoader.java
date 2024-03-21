package com.imgood.lazygtnh.loader;

import com.imgood.lazygtnh.LZGTItemList;
import com.imgood.lazygtnh.machines.LZGT_HyperdimensionalResonanceEvolver;
import com.imgood.lazygtnh.utils.LZGTTextLocalization;
import net.minecraft.entity.EntityList;
import net.minecraft.item.ItemStack;
import com.Nxer.TwistSpaceTechnology.common.ship.Ship;


public class MachineLoader {
    public static ItemStack HyperdimensionalResonanceEvolver;

    public static void loadMachines() {


        HyperdimensionalResonanceEvolver = new LZGT_HyperdimensionalResonanceEvolver(
            10000,
            "NameHyperdimensionalResonanceEvolver",
            LZGTTextLocalization.NameHyperdimensionalResonanceEvolver).getStackForm(1);
        LZGTItemList.HyperdimensionalResonanceEvolver.set(HyperdimensionalResonanceEvolver);

    }

    public static void loadMachinePostInit() {

    }
}
