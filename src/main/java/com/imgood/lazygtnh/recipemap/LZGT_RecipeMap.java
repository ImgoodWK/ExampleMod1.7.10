package com.imgood.lazygtnh.recipemap;

import com.imgood.lazygtnh.LZGT_ItemList;
import com.imgood.lazygtnh.recipemap.recipeMapFrontends.LZGT_GeneralFrontend;

import gregtech.api.gui.modularui.GT_UITextures;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.RecipeMapBuilder;

public class LZGT_RecipeMap {

    public static final RecipeMap<LZGT_RecipeMapBackend> hyperdimensionalResonanceEvolverRecipes = RecipeMapBuilder
        // At the same time , the localization key of the NEI Name
        // of this page.
        .of("lzgt.recipe.hyperdimensionalResonanceEvolverRecipes", LZGT_RecipeMapBackend::new)
        .maxIO(4, 16, 4, 8)
        .progressBar(GT_UITextures.PROGRESSBAR_ARROW_MULTIPLE)
        .frontend(LZGT_GeneralFrontend::new)
        .neiHandlerInfo(
            builder -> builder.setDisplayStack(LZGT_ItemList.HyperdimensionalResonanceEvolver.get(1))
                .setMaxRecipesPerPage(1))
        .disableOptimize()
        .build();

}
