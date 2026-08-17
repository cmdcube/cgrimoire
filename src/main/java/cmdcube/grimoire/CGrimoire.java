package cmdcube.grimoire;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CGrimoire implements ModInitializer {
	public static final String MOD_ID = "cgrimoire";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		CGrmoireItems.init();
		LOGGER.info("ItsLanker is a goon!");
		LOGGER.info("[CGrimoire] loaded successfully!");
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
