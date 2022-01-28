package net.prelaw.mc.block.custom.flowers;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.GameRules;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.prelaw.mc.block.ModBlocks;

import java.util.Random;

public class PottedShiverLeafFlowerBlock extends FlowerPotBlock {
    public PottedShiverLeafFlowerBlock(Block content, Settings settings) {
        super(content, settings);
    }

    // This Method is a copy of the wither rose method, it spawns snow particles in periodically.
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        VoxelShape voxelShape = this.getOutlineShape(state, world, pos, ShapeContext.absent());
        Vec3d vec3d = voxelShape.getBoundingBox().getCenter();
        double d = (double)pos.getX() + vec3d.x;
        double e = (double)pos.getZ() + vec3d.z;
        for (int i = 0; i < 1; ++i) {
            if (!random.nextBoolean()) continue;
            world.addParticle(ParticleTypes.SNOWFLAKE, d + random.nextDouble() / 5.0, (double)pos.getY() + (1 - random.nextDouble()), e + random.nextDouble() / 5.0, 0.0, 0.0, 0.0);
        }
    }

    // This Method will test if the Block is in a Biome that is hot to die.
    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getLightLevel(LightType.BLOCK, pos) > 11 || world.getDimension().isUltrawarm() || world.getBiome(pos).isHot(pos)) {
            this.die(state, world, pos);
        }
    }
    protected void die(BlockState state, World world, BlockPos pos) {
        world.removeBlock(pos, false);
        world.setBlockState(pos, ModBlocks.SHIVER_LEAF_DEAD.getDefaultState());
    }

    // This Method will make the Shiverleaf freeze Entities.
    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!(entity instanceof LivingEntity) || entity.getBlockStateAtPos().isOf(this)) {
            entity.slowMovement(state, new Vec3d(0.9f, 1.5, 0.9f));
            if (world.isClient) {
                boolean bl;
                Random random = world.getRandom();
                boolean bl2 = bl = entity.lastRenderX != entity.getX() || entity.lastRenderZ != entity.getZ();
                if (bl && random.nextBoolean()) {
                    world.addParticle(ParticleTypes.SNOWFLAKE, entity.getX(), pos.getY() + 1, entity.getZ(), MathHelper.nextBetween(random, -1.0f, 1.0f) * 0.083333336f, 0.05f, MathHelper.nextBetween(random, -1.0f, 1.0f) * 0.083333336f);
                }
            }
        }
        entity.setInPowderSnow(true);
        if (!world.isClient) {
            if (entity.isOnFire() && (world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING) || entity instanceof PlayerEntity) && entity.canModifyAt(world, pos)) {
                world.breakBlock(pos, false);
            }
            entity.setOnFire(false);
        }
    }
}
