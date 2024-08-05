package net.zuperz.neotech.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.zuperz.neotech.NeoTech;
import net.zuperz.neotech.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, NeoTech.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.STEEL_INGOT.get());
        basicItem(ModItems.RAW_STEEL.get());

        basicItem(ModItems.STEEL_GEAR.get());
        basicItem(ModItems.AMETHYST_GEAR.get());
        basicItem(ModItems.COPPER_GEAR.get());
        basicItem(ModItems.DIAMOND_GEAR.get());
        basicItem(ModItems.EMERALD_GEAR.get());
        basicItem(ModItems.GOLD_GEAR.get());
        basicItem(ModItems.IRON_GEAR.get());
        basicItem(ModItems.LAPIS_GEAR.get());
        basicItem(ModItems.NETHERITE_GEAR.get());

        basicItem(ModItems.STEEL_PLATE.get());
        basicItem(ModItems.AMETHYST_PLATE.get());
        basicItem(ModItems.COPPER_PLATE.get());
        basicItem(ModItems.DIAMOND_PLATE.get());
        basicItem(ModItems.EMERALD_PLATE.get());
        basicItem(ModItems.GOLD_PLATE.get());
        basicItem(ModItems.IRON_PLATE.get());
        basicItem(ModItems.LAPIS_PLATE.get());
        basicItem(ModItems.NETHERITE_PLATE.get());

        handheldItem(ModItems.WOODEN_HAMMER);
        handheldItem(ModItems.STONE_HAMMER);
        handheldItem(ModItems.GOLD_HAMMER);
        handheldItem(ModItems.IRON_HAMMER);
        handheldItem(ModItems.DIAMOND_HAMMER);
        handheldItem(ModItems.NETHERITE_HAMMER);

        handheldItem(ModItems.ELECTRIKE_SWORD);
    }


    private ItemModelBuilder handheldItem(DeferredItem<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(NeoTech.MOD_ID, "item/" + item.getId().getPath()));
    }
}