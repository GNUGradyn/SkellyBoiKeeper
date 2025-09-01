package com.gradyn.skellyBoiKeeper;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldguard.protection.regions.RegionQuery;
import org.bukkit.Location;

public class WorldguardLocationCheckHelper {
    public static boolean CheckLocationForFlag (Location location, StateFlag flag) {
        return CheckLocationForFlag(location, flag, null);
    }

    public static boolean CheckLocationForFlag (Location location, StateFlag flag, com.sk89q.worldguard.protection.association.RegionAssociable subject) {
        com.sk89q.worldedit.util.Location worldeditLocation = BukkitAdapter.adapt(location);

        RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionManager regions = container.get(BukkitAdapter.adapt(location.getWorld()));
        if (regions == null) return false;

        RegionQuery query = container.createQuery();
        ApplicableRegionSet set = query.getApplicableRegions(worldeditLocation);
        return set.testState(subject, flag);
    }
}
