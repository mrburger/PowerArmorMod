package com.mrburger.PowerArmorMod.item;

import com.mrburger.PowerArmorMod.Reference.Reference;
import com.mrburger.PowerArmorMod.entity.EntityPlasmaBoltRifle;
import com.mrburger.PowerArmorMod.entity.EntityTest;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPlasmaRifle extends Item {

    private int energyMax = 250000;
    private int maxTransfer = 25000;
    private int usageEnergy = 500;

    public ItemPlasmaRifle(String unlocalizedName) {
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(Reference.MODID + ":" + unlocalizedName);
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.rare;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,EntityPlayer par3EntityPlayer) {
        if(par3EntityPlayer.capabilities.isCreativeMode||par3EntityPlayer.inventory.consumeInventoryItem(Items.redstone))
        {
            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
            if (!par2World.isRemote)
            {
                par2World.spawnEntityInWorld(new EntityPlasmaBoltRifle(par2World, par3EntityPlayer));
            }
        }
        return par1ItemStack;
    }
}


