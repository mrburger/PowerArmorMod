package com.mrburger.PowerArmorMod.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import scala.tools.nsc.backend.icode.BasicBlocks;

/**
 * Created by mrburgerUS on 8/23/2015.
 */
public class ModBlocks {


    public static Block vanadiumore;

    public static final void init() {
        GameRegistry.registerBlock(vanadiumore = new VanadiumOre("vanadiumOre", Material.rock), "vanadiumOre" );


    }

}


