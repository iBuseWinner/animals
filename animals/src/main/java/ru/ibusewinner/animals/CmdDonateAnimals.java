package ru.ibusewinner.animals;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
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

import de.Herbystar.TTA.TTA_Methods;


public class CmdDonateAnimals implements CommandExecutor, Listener{
	
	public static String donator = "§b§lДонат-меню §8|| Plugin made by iBuseWinner";
	
	public static Inventory donate = Bukkit.createInventory(null,9,donator);
	
	ItemStack boost_30m_global = new ItemStack(Material.GOLD_INGOT,1);
	ItemStack boost_30m_local = new ItemStack(Material.DIAMOND,1);
	
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		if(!(s instanceof Player)) {
			Bukkit.getConsoleSender().sendMessage(MainAnimals.prefix+"§cКоманда доступна только игрокам!");
		}else {
			if(c.getName().equalsIgnoreCase("donate")) {
				if(a.length == 0) {
					Player send = (Player)s;
					ItemMeta boost_30m_global_m = boost_30m_global.getItemMeta();
					boost_30m_global_m.setDisplayName("§5Глобальный §fбустер §6х2 §fна §930 минут");
					boost_30m_global.setItemMeta(boost_30m_global_m);
					ItemMeta boost_30m_local_m = boost_30m_local.getItemMeta();
					boost_30m_local_m.setDisplayName("§5Локальный §fбустер §6х2 §fна §930 минут");
					boost_30m_local.setItemMeta(boost_30m_local_m);
					
					donate.setItem(3,boost_30m_global);
					donate.setItem(5,boost_30m_local);
					
					send.openInventory(donate);
					send.playSound(send.getLocation(),Sound.BLOCK_CHEST_OPEN,1.0f,1.0f);
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
			if(e.getSlot() == 3) 	
			{
				int rgc = APIAnimals.removeGc(p.getName(), 200);				
				if (rgc == 1)
				{
					for(Player pl : Bukkit.getOnlinePlayers()) {
					TTA_Methods.createBossBar(pl,"§aГлобальный бустер §9x"+2+" §aот админа §5"+p.getName()+" §6("+30+"минут)",1.0,BarStyle.SOLID,BarColor.YELLOW,BarFlag.CREATE_FOG,true);
				}
					Booostoor b = new Booostoor();
					Booostoor.gboost = 30;
					Booostoor.gboostm = 2;					
					Booostoor.agboost = 30;
					Booostoor.agboostm = 2;
					Booostoor.booster = p.getName();
					b.timer();
					p.sendMessage(MainAnimals.prefix + "§aГлобальный буст x2 на 30 минут успешно куплен!");
				}
				else if (rgc == 2) 
					p.sendMessage(MainAnimals.prefix + "§cУ вас недостаточно грендкоинов! Задонатьте ещё.");
				else p.sendMessage(MainAnimals.prefix + "§cНеизвестная ошибка! Обратитесь к администратору.");
			}
			else if(e.getSlot() == 5) 
			{
				int rgc = APIAnimals.removeGc(p.getName(), 150);
				
				if (rgc == 1)
				{
					APIAnimals.setLocalBoost(p, 2);
					p.sendMessage(MainAnimals.prefix + "§aБуст x2 на 30 минут успешно куплен!");
				}
				else if (rgc == 2) 
					p.sendMessage(MainAnimals.prefix + "§cУ вас недостаточно грендкоинов! Задонатьте ещё.");
				else p.sendMessage(MainAnimals.prefix + "§cНеизвестная ошибка! Обратитесь к администратору.");
			}
			else
			{ 
				e.setCancelled(true);
				return;
			}
			e.setCancelled(true);
		}
	}

}
