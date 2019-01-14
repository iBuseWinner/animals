package ru.ibusewinner.animals.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ru.ibusewinner.animals.APIAnimals;
import ru.ibusewinner.animals.MainAnimals;
import ru.ibusewinner.animals.Сost;

public class CmdLevelUp implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		if(!(s instanceof Player)) {
			Bukkit.getConsoleSender().sendMessage(MainAnimals.prefix+"§cКоманду могут использовать только игроки!");
		}else {
			if(c.getName().equalsIgnoreCase("levelup")) {
				if(a.length == 0) {
					Player p = (Player)s;
					if(APIAnimals.getLevel(p) == 0) {
						if(APIAnimals.getBal(p) >= Сost.levelup1r) {
							if(APIAnimals.getHearts(p) >= Сost.levelup1h) {
								APIAnimals.levelUp(p);
								APIAnimals.removeBal(p,Сost.levelup1r);
								APIAnimals.removeHearts(p,Сost.levelup1h);
							}else {
								s.sendMessage(MainAnimals.prefix+"§4Недостаточно §cсердец §4для повышения уровня! Требуется: "+Сost.levelup1h);
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для повышения уровня! Требуется: "+Сost.levelup1r);
						}
					}else if(APIAnimals.getLevel(p) == 1) {
						if(APIAnimals.getBal(p) >= Сost.levelup2r) {
							if(APIAnimals.getHearts(p) >= Сost.levelup2h) {
								APIAnimals.levelUp(p);
								APIAnimals.removeBal(p,Сost.levelup2r);
								APIAnimals.removeHearts(p,Сost.levelup2h);
							}else {
								s.sendMessage(MainAnimals.prefix+"§4Недостаточно §cсердец §4для повышения уровня! Требуется: "+Сost.levelup2h);
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для повышения уровня! Требуется: "+Сost.levelup2r);
						}
					}else if(APIAnimals.getLevel(p) == 2) {
						if(APIAnimals.getBal(p) >= Сost.levelup3r) {
							if(APIAnimals.getHearts(p) >= Сost.levelup3h) {
								APIAnimals.levelUp(p);
								APIAnimals.removeBal(p,Сost.levelup3r);
								APIAnimals.removeHearts(p,Сost.levelup3h);
							}else {
								s.sendMessage(MainAnimals.prefix+"§4Недостаточно §cсердец §4для повышения уровня! Требуется: "+Сost.levelup3h);
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для повышения уровня! Требуется: "+Сost.levelup3r);
						}
					}else if(APIAnimals.getLevel(p) == 3) {
						if(APIAnimals.getBal(p) >= Сost.levelup4r) {
							if(APIAnimals.getHearts(p) >= Сost.levelup4h) {
								APIAnimals.levelUp(p);
								APIAnimals.removeBal(p,Сost.levelup4r);
								APIAnimals.removeHearts(p,Сost.levelup4h);
							}else {
								s.sendMessage(MainAnimals.prefix+"§4Недостаточно §cсердец §4для повышения уровня! Требуется: "+Сost.levelup4h);
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для повышения уровня! Требуется: "+Сost.levelup4r);
						}
					}else if(APIAnimals.getLevel(p) == 4) {
						if(APIAnimals.getBal(p) >= Сost.levelup5r) {
							if(APIAnimals.getHearts(p) >= Сost.levelup5h) {
								APIAnimals.levelUp(p);
								APIAnimals.removeBal(p,Сost.levelup5r);
								APIAnimals.removeHearts(p,Сost.levelup5h);
							}else {
								s.sendMessage(MainAnimals.prefix+"§4Недостаточно §cсердец §4для повышения уровня! Требуется: "+Сost.levelup5h);
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для повышения уровня! Требуется: "+Сost.levelup5r);
						}
					}else if(APIAnimals.getLevel(p) == 5) {
						if(APIAnimals.getBal(p) >= Сost.levelup6r) {
							if(APIAnimals.getHearts(p) >= Сost.levelup6h) {
								APIAnimals.levelUp(p);
								APIAnimals.removeBal(p,Сost.levelup6r);
								APIAnimals.removeHearts(p,Сost.levelup6h);
							}else {
								s.sendMessage(MainAnimals.prefix+"§4Недостаточно §cсердец §4для повышения уровня! Требуется: "+Сost.levelup6h);
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для повышения уровня! Требуется: "+Сost.levelup6r);
						}
					}else if(APIAnimals.getLevel(p) == 6) {
						if(APIAnimals.getBal(p) >= Сost.levelup7r) {
							if(APIAnimals.getHearts(p) >= Сost.levelup7h) {
								APIAnimals.levelUp(p);
								APIAnimals.removeBal(p,Сost.levelup7r);
								APIAnimals.removeHearts(p,Сost.levelup7h);
							}else {
								s.sendMessage(MainAnimals.prefix+"§4Недостаточно §cсердец §4для повышения уровня! Требуется: "+Сost.levelup7h);
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для повышения уровня! Требуется: "+Сost.levelup7r);
						}
					}else if(APIAnimals.getLevel(p) == 7) {
						if(APIAnimals.getBal(p) >= Сost.levelup8r) {
							if(APIAnimals.getHearts(p) >= Сost.levelup8h) {
								APIAnimals.levelUp(p);
								APIAnimals.removeBal(p,Сost.levelup8r);
								APIAnimals.removeHearts(p,Сost.levelup8h);
							}else {
								s.sendMessage(MainAnimals.prefix+"§4Недостаточно §cсердец §4для повышения уровня! Требуется: "+Сost.levelup8h);
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для повышения уровня! Требуется: "+Сost.levelup8r);
						}
					}else if(APIAnimals.getLevel(p) == 8) {
						if(APIAnimals.getBal(p) >= Сost.levelup9r) {
							if(APIAnimals.getHearts(p) >= Сost.levelup9h) {
								APIAnimals.levelUp(p);
								APIAnimals.removeBal(p,Сost.levelup9r);
								APIAnimals.removeHearts(p,Сost.levelup9h);
							}else {
								s.sendMessage(MainAnimals.prefix+"§4Недостаточно §cсердец §4для повышения уровня! Требуется: "+Сost.levelup9h);
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для повышения уровня! Требуется: "+Сost.levelup9r);
						}
					}else if(APIAnimals.getLevel(p) == 9) {
						if(APIAnimals.getBal(p) >= Сost.levelup10r) {
							if(APIAnimals.getHearts(p) >= Сost.levelup10h) {
								APIAnimals.levelUp(p);
								APIAnimals.removeBal(p,Сost.levelup10r);
								APIAnimals.removeHearts(p,Сost.levelup10h);
							}else {
								s.sendMessage(MainAnimals.prefix+"§4Недостаточно §cсердец §4для повышения уровня! Требуется: "+Сost.levelup10h);
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для повышения уровня! Требуется: "+Сost.levelup10r);
						}
					}else if(APIAnimals.getLevel(p) == 10) {
						if(APIAnimals.getBal(p) >= Сost.levelup11r) {
							if(APIAnimals.getHearts(p) >= Сost.levelup11h) {
								APIAnimals.levelUp(p);
								APIAnimals.removeBal(p,Сost.levelup11r);
								APIAnimals.removeHearts(p,Сost.levelup11h);
							}else {
								s.sendMessage(MainAnimals.prefix+"§4Недостаточно §cсердец §4для повышения уровня! Требуется: "+Сost.levelup11h);
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для повышения уровня! Требуется: "+Сost.levelup11r);
						}
					}else if(APIAnimals.getLevel(p) == 11) {
						if(APIAnimals.getBal(p) >= Сost.levelup12r) {
							if(APIAnimals.getHearts(p) >= Сost.levelup12h) {
								APIAnimals.levelUp(p);
								APIAnimals.removeBal(p,Сost.levelup12r);
								APIAnimals.removeHearts(p,Сost.levelup12h);
							}else {
								s.sendMessage(MainAnimals.prefix+"§4Недостаточно §cсердец §4для повышения уровня! Требуется: "+Сost.levelup12h);
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для повышения уровня! Требуется: "+Сost.levelup12r);
						}
					}else if(APIAnimals.getLevel(p) == 12) {
						if(APIAnimals.getBal(p) >= Сost.levelup13r) {
							if(APIAnimals.getHearts(p) >= Сost.levelup13h) {
								APIAnimals.levelUp(p);
								APIAnimals.removeBal(p,Сost.levelup13r);
								APIAnimals.removeHearts(p,Сost.levelup13h);
							}else {
								s.sendMessage(MainAnimals.prefix+"§4Недостаточно §cсердец §4для повышения уровня! Требуется: "+Сost.levelup13h);
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для повышения уровня! Требуется: "+Сost.levelup13r);
						}
					}else if(APIAnimals.getLevel(p) == 13) {
						if(APIAnimals.getBal(p) >= Сost.levelup14r) {
							if(APIAnimals.getHearts(p) >= Сost.levelup14h) {
								APIAnimals.levelUp(p);
								APIAnimals.removeBal(p,Сost.levelup14r);
								APIAnimals.removeHearts(p,Сost.levelup14h);
							}else {
								s.sendMessage(MainAnimals.prefix+"§4Недостаточно §cсердец §4для повышения уровня! Требуется: "+Сost.levelup14h);
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для повышения уровня! Требуется: "+Сost.levelup14r);
						}
					}else if(APIAnimals.getLevel(p) == 14) {
						if(APIAnimals.getBal(p) >= Сost.levelup15r) {
							if(APIAnimals.getHearts(p) >= Сost.levelup15h) {
								APIAnimals.levelUp(p);
								APIAnimals.removeBal(p,Сost.levelup15r);
								APIAnimals.removeHearts(p,Сost.levelup15h);
							}else {
								s.sendMessage(MainAnimals.prefix+"§4Недостаточно §cсердец §4для повышения уровня! Требуется: "+Сost.levelup15h);
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для повышения уровня! Требуется: "+Сost.levelup15r);
						}
					}else if(APIAnimals.getLevel(p) == 15) {
						s.sendMessage(MainAnimals.prefix+"§bВы достигли максимального уровня! УРАА~АА~А!");
						s.sendMessage(MainAnimals.prefix+"§eВозможно, скоро добавят новые уровни!");
					}
				}else {
					s.sendMessage(MainAnimals.prefix+"§cИспользование: /levelup");
				}
			}
		}
		return false;
	}

}
