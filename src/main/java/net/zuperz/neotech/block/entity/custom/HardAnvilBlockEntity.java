package net.zuperz.neotech.block.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.crafting.RecipeInput;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.ItemCapability;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.zuperz.neotech.NeoTech;
import net.zuperz.neotech.block.entity.ModBlockEntities;
import net.zuperz.neotech.recipe.HardAnvilRecipe;
import net.zuperz.neotech.recipe.ItemHandlerRecipeInput;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class HardAnvilBlockEntity extends BlockEntity {
    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;
    private static final int SLOTS = 2;

    private final ItemStackHandler itemHandler = new ItemStackHandler(SLOTS) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (level != null) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), Block.UPDATE_ALL);
            }
        }
    };

    private final Optional<ItemStackHandler> optional = Optional.of(this.itemHandler);
    private int progress = 0;
    private final int maxProgress = 100;

    public HardAnvilBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.HARD_ANVIL_BE.get(), pos, state);
    }

    public ItemInteractionResult interact(@NotNull ItemStack stack, Player player, InteractionHand hand, BlockState state, Level level, BlockPos pos) {
        // Interaction logic for the HardAnvil block entity
        return ItemInteractionResult.SUCCESS;
    }

    public void tick(Level level, BlockPos pos, BlockState state) {
        if (isOutputSlotEmptyOrReceivable() && hasRecipe()) {
            increaseCraftingProcess();
            setChanged(level, getBlockPos(), getBlockState());

            if (hasProgressFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private void craftItem() {
        Optional<HardAnvilRecipe> recipe = getCurrentRecipe();
        ItemStack resultItem = recipe.get().getResultItem(getLevel().registryAccess());

        this.itemHandler.extractItem(INPUT_SLOT, 1, false);
        this.itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(resultItem.getItem(),
                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + resultItem.getCount()));
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private boolean hasProgressFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProcess() {
        this.progress++;
    }

    private boolean hasRecipe() {
        Optional<HardAnvilRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()) {
            return false;
        }
        ItemStack resultItem = recipe.get().getResultItem(getLevel().registryAccess());

        return canInsertAmountIntoOutputSlot(resultItem.getCount())
                && canInsertItemIntoOutputSlot(resultItem.getItem());
    }

    private Optional<HardAnvilRecipe> getCurrentRecipe() {
        ItemHandlerRecipeInput recipeInput = new ItemHandlerRecipeInput(this.itemHandler);
        Optional<RecipeHolder<HardAnvilRecipe>> recipeHolder = this.level.getRecipeManager().getRecipeFor(HardAnvilRecipe.Type.INSTANCE, recipeInput, level);

        // Extract the HardAnvilRecipe from the RecipeHolder
        return recipeHolder.map(RecipeHolder::value);
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() || this.itemHandler.getStackInSlot(OUTPUT_SLOT).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize() >=
                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + count;
    }

    private boolean isOutputSlotEmptyOrReceivable() {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() ||
                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() < this.itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
    }

    public ItemStack getItem(int pSlot) {
        return itemHandler.getStackInSlot(pSlot);
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    protected void loadAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider provider) {
        super.loadAdditional(tag, provider);
        loadClientData(tag, provider);
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider provider) {
        super.saveAdditional(tag, provider);
        saveClientData(tag, provider);
    }

    private void saveClientData(CompoundTag tag, HolderLookup.Provider provider) {
        CompoundTag Data = new CompoundTag();
        Data.put("Inventory", this.itemHandler.serializeNBT(provider));
        tag.put(NeoTech.MOD_ID, Data);
    }

    private void loadClientData(CompoundTag tag, HolderLookup.Provider provider) {
        CompoundTag Data = tag.getCompound(NeoTech.MOD_ID);
        if (Data.contains("Inventory")) {
            this.itemHandler.deserializeNBT(provider, Data.getCompound("Inventory"));
        }
    }

    @Override
    public @NotNull CompoundTag getUpdateTag(HolderLookup.@NotNull Provider provider) {
        CompoundTag tag = super.getUpdateTag(provider);
        saveClientData(tag, provider);
        return tag;
    }

    @Override
    public void handleUpdateTag(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider provider) {
        loadClientData(tag, provider);
    }

    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void onDataPacket(@NotNull Connection connection, ClientboundBlockEntityDataPacket packet, HolderLookup.@NotNull Provider provider) {
        CompoundTag tag = packet.getTag();
        handleUpdateTag(tag, provider);
    }
}
