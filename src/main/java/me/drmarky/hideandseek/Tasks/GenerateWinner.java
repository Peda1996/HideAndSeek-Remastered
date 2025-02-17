package me.drmarky.hideandseek.Tasks;

import com.github.intellectualsites.plotsquared.plot.object.Plot;
import me.drmarky.hideandseek.Utilities.Utils;
import org.bukkit.ChatColor;

public class GenerateWinner {

    private final StopGame stopGame;

    public GenerateWinner(StopGame stopGame) {
        this.stopGame = stopGame;
    }

    public void generateWinner(Plot plot) {

        if (Utils.getHiders(plot).size() == 0 || Utils.getSeekers(plot).size() == 0) {

            if (Utils.getHiders(plot).size() == 0) {
                Utils.sendListMessage(Utils.getPlayers(plot), "The " + ChatColor.RED + "seeker " + ChatColor.GRAY + "team has won!");
            } else if (Utils.getSeekers(plot).size() == 0) {
                Utils.sendListMessage(Utils.getPlayers(plot), "The " + ChatColor.BLUE + "hider " + ChatColor.GRAY + "team has won!");
            }

            stopGame.stopGame(plot, false);
        }
    }

}