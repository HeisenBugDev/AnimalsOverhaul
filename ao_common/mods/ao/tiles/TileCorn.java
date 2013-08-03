package mods.ao.tiles;

import mods.ao.core.Loader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

import java.util.Random;

public class TileCorn extends TileEntity {

    private boolean hasCob;
    private boolean hadCob;

    public void growCob(Random r) {
        if (r.nextInt(4) == 0) {
            this.hasCob = true;
            this.hadCob = true;
            System.out.println("GROW COB");
        }
        if (r.nextInt(6) == 0) {
            worldObj.setBlock(this.xCoord, this.yCoord +1, this.zCoord, Loader.BlockCorn.blockID);
        }
    }

    public void onDestroyed() {
        //DROP IF A COB HAS GROWN
    }

    public void rightClick(EntityPlayer p) {
        this.hadCob = true;      //FORCE GROW COB ON RCLICK  (DEBUG        )
        this.hasCob = true;
        //IF HAD COB DROP THE COB / PUT INTO PLAYERS INVENTORY
    }

    public boolean hasCob() {
        return hasCob;
    }

    public boolean hadCob() {
        return hadCob;
    }
}
