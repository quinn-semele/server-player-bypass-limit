package es.degrassi.serverplayerbypasslimit.command;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import es.degrassi.serverplayerbypasslimit.config.SPBLConfig;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class SPBLCommand {
    private static final String rankId = "rank_id";
    private static final String permissionId = "permission_id";
    private static final String value = "value";

    public static LiteralArgumentBuilder<CommandSourceStack> register(String name) {
        return Commands.literal(name).requires(source -> source.hasPermission(3)).then(ranks()).then(permissions());
    }

    private static ArgumentBuilder<CommandSourceStack, ?> ranks() {
        return Commands.literal("rank").then(Commands.literal("add").then(Commands.argument(rankId, StringArgumentType.word()).executes(ctx -> {
            String rank = ctx.getArgument(rankId, String.class);

            if (ctx.getSource().getEntity() instanceof ServerPlayer player) {
                if (SPBLConfig.get().addRank(rank)) {
                    player.sendSystemMessage(Component.literal(String.format("Rank %s added successfully", rank)));
                } else {
                    player.sendSystemMessage(Component.literal(String.format("Rank %s could not be added", rank)));
                }
            }

            return 0;
        }
        ))).then(Commands.literal("remove").then(Commands.argument(rankId, StringArgumentType.word()).executes(ctx -> {
            String rank = ctx.getArgument(rankId, String.class);

            if (ctx.getSource().getEntity() instanceof ServerPlayer player) {
                if (SPBLConfig.get().removeRank(rank)) {
                    player.sendSystemMessage(Component.literal(String.format("Rank %s removed successfully", rank)));
                } else {
                    player.sendSystemMessage(Component.literal(String.format("Rank %s could not be removed", rank)));
                }
            }

            return 0;
        })));
    }

    private static ArgumentBuilder<CommandSourceStack, ?> permissions() {
        return Commands.literal("permission").then(Commands.literal("add").then(Commands.argument(permissionId, StringArgumentType.word()).then(Commands.argument(value, StringArgumentType.word()).executes(ctx -> {
            String permission = ctx.getArgument(permissionId, String.class);
            String val = ctx.getArgument(value, String.class);

            if (ctx.getSource().getEntity() instanceof ServerPlayer player) {
                if (SPBLConfig.get().addPermission(permission, val)) {
                    player.sendSystemMessage(Component.literal(String.format("Permission %s with value %s added successfully", permission, val)));
                } else {
                    player.sendSystemMessage(Component.literal(String.format("Permission %s with value %s could not be added", permission, val)));
                }
            }

            return 0;
        })))).then(Commands.literal("remove").then(Commands.literal("node").then(Commands.argument(permissionId, StringArgumentType.word()).executes(ctx -> {
            String permission = ctx.getArgument(permissionId, String.class);

            if (ctx.getSource().getEntity() instanceof ServerPlayer player) {
                if (SPBLConfig.get().removePermissionByNode(permission)) {
                    player.sendSystemMessage(Component.literal(String.format("Permission with id %s removed successfully", permission)));
                } else {
                    player.sendSystemMessage(Component.literal(String.format("Permission %s could not be removed", permission)));
                }
            }

            return 0;
        }))).then(Commands.literal(value).then(Commands.argument(value, StringArgumentType.word()).executes(ctx -> {
            String val = ctx.getArgument(value, String.class);

            if (ctx.getSource().getEntity() instanceof ServerPlayer player) {
                if (SPBLConfig.get().removePermissionByValue(val)) {
                    player.sendSystemMessage(Component.literal(String.format("Permissions with value %s removed successfully", val)));
                } else {
                    player.sendSystemMessage(Component.literal(String.format("Permission with value %s could not be removed", val)));
                }
            }

            return 0;
        })))).then(Commands.literal("set").then(Commands.argument(permissionId, StringArgumentType.word()).then(Commands.argument(value, StringArgumentType.word()).executes(ctx -> {
            String permission = ctx.getArgument(permissionId, String.class);
            String val = ctx.getArgument(value, String.class);

            if (ctx.getSource().getEntity() instanceof ServerPlayer player) {
                if (SPBLConfig.get().setPermission(permission, val)) {
                    player.sendSystemMessage(Component.literal(String.format("Set permission %s with value %s successfully", permission, val)));
                } else {
                    player.sendSystemMessage(Component.literal(String.format("Permission %s with value %s could not be set", permission, val)));
                }
            }

            return 0;
        }))));
    }
}
