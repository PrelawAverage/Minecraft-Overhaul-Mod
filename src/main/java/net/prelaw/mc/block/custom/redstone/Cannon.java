package net.prelaw.mc.block.custom.redstone;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
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

import java.util.stream.Stream;

public class Cannon extends HorizontalFacingBlock {

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public Cannon(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.createCuboidShape(-2, 0, -4, 0, 5, 0),
            Block.createCuboidShape(0, 0, 0, 16, 16, 16),
            Block.createCuboidShape(2, 2, 16, 14, 14, 25),
            Block.createCuboidShape(1, 1, 25, 15, 15, 26),
            Block.createCuboidShape(0, 0, -4, 16, 1, 0),
            Block.createCuboidShape(16, 0, 0, 18, 5, 16),
            Block.createCuboidShape(16, 5, 0, 18, 10, 15),
            Block.createCuboidShape(16, 0, -4, 18, 5, 0),
            Block.createCuboidShape(-2, 0, 0, 0, 5, 16),
            Block.createCuboidShape(-2, 5, 0, 0, 10, 15)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.createCuboidShape(16, 0, -2, 20, 5, 0),
            Block.createCuboidShape(0, 0, 0, 16, 16, 16),
            Block.createCuboidShape(-9, 2, 2, 0, 14, 14),
            Block.createCuboidShape(-10, 1, 1, -9, 15, 15),
            Block.createCuboidShape(16, 0, 0, 20, 1, 16),
            Block.createCuboidShape(0, 0, 16, 16, 5, 18),
            Block.createCuboidShape(1, 5, 16, 16, 10, 18),
            Block.createCuboidShape(16, 0, 16, 20, 5, 18),
            Block.createCuboidShape(0, 0, -2, 16, 5, 0),
            Block.createCuboidShape(1, 5, -2, 16, 10, 0)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.createCuboidShape(16, 0, 16, 18, 5, 20),
            Block.createCuboidShape(0, 0, 0, 16, 16, 16),
            Block.createCuboidShape(2, 2, -9, 14, 14, 0),
            Block.createCuboidShape(1, 1, -10, 15, 15, -9),
            Block.createCuboidShape(0, 0, 16, 16, 1, 20),
            Block.createCuboidShape(-2, 0, 0, 0, 5, 16),
            Block.createCuboidShape(-2, 5, 1, 0, 10, 16),
            Block.createCuboidShape(-2, 0, 16, 0, 5, 20),
            Block.createCuboidShape(16, 0, 0, 18, 5, 16),
            Block.createCuboidShape(16, 5, 1, 18, 10, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.createCuboidShape(-4, 0, 16, 0, 5, 18),
            Block.createCuboidShape(0, 0, 0, 16, 16, 16),
            Block.createCuboidShape(16, 2, 2, 25, 14, 14),
            Block.createCuboidShape(25, 1, 1, 26, 15, 15),
            Block.createCuboidShape(-4, 0, 0, 0, 1, 16),
            Block.createCuboidShape(0, 0, -2, 16, 5, 0),
            Block.createCuboidShape(0, 5, -2, 15, 10, 0),
            Block.createCuboidShape(-4, 0, -2, 0, 5, 0),
            Block.createCuboidShape(0, 0, 16, 16, 5, 18),
            Block.createCuboidShape(0, 5, 16, 15, 10, 18)
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
    protected void spawnBreakParticles(World world, PlayerEntity player, BlockPos pos, BlockState state) {
        super.spawnBreakParticles(world, player, pos, state);
    }
}
