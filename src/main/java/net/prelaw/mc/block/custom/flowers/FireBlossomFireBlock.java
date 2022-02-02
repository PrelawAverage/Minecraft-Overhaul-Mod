package net.prelaw.mc.block.custom.flowers;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
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

public class FireBlossomFireBlock extends FlowerBlock {
    public FireBlossomFireBlock(StatusEffect effect, int i, Settings settings) {
        super(effect, 8, settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return super.canPlantOnTop(floor, world, pos)
                || floor.isOf(Blocks.NETHERRACK)
                || floor.isOf(Blocks.SOUL_SOIL)
                || floor.isOf(Blocks.WARPED_NYLIUM)
                || floor.isOf(Blocks.CRIMSON_NYLIUM)
                || floor.isOf(Blocks.SOUL_SAND);
    }

    // This Method is a copy of the wither rose method, it spawns flame particles in periodically.
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        VoxelShape voxelShape = this.getOutlineShape(state, world, pos, ShapeContext.absent());
        Vec3d vec3d = voxelShape.getBoundingBox().getCenter();
        double d = (double)pos.getX() + vec3d.x;
        double e = (double)pos.getZ() + vec3d.z;
        for (int i = 0; i < 1; ++i) {
            if (!random.nextBoolean()) continue;
            world.addParticle(ParticleTypes.FLAME, d + random.nextDouble() / 5.0, (double)pos.getY() + (1 - random.nextDouble()), e + random.nextDouble() / 5.0, 0.0, 0.0, 0.0);
        }
    }

    // This Method will test if the Block is in a Biome that is cold to die.
    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getLightLevel(LightType.BLOCK, pos) > 11 || world.getDimension().isUltrawarm() || world.getBiome(pos).isHot(pos)) {
            this.die(state, world, pos);
        }
    }
    protected void die(BlockState state, World world, BlockPos pos) {
        world.removeBlock(pos, false);
        world.setBlockState(pos, ModBlocks.FIRE_BLOSSOM_DEAD.getDefaultState());
    }

    // This Method will make the Fire Blossom burn Entities.
    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!entity.isFireImmune() && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)entity)) {
            entity.damage(DamageSource.IN_FIRE, 2);
        }
        super.onEntityCollision(state, world, pos, entity);
    }
}
