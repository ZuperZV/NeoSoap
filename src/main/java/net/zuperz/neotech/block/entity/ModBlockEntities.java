package net.zuperz.neotech.block.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.zuperz.neotech.NeoTech;
import net.zuperz.neotech.block.ModBlocks;
import net.zuperz.neotech.block.entity.custom.HardAnvilBlockEntity;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, NeoTech.MOD_ID);

    public static final Supplier<BlockEntityType<HardAnvilBlockEntity>> HARD_ANVIL_BE =
            BLOCK_ENTITIES.register("hard_anvil_be", () -> BlockEntityType.Builder.of(
                    HardAnvilBlockEntity::new, ModBlocks.HARD_ANVIL.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}