package com.gradyn.skellyBoiKeeper.Events;

import com.gradyn.skellyBoiKeeper.WorldguardLocationCheckHelper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static com.gradyn.skellyBoiKeeper.SkellyBoiKeeper.KEEP_SKELLYBOIS_FLAG;

public class EntitySpawnEventListener implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onEntitySpawn(org.bukkit.event.entity.CreatureSpawnEvent event) {
        if (event.getEntityType() != EntityType.WITHER_SKELETON) return;
        WitherSkeleton entity = (WitherSkeleton) event.getEntity();

        boolean inFarm = WorldguardLocationCheckHelper.checkLocationForFlag(entity.getLocation(), KEEP_SKELLYBOIS_FLAG);
        entity.setRemoveWhenFarAway(!inFarm);
    }
}
