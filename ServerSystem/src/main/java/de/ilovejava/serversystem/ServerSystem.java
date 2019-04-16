package de.ilovejava.serversystem;

import java.util.HashSet;

import de.ilovejava.bot.StartBot;
import de.ilovejava.commands.Command_Ban;
import de.ilovejava.commands.Command_Kick;
import de.ilovejava.commands.Command_Protect;
import de.ilovejava.commands.Command_Unban;
import de.ilovejava.commands.Verify;
import de.ilovejava.config.Config;
import de.ilovejava.events.Event_Chat;
import de.ilovejava.events.Event_Join;
import de.ilovejava.mysql.API_LoadMySQL;
import de.ilovejava.utils.Utils;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;

public class ServerSystem extends Plugin{
	@Override
	public void onEnable() {
		Utils.setInstance(this);
		Utils.setServer(ProxyServer.getInstance());
		new Config();
		new StartBot();
		new API_LoadMySQL();
		
		HashSet<Command> commands = new HashSet<>();
		commands.add(new Command_Ban("ban"));
		commands.add(new Command_Unban("unban"));
		commands.add(new Command_Protect("Protect"));
		commands.add(new Command_Kick("Kick"));
		commands.add(new Verify("verify"));
		for(Command c : commands) {
			Utils.getServer().getPluginManager().registerCommand(this, c);
		}
		
		HashSet<Listener> events = new HashSet<>();
		events.add(new Event_Join());
		events.add(new Event_Chat());
		for(Listener l : events) {
			Utils.getServer().getPluginManager().registerListener(this, l);
		}
	}
	
	@Override
	public void onDisable() {
		
	}
}
