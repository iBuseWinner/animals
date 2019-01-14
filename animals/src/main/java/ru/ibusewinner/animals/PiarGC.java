package ru.ibusewinner.animals;

import org.bukkit.Bukkit;

public class PiarGC {
	private int time = 0;
	
	private static ArrayList<String> messages;
	public static int timer = 0;
	private String VK = "§7[§c!§7]§3 Наша группа §9ВК§3: §1https://vk.com/zhiznzhivotnyh";
	private String site = "§7[§c!§7]§3 Наш сайт: §dhttps://vk.cc/8V2iL9";
	//private String forum = "§7[§c!§7]§3 Наш форум: §awww.forum.скоро.net";
	private String discord = "§7[§c!§7]§3 Наш дискорд: §9https://discord.gg/DDTDFgD";
	private String donate = "§7[§c!§7]§3 Поддержать наш проект можно по ссылке: §bhttps://vk.cc/8V2iL9";
	private String donate_cmd = "§7[§c!§7]§3 Включить бустер можно через: §e/donate";
	
	private int msgI = 0;
	
	public PiarGC() 
	{
		messages = new ArrayList<String>();
		messages.add("§7[§c!§7]§3 Наша группа §9ВК§3: §1https://vk.com/zhiznzhivotnyh");
		messages.add("§7[§c!§7]§3 Наш сайт: §dhttps://vk.cc/8V2iL9");
		//messages.add("§7[§c!§7]§3 Наш форум: §awww.forum.скоро.net)";
		messages.add("§7[§c!§7]§3 Наш дискорд: §9https://discord.gg/DDTDFgD");
		messages.add("§7[§c!§7]§3 Поддержать наш проект можно по ссылке: §bhttps://vk.cc/8V2iL9");
		messages.add("§7[§c!§7]§3 Включить бустер можно через: §e/donate");
	}
	
	@SuppressWarnings("deprecation")
	public void time() {
		timer = Bukkit.getScheduler().scheduleAsyncRepeatingTask(MainAnimals.plugin,new Runnable() {
			
			@Override
			public void run() {
				if (msgI >= messages.size()-1)
					msgI = 0;
				
				
				if (time % 1 == 0) // Каждую одну минуту будет посылать сообщение 
					Bukkit.broadcastMessage(messages.get(msgI));

//				if (time % 2 == 0) // Каждые две минуты будет посылать сообщение 
//					Bukkit.broadcastMessage(messages.get(msgI));
				
				
//				if (time % 5 == 0) // Каждые пять минут будет посылать сообщение 
//				Bukkit.broadcastMessage(messages.get(msgI));
//				...
//				etc
				
				msgI++;
				time++;
			}
		},0,20*60);
	}

}
