package mods.ao.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

public class CornRenderer extends BaseBlockRenderer  {

    private static CornRenderer INSTANCE = new CornRenderer();

    private ModelCornTop modelCornTop = new ModelCornTop();

    public static CornRenderer instance(){
        return INSTANCE;
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        modelCornTop.render(x, y, z);
        return true;
    }
}
