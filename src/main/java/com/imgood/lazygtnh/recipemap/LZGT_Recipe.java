package com.imgood.lazygtnh.recipemap;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import com.imgood.lazygtnh.LZGT_ItemList;
import com.imgood.lazygtnh.recipemap.recipeMapFrontends.LZGT_GeneralFrontend;

import gregtech.api.gui.modularui.GT_UITextures;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.RecipeMapBackend;
import gregtech.api.recipe.RecipeMapBuilder;
import gregtech.api.util.GT_Recipe;

public class LZGT_Recipe extends GT_Recipe {

    public LZGT_Recipe(ItemStack[] aInputs, ItemStack[] aOutputs, Object aSpecialItems, int[] aChances,
        FluidStack[] aFluidInputs, FluidStack[] aFluidOutputs, int aDuration, int aEUt, int aSpecialValue) {
        super(
            false,
            aInputs,
            aOutputs,
            aSpecialItems,
            aChances,
            aFluidInputs,
            aFluidOutputs,
            aDuration,
            aEUt,
            aSpecialValue);
    }

    public static final RecipeMap<RecipeMapBackend> HyperdimensionalResonanceEvolverRecipes = RecipeMapBuilder
        // At the same time , the localization key of the NEI Name
        // of this page.
        .of("lzgt.recipe.HyperdimensionalResonanceEvolverRecipes")
        .maxIO(28, 28, 4, 4)
        .progressBar(GT_UITextures.PROGRESSBAR_ARROW_MULTIPLE)
        .neiHandlerInfo(builder -> builder.setDisplayStack(LZGT_ItemList.HyperdimensionalResonanceEvolver.get(1)))
        .disableOptimize()
        .frontend(LZGT_GeneralFrontend::new)
        .build();
}
