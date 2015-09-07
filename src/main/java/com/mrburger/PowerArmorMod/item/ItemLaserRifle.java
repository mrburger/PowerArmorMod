package com.mrburger.PowerArmorMod.item;

import com.mrburger.PowerArmorMod.Main;
import com.mrburger.PowerArmorMod.Reference.Reference;
import com.mrburger.PowerArmorMod.entity.EntityLaser;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;


public class ItemLaserRifle extends Item {

    int fireRate;
    int fireTick;



    public ItemLaserRifle(String unlocalizedName) {
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(Reference.MODID + ":" + unlocalizedName);
        this.setMaxStackSize(1);
        this.setCreativeTab(Main.tab);
        this.fireRate = 2;
        this.fireTick = this.fireRate;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.rare;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack){

        return 20;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            if (this.fireTick == this.fireRate && this.fireTick != 0) {
                if (player.capabilities.isCreativeMode || player.inventory.consumeInventoryItem(ModItems.mfCell)) {
                    world.playSoundAtEntity(player, "powerarmormod:laserfire", 1.0F, 1.0F);
                    world.spawnEntityInWorld(new EntityLaser(world, player));
                }

                this.fireTick = 0;
            } else {
                ++this.fireTick;
            }
            if (this.fireRate == 0) {
                if (player.capabilities.isCreativeMode || player.inventory.consumeInventoryItem(ModItems.mfCell)) {
                    world.playSoundAtEntity(player, "powerarmormod:laserfire", 1.0F, 1.0F);
                    world.spawnEntityInWorld(new EntityLaser(world, player));
                }
            }

        }
        return stack;
    }
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean check) {
    list.add("A Space-Age Laser Rifle, Model AER-9");
    }
}