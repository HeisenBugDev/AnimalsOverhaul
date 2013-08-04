package mods.ao.render.models;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class ModelNestBase extends ModelBase {
    private IModelCustom modelNestBase;
    public ModelNestBase() {
        modelNestBase = AdvancedModelLoader.loadModel("/assets/ao/models/nest/base.obj");
    }
    private void render() {
        modelNestBase.renderAll();
    }
    public void render(double x, double y, double z) {
        // Push a blank matrix onto the stack
        GL11.glPushMatrix();

        // Move the object into the correct position on the block (because the OBJ's origin is the center of the object)
        GL11.glTranslatef((float) x + 0.5f, (float) y , (float) z + 0.5f);

        // Scale our object to about half-size in all directions (the OBJ file is a little large)
        GL11.glScalef(1 / 16f, 1 / 16f, 1 / 16f);

        // Bind the texture, so that OpenGL properly textures our block.
        FMLClientHandler.instance().getClient().renderEngine
                .func_110577_a(new ResourceLocation("ao", "models/nest/base.png"));



        // Render the object, using modelTutBox.renderAll();
        this.render();

        // Pop this matrix from the stack.
        GL11.glPopMatrix();
    }
}
