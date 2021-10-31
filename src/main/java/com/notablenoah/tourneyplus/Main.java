package com.notablenoah.tourneyplus;

import com.notablenoah.tourneyplus.commands.GearPlayerCommand;
import com.notablenoah.tourneyplus.commands.OpenDashboardCommand;
import com.notablenoah.tourneyplus.commands.OpenMenuCommand;
import com.notablenoah.tourneyplus.listeners.DeathListener;
import com.notablenoah.tourneyplus.listeners.InventoryActionListener;
import com.notablenoah.tourneyplus.listeners.InventoryCloseListener;
import com.notablenoah.tourneyplus.listeners.JoinListener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public final class Main extends JavaPlugin {

    public static boolean tourneyMode = false;
    public static boolean spectatorOnDeath = false;
    public static boolean spectatorOnKill = false;
    public static boolean customDeathMsg = false;




    public static HashMap<String, ItemStack[]> data = new HashMap<>();

    //private File customConfigFile;
    //private FileConfiguration customConfig;

    @Override
    public void onEnable() {
        // Plugin startup logic
      //  createCustomConfig();


        this.getCommand("tourney").setExecutor(new OpenMenuCommand());
        this.getCommand("gear").setExecutor(new GearPlayerCommand());
        this.getCommand("dashboard").setExecutor(new OpenDashboardCommand());


        getServer().getPluginManager().registerEvents(new InventoryCloseListener(),this);
        getServer().getPluginManager().registerEvents(new InventoryActionListener(),this);
        getServer().getPluginManager().registerEvents(new JoinListener(),this);
        getServer().getPluginManager().registerEvents(new DeathListener(),this);




        this.saveDefaultConfig();

        if (this.getConfig().contains("data")){
            this.loadKits();
        }

    }

    public void saveKits(){
        for(Map.Entry<String,ItemStack[]>)
    }

    public void loadKits(){

    }



 /*   public FileConfiguration getCustomConfig() {
        return this.customConfig;
    }
    private void createCustomConfig() {
        customConfigFile = new File(getDataFolder(), "custom.yml");
        if (!customConfigFile.exists()) {
            customConfigFile.getParentFile().mkdirs();
            saveResource("custom.yml", false);
        }

        customConfig= new YamlConfiguration();
        try {
            customConfig.load(customConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

  */


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        if(!data.isEmpty()){
            this.saveKits();
        }

    }
}
