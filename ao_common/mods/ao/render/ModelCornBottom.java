package mods.ao.render;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class ModelCornBottom extends ModelBase {
    private IModelCustom modelCornBottom;


    public ModelCornBottom() {
        modelCornBottom = AdvancedModelLoader.loadModel("/assets/ao/models/corn_bottom.obj");
    }

    private void render() {
        modelCornBottom.renderAll();
    }

    public void render(double x, double y, double z) {
        // Push a blank matrix onto the stack
        GL11.glPushMatrix();

        // Move the object into the correct position on the block (because the OBJ's origin is the center of the object)
        GL11.glTranslatef((float) x + 0.5f, (float) y, (float) z + 0.5f);

        // Scale our object to about half-size in all directions (the OBJ file is a little large)
        GL11.glScalef(1 / 16f, 1 / 16f, 1 / 16f);

        // Bind the texture, so that OpenGL properly textures our block.
        FMLClientHandler.instance().getClient().renderEngine
                .func_110577_a(new ResourceLocation("ao", "models/test.png"));

        // Render the object, using modelTutBox.renderAll();
        this.render();

        // Pop this matrix from the stack.
        GL11.glPopMatrix();
    }

}