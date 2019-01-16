package ru.ibusewinner.animals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.bukkit.Bukkit;

public class MySQLAnimals {
	
	public static String host = "127.0.0.1";
	public static String port = "3306";
	public static String database = "animals";
	public static String user = "root";
	public static String password = "V6HY8mbR1dvZiG"; // V6HY8mbR1dvZiG
	
	public static Connection con;
	
	public static boolean isConnected() {
		return con != null;
	}
	
	public static void connect(){
		if(!isConnected()){
			try {
				con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+database+"?autoReconnect=true",user,password);
				Bukkit.getConsoleSender().sendMessage(MainAnimals.prefix+"§aПодключено успешно! || Successfully connected!");
			} catch (Exception e) {
				Bukkit.getConsoleSender().sendMessage(MainAnimals.prefix+"§cОшибка при подключении к MySQL || Error with connecting to MySQL.");
				e.printStackTrace();
			}
		}
	}
	
	public static void disconnect(){
		try {
			con.close();
			Bukkit.getConsoleSender().sendMessage(MainAnimals.prefix+"§aУспешно отключено! || Successfully disconnected!");
		} catch (Exception e) {
			Bukkit.getConsoleSender().sendMessage(MainAnimals.prefix+"§cОшибка при отключении от MySQL || Error with disconnecting from MySQL.");
			e.printStackTrace();
		}
	}
	
	public static PreparedStatement getStatement(String sql){
		if(isConnected()){
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(sql);
				return ps;
			} catch (Exception e) {
				Bukkit.getConsoleSender().sendMessage(MainAnimals.prefix+"§cОшибка при получении какой-то фигни || Error with getting kakou-to figni.");
			}
		}
		return null;
	}
	
	public static ResultSet getResult(String sql){
		if(isConnected()){
			PreparedStatement ps;
			ResultSet rs;
			try {
				ps = getStatement(sql);
				rs = ps.executeQuery();
				return rs;
			} catch (Exception e) {
				Bukkit.getConsoleSender().sendMessage(MainAnimals.prefix+"§cОшибка при получении результата || Error with getting result.");
			}
		}
		return null;
	}
	
}
