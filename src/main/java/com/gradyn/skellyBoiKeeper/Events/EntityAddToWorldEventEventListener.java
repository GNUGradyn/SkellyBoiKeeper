package com.gradyn.skellyBoiKeeper.Events;

import com.destroystokyo.paper.event.entity.EntityAddToWorldEvent;
import com.gradyn.skellyBoiKeeper.WorldguardLocationCheckHelper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static com.gradyn.skellyBoiKeeper.SkellyBoiKeeper.KEEP_SKELLYBOIS_FLAG;

public class EntityAddToWorldEventEventListener implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void EntityPortalEventHandler(EntityAddToWorldEvent event) {
        if (event.getEntityType() != EntityType.WITHER_SKELETON) return;
        WitherSkeleton entity = (WitherSkeleton) event.getEntity();

        boolean inFarm = WorldguardLocationCheckHelper.checkLocationForFlag(entity.getLocation(), KEEP_SKELLYBOIS_FLAG);
        entity.setRemoveWhenFarAway(!inFarm);
    }
}
