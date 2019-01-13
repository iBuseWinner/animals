package ru.ibusewinner.animals;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class disableEverythink implements Listener{
	@EventHandler
	public void onSpawn(EntitySpawnEvent e) {
		e.setCancelled(true);
	}
	@EventHandler
	public void onFall(PlayerMoveEvent e) {
		if(e.getPlayer().getLastDamage() >= 1) {
			e.getPlayer().setHealth(20.0);
		}
	}
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = (Player)e.getPlayer();
		if(!p.hasPermission("animals.build")) {
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		Player p = (Player)e.getPlayer();
		if(!p.hasPermission("animals.build")) {
			e.setCancelled(true);
		}
	}
	
}
