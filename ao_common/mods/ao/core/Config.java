package mods.ao.core;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.Configuration;

import java.io.File;

public class Config {

    protected static File _configFolder;
    protected static File _configFile;

    public static void initConfig(FMLPreInitializationEvent event) {
        _configFolder = event.getModConfigurationDirectory();
        _configFile = new File(_configFolder.getAbsolutePath() + "/AnimalsOverhaul.cfg");
        loadPropertiesFromFile(_configFile);
    }
    public static void loadPropertiesFromFile(File file) {
        Configuration config = new Configuration(file);
        config.load();

        //add stuff here

        config.save();
    }

}
