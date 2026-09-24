/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Position
 *  net.minecraft.core.Vec3i
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.BaseEntityBlock
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Portal
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.chunk.ChunkAccess
 *  net.minecraft.world.level.portal.DimensionTransition
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.BooleanOp
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.block;

import com.mojang.serialization.MapCodec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Portal;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thebrokenscript.TheBrokenScript;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.registry.TBSBlockEntities;
import net.thebrokenscript.registry.TBSDimensions;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0014J \u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J(\u0010\u0016\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J(\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\nH\u0016J\u0012\u0010$\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010%H\u0014J \u0010(\u001a\u00020)2\u0006\u0010\u0018\u001a\u00020*2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00000%\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010'\u00a8\u0006+"}, d2={"Lnet/thebrokenscript/block/ExitBlock;", "Lnet/minecraft/world/level/block/BaseEntityBlock;", "Lnet/minecraft/world/level/block/Portal;", "properties", "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;", "<init>", "(Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)V", "skipRendering", "", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "adjacentBlockState", "side", "Lnet/minecraft/core/Direction;", "propagatesSkylightDown", "reader", "Lnet/minecraft/world/level/BlockGetter;", "pos", "Lnet/minecraft/core/BlockPos;", "getLightBlock", "", "worldIn", "getVisualShape", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "level", "context", "Lnet/minecraft/world/phys/shapes/CollisionContext;", "entityInside", "", "Lnet/minecraft/world/level/Level;", "entity", "Lnet/minecraft/world/entity/Entity;", "newBlockEntity", "Lnet/minecraft/world/level/block/entity/BlockEntity;", "p0", "p1", "codec", "Lcom/mojang/serialization/MapCodec;", "getCodec", "()Lcom/mojang/serialization/MapCodec;", "getPortalDestination", "Lnet/minecraft/world/level/portal/DimensionTransition;", "Lnet/minecraft/server/level/ServerLevel;", "thebrokenscript-common"})
public final class ExitBlock
extends BaseEntityBlock
implements Portal {
    @NotNull
    private final MapCodec<ExitBlock> codec;

    public ExitBlock(@NotNull BlockBehaviour.Properties properties) {
        Intrinsics.checkNotNullParameter((Object)properties, (String)"properties");
        super(properties);
        MapCodec mapCodec = BaseEntityBlock.simpleCodec(ExitBlock::codec$lambda$0);
        Intrinsics.checkNotNullExpressionValue((Object)mapCodec, (String)"simpleCodec(...)");
        this.codec = mapCodec;
    }

    protected boolean skipRendering(@NotNull BlockState state, @NotNull BlockState adjacentBlockState, @NotNull Direction side) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)adjacentBlockState, (String)"adjacentBlockState");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        return adjacentBlockState.is((Block)this) || super.skipRendering(state, adjacentBlockState, side);
    }

    protected boolean propagatesSkylightDown(@NotNull BlockState state, @NotNull BlockGetter reader, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)reader, (String)"reader");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return true;
    }

    protected int getLightBlock(@NotNull BlockState state, @NotNull BlockGetter worldIn, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)worldIn, (String)"worldIn");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return 0;
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

    protected void entityInside(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Entity entity) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        if (entity.canUsePortal(false) && Shapes.joinIsNotEmpty((VoxelShape)Shapes.create((AABB)entity.getBoundingBox().move(PositionUtil.negate((BlockPos)pos))), (VoxelShape)state.getShape((BlockGetter)level, pos), (BooleanOp)BooleanOp.AND)) {
            ResourceKey dimensionEntity = entity.level().dimension();
            if (Intrinsics.areEqual((Object)dimensionEntity, (Object)Level.OVERWORLD) || Intrinsics.areEqual((Object)dimensionEntity, (Object)Level.END) || Intrinsics.areEqual((Object)dimensionEntity, (Object)Level.NETHER)) {
                return;
            }
            if (entity instanceof ServerPlayer && entity.portalProcess == null) {
                boolean isRandomTeleport;
                boolean bl = isRandomTeleport = (double)((ServerPlayer)entity).getRandom().nextFloat() < 0.4 && (Intrinsics.areEqual((Object)dimensionEntity, TBSDimensions.CLAN_VOID) || Intrinsics.areEqual((Object)dimensionEntity, TBSDimensions.NULL_TORTURE));
                if (isRandomTeleport) {
                    BlockPos tpPos = null;
                    if (Intrinsics.areEqual((Object)dimensionEntity, TBSDimensions.CLAN_VOID)) {
                        Vec3 motion = ((ServerPlayer)entity).getDeltaMovement();
                        Direction approachDirection = Direction.getNearest((float)(-((float)motion.x)), (float)0.0f, (float)(-((float)motion.z)));
                        Vec3i offset = approachDirection.getNormal().multiply(8);
                        BlockPos offsetPos = pos.offset(offset);
                        tpPos = new BlockPos(offsetPos.getX() + ((ServerPlayer)entity).getRandom().nextInt(4, 11) * 8, offsetPos.getY(), offsetPos.getZ() + ((ServerPlayer)entity).getRandom().nextInt(4, 11) * 8);
                        ChunkAccess chunkAccess = level.getChunk(tpPos);
                        Intrinsics.checkNotNullExpressionValue((Object)chunkAccess, (String)"getChunk(...)");
                        ChunkAccess chunk = chunkAccess;
                        BlockPos blockPos = chunk.getPos().getWorldPosition().offset(8, 0, 8);
                        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"offset(...)");
                        Vec3 tpPosUpdated = PositionUtil.withY((BlockPos)blockPos, (Number)(level.random.nextBoolean() ? 201 : (level.random.nextBoolean() ? 207 : 216))).getCenter().add(-0.5, -0.5, -0.5);
                        if (!level.getBlockState(tpPos).isAir()) {
                            Vec3 vec3 = tpPosUpdated.add(2.0, 0.0, 2.0);
                            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"add(...)");
                            v4 = PositionUtil.getBlockPos((Position)((Position)vec3));
                        } else {
                            Intrinsics.checkNotNull((Object)tpPosUpdated);
                            v4 = tpPos = PositionUtil.getBlockPos((Position)((Position)tpPosUpdated));
                        }
                    }
                    if (Intrinsics.areEqual((Object)dimensionEntity, TBSDimensions.NULL_TORTURE)) {
                        tpPos = new BlockPos(((ServerPlayer)entity).getBlockX() + ((ServerPlayer)entity).getRandom().nextInt(4, 7) * 8, ((ServerPlayer)entity).getBlockY(), ((ServerPlayer)entity).getBlockZ());
                        ChunkAccess chunkAccess = level.getChunk(tpPos);
                        Intrinsics.checkNotNullExpressionValue((Object)chunkAccess, (String)"getChunk(...)");
                        ChunkAccess chunk = chunkAccess;
                        BlockPos blockPos = chunk.getPos().getWorldPosition().offset(5, 0, 0);
                        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"offset(...)");
                        tpPos = PositionUtil.withY((BlockPos)blockPos, (Number)66);
                    }
                    TheBrokenScript.serverWorkQueue.add(1L, () -> ExitBlock.entityInside$lambda$0(entity));
                    BlockPos blockPos = tpPos;
                    Intrinsics.checkNotNull(blockPos);
                    EntityUtil.teleport((Entity)entity, blockPos);
                } else {
                    PlayerExt.INSTANCE.updateVars((Player)entity, (Function1<? super PlayerVariables, Unit>)((Function1)ExitBlock::entityInside$lambda$1));
                    if (PlayerExt.INSTANCE.getVars((Player)entity).getTicksUntilExit() > 0L) {
                        PlayerExt.INSTANCE.updateVars((Player)entity, (Function1<? super PlayerVariables, Unit>)((Function1)ExitBlock::entityInside$lambda$2));
                    }
                    entity.setAsInsidePortal((Portal)this, pos);
                }
            }
        }
    }

    @NotNull
    public BlockEntity newBlockEntity(@NotNull BlockPos p0, @NotNull BlockState p1) {
        Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
        Intrinsics.checkNotNullParameter((Object)p1, (String)"p1");
        return TBSBlockEntities.EXIT.create(p0, p1);
    }

    @NotNull
    public final MapCodec<ExitBlock> getCodec() {
        return this.codec;
    }

    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return this.codec;
    }

    @NotNull
    public DimensionTransition getPortalDestination(@NotNull ServerLevel level, @NotNull Entity entity, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        TheBrokenScript.serverWorkQueue.add(1L, () -> ExitBlock.getPortalDestination$lambda$0(entity));
        return new DimensionTransition(level.getServer().overworld(), pos.getCenter(), entity.getDeltaMovement(), entity.getYRot(), entity.getXRot(), DimensionTransition.PLACE_PORTAL_TICKET);
    }

    private static final Unit entityInside$lambda$0(Entity $entity) {
        PlayerExt.tryPlaySound$default(PlayerExt.INSTANCE, (Player)$entity, (SoundEvent)TBSSounds.TRAVEL.invoke(), false, 0.0f, 0.0f, 0.0f, 30, null);
        return Unit.INSTANCE;
    }

    private static final Unit entityInside$lambda$1(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setFixPos(true);
        $this$updateVars.setSkipFallDamage(true);
        return Unit.INSTANCE;
    }

    private static final Unit entityInside$lambda$2(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setTicksUntilExit(0L);
        return Unit.INSTANCE;
    }

    private static final ExitBlock codec$lambda$0(BlockBehaviour.Properties properties) {
        Intrinsics.checkNotNullParameter((Object)properties, (String)"properties");
        return new ExitBlock(properties);
    }

    private static final Unit getPortalDestination$lambda$0(Entity $entity) {
        if ($entity instanceof ServerPlayer) {
            PlayerExt.tryPlaySound$default(PlayerExt.INSTANCE, (Player)$entity, (SoundEvent)TBSSounds.TRAVEL.invoke(), false, 0.0f, 0.0f, 0.0f, 30, null);
        }
        return Unit.INSTANCE;
    }
}

