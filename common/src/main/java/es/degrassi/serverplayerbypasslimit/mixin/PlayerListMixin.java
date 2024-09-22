package es.degrassi.serverplayerbypasslimit.mixin;

import com.mojang.authlib.GameProfile;
import dev.ftb.mods.ftbranks.api.FTBRanksAPI;
import dev.ftb.mods.ftbranks.api.RankManager;

import java.util.concurrent.atomic.AtomicBoolean;

import es.degrassi.serverplayerbypasslimit.config.SPBLConfig;
import net.minecraft.server.dedicated.DedicatedPlayerList;
import net.minecraft.server.players.PlayerList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({PlayerList.class, DedicatedPlayerList.class})
public abstract class PlayerListMixin {
    @Inject(
            at = {@At("RETURN")},
            method = {"canBypassPlayerLimit"},
            cancellable = true
    )
    public void canBypassPlayerLimit(GameProfile gameProfile, CallbackInfoReturnable<Boolean> cir) {
        AtomicBoolean shouldBypassLimit = new AtomicBoolean(cir.getReturnValue());

        if (shouldBypassLimit.get()) {
            return;
        }

        RankManager manager = FTBRanksAPI.manager();
        SPBLConfig config = SPBLConfig.get();

        config.byPassRanks.forEach(rank -> {
            manager.getRank(rank).ifPresent(Rank -> {
                shouldBypassLimit.set(shouldBypassLimit.get() || manager.getAddedRanks(gameProfile).contains(Rank));
            });
        });

        config.byPassPermissions.forEach((permission, value) -> {
            manager.getAddedRanks(gameProfile).forEach(rank -> {
                shouldBypassLimit.set(shouldBypassLimit.get() || rank.getPermission(permission).equals(FTBRanksAPI.getInstance().parsePermissionValue(value)));
            });
        });

        cir.setReturnValue(shouldBypassLimit.get());
    }
}
