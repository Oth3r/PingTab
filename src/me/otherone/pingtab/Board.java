package me.otherone.pingtab;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

public class Board {

    public static void loop(Plugin plugin) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective obj = board.registerNewObjective("PingTab:Ping", "dummy", "ping");
        obj.setDisplaySlot(DisplaySlot.PLAYER_LIST);

        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : plugin.getServer().getOnlinePlayers()) {
                    Score score = obj.getScore(player.getName());
                    score.setScore(Ping.get(player));
                    player.setScoreboard(board);
                }
                if (Bukkit.getOnlinePlayers().size() == 0) {
                    cancel();
                }
            }
        }.runTaskTimerAsynchronously(plugin, 0L, 20L);
    }

    public static void make(Player player) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective obj = board.registerNewObjective("PingTab:Ping", "dummy", "ping");
        obj.setDisplaySlot(DisplaySlot.PLAYER_LIST);
        Score score = obj.getScore(player.getName());
        score.setScore(Ping.get(player));
        player.setScoreboard(board);
    }
}
