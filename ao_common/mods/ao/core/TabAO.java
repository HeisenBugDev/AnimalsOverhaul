package mods.ao.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabAO extends CreativeTabs {

    public TabAO() {
        super("animalsOverhaul");
    }

    @Override
    public int getTabIconItemIndex() {
        return Item.egg.itemID;
    }

    @Override
    public String getTranslatedTabLabel() {
        return "Animals Overhaul";
    }
}
