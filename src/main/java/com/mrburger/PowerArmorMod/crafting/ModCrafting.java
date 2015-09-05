package com.mrburger.PowerArmorMod.crafting;

import com.mrburger.PowerArmorMod.item.ModItems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by mrburgerUS on 8/23/2015.
 */
public class ModCrafting {


    public static void init() {
        GameRegistry.addSmelting(ModItems.vanadium, new ItemStack(ModItems.vanadiumIngot),0.8F);
        GameRegistry.addSmelting(ModItems.spacealloy, new ItemStack(ModItems.armorplate), 1.0F);
        GameRegistry.addSmelting(ModItems.ceramicMix, new ItemStack(ModItems.ceramicPlate), 1.0F);
        GameRegistry.addRecipe(new ItemStack(ModItems.spacealloy, 2), new Object[]{"#I", "I#", '#', Items.iron_ingot, 'I', ModItems.vanadiumIngot});
        GameRegistry.addRecipe(new ItemStack(ModItems.spacealloy, 2), new Object[]{"##", "##", '#', ModItems.spacealloy});
        GameRegistry.addRecipe(new ItemStack(ModItems.advarmorplate, 2), new Object[]{"#I", "I#", '#', Items.netherbrick, 'I', ModItems.vanadiumIngot});
        GameRegistry.addRecipe(new ItemStack(ModItems.mfPack), new Object[]{"*#*", "rrr", "*#*", '*', ModItems.vanadiumIngot, '#', Items.gold_ingot, 'r', ModItems.mfCell});
        GameRegistry.addRecipe(new ItemStack(ModItems.mfCell,16), new Object[]{" v ","#r#"," # ", '#', ModItems.ceramicPlate, 'r', Items.redstone, 'v', ModItems.vanadiumIngot});
        GameRegistry.addRecipe(new ItemStack(ModItems.ceramicMix, 8), new Object[]{"bnb", "nrn", "bnb", 'n', Items.netherbrick, 'b', Items.brick, 'r', Items.blaze_powder});

        GameRegistry.addRecipe(new ItemStack(ModItems.powerHelmet), new Object[]{"#I#","# #", '#', ModItems.armorplate, 'I', ModItems.mfPack});
        GameRegistry.addRecipe(new ItemStack(ModItems.powerChest), new Object[]{"# #","#I#","###", '#', ModItems.armorplate, 'I', ModItems.mfPack});
        GameRegistry.addRecipe(new ItemStack(ModItems.powerLeggings), new Object[]{"#I#","# #","# #", '#', ModItems.armorplate, 'I', ModItems.mfPack});
        GameRegistry.addRecipe(new ItemStack(ModItems.powerHelmet), new Object[]{"# #","#I#", '#', ModItems.armorplate, 'I', ModItems.mfPack});




    }




}
