package com.gradyn.skellyBoiKeeper.Events;

import com.gradyn.skellyBoiKeeper.WorldguardLocationCheckHelper;
import io.papermc.paper.event.entity.EntityMoveEvent;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static com.gradyn.skellyBoiKeeper.SkellyBoiKeeper.KEEP_SKELLYBOIS_FLAG;

public class EntityMoveEventListener implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void EntityMoveEventHandler(EntityMoveEvent event) {
        if (event.getEntityType() != EntityType.WITHER_SKELETON) return;

        // only bother when they actually step into a new block (reduce churn)
        if (event.getFrom().getBlockX() == event.getTo().getBlockX()
                && event.getFrom().getBlockY() == event.getTo().getBlockY()
                && event.getFrom().getBlockZ() == event.getTo().getBlockZ()) return;

        WitherSkeleton entity = (WitherSkeleton) event.getEntity();

        boolean isInFarm = WorldguardLocationCheckHelper.checkLocationForFlag(event.getTo(), KEEP_SKELLYBOIS_FLAG);

        entity.setRemoveWhenFarAway(!isInFarm);
    }

}
