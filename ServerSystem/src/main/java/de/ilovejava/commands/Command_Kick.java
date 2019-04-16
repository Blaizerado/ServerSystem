package de.ilovejava.commands;

import de.ilovejava.utils.Utils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Command_Kick extends Command {

	public Command_Kick(String name) {
		super(name);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(sender instanceof ProxiedPlayer) {
			ProxiedPlayer p = (ProxiedPlayer) sender;
			if(!p.hasPermission("SYS.Kick")) {p.sendMessage(Utils.getPrefix() + "§cDas darfst du nicht!"); return;}
			if(args.length == 0) {
				p.sendMessage("§b/kick [Player] [Grund]");
			}else if(args.length == 1) {
				if(Utils.getServer().getPlayer(args[0]).isConnected()) {
					ProxiedPlayer target = Utils.getServer().getPlayer(args[0]);
					if(!target.hasPermission("SYS.Protect.Ignore")) {
						target.disconnect("§6Achtung, §c"+target.getName()+"§6, du wurdest soeben vom Server gekickt\n\nVon: "+ p.getName());
					}else {p.sendMessage(Utils.getPrefix() + "§cAchtung, Der Spieler §6"+target.getName()+"§c ist geschützt!");}
				}
			}else if(args.length >= 2) {
				if(Utils.getServer().getPlayer(args[0]).isConnected()) {
					ProxiedPlayer target = Utils.getServer().getPlayer(args[0]);
					if(!target.hasPermission("SYS.Protect.Ignore")) {
						String msg = null;
						for(int i = 0; i<args.length; i++) {
							msg = msg+" "+args[i];
						}
						msg = msg.replace("null", "");
						msg = msg.replace(target.getName(), "");
						target.disconnect("§6Achtung, §c"+target.getName()+"§6, du wurdest soeben vom Server gekickt\n\nVon: §c"+ p.getName()+"\n§6Grund: §c"+msg);
					}else {p.sendMessage(Utils.getPrefix() + "§cAchtung, Der Spieler §6"+target.getName()+"§c ist geschützt!");}
				}
			}
		}
	}

}
