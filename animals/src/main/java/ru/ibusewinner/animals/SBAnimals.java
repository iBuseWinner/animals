package ru.ibusewinner.animals;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import de.Herbystar.TTA.TTA_Methods;

public class SBAnimals implements Listener{
	private static Map<Player, Integer> timers = new HashMap <Player, Integer>();
	
	ScoreboardManager manager = Bukkit.getScoreboardManager();
	final Scoreboard board = manager.getNewScoreboard();
	static Objective objective;
	public static int timer = 0;
	@SuppressWarnings("deprecation")
	public static void newScoreboardTimer()
	{
		
		timer = Bukkit.getServer().getScheduler().scheduleAsyncRepeatingTask(MainAnimals.plugin, new Runnable() 
		{
			@Override
			public void run() 
			{
				for (Player player : Bukkit.getOnlinePlayers())
				{
					ScoreboardManager manager = Bukkit.getScoreboardManager();
					final Scoreboard board = manager.getMainScoreboard();
					try {
						objective = board.registerNewObjective("AnimalLive", "dummy");
					} catch (Exception e) {
						objective = board.getObjective("AnimalLive");
						e.printStackTrace();
					}
					
					objective.setDisplaySlot(DisplaySlot.SIDEBAR);
					objective.setDisplayName("§e§lЖизнь Животных");
					
					int bal = APIAnimals.getBal(player);
					
					Score score = objective.getScore("§aБаланс: "+"§7"+String.valueOf(bal)+"р");
					score.setScore(9);
					
					int income = APIAnimals.getIncome(player);
					
					Score score2 = objective.getScore("§aДоход: "+"§6"+String.valueOf(income)+"р/сек §bx"+APIAnimals.getLocalBoost(player) * Booostoor.agboostm * Booostoor.gboostm);
					score2.setScore(8);
					
					Score score3 = objective.getScore("§0");
					score3.setScore(7);
					
					Score score6 = objective.getScore("§aЖивотное:");
					score6.setScore(6);
					
					if(APIAnimals.getAnimal(player) == 0) {
						String type = "§8Не выбрано";
						Score score7 = objective.getScore(type);
						score7.setScore(5);
					}else if(APIAnimals.getAnimal(player) == 1) {
						String type = "§eкот";
						Score score7 = objective.getScore(type);
						score7.setScore(5);
					}else if(APIAnimals.getAnimal(player) == 2) {
						String type = "§fсобака";
						Score score7 = objective.getScore(type);
						score7.setScore(5);
					}else if(APIAnimals.getAnimal(player) == 3) {
						String type = "§6корова";
						Score score7 = objective.getScore(type);
						score7.setScore(5);
					}else if(APIAnimals.getAnimal(player) == 4) {
						String type = "§dсвинья";
						Score score7 = objective.getScore(type);
						score7.setScore(5);
					}else if(APIAnimals.getAnimal(player) == 5) {
						String type = "§fкурица";
						Score score7 = objective.getScore(type);
						score7.setScore(5);
					}else if(APIAnimals.getAnimal(player) == 7) {
						String type = "§fмедведь";
						Score score7 = objective.getScore(type);
						score7.setScore(5);
					}else if(APIAnimals.getAnimal(player) == 8) {
						String type = "§6кролик";
						Score score7 = objective.getScore(type);
						score7.setScore(5);
					}else if(APIAnimals.getAnimal(player) == 9) {
						String type = "§9попугай";
						Score score7 = objective.getScore(type);
						score7.setScore(5);
					}
					
					int level = APIAnimals.getLevel(player);
					
					Score score14 = objective.getScore("§aУровень: "+"§9"+String.valueOf(level));
					score14.setScore(4);
					
					int hearts = APIAnimals.getHearts(player);
					
					Score score8 = objective.getScore("§cСердечек§a: "+"§c"+String.valueOf(hearts)+"§l❤");
					score8.setScore(3);
					
					Score score10 = objective.getScore("§8");
					score10.setScore(2);
					
					Score score19 = objective.getScore("§aОнлайн: §a§l " + Bukkit.getOnlinePlayers().size());
					score19.setScore(1);
					
					player.setScoreboard(board);

					TTA_Methods.sendTablist(player,"\n§a§lGrendCity\n    §eСервер, который вы ждали! ;3\n\n§3Онлайн на всём сервере: §a"+Bukkit.getOnlinePlayers().size()
							+"\n","\n§3Наша группа §9ВК§3: §1https://vk.com/zhiznzhivotnyh\n§3Наш сайт: §bhttps://vk.cc/8V2iL9\n");			
				}
			}
		}, 0, 20*2);
	}
/*	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		final Player player = event.getPlayer();
		
		int timer = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(MainAnimals.plugin,new Runnable() {
			
			public void run() {
				ScoreboardManager manager = Bukkit.getScoreboardManager();
				final Scoreboard board = manager.getNewScoreboard();
				final Objective objective = board.registerNewObjective("AnimalLive", "dummy");
				
				objective.setDisplaySlot(DisplaySlot.SIDEBAR);
				objective.setDisplayName("§e§lЖизнь Животных");
				
				int bal = APIAnimals.getBal(player);
				
				Score score = objective.getScore("§aБаланс: "+"§7"+String.valueOf(bal)+"р");
				score.setScore(10);
				
				int income = APIAnimals.getIncome(player);
				
				Score score2 = objective.getScore("§aДоход: "+"§6"+String.valueOf(income)+"р/сек §bx"+APIAnimals.getLocalBoost(player) * Booostoor.agboostm * Booostoor.gboostm);
				score2.setScore(9);
				
				Score score3 = objective.getScore("§0");
				score3.setScore(8);
				
				Score score6 = objective.getScore("§aЖивотное:");
				score6.setScore(7);
				
				if(APIAnimals.getAnimal(player) == 0) {
					String type = "§8Не выбрано";
					Score score7 = objective.getScore(type);
					score7.setScore(6);
				}else if(APIAnimals.getAnimal(player) == 1) {
					String type = "§eкот";
					Score score7 = objective.getScore(type);
					score7.setScore(6);
				}else if(APIAnimals.getAnimal(player) == 2) {
					String type = "§fсобака";
					Score score7 = objective.getScore(type);
					score7.setScore(6);
				}else if(APIAnimals.getAnimal(player) == 3) {
					String type = "§6корова";
					Score score7 = objective.getScore(type);
					score7.setScore(6);
				}else if(APIAnimals.getAnimal(player) == 4) {
					String type = "§dсвинья";
					Score score7 = objective.getScore(type);
					score7.setScore(6);
				}else if(APIAnimals.getAnimal(player) == 5) {
					String type = "§fкурица";
					Score score7 = objective.getScore(type);
					score7.setScore(6);
				}else if(APIAnimals.getAnimal(player) == 7) {
					String type = "§fмедведь";
					Score score7 = objective.getScore(type);
					score7.setScore(6);
				}else if(APIAnimals.getAnimal(player) == 8) {
					String type = "§6кролик";
					Score score7 = objective.getScore(type);
					score7.setScore(6);
				}else if(APIAnimals.getAnimal(player) == 9) {
					String type = "§9попугай";
					Score score7 = objective.getScore(type);
					score7.setScore(6);
				}
				
				int level = APIAnimals.getLevel(player);
				
				Score score14 = objective.getScore("§aУровень: "+"§9"+String.valueOf(level));
				score14.setScore(5);
				
				Score score9 = objective.getScore("§1");
				score9.setScore(4);
				
				int hearts = APIAnimals.getHearts(player);
				
				Score score8 = objective.getScore("§cСердечек§a: "+"§c"+String.valueOf(hearts)+"§l❤");
				score8.setScore(3);
				
				Score score13 = objective.getScore("§5");
				score13.setScore(2);
				
				Score score19 = objective.getScore("§aОнлайн: §a§l " + Bukkit.getOnlinePlayers().size());
				score19.setScore(1);
				
				player.setScoreboard(board);

				TTA_Methods.sendTablist(player,"\n§a§lGrendCity\n    §eСервер, который вы ждали! ;3\n\n§3Онлайн на всём сервере: §a"+Bukkit.getOnlinePlayers().size()
						+"\n","\n§3Наша группа §9ВК§3: §1https://vk.com/zhiznzhivotnyh\n§3Наш сайт: §bhttps://vk.cc/8V2iL9\n");			

			}
		},0,20*2);
		timers.put(player, timer);
	}
	@EventHandler
	public void onQuit(PlayerQuitEvent e)
	{
		Bukkit.getServer().getScheduler().cancelTask(timers.get(e.getPlayer()));
		timers.remove(e.getPlayer());
	}*/
	
}
