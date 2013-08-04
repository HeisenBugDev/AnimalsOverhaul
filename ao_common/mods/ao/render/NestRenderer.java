package mods.ao.render;

import mods.ao.render.models.ModelCornRod;
import mods.ao.render.models.ModelNestBase;
import mods.ao.tiles.TileNest;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class NestRenderer extends TileEntitySpecialRenderer {

    private static NestRenderer INSTANCE = new NestRenderer();
    private ModelNestBase modelNestBase = new ModelNestBase();

    public static NestRenderer instance() {
        return INSTANCE;
    }

    @Override
    public void renderTileEntityAt(TileEntity tileentity, double d0, double d1, double d2, float f) {
        TileNest te = (TileNest) tileentity;
        modelNestBase.render(d0, d1, d2);

    }
}
