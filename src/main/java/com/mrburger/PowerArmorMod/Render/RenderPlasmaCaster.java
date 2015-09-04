package com.mrburger.PowerArmorMod.Render;

import com.mrburger.PowerArmorMod.Reference.Reference;
import com.mrburger.PowerArmorMod.item.model.ModelPlasmaCaster;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * Created by mrburgerUS on 9/4/2015.
 */
public class RenderPlasmaCaster implements IItemRenderer {

    private ModelPlasmaCaster plasma;
    public static ResourceLocation texture = new ResourceLocation(Reference.MODID + ":" + "textures/models/modelplasmacaster.png" );

    public RenderPlasmaCaster(){

        plasma = new ModelPlasmaCaster();


    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        switch (type){

            case EQUIPPED:
                return true;
            case EQUIPPED_FIRST_PERSON:
                return true;
            default:
                return false;
        }
    }


    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return false;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        switch (type) {

            case EQUIPPED:
            {
                GL11.glPushMatrix();

                Minecraft.getMinecraft().renderEngine.bindTexture(texture);

                GL11.glScalef(1.1F, 1.1F, 1.1F);
                GL11.glRotatef(-150, 0F, 0F, 1F);
                GL11.glTranslatef(-0.75F, 0.3F, -0.05F);



                this.plasma.renderModel(0.0625F);

                GL11.glPopMatrix();
            }
            case EQUIPPED_FIRST_PERSON:
            {
                GL11.glPushMatrix();

                Minecraft.getMinecraft().renderEngine.bindTexture(texture);

                GL11.glScalef(1.1F, 1.1F, 1.1F);
                GL11.glRotatef(-150, 0F, 0F, 1F);



                GL11.glTranslatef(-0.75F, 0.3F, -0.05F);



                this.plasma.renderModel(0.0625F);

                GL11.glPopMatrix();


            }
            default:
                break;
        }
    }

}
