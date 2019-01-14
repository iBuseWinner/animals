package ru.ibusewinner.animals;

import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import ü.TTA_HoloAPI;

public class HologramAPI 
{
	public static Map<String, TTA_HoloAPI> holos;
	public static Location location;

	public static void init() 
	{
		displayHolos();
	}
	
	public static void removeHolo(String name)
	{
		for (Player p : Bukkit.getOnlinePlayers()) 
			holos.get(name).destroyHolo(p);
		holos.remove(name);
	}
	
	public static void addHolo(String name, TTA_HoloAPI holo) // Добавляет новую голограмму в map
	{
		holos.put(name, holo);
		displayHolo(name);
	}
	public static void reloadHolos() 
	{
		for (TTA_HoloAPI holo : holos.values()) 
			for (Player p : Bukkit.getOnlinePlayers()) 
			{
				holo.destroyHolo(p);
				holo.displayHolo(p);				
			}
	}
	
	public static void displayHolos() // Показывает все голограммы всем игрокам
	{
		
		if (holos.size() > 0)
			for (TTA_HoloAPI holo : holos.values()) 
				for (Player p : Bukkit.getOnlinePlayers())
					holo.displayHolo(p);
	}
	public static void displayHolo(String name) // Показывает определённую голограмму всем игрокам
	{
		for (Player p : Bukkit.getOnlinePlayers())
			holos.get(name).displayHolo(p);
	}
	public static void displayHolos(Player p) // Показывает все голограммы одному игроку
	{
		for (TTA_HoloAPI holo : holos.values())
			holo.displayHolo(p);
	}
}
