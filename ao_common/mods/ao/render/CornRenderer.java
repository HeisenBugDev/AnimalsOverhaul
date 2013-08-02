package mods.ao.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;

public class CornRenderer extends TileEntitySpecialRenderer {

    private static CornRenderer INSTANCE = new CornRenderer();

    private ModelCornTop modelCornTop = new ModelCornTop();

    public static CornRenderer instance(){
        return INSTANCE;
    }

    @Override
    public void renderTileEntityAt(TileEntity tileentity, double d0, double d1, double d2, float f) {
        modelCornTop.render(d0, d1, d2);
    }
}
