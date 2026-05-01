package de.pnku.more_variants_pale_oak_backport.mixin;

import de.pnku.more_variants_core.util.WoodTypeHolder;
import de.pnku.more_variants_pale_oak_backport.WoodTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WoodTypeHolder.class)
public abstract class WoodTypeHolderMixin {
    @Inject(method = "init", at = @At("HEAD"), remap = false)
    private static void injectedInitAtHead(CallbackInfo ci) {
        WoodTypeHolder.addWoodTypes(WoodTypes.PALE_OAK);
    }
}
