package com.mrburger.PowerArmorMod.item;


import cofh.api.energy.IEnergyContainerItem;
import com.mrburger.PowerArmorMod.Reference.Reference;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;

import java.util.List;

public class T51BArmor extends ItemArmor implements ISpecialArmor, IEnergyContainerItem {


    public String textureName;

    public T51BArmor(String unlocalizedName, ArmorMaterial material, String textureName, int type) {
        super(material, 0, type);
        this.textureName = textureName;
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(Reference.MODID + ":" + unlocalizedName);
    }

    private double totalAbsorption = 0.9D;
    private int transferMax = 10000;
    private int energyMax = (int) 1E7;
    private int damageEnergy = 200;



    protected double absoptionAmt() {

        switch (armorType) {
            case 0:
                return .20D;
            case 1:
                return .40D;
            case 2:
                return .30D;
            case 3:
                return .10D;
        }
        return 0;


    }
    @Override
    public boolean getIsRepairable(ItemStack itemRepair, ItemStack stack) {

        return false;
    }

    @Override
    public int getDisplayDamage(ItemStack stack) {

        if (stack.stackTagCompound == null) {
            Reference.setDefaultEnergyTag(stack, 0);
        }
        return energyMax - stack.stackTagCompound.getInteger("Energy");
    }
    @Override
    public void setDamage(ItemStack stack, int damage) {

        super.setDamage(stack, 0);
    }

    @Override
    public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {
        if (container.stackTagCompound == null) {
            Reference.setDefaultEnergyTag(container, 0);
        }
        int stored = container.stackTagCompound.getInteger("EnergyT51");
        int receive = Math
                .min(maxReceive, Math.min(getMaxEnergyStored(container)
                        - stored, transferMax));

        if (!simulate) {
            stored += receive;
            container.stackTagCompound.setInteger("EnergyT51", stored);
        }
        return receive;
    }

    @Override
    public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {
        if (container.stackTagCompound == null) {
            Reference.setDefaultEnergyTag(container, 0);
        }
        int stored = container.stackTagCompound.getInteger("EnergyT51");
        int extract = Math.min(maxExtract, stored);

        if (!simulate) {
            stored -= extract;
            container.stackTagCompound.setInteger("EnergyT51", stored);
        }
        return extract;
    }

    @Override
    public int getEnergyStored(ItemStack container) {
        if (container.stackTagCompound == null) {
            Reference.setDefaultEnergyTag(container, 0);
        }
        return container.stackTagCompound.getInteger("EnergyT51");
    }

    @Override
    public int getMaxEnergyStored(ItemStack container) {
        return energyMax;
    }

    @Override
    public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {
        if (source.damageType.equals(DamageSource.fall.damageType) && armor.getItem() == ModItems.powerBoots) return new ArmorProperties(1, 0.95D, 1000);
        if (source.damageType.equals(DamageSource.magic.damageType) && armor.getItem() == ModItems.powerChest) return new ArmorProperties(1, 1.0D, 1000);
        //  if (source.damageType.equals(DamageSource.isExplosion) && armor.getItem() == ModItems.powerChest) return new ArmorProperties(1, 1.0D, 1000);
        return new ArmorProperties(1, (absoptionAmt()*totalAbsorption), 1000);
    }

    @Override
    public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
        return (int) (absoptionAmt()*20);
    }

    @Override
    public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
        extractEnergy(stack, damage * damageEnergy, false);
    }
    @Override
    public void onArmorTick(World w, EntityPlayer player, ItemStack armor) {
        if (player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == ModItems.t51Chest
                && player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == ModItems.t51Legs
                && player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == ModItems.t51Boots && (this.getEnergyStored(armor) > 100)) {
            player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 20));
            if (player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == ModItems.t51Helmet
                    && player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == ModItems.t51Chest
                    && player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == ModItems.t51Legs
                    && player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == ModItems.t51Boots && (this.getEnergyStored(armor) > 100))
                player.addPotionEffect(new PotionEffect(Potion.resistance.id, 20, 1));

        }
    }
    @Override
    public boolean isDamaged(ItemStack stack) {

        return true;
    }
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean check) {
        if (stack.stackTagCompound == null) {
            Reference.setDefaultEnergyTag(stack, 0);
        }

        list.add("Energy: " + stack.stackTagCompound.getInteger("EnergyT51") + " / " + energyMax);
    }
}
