package com.mrburger.PowerArmorMod.item;

import com.mrburger.PowerArmorMod.Main;
import com.mrburger.PowerArmorMod.Reference.Reference;
import com.mrburger.PowerArmorMod.Render.RenderPlasmaCaster;
import com.mrburger.PowerArmorMod.Render.RenderPlasmaCasterUnqiue;
import com.mrburger.PowerArmorMod.Render.RenderSuperSledge;
import com.mrburger.PowerArmorMod.item.model.ModelSuperSledge;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.util.EnumHelper;

/**
 * Created by mrburgerUS on 8/23/2015.
 */
public class ModItems {

    public static ItemArmor.ArmorMaterial POWERARMOR = EnumHelper.addArmorMaterial("POWERARMOR", 100, new int[]{3, 8, 6, 3}, 0);
    public static ItemArmor.ArmorMaterial T51B = EnumHelper.addArmorMaterial("T51B", 1000, new int[]{3, 8, 6, 3}, 0);
    public static ItemArmor.ArmorMaterial ENCLAVE = EnumHelper.addArmorMaterial("ENCLAVE", 1000, new int[]{3, 8, 6, 3}, 0);
    public static Item.ToolMaterial SUPERSLEDGE = EnumHelper.addToolMaterial("SUPERSLEDGE", 0, 100, 1.0F, 2.0F, 0);


    public static Item vanadium;
    public static Item vanadiumIngot;
    public static Item spacealloy;
    public static Item armorplate;
    public static Item powerHelmet;
    public static Item powerChest;
    public static Item powerLeggings;
    public static Item powerBoots;
    public static Item advarmorplate;
    public static Item t51Helmet;
    public static Item t51Chest;
    public static Item t51Legs;
    public static Item t51Boots;
    public static Item mfPack;
    public static Item superSledge;
    public static Item plasmaRifle;
    public static Item plasmaRifleUnique;
    public static Item mfCell;
    public static Item ceramicPlate;
    public static Item ceramicMix;
    public static Item laserRifle;
		
    public static final void init() {
        vanadium = new Item().setUnlocalizedName("vanadium").setCreativeTab(Main.tab).setTextureName(Reference.MODID+":"+"vanadium");
        GameRegistry.registerItem(vanadium, "vanadium");
				
        vanadiumIngot = new Item().setUnlocalizedName("vanadiumingot").setCreativeTab(Main.tab).setTextureName(Reference.MODID+":"+"vanadiumingot");
        GameRegistry.registerItem(vanadiumIngot, "vanadiumingot");

        spacealloy = new Item().setUnlocalizedName("spacealloy").setCreativeTab(Main.tab).setTextureName(Reference.MODID+":"+"spacealloy");
        GameRegistry.registerItem(spacealloy, "spacealloy");

        armorplate = new Item().setUnlocalizedName("armorplate").setCreativeTab(Main.tab).setTextureName(Reference.MODID+":"+"armorplate");
        GameRegistry.registerItem(armorplate, "armorplate");

        advarmorplate = new Item().setUnlocalizedName("advarmorplate").setCreativeTab(Main.tab).setTextureName(Reference.MODID+":"+"advarmorplate");
        GameRegistry.registerItem(advarmorplate, "advarmorplate");

        mfPack =  new Item().setUnlocalizedName("mfpack").setCreativeTab(Main.tab).setTextureName(Reference.MODID + ":" + "mfpack");
        GameRegistry.registerItem(mfPack, "mfpack");

        mfCell =  new Item().setUnlocalizedName("mfcell").setMaxStackSize(16).setCreativeTab(Main.tab).setTextureName(Reference.MODID + ":" + "mfcell");
        GameRegistry.registerItem(mfCell, "mfcell");

        ceramicPlate =  new Item().setUnlocalizedName("ceramicplate").setCreativeTab(Main.tab).setTextureName(Reference.MODID + ":" + "ceramicplate");
        GameRegistry.registerItem(ceramicPlate, "ceramicplate");

        ceramicMix =  new Item().setUnlocalizedName("ceramicmix").setCreativeTab(Main.tab).setTextureName(Reference.MODID + ":" + "ceramicmix");
        GameRegistry.registerItem(ceramicMix, "ceramicmix");


        GameRegistry.registerItem(superSledge = new ItemSuperSledge("supersledge", SUPERSLEDGE), "supersledge");

        GameRegistry.registerItem(plasmaRifle = new ItemPlasmaRifle("plasmarifle"), "plasmarifle");
        GameRegistry.registerItem(plasmaRifleUnique = new ItemPlasmaRifleUnique("plasmarifleunique"), "plasmarifleunique");
        GameRegistry.registerItem(laserRifle = new ItemLaserRifle("laserrifle"), "laserrifle");

        GameRegistry.registerItem(powerHelmet = new T45DArmor("powerhelmet", POWERARMOR, "powerhelmet", 0), "powerhelmet");
        GameRegistry.registerItem(powerChest = new T45DArmor("powerchest", POWERARMOR, "powerchest", 1), "powerchest");
        GameRegistry.registerItem(powerLeggings = new T45DArmor("powerlegs", POWERARMOR, "powerlegs", 2), "powerlegs");
        GameRegistry.registerItem(powerBoots = new T45DArmor("powerboots", POWERARMOR, "powerboots", 3), "powerboots");

        GameRegistry.registerItem(t51Helmet = new T51BArmor ("t51helmet", T51B, "t51helmet", 0), "t51helmet");
        GameRegistry.registerItem(t51Chest = new T51BArmor("t51chest", T51B, "t51chest", 1), "t51chest");
        GameRegistry.registerItem(t51Legs = new T51BArmor("t51legs", T51B, "t51legs", 2), "t51legs");
        GameRegistry.registerItem(t51Boots = new T51BArmor("t51boots", T51B, "t51boots", 3), "t51boots");


        MinecraftForgeClient.registerItemRenderer(ModItems.superSledge, (IItemRenderer) new RenderSuperSledge());
        MinecraftForgeClient.registerItemRenderer(ModItems.plasmaRifle, (IItemRenderer)new RenderPlasmaCaster());
        MinecraftForgeClient.registerItemRenderer(ModItems.plasmaRifleUnique, (IItemRenderer)new RenderPlasmaCasterUnqiue());


    }



}
