package mods.ao.tiles;

import mods.ao.objects.Egg;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileNest extends TileEntity {

    private Egg[] eggs;

    public TileNest() {
        this.eggs = new Egg[16];
    }

    @Override
    public void updateEntity() {
        for (Egg e : eggs) {
            e.tick();
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
        for (int i = 0; i < 16; i++) {
            eggs[i].writeToNBT(par1NBTTagCompound.getCompoundTag("eggs").getCompoundTag("egg_" + i));
        }
        super.writeToNBT(par1NBTTagCompound);
    }

}
