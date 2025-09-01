package com.gradyn.skellyBoiKeeper.Events;

import com.gradyn.skellyBoiKeeper.WorldguardLocationCheckHelper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

import static com.gradyn.skellyBoiKeeper.SkellyBoiKeeper.KEEP_SKELLYBOIS_FLAG;

public class EntitySpawnEventListener implements Listener {
    @EventHandler
    public void EntitySpawnEventHandler(EntitySpawnEvent event) {
        Entity entity = event.getEntity();

        if (entity.getType() != EntityType.WITHER_SKELETON) return;
        if (!WorldguardLocationCheckHelper.CheckLocationForFlag(entity.getLocation(), KEEP_SKELLYBOIS_FLAG)) return;

        ((WitherSkeleton)entity).setRemoveWhenFarAway(false);
    }
}
