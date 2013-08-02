package mods.ao.core;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = "AnimalsOverhaul", name = "Animals Overhaul", version = "@VERSION@")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class AnimalsOverhaul {

    @SidedProxy(clientSide = "mods.ao.core.ClientProxy", serverSide = "mods.ao.core.CommonProxy")
    public static ClientProxy proxy;
    @Mod.Instance("AnimalsOverhaul")
    public static AnimalsOverhaul instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Config.initConfig(event);
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent event) {
        Loader.initAll();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}