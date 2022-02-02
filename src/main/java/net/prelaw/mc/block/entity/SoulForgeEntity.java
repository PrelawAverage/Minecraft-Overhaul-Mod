package net.prelaw.mc.block.entity;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.prelaw.mc.block.custom.decoration.SoulForgeBlock;
import net.prelaw.mc.item.inventory.ImplementedInventory;
import net.prelaw.mc.recipe.SoulForgeRecipe;
import net.prelaw.mc.screen.SoulForgeScreenHandler;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class SoulForgeEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {

    // This is our inventory of the block
    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(4, ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;
    private int fuelTime = 0;
    private int maxFuelTime = 0;

    public SoulForgeEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SOUL_FORGE, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0: return SoulForgeEntity.this.progress;
                    case 1: return SoulForgeEntity.this.maxProgress;
                    case 2: return SoulForgeEntity.this.fuelTime;
                    case 3: return SoulForgeEntity.this.maxFuelTime;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: SoulForgeEntity.this.progress = value; break;
                    case 1: SoulForgeEntity.this.maxProgress = value; break;
                    case 2: SoulForgeEntity.this.fuelTime = value; break;
                    case 3: SoulForgeEntity.this.maxFuelTime = value; break;
                }
            }

            public int size() {
                return 4;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return new LiteralText("Soul Forge");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new SoulForgeScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("soul_forge.progress", progress);
        nbt.putInt("soul_forge.fuelTime", fuelTime);
        nbt.putInt("soul_forge.maxFuelTime", maxFuelTime);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("soul_forge.progress");
        fuelTime = nbt.getInt("soul_forge.fuelTime");
        maxFuelTime = nbt.getInt("soul_forge.maxFuelTime");
    }

    // Sets fuel time
    private void consumeFuel() {
        if(!getStack(0).isEmpty()) {
            this.fuelTime = FuelRegistry.INSTANCE.get(this.removeStack(0, 1).getItem());
            this.maxFuelTime = this.fuelTime;
        }
    }

    // On tick
    public static void tick(World world, BlockPos pos, BlockState state, SoulForgeEntity entity) {

        // If consuming fuel is true, substract fuelTime
        if (isConsumingFuel(entity)) {
            // Fuel time decreases
            entity.fuelTime--;
            state = (BlockState)state.with(SoulForgeBlock.LIT, true);
            world.setBlockState(pos, state, Block.NOTIFY_ALL);
        }

        // This checks if there is a recipe, and fuel and not consuming fuel, consume fuel. (Start smelting)
        if(hasRecipe(entity)) {
            if(hasFuelInFuelSlot(entity) && !isConsumingFuel(entity)) {
                entity.consumeFuel();
            }
            // Crafting will finally happen
            if(isConsumingFuel(entity)) {
                entity.progress++;
                if(entity.progress > entity.maxProgress) {
                    craftItem(entity);
                }
            } else {
                entity.progress--;
                state = (BlockState)state.with(SoulForgeBlock.LIT, false);
                world.setBlockState(pos, state, Block.NOTIFY_ALL);
            }
        } else {
            entity.resetProgress();
        }
    }

    private static boolean hasFuelInFuelSlot(SoulForgeEntity entity) {
        return !entity.getStack(0).isEmpty();
    }

    // Return true if fuel is actively burning
    private static boolean isConsumingFuel(SoulForgeEntity entity) {
        return entity.fuelTime > 0;
    }

    private static boolean hasRecipe(SoulForgeEntity entity) {
        // Getting World
        World world = entity.world;
        // Creating a simple inventory to the size of the entity's inventory.
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        // Setting every stack in our entity, to our SimpleInventory inventory
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        // Is there a match
        Optional<SoulForgeRecipe> match = world.getRecipeManager()
                .getFirstMatch(SoulForgeRecipe.Type.INSTANCE, inventory, world);

        // Return if there is a mathc, and there is space for the output
        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput());
    }

    // How the crafting of the item happens
    private static void craftItem(SoulForgeEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<SoulForgeRecipe> match = world.getRecipeManager()
                .getFirstMatch(SoulForgeRecipe.Type.INSTANCE, inventory, world);

        // Checking once again if there is a recipe
        if(match.isPresent()) {
            // Remove items
            entity.removeStack(1,1);
            entity.removeStack(2,1);

            // Add result, if there is nothing, set to 1, if there is something in there, add 1.
            entity.setStack(3, new ItemStack(match.get().getOutput().getItem(),
                    entity.getStack(3).getCount() + 1));

            // Reset the entire crafting process.
            entity.resetProgress();
        }
    }

    // Reset
    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, ItemStack output) {
        return inventory.getStack(3).getItem() == output.getItem() || inventory.getStack(3).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(3).getMaxCount() > inventory.getStack(3).getCount();
    }

}
