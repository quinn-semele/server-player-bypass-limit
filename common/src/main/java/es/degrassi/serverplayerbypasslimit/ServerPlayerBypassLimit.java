package es.degrassi.serverplayerbypasslimit;

import com.mojang.brigadier.CommandDispatcher;
import dev.architectury.event.events.common.CommandRegistrationEvent;
import es.degrassi.serverplayerbypasslimit.command.SPBLCommand;
import es.degrassi.serverplayerbypasslimit.config.SPBLConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public final class ServerPlayerBypassLimit {
    public static final String MOD_ID = "serverplayerbypasslimit";

    public static void init() {
        AutoConfig.register(SPBLConfig.class, JanksonConfigSerializer::new);
        CommandRegistrationEvent.EVENT.register(ServerPlayerBypassLimit::registerCommands);
    }

    private static void registerCommands(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext registry, Commands.CommandSelection selection) {
        dispatcher.register(SPBLCommand.register("serverplayerbypasslimit"));
        dispatcher.register(SPBLCommand.register("spbl"));
    }
}
