package net.zuperz.neotech.item.custom;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.zuperz.neotech.NeoTech;
import net.zuperz.neotech.block.ModBlocks;
import net.zuperz.neotech.item.ModItems;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NeoTech.MOD_ID);

    public static final Supplier<CreativeModeTab> NEO_TECH_TAB =
            CREATIVE_MODE_TABS.register("neo_tech_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.neo_tech.neo_tech_tab"))
                    .icon(() -> new ItemStack(ModItems.STEEL_INGOT.get()))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.STEEL_INGOT);
                        pOutput.accept(ModItems.RAW_STEEL);

                        pOutput.accept(ModItems.STEEL_GEAR);
                        pOutput.accept(ModItems.AMETHYST_GEAR);
                        pOutput.accept(ModItems.COPPER_GEAR);
                        pOutput.accept(ModItems.DIAMOND_GEAR);
                        pOutput.accept(ModItems.EMERALD_GEAR);
                        pOutput.accept(ModItems.GOLD_GEAR);
                        pOutput.accept(ModItems.IRON_GEAR);
                        pOutput.accept(ModItems.LAPIS_GEAR);
                        pOutput.accept(ModItems.NETHERITE_GEAR);
                    }).build());

    public static final Supplier<CreativeModeTab> NEO_TECH_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("neo_tech_blocks_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.neo_tech.neo_tech_blocks_tab"))
                    .icon(() -> new ItemStack(ModBlocks.STEEL_ORE.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(NeoTech.MOD_ID, "neo_tech_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.STEEL_BLOCK);
                        pOutput.accept(ModBlocks.RAW_STEEL_BLOCK);

                        pOutput.accept(ModBlocks.STEEL_ORE);
                        pOutput.accept(ModBlocks.STEEL_DEEPSLATE_ORE);

                        pOutput.accept(ModBlocks.HARD_ANVIL);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
