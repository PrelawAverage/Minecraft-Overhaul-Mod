package net.prelaw.mc.block.custom.decoration;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Random;
import java.util.stream.Stream;

public class ShipJar extends HorizontalFacingBlock {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public ShipJar(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.createCuboidShape(5, 1, 8, 12, 5, 8),
            Block.createCuboidShape(7, 2, 7, 7, 4, 9),
            Block.createCuboidShape(8, 2, 6.5, 8, 5, 9.5),
            Block.createCuboidShape(9.5, 2, 6.5, 9.5, 4, 9.5),
            Block.createCuboidShape(5, 1, 5.5, 13, 6, 10.5),
            Block.createCuboidShape(3, 2, 6.5, 5, 5, 9.5),
            Block.createCuboidShape(6, 0, 6.5, 7, 1, 9.5),
            Block.createCuboidShape(11, 0, 6.5, 12, 1, 9.5),
            Block.createCuboidShape(3, 1.5, 6, 4, 5.5, 10)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.createCuboidShape(8, 1, 5, 8, 5, 12),
            Block.createCuboidShape(7, 2, 7, 9, 4, 7),
            Block.createCuboidShape(6.5, 2, 8, 9.5, 5, 8),
            Block.createCuboidShape(6.5, 2, 9.5, 9.5, 4, 9.5),
            Block.createCuboidShape(5.5, 1, 5, 10.5, 6, 13),
            Block.createCuboidShape(6.5, 2, 3, 9.5, 5, 5),
            Block.createCuboidShape(6.5, 0, 6, 9.5, 1, 7),
            Block.createCuboidShape(6.5, 0, 11, 9.5, 1, 12),
            Block.createCuboidShape(6, 1.5, 3, 10, 5.5, 4)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.createCuboidShape(4, 1, 8, 11, 5, 8),
            Block.createCuboidShape(9, 2, 7, 9, 4, 9),
            Block.createCuboidShape(8, 2, 6.5, 8, 5, 9.5),
            Block.createCuboidShape(6.5, 2, 6.5, 6.5, 4, 9.5),
            Block.createCuboidShape(3, 1, 5.5, 11, 6, 10.5),
            Block.createCuboidShape(11, 2, 6.5, 13, 5, 9.5),
            Block.createCuboidShape(9, 0, 6.5, 10, 1, 9.5),
            Block.createCuboidShape(4, 0, 6.5, 5, 1, 9.5),
            Block.createCuboidShape(12, 1.5, 6, 13, 5.5, 10)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.createCuboidShape(8, 1, 4, 8, 5, 11),
            Block.createCuboidShape(7, 2, 9, 9, 4, 9),
            Block.createCuboidShape(6.5, 2, 8, 9.5, 5, 8),
            Block.createCuboidShape(6.5, 2, 6.5, 9.5, 4, 6.5),
            Block.createCuboidShape(5.5, 1, 3, 10.5, 6, 11),
            Block.createCuboidShape(6.5, 2, 11, 9.5, 5, 13),
            Block.createCuboidShape(6.5, 0, 9, 9.5, 1, 10),
            Block.createCuboidShape(6.5, 0, 4, 9.5, 1, 5),
            Block.createCuboidShape(6, 1.5, 12, 10, 5.5, 13)
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

    @Override
    protected void spawnBreakParticles(World world, PlayerEntity player, BlockPos pos, BlockState state) {
        super.spawnBreakParticles(world, player, pos, state);
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
}