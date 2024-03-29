package com.imgood.lazygtnh.utils.recipes;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import gregtech.api.recipe.RecipeMap;
import gregtech.api.util.GT_Recipe;

public class LZGT_RecipeBuilder {

    public static LZGT_RecipeBuilder builder() {
        return new LZGT_RecipeBuilder();
    }

    private ItemStack[] inputItems = new ItemStack[0];
    private ItemStack[] outputItems = new ItemStack[0];
    private FluidStack[] inputFluids = new FluidStack[0];
    private FluidStack[] outputFluids = new FluidStack[0];
    private int[] outputChance;
    private int eut = 0;
    private int duration = 0;
    private int specialValue = 0;

    public LZGT_RecipeBuilder() {}

    public LZGT_RecipeBuilder itemInputs(ItemStack... inputItems) {
        this.inputItems = inputItems;
        return this;
    }

    public LZGT_RecipeBuilder itemOutputs(ItemStack... outputItems) {
        this.outputItems = outputItems;
        return this;
    }

    public LZGT_RecipeBuilder fluidInputs(FluidStack... inputFluids) {
        this.inputFluids = inputFluids;
        return this;
    }

    public LZGT_RecipeBuilder fluidOutputs(FluidStack... outputFluids) {
        this.outputFluids = outputFluids;
        return this;
    }

    public LZGT_RecipeBuilder outputChances(int... outputChance) {
        this.outputChance = outputChance;
        return this;
    }

    public LZGT_RecipeBuilder eut(int eut) {
        this.eut = eut;
        return this;
    }

    public LZGT_RecipeBuilder eut(long eut) {
        this.eut = (int) eut;
        return this;
    }

    public LZGT_RecipeBuilder duration(int duration) {
        this.duration = duration;
        return this;
    }

    public LZGT_RecipeBuilder specialValue(int specialValue) {
        this.specialValue = specialValue;
        return this;
    }

    public LZGT_RecipeBuilder noOptimize() {
        return this;
    }

    public LZGT_RecipeBuilder addTo(RecipeMap<?> recipeMap) {
        GT_Recipe tempRecipe = new GT_Recipe(
            false,
            inputItems,
            outputItems,
            null,
            outputChance,
            inputFluids,
            outputFluids,
            duration,
            eut,
            specialValue);

        tempRecipe.mInputs = inputItems.clone();
        tempRecipe.mOutputs = outputItems.clone();

        recipeMap.add(tempRecipe);
        return this;
    }
}
