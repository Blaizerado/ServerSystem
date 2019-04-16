package de.ilovejava.config;

import java.io.File;

import de.ilovejava.configuration.file.YamlConfiguration;
import de.ilovejava.utils.Utils;
import net.md_5.bungee.api.ChatColor;

public class Config {
	public Config() {
		File f = new File("plugins/ServerSystem","Config.cfg");
		isSet(f, "Config.Utils.Prefix", "&b&o&lServerSystem&8&o&l:&f&o&l ");
		isSet(f, "Config.Teamspeak.enable", true);
		isSet(f, "Config.Teamspeak.Ip", "127.0.0.1");
		isSet(f, "Config.Teamspeak.User", "serveradmin");
		isSet(f, "Config.Teamspeak.Password", "Password");
		isSet(f, "Config.Teamspeak.ServerID", 1);
		isSet(f, "Config.Teamspeak.Nickname", "Natic-API");
		isSet(f, "Config.MySQL.Host", "localhost");
		isSet(f, "Config.MySQL.User", "User");
		isSet(f, "Config.MySQL.Password", "Password");
		isSet(f, "Config.MySQL.Database", "DB");
		isSet(f, "Config.MySQL.Port", 3306);
		isSet(f, "Config.Settings.TeamspeakVerifyEnable", true);
		isSet(f, "Config.Settings.TeamspeakVerifyGroup", 0);
		getConfigData(f);
	}
	
	public void getConfigData(File f) {
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(f);
		Utils.setPrefix(ChatColor.translateAlternateColorCodes('&', cfg.getString("Config.Utils.Prefix")));
		Utils.setIsbotenable(cfg.getBoolean("Config.Teamspeak.enable"));
		Utils.setTsip(cfg.getString("Config.Teamspeak.Ip"));
		Utils.setQueryname(cfg.getString("Config.Teamspeak.User"));
		Utils.setQuerypasswort(cfg.getString("Config.Teamspeak.Password"));
		Utils.setTsqueryserver(cfg.getInt("Config.Teamspeak.ServerID"));
		Utils.setQuernickname(cfg.getString("Config.Teamspeak.Nickname"));
		Utils.setHost(cfg.getString("Config.MySQL.Host"));
		Utils.setUser(cfg.getString("Config.MySQL.User"));
		Utils.setPassword(cfg.getString("Config.MySQL.Password"));
		Utils.setDatabase(cfg.getString("Config.MySQL.Database"));
		Utils.setPort(cfg.getInt("Config.MySQL.Port"));
		Utils.setChannelGroup(cfg.getInt("Config.Settings.TeamspeakVerifyGroup"));
		Utils.setVerifyEnable(cfg.getBoolean("Config.Settings.TeamspeakVerifyEnable"));
	}
	
	private void isSet(File f, String key, Object obj) {
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(f);
		if(!cfg.isSet(key)) {
			cfg.set(key, obj);
			try {cfg.save(f);}catch(Exception e) {e.printStackTrace();}
		}
	}
}
