package com.mrburger.PowerArmorMod.Reference;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by mrburgerUS on 8/23/2015.
 */
public class Reference {

    public static final String MODID = "PowerArmorMod";
    public static final String MODNAME = "T-45D Power Armor";
    public static final String VERSION = "0.1";

    public static final String energyTag = "Energy";

    public static void setDefaultEnergyTag(ItemStack stack, int energy) {
        if (stack.getTagCompound() == null)
            stack.setTagCompound(new NBTTagCompound());
        stack.getTagCompound().setInteger(energyTag, energy);
    }


}




