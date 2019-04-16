package de.ilovejava.utils;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;

import de.ilovejava.mysql.API_MySQL;
import de.ilovejava.serversystem.ServerSystem;
import lombok.Getter;
import lombok.Setter;
import net.md_5.bungee.api.ProxyServer;

public class Utils {
	@Getter @Setter
	public static ServerSystem instance;
	@Getter @Setter
	public static TS3Config config;
	@Getter @Setter
	public static TS3Query query;
	@Getter @Setter
	public static TS3Api api;
	@Getter @Setter
	public static String tsip;
	@Getter @Setter
	public static String queryname;
	@Getter @Setter
	public static String querypasswort;
	@Getter @Setter
	public static String quernickname;
	@Getter @Setter
	public static Integer tsqueryserver;
	@Getter @Setter
	public static String Host;
	@Getter @Setter
	public static String User;
	@Getter @Setter
	public static String Password;
	@Getter @Setter
	public static String Database;
	@Getter @Setter
	public static Integer Port;
	@Getter @Setter
	public static API_MySQL mysql;
	@Getter @Setter
	public static String prefix;
	@Getter @Setter
	public static boolean isbotenable;
	@Getter @Setter
	public static ProxyServer server;
	@Getter @Setter
	public static Integer ChannelGroup;
	@Getter @Setter
	public static boolean VerifyEnable;
}
