package de.pnku.more_variants_pale_oak_backport;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MoreVariantsPaleOakBackport implements ModInitializer {
	public static final String MOD_ID = "more_variants_pale_oak_backport";
	public static final String MOD_NAME = "More Variants: Pale Oak Backport";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

	
	@Override
	public void onInitialize() {
		RegistryEntryAddedCallback.event(BuiltInRegistries.BLOCK).register((rawId, id, block) -> {
			if (id.equals(ResourceLocation.withDefaultNamespace("pale_oak_planks"))) {
				LOGGER.info("Pale Oak Planks block added to registry, adding Pale Oak variants for compatible Mods.");
			}
		});
	}

	public static ResourceLocation withModId(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}

}
