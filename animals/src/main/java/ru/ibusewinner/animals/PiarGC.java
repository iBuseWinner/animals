package ru.ibusewinner.animals;

import org.bukkit.Bukkit;

public class PiarGC {
	private int timer = 0;
	
	private String VK = "§7[§c!§7]§3 Наша группа §9ВК§3: §1https://vk.com/zhiznzhivotnyh";
	private String site = "§7[§c!§7]§3 Наш сайт: §dhttps://vk.cc/8V2iL9";
	//private String forum = "§7[§c!§7]§3 Наш форум: §awww.forum.скоро.net";
	private String discord = "§7[§c!§7]§3 Наш дискорд: §9https://discord.gg/DDTDFgD";
	private String donate = "§7[§c!§7]§3 Поддержать наш проект можно по ссылке: §bhttps://vk.cc/8V2iL9";
	private String donate_cmd = "§7[§c!§7]§3 Включить бустер можно через: §e/donate";
	
	@SuppressWarnings("deprecation")
	public void time() {
		timer = Bukkit.getScheduler().scheduleAsyncRepeatingTask(MainAnimals.plugin,new Runnable() {
			
			@Override
			public void run() {
				if(timer == 1) {
					Bukkit.broadcastMessage(VK);
					timer++;
				}else if(timer == 2) {
					Bukkit.broadcastMessage(site);
					timer++;
				}else if(timer == 3) {
					//Bukkit.broadcastMessage(forum);
					//timer++;
				//}else if(timer == 4) {
					Bukkit.broadcastMessage(discord);
					timer++;
				}else if(timer == 4) {
					Bukkit.broadcastMessage(donate);
					timer++;
				}else if(timer == 5) {
					Bukkit.broadcastMessage(donate_cmd);
					timer++;
				}else {
					timer++;
				}
				timer++;
			}
		},0,20*60);
	}

}
