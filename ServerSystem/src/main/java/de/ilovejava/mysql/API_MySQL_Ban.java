package de.ilovejava.mysql;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import de.ilovejava.utils.Utils;
import de.ilovejava.uuid.uuidfetcher;

public class API_MySQL_Ban {
	public static void createPermaBan(String UUID, String Reason, String Banner) {
		Utils.getMysql().update("INSERT INTO ServerSystem_Bans(UUID,active,Banreason,Banner,BanendTime) VALUES('"+UUID+"','"+1+"','"+Reason+"','"+Banner+"','"+new Date().getTime()+"')");
	}
	
	public static void createTimeBan(String UUID, Long bis, String Banner, String reason) {
		Utils.getMysql().update("INSERT INTO ServerSystem_TimeBan(UUID,FirstBan,Unban,Banner,Banreson,active) VALUES('"+UUID+"','"+new Date().getTime()+"','"+bis+"','"+Banner+"','"+reason+"','1')");
	}
	
	public static boolean isTimeBaned(String UUID) {
		ResultSet rs = Utils.getMysql().query("SELECT * FROM ServerSystem_TimeBan WHERE UUID='"+UUID+"' ORDER BY active='1'");
		try {
			if(rs.next()) {
				if(rs.getInt("active") == 1) {
					return true;
				}
			}
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
	
	public static Long getTo(String UUID) {
		Long l = null;
		ResultSet rs = Utils.getMysql().query("SELECT * FROM ServerSystem_TimeBan WHERE UUID='"+UUID+"' ORDER BY active='1'");
		try {
			if(rs.next()) {
				l = rs.getLong("Unban");
			}
		}catch(Exception e) {e.printStackTrace();}
		return l;
	}
	
	public static void unTimeBan(String UUID) {
		Utils.getMysql().update("UPDATE ServerSystem_TimeBan SET active='0' WHERE UUID='"+UUID+"' ORDER BY active='1'");
	}
	
	public static void unPermaBan(String UUID) {
		Utils.getMysql().update("UPDATE ServerSystem_Bans SET active='0' WHERE UUID='"+UUID+"' ORDER BY active='1'");
		
	}
	
	public static String getTimeBanResource(String uuid) {
		String msg = null;
		ResultSet rs = Utils.getMysql().query("SELECT * FROM ServerSystem_TimeBan WHERE UUID='"+uuid+"' ORDER BY active='1'");
		try {
			if(rs.next()) {
				SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
				msg = "§6Achtung §c"+uuidfetcher.getName(UUID.fromString(rs.getString("UUID")))+"§6 du wurdest von Mingoland.de Gebannt\n\nGrund: §c"+rs.getString("Banreson")+"\n§6Von: §c" +uuidfetcher.getName(UUID.fromString(rs.getString("Banner")))
				+"\n§6Gebannt am: §c"+df.format(rs.getLong("FirstBan")) + " Uhr\n§6Entbannung: §c"+df.format(rs.getLong("Unban"))+" Uhr\n\n§6Solltest du denken das dieser Bann ungerecht ist?\nDann melde ich bei uns im Forum!";
			}
		}catch(Exception e) {e.printStackTrace();}
		msg = msg.replace("null", "");
		return msg;
	}
	
	public static String getPermaBanResource(String uuid) {
		String msg = null;
		ResultSet rs = Utils.getMysql().query("SELECT * FROM ServerSystem_Bans WHERE UUID='"+uuid+"' ORDER BY active='1'");
		try {
			if(rs.next()) {
				SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
				msg = "§6Achtung §c"+uuidfetcher.getName(UUID.fromString(rs.getString("UUID")))+"§6 du wurdest von Mingoland.de Gebannt\n\nGrund: §c"+rs.getString("Banreason")+"\n§6Von: §c" +uuidfetcher.getName(UUID.fromString(rs.getString("Banner")))
				+"\n§6Gebannt am: §c"+df.format(rs.getLong("BanendTime")) + " Uhr\n§6Entbannung: §cNiemals\n\n§6Solltest du denken das dieser Bann ungerecht ist?\nDann melde ich bei uns im Forum!";
			}
		}catch(Exception e) {e.printStackTrace();}
		return msg;
	}
	
	public static boolean isPermaBaned(String UUID) {
		ResultSet rs = Utils.getMysql().query("SELECT * FROM ServerSystem_Bans WHERE UUID='"+UUID+"' ORDER BY active='1'");
		try {
			if(rs.next()) {
				if(rs.getInt("active") == 1) {
					return true;
				}
			}
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
}
