package net.zuperz.neotech.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.BrushItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.zuperz.neotech.NeoTech;
import net.zuperz.neotech.item.custom.FuelItem;
import net.zuperz.neotech.item.custom.ModFoodProoerties;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(NeoTech.MOD_ID);

    public static final DeferredItem<Item> STEEL_INGOT = ITEMS.registerItem("steel_ingot",
            Item::new, (new Item.Properties()));
    public static final DeferredItem<Item> RAW_STEEL =ITEMS.registerItem("raw_steel",
            Item::new, (new Item.Properties()));

    public static final DeferredItem<Item> STEEL_GEAR =ITEMS.registerItem("steel_gear",
            Item::new, (new Item.Properties()));

    public static final DeferredItem<Item> AMETHYST_GEAR =ITEMS.registerItem("amethyst_gear",
            Item::new, (new Item.Properties()));

    public static final DeferredItem<Item> COPPER_GEAR =ITEMS.registerItem("copper_gear",
            Item::new, (new Item.Properties()));

    public static final DeferredItem<Item> DIAMOND_GEAR =ITEMS.registerItem("diamond_gear",
            Item::new, (new Item.Properties()));

    public static final DeferredItem<Item> EMERALD_GEAR =ITEMS.registerItem("emerald_gear",
            Item::new, (new Item.Properties()));

    public static final DeferredItem<Item> GOLD_GEAR =ITEMS.registerItem("gold_gear",
            Item::new, (new Item.Properties()));

    public static final DeferredItem<Item> IRON_GEAR =ITEMS.registerItem("iron_gear",
            Item::new, (new Item.Properties()));

    public static final DeferredItem<Item> LAPIS_GEAR =ITEMS.registerItem("lapis_gear",
            Item::new, (new Item.Properties()));

    public static final DeferredItem<Item> NETHERITE_GEAR =ITEMS.registerItem("netherite_gear",
            Item::new, (new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}