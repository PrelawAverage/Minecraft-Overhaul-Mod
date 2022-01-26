package net.prelaw.mc.item.custom.tools;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.prelaw.mc.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class OreDetectorItem extends Item {

    public OreDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        // First Testing if on Client, we want this because this is a clientside function.
        if(context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= positionClicked.getY(); i++) {
                Block blockBelowClicked = context.getWorld().getBlockState(positionClicked.down(i)).getBlock();

                if(isValuableBlock(blockBelowClicked)) {
                    outputOreCoordinates(positionClicked, player, blockBelowClicked, positionClicked.getY() - i);
                    foundBlock = true;
                    break;
                }
            }
            if (!foundBlock) {
                player.sendMessage(new TranslatableText("item.minecraft_overhaul.ore_detector.no_ore_found"), true);
            }
        }

        // This will damage the item by 1, and also sets what animation to display when the item breaks
        context.getStack().damage(1, context.getPlayer(),
                (player) -> player.sendToolBreakStatus(player.getActiveHand()));

        return super.useOnBlock(context);
    }

    // This Method will send a message to the player of the coordinates of the ore found.
    private void outputOreCoordinates(BlockPos positionClicked, PlayerEntity player, Block blockBelowClicked, int yFound) {
        player.sendMessage(new LiteralText("Found " + blockBelowClicked.asItem().getName().getString() + " at " + positionClicked.getX() + ", " + yFound + ", " + positionClicked.getZ()), true);
    }

    // This is a Method that will return true if "block" is equal to any of the blocks listed below.
    private boolean isValuableBlock(Block block) {
        return block == Blocks.IRON_ORE || block == Blocks.COPPER_ORE || block == Blocks.GOLD_ORE || block == ModBlocks.SILVER_ORE;
    }

}
