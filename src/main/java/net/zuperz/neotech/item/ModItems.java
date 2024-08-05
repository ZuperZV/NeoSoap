package net.zuperz.neotech.item;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.BrushItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.zuperz.neotech.NeoTech;
import net.zuperz.neotech.item.custom.FuelItem;
import net.zuperz.neotech.item.custom.ModFoodProoerties;
import net.zuperz.neotech.item.custom.ModToolTiers;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(NeoTech.MOD_ID);

    public static final DeferredItem<Item> STEEL_INGOT = ITEMS.registerItem("steel_ingot",
            Item::new, (new Item.Properties()));
    public static final DeferredItem<Item> RAW_STEEL =ITEMS.registerItem("raw_steel",
            Item::new, (new Item.Properties()));

    //gear

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

    //plate
    public static final DeferredItem<Item> STEEL_PLATE =ITEMS.registerItem("steel_plate",
            Item::new, (new Item.Properties()));

    public static final DeferredItem<Item> AMETHYST_PLATE =ITEMS.registerItem("amethyst_plate",
            Item::new, (new Item.Properties()));

    public static final DeferredItem<Item> COPPER_PLATE =ITEMS.registerItem("copper_plate",
            Item::new, (new Item.Properties()));

    public static final DeferredItem<Item> DIAMOND_PLATE =ITEMS.registerItem("diamond_plate",
            Item::new, (new Item.Properties()));

    public static final DeferredItem<Item> EMERALD_PLATE =ITEMS.registerItem("emerald_plate",
            Item::new, (new Item.Properties()));

    public static final DeferredItem<Item> GOLD_PLATE =ITEMS.registerItem("gold_plate",
            Item::new, (new Item.Properties()));

    public static final DeferredItem<Item> IRON_PLATE =ITEMS.registerItem("iron_plate",
            Item::new, (new Item.Properties()));

    public static final DeferredItem<Item> LAPIS_PLATE =ITEMS.registerItem("lapis_plate",
            Item::new, (new Item.Properties()));

    public static final DeferredItem<Item> NETHERITE_PLATE =ITEMS.registerItem("netherite_plate",
            Item::new, (new Item.Properties()));

    //hammer

    public static final DeferredItem<Item> WOODEN_HAMMER =ITEMS.register("wooden_hammer",
            () -> new SwordItem(Tiers.WOOD,
                    new Item.Properties().fireResistant().attributes(SwordItem.createAttributes(Tiers.WOOD, 3, -2.4f))));

    public static final DeferredItem<Item> GOLD_HAMMER =ITEMS.register("gold_hammer",
            () -> new SwordItem(Tiers.GOLD,
                    new Item.Properties().fireResistant().attributes(SwordItem.createAttributes(Tiers.GOLD, 3, -2.4f))));

    public static final DeferredItem<Item> DIAMOND_HAMMER =ITEMS.register("diamond_hammer",
            () -> new SwordItem(Tiers.DIAMOND,
                    new Item.Properties().fireResistant().attributes(SwordItem.createAttributes(Tiers.DIAMOND, 3, -2.4f))));

    public static final DeferredItem<Item> STONE_HAMMER =ITEMS.register("stone_hammer",
            () -> new SwordItem(Tiers.STONE,
                    new Item.Properties().fireResistant().attributes(SwordItem.createAttributes(Tiers.STONE, 3, -2.4f))));

    public static final DeferredItem<Item> IRON_HAMMER =ITEMS.register("iron_hammer",
            () -> new SwordItem(Tiers.IRON,
                    new Item.Properties().fireResistant().attributes(SwordItem.createAttributes(Tiers.IRON, 3, -2.4f))));

    public static final DeferredItem<Item> NETHERITE_HAMMER =ITEMS.register("netherite_hammer",
            () -> new SwordItem(Tiers.NETHERITE,
                    new Item.Properties().fireResistant().attributes(SwordItem.createAttributes(Tiers.NETHERITE, 3, -2.4f))));

    //Tools

    public static final DeferredItem<Item> ELECTRIKE_SWORD = ITEMS.register("electrike_sword",
            () -> new SwordItem(ModToolTiers.ELECTRIKE,
                    new Item.Properties().fireResistant().attributes(SwordItem.createAttributes(ModToolTiers.ELECTRIKE, 3, -2.4f))));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}