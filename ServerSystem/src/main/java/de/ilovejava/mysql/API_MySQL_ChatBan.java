package de.ilovejava.mysql;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.UUID;

import de.ilovejava.utils.Utils;
import de.ilovejava.uuid.uuidfetcher;

public class API_MySQL_ChatBan {
	public static boolean hasTimeBan(String UUID) {
		ResultSet rs = Utils.getMysql().query("SELECT * FROM ServerSystem_ChatBans WHERE UUID='"+UUID+"' ORDER BY active='1'");
		try {
			if(rs.next()) {
				if(rs.getLong("UnbanTime") >= 1) {
					return true;
				}
			}
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
	
	public static boolean hasPermaBan(String UUID) {
		ResultSet rs = Utils.getMysql().query("SELECT * FROM ServerSystem_ChatBans WHERE UUID='"+UUID+"' ORDER BY active='1'");
		try {
			if(rs.next()) {
				if(rs.getLong("UnbanTime") == 0) {
					return true;
				}
			}
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
	
	public static void createTimeBan(String UUID, String Banner, String Reason, Long TimeBan) {
		Utils.getMysql().update("INSERT INTO ServerSystem_ChatBans(UUID,UnbanTime,Reason,Banner,active) VALUES('"+UUID+"','"+TimeBan+"','"+Reason+"','"+Banner+"','1')");
	}
	
	public static void createPermaBan(String UUID, String Banner, String Reason) {
		Utils.getMysql().update("INSERT INTO ServerSystem_ChatBans(UUID,UnbanTime,Reason,Banner,active) VALUES('"+UUID+"','0','"+Reason+"','"+Banner+"','1')");
	}
	
	public static String getTimeBanReason(String uuid) {
		ResultSet rs = Utils.getMysql().query("SELECT * FROM ServerSystem_ChatBans WHERE UUID='"+uuid+"' ORDER BY active='1'");
		String msg = null;
		try {
			if(rs.next()) {
				SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
				msg = "§c§o§lAchtung, du wurdest vom Chat ausgeschlossen\n\n§6Grund: §c"+rs.getString("Reason")+"§6\nVon: §c"+uuidfetcher.getName(UUID.fromString(rs.getString("Banner")))+
						"\n§6Bis: §c"+df.format(rs.getLong("UnbanTime"));
			}
		}catch(Exception e) {e.printStackTrace();}
		return msg;
	}
	
	public static String getPermaBanReason(String uuid) {
		ResultSet rs = Utils.getMysql().query("SELECT * FROM ServerSystem_ChatBans WHERE UUID='"+uuid+"' ORDER BY active='1'");
		String msg = null;
		try {
			if(rs.next()) {
				msg = "§c§o§lAchtung, du wurdest vom Chat ausgeschlossen\n\n§6Grund: §c"+rs.getString("Reason")+"\n§6Von: §c"+uuidfetcher.getName(UUID.fromString(rs.getString("Banner")))+"\n§6Bis: Unendlich!";
			}
		}catch(Exception e) {e.printStackTrace();}
		return msg;
	}
}
