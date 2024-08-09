package net.zuperz.neotech.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.zuperz.neotech.NeoTech;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.lang.reflect.Type;

public class HardAnvilRecipe implements Recipe<RecipeInput> {
    private final Ingredient input;
    private final ItemStack outputStack;

    public HardAnvilRecipe(Ingredient input, ItemStack outputStack) {
        this.input = input;
        this.outputStack = outputStack;
    }

    public HardAnvilRecipe(ItemStack itemStack, Integer integer, Ingredient ingredient) {
        this.outputStack = new ItemStack(itemStack.getItem(), integer);
        this.input = ingredient;
    }

    public Ingredient getInput() {
        return input;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> ingredients = NonNullList.create();
        ingredients.add(input);
        return ingredients;
    }

    @Override
    public boolean matches(RecipeInput recipeInput, Level level) {
        return this.input.test(recipeInput.getItem(0));
    }

    @Override
    public @NotNull ItemStack assemble(RecipeInput recipeInput, HolderLookup.Provider provider) {
        return this.outputStack.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public @NotNull ItemStack getResultItem(HolderLookup.Provider provider) {
        return this.outputStack.copy();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public ResourceLocation getId() {
        return ResourceLocation.fromNamespaceAndPath(NeoTech.MOD_ID, "hard_anvil");
    }


    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static final class Type implements RecipeType<HardAnvilRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "hard_anvil";
    }

    public static class Serializer implements RecipeSerializer<HardAnvilRecipe> {
        private Serializer() {}
        public static final Serializer INSTANCE = new Serializer();

        public static final ResourceLocation ID =
                ResourceLocation.fromNamespaceAndPath(NeoTech.MOD_ID, "hard_anvil");


        public static final MapCodec<HardAnvilRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                ItemStack.CODEC.fieldOf("outputItem").forGetter(recipe -> recipe.outputStack),
                Codec.INT.fieldOf("outputAmount").forGetter(recipe -> recipe.outputStack.getCount()),
                Ingredient.CODEC.fieldOf("inputItem").forGetter(HardAnvilRecipe::getInput)
        ).apply(instance, HardAnvilRecipe::new));


        public static final StreamCodec<RegistryFriendlyByteBuf, HardAnvilRecipe> STREAM_CODEC = StreamCodec.of(HardAnvilRecipe.Serializer::toNetwork, HardAnvilRecipe.Serializer::fromNetwork);

        public static HardAnvilRecipe fromNetwork(RegistryFriendlyByteBuf buf) {
            ItemStack output = ItemStack.STREAM_CODEC.decode(buf);
            Ingredient input = Ingredient.CONTENTS_STREAM_CODEC.decode(buf);
            return new HardAnvilRecipe(input, output);
        }

        public static void toNetwork(RegistryFriendlyByteBuf buf, HardAnvilRecipe recipe) {
            Ingredient.CONTENTS_STREAM_CODEC.encode(buf, recipe.input);
            ItemStack.STREAM_CODEC.encode(buf, recipe.outputStack);
        }

        @Override
        public @NotNull MapCodec<HardAnvilRecipe> codec() {
            return CODEC;
        }

        @Override
        public @NotNull StreamCodec<RegistryFriendlyByteBuf, HardAnvilRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}