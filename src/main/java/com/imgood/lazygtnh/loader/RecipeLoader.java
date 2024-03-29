package com.imgood.lazygtnh.loader;

import com.imgood.lazygtnh.LazyGTNH;
import com.imgood.lazygtnh.recipe.IRecipePool;
import com.imgood.lazygtnh.recipe.machineRecipe.HyperdimensionalResonanceEvolverRecipePool;

public class RecipeLoader {

    public static void loadRecipes() {
        IRecipePool[] recipePools = new IRecipePool[] { new HyperdimensionalResonanceEvolverRecipePool() };

        for (IRecipePool recipePool : recipePools) {
            LazyGTNH.LOG.info("Loading recipes:" + recipePool);
            recipePool.loadRecipes();
        }

    }

}
