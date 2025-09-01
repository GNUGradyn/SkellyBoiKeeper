package com.gradyn.skellyBoiKeeper;

import com.gradyn.skellyBoiKeeper.Events.EntitySpawnEventListener;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.flags.Flag;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.flags.registry.FlagConflictException;
import com.sk89q.worldguard.protection.flags.registry.FlagRegistry;
import org.bukkit.plugin.java.JavaPlugin;

public final class SkellyBoiKeeper extends JavaPlugin {
    public static StateFlag KEEP_SKELLYBOIS_FLAG;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EntitySpawnEventListener(), this);

        FlagRegistry registry = WorldGuard.getInstance().getFlagRegistry();
        try {
            StateFlag flag = new StateFlag("keep-skellybois", true);
            registry.register(flag);
            KEEP_SKELLYBOIS_FLAG = flag;
        } catch (FlagConflictException e) {
            Flag<?> existing = registry.get("keep-skellybois");
            if (existing instanceof StateFlag) {
                KEEP_SKELLYBOIS_FLAG = (StateFlag) existing;
            } else {
                throw new RuntimeException("Uhh.. somehow you have another \"keep-skellybois\" bool flag??");
            }
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
