package ru.ibusewinner.animals.holos;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import ru.ibusewinner.animals.MainAnimals;
import ü.TTA_HoloAPI;

public class SetupHoloAnimals implements Listener{
	public Location loc;
	public TTA_HoloAPI holo = new TTA_HoloAPI();
	public ArrayList<String> lines = new ArrayList<String>();
	
	@SuppressWarnings("unchecked")
	public void setupHolo(String name) {
		
		try {
			World world = Bukkit.getWorld(MainAnimals.cfg.getString("holograms."+name+".world"));
			loc = new Location(world,MainAnimals.cfg.getDouble("holograms."+name+".x"),MainAnimals.cfg.getDouble("holograms."+name+".y"),MainAnimals.cfg.getDouble("holograms."+name+".z"));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		lines.addAll((Collection<? extends String>) MainAnimals.cfg.getList("holograms."+name+".text"));
		holo.createHolo(loc,lines);
	}
	@EventHandler
	public void displayHolos(PlayerJoinEvent e) {
		holo.displayHolo(e.getPlayer());
	}
	@EventHandler
	public void destroyHolos(PlayerQuitEvent e) {
		holo.destroyHolo(e.getPlayer());
	}
	
}
