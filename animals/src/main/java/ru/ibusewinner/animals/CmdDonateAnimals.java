package ru.ibusewinner.animals;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CmdDonateAnimals implements CommandExecutor, Listener{
	
	public static String donator = "§b§lДонат-меню §8|| Plugin made by iBuseWinner";
	
	public static Inventory donate = Bukkit.createInventory(null,27,donator);
	
	ItemStack boost_30m_local = new ItemStack(Material.GOLD_INGOT,1);
	
	ItemStack boost_30m_glob = new ItemStack(Material.DIAMOND,1);
	
	
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		if(!(s instanceof Player)) {
			Bukkit.getConsoleSender().sendMessage(MainAnimals.prefix+"§cКоманда доступна только игрокам!");
		}else {
			if(c.getName().equalsIgnoreCase("donate")) {
				if(a.length == 0) {
					Player send = (Player)s;
					
					ItemMeta boost_30m_x2_m = boost_30m_local.getItemMeta();
					boost_30m_x2_m.setDisplayName("§5Глобальный §fбустер §6х2 §fна §930 минут");
					boost_30m_local.setItemMeta(boost_30m_x2_m);
					
					
					donate.setItem(10,boost_30m_x2);
					donate.setItem(11,boost_1h_x2);
					
					
					send.openInventory(donate);
				}else {
					s.sendMessage(MainAnimals.prefix+"§cИспользование: /donate");
				}
			}
		}
		return false;
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player)e.getWhoClicked();
		
		if(e.getInventory().getName().equalsIgnoreCase(donator)) {
			e.setCancelled(true);
			
			if(e.getSlot() == 10) {
				p.sendMessage(MainAnimals.prefix+"§4Скоро...");
			}else if(e.getSlot() == 11) {
				p.sendMessage(MainAnimals.prefix+"§4Скоро...");
			}else if(e.getSlot() == 12) {
				p.sendMessage(MainAnimals.prefix+"§4Скоро...");
			}else if(e.getSlot() == 16) {
				p.sendMessage(MainAnimals.prefix+"§4Скоро...");
			}else if(e.getSlot() == 17) {
				p.sendMessage(MainAnimals.prefix+"§4Скоро...");
			}else if(e.getSlot() == 18) {
				p.sendMessage(MainAnimals.prefix+"§4Скоро...");
			}else {
				return;
			}
		}
	}

}
