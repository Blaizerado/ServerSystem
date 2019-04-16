package de.ilovejava.commands;

import de.ilovejava.mysql.API_MySQL_PlayerData;
import de.ilovejava.utils.Utils;
import de.ilovejava.uuid.uuidfetcher;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Command_Protect extends Command {

	public Command_Protect(String name) {
		super(name);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(sender instanceof ProxiedPlayer) {
			ProxiedPlayer p = (ProxiedPlayer) sender;
			if(!p.hasPermission("SYS.Pro.*")) {p.sendMessage("§cAchtung, du darfst das nicht!"); return;}
			if(args.length == 0) {
				p.sendMessage("§b/Protect pro [User]");
				p.sendMessage("§b/Protect del [User]");
			}else if(args.length == 1) {
				p.sendMessage("§b/Protect pro [User]");
				p.sendMessage("§b/Protect del [User]");
			}else if(args.length == 2) {
				if(args[0].equalsIgnoreCase("pro")) {
					String Player = args[1];
					if(!API_MySQL_PlayerData.isUserNameExists(Player)) {p.sendMessage(Utils.getPrefix() + "§cAchtung, der Spieler §6"+Player+"§c wurde nicht gefunden!"); return;}
					String uuid = uuidfetcher.getUUID(Player).toString(); 
					if(API_MySQL_PlayerData.isExists(uuid)) {
						API_MySQL_PlayerData.setProectedUser(uuid, 1);
						p.sendMessage(Utils.getPrefix()+"§bDer User §6" + Player + "§b ist nun Geschützt!");
					}else {p.sendMessage(Utils.getPrefix() + "§cAchtung, der Spieler §6"+ Player+"§c ist nicht in der Datenbank!");}
					return;
					
				}else if(args[0].equalsIgnoreCase("del")) {
					String Player = args[1];
					if(!API_MySQL_PlayerData.isUserNameExists(Player)) {p.sendMessage(Utils.getPrefix() + "§cAchtung, der Spieler §6"+Player+"§c wurde nicht gefunden!"); return;}
					String uuid = uuidfetcher.getUUID(Player).toString();  
					if(API_MySQL_PlayerData.isExists(uuid)) {
						API_MySQL_PlayerData.setProectedUser(uuid, 0);
						p.sendMessage(Utils.getPrefix() + "§bAchtung, der Spieler §6"+ Player + "§b ist nun nicht mehr Geschützt!");
					}else {p.sendMessage(Utils.getPrefix() + "§cAchtung, der Spieler §6"+ Player+"§c ist nicht in der Datenbank!");}
					return;
					
				}
			}
		}
	}

}
