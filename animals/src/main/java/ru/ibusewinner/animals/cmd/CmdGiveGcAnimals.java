package ru.ibusewinner.animals.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ru.ibusewinner.animals.APIAnimals;
import ru.ibusewinner.animals.MainAnimals;

public class CmdGiveGcAnimals implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		
		if(c.getName().equalsIgnoreCase("algc")) {
			if(s.hasPermission("animalslive.gc")) {
				if(a.length <= 2) {
					s.sendMessage(MainAnimals.prefix+"§cИспользование: /algc add|remove|get <ник> <сумма>");
				}else {
					if(a[0].equalsIgnoreCase("add")) {
						try {
							String name = a[1];
							int sum = Integer.parseInt(a[2]);
							APIAnimals.addGc(name, sum);
							Player t = Bukkit.getPlayer(name);
							t.sendMessage(MainAnimals.prefix+"§aАдминистратор §c"+s.getName()+"§a подарил Вам §9"+sum+"гк§a!");
							s.sendMessage(MainAnimals.prefix+"§9"+sum+"гк §aбыло отправлено на счёт игроку §1"+name);
						}catch(Exception ex) {
							s.sendMessage(MainAnimals.prefix+"§cИгрок не найден!");
						}
					}else if(a[0].equalsIgnoreCase("get")) {
						try {
							String name = a[1];
							int count = APIAnimals.getGc(name);
							s.sendMessage(MainAnimals.prefix+"§aИгрок §1"+name+"§a имеет §9"+count+"гк§a!");
							s.sendMessage(name);
						}catch(Exception ex) {
							s.sendMessage(MainAnimals.prefix+"§cИгрок не найден!");
						}
					}else if(a[0].equalsIgnoreCase("remove")) {
						try {
							String name = a[1];
							int sum = Integer.parseInt(a[2]);
							APIAnimals.removeGc(name, sum);
							Player t = Bukkit.getPlayer(name);
							t.sendMessage(MainAnimals.prefix+"§aАдминистратор §c"+s.getName()+"§a забрал у Вас §9"+sum+"гк§a!");
							s.sendMessage(MainAnimals.prefix+"§9"+sum+"гк §aбыло забрано со счёта игрока §1"+name);
						}catch(Exception ex) {
							s.sendMessage(MainAnimals.prefix+"§cИгрок не найден!");
						}
					}else if(a[0].equalsIgnoreCase("mygc")) {
						try {
							Player send = (Player)s;
							String name = s.getName();
							int count = APIAnimals.getGc(send);
							s.sendMessage(MainAnimals.prefix+"§aИгрок §1"+name+"§a имеет §9"+count+"гк§a!");
						}catch(Exception ex) {
							s.sendMessage(MainAnimals.prefix+"§cИгрок не найден!");
						}
					}
				}
			}else {
				s.sendMessage(MainAnimals.prefix+"§cВам недоступна данная команда!");
			}
		
		}
		return true;
	}

}
