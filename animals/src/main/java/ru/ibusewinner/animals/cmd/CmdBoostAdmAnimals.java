package ru.ibusewinner.animals.cmd;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Herbystar.TTA.TTA_Methods;
import ru.ibusewinner.animals.MainAnimals;
import ru.ibusewinner.animals.boosters.GlobalBoost;

public class CmdBoostAdmAnimals implements CommandExecutor{

	
	
	@SuppressWarnings("unused")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		if (cmd.getName().equalsIgnoreCase("alboost"))
		{
			if (!sender.hasPermission("animalslive.boosts"))
			{
				sender.sendMessage("§cУ вас недостаточно прав!");
				return true;
			}
			if (args.length < 1)
			{
				sender.sendMessage("§cИспользование: /alboost set|del|add");
				return true;
			}
			switch (args[0].toLowerCase()) {
			case "set":

				if (args.length < 3)
				{
					if (args.length > 3)
					{
						sender.sendMessage("§cВы ввели слишком много аргументов!");
						return true;
					}
					sender.sendMessage("§cИспользование: /alboost set <множитель> <длительность бустера в минутах>");
					return true;
				}
				else
				{
					try {
						int mnoz = Integer.parseInt(args[1]);
						int dur = Integer.parseInt(args[2]);
						GlobalBoost.set(mnoz, dur);
						Bukkit.broadcastMessage("§c" + sender.getName() + "§a установил новый бустер §cx" + mnoz+ " §aна §c" + dur + "§a минут");						
					} catch (Exception e) {
						sender.sendMessage("§cИспользование: /alboost set <множитель> <длительность бустера в минутах>");
					}
					
					
				}
				break;
			case "del":
				if (args.length < 2)
				{
					if (args.length > 2)
					{
						sender.sendMessage("§cВы ввели слишком много аргументов!");
						sender.sendMessage("§сИспользование: /alboost del <множитель>");
						return true;
					}
					sender.sendMessage("§сДля подтверждения введите множитель буста: /alboost del <множитель>");
					return true;
				}
				else
				{
					if (GlobalBoost.isSet())
					{
						try
						{
							if (Integer.parseInt(args[1]) == GlobalBoost.boost)
							{
								GlobalBoost.remove();
								Bukkit.broadcastMessage("§aГлобальный бустер был удалён администратором!");
							}
							else
							{
								sender.sendMessage("§cНеверный множитель!");
								sender.sendMessage("§сДля подтверждения введите множитель текущего буста: /alboost del <множитель>");
							}
						}catch (Exception e)
						{
							sender.sendMessage("§cНекорректные аргументы!");
							sender.sendMessage("§сИспользование: /alboost del <множитель>");
							e.printStackTrace();
						}
					}
					else sender.sendMessage("§cГлобальный бустер не установлен!");
				}
				break;
			case "add":
				if (args.length < 2)
				{
					sender.sendMessage("§cИспользование: /alboost add <время в минутах> <множитель>");
					break;
				}
				else if (args.length < 3)
				{
					sender.sendMessage("§cДля подтверждения введите множитель буста:");
					sender.sendMessage("§c/alboost add <время в минутах> <множитель>");
					break;
				} 
				else if (args.length > 3) 
				{
					sender.sendMessage("§cВы ввели слишком много аргументов!");
					sender.sendMessage("§cИспользование: /alboost add <время в минутах> <множитель>");
					break;
				}
				if (GlobalBoost.isSet())
				{
					try
					{
						int dur = Integer.parseInt(args[1]);
						int mnoz = Integer.parseInt(args[2]);
						if (mnoz != GlobalBoost.boost)
						{
							sender.sendMessage("§cНеверный множитель!");
							sender.sendMessage("§сДля подтверждения введите множитель текущего буста: /alboost add <время в минутах> <множитель>");
							return true;
						}
						GlobalBoost.boostTimer += dur;
						Bukkit.broadcastMessage("§c" + sender.getName() + "§a продлил буст на §c" + dur + "§a минут!");
					} catch (Exception e)
					{
						sender.sendMessage("§cНекорректные аргументы!");
						sender.sendMessage("§cИспользование: /alboost add <время в минутах> <множитель>");
					}
				}else sender.sendMessage("§cГлобальный бустер не установлен! Для начала установите глобальный бустер: /alboost set");
				break;
			default:
				sender.sendMessage("§cИспользование: /alboost set|del|add");
				break;
			}
		}

		
		
		return true;
		/*
		if(!(sender instanceof Player)) {
			sender.sendMessage(MainAnimals.prefix+"§cКоманда только для игроков!");
		}else {
			if(cmd.getName().equalsIgnoreCase("alboost")) {
				if(sender.hasPermission("animalslive.boosts")) {
					if(args.length <= 1 && !args[0].equalsIgnoreCase("del")) {
						sender.sendMessage(MainAnimals.prefix+"§cИспользование: /alboost set|del <множитель> <длительность в минутах> - активировать/деактивировать бустер");
					}else {
						if(args[0].equalsIgnoreCase("set") && args.length == 3) {
							int mnoz = Integer.parseInt(args[1]);
							int dur = Integer.parseInt(args[2]);
							
							for(Player pl : Bukkit.getOnlinePlayers()) {
								TTA_Methods.createBossBar(pl,"§aГлобальный бустер §9x"+mnoz+" §aот админа §5"+sender.getName()+" §6("+dur+"минут)",1.0,BarStyle.SOLID,BarColor.YELLOW,BarFlag.CREATE_FOG,true);
							}
							
							GlobalBoost.agboost = dur;
							GlobalBoost.agboostm = mnoz;
							GlobalBoost.booster = sender.getName();
							
							Bukkit.broadcastMessage(MainAnimals.prefix+"§aГлобальный бустер §9x"+mnoz+" §aбыл включён администратором §5"+sender.getName()+" §aна §9"+dur+" минут§a!");
						}else if(args[0].equalsIgnoreCase("del") && args.length == 1) {
							if(GlobalBoost.agboost >= 1) {
								GlobalBoost.agboost = 0;
								int boost = GlobalBoost.agboostm;
								Bukkit.broadcastMessage(MainAnimals.prefix+"§aБустер §9x"+boost+" §aпринуждённо закончен администратором §5"+sender.getName()+"§a!");
								for (Player p : Bukkit.getOnlinePlayers()) {								
									TTA_Methods.removeBossBar(p);
								}
								GlobalBoost.agboostm = 1;
							}else {
								sender.sendMessage(MainAnimals.prefix+"§cБустер и так уже закончен!");
							}
						}
					}
				}else {
					sender.sendMessage(MainAnimals.prefix+"§cУ Вас недостаточно прав!");
				}
			}
		}
		return false;*/
	}
}
