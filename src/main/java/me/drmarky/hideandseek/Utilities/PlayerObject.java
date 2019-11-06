package me.drmarky.hideandseek.Utilities;

import com.github.intellectualsites.plotsquared.plot.object.Plot;

public class PlayerObject {

    public Team team;
    public Plot plot;

    public PlayerObject(Team team, Plot plot) {
        this.team = team;
        this.plot = plot;
    }
}
