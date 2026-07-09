package de.pnku.more_variants_pale_oak_backport.mixin;

import de.pnku.more_variants_core.util.MoreVariantRegistryHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

import static de.pnku.more_variants_pale_oak_backport.MoreVariantsPaleOakBackport.known_valid_mod_ids;
import static de.pnku.more_variants_pale_oak_backport.WoodTypes.PALE_OAK;

@Mixin(MoreVariantRegistryHelper.class)
public abstract class MoreVariantRegistryHelperMixin {
    @Inject(method = "whenItemRegistered", at = @At("HEAD"), remap = false)
    private static void injectedWhenItemRegisteredAtHead(ResourceLocation itemId, Consumer<Item> action, CallbackInfo ci) {
        if (itemId.equals(PALE_OAK.planksId())) {
            known_valid_mod_ids.forEach(modId -> {
                if (FabricLoader.getInstance().isModLoaded(modId)) {
                    action.accept(Items.AIR);
                }
            });
        }
    }
}
