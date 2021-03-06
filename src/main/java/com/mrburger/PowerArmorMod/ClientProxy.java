package com.mrburger.PowerArmorMod;

import com.mrburger.PowerArmorMod.Reference.Reference;
import com.mrburger.PowerArmorMod.Render.HoldingWeapon;
import com.mrburger.PowerArmorMod.Render.RenderLaserBolt;
import com.mrburger.PowerArmorMod.Render.RenderPlasma;
import com.mrburger.PowerArmorMod.entity.EntityLaser;
import com.mrburger.PowerArmorMod.entity.EntityPlasmaBoltRifle;
import com.mrburger.PowerArmorMod.entity.EntityPlasmaBoltRifleUnique;
import com.mrburger.PowerArmorMod.item.ModItems;
import com.mrburger.PowerArmorMod.item.model.ModelT45DArmor;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class ClientProxy extends CommonProxy {public static final Map<Item, ModelBiped> armorModels = new HashMap<Item, ModelBiped>();

    public static void register_renderers(){

        ModelT45DArmor T45Armor = new ModelT45DArmor();
        ModelT45DArmor T45Legs = new ModelT45DArmor();

        armorModels.put(ModItems.powerHelmet,T45Armor);
        armorModels.put(ModItems.powerChest, T45Armor);
        armorModels.put(ModItems.powerLeggings, T45Legs);
        armorModels.put(ModItems.powerBoots, T45Armor);

        EntityRegistry.registerModEntity(EntityPlasmaBoltRifle.class, "plasmabolt", 1, Reference.MODID, 80, 3, true);
        RenderingRegistry.registerEntityRenderingHandler(EntityPlasmaBoltRifle.class, new RenderPlasma());
        EntityRegistry.registerModEntity(EntityPlasmaBoltRifleUnique.class, "plasmaboltunique", 1, Reference.MODID, 80, 3, true);
        RenderingRegistry.registerEntityRenderingHandler(EntityPlasmaBoltRifleUnique.class, new RenderPlasma());

        EntityRegistry.registerModEntity(EntityLaser.class, "laser", 2, Reference.MODID, 80, 100, true);
        RenderingRegistry.registerEntityRenderingHandler(EntityLaser.class, new RenderLaserBolt());

        //RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, new HoldingWeapon());
    }


}