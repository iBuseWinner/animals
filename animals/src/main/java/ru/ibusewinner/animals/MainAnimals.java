package ru.ibusewinner.animals;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import de.Herbystar.TTA.TTA_Methods;

public class MainAnimals extends JavaPlugin{
	
	public static String prefix = "§e§lЖизнь Животных§8 >>§7 ";
	static Plugin plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		MySQLAnimals.connect();
		regCmdList();
	}
	@Override
	public void onDisable() {
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
		Bukkit.getPluginCommand("levelup").setExecutor(new OooOOOoo_Cmd_LevelUp_OoOooooO());
	}
}
