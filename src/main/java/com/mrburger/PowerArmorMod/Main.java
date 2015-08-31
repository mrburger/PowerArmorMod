package com.mrburger.PowerArmorMod;

import com.mrburger.PowerArmorMod.Reference.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.MODNAME, version = Reference.VERSION)
public class Main {

    @SidedProxy(clientSide="com.mrburger.PowerArmorMod.ClientProxy", serverSide="com.mrburger.PowerArmorMod.ServerProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.preInit(e);
        System.out.println("T-45 PreInit Complete!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
        System.out.println("T-45 Init Complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
        System.out.println("T-45 PostInit Complete!");
    }


}
