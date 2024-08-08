package net.zuperz.neotech.recipe;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.zuperz.neotech.NeoTech;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, NeoTech.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, HardAnvilRecipe.Serializer> HARD_ANVIL_SERIALIZER =
            SERIALIZERS.register("hard_anvil", () -> HardAnvilRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}