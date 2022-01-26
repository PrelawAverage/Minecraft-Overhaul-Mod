package net.prelaw.mc.item.custom.misc;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ClickType;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.prelaw.mc.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.List;

// This Class will handle all Old Bundle Item Properties
public class OldBundleItems extends Item {
    public OldBundleItems(Settings settings) {
        super(settings);
    }

    // This is the right-click function that will open the bundle a give random loot to the player.
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        // Creating a itemStack data type to get what is in the users hand.
        ItemStack itemStack = user.getStackInHand(hand);
        // This will text if the player is not in creative mode.
        if (!user.isCreative()) {
            // Removes the item from the player (DONE)
            itemStack.decrement(1);
        }
        // Plays a sound of the bag opening (DONE)
        world.playSoundFromEntity(user, user, SoundEvents.BLOCK_BEEHIVE_ENTER, SoundCategory.PLAYERS, 1, 1);
        return super.use(world, user, hand);
    }

    // This adds a ToolTip to the item. When the player in is their inventory and hovers over the item, they will see the second tool tip, when they hold shift, the second will pop up (DONE)
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
            tooltip.add(new TranslatableText("item.minecraft_overhaul.old_bundle_item.tooltip"));
    }

}
