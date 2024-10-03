package com.underdog.insomnia.mixin;

import net.minecraft.world.dimension.NetherPortal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(NetherPortal.class)
public class NetherPortalMixin {

    /**
     * @author me
     * @reason idk
     */
    @Overwrite
    public boolean isValid() {
        // Always return false to prevent portal creation
        return false;
    }
}