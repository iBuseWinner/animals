package ru.ibusewinner.animals.cmd;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ru.ibusewinner.animals.APIAnimals;
import ru.ibusewinner.animals.MainAnimals;

public class CmdRespawnAnimals implements CommandExecutor{

	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		if(!(s instanceof Player)) {
			s.sendMessage(MainAnimals.prefix+"§cКоманда только для игроков!");
		}else {
			if(c.getName().equalsIgnoreCase("respawn")) {
				Player send = (Player)s;
				if(APIAnimals.getAnimal(send) >= 1) {
					if(APIAnimals.getRespawns(send) == 0) {
						if(APIAnimals.getBal(send) >= 100000000) {
							if(APIAnimals.getHearts(send) >= 50000) {
								APIAnimals.addRespawn(send);
								APIAnimals.resetPlayer(send);
								send.teleport(new Location(Bukkit.getWorld("world"), -24, 102, 473));
							}else {
								s.sendMessage(MainAnimals.prefix+"§4У Вас недостаточно §cсердечек§4 для совершения данного действия! §4(нужно 50.000 сердечек)");
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cУ Вас недостаточно средств! §4(нужно 100.000.000)");
						}
					}else if(APIAnimals.getRespawns(send) == 1) {
						if(APIAnimals.getBal(send) >= 150000000) {
							if(APIAnimals.getHearts(send) >= 100000) {
								APIAnimals.addRespawn(send);
								APIAnimals.resetPlayer(send);
								send.teleport(new Location(Bukkit.getWorld("world"), -24, 102, 473));
							}else {
								s.sendMessage(MainAnimals.prefix+"§4У Вас недостаточно §cсердечек§4 для совершения данного действия! §4(нужно 100.000 сердечек)");
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cУ Вас недостаточно средств! §4(нужно 150.000.000)");
						}
					}else if(APIAnimals.getRespawns(send) == 2) {
						s.sendMessage(MainAnimals.prefix+"§cВы достигли максимального количества перерождений!");
					}
				}else {
					s.sendMessage(MainAnimals.prefix+"§cВы должны быть каким-то животным, чтобы Вы могли использовать данную команду!");
				}
			}
		}
		return false;
	}

}
