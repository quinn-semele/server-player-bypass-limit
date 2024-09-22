package es.degrassi.serverplayerbypasslimit.fabric;

import es.degrassi.serverplayerbypasslimit.ServerPlayerBypassLimit;
import net.fabricmc.api.ModInitializer;

public final class ServerPlayerBypassLimitFabric implements ModInitializer {
    public void onInitialize() {
        ServerPlayerBypassLimit.init();
    }
}
