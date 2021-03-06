package ru.ibusewinner.animals.cmd;

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
import ru.ibusewinner.animals.APIAnimals;
import ru.ibusewinner.animals.MainAnimals;
import ru.ibusewinner.animals.boosters.GlobalBoost;
import ru.ibusewinner.animals.boosters.LocalBoost;

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
//					ItemMeta boost_30m_global_m = boost_30m_global.getItemMeta();
//					boost_30m_global_m.setDisplayName("§5Глобальный §fбустер §6х2 §fна §930 минут");
//					boost_30m_global.setItemMeta(boost_30m_global_m);
					ItemMeta boost_30m_local_m = boost_30m_local.getItemMeta();
					boost_30m_local_m.setDisplayName("§5Локальный §fбустер §6х2 §fна §930 минут - 150 грендкоинов");
					boost_30m_local.setItemMeta(boost_30m_local_m);
					
//					donate.setItem(3,boost_30m_global);
					donate.setItem(4,boost_30m_local);
					
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
				if (GlobalBoost.isSet())
				{
					p.sendMessage("§cДождитесь окончания предыдущего глобального бустера, что бы купить новый!");
				}
				else
				{
					int rgc = APIAnimals.removeGc(p.getName(), 200);
					if (rgc == 1)
					{
//						for(Player pl : Bukkit.getOnlinePlayers())	
//							TTA_Methods.createBossBar(pl,"§aГлобальный бустер §9x"+2+" §aот админа §5"+p.getName()+" §6("+30+"минут)",1.0,BarStyle.SOLID,BarColor.YELLOW,BarFlag.CREATE_FOG,true);
						GlobalBoost.set(2, 30);
						p.sendMessage(MainAnimals.prefix + "§aГлобальный буст x2 на 30 минут успешно куплен!");
						Bukkit.broadcastMessage("§aИгрок §c" + p.getName() + "§a купил глобальный буст §cx2 §aна §c30 §aминут");
					}
					else if (rgc == 2) 
						p.sendMessage(MainAnimals.prefix + "§cУ вас недостаточно грендкоинов! Задонатьте ещё.");
					else p.sendMessage(MainAnimals.prefix + "§cНеизвестная ошибка! Обратитесь к администратору.");
				}
				/*
				int rgc = APIAnimals.removeGc(p.getName(), 200);				
				if (rgc == 1)
				{
					for(Player pl : Bukkit.getOnlinePlayers()) {
					//TTA_Methods.createBossBar(pl,"§aГлобальный бустер §9x"+2+" §aот админа §5"+p.getName()+" §6("+30+"минут)",1.0,BarStyle.SOLID,BarColor.YELLOW,BarFlag.CREATE_FOG,true);
					p.sendMessage(MainAnimals.prefix + "§aГлобальный буст x2 на 30 минут успешно куплен!");
				}
				else if (rgc == 2) 
					p.sendMessage(MainAnimals.prefix + "§cУ вас недостаточно грендкоинов! Задонатьте ещё.");
				else p.sendMessage(MainAnimals.prefix + "§cНеизвестная ошибка! Обратитесь к администратору.");
				*/
			}
		}
		if(e.getSlot() == 4) 
		{
			int rgc = APIAnimals.removeGc(p.getName(), 150);
			
			if (rgc == 1)
			{
				MainAnimals.boosters.remove(p);
				LocalBoost boost = new LocalBoost(p, 2, 30);
				p.sendMessage(MainAnimals.prefix + "§aБуст §cx2 §aуспешно куплен/продлён на §c30 минут §aза §c150 грендкоинов!");
			}
			else if (rgc == 2) 
				p.sendMessage(MainAnimals.prefix + "§cУ вас недостаточно грендкоинов! грендкоины вы можете купить на сайте §awww.скоро.ru/");
			else p.sendMessage(MainAnimals.prefix + "§cНеизвестная ошибка! Обратитесь к администратору.");
		}
		else
		{ 
			e.setCancelled(true);
		}
		e.setCancelled(true);
	}
}
