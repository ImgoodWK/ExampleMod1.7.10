package com.imgood.lazygtnh.block.textures;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class IiconTextures {

    public IiconTextures() {

    }

    private IIcon icon;
    private static final String loc_HyperDimensionalResonanceEvolverField = "lazygtnh:rendering/HyperDimensionalResonanceEvolverField.png";

    public void registerIcons(IIconRegister iregister) {
        this.icon = iregister.registerIcon((loc_HyperDimensionalResonanceEvolverField));
    }

    public IIcon getIcon() {
        return this.icon;
    }
}
