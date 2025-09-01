package com.gradyn.skellyBoiKeeper;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldguard.protection.regions.RegionQuery;
import org.bukkit.Location;

public class WorldguardLocationCheckHelper {
    private static final RegionContainer CONTAINER = WorldGuard.getInstance().getPlatform().getRegionContainer();
    private static final RegionQuery QUERY = CONTAINER.createQuery();

    public static boolean checkLocationForFlag(Location location, StateFlag flag) {
        return checkLocationForFlag(location, flag, null);
    }

    public static boolean checkLocationForFlag(Location location, StateFlag flag, com.sk89q.worldguard.protection.association.RegionAssociable subject) {
        com.sk89q.worldedit.util.Location worldeditLocation = BukkitAdapter.adapt(location);

        if (CONTAINER.get(BukkitAdapter.adapt(location.getWorld())) == null) return false;

        ApplicableRegionSet set = QUERY.getApplicableRegions(worldeditLocation);
        return set.testState(subject, flag);
    }
}
