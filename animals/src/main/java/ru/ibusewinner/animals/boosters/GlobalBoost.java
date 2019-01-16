package ru.ibusewinner.animals.boosters;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import de.Herbystar.TTA.TTA_Methods;
import ru.ibusewinner.animals.MainAnimals;

public class GlobalBoost {
	
	//Длительность бустеров в минутах (Админский, обычный)
	public static int agboost = 0;
	public static int gboost = 0;
	//Множитель бустеров (Админский, обычный)
	
	public static int agboostm = 1;
	public static int gboostm = 1;
	private static int timer = 0;
	
	public static String booster = " ";
	public int taskId = 0;
	
	public GlobalBoost() 
	{
		
	}
	
	@SuppressWarnings("deprecation")
	public void timer() 
	{
		taskId = Bukkit.getServer().getScheduler().scheduleAsyncRepeatingTask(MainAnimals.plugin,new Runnable() 
		{
			
			@Override
			public void run() 
			{
				
				if(agboost <= 0)
				{
					for(Player pl : Bukkit.getOnlinePlayers()) 
					{
						TTA_Methods.removeBossBar(pl);
						Bukkit.getScheduler().cancelTask(taskId);
						agboostm = 1;
					}
				}
				else 
				{
					TTA_Methods.setBarTitle("§aГлобальный бустер §9x"+agboostm+" §aот игрока §5"+booster+" §6("+agboost+"минут)");
					if (timer % 60 == 0)
						agboost--;
				}
				
				if(gboost <= 0) 
				{
					for(Player pl : Bukkit.getOnlinePlayers()) 
					{
						TTA_Methods.removeBossBar(pl);
						Bukkit.getScheduler().cancelTask(taskId);
						gboostm = 1;
					}
				}
				else
				{
					gboost--;
					TTA_Methods.setBarTitle("§aГлобальный бустер §9x"+agboostm+" §aот игрока §5"+booster+" §6("+agboost+"минут)");
				}
				timer++;
			} 
		},0,20);
	}
	
}
