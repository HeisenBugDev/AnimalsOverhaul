package mods.ao.blocks;

import mods.ao.tiles.TileCorn;
import mods.ao.tiles.TileNest;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Random;

public class BlockNest extends BlockContainer {

    public BlockNest(int par1) {
        super(par1, Material.ground);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileNest();
    }

    @Override
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        ((TileNest)par1World.getBlockTileEntity(par2, par3, par4)).rightClick(par5EntityPlayer);
        return true;
    }

    @Override
    public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5) {
        if (par1World.getBlockTileEntity(par2, par3, par4) == null) { System.out.println("This is getting called twice -.-"); return ; }
        ((TileNest)par1World.getBlockTileEntity(par2, par3, par4)).onDestroyed();
    }

}
