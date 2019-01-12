package ru.ibusewinner.animals;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class APIAnimals {
	
	public static void createTable(){
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("CREATE TABLE IF NOT EXISTS players (name VARCHAR(100), uuid VARCHAR(100), animal INT(100)"
					+ ", gc INT(100), balance INT(100), level INT(100), income INT(100), localboost INT(100), respawns INT(100), hearts INT(100), humans INT(100), bizs INT(100)"
					+ ", shelter BOOLEAN, bizkol INT(100), bizfarm INT(100), bizderpri INT(100), bizgorpri INT(100), bizcirc INT(100), bizanipoy INT(100)"
					+ ", bizanipol INT(100), bizanicou INT(100), hum1 BOOLEAN, hum2 BOOLEAN, hum3 BOOLEAN, hum4 BOOLEAN, hum5 BOOLEAN, hum6 BOOLEAN, hum7 BOOLEAN"
					+ ", hum8 BOOLEAN, hum9 BOOLEAN)");
			ps.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public static void register(Player p){
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("INSERT INTO players (name, uuid, animal, gc, balance, level, income, localboost, respawns, hearts, humans, bizs"
					+ ", shelter, bizkol, bizfarm, bizderpri, bizgorpri, bizcirc, bizanipoy, bizanipol, bizanicou, hum1, hum2, hum3, hum4, hum5, hum6, hum7, hum8, hum9"
					+ ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1,p.getName());
			ps.setString(2,p.getUniqueId().toString());
			ps.setInt(3,0);
			ps.setInt(4,0);
			ps.setInt(5,0);
			ps.setInt(6,0);
			ps.setInt(7,0);
			ps.setInt(8,1);
			ps.setInt(9,0);
			ps.setInt(10,0);
			ps.setInt(11,0);
			ps.setInt(12,0);
			ps.setBoolean(13,false);
			ps.setInt(14,0);
			ps.setInt(15,0);
			ps.setInt(16,0);
			ps.setInt(17,0);
			ps.setInt(18,0);
			ps.setInt(19,0);
			ps.setInt(20,0);
			ps.setInt(21,0);
			ps.setBoolean(22,false);
			ps.setBoolean(23,false);
			ps.setBoolean(24,false);
			ps.setBoolean(25,false);
			ps.setBoolean(26,false);
			ps.setBoolean(27,false);
			ps.setBoolean(28,false);
			ps.setBoolean(29,false);
			ps.setBoolean(30,false);
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public static boolean isRegistered(Player p){
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE uuid= ?");
			ps.setString(1, p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			boolean user = rs.next();
			rs.close();
			ps.close();
			return user;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	public static boolean isRegistered(String name){
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE name= ?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			boolean user = rs.next();
			rs.close();
			ps.close();
			return user;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	
	public static int getBal(Player p){
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE uuid= ?");
			ps.setString(1, p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int balance = rs.getInt("balance");
			rs.close();
			ps.close();
			return balance;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}

	public static void addBal(Player p, int balance){
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET balance= ? WHERE uuid= ?");
			ps.setInt(1, getBal(p) + balance);
			ps.setString(2, p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public static void removeBal(Player p, int balance){
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET balance= ? WHERE uuid= ?");
			ps.setInt(1, getBal(p) - balance);
			ps.setString(2, p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static int getBal(String name){
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE name= ?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int balance = rs.getInt("balance");
			rs.close();
			ps.close();
			return balance;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}

	public static void addBal(String name, int balance){
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET balance= ? WHERE name= ?");
			ps.setInt(1, getBal(name) + balance);
			ps.setString(2, name);
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public static void removeBal(String name, int balance){
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET balance= ? WHERE name= ?");
			ps.setInt(1, getBal(name) - balance);
			ps.setString(2, name);
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void setAnimal(Player p, int animal) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET animal= ? WHERE uuid= ?");
			ps.setInt(1,animal);
			ps.setString(2, p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static int getAnimal(String name) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE name= ?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int animal = rs.getInt("animal");
			rs.close();
			ps.close();
			return animal;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return 0;
	}

	public static int getAnimal(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE uuid= ?");
			ps.setString(1, p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int animal = rs.getInt("animal");
			rs.close();
			ps.close();
			return animal;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return 0;
	}
	
	public static int getLevel(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE uuid= ?");
			ps.setString(1, p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int level = rs.getInt("level");
			rs.close();
			ps.close();
			return level;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	public static int getLevel(String name) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE name= ?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int level = rs.getInt("level");
			rs.close();
			ps.close();
			return level;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	public static void levelUp(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET level= ? WHERE uuid= ?");
			ps.setInt(1,getLevel(p)+1);
			ps.setString(2, p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static int getLocalBoost(String name) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE name= ?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int boost = rs.getInt("localboost");
			rs.close();
			ps.close();
			return boost;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	public static int getLocalBoost(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE uuid= ?");
			ps.setString(1, p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int boost = rs.getInt("localboost");
			rs.close();
			ps.close();
			return boost;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	public static void setLocalBoost(Player p, int boost) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET localboost= ? WHERE uuid= ?");
			ps.setInt(1,getLocalBoost(p)*boost);
			ps.setString(2,p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void removeLocalBoost(Player p, int boost) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET localboost= ? WHERE uuid= ?");
			ps.setInt(1,getLocalBoost(p)/boost);
			ps.setString(2,p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static int getIncome(String name) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE name= ?");
			ps.setString(1,name);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int income = rs.getInt("income");
			rs.close();
			ps.close();
			return income;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	public static int getIncome(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE uuid= ?");
			ps.setString(1, p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int income = rs.getInt("income");
			rs.close();
			ps.close();
			return income;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	public static void addBalBoost(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET balance= ? WHERE uuid= ?");
			ps.setInt(1, getBal(p) + (getIncome(p) * getLocalBoost(p) * Booostoor.agboostm * Booostoor.gboostm));
			ps.setString(2, p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static int getRespawns(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE uuid= ?");
			ps.setString(1, p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int income = rs.getInt("respawns");
			rs.close();
			ps.close();
			return income;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	public static int getRespawns(String name) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE name= ?");
			ps.setString(1,name);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int respawns = rs.getInt("respawns");
			rs.close();
			ps.close();
			return respawns;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	public static void addRespawn(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET respawns= ? WHERE uuid= ?");
			ps.setInt(1,getRespawns(p)+1);
			ps.setString(2, p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void addIncome(Player p, int income) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET income= ? WHERE uuid= ?");
			ps.setInt(1,getIncome(p)+income);
			ps.setString(2,p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static int getHearts(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE uuid= ?");
			ps.setString(1,p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int hearts = rs.getInt("hearts");
			rs.close();
			ps.close();
			return hearts;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	public static int getHearts(String name) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE name= ?");
			ps.setString(1,name);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int hearts = rs.getInt("hearts");
			rs.close();
			ps.close();
			return hearts;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	public static void addHearts(Player p, int hearts) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET hearts= ? WHERE uuid= ?");
			ps.setInt(1,getHearts(p)+hearts);
			ps.setString(2,p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void addHearts(String name, int hearts) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET hearts= ? WHERE name= ?");
			ps.setInt(1,getHearts(name)+hearts);
			ps.setString(2,name);
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void removeHearts(Player p, int hearts) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET hearts= ? WHERE uuid= ?");
			ps.setInt(1,getHearts(p)-hearts);
			ps.setString(2,p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void removeHearts(String name, int hearts) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET hearts= ? WHERE name= ?");
			ps.setInt(1,getHearts(name)-hearts);
			ps.setString(2,name);
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static int getHumans(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE uuid= ?");
			ps.setString(1,p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int humans = rs.getInt("humans");
			rs.close();
			ps.close();
			return humans;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	public static int getHumans(String name) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE name= ?");
			ps.setString(1,name);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int humans = rs.getInt("humans");
			rs.close();
			ps.close();
			return humans;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	public static void addHuman(Player p, int human) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET humans= ? WHERE uuid= ?");
			ps.setInt(1,getHumans(p)+human);
			ps.setString(2,p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static int getBizs(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE uuid= ?");
			ps.setString(1,p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int humans = rs.getInt("bizs");
			rs.close();
			ps.close();
			return humans;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	public static int getBizs(String name) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE name= ?");
			ps.setString(1,name);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int bizs = rs.getInt("bizs");
			rs.close();
			ps.close();
			return bizs;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	public static void addBiz(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET bizs= ? WHERE uuid= ?");
			ps.setInt(1,getBizs(p)+1);
			ps.setString(2,p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void setShelter(Player p, boolean shelter) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET shelter= ? WHERE uuid= ?");
			ps.setBoolean(1,shelter);
			ps.setString(2,p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static boolean isShelter(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE uuid= ?");
			ps.setString(1,p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			boolean shelter = rs.getBoolean("shelter");
			rs.close();
			ps.close();
			return shelter;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	public static void resetPlayer(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("DELETE FROM players WHERE uuid= ?");
			ps.setString(2,p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static int getBizKol(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE uuid= ?");
			ps.setString(1, p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int bizs = rs.getInt("bizkol");
			rs.close();
			ps.close();
			return bizs;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	public static int getBizFarm(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE uuid= ?");
			ps.setString(1, p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int bizs = rs.getInt("bizfarm");
			rs.close();
			ps.close();
			return bizs;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	public static int getBizDerPri(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE uuid= ?");
			ps.setString(1, p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int bizs = rs.getInt("bizderpri");
			rs.close();
			ps.close();
			return bizs;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	public static int getBizGorPri(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE uuid= ?");
			ps.setString(1, p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int bizs = rs.getInt("bizgorpri");
			rs.close();
			ps.close();
			return bizs;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	public static int getBizCirc(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE uuid= ?");
			ps.setString(1, p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int bizs = rs.getInt("bizcirc");
			rs.close();
			ps.close();
			return bizs;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	public static int getBizAniPoy(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE uuid= ?");
			ps.setString(1, p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int bizs = rs.getInt("bizanipoy");
			rs.close();
			ps.close();
			return bizs;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	public static int getBizAniPol(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE uuid= ?");
			ps.setString(1, p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int bizs = rs.getInt("bizanipol");
			rs.close();
			ps.close();
			return bizs;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	public static int getBizAniCou(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE uuid= ?");
			ps.setString(1, p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int bizs = rs.getInt("bizanicou");
			rs.close();
			ps.close();
			return bizs;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	public static int getHum1(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE uuid= ?");
			ps.setString(1, p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int bizs = rs.getInt("hum1");
			rs.close();
			ps.close();
			return bizs;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	public static int getHum2(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE uuid= ?");
			ps.setString(1, p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int bizs = rs.getInt("hum2");
			rs.close();
			ps.close();
			return bizs;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	public static int getHum3(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE uuid= ?");
			ps.setString(1, p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int bizs = rs.getInt("hum3");
			rs.close();
			ps.close();
			return bizs;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	public static int getHum4(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE uuid= ?");
			ps.setString(1, p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int bizs = rs.getInt("hum4");
			rs.close();
			ps.close();
			return bizs;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	public static int getHum5(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE uuid= ?");
			ps.setString(1, p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int bizs = rs.getInt("hum5");
			rs.close();
			ps.close();
			return bizs;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	public static int getHum6(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE uuid= ?");
			ps.setString(1, p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int bizs = rs.getInt("hum6");
			rs.close();
			ps.close();
			return bizs;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	public static int getHum7(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE uuid= ?");
			ps.setString(1, p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int bizs = rs.getInt("hum7");
			rs.close();
			ps.close();
			return bizs;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	public static int getHum8(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE uuid= ?");
			ps.setString(1, p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int bizs = rs.getInt("hum8");
			rs.close();
			ps.close();
			return bizs;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	public static int getHum9(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE uuid= ?");
			ps.setString(1, p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int bizs = rs.getInt("hum9");
			rs.close();
			ps.close();
			return bizs;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	public static void addBizKol(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET bizkol= ? WHERE uuid= ?");
			ps.setInt(1,getBizKol(p)+1);
			ps.setString(2,p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void addBizFarm(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET bizfarm= ? WHERE uuid= ?");
			ps.setInt(1,getBizFarm(p)+1);
			ps.setString(2,p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void addBizDerPri(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET bizderpri= ? WHERE uuid= ?");
			ps.setInt(1,getBizDerPri(p)+1);
			ps.setString(2,p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void addBizGorPri(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET bizgorpri= ? WHERE uuid= ?");
			ps.setInt(1,getBizGorPri(p)+1);
			ps.setString(2,p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void addBizCirc(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET bizcirc= ? WHERE uuid= ?");
			ps.setInt(1,getBizCirc(p)+1);
			ps.setString(2,p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void addBizAniPoy(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET bizanipoy= ? WHERE uuid= ?");
			ps.setInt(1,getBizAniPoy(p)+1);
			ps.setString(2,p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void addBizAniPol(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET bizanipol= ? WHERE uuid= ?");
			ps.setInt(1,getBizAniPol(p)+1);
			ps.setString(2,p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void addBizAniCou(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET bizanicou= ? WHERE uuid= ?");
			ps.setInt(1,getBizAniCou(p)+1);
			ps.setString(2,p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void addHum1(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET hum1= ? WHERE uuid= ?");
			ps.setBoolean(1,true);
			ps.setString(2,p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void addHum2(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET hum2= ? WHERE uuid= ?");
			ps.setBoolean(1,true);
			ps.setString(2,p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void addHum3(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET hum3= ? WHERE uuid= ?");
			ps.setBoolean(1,true);
			ps.setString(2,p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void addHum4(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET hum4= ? WHERE uuid= ?");
			ps.setBoolean(1,true);
			ps.setString(2,p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void addHum5(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET hum5= ? WHERE uuid= ?");
			ps.setBoolean(1,true);
			ps.setString(2,p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void addHum6(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET hum6= ? WHERE uuid= ?");
			ps.setBoolean(1,true);
			ps.setString(2,p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void addHum7(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET hum7= ? WHERE uuid= ?");
			ps.setBoolean(1,true);
			ps.setString(2,p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void addHum8(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET hum8= ? WHERE uuid= ?");
			ps.setBoolean(1,true);
			ps.setString(2,p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void addHum9(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET hum9= ? WHERE uuid= ?");
			ps.setBoolean(1,true);
			ps.setString(2,p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void boostTimer(Player p, int timer) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET boostTime= ? WHERE uuid= ?");
			ps.setInt(1,timer);
			ps.setString(2,p.getUniqueId().toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static int boostTime(Player p) {
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE uuid= ?");
			ps.setString(1, p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int time = rs.getInt("boostTime");
			rs.close();
			ps.close();
			return time;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
	
	
	
	public static int getGc(Player p) {
		return getGc(p.getName());
	}
	
	public static int getGc(String name) {
		try {
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM players WHERE name= ?");
			ps.setString(1,name);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int gc = rs.getInt("gc");
			rs.close();
			ps.close();
			return gc;
		}catch(Exception ex) {
			Bukkit.getConsoleSender().sendMessage(MainAnimals.prefix+"§cЧто-то пошло не так!");
			ex.printStackTrace();
		}
		return -1;
	}

	// returns: 1 - okay; 2 - no money; 3 - error;
	public static int removeGc(Player p, int sum) {
		return removeGc(p.getName(), sum);
	}
	// returns: 1 - okay; 2 - no money; 3 - error; other - ???
	public static int removeGc(String name, int sum)
	{
		try {
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET gc= ? WHERE name= ?");
			ps.setString(2, name);
			if (getGc(name) - sum < 0)
				return 2;
			ps.setInt(1,getGc(name)-sum);
			ResultSet rs = ps.executeQuery();
			rs.close();
			return 1;
		}catch(Exception ex) {
			Bukkit.getConsoleSender().sendMessage(MainAnimals.prefix+"§cЧто-то пошло не так!");
			return 3;
		}
	}
	
	public static void addGc(Player p, int sum) {
		try {
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET gc= ? WHERE name= ?");
			ps.setString(2, p.getName());
			ps.setInt(1,getGc(p)+sum);
			ResultSet rs = ps.executeQuery();
			rs.close();
			ps.close();
		}catch(Exception ex) {
			Bukkit.getConsoleSender().sendMessage(MainAnimals.prefix+"§cЧто-то пошло не так!");
		}
	}
	public static void addGc(String name, int sum) {
		try {
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE players SET gc= ? WHERE name= ?");
			ps.setString(2,name);
			ps.setInt(1,getGc(name)+sum);
			ResultSet rs = ps.executeQuery();
			rs.close();
			ps.close();
		}catch(Exception ex) {
			Bukkit.getConsoleSender().sendMessage(MainAnimals.prefix+"§cЧто-то пошло не так!");
		}
	}
}
