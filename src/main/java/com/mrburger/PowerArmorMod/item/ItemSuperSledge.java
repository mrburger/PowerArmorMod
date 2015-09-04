package com.mrburger.PowerArmorMod.item;

import cofh.api.energy.IEnergyContainerItem;
import com.mrburger.PowerArmorMod.Reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import java.util.List;

public class ItemSuperSledge extends ItemSword implements IEnergyContainerItem {

    private int energyMax = 250000;
    private int maxTransfer = 25000;
    private int usageEnergy = 500;

    public ItemSuperSledge(String unlocalizedName, ToolMaterial material) {
        super(material);
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(Reference.MODID + ":" + unlocalizedName);

    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {

        return EnumRarity.rare;

    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean currentItem) {
        EntityPlayer player = (EntityPlayer) entity;

        if (!currentItem) {
            return;
        } else {
            player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 10));
            player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 10, 3));

        }
    }


    @Override
    public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {
        if (container.stackTagCompound == null) {
            Reference.setDefaultEnergyTag(container, 0);
        }
        int stored = container.stackTagCompound.getInteger("EnergyT45");
        int receive = Math
                .min(maxReceive, Math.min(getMaxEnergyStored(container)
                        - stored, maxTransfer));

        if (!simulate) {
            stored += receive;
            container.stackTagCompound.setInteger("EnergyT45", stored);
        }
        return receive;
    }


    @Override
    public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {
        return 0;
    }

    @Override
    public int getEnergyStored(ItemStack container) {
        return 0;
    }

    @Override
    public int getMaxEnergyStored(ItemStack container) {
        return energyMax;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean check) {
        if (stack.stackTagCompound == null) {
            Reference.setDefaultEnergyTag(stack, 0);
        }

        list.add("Energy: " + "PLACEHOLDER" + " / " + energyMax);
    }
    @Override
    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }




}
