package mods.ao.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class CornRenderer extends TileEntitySpecialRenderer {

    private static CornRenderer INSTANCE = new CornRenderer();
    private ModelCornBottom modelCornBottom = new ModelCornBottom();
    private ModelCornCob modelCornCob = new ModelCornCob();

    public static CornRenderer instance() {
        return INSTANCE;
    }

    @Override
    public void renderTileEntityAt(TileEntity tileentity, double d0, double d1, double d2, float f) {
        modelCornBottom.render(d0, d1, d2);
        modelCornCob.render(d0, d1, d2);
    }
}
