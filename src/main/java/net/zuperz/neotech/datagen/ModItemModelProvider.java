package net.zuperz.neotech.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
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
    }

    public void buttonItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(NeoTech.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(NeoTech.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(NeoTech.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

}