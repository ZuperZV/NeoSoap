package net.zuperz.neotech.item.custom;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.zuperz.neotech.item.ModItems;
import net.zuperz.neotech.util.ModTags;

public class ModToolTiers {
    public static final Tier ELECTRIKE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_ELECTRIKE_TOOL,
            600, 4f, 1.5f, 20,
            () -> Ingredient.of(ModItems.ELECTRIKE_SWORD));
}