package ru.ibusewinner.animals.boosters;


import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import de.Herbystar.TTA.TTA_Methods;
import ru.ibusewinner.animals.MainAnimals;

public class GlobalBoost {

	public static int boostTimer = 0; 	// Длительность бустера в минутах
	public static int boost = 1;		// Множитель бустера
	
	public static int taskId = -1;		// ID таймера 
	private static boolean boosted = false; 
	private static int timer = 0;
	public GlobalBoost() 
	{
		if (taskId == -1)
			timer();
	}
	private static boolean bossBared;
	@SuppressWarnings("deprecation")
	public void timer() 
	{
		taskId = Bukkit.getServer().getScheduler().scheduleAsyncRepeatingTask(MainAnimals.plugin,new Runnable() 
		{

			@Override
			public void run() 
			{
				if (boosted)
				{
					TTA_Methods.setBarTitle("§aГлобальный бустер §9x"+boost+" §6("+boostTimer+" минут)");
					
					timer++;
					if (timer % 60 == 0)
					{
						boostTimer--;
					}
					if (boostTimer <= 0)
					{
						remove();
					}
				}
				else timer = 0;
			/*	
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
				timer++;*/
			} 
		},0,20);
	}

	public static void set(int mnoz, int time) 
	{
		remove();
		boost = mnoz;
		boostTimer = time;
		boosted = true;
		timer = 0;
		bossBared = true;
		
		for (Player p : Bukkit.getOnlinePlayers()) addBar(p);
	}
	
	public static void addBar(Player p)
	{
		if (isSet())
			TTA_Methods.createBossBar(p,"§aГлобальный бустер §9x"+boost+" §6("+boostTimer+" минут)",1.0,BarStyle.SOLID,BarColor.YELLOW,BarFlag.CREATE_FOG,true);
	}
	
	public static void removeBar(Player p)
	{
		try{
			TTA_Methods.removeBossBar(p);
		}catch (Exception e) {}
	}
	
	public static void remove() 
	{
		for (Player p : Bukkit.getOnlinePlayers()) removeBar(p);
		timer = 0;
		boost = 1;
		boostTimer = 0;
		boosted = false;
	}

	public static boolean isSet() 
	{
		return boosted;
	}
}
