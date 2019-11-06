package me.drmarky.hideandseek.Events;

import com.github.intellectualsites.plotsquared.plot.object.Plot;
import com.github.intellectualsites.plotsquared.plot.object.PlotPlayer;
import me.drmarky.hideandseek.Tasks.GenerateWinner;
import me.drmarky.hideandseek.Tasks.StopGame;
import me.drmarky.hideandseek.Utilities.Data;
import me.drmarky.hideandseek.Utilities.Utils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PlayerTeleportListener implements Listener {

    private final GenerateWinner generateWinner;
    private final StopGame stopGame;

    public PlayerTeleportListener(GenerateWinner generateWinner, StopGame stopGame) {
        this.generateWinner = generateWinner;
        this.stopGame = stopGame;
    }

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent e) {

        Player player = e.getPlayer();
        PlotPlayer plotPlayer = PlotPlayer.get(player.getName());

        // CHECK that they left the plot
        if (Data.directory.containsKey(plotPlayer)) {
            Plot plot = Data.directory.get(plotPlayer).plot;
            if (!(plot.getPlayersInPlot().contains(plotPlayer))) {
                Utils.sendListMessage(Utils.getPlayers(plot), ChatColor.GOLD + plotPlayer.getName() + ChatColor.GRAY + " has left the game.");
                Utils.removePlayer(plotPlayer);
                generateWinner.generateWinner(plot);
            }
        }
    }

}