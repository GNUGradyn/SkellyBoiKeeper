package com.gradyn.skellyBoiKeeper.Events;

import com.gradyn.skellyBoiKeeper.WorldguardLocationCheckHelper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPortalEvent;

import static com.gradyn.skellyBoiKeeper.SkellyBoiKeeper.KEEP_SKELLYBOIS_FLAG;

public class EntityPortalEventListener implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void EntityPortalEventHandler(EntityPortalEvent event) {
        if (event.getEntityType() != EntityType.WITHER_SKELETON) return;
        WitherSkeleton entity = (WitherSkeleton) event.getEntity();

        boolean inFarm = WorldguardLocationCheckHelper.checkLocationForFlag(entity.getLocation(), KEEP_SKELLYBOIS_FLAG);
        entity.setRemoveWhenFarAway(!inFarm);
    }
}
