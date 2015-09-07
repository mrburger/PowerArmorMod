package com.mrburger.PowerArmorMod.item;

import com.mrburger.PowerArmorMod.Main;
import com.mrburger.PowerArmorMod.Reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by mrburgerUS on 8/23/2015.
 */
public class VanadiumOre extends Block {

		//String unlocalizedName = "vanadiumore";

    protected VanadiumOre(String unlocalizedName, Material vanadiumore) {
        super(vanadiumore);
        this.setBlockName(unlocalizedName);
        this.setBlockTextureName(Reference.MODID + ":" + unlocalizedName);
        this.setCreativeTab(Main.tab);
        this.setHardness(5.0F);
        this.setResistance(1500.0F);
        this.setLightLevel(0.0F);
        this.setHarvestLevel("pickaxe", 2);
        this.setStepSound(soundTypeStone);
    }
}
