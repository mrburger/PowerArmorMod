package com.mrburger.PowerArmorMod.item;

import com.mrburger.PowerArmorMod.Main;
import com.mrburger.PowerArmorMod.Reference.Reference;
import com.mrburger.PowerArmorMod.entity.EntityPlasmaBoltRifle;
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

import java.util.List;

public class ItemPlasmaRifle extends Item {

    public int type;
    int fireRate = 1;
    int fireTick = fireRate;

    public ItemPlasmaRifle(String unlocalizedName) {
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(Reference.MODID + ":" + unlocalizedName);
        this.setMaxStackSize(1);
        this.setCreativeTab(Main.tab);
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
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            if (this.fireTick == this.fireRate && this.fireTick != 0) {
                if (player.capabilities.isCreativeMode || player.inventory.consumeInventoryItem(ModItems.mfCell)) {
                    world.playSoundAtEntity(player, "powerarmormod:plasmafire", 1.0F, 1.0F);
                    world.spawnEntityInWorld(new EntityPlasmaBoltRifle(world, player));
                }

                this.fireTick = 0;
            } else {
                ++this.fireTick;
            }
            if (this.fireRate == 0) {
                if (player.capabilities.isCreativeMode || player.inventory.consumeInventoryItem(ModItems.mfCell)) {
                    world.playSoundAtEntity(player, "powerarmormod:plasmafire", 1.0F, 1.0F);
                    world.spawnEntityInWorld(new EntityPlasmaBoltRifle(world, player));
                }
            }

        }
        return stack;
    }
        @Override
        @SideOnly(Side.CLIENT)
        public boolean isFull3D ()
        {
            return true;
        }
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean check) {
        list.add("A Winchester P94 Plasma Caster.");
    }
    }



