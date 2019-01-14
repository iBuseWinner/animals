package ru.ibusewinner.animals;

import java.util.List;

import org.bukkit.Bukkit;

public class PiarGC {
	private int time = 0;
	
	private static List<String> messages;
	private int msgI = 0;
	public static int timer;
	public PiarGC() 
	{
		messages.add("§7[§c!§7]§3 Наша группа §9ВК§3: §1https://vk.com/zhiznzhivotnyh");
		messages.add("§7[§c!§7]§3 Наш сайт: §dww.скоро.net");
		messages.add("§7[§c!§7]§3 Наш форум: §awww.forum.скоро.net");
		messages.add("§7[§c!§7]§3 Наш дискорд: §9https://discord.gg/DDTDFgD");
		messages.add("§7[§c!§7]§3 Поддержать наш проект можно по ссылке: §bwww.скоро.net/cabinet");
		messages.add("§7[§c!§7]§3 Купить бусты - §b/donate");
		
		time();
	}
	
	@SuppressWarnings("deprecation")
	public void time() {
		timer = Bukkit.getScheduler().scheduleAsyncRepeatingTask(MainAnimals.plugin,new Runnable() {
			
			@Override
			public void run() {
				if (time % 5 == 0)
				{
					if (msgI >= messages.size()-1)
						msgI=0;
					
					Bukkit.broadcastMessage(messages.get(msgI));
					
					
					msgI++;
				}
				time++;
			}
		},0,20*60);
	}

}
