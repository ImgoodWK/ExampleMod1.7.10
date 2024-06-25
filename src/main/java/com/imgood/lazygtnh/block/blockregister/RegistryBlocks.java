package com.imgood.lazygtnh.block.blockregister;

import com.imgood.lazygtnh.LazyGTNH;
import com.imgood.lazygtnh.block.BasicBlocks;
import com.imgood.lazygtnh.block.BlockHRERender;
import com.imgood.lazygtnh.tiles.rendertiles.TileHREFeild;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegistryBlocks {
    public static void registryBlocks() {
        GameRegistry.registerTileEntity(TileHREFeild.class, "HREFeildRender");
        BasicBlocks.Block_HRERender = new BlockHRERender();
        LazyGTNH.logger.info("testmsgHREFeildRender666");
    }
}
