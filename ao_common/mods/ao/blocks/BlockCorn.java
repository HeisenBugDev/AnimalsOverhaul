package mods.ao.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockReed;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

/**
 * Created with IntelliJ IDEA.
 * User: theron
 * Date: 8/2/13
 * Time: 12:12 PM
 */
public class BlockCorn extends BlockReed {

    public BlockCorn(int par1) {
        super(par1);
    }

    @Override
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
        Block block = Block.blocksList[par1World.getBlockId(par2, par3 - 1, par4)];
        return (block != null && canSustainPlant(par1World, par2, par3 - 1, par4, ForgeDirection.UP, this));
    }

    @Override
    public boolean canSustainPlant(World world, int x, int y, int z, ForgeDirection direction, IPlantable plant) {
        //if (plantID == reed.blockID && blockID == reed.blockID)
        //{
        return true;
        //}
    }

    @Override
    public EnumPlantType getPlantType(World world, int x, int y, int z) {
        return EnumPlantType.Crop;
    }

    @Override
    public int getPlantID(World world, int x, int y, int z) {
        return blockID;
    }
}
