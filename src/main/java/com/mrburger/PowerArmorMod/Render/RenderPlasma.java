package com.mrburger.PowerArmorMod.Render;


import com.mrburger.PowerArmorMod.Reference.Reference;
import com.mrburger.PowerArmorMod.item.model.ModelPlasmaBolt;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;


public class RenderPlasma extends Render {

    private ModelPlasmaBolt plasmaentity;
    public static ResourceLocation texture = new ResourceLocation(Reference.MODID + ":" + "/textures/models/plasmabolt.png" );

    public RenderPlasma() {
        plasmaentity = new ModelPlasmaBolt();
    }

    @Override
    public void doRender(Entity par1EntityThrownItem, double par2, double par4, double par6, float par8, float par9) {

        GL11.glPushMatrix();
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        GL11.glTranslatef((float) par2, (float) par4, (float) par6);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        float f2 = 1.0F;
        GL11.glScalef(f2 / 1.0F, f2 / 1.0F, f2 / 1.0F);
        Tessellator tessellator = Tessellator.instance;
        GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        tessellator.draw();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);

       this.plasmaentity.renderModel(0.0625F);
        GL11.glPopMatrix();

    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return texture;
    }
}
