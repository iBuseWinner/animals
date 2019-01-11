package ru.ibusewinner.animals;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OooOOOoo_Cmd_LevelUp_OoOooooO implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		if(!(s instanceof Player)) {
			Bukkit.getConsoleSender().sendMessage(MainAnimals.prefix+"§cКоманду могут использовать только игроки!");
		}else {
			if(c.getName().equalsIgnoreCase("levelup")) {
				if(a.length == 0) {
					Player p = (Player)s;
					if(APIAnimals.getLevel(p) == 0) {
						if(APIAnimals.getBal(p) >= OoOooOOo_cost_OoOOoO.levelup1r) {
							if(APIAnimals.getHearts(p) >= OoOooOOo_cost_OoOOoO.levelup1h) {
								APIAnimals.levelUp(p);
								APIAnimals.removeBal(p,OoOooOOo_cost_OoOOoO.levelup1r);
								APIAnimals.removeHearts(p,OoOooOOo_cost_OoOOoO.levelup1h);
							}else {
								s.sendMessage(MainAnimals.prefix+"§4Недостаточно §cсердец §4для повышения уровня! Требуется: "+OoOooOOo_cost_OoOOoO.levelup1h);
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для повышения уровня! Требуется: "+OoOooOOo_cost_OoOOoO.levelup1r);
						}
					}else if(APIAnimals.getLevel(p) == 1) {
						if(APIAnimals.getBal(p) >= OoOooOOo_cost_OoOOoO.levelup2r) {
							if(APIAnimals.getHearts(p) >= OoOooOOo_cost_OoOOoO.levelup2h) {
								APIAnimals.levelUp(p);
								APIAnimals.removeBal(p,OoOooOOo_cost_OoOOoO.levelup2r);
								APIAnimals.removeHearts(p,OoOooOOo_cost_OoOOoO.levelup2h);
							}else {
								s.sendMessage(MainAnimals.prefix+"§4Недостаточно §cсердец §4для повышения уровня! Требуется: "+OoOooOOo_cost_OoOOoO.levelup2h);
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для повышения уровня! Требуется: "+OoOooOOo_cost_OoOOoO.levelup2r);
						}
					}else if(APIAnimals.getLevel(p) == 2) {
						if(APIAnimals.getBal(p) >= OoOooOOo_cost_OoOOoO.levelup3r) {
							if(APIAnimals.getHearts(p) >= OoOooOOo_cost_OoOOoO.levelup3h) {
								APIAnimals.levelUp(p);
								APIAnimals.removeBal(p,OoOooOOo_cost_OoOOoO.levelup3r);
								APIAnimals.removeHearts(p,OoOooOOo_cost_OoOOoO.levelup3h);
							}else {
								s.sendMessage(MainAnimals.prefix+"§4Недостаточно §cсердец §4для повышения уровня! Требуется: "+OoOooOOo_cost_OoOOoO.levelup3h);
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для повышения уровня! Требуется: "+OoOooOOo_cost_OoOOoO.levelup3r);
						}
					}else if(APIAnimals.getLevel(p) == 3) {
						if(APIAnimals.getBal(p) >= OoOooOOo_cost_OoOOoO.levelup4r) {
							if(APIAnimals.getHearts(p) >= OoOooOOo_cost_OoOOoO.levelup4h) {
								APIAnimals.levelUp(p);
								APIAnimals.removeBal(p,OoOooOOo_cost_OoOOoO.levelup4r);
								APIAnimals.removeHearts(p,OoOooOOo_cost_OoOOoO.levelup4h);
							}else {
								s.sendMessage(MainAnimals.prefix+"§4Недостаточно §cсердец §4для повышения уровня! Требуется: "+OoOooOOo_cost_OoOOoO.levelup4h);
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для повышения уровня! Требуется: "+OoOooOOo_cost_OoOOoO.levelup4r);
						}
					}else if(APIAnimals.getLevel(p) == 4) {
						if(APIAnimals.getBal(p) >= OoOooOOo_cost_OoOOoO.levelup5r) {
							if(APIAnimals.getHearts(p) >= OoOooOOo_cost_OoOOoO.levelup5h) {
								APIAnimals.levelUp(p);
								APIAnimals.removeBal(p,OoOooOOo_cost_OoOOoO.levelup5r);
								APIAnimals.removeHearts(p,OoOooOOo_cost_OoOOoO.levelup5h);
							}else {
								s.sendMessage(MainAnimals.prefix+"§4Недостаточно §cсердец §4для повышения уровня! Требуется: "+OoOooOOo_cost_OoOOoO.levelup5h);
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для повышения уровня! Требуется: "+OoOooOOo_cost_OoOOoO.levelup5r);
						}
					}else if(APIAnimals.getLevel(p) == 5) {
						if(APIAnimals.getBal(p) >= OoOooOOo_cost_OoOOoO.levelup6r) {
							if(APIAnimals.getHearts(p) >= OoOooOOo_cost_OoOOoO.levelup6h) {
								APIAnimals.levelUp(p);
								APIAnimals.removeBal(p,OoOooOOo_cost_OoOOoO.levelup6r);
								APIAnimals.removeHearts(p,OoOooOOo_cost_OoOOoO.levelup6h);
							}else {
								s.sendMessage(MainAnimals.prefix+"§4Недостаточно §cсердец §4для повышения уровня! Требуется: "+OoOooOOo_cost_OoOOoO.levelup6h);
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для повышения уровня! Требуется: "+OoOooOOo_cost_OoOOoO.levelup6r);
						}
					}else if(APIAnimals.getLevel(p) == 6) {
						if(APIAnimals.getBal(p) >= OoOooOOo_cost_OoOOoO.levelup7r) {
							if(APIAnimals.getHearts(p) >= OoOooOOo_cost_OoOOoO.levelup7h) {
								APIAnimals.levelUp(p);
								APIAnimals.removeBal(p,OoOooOOo_cost_OoOOoO.levelup7r);
								APIAnimals.removeHearts(p,OoOooOOo_cost_OoOOoO.levelup7h);
							}else {
								s.sendMessage(MainAnimals.prefix+"§4Недостаточно §cсердец §4для повышения уровня! Требуется: "+OoOooOOo_cost_OoOOoO.levelup7h);
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для повышения уровня! Требуется: "+OoOooOOo_cost_OoOOoO.levelup7r);
						}
					}else if(APIAnimals.getLevel(p) == 7) {
						if(APIAnimals.getBal(p) >= OoOooOOo_cost_OoOOoO.levelup8r) {
							if(APIAnimals.getHearts(p) >= OoOooOOo_cost_OoOOoO.levelup8h) {
								APIAnimals.levelUp(p);
								APIAnimals.removeBal(p,OoOooOOo_cost_OoOOoO.levelup8r);
								APIAnimals.removeHearts(p,OoOooOOo_cost_OoOOoO.levelup8h);
							}else {
								s.sendMessage(MainAnimals.prefix+"§4Недостаточно §cсердец §4для повышения уровня! Требуется: "+OoOooOOo_cost_OoOOoO.levelup8h);
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для повышения уровня! Требуется: "+OoOooOOo_cost_OoOOoO.levelup8r);
						}
					}else if(APIAnimals.getLevel(p) == 8) {
						if(APIAnimals.getBal(p) >= OoOooOOo_cost_OoOOoO.levelup9r) {
							if(APIAnimals.getHearts(p) >= OoOooOOo_cost_OoOOoO.levelup9h) {
								APIAnimals.levelUp(p);
								APIAnimals.removeBal(p,OoOooOOo_cost_OoOOoO.levelup9r);
								APIAnimals.removeHearts(p,OoOooOOo_cost_OoOOoO.levelup9h);
							}else {
								s.sendMessage(MainAnimals.prefix+"§4Недостаточно §cсердец §4для повышения уровня! Требуется: "+OoOooOOo_cost_OoOOoO.levelup9h);
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для повышения уровня! Требуется: "+OoOooOOo_cost_OoOOoO.levelup9r);
						}
					}else if(APIAnimals.getLevel(p) == 9) {
						if(APIAnimals.getBal(p) >= OoOooOOo_cost_OoOOoO.levelup10r) {
							if(APIAnimals.getHearts(p) >= OoOooOOo_cost_OoOOoO.levelup10h) {
								APIAnimals.levelUp(p);
								APIAnimals.removeBal(p,OoOooOOo_cost_OoOOoO.levelup10r);
								APIAnimals.removeHearts(p,OoOooOOo_cost_OoOOoO.levelup10h);
							}else {
								s.sendMessage(MainAnimals.prefix+"§4Недостаточно §cсердец §4для повышения уровня! Требуется: "+OoOooOOo_cost_OoOOoO.levelup10h);
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для повышения уровня! Требуется: "+OoOooOOo_cost_OoOOoO.levelup10r);
						}
					}else if(APIAnimals.getLevel(p) == 10) {
						if(APIAnimals.getBal(p) >= OoOooOOo_cost_OoOOoO.levelup11r) {
							if(APIAnimals.getHearts(p) >= OoOooOOo_cost_OoOOoO.levelup11h) {
								APIAnimals.levelUp(p);
								APIAnimals.removeBal(p,OoOooOOo_cost_OoOOoO.levelup11r);
								APIAnimals.removeHearts(p,OoOooOOo_cost_OoOOoO.levelup11h);
							}else {
								s.sendMessage(MainAnimals.prefix+"§4Недостаточно §cсердец §4для повышения уровня! Требуется: "+OoOooOOo_cost_OoOOoO.levelup11h);
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для повышения уровня! Требуется: "+OoOooOOo_cost_OoOOoO.levelup11r);
						}
					}else if(APIAnimals.getLevel(p) == 11) {
						if(APIAnimals.getBal(p) >= OoOooOOo_cost_OoOOoO.levelup12r) {
							if(APIAnimals.getHearts(p) >= OoOooOOo_cost_OoOOoO.levelup12h) {
								APIAnimals.levelUp(p);
								APIAnimals.removeBal(p,OoOooOOo_cost_OoOOoO.levelup12r);
								APIAnimals.removeHearts(p,OoOooOOo_cost_OoOOoO.levelup12h);
							}else {
								s.sendMessage(MainAnimals.prefix+"§4Недостаточно §cсердец §4для повышения уровня! Требуется: "+OoOooOOo_cost_OoOOoO.levelup12h);
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для повышения уровня! Требуется: "+OoOooOOo_cost_OoOOoO.levelup12r);
						}
					}else if(APIAnimals.getLevel(p) == 12) {
						if(APIAnimals.getBal(p) >= OoOooOOo_cost_OoOOoO.levelup13r) {
							if(APIAnimals.getHearts(p) >= OoOooOOo_cost_OoOOoO.levelup13h) {
								APIAnimals.levelUp(p);
								APIAnimals.removeBal(p,OoOooOOo_cost_OoOOoO.levelup13r);
								APIAnimals.removeHearts(p,OoOooOOo_cost_OoOOoO.levelup13h);
							}else {
								s.sendMessage(MainAnimals.prefix+"§4Недостаточно §cсердец §4для повышения уровня! Требуется: "+OoOooOOo_cost_OoOOoO.levelup13h);
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для повышения уровня! Требуется: "+OoOooOOo_cost_OoOOoO.levelup13r);
						}
					}else if(APIAnimals.getLevel(p) == 13) {
						if(APIAnimals.getBal(p) >= OoOooOOo_cost_OoOOoO.levelup14r) {
							if(APIAnimals.getHearts(p) >= OoOooOOo_cost_OoOOoO.levelup14h) {
								APIAnimals.levelUp(p);
								APIAnimals.removeBal(p,OoOooOOo_cost_OoOOoO.levelup14r);
								APIAnimals.removeHearts(p,OoOooOOo_cost_OoOOoO.levelup14h);
							}else {
								s.sendMessage(MainAnimals.prefix+"§4Недостаточно §cсердец §4для повышения уровня! Требуется: "+OoOooOOo_cost_OoOOoO.levelup14h);
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для повышения уровня! Требуется: "+OoOooOOo_cost_OoOOoO.levelup14r);
						}
					}else if(APIAnimals.getLevel(p) == 14) {
						if(APIAnimals.getBal(p) >= OoOooOOo_cost_OoOOoO.levelup15r) {
							if(APIAnimals.getHearts(p) >= OoOooOOo_cost_OoOOoO.levelup15h) {
								APIAnimals.levelUp(p);
								APIAnimals.removeBal(p,OoOooOOo_cost_OoOOoO.levelup15r);
								APIAnimals.removeHearts(p,OoOooOOo_cost_OoOOoO.levelup15h);
							}else {
								s.sendMessage(MainAnimals.prefix+"§4Недостаточно §cсердец §4для повышения уровня! Требуется: "+OoOooOOo_cost_OoOOoO.levelup15h);
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для повышения уровня! Требуется: "+OoOooOOo_cost_OoOOoO.levelup15r);
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
