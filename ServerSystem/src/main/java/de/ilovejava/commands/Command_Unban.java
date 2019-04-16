package de.ilovejava.commands;

import de.ilovejava.mysql.API_MySQL_Ban;
import de.ilovejava.utils.Utils;
import de.ilovejava.uuid.uuidfetcher;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Command_Unban extends Command {

	public Command_Unban(String name) {
		super(name);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(sender instanceof ProxiedPlayer) {
			ProxiedPlayer p = (ProxiedPlayer) sender;
			if(args.length == 0) {
				p.sendMessage("§b/unban Player");
			}else if(args.length == 1) {
				String Player = args[0];
				String uuid = uuidfetcher.getUUID(args[0]).toString();
				if(API_MySQL_Ban.isPermaBaned(uuid)) {
					API_MySQL_Ban.unPermaBan(uuid);
					p.sendMessage(Utils.getPrefix() + "§cAchtung, du hast den Spieler §6"+Player +"§c entbannt");
				}else if(API_MySQL_Ban.isTimeBaned(uuid)) {
					API_MySQL_Ban.unTimeBan(uuid);
					p.sendMessage(Utils.getPrefix() + "§cAchtung, du hast den Spieler §6"+Player +"§c entbannt");
				}else {
					p.sendMessage(Utils.getPrefix() + "§cAchtung, der Spieler ist nicht Online!");
				}
			}
		}
	}

}
