package com.mrburger.PowerArmorMod.Render;

import com.mrburger.PowerArmorMod.item.ItemPlasmaRifle;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.item.ItemStack;

//Working on, does not currently work.
public class HoldingWeapon extends RenderPlayer {
    @Override
    protected void renderLivingAt(
            AbstractClientPlayer par1AbstractClientPlayer, double par2,
            double par4, double par6) {
        ItemStack currItem = par1AbstractClientPlayer.getCurrentEquippedItem();
        if (currItem.getItem() instanceof ItemPlasmaRifle)
        {
            if (((ItemPlasmaRifle)currItem.getItem()).type == 0 || currItem.stackTagCompound.getBoolean("mouseDown"))
            {
                this.modelBipedMain.aimedBow = true;
            }


        }
        super.renderLivingAt(par1AbstractClientPlayer, par2, par4, par6);
    }
}
