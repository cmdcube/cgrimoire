package cmdcube.grimoire.client;

import cmdcube.grimoire.CGrimoire;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.EndRodParticle;

public class CGrimoireClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ParticleFactoryRegistry.getInstance().register(CGrimoire.SPARKLE_PARTICLE, EndRodParticle.Provider::new);
	}
}