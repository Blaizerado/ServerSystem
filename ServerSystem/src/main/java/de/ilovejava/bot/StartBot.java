package de.ilovejava.bot;


import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;

import de.ilovejava.utils.Utils;
import net.md_5.bungee.api.ProxyServer;

public class StartBot {
	@SuppressWarnings("deprecation")
	public StartBot() {
		if(Utils.isbotenable) {
			ProxyServer.getInstance().getConsole().sendMessage("§bTeamspeak Bot wird gestartet!");
			Utils.setConfig(new TS3Config());
			Utils.setQuery(new TS3Query(Utils.getConfig()));
			Utils.setApi(Utils.getQuery().getApi());
			Utils.getConfig().setHost(Utils.getTsip());
			Utils.getQuery().connect();
			Utils.getApi().login(Utils.getQueryname(), Utils.getQuerypasswort());
			if(Utils.getQuery().isConnected()) {Utils.getServer().getConsole().sendMessage("§bDer Teamspeak bot wurde erfolgreich verbunden!");}else { Utils.getServer().getConsole().sendMessage("§cAchtung es gab einen Fehler beim Teamspeak Bot!");return;}
			Utils.getApi().selectVirtualServerById(Utils.getTsqueryserver());
			Utils.getApi().setNickname(Utils.getQuernickname());
			Utils.getServer().getConsole().sendMessage("§bLade Teamspeak Events!");
			new Teamspeak_Events();
		}else {
			Utils.getServer().getConsole().sendMessage("§cDer Teamspeak bot wurde angestellt!");
		}
	}
}
