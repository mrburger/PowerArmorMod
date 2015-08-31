package com.mrburger.PowerArmorMod;

import com.mrburger.PowerArmorMod.item.ModItems;
import com.mrburger.PowerArmorMod.item.model.ModelT45DArmor;
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

    }


}