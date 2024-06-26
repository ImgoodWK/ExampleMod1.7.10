package com.imgood.lazygtnh.nei;

import static gregtech.api.enums.Mods.NotEnoughItems;

import net.minecraft.nbt.NBTTagCompound;

import com.imgood.lazygtnh.LazyGTNH;

import cpw.mods.fml.common.event.FMLInterModComms;
import gregtech.api.interfaces.tileentity.RecipeMapWorkable;

/**
 * Handle NEI tags.
 * <li>Rewrite {@link RecipeMapWorkable#getAvailableRecipeMaps()} to auto handle GT machine's NEI tag if you are working
 * on a new GT machine which can process many recipe maps.
 */
public class NEIHandler {

    public static void IMCSender() {

        sendHandler("lzgt.recipe.HyperdimensionalResonanceEvolverRecipes", "gregtech:gt.blockmachines:10000");

        sendCatalyst("lzgt.recipe.HyperdimensionalResonanceEvolverRecipes", "gregtech:gt.blockmachines:10000");

    }

    private static void sendHandler(String aName, String aBlock) {
        NBTTagCompound aNBT = new NBTTagCompound();
        aNBT.setString("handler", aName);
        aNBT.setString("modName", LazyGTNH.MOD_NAME);
        aNBT.setString("modId", LazyGTNH.MODID);
        aNBT.setBoolean("modRequired", true);
        aNBT.setString("itemName", aBlock);
        aNBT.setInteger("handlerHeight", 135);
        aNBT.setInteger("handlerWidth", 166);
        aNBT.setInteger("maxRecipesPerPage", 1);
        aNBT.setInteger("yShift", 6);
        FMLInterModComms.sendMessage("NotEnoughItems", "registerHandlerInfo", aNBT);
    }

    private static void sendCatalyst(String aName, String aStack) {
        NBTTagCompound aNBT = new NBTTagCompound();
        aNBT.setString("handlerID", aName);
        aNBT.setString("itemName", aStack);
        FMLInterModComms.sendMessage("NotEnoughItems", "registerCatalystInfo", aNBT);
    }

    private static void sendCatalyst(String aName, String aStack, int aPriority) {
        NBTTagCompound aNBT = new NBTTagCompound();
        aNBT.setString("handlerID", aName);
        aNBT.setString("itemName", aStack);
        aNBT.setInteger("priority", aPriority);
        FMLInterModComms.sendMessage(NotEnoughItems.ID, "registerCatalystInfo", aNBT);
    }
}
