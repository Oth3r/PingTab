package me.otherone.pingtab;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PingTab extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);

        if (Bukkit.getOnlinePlayers().size() != 0)
            Board.loop(this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (Bukkit.getOnlinePlayers().size() > 2)
            Board.loop(this);
    }

}
