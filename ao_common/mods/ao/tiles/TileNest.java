package mods.ao.tiles;

import cpw.mods.fml.common.Mod;
import mods.ao.objects.Egg;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

import java.util.Iterator;
import java.util.List;

public class TileNest extends TileEntity {

    private Egg[] eggs;
    private boolean isChickenOnTop;


    public void rightClick(EntityPlayer p) {
        if (p.getCurrentEquippedItem() != null && p.getCurrentEquippedItem().itemID == Item.egg.itemID) {
            for (int i = 0; i < 16; i++) {
                if (eggs[i] == null) {
                    eggs[i] = new Egg(2); //SPOIL EGG AFTER 2 MC DAYS
                }
            }
        }
    }

    protected AxisAlignedBB getSensitiveAABB()
    {
        int x = xCoord;
        int y = yCoord;
        int z = zCoord;
        return AxisAlignedBB.getAABBPool().getAABB(x, y, z, x+1, y+1.5f, z+1);
    }

    public void onDestroyed() {
        //DROP EGGS
    }

    List list;

    public TileNest() {
        this.eggs = new Egg[16];
    }

    public void checkChicken() {
        list = worldObj.getEntitiesWithinAABBExcludingEntity((Entity)null, this.getSensitiveAABB());
        if (list != null && !list.isEmpty())
        {
            for (Object e : list) {
                isChickenOnTop = (e instanceof EntityChicken);
            }
        } else isChickenOnTop = false;
    }

    int i;
    int i2;
    @Override
    public void updateEntity() {

        i2++;
        if (i2 == 10) { checkChicken(); i2 = 0; }
        if (!isChickenOnTop) {
            i++;
            if (i == 24000) {
                 for (Egg e : eggs) {
                    e.tick();
                }
                i = 0;
            }
        }

    }

    @Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        for (int i = 0; i < 16; i++) {
            eggs[i].readFromNBT(par1NBTTagCompound.getCompoundTag("eggs").getCompoundTag("egg_" + i));
        }
        super.readFromNBT(par1NBTTagCompound);
    }

    @Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        if (eggs == null) {eggs = new Egg[16];}
        NBTTagCompound t = new NBTTagCompound("eggs");
        for (int i = 0; i < 16; i++) {
            NBTTagCompound t2 = new NBTTagCompound("egg_" + i);
            eggs[i].writeToNBT(t2);
            t.setCompoundTag("egg_" + i, t2);
        }
        par1NBTTagCompound.setCompoundTag("eggs", t);
        super.writeToNBT(par1NBTTagCompound);
    }

}
