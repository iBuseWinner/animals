package ru.ibusewinner.animals.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import ru.ibusewinner.animals.MainAnimals;

public class CmdCfgRelAnimals implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		if(c.getName().equalsIgnoreCase("alcfg")) {
			if(a.length == 0) {
				MainAnimals.plugin.saveConfig();
				s.sendMessage(MainAnimals.prefix+"§aКонфиг перезагружен!");
			}else {
				s.sendMessage(MainAnimals.prefix+"§4Использование: /alcfg");
			}
		}
		return true;
	}

}
