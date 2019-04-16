package de.ilovejava.events;

import de.ilovejava.mysql.API_MySQL_ChatBan;
import de.ilovejava.utils.Utils;
import de.ilovejava.uuid.uuidfetcher;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class Event_Chat implements Listener {
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onChat(ChatEvent e) {
		ProxiedPlayer p = (ProxiedPlayer) e.getSender();
		String uuid = uuidfetcher.getUUID(p.getName()).toString();
		if(API_MySQL_ChatBan.hasPermaBan(uuid)) {
			p.sendMessage(Utils.getPrefix()+API_MySQL_ChatBan.getPermaBanReason(uuid));
			e.setCancelled(true);
		}
	}
}
