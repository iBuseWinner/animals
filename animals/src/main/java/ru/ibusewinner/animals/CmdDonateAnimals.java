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
	
	public static Inventory donate = Bukkit.createInventory(null,9,donator);
	
<<<<<<< HEAD
	ItemStack boost_30m_local = new ItemStack(Material.GOLD_INGOT,1);
	
	ItemStack boost_30m_glob = new ItemStack(Material.DIAMOND,1);
	
=======
	ItemStack boost_30m_global = new ItemStack(Material.GOLD_INGOT,1);
	ItemStack boost_30m_local = new ItemStack(Material.GOLD_INGOT,1);
>>>>>>> 702030ccf77478ea6021b03ffb1af9812b77f9cf
	
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		if(!(s instanceof Player)) {
			Bukkit.getConsoleSender().sendMessage(MainAnimals.prefix+"§cКоманда доступна только игрокам!");
		}else {
			if(c.getName().equalsIgnoreCase("donate")) {
				if(a.length == 0) {
					Player send = (Player)s;
					
<<<<<<< HEAD
					ItemMeta boost_30m_x2_m = boost_30m_local.getItemMeta();
					boost_30m_x2_m.setDisplayName("§5Локальный §fбустер §6х2 §fна §930 минут");
					boost_30m_local.setItemMeta(boost_30m_x2_m);
					
					ItemMeta boost_30m_glob_m = boost_30m_glob.getItemMeta();
					boost_30m_glob_m.setDisplayName("§5Глобальный §fбустер §6х2 §fна §930 минут");
					boost_30m_glob.setItemMeta(boost_30m_glob_m);
					
					
					donate.setItem(3,boost_30m_local);
					donate.setItem(5,boost_30m_glob);
					
=======
					ItemMeta boost_30m_global_m = boost_30m_global.getItemMeta();
					boost_30m_global_m.setDisplayName("§5Глобальный §fбустер §6х2 §fна §930 минут");
					boost_30m_global.setItemMeta(boost_30m_global_m);
					ItemMeta boost_30m_local_m = boost_30m_local.getItemMeta();
					boost_30m_local_m.setDisplayName("§5Локальный §fбустер §6х2 §fна §930 минут");
					boost_30m_local.setItemMeta(boost_30m_local_m);
					
					donate.setItem(3,boost_30m_global);
					donate.setItem(5,boost_30m_local);
>>>>>>> 702030ccf77478ea6021b03ffb1af9812b77f9cf
					
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
			
			if(e.getSlot() == 3) {
				p.sendMessage(MainAnimals.prefix+"§4Скоро...");
			}else if(e.getSlot() == 5) {
				p.sendMessage(MainAnimals.prefix+"§4Скоро...");
			}else {
				return;
			}
		}
	}

}
