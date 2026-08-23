/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.EntityBlock
 *  net.minecraft.world.level.block.RenderShape
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.material.FlowingFluid
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.thebrokenscript.brokencore.api.blocks.FluidControls
 *  net.thebrokenscript.brokencore.api.blocks.TickedBlock
 *  net.thebrokenscript.brokencore.api.dsl.BlockUtil
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.block;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thebrokenscript.block.entity.ShadowBugBlockEntity;
import net.thebrokenscript.brokencore.api.blocks.FluidControls;
import net.thebrokenscript.brokencore.api.blocks.TickedBlock;
import net.thebrokenscript.brokencore.api.dsl.BlockUtil;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.registry.TBSBlockEntities;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 .2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001.B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0014J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0014J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u000bH\u0014J \u0010\u001c\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J0\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0010H\u0014J0\u0010\"\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u000bH\u0016J(\u0010(\u001a\u00020\u001e2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020)2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010*\u001a\u00020+H\u0014J\u0018\u0010,\u001a\u00020-2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a8\u0006/"}, d2={"Lnet/thebrokenscript/block/ShadowBugBlock;", "Lnet/thebrokenscript/brokencore/api/blocks/TickedBlock;", "Lnet/minecraft/world/level/block/EntityBlock;", "Lnet/thebrokenscript/brokencore/api/blocks/FluidControls;", "properties", "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;", "<init>", "(Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)V", "skipRendering", "", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "adjacentBlockState", "side", "Lnet/minecraft/core/Direction;", "getLightBlock", "", "worldIn", "Lnet/minecraft/world/level/BlockGetter;", "pos", "Lnet/minecraft/core/BlockPos;", "getVisualShape", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "level", "context", "Lnet/minecraft/world/phys/shapes/CollisionContext;", "getRenderShape", "Lnet/minecraft/world/level/block/RenderShape;", "propagatesSkylightDown", "updateIndirectNeighbourShapes", "", "Lnet/minecraft/world/level/LevelAccessor;", "flags", "recursionLeft", "canFlow", "fluid", "Lnet/minecraft/world/level/material/FlowingFluid;", "direction", "targetPos", "targetState", "tick", "Lnet/minecraft/server/level/ServerLevel;", "random", "Lnet/minecraft/util/RandomSource;", "newBlockEntity", "Lnet/thebrokenscript/block/entity/ShadowBugBlockEntity;", "Companion", "thebrokenscript-common"})
public final class ShadowBugBlock
extends TickedBlock
implements EntityBlock,
FluidControls {
    @NotNull
    public static final Companion Companion = new Companion(null);

    public ShadowBugBlock(@NotNull BlockBehaviour.Properties properties) {
        Intrinsics.checkNotNullParameter((Object)properties, (String)"properties");
        super(properties, 60);
    }

    protected boolean skipRendering(@NotNull BlockState state, @NotNull BlockState adjacentBlockState, @NotNull Direction side) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)adjacentBlockState, (String)"adjacentBlockState");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        return adjacentBlockState.is((Block)this) || super.skipRendering(state, adjacentBlockState, side);
    }

    protected int getLightBlock(@NotNull BlockState state, @NotNull BlockGetter worldIn, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)worldIn, (String)"worldIn");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return 15;
    }

    @NotNull
    protected VoxelShape getVisualShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        VoxelShape voxelShape = Shapes.empty();
        Intrinsics.checkNotNullExpressionValue((Object)voxelShape, (String)"empty(...)");
        return voxelShape;
    }

    @NotNull
    protected RenderShape getRenderShape(@NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        return RenderShape.INVISIBLE;
    }

    protected boolean propagatesSkylightDown(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return state.getFluidState().isEmpty();
    }

    protected void updateIndirectNeighbourShapes(@NotNull BlockState state, @NotNull LevelAccessor level, @NotNull BlockPos pos, int flags, int recursionLeft) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
    }

    public boolean canFlow(@NotNull BlockGetter level, @NotNull FlowingFluid fluid, @NotNull Direction direction, @NotNull BlockPos targetPos, @NotNull BlockState targetState) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)fluid, (String)"fluid");
        Intrinsics.checkNotNullParameter((Object)direction, (String)"direction");
        Intrinsics.checkNotNullParameter((Object)targetPos, (String)"targetPos");
        Intrinsics.checkNotNullParameter((Object)targetState, (String)"targetState");
        return false;
    }

    protected void tick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        super.tick(state, level, pos, random);
        LevelAccessor levelAccessor = (LevelAccessor)level;
        Vec3 vec3 = pos.getCenter();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getCenter(...)");
        if (EntityFinder.hasEntitiesInRange((LevelAccessor)levelAccessor, Player.class, (Vec3)vec3, (Number)10.0)) {
            CompoundTag previousTag;
            BlockEntity be = level.getBlockEntity(pos);
            ShadowBugBlockEntity shadowBugBlockEntity = be instanceof ShadowBugBlockEntity ? (ShadowBugBlockEntity)be : null;
            BlockState previous = shadowBugBlockEntity != null ? shadowBugBlockEntity.getPreviousState() : null;
            ShadowBugBlockEntity shadowBugBlockEntity2 = be instanceof ShadowBugBlockEntity ? (ShadowBugBlockEntity)be : null;
            Object object = previousTag = shadowBugBlockEntity2 != null ? shadowBugBlockEntity2.getPreviousEntityTag() : null;
            if (previous != null) {
                level.setBlock(pos, previous, 3);
                if (previousTag != null) {
                    BlockEntity blockEntity = level.getBlockEntity(pos);
                    if (blockEntity != null) {
                        blockEntity.loadCustomOnly(previousTag, (HolderLookup.Provider)level.registryAccess());
                    }
                    BlockEntity blockEntity2 = level.getBlockEntity(pos);
                    if (blockEntity2 != null) {
                        BlockUtil.setDirty((BlockEntity)blockEntity2);
                    }
                }
            } else {
                level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
            }
        }
    }

    @NotNull
    public ShadowBugBlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        return (ShadowBugBlockEntity)TBSBlockEntities.SHADOW_BUG.create(pos, state);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/block/ShadowBugBlock$Companion;", "", "<init>", "()V", "setPreviousState", "Lnet/thebrokenscript/block/entity/ShadowBugBlockEntity;", "level", "Lnet/minecraft/world/level/BlockGetter;", "pos", "Lnet/minecraft/core/BlockPos;", "previous", "Lnet/minecraft/world/level/block/state/BlockState;", "prevTag", "Lnet/minecraft/nbt/CompoundTag;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final ShadowBugBlockEntity setPreviousState(@NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull BlockState previous, @Nullable CompoundTag prevTag) {
            BlockEntity blockEntity;
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
            Intrinsics.checkNotNullParameter((Object)previous, (String)"previous");
            BlockEntity blockEntity2 = level.getBlockEntity(pos);
            ShadowBugBlockEntity shadowBugBlockEntity = blockEntity2 instanceof ShadowBugBlockEntity ? (ShadowBugBlockEntity)blockEntity2 : null;
            if (shadowBugBlockEntity != null) {
                BlockEntity $this$setPreviousState_u24lambda_u240 = blockEntity2 = shadowBugBlockEntity;
                boolean bl = false;
                $this$setPreviousState_u24lambda_u240.setPrevious(previous);
                if (prevTag != null) {
                    $this$setPreviousState_u24lambda_u240.setPreviousTag(prevTag);
                }
                blockEntity = blockEntity2;
            } else {
                blockEntity = null;
            }
            return blockEntity;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

