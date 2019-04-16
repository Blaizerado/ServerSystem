package de.ilovejava.events;

import de.ilovejava.checkban.CheckBan;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class Event_Join implements Listener {
	@EventHandler
	public void onJoin(PostLoginEvent e) {
		new CheckBan(e.getPlayer());
	}
}
