package mods.ao.core;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import mods.ao.blocks.BlockCorn;
import mods.ao.blocks.BlockNest;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.client.MinecraftForgeClient;
import render.CornRenderer;

public class Loader {

    public static CreativeTabs tab_ao;
    public static BlockNest BlockNest;
    public static BlockCorn BlockCorn;

    public static void initAll() {
        initTabs();
        initItems();
        initBlocks();
        initRenderers();
        initTEs();
    }

    public static void initTabs() {
        tab_ao = new TabAO();
    }

    public static void initItems() {

    }

    public static void initBlocks() {
        BlockNest = (BlockNest) new BlockNest(Config.BlockNestID).setUnlocalizedName(Config.NameBlockNest)
                .setCreativeTab(tab_ao).func_111022_d(Config.getTextureName(Config.NameBlockNest));
        GameRegistry.registerBlock(BlockNest, Config.NameBlockNest);
        LanguageRegistry.addName(BlockNest, "Nest");

        BlockCorn = (BlockCorn) new BlockCorn(Config.BlockCornID).setUnlocalizedName(Config.NameBlockCorn)
                .setCreativeTab(tab_ao).func_111022_d(Config.getTextureName(Config.NameBlockCorn));
        GameRegistry.registerBlock(BlockCorn,Config.NameBlockCorn);
        LanguageRegistry.addName(BlockCorn,"Corn");
    }

    public static void initRenderers() {
        RenderingRegistry.registerBlockHandler(CornRenderer.instance());

    }

    public static void initTEs() {

    }

}
