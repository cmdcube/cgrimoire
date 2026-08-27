package cmdcube.grimoire;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CGrimoire implements ModInitializer {
	public static final String MOD_ID = "cgrimoire";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final SimpleParticleType SPARKLE_PARTICLE = FabricParticleTypes.simple();

	@Override
	public void onInitialize() {
		CGrmoireItems.init();
		CGrimoireBlocks.init();
		LOGGER.info("ItsLanker is a goon!");
		LOGGER.info("[CGrimoire] loaded successfully!");
		Registry.register(BuiltInRegistries.PARTICLE_TYPE, Identifier.fromNamespaceAndPath(MOD_ID, "sparkle_particle"), SPARKLE_PARTICLE);
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}