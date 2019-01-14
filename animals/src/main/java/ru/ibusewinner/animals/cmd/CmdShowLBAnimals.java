package ru.ibusewinner.animals.cmd;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ru.ibusewinner.animals.MainAnimals;
import ü.TTA_HoloAPI;

public class CmdShowLBAnimals implements CommandExecutor{
	
	public static TTA_HoloAPI holo = new TTA_HoloAPI();
	public static TTA_HoloAPI lb = new TTA_HoloAPI();
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		if(!(s instanceof Player)) {
			s.sendMessage(MainAnimals.prefix+"§cКоманда только для игроков!");
		}else {
			if(c.getName().equalsIgnoreCase("alholo")) {
				if(s.getName().equalsIgnoreCase("ibusewinner")) {
					try {
						Player send = (Player)s;
						Location loc = new Location(send.getWorld(),send.getLocation().getX(),send.getLocation().getY(),send.getLocation().getZ());
						ArrayList<String> lines = new ArrayList<String>();
						lines.add("§7Привет!");
						lines.add("§7Ты попал на сервер §bGrendCity§7, на режим §eЖизнь Животных§7!");
						lines.add("§0");
						lines.add("§7Для начала тебе нужно найти потерянных овечек");
						lines.add("§7и сдать их в ближайший к тебе приют.");
						lines.add("§7Накопи на бизнес §bКолодец §a300р §7и купи его!");
						lines.add("§7Покупай бизнесы и хозяев, перерождайся через §8/respawn§7");
						lines.add("§7и выходи в топ по количеству хозяев!");
						lines.add("§1");
						lines.add("§dУдачи!");
						if(a[0].equalsIgnoreCase("create")) {
							holo.createHolo(loc, lines);
							for(Player p : Bukkit.getOnlinePlayers()) {
								holo.displayHolo(p);	
							}
						}else if(a[0].equalsIgnoreCase("delete")) {
							for(Player p : Bukkit.getOnlinePlayers()) {
								holo.destroyHolo(p);
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§4/alholo create|delete - создать/удалить голограмму§l§n§o!!!!!!!!!!!");
						}
					}catch(Exception ex) {
						Bukkit.getConsoleSender().sendMessage(MainAnimals.prefix+"§4Блин, админ рукожоп ,_,");
					}
				}else {
					s.sendMessage(MainAnimals.prefix+"§cВам недоступна данная команда!");
				}
			}
		}
		return false;
	}

}
