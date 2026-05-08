package de.pnku.more_variants_pale_oak_backport.mixin;

import de.pnku.more_variants_core.util.MoreVariantWoodTypeHolder;
import de.pnku.more_variants_pale_oak_backport.WoodTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MoreVariantWoodTypeHolder.class)
public abstract class MoreVariantWoodTypeHolderMixin {
    @Inject(method = "init", at = @At("HEAD"), remap = false)
    private static void injectedInitAtHead(CallbackInfo ci) {
        MoreVariantWoodTypeHolder.addMoreVariantWoodTypes(WoodTypes.PALE_OAK);
    }
}
