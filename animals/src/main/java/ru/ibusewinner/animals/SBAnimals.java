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
	final Objective objective = board.registerNewObjective("AnimalLive", "dummy");
	
	@EventHandler
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
				score.setScore(15);
				
				int income = APIAnimals.getIncome(player);
				
				Score score2 = objective.getScore("§aДоход: "+"§6"+String.valueOf(income)+"р/сек §bx"+APIAnimals.getLocalBoost(player) * Booostoor.agboostm * Booostoor.gboostm);
				score2.setScore(14);
				
				Score score3 = objective.getScore("§0");
				score3.setScore(13);
				
				int respawns = APIAnimals.getRespawns(player);
				
				Score score4 = objective.getScore("§aПерерождений: "+"§1"+String.valueOf(respawns));
				score4.setScore(12);
				
				Score score6 = objective.getScore("§aЖивотное:");
				score6.setScore(11);
				
				if(APIAnimals.getAnimal(player) == 0) {
					String type = "§8Не выбрано";
					Score score7 = objective.getScore(type);
					score7.setScore(10);
				}else if(APIAnimals.getAnimal(player) == 1) {
					String type = "§eкот";
					Score score7 = objective.getScore(type);
					score7.setScore(10);
				}else if(APIAnimals.getAnimal(player) == 2) {
					String type = "§fсобака";
					Score score7 = objective.getScore(type);
					score7.setScore(10);
				}else if(APIAnimals.getAnimal(player) == 3) {
					String type = "§6корова";
					Score score7 = objective.getScore(type);
					score7.setScore(10);
				}else if(APIAnimals.getAnimal(player) == 4) {
					String type = "§dсвинья";
					Score score7 = objective.getScore(type);
					score7.setScore(10);
				}else if(APIAnimals.getAnimal(player) == 5) {
					String type = "§fкурица";
					Score score7 = objective.getScore(type);
					score7.setScore(10);
				}else if(APIAnimals.getAnimal(player) == 7) {
					String type = "§fмедведь";
					Score score7 = objective.getScore(type);
					score7.setScore(10);
				}else if(APIAnimals.getAnimal(player) == 8) {
					String type = "§6кролик";
					Score score7 = objective.getScore(type);
					score7.setScore(10);
				}else if(APIAnimals.getAnimal(player) == 9) {
					String type = "§9попугай";
					Score score7 = objective.getScore(type);
					score7.setScore(10);
				}
				
				int level = APIAnimals.getLevel(player);
				
				Score score14 = objective.getScore("§aУровень: "+"§9"+String.valueOf(level));
				score14.setScore(9);
				
				Score score9 = objective.getScore("§1");
				score9.setScore(8);
				
				int hearts = APIAnimals.getHearts(player);
				
				Score score8 = objective.getScore("§cСердечек§a: "+"§c"+String.valueOf(hearts)+"§l❤");
				score8.setScore(7);
				
				int humans = APIAnimals.getHumans(player);
				
				Score score10 = objective.getScore("§aХозяев: "+"§2"+String.valueOf(humans));
				score10.setScore(6);
				
				int bizs = APIAnimals.getBizs(player);
				
				Score score12 = objective.getScore("§aБизнесов: "+"§e"+String.valueOf(bizs));
				score12.setScore(5);
				
				Score score13 = objective.getScore("§5");
				score13.setScore(4);
				
				int boost = APIAnimals.getLocalBoost(player);
				
				int m = 0;
				int h = 0;
				Score score15 = objective.getScore("§aБустер: §3x"+String.valueOf(boost));
				if (MainAnimals.boosters.containsKey(player))
				{
					int currentTime = MainAnimals.boosters.get(player).currentTime;
					int boostTimer = MainAnimals.boosters.get(player).boostTimer;
					int difference = boostTimer - currentTime;
					m = difference / 60 + 1;
					
					h = m / 60;
					m = m - h*60;
					score15 = objective.getScore("§aБустер: §3x"+String.valueOf(boost) + " §7на §3" + h + ":" + m);
				}
				score15.setScore(3);
				
				Score score16 = objective.getScore("§3");
				score16.setScore(2);
				
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
	}
	
}
