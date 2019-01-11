package ru.ibusewinner.animals;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdInfoAnimals implements CommandExecutor{

	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		if(!(s instanceof Player)) {
			s.sendMessage(MainAnimals.prefix+"§cКоманда только для игроков!");
		}else {
			if(c.getName().equalsIgnoreCase("info")) {
				Player send = (Player)s;
				if(APIAnimals.getAnimal(send) >= 1) {
					if(a.length == 0) {
						s.sendMessage(MainAnimals.prefix+"§aВаша информация:");
						s.sendMessage(MainAnimals.prefix+"§aБаланс: §c"+APIAnimals.getBal(send)+"рублей");
						s.sendMessage(MainAnimals.prefix+"§aДоход: §c"+APIAnimals.getIncome(send)+"р/сек §bx"+APIAnimals.getLocalBoost(send) * OoOoOOo_Booostoor_oOOoOooOO.agboostm * OoOoOOo_Booostoor_oOOoOooOO.gboostm);
						s.sendMessage(MainAnimals.prefix+"§aБустер: §cx"+APIAnimals.getLocalBoost(send));
						s.sendMessage(MainAnimals.prefix+"§aУровень: §c"+APIAnimals.getLevel(send));
						s.sendMessage(MainAnimals.prefix+"§aПерерождений: §c"+APIAnimals.getRespawns(send));
						s.sendMessage(MainAnimals.prefix+"§aСердец: §c"+APIAnimals.getHearts(send)+"❤");
						s.sendMessage(MainAnimals.prefix+"§aХозяев: §c"+APIAnimals.getHumans(send));
						s.sendMessage(MainAnimals.prefix+"§aБизнесов: §c"+APIAnimals.getBizs(send));
						if(APIAnimals.getAnimal(send) == 1) {
							s.sendMessage(MainAnimals.prefix+"§aЖивотное: §eкот");
						}else if(APIAnimals.getAnimal(send) == 2) {
							s.sendMessage(MainAnimals.prefix+"§aЖивотное: §fсобака");
						}else if(APIAnimals.getAnimal(send) == 3) {
							s.sendMessage(MainAnimals.prefix+"§aЖивотное: §6корова");
						}else if(APIAnimals.getAnimal(send) == 4) {
							s.sendMessage(MainAnimals.prefix+"§aЖивотное: §dсвинья");
						}else if(APIAnimals.getAnimal(send) == 5) {
							s.sendMessage(MainAnimals.prefix+"§aЖивотное: §fкурица");
						}else if(APIAnimals.getAnimal(send) == 7) {
							s.sendMessage(MainAnimals.prefix+"§aЖивотное: §fмедведь");
						}else if(APIAnimals.getAnimal(send) == 8) {
							s.sendMessage(MainAnimals.prefix+"§aЖивотное: §6кролик");
						}else if(APIAnimals.getAnimal(send) == 9) {
							s.sendMessage(MainAnimals.prefix+"§aЖивотное: §9попугай");
						}
					}else {
						String target = a[0];
						
						if(!APIAnimals.isRegistered(target)) {
							s.sendMessage(MainAnimals.prefix+"§cИгрок не найден!");
						}else {
							s.sendMessage(MainAnimals.prefix+"§aИнформация "+target+":");
							s.sendMessage(MainAnimals.prefix+"§aБаланс: §c"+APIAnimals.getBal(target)+"рублей");
							s.sendMessage(MainAnimals.prefix+"§aДоход: §c"+APIAnimals.getIncome(target)+"р/сек §bx"+APIAnimals.getLocalBoost(target) * OoOoOOo_Booostoor_oOOoOooOO.agboostm * OoOoOOo_Booostoor_oOOoOooOO.gboostm);
							s.sendMessage(MainAnimals.prefix+"§aБустер: §cx"+APIAnimals.getLocalBoost(target));
							s.sendMessage(MainAnimals.prefix+"§aУровень: §c"+APIAnimals.getLevel(target));
							s.sendMessage(MainAnimals.prefix+"§aПерерождений: §c"+APIAnimals.getRespawns(target));
							s.sendMessage(MainAnimals.prefix+"§aСердец: §c"+APIAnimals.getHearts(target));
							s.sendMessage(MainAnimals.prefix+"§aХозяев: §c"+APIAnimals.getHumans(target));
							s.sendMessage(MainAnimals.prefix+"§aБизнесов: §c"+APIAnimals.getBizs(target));
							if(APIAnimals.getAnimal(target) == 1) {
								s.sendMessage(MainAnimals.prefix+"§aЖивотное: §eкот");
							}else if(APIAnimals.getAnimal(target) == 2) {
								s.sendMessage(MainAnimals.prefix+"§aЖивотное: §fсобака");
							}else if(APIAnimals.getAnimal(target) == 3) {
								s.sendMessage(MainAnimals.prefix+"§aЖивотное: §6корова");
							}else if(APIAnimals.getAnimal(target) == 4) {
								s.sendMessage(MainAnimals.prefix+"§aЖивотное: §dсвинья");
							}else if(APIAnimals.getAnimal(target) == 5) {
								s.sendMessage(MainAnimals.prefix+"§aЖивотное: §fкурица");
							}else if(APIAnimals.getAnimal(target) == 7) {
								s.sendMessage(MainAnimals.prefix+"§aЖивотное: §fмедведь");
							}else if(APIAnimals.getAnimal(target) == 8) {
								s.sendMessage(MainAnimals.prefix+"§aЖивотное: §6кролик");
							}else if(APIAnimals.getAnimal(target) == 9) {
								s.sendMessage(MainAnimals.prefix+"§aЖивотное: §9попугай");
							}
						}
					}
				}else {
					s.sendMessage(MainAnimals.prefix+"§cВы должны быть каким-то животным, чтобы Вы могли использовать данную команду!");
				}
			}
		}
		return false;
	}

}
