package ru.ibusewinner.animals;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Player;

import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.DisguiseType;
import me.libraryaddict.disguise.disguisetypes.FlagWatcher;
import me.libraryaddict.disguise.disguisetypes.MobDisguise;
import me.libraryaddict.disguise.disguisetypes.watchers.OcelotWatcher;

public class CmdChooseAnimals implements CommandExecutor{

	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		if(!(s instanceof Player)) {
			s.sendMessage(MainAnimals.prefix+"§cКоманда только для игроков!");
		}else {
			if(c.getName().equalsIgnoreCase("choose")) {
				Player send = (Player)s;
				if(APIAnimals.getAnimal(send) == 0) {
					if(a.length == 0 || a.length > 1) {
						s.sendMessage(MainAnimals.prefix+"§cВы не написали тип животного! Доступные типы:");
						s.sendMessage(MainAnimals.prefix+"§eкот§7, §fсобака§7, §6корова§7, §dсвинья§7, §fкурица§7, §fмедведь§7, §6кролик§7, §9попугай§7");
					}else {
						String type = a[0];
						
						MobDisguise cat = new MobDisguise(DisguiseType.OCELOT, false);
						OcelotWatcher catw = (OcelotWatcher) cat.getWatcher();
						catw.setType(Ocelot.Type.BLACK_CAT);
						catw.setCustomName(send.getName());
						catw.setCustomNameVisible(true);
						
						MobDisguise dog = new MobDisguise(DisguiseType.WOLF, false);
						FlagWatcher dogw = dog.getWatcher();
						dogw.setCustomName(send.getName());
						dogw.setCustomNameVisible(true);
						
						MobDisguise cow = new MobDisguise(DisguiseType.COW, false);
						FlagWatcher coww = cow.getWatcher();
						coww.setCustomName(send.getName());
						coww.setCustomNameVisible(true);
						
						MobDisguise pig = new MobDisguise(DisguiseType.PIG, false);
						FlagWatcher pigw = pig.getWatcher();
						pigw.setCustomName(send.getName());
						pigw.setCustomNameVisible(true);
						
						MobDisguise chicken = new MobDisguise(DisguiseType.CHICKEN, false);
						FlagWatcher chickenw = chicken.getWatcher();
						chickenw.setCustomName(send.getName());
						chickenw.setCustomNameVisible(true);
						
						MobDisguise bear = new MobDisguise(DisguiseType.POLAR_BEAR, false);
						FlagWatcher bearw = bear.getWatcher();
						bearw.setCustomName(send.getName());
						bearw.setCustomNameVisible(true);
						
						MobDisguise rabbid = new MobDisguise(DisguiseType.RABBIT, false);
						FlagWatcher rabbidw = rabbid.getWatcher();
						rabbidw.setCustomName(send.getName());
						rabbidw.setCustomNameVisible(true);
						
						MobDisguise parrot = new MobDisguise(DisguiseType.PARROT, false);
						FlagWatcher parrotw = parrot.getWatcher();
						parrotw.setCustomName(send.getName());
						parrotw.setCustomNameVisible(true);
						
						
						if(type.equalsIgnoreCase("кот")) {
							APIAnimals.setAnimal(send,1);
							s.sendMessage(MainAnimals.prefix+"§aВы успешно выбрали животное: §eкот");
							DisguiseAPI.disguiseToAll(send,cat);
						}else if(type.equalsIgnoreCase("собака")) {
							APIAnimals.setAnimal(send,2);
							s.sendMessage(MainAnimals.prefix+"§aВы успешно выбрали животное: §fсобака");
							DisguiseAPI.disguiseToAll(send,dog);
						}else if(type.equalsIgnoreCase("корова")) {
							APIAnimals.setAnimal(send,3);
							s.sendMessage(MainAnimals.prefix+"§aВы успешно выбрали животное: §6корова");
							DisguiseAPI.disguiseToAll(send,cow);
						}else if(type.equalsIgnoreCase("свинья")) {
							APIAnimals.setAnimal(send,4);
							s.sendMessage(MainAnimals.prefix+"§aВы успешно выбрали животное: §dсвинья");
							DisguiseAPI.disguiseToAll(send,pig);
						}else if(type.equalsIgnoreCase("курица")) {
							APIAnimals.setAnimal(send,5);
							s.sendMessage(MainAnimals.prefix+"§aВы успешно выбрали животное: §fкурица");
							DisguiseAPI.disguiseToAll(send,chicken);
						}else if(type.equalsIgnoreCase("медведь")) {
							APIAnimals.setAnimal(send,7);
							s.sendMessage(MainAnimals.prefix+"§aВы успешно выбрали животное: §fмедведь");
							DisguiseAPI.disguiseToAll(send,bear);
						}else if(type.equalsIgnoreCase("кролик")) {
							APIAnimals.setAnimal(send,8);
							s.sendMessage(MainAnimals.prefix+"§aВы успешно выбрали животное: §6кролик");
							DisguiseAPI.disguiseToAll(send,rabbid);
						}else if(type.equalsIgnoreCase("попугай")) {
							APIAnimals.setAnimal(send,9);
							s.sendMessage(MainAnimals.prefix+"§aВы успешно выбрали животное: §9попугай");
							DisguiseAPI.disguiseToAll(send,parrot);
						}else {
							s.sendMessage(MainAnimals.prefix+"§cВы не написали тип животного! Доступные типы:");
							s.sendMessage(MainAnimals.prefix+"§eкот§7, §fсобака§7, §6корова§7, §dсвинья§7, §fкурица§7, §fмедведь§7, §6кролик§7, §9попугай§7");
						}
					}
				}else {
					s.sendMessage(MainAnimals.prefix+"§cВы уже выбрали своё животное!");
				}
			}
		}
		return false;
	}

}
