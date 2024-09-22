package es.degrassi.serverplayerbypasslimit.forge;

import es.degrassi.serverplayerbypasslimit.ServerPlayerBypassLimit;
import net.neoforged.fml.common.Mod;

@Mod(ServerPlayerBypassLimit.MOD_ID)
public final class ServerPlayerBypassLimitNeoForge {
    public ServerPlayerBypassLimitNeoForge() {
        ServerPlayerBypassLimit.init();
    }
}
