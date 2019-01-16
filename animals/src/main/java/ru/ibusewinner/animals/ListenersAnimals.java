package ru.ibusewinner.animals;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.bukkit.scoreboard.Team.Option;
import org.bukkit.scoreboard.Team.OptionStatus;

import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.AnimalColor;
import me.libraryaddict.disguise.disguisetypes.DisguiseType;
import me.libraryaddict.disguise.disguisetypes.FlagWatcher;
import me.libraryaddict.disguise.disguisetypes.MobDisguise;
import me.libraryaddict.disguise.disguisetypes.watchers.OcelotWatcher;
import me.libraryaddict.disguise.disguisetypes.watchers.SheepWatcher;
import ru.ibusewinner.animals.boosters.GlobalBoost;
import ru.ibusewinner.animals.boosters.LocalBoost;
public class ListenersAnimals implements Listener{

	public static Scoreboard noPushScoreboard;
	public static Team noPushTeam;
	
	public ListenersAnimals() 
	{
		noPush();
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		event.setJoinMessage("");
		if(!APIAnimals.isRegistered(player)) {
			APIAnimals.register(player);
			player.sendMessage(MainAnimals.prefix+"§aВы играете впервые на данном режиме, поэтому Вы будете зарегистрированы в нашей базе данных!");
			Bukkit.broadcastMessage(MainAnimals.prefix+"§bИгрок "+player.getName()+" §bвпервые зашёл на данный режим! Поприветствуем его!");
		}
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"nte reload");
		
		MobDisguise cat = new MobDisguise(DisguiseType.OCELOT, false);
		OcelotWatcher catw = (OcelotWatcher) cat.getWatcher();
		catw.setType(Ocelot.Type.BLACK_CAT);
		catw.setCustomName(player.getName());
		catw.setCustomNameVisible(true);
		MobDisguise dog = new MobDisguise(DisguiseType.WOLF, false);
		FlagWatcher dogw = dog.getWatcher();
		dogw.setCustomName(player.getName());
		dogw.setCustomNameVisible(true);
		MobDisguise cow = new MobDisguise(DisguiseType.COW, false);
		FlagWatcher coww = cow.getWatcher();
		coww.setCustomName(player.getName());
		coww.setCustomNameVisible(true);
		MobDisguise pig = new MobDisguise(DisguiseType.PIG, false);
		FlagWatcher pigw = pig.getWatcher();
		pigw.setCustomName(player.getName());
		pigw.setCustomNameVisible(true);
		MobDisguise chicken = new MobDisguise(DisguiseType.CHICKEN, false);
		FlagWatcher chickenw = chicken.getWatcher();
		chickenw.setCustomName(player.getName());
		chickenw.setCustomNameVisible(true);
		MobDisguise sheep = new MobDisguise(DisguiseType.SHEEP, false);
		SheepWatcher sheepw = (SheepWatcher) sheep.getWatcher();
		sheepw.setColor(AnimalColor.LIME);
		sheepw.setCustomName(player.getName());
		sheepw.setCustomNameVisible(true);
		MobDisguise bear = new MobDisguise(DisguiseType.POLAR_BEAR, false);
		FlagWatcher bearw = bear.getWatcher();
		bearw.setCustomName(player.getName());
		bearw.setCustomNameVisible(true);
		MobDisguise rabbid = new MobDisguise(DisguiseType.RABBIT, false);
		FlagWatcher rabbidw = rabbid.getWatcher();
		rabbidw.setCustomName(player.getName());
		rabbidw.setCustomNameVisible(true);
		MobDisguise parrot = new MobDisguise(DisguiseType.PARROT, false);
		FlagWatcher parrotw = parrot.getWatcher();
		parrotw.setCustomName(player.getName());
		parrotw.setCustomNameVisible(true);
		if(APIAnimals.getAnimal(player) == 0) {
			player.teleport(new Location(Bukkit.getWorld("world"), -24.5, 102.5, 473.5));
			DisguiseAPI.undisguiseToAll(player);
		}else if(APIAnimals.getAnimal(player) == 1) {
			player.teleport(new Location(Bukkit.getWorld("world"), -24.5, 102.5, 473.5));
			DisguiseAPI.disguiseToAll(player,cat);
		}else if(APIAnimals.getAnimal(player) == 2) {
			player.teleport(new Location(Bukkit.getWorld("world"), -24.5, 102.5, 473.5));
			DisguiseAPI.disguiseToAll(player,dog);
		}else if(APIAnimals.getAnimal(player) == 3) {
			player.teleport(new Location(Bukkit.getWorld("world"), -24.5, 102.5, 473.5));
			DisguiseAPI.disguiseToAll(player,cow);
		}else if(APIAnimals.getAnimal(player) == 4) {
			player.teleport(new Location(Bukkit.getWorld("world"), -24.5, 102.5, 473.5));
			DisguiseAPI.disguiseToAll(player,pig);
		}else if(APIAnimals.getAnimal(player) == 5) {
			player.teleport(new Location(Bukkit.getWorld("world"), -24.5, 102.5, 473.5));
			DisguiseAPI.disguiseToAll(player,chicken);
		}else if(APIAnimals.getAnimal(player) == 6) {
			player.teleport(new Location(Bukkit.getWorld("world"), -24.5, 102.5, 473.5));
			DisguiseAPI.disguiseToAll(player,sheep);
		}else if(APIAnimals.getAnimal(player) == 7) {
			player.teleport(new Location(Bukkit.getWorld("world"), -24.5, 102.5, 473.5));
			DisguiseAPI.disguiseToAll(player,bear);
		}else if(APIAnimals.getAnimal(player) == 8) {
			player.teleport(new Location(Bukkit.getWorld("world"), -24.5, 102.5, 473.5));
			DisguiseAPI.disguiseToAll(player,rabbid);
		}else if(APIAnimals.getAnimal(player) == 9) {
			player.teleport(new Location(Bukkit.getWorld("world"), -24.5, 102.5, 473.5));
			DisguiseAPI.disguiseToAll(player,parrot);
		}
		DisguiseAPI.setViewDisguiseToggled(player,false);
		try {
			
		}catch(Exception ex) {
			Bukkit.getConsoleSender().sendMessage(MainAnimals.prefix+"§9meow §d;3");
		}
		
		
			Bukkit.getServer().getScheduler().scheduleAsyncRepeatingTask(MainAnimals.plugin,new Runnable() {
				
				@Override
				public void run() {
					if(APIAnimals.getAnimal(player) == 0) {
						player.sendMessage(MainAnimals.prefix+"§cСначала авторизуйтесь, потом выберите животного через /choose");
						player.sendMessage(MainAnimals.prefix+"§cЕсли Вы здесь впервые, то введите /reg <пароль> <повтор пароля>");
						player.sendMessage(MainAnimals.prefix+"§cЕсли Вы здесь уже играли, то введите /l <пароль>");
					}
				}
			},0,20*30);
		
		Bukkit.getServer().getScheduler().scheduleAsyncRepeatingTask(MainAnimals.plugin,new Runnable() {
			public void run() {
				for(Player pl : Bukkit.getOnlinePlayers()) {
					APIAnimals.addBalBoost(pl);
					
					if(APIAnimals.getHum1(player) == 1) {
						APIAnimals.addHearts(player,1);
					}
					if(APIAnimals.getHum2(player) == 1) {
						APIAnimals.addHearts(player,1);
					}
					if(APIAnimals.getHum3(player) == 1) {
						APIAnimals.addHearts(player,1);
					}
					if(APIAnimals.getHum4(player) == 1) {
						APIAnimals.addHearts(player,1);
					}
					if(APIAnimals.getHum5(player) == 1) {
						APIAnimals.addHearts(player,1);
					}
					if(APIAnimals.getHum6(player) == 1) {
						APIAnimals.addHearts(player,1);
					}
					if(APIAnimals.getHum7(player) == 1) {
						APIAnimals.addHearts(player,1);
					}
					if(APIAnimals.getHum8(player) == 1) {
						APIAnimals.addHearts(player,1);
					}
					if(APIAnimals.getHum9(player) == 1) {
						APIAnimals.addHearts(player,1);
					}
				}
			}
		},0,20*2);

		LocalBoost lb = new LocalBoost(player);
		
		noPushTeam.addPlayer(player);
		player.setScoreboard(noPushScoreboard);
		DisguiseAPI.setViewDisguiseToggled(player, false);
		
		GlobalBoost.addBar(player);
	}

	public static void noPush()
	{
		noPushScoreboard=  Bukkit.getScoreboardManager().getMainScoreboard();
		try{
			noPushTeam = noPushScoreboard.registerNewTeam("NoPush");
		}catch(Exception e)
		{
			noPushTeam = noPushScoreboard.getTeam("NoPush");
		}
		noPushTeam.setOption(Option.COLLISION_RULE, OptionStatus.NEVER);
	}
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e)
	{
		if (MainAnimals.boosters.containsKey(e.getPlayer()))
		{
			MainAnimals.boosters.get(e.getPlayer()).sendDb();
			MainAnimals.boosters.remove(e.getPlayer());
		}
	}
	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		final Player player = event.getPlayer();
		if(APIAnimals.getAnimal(player) == 0) {
			player.sendMessage(MainAnimals.prefix+"§cПропишите §9/choose §cи выберите своего животного!");
			event.setCancelled(true);
		}
		
		if(player.getLocation().getY() <= 86) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,10,100,false,false,Color.BLACK));
			player.teleport(new Location(Bukkit.getWorld("world"), -24.5, 102.5, 473.5));
			player.setHealth(20.0);
			player.sendMessage(MainAnimals.prefix+"§aНе падай, хе-хе))");
		}
	}
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		if(APIAnimals.getAnimal(player) == 0) {
			event.setCancelled(true);
			player.sendMessage(MainAnimals.prefix+"§cПропишите §9/choose §cи выберите своего животного!");
		}
	}
	
	@EventHandler
	public void hit(EntityDamageByEntityEvent e) {
		Player p = (Player)e.getDamager();
		try {
			if(e.getEntityType() == EntityType.SHEEP) {
				if(e.getDamager() instanceof Player) {
					if(APIAnimals.isShelter(p) == false) {
						e.setCancelled(true);
						APIAnimals.setShelter(p,true);
						p.sendMessage(MainAnimals.prefix+"§bВы подобрали овечку. Отнесите её в приют и получите награду!");
					}else {
						p.sendMessage(MainAnimals.prefix+"§cВы уже подобрали одну овечку! Отнесите сначала её, потом приходите за другой!");
					}
				}else {
					e.setCancelled(true);
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		e.setQuitMessage("");
	}
}
