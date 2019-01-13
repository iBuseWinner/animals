package ru.ibusewinner.animals;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class LocalBoost 
{
	private Player player;
	public int boostTimer = 0;
	public int currentTime = 0;
	public int booster = 1;
	public boolean boosted = false;
	public int timer = 0;
	
	/*
	 * Использование
	 * 
	 * 	Для добавления нового/продления старого бустера" 
			MainAnimals.boosters.remove(p);
			LocalBoost lb = new LocalBoost(p, 2, 30);
			
		Для установки бустера игроку из бд (Для продолжения таймера после перезахода):
			LocalBoost lb = new LocalBoost(player);
	 */
	
	public LocalBoost(Player player)
	{
		this.player = player;
		init();
		MainAnimals.boosters.put(player, this);
		if (MainAnimals.boosters.get(this.player).isBoosted())
		{
			MainAnimals.boosters.get(this.player).start();
		}
		else
		{
			if (MainAnimals.boosters.get(this.player).timer != 0) MainAnimals.boosters.get(this.player).stop();
			MainAnimals.boosters.get(this.player).delete();
		}
	}
	

	public LocalBoost(Player player, int booster, int boostTimer)
	{
		this.player = player;
		for (LocalBoost lb: MainAnimals.boosters.values())
		{
			lb.sendDb();
		}
		init();
		
		if (!isBoosted()) currentTime = 0;
		set(booster, boostTimer);
		if (!MainAnimals.boosters.containsKey(player))
			MainAnimals.boosters.put(player, this);
		MainAnimals.boosters.get(this.player).start();
	}
	private void init()
	{
		boostTimer = APIAnimals.getBoostTime(player);
		currentTime = APIAnimals.getCurrentTime(player);
		booster = APIAnimals.getLocalBoost(player);
		boosted = isBoosted();
	}
	public void delete()
	{
		boostTimer = 0;
		currentTime = 0;
		booster = 1;
		boosted = false;		
		stop();
		sendDb();
		MainAnimals.boosters.remove(player);
		
	}
	public void set(int booster, int timer) // Время в минутах. В бд оно в секунды переводится
	{
		this.boostTimer = this.boostTimer+timer*60; // Здесь как раз перевод времени в секунды 
		this.booster = booster;
		sendDb();
	}
	public void sendDb()
	{
		APIAnimals.setBoostTime(player, boostTimer);
		APIAnimals.setCurrentTime(player, currentTime);
		APIAnimals.setLocalBoost(player, booster);
	}
	@SuppressWarnings("deprecation")
	public void start()
	{
		boosted = true;
		timer = Bukkit.getServer().getScheduler().scheduleAsyncRepeatingTask(MainAnimals.plugin, new Runnable()
		{
			
			@Override
			public void run() 
			{
				currentTime++;
				if (currentTime >= boostTimer)
				{
					delete();
					boosted = false;
				}
				else if (currentTime == 0 && boostTimer == 0 || (currentTime == 0 || boostTimer == 0))
					boosted = false;
				
				if (!boosted)
				{
					delete();
				}
			}
		}, 0, 20);
	}
	
	public boolean isBoosted() 
	{
		return booster > 1 && currentTime < boostTimer;
	}
	public void stop()
	{
		Bukkit.getServer().getScheduler().cancelTask(timer);
	}
	
}