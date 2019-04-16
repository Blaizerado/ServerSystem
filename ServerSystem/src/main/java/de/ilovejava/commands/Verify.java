package de.ilovejava.commands;

import com.github.theholywaffle.teamspeak3.api.wrapper.Client;

import de.ilovejava.utils.Utils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Verify extends Command {
	int i = 0;
	public Verify(String name) {
		super(name);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(sender instanceof ProxiedPlayer) {
			ProxiedPlayer p = (ProxiedPlayer) sender;
			if(Utils.isVerifyEnable()) {
				if(args.length == 0) {
					for(Client c : Utils.getApi().getClients()) {
						if(c.getNickname().equals(p.getName())) {
							i = 1;
							if(!c.isInServerGroup(Utils.getChannelGroup())) {
								Utils.getApi().addClientToServerGroup(Utils.getChannelGroup(), c.getDatabaseId());
								Utils.getApi().sendPrivateMessage(c.getId(), "Herzlich willkommen auf Mingoland.de du wurdest soeben aktiviert!");
								p.sendMessage(Utils.getPrefix()+"ßbßoßlDu bist nun aktiviert!");
							}else {p.sendMessages(Utils.getPrefix()+"ßcßoßlAchtung, du bist bereits aktivert!");}
						}
					}
					if(i == 0) {p.sendMessage(Utils.getPrefix()+"ßbßoßlAchtung, bitte Logge dich im Teamspeak Mingoland.de ein!\nBeachte das du im Teamspeak genau so heiﬂt wie in Minecraft!");}
				}else {p.sendMessage(Utils.getPrefix()+"Bitte gib /verify ein!");}
			}else {p.sendMessage(Utils.getPrefix()+"ßcßoßlAchtung, das Verify System ist zur Zeit nicht Aktiv!");}
		}
	}

}
