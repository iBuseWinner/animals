package ru.ibusewinner.animals;

import org.bukkit.Bukkit;

public class PiarGC {
	private int timer = 0;
	
	private String VK = "§7[§c!§7]§3 Наша группа §9ВК§3: §1https://vk.com/zhiznzhivotnyh";
	private String site = "§7[§c!§7]§3 Наш сайт: §dww.скоро.net";
	private String forum = "§7[§c!§7]§3 Наш форум: §awww.forum.скоро.net";
	private String discord = "§7[§c!§7]§3 Наш дискорд: §9https://discord.gg/DDTDFgD";
	private String donate = "§7[§c!§7]§3 Поддержать наш проект можно по ссылке: §bwww.скоро.net/cabinet";
	
	@SuppressWarnings("deprecation")
	public void time() {
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(MainAnimals.plugin,new Runnable() {
			
			@Override
			public void run() {
				if(timer == 5) {
					Bukkit.broadcastMessage(VK);
					timer++;
				}else if(timer == 10) {
					Bukkit.broadcastMessage(site);
					timer++;
				}else if(timer == 15) {
					Bukkit.broadcastMessage(forum);
					timer++;
				}else if(timer == 20) {
					Bukkit.broadcastMessage(discord);
					timer++;
				}else if(timer == 25) {
					Bukkit.broadcastMessage(donate);
					timer++;
				}else {
					timer++;
				}
			}
		},0,20*60);
	}

}
