package de.ilovejava.checkban;

import java.util.Date;

import de.ilovejava.mysql.API_MySQL_Ban;
import de.ilovejava.mysql.API_MySQL_PlayerData;
import de.ilovejava.uuid.uuidfetcher;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class CheckBan {
	@SuppressWarnings("deprecation")
	public CheckBan(ProxiedPlayer p) {
		String UUID = uuidfetcher.getUUID(p.getName()).toString();
		if(!API_MySQL_PlayerData.isExists(UUID)) {
			API_MySQL_PlayerData.createPlayer(UUID, p.getName(), p.getAddress().getHostName());
		}
		
		if(API_MySQL_Ban.isTimeBaned(UUID)) {
			if(API_MySQL_Ban.getTo(UUID) >= new Date().getTime()) {
				p.disconnect(API_MySQL_Ban.getTimeBanResource(UUID));
			}else {API_MySQL_Ban.unTimeBan(UUID);}
		}else if(API_MySQL_Ban.isPermaBaned(uuidfetcher.getUUID(p.getName()).toString())) {
			p.disconnect(API_MySQL_Ban.getPermaBanResource(UUID));
		}
	}
}
