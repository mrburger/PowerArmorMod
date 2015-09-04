package com.mrburger.PowerArmorMod;

import com.mrburger.PowerArmorMod.Render.RenderPlasmaBolt;
import com.mrburger.PowerArmorMod.entity.EntityPlasmaBoltRifle;
import com.mrburger.PowerArmorMod.item.ModItems;
import com.mrburger.PowerArmorMod.item.model.ModelPlasmaBolt;
import com.mrburger.PowerArmorMod.item.model.ModelSuperSledge;
import com.mrburger.PowerArmorMod.item.model.ModelT45DArmor;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.model.ModelBiped;
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

        RenderingRegistry.registerEntityRenderingHandler(EntityPlasmaBoltRifle.class,
                new RenderPlasmaBolt(new ModelPlasmaBolt(), 0.5F));
    }


}