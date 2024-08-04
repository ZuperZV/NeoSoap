package net.zuperz.neotech.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.zuperz.neotech.NeoTech;
import net.zuperz.neotech.block.ModBlocks;
import net.zuperz.neotech.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> STEEL_SMELTABLES = List.of(ModItems.RAW_STEEL,
                ModBlocks.STEEL_ORE, ModBlocks.STEEL_DEEPSLATE_ORE);

        oreSmelting(pRecipeOutput, STEEL_SMELTABLES, RecipeCategory.MISC, ModItems.STEEL_INGOT.get(), 0.25f, 200, "steel_ingot");
        oreBlasting(pRecipeOutput, STEEL_SMELTABLES, RecipeCategory.MISC, ModItems.STEEL_INGOT.get(), 0.25f, 100, "steel_ingot");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STEEL_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.STEEL_INGOT.get())
                .unlockedBy("has_steel_ingot", has(ModItems.STEEL_INGOT.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STEEL_INGOT.get(), 9)
                .requires(ModBlocks.STEEL_BLOCK.get())
                .unlockedBy("has_steel_block", has(ModBlocks.STEEL_BLOCK.get())).save(pRecipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_STEEL_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RAW_STEEL.get())
                .unlockedBy("has_raw_steel", has(ModItems.RAW_STEEL.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_STEEL.get(), 9)
                .requires(ModBlocks.RAW_STEEL_BLOCK.get())
                .unlockedBy("has_raw_steel_block", has(ModBlocks.RAW_STEEL_BLOCK.get())).save(pRecipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STEEL_GEAR.get())
                .pattern(" A ")
                .pattern("A A")
                .pattern(" A ")
                .define('A', ModItems.STEEL_INGOT.get())
                .unlockedBy("has_steel", has(ModItems.STEEL_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AMETHYST_GEAR.get())
                .pattern(" A ")
                .pattern("A A")
                .pattern(" A ")
                .define('A',Items.AMETHYST_SHARD)
                .unlockedBy("has_amethyst", has(Items.AMETHYST_SHARD)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COPPER_GEAR.get())
                .pattern(" A ")
                .pattern("A A")
                .pattern(" A ")
                .define('A',Items.COPPER_INGOT)
                .unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIAMOND_GEAR.get())
                .pattern(" A ")
                .pattern("A A")
                .pattern(" A ")
                .define('A',Items.DIAMOND)
                .unlockedBy("has_diamond", has(Items.DIAMOND)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMERALD_GEAR.get())
                .pattern(" A ")
                .pattern("A A")
                .pattern(" A ")
                .define('A',Items.EMERALD)
                .unlockedBy("has_emerald", has(Items.EMERALD)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GOLD_GEAR.get())
                .pattern(" A ")
                .pattern("A A")
                .pattern(" A ")
                .define('A',Items.GOLD_INGOT)
                .unlockedBy("has_diamond", has(Items.GOLD_INGOT)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.IRON_GEAR.get())
                .pattern(" A ")
                .pattern("A A")
                .pattern(" A ")
                .define('A',Items.IRON_INGOT)
                .unlockedBy("has_iron", has(Items.IRON_INGOT)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LAPIS_GEAR.get())
                .pattern(" A ")
                .pattern("A A")
                .pattern(" A ")
                .define('A',Items.LAPIS_LAZULI)
                .unlockedBy("has_lapis", has(Items.LAPIS_LAZULI)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NETHERITE_GEAR.get())
                .pattern(" A ")
                .pattern("A A")
                .pattern(" A ")
                .define('A',Items.NETHERITE_INGOT)
                .unlockedBy("has_netherite", has(Items.NETHERITE_INGOT)).save(pRecipeOutput);

    }


    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, NeoTech.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}