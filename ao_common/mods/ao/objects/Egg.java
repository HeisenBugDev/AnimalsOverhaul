package mods.ao.objects;

import net.minecraft.nbt.NBTTagCompound;

public class Egg {

    /**
     * How many ticks until the egg spoils
     */
    private int timeToSpoil;

    public boolean isSpoiled() {
        return (this.getTimeToSpoil() <= 0);
    }

    public int getTimeToSpoil() {
        return timeToSpoil;
    }

    public void setTimeToSpoil(int timeToSpoil) {
        this.timeToSpoil = timeToSpoil;
    }

    public void tick() {
        timeToSpoil--;
    }

    public Egg(int timeToSpoil) {
        this.timeToSpoil = timeToSpoil;

    }

    public Egg() { }

    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        this.timeToSpoil = par1NBTTagCompound.getInteger("spoiltimer");
    }

    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        par1NBTTagCompound.setInteger("spoiltimer", timeToSpoil);
    }
}
