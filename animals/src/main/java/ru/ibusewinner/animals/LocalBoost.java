package ru.ibusewinner.animals;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class LocalBoost 
{
	public static List<LocalBoost> boosters;
	private Player player;
	public int boostTimer = 0;
	public int currentTime = 0;
	public int booster = 1;
	public boolean stopTimer = false;
	public int timer;
	
	public LocalBoost(Player player) 
	{
		this.player = player;
		init();

		if ((boostTimer <= currentTime && (boostTimer > 0 && currentTime > 0)) || (boostTimer == 0 || currentTime == 0))
		{
			delete();
		}
		else start();
	}
	private void init()
	{
		boostTimer = APIAnimals.getBoostTime(player);
		currentTime = APIAnimals.getBoostTime(player);
		booster = APIAnimals.getLocalBoost(player);
	}
	public void delete()
	{
		boostTimer = 0;
		currentTime = 0;
		booster = 1;
		sendDb();
		
	}
	public void sendDb()
	{
		APIAnimals.setBoostTime(player, boostTimer);
		APIAnimals.setCurrentTime(player, currentTime);
		APIAnimals.setLocalBoost(player, booster);
	}
	public void start()
	{
		timer = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(MainAnimals.plugin, new Runnable() {
			
			@Override
			public void run() 
			{
				currentTime++;
				if (currentTime >= boostTimer)
				{
					delete();
					stopTimer = true;
				}
				if (currentTime == 0 && boostTimer == 0 || (currentTime == 0 || boostTimer == 0))
					stopTimer = true;
				if (stopTimer)
					Bukkit.getServer().getScheduler().cancelTask(timer);
			}
		}, 0, 20);
	}
	
}