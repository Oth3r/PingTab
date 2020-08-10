package me.otherone.pingtab;

import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;

public class Ping {

    public static int get(Player player) {
        int ping = 0;
        try {
            Object entityPlayer = player.getClass().getMethod("getHandle").invoke(player);
            ping = (int) entityPlayer.getClass().getField("ping").get(entityPlayer);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return ping;
    }
}
