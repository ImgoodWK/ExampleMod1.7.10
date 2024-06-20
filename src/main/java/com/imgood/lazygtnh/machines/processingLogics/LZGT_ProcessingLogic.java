package com.imgood.lazygtnh.machines.processingLogics;

import javax.annotation.Nonnull;

import com.Nxer.TwistSpaceTechnology.common.machine.multiMachineClasses.processingLogics.GTCM_ParallelHelper;

import gregtech.api.logic.ProcessingLogic;
import gregtech.api.util.GT_ParallelHelper;
import gregtech.api.util.GT_Recipe;

public class LZGT_ProcessingLogic extends ProcessingLogic {

    public LZGT_ProcessingLogic() {

    }

    @Nonnull
    protected GT_ParallelHelper createParallelHelper(@Nonnull GT_Recipe recipe) {
        return (new GTCM_ParallelHelper()).setRecipe(recipe)
            .setItemInputs(this.inputItems)
            .setFluidInputs(this.inputFluids)
            .setAvailableEUt(this.availableVoltage * this.availableAmperage)
            .setMachine(this.machine, this.protectItems, this.protectFluids)
            .setRecipeLocked(this.recipeLockableMachine, this.isRecipeLocked)
            .setMaxParallel(this.maxParallel)
            .setEUtModifier(this.euModifier)
            .enableBatchMode(this.batchSize)
            .setConsumption(true)
            .setOutputCalculation(true);
    }
}
