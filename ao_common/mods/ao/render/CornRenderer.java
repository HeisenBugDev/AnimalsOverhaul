package mods.ao.render;

import mods.ao.render.models.ModelCornSide;
import mods.ao.render.models.ModelCornCob;
import mods.ao.render.models.ModelCornRod;
import mods.ao.tiles.TileCorn;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class CornRenderer extends TileEntitySpecialRenderer {

    private static CornRenderer INSTANCE = new CornRenderer();
    private ModelCornSide modelCornSide = new ModelCornSide();
    private ModelCornCob modelCornCob = new ModelCornCob();
    private ModelCornRod modelCornRod = new ModelCornRod();

    public static CornRenderer instance() {
        return INSTANCE;
    }

    @Override
    public void renderTileEntityAt(TileEntity tileentity, double d0, double d1, double d2, float f) {
        modelCornRod.render(d0, d1, d2);
        if (((TileCorn)tileentity).hadCob()) {
            modelCornSide.render(d0, d1, d2, 0);
        }
        if (((TileCorn)tileentity).hasCob()) {
            modelCornCob.render(d0,d1,d2);
            System.out.println("COB");
        }
    }
}
