package ru.ibusewinner.animals;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class DonateAPI {
	
	public static void createTable(){
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("CREATE TABLE IF NOT EXISTS donate (id INT(100), nick VARCHAR(100), gc INT(100)");
			ps.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void register(Player p) {
		try {
			PreparedStatement ps = MySQLAnimals.getStatement("INSERT INTO donate (id, nick, gc) VALUES (?, ?, ?)");
			ps.setInt(1,ps.getFetchSize()+1);
			ps.setString(2,p.getName());
			ps.setInt(3,0);
		}catch(Exception ex) {
			Bukkit.getConsoleSender().sendMessage(MainAnimals.prefix+"§cНевозможно зарегистрировать игрока "+p.getName());
		}
	}
	
	public static boolean isRegistered(Player p){
		try{
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM donate WHERE nick= ?");
			ps.setString(1, p.getName());
			ResultSet rs = ps.executeQuery();
			boolean user = rs.next();
			rs.close();
			rs.close();
			return user;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	public static int getGc(Player p) {
		try {
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM donate WHERE nick= ?");
			ps.setString(1, p.getName());
			ResultSet rs = ps.executeQuery();
			int gc = rs.getInt("gc");
			rs.close();
			rs.close();
			return gc;
		}catch(Exception ex) {
			Bukkit.getConsoleSender().sendMessage(MainAnimals.prefix+"§cЧто-то пошло не так!");
		}
		return -1;
	}
	
	public static int getGc(String name) {
		try {
			PreparedStatement ps = MySQLAnimals.getStatement("SELECT * FROM donate WHERE nick= ?");
			ps.setString(1,name);
			ResultSet rs = ps.executeQuery();
			int gc = rs.getInt("gc");
			rs.close();
			rs.close();
			return gc;
		}catch(Exception ex) {
			Bukkit.getConsoleSender().sendMessage(MainAnimals.prefix+"§cЧто-то пошло не так!");
		}
		return -1;
	}

	// returns: 1 - okay; 2 - no money; 3 - error; other - ???
	public static int removeGc(Player p, int sum) {
		try {
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE donate SET gc= ? WHERE nick= ?");
			ps.setString(2, p.getName());
			if (getGc(p) - sum < 0)
				return 2;
			ps.setInt(1,getGc(p)-sum);
			ResultSet rs = ps.executeQuery();
			rs.close();
			rs.close();
			return 1;
		}catch(Exception ex) {
			Bukkit.getConsoleSender().sendMessage(MainAnimals.prefix+"§cЧто-то пошло не так!");
			return 3;
		}
	}
	// returns: 1 - okay; 2 - no money; 3 - error; other - ???
	public static int removeGc(String name, int sum)
	{
		try {
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE donate SET gc= ? WHERE nick= ?");
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
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE donate SET gc= ? WHERE nick= ?");
			ps.setString(2, p.getName());
			ps.setInt(1,getGc(p)+sum);
			ResultSet rs = ps.executeQuery();
			rs.close();
			rs.close();
		}catch(Exception ex) {
			Bukkit.getConsoleSender().sendMessage(MainAnimals.prefix+"§cЧто-то пошло не так!");
		}
	}
	public static void addGc(String name, int sum) {
		try {
			PreparedStatement ps = MySQLAnimals.getStatement("UPDATE donate SET gc= ? WHERE nick= ?");
			ps.setString(2,name);
			ps.setInt(1,getGc(name)+sum);
			ResultSet rs = ps.executeQuery();
			rs.close();
			rs.close();
		}catch(Exception ex) {
			Bukkit.getConsoleSender().sendMessage(MainAnimals.prefix+"§cЧто-то пошло не так!");
		}
	}
	
}
