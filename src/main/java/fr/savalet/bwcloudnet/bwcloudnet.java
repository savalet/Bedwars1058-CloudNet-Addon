package fr.savalet.bwcloudnet;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import de.dytanic.cloudnet.wrapper.Wrapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

public final class bwcloudnet extends JavaPlugin {
    public Logger logger = Bukkit.getLogger();

    @Override
    public void onLoad() {
        logger.info("*-------Bedwars1058 CloudNet-------*");
        logger.info("*        Plugin loading...         *");
        logger.info("*------1.2-RELEASE by Savalet------*");
        String ServiceName =  Wrapper.getInstance().getServiceId().getName();
        logger.info("Service name: " + ServiceName);
        try {
            File file = new File("plugins/BedWars1058/config.yml");
            Scanner reader = new Scanner(file);
            StringBuilder data_parse = new StringBuilder();
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                if (data.contains("  server-id: "))
                    data = "  server-id: " + ServiceName;
                data_parse.append(data).append("\n");
            }
            reader.close();
            logger.info("Config file read");
            try {
                FileWriter writer = new FileWriter("plugins/BedWars1058/config.yml");
                writer.write(data_parse.toString());
                writer.close();
                logger.info("Successfully wrote config file");
            } catch (IOException e) {
                logger.severe("An error occurred !");
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            logger.severe("Config file doesn't exist !");
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        logger.info("*-------Bedwars1058 CloudNet-------*");
        logger.info("*          Plugin disabled         *");
        logger.info("*------1.2-RELEASE by Savalet------*");
    }
}
