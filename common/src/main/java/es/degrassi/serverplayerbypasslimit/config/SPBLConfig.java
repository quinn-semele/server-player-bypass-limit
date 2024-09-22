package es.degrassi.serverplayerbypasslimit.config;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Category;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "server_player_bypass_limit")
public class SPBLConfig implements ConfigData {
    @Comment("A list of ranks that can byPass the server limit")
    @Category("ranks")
    public List<String> byPassRanks = new LinkedList<>();
    @Comment("A list of permissions that can byPass the server limit")
    @Category("permissions")
    public Map<String, String> byPassPermissions = new LinkedHashMap<>();

    public static SPBLConfig get() {
        return AutoConfig.getConfigHolder(SPBLConfig.class).getConfig();
    }

    public static void changed() {
        AutoConfig.getConfigHolder(SPBLConfig.class).save();
        AutoConfig.getConfigHolder(SPBLConfig.class).load();
    }

    public boolean addRank(String rank) {
        if (byPassRanks.contains(rank)) {
            return false;
        }

        byPassRanks.add(rank); changed();

        return true;
    }

    public boolean removeRank(String rankToRemove) {
        if (!byPassRanks.contains(rankToRemove)) {
            return false;
        }

        byPassRanks.removeIf(rank -> rank.equals(rankToRemove)); changed();

        return true;
    }

    public boolean addPermission(String node, String value) {
        if (byPassPermissions.containsKey(node)) {
            return false;
        }

        byPassPermissions.put(node, value); changed();

        return true;
    }

    public boolean removePermissionByNode(String node) {
        if (!byPassPermissions.containsKey(node)) {
            return false;
        }

        String removed = byPassPermissions.remove(node); changed();

        return removed != null;
    }

    public boolean removePermissionByValue(String value) {
        return byPassPermissions.entrySet().stream()
                .filter(entry -> !value.equals(entry.getValue()))
                .allMatch(entry -> removePermissionByNode(entry.getKey()));
    }

    public boolean setPermission(String node, String value) {
        byPassPermissions.put(node, value); changed();

        return true;
    }
}
