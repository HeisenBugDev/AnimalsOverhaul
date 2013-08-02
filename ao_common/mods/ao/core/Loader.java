package mods.ao.core;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import mods.ao.blocks.BlockNest;
import net.minecraft.client.resources.Language;
import net.minecraft.creativetab.CreativeTabs;

public class Loader {

    public static CreativeTabs tab_ao;

    public static BlockNest BlockNest;

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
    }

    public static void initRenderers() {

    }

    public static void initTEs() {

    }

}
