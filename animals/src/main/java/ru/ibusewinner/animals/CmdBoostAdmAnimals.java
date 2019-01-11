package ru.ibusewinner.animals;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Herbystar.TTA.TTA_Methods;

public class CmdBoostAdmAnimals implements CommandExecutor{

	
	
	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		if(!(s instanceof Player)) {
			s.sendMessage(MainAnimals.prefix+"§cКоманда только для игроков!");
		}else {
			if(c.getName().equalsIgnoreCase("alboost")) {
				if(s.hasPermission("animalslive.boosts")) {
					if(a.length <= 1 && !a[0].equalsIgnoreCase("del")) {
						s.sendMessage(MainAnimals.prefix+"§cИспользование: /alboost set|del <множитель> <длительность в минутах> - активировать/деактивировать бустер");
					}else {
						if(a[0].equalsIgnoreCase("set") && a.length == 3) {
							int mnoz = Integer.parseInt(a[1]);
							int dur = Integer.parseInt(a[2]);
							
							for(Player pl : Bukkit.getOnlinePlayers()) {
								TTA_Methods.createBossBar(pl,"§aГлобальный бустер §9x"+mnoz+" §aот админа §5"+s.getName()+" §6("+dur+"минут)",1.0,BarStyle.SOLID,BarColor.YELLOW,BarFlag.CREATE_FOG,true);
							}
							
							OoOoOOo_Booostoor_oOOoOooOO.agboost = dur;
							OoOoOOo_Booostoor_oOOoOooOO.agboostm = mnoz;
							OoOoOOo_Booostoor_oOOoOooOO.booster = s.getName();
							
							Bukkit.broadcastMessage(MainAnimals.prefix+"§aГлобальный бустер §9x"+mnoz+" §aбыл включён администратором §5"+s.getName()+" §aна §9"+dur+" минут§a!");
						}else if(a[0].equalsIgnoreCase("del") && a.length == 1) {
							if(OoOoOOo_Booostoor_oOOoOooOO.agboost >= 1) {
								OoOoOOo_Booostoor_oOOoOooOO.agboost = 0;
								int boost = OoOoOOo_Booostoor_oOOoOooOO.agboostm;
								Bukkit.broadcastMessage(MainAnimals.prefix+"§aБустер §9x"+boost+" §aпринуждённо закончен администратором §5"+s.getName()+"§a!");
								OoOoOOo_Booostoor_oOOoOooOO.agboostm = 1;
							}else {
								s.sendMessage(MainAnimals.prefix+"§cБустер и так уже закончен!");
							}
						}
					}
				}else {
					s.sendMessage(MainAnimals.prefix+"§cУ Вас недостаточно прав!");
				}
			}
		}
		return false;
	}
}