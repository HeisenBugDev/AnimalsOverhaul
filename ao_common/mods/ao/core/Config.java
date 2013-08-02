package mods.ao.core;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.Configuration;

import java.io.File;

public class Config {

    public static String NameBlockNest = "blockNest";
    public static String NameBlockCorn = "blockCorn";

    public static int BlockNestID;
    public static int BlockCornID;

    public static String getTextureName(String name) {
        return "ao:" + name;
    }

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

        BlockNestID = config.get("Blocks", "BlockNest", 3525).getInt();
        BlockCornID = config.get("Block", "BlockCorn", 3526).getInt();

        //add stuff here

        config.save();
    }

}
