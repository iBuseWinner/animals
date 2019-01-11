package ru.ibusewinner.animals;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdBredAnimals implements CommandExecutor{

	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		if(!(s instanceof Player)) {
			s.sendMessage(MainAnimals.prefix+"§cКоманда только для игроков!");
		}else {
			if(c.getName().equalsIgnoreCase("KAd5WlBYtyUhqubXaHIwmcXb")){
				Player send = (Player)s;
				if(a[0].equalsIgnoreCase("fhFUAWyr8hd8hU26Jd")) {
					if(APIAnimals.isShelter(send) == false) {
						s.sendMessage(MainAnimals.prefix+"§cВы не подобрали овечку! Подберите овечку на улице и отнесите её в ближайший приют!");
					}else {
						APIAnimals.setShelter(send,false);
						APIAnimals.addBal(send,35);
						APIAnimals.addHearts(send,1);
						
						s.sendMessage(MainAnimals.prefix+"§aВы успешно сдали овечку в приют и получили за это §c35р§a и §c1 сердечко!");
					}
				}
			}
		}
		return false;
	}

}
