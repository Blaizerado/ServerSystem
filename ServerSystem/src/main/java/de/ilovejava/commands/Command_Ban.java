package de.ilovejava.commands;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import de.ilovejava.mysql.API_MySQL_Ban;
import de.ilovejava.mysql.API_MySQL_PlayerData;
import de.ilovejava.utils.Utils;
import de.ilovejava.uuid.uuidfetcher;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Command_Ban extends Command {

	public Command_Ban(String name) {
		super(name);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(sender instanceof ProxiedPlayer) {
			ProxiedPlayer p = (ProxiedPlayer) sender;
			if(!p.hasPermission("Ban.info")) {p.sendMessage("§cAchtung, du darfst das nicht!"); return;}
			if(args.length == 0) {
				p.sendMessage("§b/Ban Player [ID]");
				p.sendMessage("§6 1: Beleidigung/Trolling->{30 Minuten}");
				p.sendMessage("§6 2: Harte Beleidigung/Zerstörung->{60 Minuten}");
				p.sendMessage("§6 3: Schwere Beleidigung/Falsches Verhalten ->{2 Stunden}");
				p.sendMessage("§6 4: Support Ausnutzung/Lügen ->{12 Stunden}");
				p.sendMessage("§6 5: Bug Use/Betrug->{24 Stunden}");
				p.sendMessage("§6 6: Arbeit´s Behinderung/Verhetzung->{48 Stunden}");
				p.sendMessage("§6 7: Abwerben/Werbung->{7 Tage}");
				p.sendMessage("§6 8: Server feindliches Verhalten/Server Beleidigung->{14 Tage}");
				p.sendMessage("§6 9: Leichtes Hacken->{30 Tage}");
				p.sendMessage("§6 10: Schweres Hacken->{60 Tage}");
				p.sendMessage("§6 11: Hartes Hacken->{6 Monate}");
				p.sendMessage("§6 12: Harter Regel Verstoß->{Perma}");
				p.sendMessage("§6 13: Developer Ban->{Perma(Mit Ip Ban)}");
			}else if(args.length == 1) {
				p.sendMessage("§b/Ban Player [ID]");
			}else if(args.length == 2) {
				String Player = args[0];
				Integer i = Integer.valueOf(args[1]);
				if(API_MySQL_PlayerData.isExists(uuidfetcher.getUUID(Player).toString())) {
					if(!API_MySQL_Ban.isPermaBaned(uuidfetcher.getUUID(Player).toString()) && !API_MySQL_Ban.isTimeBaned(uuidfetcher.getUUID(Player).toString())) {
						String uuid = uuidfetcher.getUUID(Player).toString();
						String buuid = uuidfetcher.getUUID(p.getName()).toString();
						Date d = new Date();
						
						switch (i) {
						case 1:
							if(!p.hasPermission("Ban.execute.1")) {p.sendMessage("§cAchtung, du darfst das nicht!");}
							d.setMinutes(d.getMinutes()+30);
							createTimeBan(uuid, d.getTime(), buuid, "Beleidigung/Trolling", Player);
							break;
						case 2:
							if(!p.hasPermission("Ban.execute.2")) {p.sendMessage("§cAchtung, du darfst das nicht!");}
							d.setMinutes(d.getMinutes()+60);
							createTimeBan(uuid, d.getTime(), buuid, "Harte Beleidigung/Zerstörung", Player);
							break;
						case 3:
							if(!p.hasPermission("Ban.execute.3")) {p.sendMessage("§cAchtung, du darfst das nicht!");}
							d.setHours(d.getHours()+2);
							createTimeBan(uuid, d.getTime(), buuid, "Schwere Beleidigung/Falsches Verhalten", Player);
							break;
						case 4:
							if(!p.hasPermission("Ban.execute.4")) {p.sendMessage("§cAchtung, du darfst das nicht!");}
							d.setHours(d.getHours()+12);
							createTimeBan(uuid, d.getTime(), buuid, "Support Ausnutzung/Lügen", Player);
							break;
						case 5:
							if(!p.hasPermission("Ban.execute.5")) {p.sendMessage("§cAchtung, du darfst das nicht!");}
							d.setHours(d.getHours()+24);
							createTimeBan(uuid, d.getTime(), buuid, "Bug Use/Betrug", Player);
							break;
						case 6:
							if(!p.hasPermission("Ban.execute.6")) {p.sendMessage("§cAchtung, du darfst das nicht!");}
							d.setHours(d.getHours()+48);
							createTimeBan(uuid, d.getTime(), buuid, "Arbeit´s Behinderung/Verhetzung", Player);
							break;
						case 7:
							if(!p.hasPermission("Ban.execute.7")) {p.sendMessage("§cAchtung, du darfst das nicht!");}
							d.setHours(d.getHours()+24*7);
							createTimeBan(uuid, d.getTime(), buuid, "Abwerben/Werbung",Player);
							break;
						case 8:
							if(!p.hasPermission("Ban.execute.8")) {p.sendMessage("§cAchtung, du darfst das nicht!");}
							d.setHours(d.getHours()+24*14);
							createTimeBan(uuid, d.getTime(), buuid, "Server feindliches Verhalten/Server Beleidigung", Player);
							break;
						case 9:
							if(!p.hasPermission("Ban.execute.9")) {p.sendMessage("§cAchtung, du darfst das nicht!");}
							d.setHours(d.getHours()+24*30);
							createTimeBan(uuid, d.getTime(), buuid, "Leichtes Hacken", Player);
							break;
						case 10:
							if(!p.hasPermission("Ban.execute.10")) {p.sendMessage("§cAchtung, du darfst das nicht!");}
							d.setHours(d.getHours()+24*60);
							createTimeBan(uuid, d.getTime(), buuid, "Schweres Hacken",Player);
							break;
						case 11:
							if(!p.hasPermission("Ban.execute.11")) {p.sendMessage("§cAchtung, du darfst das nicht!");}
							d.setMonth(d.getMonth()+6);
							createTimeBan(uuid, d.getTime(), buuid, "Hartes Hacken",Player);
							break;
						case 12:
							if(!p.hasPermission("Ban.execute.12")) {p.sendMessage("§cAchtung, du darfst das nicht!");}
							createPermBan(uuid, "Harter Regel Verstoß", buuid,Player);
							break;
						case 13:
							if(!p.hasPermission("Ban.execute.13")) {p.sendMessage("§cAchtung, du darfst das nicht!");}
							createPermBan(uuid, "Developer Ban", buuid,Player);
							break;
						default:
							break;
						}
						p.sendMessage(Utils.getPrefix() + "§cDu hast den Spieler §6"+Player + "§c vom Server gebannt!");
					}else {
						p.sendMessage(Utils.getPrefix() + "§cAchtung, der Spieler §6"+Player+"§c wurde bereits gebannt!");
					}
				}else {p.sendMessage(Utils.getPrefix() + "§cAchtung, der Spieler §6" + Player + "§c ist nicht in der Datenbank erfasst!");}
			}
		}
	}
	@SuppressWarnings("deprecation")
	private void createPermBan(String Player, String Reason, String Banner, String PlayerName) {
		SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		API_MySQL_Ban.createPermaBan(Player, Reason, Banner);
		if(Utils.getServer().getPlayer(PlayerName).isConnected()) {
			Utils.getServer().getPlayer(PlayerName).disconnect("§6Achtung §c"+PlayerName+"§6 du wurdest von Mingoland.de Gebannt\n\nGrund: §c"+Reason+"\n§6Von: §c" +uuidfetcher.getName(UUID.fromString(Banner))
			+"\n§6Gebannt am: §c"+df.format(new Date().getTime()) + " Uhr\n§6Entbannung: §cNiemals\n\n§6Solltest du denken das dieser Bann ungerecht ist?\nDann melde ich bei uns im Forum!");
		}else {
			System.out.println("Ist nicht Online!");
		}
	}
	
	@SuppressWarnings("deprecation")
	private void createTimeBan(String uuid, Long To, String Banner, String Reason, String PlayerName) {
		API_MySQL_Ban.createTimeBan(uuid, To, Banner, Reason);
		if(Utils.getServer().getPlayer(PlayerName).isConnected()) {
			SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
			Utils.getServer().getPlayer(PlayerName).disconnect("§6Achtung §c"+PlayerName+"§6 du wurdest von Mingoland.de Gebannt\n\nGrund: §c"+Reason+"\n§6Von: §c" +uuidfetcher.getName(UUID.fromString(Banner))
			+"\n§6Gebannt am: §c"+df.format(new Date().getTime()) + " Uhr\n§6Entbannung: §c"+df.format(To)+" Uhr\n\n§6Solltest du denken das dieser Bann ungerecht ist?\nDann melde ich bei uns im Forum!");
		}else {
			System.out.println("Ist nicht Online!");
		}
	}
}
