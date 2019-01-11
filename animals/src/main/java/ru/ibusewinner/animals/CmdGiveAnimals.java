package ru.ibusewinner.animals;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdGiveAnimals implements CommandExecutor{

	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		if(!(s instanceof Player)) {
			s.sendMessage(MainAnimals.prefix+"§cКоманда только для игроков!");
		}else {
			if(c.getName().equalsIgnoreCase("algive")) {
				if(s.getName().equalsIgnoreCase("ibusewinner")) {
					if(a.length <= 2) {
						s.sendMessage(MainAnimals.prefix+"§cТы не указал, что именно ты хочешь сделать и с кем!");
					}else {
						Player t = Bukkit.getPlayer(a[2]);
						int count = Integer.parseInt(a[3]);
						
						if(a[0].equalsIgnoreCase("add")) {
							if(a[1].equalsIgnoreCase("bal")) {
								APIAnimals.addBal(t,count);
								
								s.sendMessage(MainAnimals.prefix+"§aУспешно добавлено "+count+"р игроку "+t);
							}else {
								s.sendMessage(MainAnimals.prefix+"§cНу ващет тут надо указать bal");
							}
						}else if(a[0].equalsIgnoreCase("remove")) {
							if(a[1].equalsIgnoreCase("bal")) {
								APIAnimals.removeBal(t,count);
								
								s.sendMessage(MainAnimals.prefix+"§aУспешно убрано "+count+"р игроку "+t);
							}else {
								s.sendMessage(MainAnimals.prefix+"§cНу ващет тут надо указать bal");
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cНу ващет тут надо указать add или remove");
						}
					}
				}else {s.sendMessage(MainAnimals.prefix+"§cА тибе низя использовать эту команду! с:");}
			}
		}
		return false;
	}

}
