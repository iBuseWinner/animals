package ru.ibusewinner.animals.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ru.ibusewinner.animals.APIAnimals;
import ru.ibusewinner.animals.MainAnimals;
import ru.ibusewinner.animals.Сost;

public class CmdsAnimals implements CommandExecutor{

	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		if(!(s instanceof Player)) {
			s.sendMessage(MainAnimals.prefix+"§cКоманда только для игроков!");
		}else {
			if(c.getName().equalsIgnoreCase("buy")) {
				Player send = (Player)s;
				if(a.length == 0) {
					s.sendMessage(MainAnimals.prefix+"§cИспользование: /buy list|biz|human <№ бизнеса/человека> - купить бизнес|хозяина");
				}else {
					if(a[0].equalsIgnoreCase("list")) {
						if(a.length == 1) {
							s.sendMessage(MainAnimals.prefix+"§cИспользование: /buy list biz|human - посмотреть список бизнесов|хозяинов");
						}else if(a.length == 2){
							if(a[1].equalsIgnoreCase("biz")) {
								s.sendMessage(MainAnimals.prefix+"§bСписок бизнесов:");
                                s.sendMessage(MainAnimals.prefix+"§aНазвание - цена - доход (р/сек)");
                                s.sendMessage(MainAnimals.prefix+"1.§cКолодец §2 - §c300|600|900|1200|1500 §2- §c5р/сек");
                                s.sendMessage(MainAnimals.prefix+"2.§cФерма §2- §c10.000|20.000|30.000|40.000|50.000р §2- §c10р/сек");
                                s.sendMessage(MainAnimals.prefix+"3.§cДеревенский Приют §2- §c100.000|200.000|300.000|400.000|500.000р §2- §c50р/сек");
                                s.sendMessage(MainAnimals.prefix+"4.§cГородской Приют §2- §c500.000|1.000.000|1.500.000|2.000.000|2.500.000р §2- §c75р/сек");
                                s.sendMessage(MainAnimals.prefix+"5.§cЦирк §2- §c1.000.000|2.000.000|3.000.000|4.000.000|5.000.000р §2- §c120р/сек");
                                s.sendMessage(MainAnimals.prefix+"6.§cЗверопой §2- §c5.000.000|10.000.000|15.000.000|20.000.000|25.000.000р §2- §c250р/сек");
                                s.sendMessage(MainAnimals.prefix+"7.§cЗверополис §2- §c25.000.000|50.000.000|75.000.000|100.000.000|125.000.000р §2- §c500р/сек");
                                s.sendMessage(MainAnimals.prefix+"8.§cСтрана зверей §2- §c1.000.000.000|2.000.000.000|3.000.000.000|4.000.000.000|5.000.000.000р §2- §c100.000р/сек");
							}else if(a[1].equalsIgnoreCase("human")){
								s.sendMessage(MainAnimals.prefix+"§bСписок хозяев:");
                                s.sendMessage(MainAnimals.prefix+"§aИмя - цена - даёт ❤");
                                s.sendMessage(MainAnimals.prefix+"1.§6Костя §3- §6500р §3- §c250❤");
                                s.sendMessage(MainAnimals.prefix+"2.§6Анна §3- §61.000р §3- §c500❤");
                                s.sendMessage(MainAnimals.prefix+"3.§6Иван §3- §65.000р §3- §c2.500❤");
                                s.sendMessage(MainAnimals.prefix+"4.§6Сергей §3- §610.000р §3- §c5.000❤");
                                s.sendMessage(MainAnimals.prefix+"5.§6Мария §3- §625.000р §3- §c10.000❤");
                                s.sendMessage(MainAnimals.prefix+"6.§6Михаил §3- §650.000р §3- §c25.000❤");
                                s.sendMessage(MainAnimals.prefix+"7.§6София §3- §6100.000р §3- §c50.000❤");
                                s.sendMessage(MainAnimals.prefix+"8.§6Никита §3- §6250.000р §3- §c100.000❤");
                                s.sendMessage(MainAnimals.prefix+"9.§6Александра §3- §6500.000р §3- §c250.000❤");
							}else {
								s.sendMessage(MainAnimals.prefix+"§cИспользование: /buy list biz|human - посмотреть список бизнесов|хозяинов");
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cИспользование: /buy list biz|human - посмотреть список бизнесов|хозяинов");
						}
					}else if(a[0].equalsIgnoreCase("biz") && a.length == 2) {
						if(a[1].equalsIgnoreCase("1")) {
							if(APIAnimals.getBizKol(send) == 0) {
								if(APIAnimals.getBal(send) >= 300) {
									APIAnimals.removeBal(send,300);
									APIAnimals.addIncome(send,5);
									APIAnimals.addBiz(send);
									APIAnimals.addBizKol(send);
									APIAnimals.addHearts(send,20);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aКолодец§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage("§7Бабушка§8: §7Ой, милок, маловато у тебя денюжек, подкопи ещё, а потом приходи.");
								}
							}else if(APIAnimals.getBizKol(send) == 1) {
								if(APIAnimals.getBal(send) >= 600) {
									APIAnimals.removeBal(send,600);
									APIAnimals.addIncome(send,6);
									APIAnimals.addBiz(send);
									APIAnimals.addBizKol(send);
									APIAnimals.addHearts(send,20);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aКолодец§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage("§7Бабушка§8: §7Ой, милок, маловато у тебя денюжек, подкопи ещё, а потом приходи.");
								}
							}else if(APIAnimals.getBizKol(send) == 2) {
								if(APIAnimals.getBal(send) >= 900) {
									APIAnimals.removeBal(send,900);
									APIAnimals.addIncome(send,7);
									APIAnimals.addBiz(send);
									APIAnimals.addBizKol(send);
									APIAnimals.addHearts(send,20);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aКолодец§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage("§7Бабушка§8: §7Ой, милок, маловато у тебя денюжек, подкопи ещё, а потом приходи.");
								}
							}else if(APIAnimals.getBizKol(send) == 3) {
								if(APIAnimals.getBal(send) >= 1200) {
									APIAnimals.removeBal(send,1200);
									APIAnimals.addIncome(send,8);
									APIAnimals.addBiz(send);
									APIAnimals.addBizKol(send);
									APIAnimals.addHearts(send,20);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aКолодец§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage("§7Бабушка§8: §7Ой, милок, маловато у тебя денюжек, подкопи ещё, а потом приходи.");
								}
							}else if(APIAnimals.getBizKol(send) == 4) {
								if(APIAnimals.getBal(send) >= 1500) {
									APIAnimals.removeBal(send,1500);
									APIAnimals.addIncome(send,10);
									APIAnimals.addBiz(send);
									APIAnimals.addBizKol(send);
									APIAnimals.addHearts(send,20);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aКолодец§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage("§7Бабушка§8: §7Ой, милок, маловато у тебя денюжек, подкопи ещё, а потом приходи.");
								}
							}else if(APIAnimals.getBizKol(send) == 5) {
								s.sendMessage(MainAnimals.prefix+"§aВы купили максимальное количество данного бизнеса!");
							}
						}else if(a[1].equalsIgnoreCase("2")) {
							if(APIAnimals.getBizFarm(send) == 0) {
								if(APIAnimals.getBal(send) >= 10000) {
									APIAnimals.removeBal(send,10000);
									APIAnimals.addIncome(send,10);
									APIAnimals.addBiz(send);
									APIAnimals.addBizFarm(send);
									APIAnimals.addHearts(send,50);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aФерма§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage("§7Фермер§8: §7Ээээ, ишь чего захотел! Вот когда накопишь больше денег, тогда и возвращайся");
								}
							}else if(APIAnimals.getBizFarm(send) == 1) {
								if(APIAnimals.getBal(send) >= 20000) {
									APIAnimals.removeBal(send,20000);
									APIAnimals.addIncome(send,10);
									APIAnimals.addBiz(send);
									APIAnimals.addBizFarm(send);
									APIAnimals.addHearts(send,50);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aФерма§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage("§7Фермер§8: §7Ээээ, ишь чего захотел! Вот когда накопишь больше денег, тогда и возвращайся");
								}
							}else if(APIAnimals.getBizFarm(send) == 2) {
								if(APIAnimals.getBal(send) >= 30000) {
									APIAnimals.removeBal(send,30000);
									APIAnimals.addIncome(send,5);
									APIAnimals.addBiz(send);
									APIAnimals.addBizFarm(send);
									APIAnimals.addHearts(send,50);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aФерма§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage("§7Фермер§8: §7Ээээ, ишь чего захотел! Вот когда накопишь больше денег, тогда и возвращайся");
								}
							}else if(APIAnimals.getBizFarm(send) == 3) {
								if(APIAnimals.getBal(send) >= 40000) {
									APIAnimals.removeBal(send,40000);
									APIAnimals.addIncome(send,10);
									APIAnimals.addBiz(send);
									APIAnimals.addBizFarm(send);
									APIAnimals.addHearts(send,50);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aФерма§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage("§7Фермер§8: §7Ээээ, ишь чего захотел! Вот когда накопишь больше денег, тогда и возвращайся");
								}
							}else if(APIAnimals.getBizFarm(send) == 4) {
								if(APIAnimals.getBal(send) >= 50000) {
									APIAnimals.removeBal(send,50000);
									APIAnimals.addIncome(send,10);
									APIAnimals.addBiz(send);
									APIAnimals.addBizFarm(send);
									APIAnimals.addHearts(send,50);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aФерма§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage("§7Фермер§8: §7Ээээ, ишь чего захотел! Вот когда накопишь больше денег, тогда и возвращайся");
								}
							}else if(APIAnimals.getBizFarm(send) == 5) {
								s.sendMessage(MainAnimals.prefix+"§aВы купили максимальное количество данного бизнеса!");
							}
						}else if(a[1].equalsIgnoreCase("3")) {
							if(APIAnimals.getBizDerPri(send) == 0) {
								if(APIAnimals.getBal(send) >= 100000) {
									APIAnimals.removeBal(send,100000);
									APIAnimals.addIncome(send,50);
									APIAnimals.addBiz(send);
									APIAnimals.addBizDerPri(send);
									APIAnimals.addHearts(send,75);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aДеревенский Приют§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage("§7Работник приюта§8: §7Кыш отсюда, а то к себе в приют заберу!");
								}
							}else if(APIAnimals.getBizDerPri(send) == 1) {
								if(APIAnimals.getBal(send) >= 200000) {
									APIAnimals.removeBal(send,200000);
									APIAnimals.addIncome(send,50);
									APIAnimals.addBiz(send);
									APIAnimals.addBizDerPri(send);
									APIAnimals.addHearts(send,75);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aДеревенский Приют§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage("§7Работник приюта§8: §7Кыш отсюда, а то к себе в приют заберу!");
								}
							}else if(APIAnimals.getBizDerPri(send) == 2) {
								if(APIAnimals.getBal(send) >= 300000) {
									APIAnimals.removeBal(send,300000);
									APIAnimals.addIncome(send,50);
									APIAnimals.addBiz(send);
									APIAnimals.addBizDerPri(send);
									APIAnimals.addHearts(send,75);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aДеревенский Приют§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage("§7Работник приюта§8: §7Кыш отсюда, а то к себе в приют заберу!");
								}
							}else if(APIAnimals.getBizDerPri(send) == 3) {
								if(APIAnimals.getBal(send) >= 400000) {
									APIAnimals.removeBal(send,400000);
									APIAnimals.addIncome(send,50);
									APIAnimals.addBiz(send);
									APIAnimals.addBizDerPri(send);
									APIAnimals.addHearts(send,75);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aДеревенский Приют§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage("§7Работник приюта§8: §7Кыш отсюда, а то к себе в приют заберу!");
								}
							}else if(APIAnimals.getBizDerPri(send) == 4) {
								if(APIAnimals.getBal(send) >= 500000) {
									APIAnimals.removeBal(send,500000);
									APIAnimals.addIncome(send,50);
									APIAnimals.addBiz(send);
									APIAnimals.addBizDerPri(send);
									APIAnimals.addHearts(send,75);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aДеревенский Приют§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage("§7Работник приюта§8: §7Кыш отсюда, а то к себе в приют заберу!");
								}
							}else if(APIAnimals.getBizDerPri(send) == 5) {
								s.sendMessage(MainAnimals.prefix+"§aВы купили максимальное количество данного бизнеса!");
							}
						}else if(a[1].equalsIgnoreCase("4")) {
							if(APIAnimals.getBizGorPri(send) == 0) {
								if(APIAnimals.getBal(send) >= 500000) {
									APIAnimals.removeBal(send,500000);
									APIAnimals.addIncome(send,75);
									APIAnimals.addBiz(send);
									APIAnimals.addBizGorPri(send);
									APIAnimals.addHearts(send,75);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aГородской Приют§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного бизнеса!");
								}
							}else if(APIAnimals.getBizGorPri(send) == 1) {
								if(APIAnimals.getBal(send) >= 1000000) {
									APIAnimals.removeBal(send,1000000);
									APIAnimals.addIncome(send,75);
									APIAnimals.addBiz(send);
									APIAnimals.addBizGorPri(send);
									APIAnimals.addHearts(send,75);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aГородской Приют§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного бизнеса!");
								}
							}else if(APIAnimals.getBizGorPri(send) == 2) {
								if(APIAnimals.getBal(send) >= 1500000) {
									APIAnimals.removeBal(send,1500000);
									APIAnimals.addIncome(send,75);
									APIAnimals.addBiz(send);
									APIAnimals.addBizGorPri(send);
									APIAnimals.addHearts(send,75);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aГородской Приют§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного бизнеса!");
								}
							}else if(APIAnimals.getBizGorPri(send) == 3) {
								if(APIAnimals.getBal(send) >= 2000000) {
									APIAnimals.removeBal(send,2000000);
									APIAnimals.addIncome(send,75);
									APIAnimals.addBiz(send);
									APIAnimals.addBizGorPri(send);
									APIAnimals.addHearts(send,75);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aГородской Приют§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного бизнеса!");
								}
							}else if(APIAnimals.getBizGorPri(send) == 4) {
								if(APIAnimals.getBal(send) >= 2500000) {
									APIAnimals.removeBal(send,2500000);
									APIAnimals.addIncome(send,75);
									APIAnimals.addBiz(send);
									APIAnimals.addBizGorPri(send);
									APIAnimals.addHearts(send,75);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aГородской Приют§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного бизнеса!");
								}
							}else if(APIAnimals.getBizGorPri(send) == 5) {
								s.sendMessage(MainAnimals.prefix+"§aВы купили максимальное количество данного бизнеса!");
							}
						}else if(a[1].equalsIgnoreCase("5")) {
							if(APIAnimals.getBizCirc(send) == 0) {
								if(APIAnimals.getBal(send) >= 1000000) {
									APIAnimals.removeBal(send,1000000);
									APIAnimals.addIncome(send,120);
									APIAnimals.addBiz(send);
									APIAnimals.addBizCirc(send);
									APIAnimals.addHearts(send,100);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aВоздушный шар§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного бизнеса!");
								}
							}else if(APIAnimals.getBizCirc(send) == 1) {
								if(APIAnimals.getBal(send) >= 2000000) {
									APIAnimals.removeBal(send,2000000);
									APIAnimals.addIncome(send,120);
									APIAnimals.addBiz(send);
									APIAnimals.addBizCirc(send);
									APIAnimals.addHearts(send,100);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aВоздушный шар§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного бизнеса!");
								}
							}else if(APIAnimals.getBizCirc(send) == 2) {
								if(APIAnimals.getBal(send) >= 3000000) {
									APIAnimals.removeBal(send,3000000);
									APIAnimals.addIncome(send,120);
									APIAnimals.addBiz(send);
									APIAnimals.addBizCirc(send);
									APIAnimals.addHearts(send,100);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aВоздушный шар§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного бизнеса!");
								}
							}else if(APIAnimals.getBizCirc(send) == 3) {
								if(APIAnimals.getBal(send) >= 4000000) {
									APIAnimals.removeBal(send,4000000);
									APIAnimals.addIncome(send,120);
									APIAnimals.addBiz(send);
									APIAnimals.addBizCirc(send);
									APIAnimals.addHearts(send,100);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aВоздушный шар§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного бизнеса!");
								}
							}else if(APIAnimals.getBizCirc(send) == 4) {
								if(APIAnimals.getBal(send) >= 5000000) {
									APIAnimals.removeBal(send,5000000);
									APIAnimals.addIncome(send,120);
									APIAnimals.addBiz(send);
									APIAnimals.addBizCirc(send);
									APIAnimals.addHearts(send,100);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aВоздушный шар§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного бизнеса!");
								}
							}else if(APIAnimals.getBizCirc(send) == 5) {
								s.sendMessage(MainAnimals.prefix+"§aВы купили максимальное количество данного бизнеса!");
							}
						}else if(a[1].equalsIgnoreCase("6")) {
							if(APIAnimals.getBizAniPoy(send) == 0) {
								if(APIAnimals.getBal(send) >= 5000000) {
									APIAnimals.removeBal(send,5000000);
									APIAnimals.addIncome(send,250);
									APIAnimals.addBiz(send);
									APIAnimals.addBizAniPoy(send);
									APIAnimals.addHearts(send,1000);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aЗверопой§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного бизнеса!");
								}
							}else if(APIAnimals.getBizAniPoy(send) == 1) {
								if(APIAnimals.getBal(send) >= 10000000) {
									APIAnimals.removeBal(send,10000000);
									APIAnimals.addIncome(send,250);
									APIAnimals.addBiz(send);
									APIAnimals.addBizAniPoy(send);
									APIAnimals.addHearts(send,1000);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aЗверопой§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного бизнеса!");
								}
							}else if(APIAnimals.getBizAniPoy(send) == 2) {
								if(APIAnimals.getBal(send) >= 15000000) {
									APIAnimals.removeBal(send,15000000);
									APIAnimals.addIncome(send,250);
									APIAnimals.addBiz(send);
									APIAnimals.addBizAniPoy(send);
									APIAnimals.addHearts(send,1000);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aЗверопой§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного бизнеса!");
								}
							}else if(APIAnimals.getBizAniPoy(send) == 3) {
								if(APIAnimals.getBal(send) >= 20000000) {
									APIAnimals.removeBal(send,20000000);
									APIAnimals.addIncome(send,250);
									APIAnimals.addBiz(send);
									APIAnimals.addBizAniPoy(send);
									APIAnimals.addHearts(send,1000);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aЗверопой§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного бизнеса!");
								}
							}else if(APIAnimals.getBizAniPoy(send) == 4) {
								if(APIAnimals.getBal(send) >= 25000000) {
									APIAnimals.removeBal(send,25000000);
									APIAnimals.addIncome(send,250);
									APIAnimals.addBiz(send);
									APIAnimals.addBizAniPoy(send);
									APIAnimals.addHearts(send,1000);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aЗверопой§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного бизнеса!");
								}
							}else if(APIAnimals.getBizAniPoy(send) == 5) {
								s.sendMessage(MainAnimals.prefix+"§aВы купили максимальное количество данного бизнеса!");
							}
						}else if(a[1].equalsIgnoreCase("7")) {
							if(APIAnimals.getBizAniPol(send) == 0) {
								if(APIAnimals.getBal(send) >= 25000000) {
									APIAnimals.removeBal(send,25000000);
									APIAnimals.addIncome(send,500);
									APIAnimals.addBiz(send);
									APIAnimals.addBizAniPol(send);
									APIAnimals.addHearts(send,5000);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aЗверополис§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного бизнеса!");
								}
							}else if(APIAnimals.getBizAniPol(send) == 1) {
								if(APIAnimals.getBal(send) >= 50000000) {
									APIAnimals.removeBal(send,50000000);
									APIAnimals.addIncome(send,500);
									APIAnimals.addBiz(send);
									APIAnimals.addBizAniPol(send);
									APIAnimals.addHearts(send,5000);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aЗверополис§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного бизнеса!");
								}
							}else if(APIAnimals.getBizAniPol(send) == 2) {
								if(APIAnimals.getBal(send) >= 75000000) {
									APIAnimals.removeBal(send,75000000);
									APIAnimals.addIncome(send,500);
									APIAnimals.addBiz(send);
									APIAnimals.addBizAniPol(send);
									APIAnimals.addHearts(send,5000);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aЗверополис§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного бизнеса!");
								}
							}else if(APIAnimals.getBizAniPol(send) == 3) {
								if(APIAnimals.getBal(send) >= 100000000) {
									APIAnimals.removeBal(send,100000000);
									APIAnimals.addIncome(send,500);
									APIAnimals.addBiz(send);
									APIAnimals.addBizAniPol(send);
									APIAnimals.addHearts(send,5000);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aЗверополис§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного бизнеса!");
								}
							}else if(APIAnimals.getBizAniPol(send) == 4) {
								if(APIAnimals.getBal(send) >= 125000000) {
									APIAnimals.removeBal(send,125000000);
									APIAnimals.addIncome(send,500);
									APIAnimals.addBiz(send);
									APIAnimals.addBizAniPol(send);
									APIAnimals.addHearts(send,5000);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aЗверополис§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного бизнеса!");
								}
							}else if(APIAnimals.getBizAniPol(send) == 5) {
								s.sendMessage(MainAnimals.prefix+"§aВы купили максимальное количество данного бизнеса!");
							}
						}else if(a[1].equalsIgnoreCase("8")) {
							if(APIAnimals.getBizAniCou(send) == 0) {
								if(APIAnimals.getBal(send) >= 1000000000) {
									APIAnimals.removeBal(send,1000000000);
									APIAnimals.addIncome(send,100000);
									APIAnimals.addBiz(send);
									APIAnimals.addBizAniCou(send);
									APIAnimals.addHearts(send,10000);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aСтрана Зверей§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного бизнеса!");
								}
							}else if(APIAnimals.getBizAniCou(send) == 1) {
								if(APIAnimals.getBal(send) >= 2000000000) {
									APIAnimals.removeBal(send,2000000000);
									APIAnimals.addIncome(send,100000);
									APIAnimals.addBiz(send);
									APIAnimals.addBizAniCou(send);
									APIAnimals.addHearts(send,10000);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aСтрана Зверей§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного бизнеса!");
								}
							}else if(APIAnimals.getBizAniCou(send) == 2) {
								if(APIAnimals.getBal(send) >= 2147483647) {
									APIAnimals.removeBal(send,2147483647);
									APIAnimals.addIncome(send,100000);
									APIAnimals.addBiz(send);
									APIAnimals.addBizAniCou(send);
									APIAnimals.addHearts(send,10000);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aСтрана Зверей§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного бизнеса!");
								}
							}else if(APIAnimals.getBizAniCou(send) == 3) {
								if(APIAnimals.getBal(send) >= 2147483647) {
									APIAnimals.removeBal(send,2147483647);
									APIAnimals.addIncome(send,100000);
									APIAnimals.addBiz(send);
									APIAnimals.addBizAniCou(send);
									APIAnimals.addHearts(send,10000);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aСтрана Зверей§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного бизнеса!");
								}
							}else if(APIAnimals.getBizAniCou(send) == 4) {
								if(APIAnimals.getBal(send) >= 2147483647) {
									APIAnimals.removeBal(send,2147483647);
									APIAnimals.addIncome(send,100000);
									APIAnimals.addBiz(send);
									APIAnimals.addBizAniCou(send);
									APIAnimals.addHearts(send,10000);
									
									s.sendMessage(MainAnimals.prefix+"§bВы успешно купили бизнес §aСтрана Зверей§b!");
									s.sendMessage(MainAnimals.prefix+"§dВаш новый доход: §c"+APIAnimals.getIncome(send));
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного бизнеса!");
								}
							}else if(APIAnimals.getBizAniCou(send) == 5) {
								s.sendMessage(MainAnimals.prefix+"§aВы купили максимальное количество данного бизнеса!");
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cИспользование: /buy list biz");
						}
					}else if(a[0].equalsIgnoreCase("human") && a.length == 2) {
						if(a[1].equalsIgnoreCase("1")) {
							if(APIAnimals.getHum1(send) == 0) {
								if(APIAnimals.getBal(send) >= Сost.hum1r) {
									if(APIAnimals.getHearts(send) >= Сost.hum1h) {
										APIAnimals.removeHearts(send,Сost.hum1h);
										APIAnimals.removeBal(send,Сost.hum1r);
										APIAnimals.addHuman(send,1);
										APIAnimals.addHum1(send);
										APIAnimals.addHearts(send,250);
										
										s.sendMessage(MainAnimals.prefix+"§bВы успешно купили хозяина!");
									}else {
										s.sendMessage(MainAnimals.prefix+"§cНедостаточно сердечек для покупки данного хозяина!");
									}
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного хозяина!");
								}
							}else {
								s.sendMessage(MainAnimals.prefix+"§aВы уже купили данного хозяина!");
							}
						}else if(a[1].equalsIgnoreCase("2")) {
							if(APIAnimals.getHum2(send) == 0) {
								if(APIAnimals.getBal(send) >= Сost.hum2r) {
									if(APIAnimals.getHearts(send) >= Сost.hum2h) {
										APIAnimals.removeHearts(send,Сost.hum2h);
										APIAnimals.removeBal(send,Сost.hum2r);
										APIAnimals.addHuman(send,1);
										APIAnimals.addHum2(send);
										APIAnimals.addHearts(send,750);
										
										s.sendMessage(MainAnimals.prefix+"§bВы успешно купили хозяина!");
									}else {
										s.sendMessage(MainAnimals.prefix+"§cНедостаточно сердечек для покупки данного хозяина!");
									}
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного хозяина!");
								}
							}else {
								s.sendMessage(MainAnimals.prefix+"§aВы уже купили данного хозяина!");
							}
						}else if(a[1].equalsIgnoreCase("3")) {
							if(APIAnimals.getHum3(send) == 0) {
								if(APIAnimals.getBal(send) >= Сost.hum3r) {
									if(APIAnimals.getHearts(send) >= Сost.hum3h) {
										APIAnimals.removeHearts(send,Сost.hum3h);
										APIAnimals.removeBal(send,Сost.hum3r);
										APIAnimals.addHuman(send,1);
										APIAnimals.addHum3(send);
										APIAnimals.addHearts(send,1250);
										
										s.sendMessage(MainAnimals.prefix+"§bВы успешно купили хозяина!");
									}else {
										s.sendMessage(MainAnimals.prefix+"§cНедостаточно сердечек для покупки данного хозяина!");
									}
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного хозяина!");
								}
							}else {
								s.sendMessage(MainAnimals.prefix+"§aВы уже купили данного хозяина!");
							}
						}else if(a[1].equalsIgnoreCase("4")) {
							if(APIAnimals.getHum4(send) == 0) {
								if(APIAnimals.getBal(send) >= Сost.hum4r) {
									if(APIAnimals.getHearts(send) >= Сost.hum4h) {
										APIAnimals.removeHearts(send,Сost.hum4h);
										APIAnimals.removeBal(send,Сost.hum4r);
										APIAnimals.addHuman(send,1);
										APIAnimals.addHum4(send);
										APIAnimals.addHearts(send,2000);
										
										s.sendMessage(MainAnimals.prefix+"§bВы успешно купили хозяина!");
									}else {
										s.sendMessage(MainAnimals.prefix+"§cНедостаточно сердечек для покупки данного хозяина!");
									}
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного хозяина!");
								}
							}else {
								s.sendMessage(MainAnimals.prefix+"§aВы уже купили данного хозяина!");
							}
						}else if(a[1].equalsIgnoreCase("5")) {
							if(APIAnimals.getHum5(send) == 0) {
								if(APIAnimals.getBal(send) >= Сost.hum5r) {
									if(APIAnimals.getHearts(send) >= Сost.hum5h) {
										APIAnimals.removeHearts(send,Сost.hum5h);
										APIAnimals.removeBal(send,Сost.hum5r);
										APIAnimals.addHuman(send,1);
										APIAnimals.addHum5(send);
										APIAnimals.addHearts(send,5000);
										
										s.sendMessage(MainAnimals.prefix+"§bВы успешно купили хозяина!");
									}else {
										s.sendMessage(MainAnimals.prefix+"§cНедостаточно сердечек для покупки данного хозяина!");
									}
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного хозяина!");
								}
							}else {
								s.sendMessage(MainAnimals.prefix+"§aВы уже купили данного хозяина!");
							}
						}else if(a[1].equalsIgnoreCase("6")) {
							if(APIAnimals.getHum6(send) == 0) {
								if(APIAnimals.getBal(send) >= Сost.hum6r) {
									if(APIAnimals.getHearts(send) >= Сost.hum6h) {
										APIAnimals.removeHearts(send,Сost.hum6h);
										APIAnimals.removeBal(send,Сost.hum6r);
										APIAnimals.addHuman(send,1);
										APIAnimals.addHum6(send);
										APIAnimals.addHearts(send,15000);
										
										s.sendMessage(MainAnimals.prefix+"§bВы успешно купили хозяина!");
									}else {
										s.sendMessage(MainAnimals.prefix+"§cНедостаточно сердечек для покупки данного хозяина!");
									}
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного хозяина!");
								}
							}else {
								s.sendMessage(MainAnimals.prefix+"§aВы уже купили данного хозяина!");
							}
						}else if(a[1].equalsIgnoreCase("7")) {
							if(APIAnimals.getHum7(send) == 0) {
								if(APIAnimals.getBal(send) >= Сost.hum7r) {
									if(APIAnimals.getHearts(send) >= Сost.hum7h) {
										APIAnimals.removeHearts(send,Сost.hum7h);
										APIAnimals.removeBal(send,Сost.hum7r);
										APIAnimals.addHuman(send,1);
										APIAnimals.addHum7(send);
										APIAnimals.addHearts(send,30000);
										
										s.sendMessage(MainAnimals.prefix+"§bВы успешно купили хозяина!");
									}else {
										s.sendMessage(MainAnimals.prefix+"§cНедостаточно сердечек для покупки данного хозяина!");
									}
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного хозяина!");
								}
							}else {
								s.sendMessage(MainAnimals.prefix+"§aВы уже купили данного хозяина!");
							}
						}else if(a[1].equalsIgnoreCase("8")) {
							if(APIAnimals.getHum8(send) == 0) {
								if(APIAnimals.getBal(send) >= Сost.hum8r) {
									if(APIAnimals.getHearts(send) >= Сost.hum8h) {
										APIAnimals.removeHearts(send,Сost.hum8h);
										APIAnimals.removeBal(send,Сost.hum8r);
										APIAnimals.addHuman(send,1);
										APIAnimals.addHum8(send);
										
										s.sendMessage(MainAnimals.prefix+"§bВы успешно купили хозяина!");
									}else {
										s.sendMessage(MainAnimals.prefix+"§cНедостаточно сердечек для покупки данного хозяина!");
									}
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного хозяина!");
								}
							}else {
								s.sendMessage(MainAnimals.prefix+"§aВы уже купили данного хозяина!");
							}
						}else if(a[1].equalsIgnoreCase("9")) {
							if(APIAnimals.getHum9(send) == 0) {
								if(APIAnimals.getBal(send) >= Сost.hum9r) {
									if(APIAnimals.getHearts(send) >= Сost.hum9h) {
										APIAnimals.removeHearts(send,Сost.hum9h);
										APIAnimals.removeBal(send,Сost.hum9r);
										APIAnimals.addHuman(send,1);
										APIAnimals.addHum9(send);
										
										s.sendMessage(MainAnimals.prefix+"§bВы успешно купили хозяина!");
									}else {
										s.sendMessage(MainAnimals.prefix+"§cНедостаточно сердечек для покупки данного хозяина!");
									}
								}else {
									s.sendMessage(MainAnimals.prefix+"§cНедостаточно средств для покупки данного хозяина!");
								}
							}else {
								s.sendMessage(MainAnimals.prefix+"§aВы уже купили данного хозяина!");
							}
						}else {
							s.sendMessage(MainAnimals.prefix+"§cИспользование: /buy list human");
						}
					}else if(a[0].equalsIgnoreCase("biz") && a.length == 1) {
						s.sendMessage(MainAnimals.prefix+"§cИспользование: /buy biz <№ бизнеса>");
					}else if(a[0].equalsIgnoreCase("human") && a.length == 1) {
						s.sendMessage(MainAnimals.prefix+"§cИспользование: /buy human <№ хозяина>");
					}
				}
			}
		}
		
		return true;
	}
}
