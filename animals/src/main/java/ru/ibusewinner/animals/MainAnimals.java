package ru.ibusewinner.animals;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import de.Herbystar.TTA.TTA_Methods;
import ru.ibusewinner.animals.cmd.CmdBoostAdmAnimals;
import ru.ibusewinner.animals.cmd.CmdBredAnimals;
import ru.ibusewinner.animals.cmd.CmdChooseAnimals;
import ru.ibusewinner.animals.cmd.CmdDonateAnimals;
import ru.ibusewinner.animals.cmd.CmdGiveAnimals;
import ru.ibusewinner.animals.cmd.CmdGiveGcAnimals;
import ru.ibusewinner.animals.cmd.CmdInfoAnimals;
import ru.ibusewinner.animals.cmd.CmdLevelUp;
import ru.ibusewinner.animals.cmd.CmdRespawnAnimals;
import ru.ibusewinner.animals.cmd.CmdShowAnimals;
import ru.ibusewinner.animals.cmd.CmdShowLBAnimals;
import ru.ibusewinner.animals.cmd.CmdsAnimals;

public class MainAnimals extends JavaPlugin{
	
	public static String prefix = "§e§lЖизнь Животных§8 >>§7 ";
	static Plugin plugin;
	public static Map<Player, LocalBoost> boosters = new HashMap<Player, LocalBoost>();
	
	@Override
	public void onEnable() {
		plugin = this;
		MySQLAnimals.connect();
		APIAnimals.createTable();
		regCmdList();
	}
	@Override
	public void onDisable() {
		for (LocalBoost lb : MainAnimals.boosters.values()) {
			lb.sendDb();
			lb.delete();
		}
		MySQLAnimals.disconnect();
		try {
			for(Player pl : Bukkit.getOnlinePlayers()) {
				if(TTA_Methods.hasBossBar(pl) == true) {
					TTA_Methods.removeBossBar(pl);
				}
			}
		}catch(Exception ex) {
			Bukkit.getConsoleSender().sendMessage(MainAnimals.prefix+"§cНикаких бустеров нет!");
		}
	}
	
	public void regCmdList() {
		Bukkit.getPluginManager().registerEvents(new ListenersAnimals(),this);
		Bukkit.getPluginManager().registerEvents(new SBAnimals(),this);
		Bukkit.getPluginManager().registerEvents(new CmdDonateAnimals(),this);
		Bukkit.getPluginManager().registerEvents(new disableEverythink(),this);
		Bukkit.getPluginCommand("choose").setExecutor(new CmdChooseAnimals());
		Bukkit.getPluginCommand("alboost").setExecutor(new CmdBoostAdmAnimals());
		Bukkit.getPluginCommand("info").setExecutor(new CmdInfoAnimals());
		Bukkit.getPluginCommand("buy").setExecutor(new CmdsAnimals());
		Bukkit.getPluginCommand("show").setExecutor(new CmdShowAnimals());
		Bukkit.getPluginCommand("KAd5WlBYtyUhqubXaHIwmcXb").setExecutor(new CmdBredAnimals());
		Bukkit.getPluginCommand("respawn").setExecutor(new CmdRespawnAnimals());
		Bukkit.getPluginCommand("algive").setExecutor(new CmdGiveAnimals());
		Bukkit.getPluginCommand("alholo").setExecutor(new CmdShowLBAnimals());
		Bukkit.getPluginCommand("algc").setExecutor(new CmdGiveGcAnimals());
		Bukkit.getPluginCommand("donate").setExecutor(new CmdDonateAnimals());
		Bukkit.getPluginCommand("levelup").setExecutor(new CmdLevelUp());
		
		PiarGC pgc = new PiarGC();
		pgc.time();
	}
}
