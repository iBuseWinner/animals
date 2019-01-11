package ru.ibusewinner.animals;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import de.Herbystar.TTA.TTA_Methods;

public class Booostoor {
	
	//Длительность бустеров в минутах (Админский, обычный)
	public static int agboost = 0;
	public static int gboost = 0;
	//Множитель бустеров (Админский, обычный)
	
	public static int agboostm = 1;
	public static int gboostm = 1;
	
	public static String booster = " ";
	private int taskId = 0;
	@SuppressWarnings("deprecation")
	public void timer() {
		
		taskId = Bukkit.getServer().getScheduler().scheduleAsyncRepeatingTask(MainAnimals.plugin,new Runnable() {
			
			@Override
			public void run() {
				
				if(agboost <= 0){
					for(Player pl : Bukkit.getOnlinePlayers()) {
						TTA_Methods.removeBossBar(pl);
						Bukkit.getScheduler().cancelTask(taskId);
					}
				}else {
					agboost--;
					TTA_Methods.setBarTitle("§aГлобальный бустер §9x"+agboostm+" §aот админа §5"+booster+" §6("+agboost+"минут)");
				}
				
				if(gboost <= 0) {
					for(Player pl : Bukkit.getOnlinePlayers()) {
						TTA_Methods.removeBossBar(pl);
						Bukkit.getScheduler().cancelTask(taskId);
					}
				}else {
					gboost--;
					TTA_Methods.setBarTitle("§aГлобальный бустер §9x"+agboostm+" §aот игрока §5"+booster+" §6("+agboost+"минут)");
				}
			} 
		},0,20*60);
	}
	
}
