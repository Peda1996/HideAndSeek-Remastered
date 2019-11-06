package me.drmarky.hideandseek.Events;

import com.github.intellectualsites.plotsquared.plot.object.Plot;
import com.github.intellectualsites.plotsquared.plot.object.PlotPlayer;
import me.drmarky.hideandseek.Tasks.Tag;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageEntityListener implements Listener {

    private final Tag tag;

    public EntityDamageEntityListener(Tag tag) {
        this.tag = tag;
    }

    @EventHandler
    public void onEntityDamagebyEntity(EntityDamageByEntityEvent e) {

        if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
            tag.tag(PlotPlayer.get(e.getEntity().getName()), PlotPlayer.get(e.getDamager().getName()), PlotPlayer.get(e.getEntity().getName()).getCurrentPlot());
        }
    }

}
