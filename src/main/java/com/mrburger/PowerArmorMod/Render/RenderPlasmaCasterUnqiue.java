package com.mrburger.PowerArmorMod.Render;


import com.mrburger.PowerArmorMod.Reference.Reference;
import com.mrburger.PowerArmorMod.item.model.ModelPlasmaCaster;
import com.mrburger.PowerArmorMod.item.model.ModelPlasmaCasterUnique;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * Created by mrburgerUS on 9/4/2015.
 */
public class RenderPlasmaCasterUnqiue implements IItemRenderer {

    private ModelPlasmaCasterUnique plasma;
    public static ResourceLocation texture = new ResourceLocation(Reference.MODID + ":" + "textures/models/modelplasmacasterunique.png" );

    public RenderPlasmaCasterUnqiue(){

        plasma = new ModelPlasmaCasterUnique();


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
                GL11.glRotatef(-180, 1F, 1F, 0F);
                GL11.glTranslatef(0.15F, 0.9F, -0.05F);



                this.plasma.renderModel(0.0625F);

                GL11.glPopMatrix();
            }
            case EQUIPPED_FIRST_PERSON:
            {
                GL11.glPushMatrix();

                Minecraft.getMinecraft().renderEngine.bindTexture(texture);

                GL11.glScalef(1.1F, 1.1F, 1.1F);
                GL11.glRotatef(-180, 1F, 1F, 0F);


                boolean isFirstPerson = false;

                if(data[1] != null && data[1] instanceof EntityPlayer)
                {
                    if(!(data[1] == Minecraft.getMinecraft().renderViewEntity && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0 && !((Minecraft.getMinecraft().currentScreen instanceof GuiInventory || Minecraft.getMinecraft().currentScreen instanceof GuiContainerCreative) && RenderManager.instance.playerViewY == 180.0F)))
                    {
                        GL11.glTranslatef(0.15F, 0.9F, -0.05F);
                    }
                    else
                    {
                        isFirstPerson = true;

                        GL11.glRotatef(45, 0F, 0F, 1F);
                        GL11.glTranslatef(0F, 0.2F, 0F);

                    }
                }
                else
                {
                    GL11.glTranslatef(0.15F, 0.9F, -0.05F);
                }






                this.plasma.renderModel(0.0625F);

                GL11.glPopMatrix();


            }
            default:
                break;
        }
    }

}
