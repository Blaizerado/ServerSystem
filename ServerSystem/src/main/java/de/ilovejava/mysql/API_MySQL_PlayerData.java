package de.ilovejava.mysql;

import java.sql.ResultSet;
import java.util.Date;

import de.ilovejava.utils.Utils;

public class API_MySQL_PlayerData {
	public static boolean isExists(String UUID) {
		ResultSet rs = Utils.getMysql().query("SELECT * FROM ServerSystem_PlayerData WHERE UUID='"+UUID+"'");
		try {
			if(rs.next()) {
				return true;
			}
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
	
	public static boolean isUserNameExists(String Name) {
		ResultSet rs = Utils.getMysql().query("SELECT * FROM ServerSystem_PlayerData WHERE LasName='"+Name+"'");
		try {
			if(rs.next()) {
				return true;
			}
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
	
	public static void createPlayer(String UUID, String Name, String IP) {
		Utils.getMysql().update("INSERT INTO ServerSystem_PlayerData(UUID,LasName,IP,FirstLogin,Protect) VALUES('"+UUID+"','"+Name+"','"+IP+"','"+new Date().getTime()+"','0')");
	}
	
	public static void setProectedUser(String UUID, Integer i) {
		Utils.getMysql().update("UPDATE ServerSystem_PlayerData SET Protect='"+i+"' WHERE UUID='"+UUID+"'");
	}
	
	public static boolean isProectedUser(String UUID) {
		ResultSet rs = Utils.getMysql().query("SELECT * FROM ServerSystem_PlayerData WHERE UUID='"+UUID+"'");
		try {
			if(rs.next()) {
				if(rs.getInt("Protect") == 1){
					return true;
				}
			}
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
}
