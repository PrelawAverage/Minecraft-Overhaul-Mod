package net.prelaw.mc.block.custom.decoration;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.*;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.prelaw.mc.block.entity.ModBlockEntities;
import org.jetbrains.annotations.Nullable;

import java.util.Random;
import java.util.stream.Stream;

public class DyeVatBlock extends HorizontalFacingBlock {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public DyeVatBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.createCuboidShape(0, 4, 0, 2, 16, 16),
            Block.createCuboidShape(14, 4, 0, 16, 16, 16),
            Block.createCuboidShape(2, 4, 14, 14, 16, 16),
            Block.createCuboidShape(2, 4, 0, 14, 16, 2),
            Block.createCuboidShape(0, 0, 0, 16, 4, 16),
            Block.createCuboidShape(11, 18, 13, 13, 20, 16),
            Block.createCuboidShape(10, 16, 13, 12, 18, 16),
            Block.createCuboidShape(12, 16, 13, 14, 18, 16),
            Block.createCuboidShape(7, 19, 7, 9, 20, 9),
            Block.createCuboidShape(7, 20, 7, 9, 22, 14),
            Block.createCuboidShape(7, 16, 14, 9, 22, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.createCuboidShape(0, 4, 0, 16, 16, 2),
            Block.createCuboidShape(0, 4, 14, 16, 16, 16),
            Block.createCuboidShape(0, 4, 2, 2, 16, 14),
            Block.createCuboidShape(14, 4, 2, 16, 16, 14),
            Block.createCuboidShape(0, 0, 0, 16, 4, 16),
            Block.createCuboidShape(0, 18, 11, 3, 20, 13),
            Block.createCuboidShape(0, 16, 10, 3, 18, 12),
            Block.createCuboidShape(0, 16, 12, 3, 18, 14),
            Block.createCuboidShape(7, 19, 7, 9, 20, 9),
            Block.createCuboidShape(2, 20, 7, 9, 22, 9),
            Block.createCuboidShape(0, 16, 7, 2, 22, 9)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.createCuboidShape(14, 4, 0, 16, 16, 16),
            Block.createCuboidShape(0, 4, 0, 2, 16, 16),
            Block.createCuboidShape(2, 4, 0, 14, 16, 2),
            Block.createCuboidShape(2, 4, 14, 14, 16, 16),
            Block.createCuboidShape(0, 0, 0, 16, 4, 16),
            Block.createCuboidShape(3, 18, 0, 5, 20, 3),
            Block.createCuboidShape(4, 16, 0, 6, 18, 3),
            Block.createCuboidShape(2, 16, 0, 4, 18, 3),
            Block.createCuboidShape(7, 19, 7, 9, 20, 9),
            Block.createCuboidShape(7, 20, 2, 9, 22, 9),
            Block.createCuboidShape(7, 16, 0, 9, 22, 2)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.createCuboidShape(0, 4, 14, 16, 16, 16),
            Block.createCuboidShape(0, 4, 0, 16, 16, 2),
            Block.createCuboidShape(14, 4, 2, 16, 16, 14),
            Block.createCuboidShape(0, 4, 2, 2, 16, 14),
            Block.createCuboidShape(0, 0, 0, 16, 4, 16),
            Block.createCuboidShape(13, 18, 3, 16, 20, 5),
            Block.createCuboidShape(13, 16, 4, 16, 18, 6),
            Block.createCuboidShape(13, 16, 2, 16, 18, 4),
            Block.createCuboidShape(7, 19, 7, 9, 20, 9),
            Block.createCuboidShape(7, 20, 7, 14, 22, 9),
            Block.createCuboidShape(14, 16, 7, 16, 22, 9)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            case EAST:
                return SHAPE_E;
            default:
                return SHAPE_N;
        }
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        double d = (double)pos.getX() + 0.5;
        double e = (double)pos.getY() + 1.1;
        double f = (double)pos.getZ() + 0.5;
        if (random.nextDouble() < 0.3) {
            world.addParticle(ParticleTypes.DRIPPING_WATER, d, e, f, 0.0, 0.0, 0.0);
        }
    }


}