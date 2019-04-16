package de.ilovejava.mysql;

import de.ilovejava.utils.Utils;

public class API_LoadMySQL {
	public API_LoadMySQL() {
		Utils.setMysql(new API_MySQL(Utils.getHost(), Utils.getDatabase(), Utils.getUser(), Utils.getPassword(), Utils.getPort()));
		createTables();
	}
	
	private void createTables() {
		Utils.getMysql().update("CREATE TABLE IF NOT EXISTS ServerSystem_Bans(id MEDIUMINT NOT NULL AUTO_INCREMENT,PRIMARY KEY (id), UUID varchar(123), active boolean, Banreason varchar(900), Banner varchar(123), BanendTime long)");
		Utils.getMysql().update("CREATE TABLE IF NOT EXISTS ServerSystem_PlayerData(UUID varchar(123), LasName varchar(27), IP varchar(123), FirstLogin long, Protect int)");
		Utils.getMysql().update("CREATE TABLE IF NOT EXISTS ServerSystem_TimeBan(id MEDIUMINT NOT NULL AUTO_INCREMENT,PRIMARY KEY (id), UUID varchar(123), FirstBan long, Unban long, Banner varchar(123), Banreson varchar(900), active boolean)");
		Utils.getMysql().update("CREATE TABLE IF NOT EXISTS ServerSystem_ChatBans(id MEDIUMINT NOT NULL AUTO_INCREMENT,PRIMARY KEY (id), UUID varchar(123), UnbanTime long, Reason varchar(900), Banner varchar(123), active int)");
	}
}
