package ru.ibusewinner.animals.boosters;


import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
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
					for (Player p : Bukkit.getOnlinePlayers())
					{
						for (int i = 0; i < Bukkit.getOnlinePlayers().size(); i++)
						{
							try {
							TTA_Methods.removeBossBar(p);
							} catch (Exception e) 
							{
								MainAnimals.plugin.getLogger().warning("Boost Exception <:D");
							}
						}
						TTA_Methods.createBossBar(p,"§aГлобальный бустер §9x"+boost+" §6("+boostTimer+" минут)",1.0,BarStyle.SOLID,BarColor.YELLOW,BarFlag.CREATE_FOG,true);
					}
					TTA_Methods.setBarTitle("§aГлобальный бустер §9x"+boost+" §6("+boostTimer+" минут)");
					
//					TTA_Methods.setBarTitle("§aГлобальный бустер §9x"+boost+" §6("+boostTimer+"минут)");
					if (boostTimer <= 0)
					{
						remove();
					}
					timer++;
					if (timer % 60 == 0)
					{
						boostTimer--;
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
		boost = mnoz;
		boostTimer = time;
		boosted = true;
		timer = 0;
	}

	public static boolean isSet() 
	{
		return boosted;
	}

	public static void remove() 
	{
		timer = 0;
		boost = 1;
		boostTimer = 0;
		boosted = false;
		for (Player p : Bukkit.getOnlinePlayers())
			try{
				TTA_Methods.removeBossBar(p);
			}catch (Exception e) {}
	}
	
}
