package com.mrburger.PowerArmorMod;

import com.mrburger.PowerArmorMod.crafting.ModCrafting;
import com.mrburger.PowerArmorMod.item.ModBlocks;
import com.mrburger.PowerArmorMod.item.ModItems;
import com.mrburger.PowerArmorMod.world.ModWorldGen;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
        ModItems.init();
        ModBlocks.init();
    }

    public void init(FMLInitializationEvent e) {
        ModCrafting.init();
        GameRegistry.registerWorldGenerator(new ModWorldGen(), 0);
        ClientProxy.register_renderers();

    }

    public void postInit(FMLPostInitializationEvent e) {

    }




}
