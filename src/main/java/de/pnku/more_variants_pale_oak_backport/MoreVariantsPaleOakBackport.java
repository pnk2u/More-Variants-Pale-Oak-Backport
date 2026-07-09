package de.pnku.more_variants_pale_oak_backport;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class MoreVariantsPaleOakBackport implements ModInitializer {
	public static final String MOD_ID = "more_variants_pale_oak_backport";
	public static final String MOD_NAME = "More Variants: Pale Oak Backport";
	public static final String PACK_ID = "compatibility_data";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);
	public static final List<String> known_valid_mod_ids = List.of(
			"vanillabackport"
	);

	
	@Override
	public void onInitialize() {
		RegistryEntryAddedCallback.event(BuiltInRegistries.BLOCK).register((rawId, id, block) -> {
			if (id.equals(ResourceLocation.withDefaultNamespace("pale_oak_planks"))) {
				LOGGER.info("Pale Oak Planks block added to registry, adding Pale Oak variants for compatible Mods.");
			}
		});
		ResourceManagerHelper.registerBuiltinResourcePack(
				withModId(PACK_ID),
				FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow(),
				Component.translatable(String.join(".","resourcePack", MOD_ID, PACK_ID, "name")),
				ResourcePackActivationType.ALWAYS_ENABLED
		);
	}

	public static ResourceLocation withModId(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}

}
