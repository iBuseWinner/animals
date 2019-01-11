package ru.ibusewinner.animals;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.libraryaddict.disguise.DisguiseAPI;

public class CmdShowAnimals implements CommandExecutor{

	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		if(!(s instanceof Player)) {
			s.sendMessage(MainAnimals.prefix+"§cКоманда только для игроков!");
		}else {
			if(c.getName().equalsIgnoreCase("show")) {
				Player send = (Player)s;
				if(DisguiseAPI.isViewSelfToggled(send) == true) {
					DisguiseAPI.setViewDisguiseToggled(send, false);
				}else {
					DisguiseAPI.setViewDisguiseToggled(send, true);
				}
			}
		}
		return false;
	}

}
