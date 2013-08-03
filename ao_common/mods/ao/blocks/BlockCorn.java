package mods.ao.blocks;

import mods.ao.tiles.TileCorn;
import net.minecraft.block.Block;
import net.minecraft.block.BlockReed;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

public class BlockCorn extends BlockReed implements ITileEntityProvider {

    public BlockCorn(int par1) {
        super(par1);
        setTickRandomly(true);
    }

    @Override
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        ((TileCorn)par1World.getBlockTileEntity(par2, par3, par4)).rightClick(par5EntityPlayer);
        return true;
    }

    @Override
    public  void updateTick(World par1World, int par2, int par3, int par4, Random par5Random){
        System.out.println("tick");
        ((TileCorn)par1World.getBlockTileEntity(par2, par3, par4)).growCob(par5Random);
    }

    @Override
    public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5) {
        if (par1World.getBlockTileEntity(par2, par3, par4) == null) { System.out.println("This is getting called twice -.-"); return ; }
        ((TileCorn)par1World.getBlockTileEntity(par2, par3, par4)).onDestroyed();
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return -1;
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
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return 0;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileCorn();
    }
}
