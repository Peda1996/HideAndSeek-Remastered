package me.drmarky.hideandseek;

import me.drmarky.hideandseek.Events.PlayerMoveListener;
import me.drmarky.hideandseek.Tasks.GenerateWinner;
import me.drmarky.hideandseek.Tasks.RegisterPlayers;
import me.drmarky.hideandseek.Tasks.StartGame;
import me.drmarky.hideandseek.Tasks.StopGame;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        PluginDescriptionFile pdfFile = getDescription();
        Logger logger = getLogger();

        logger.info(pdfFile.getName() + " has been enabled. (V." + pdfFile.getVersion() + ")");

        registerEvents();

        new HideAndSeekCommand(new RegisterPlayers(), new StartGame(this), new StopGame());
    }

    @Override
    public void onDisable() {
        PluginDescriptionFile pdfFile = getDescription();
        Logger logger = getLogger();

        logger.info(pdfFile.getName() + " has been disabled. (V." + pdfFile.getVersion() + ")");
    }

    private void registerEvents() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerMoveListener(new GenerateWinner(), new StopGame()), this);
    }

}
