package com.nitecell.nitepunishments.listeners;

import com.nitecell.nitepunishments.managers.PunishmentsManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

public class BanListener implements Listener {

    PunishmentsManager punishments = PunishmentsManager.getInstance();

    @EventHandler
    public void onLogin(AsyncPlayerPreLoginEvent event) {

        String targetUUID = event.getUniqueId().toString();
        Object statusPath = punishments.getPunishments().get("punishments." + targetUUID + ".bans.status");

        if (punishments.getPunishments().contains(targetUUID) && statusPath == "ACTIVE" ) {
            event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_BANNED, "You have been banned from the server.");
        }

    }
}
