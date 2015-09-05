package com.mrburger.PowerArmorMod.item;

import com.mrburger.PowerArmorMod.Reference.Reference;
import com.mrburger.PowerArmorMod.entity.EntityPlasmaBoltRifle;
import com.mrburger.PowerArmorMod.entity.EntityPlasmaBoltRifleUnique;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemPlasmaRifleUnique extends Item {

    public int type;

    public ItemPlasmaRifleUnique(String unlocalizedName) {
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(Reference.MODID + ":" + unlocalizedName);
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.epic;
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
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,EntityPlayer par3EntityPlayer) {
        if(par3EntityPlayer.capabilities.isCreativeMode||par3EntityPlayer.inventory.consumeInventoryItem(ModItems.mfCell))
        {
            par2World.playSoundAtEntity(par3EntityPlayer, "powerarmormod:plasmafire", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
            if (!par2World.isRemote)
            {
                par2World.spawnEntityInWorld(new EntityPlasmaBoltRifleUnique(par2World, par3EntityPlayer));
            }
        }
        return par1ItemStack;
    }
    @Override
    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }
}


