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
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.BaseEntityBlock
 *  net.minecraft.world.level.block.Portal
 *  net.minecraft.world.level.block.RenderShape
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.portal.DimensionTransition
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.shapes.BooleanOp
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
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
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Portal;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thebrokenscript.TheBrokenScript;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.registry.TBSBlockEntities;
import net.thebrokenscript.registry.TBSDimensions;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J(\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u001c\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001dH\u0014J\u0018\u0010 \u001a\u00020!2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\t\u001a\u00020\nH\u0014R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00000\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2={"Lnet/thebrokenscript/block/AllDeadBlock;", "Lnet/minecraft/world/level/block/BaseEntityBlock;", "Lnet/minecraft/world/level/block/Portal;", "properties", "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;", "<init>", "(Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)V", "getLightBlock", "", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "worldIn", "Lnet/minecraft/world/level/BlockGetter;", "pos", "Lnet/minecraft/core/BlockPos;", "canBeReplaced", "", "context", "Lnet/minecraft/world/item/context/BlockPlaceContext;", "entityInside", "", "level", "Lnet/minecraft/world/level/Level;", "entity", "Lnet/minecraft/world/entity/Entity;", "getPortalDestination", "Lnet/minecraft/world/level/portal/DimensionTransition;", "Lnet/minecraft/server/level/ServerLevel;", "codec", "Lcom/mojang/serialization/MapCodec;", "getCodec", "()Lcom/mojang/serialization/MapCodec;", "newBlockEntity", "Lnet/minecraft/world/level/block/entity/BlockEntity;", "getRenderShape", "Lnet/minecraft/world/level/block/RenderShape;", "thebrokenscript-common"})
public final class AllDeadBlock
extends BaseEntityBlock
implements Portal {
    @NotNull
    private final MapCodec<AllDeadBlock> codec;

    public AllDeadBlock(@NotNull BlockBehaviour.Properties properties) {
        Intrinsics.checkNotNullParameter((Object)properties, (String)"properties");
        super(properties);
        MapCodec mapCodec = BaseEntityBlock.simpleCodec(AllDeadBlock::codec$lambda$0);
        Intrinsics.checkNotNullExpressionValue((Object)mapCodec, (String)"simpleCodec(...)");
        this.codec = mapCodec;
    }

    protected int getLightBlock(@NotNull BlockState state, @NotNull BlockGetter worldIn, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)worldIn, (String)"worldIn");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return 15;
    }

    protected boolean canBeReplaced(@NotNull BlockState state, @NotNull BlockPlaceContext context) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        return !context.getItemInHand().is(this.asItem());
    }

    protected void entityInside(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Entity entity) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        if (entity.canUsePortal(false) && Shapes.joinIsNotEmpty((VoxelShape)Shapes.create((AABB)entity.getBoundingBox().move(PositionUtil.negate((BlockPos)pos))), (VoxelShape)state.getShape((BlockGetter)level, pos), (BooleanOp)BooleanOp.AND) && entity instanceof ServerPlayer) {
            entity.setAsInsidePortal((Portal)this, pos);
            PlayerExt.INSTANCE.updateVars((Player)entity, (Function1<? super PlayerVariables, Unit>)((Function1)AllDeadBlock::entityInside$lambda$0));
        }
    }

    @NotNull
    public DimensionTransition getPortalDestination(@NotNull ServerLevel level, @NotNull Entity entity, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        TheBrokenScript.serverWorkQueue.add(1L, () -> AllDeadBlock.getPortalDestination$lambda$0(entity));
        ServerLevel serverLevel = level.getServer().getLevel((double)level.random.nextFloat() < 0.7 && !Intrinsics.areEqual((Object)entity.level().dimension(), TBSDimensions.CLAN_VOID) ? TBSDimensions.CLAN_VOID : (!Intrinsics.areEqual((Object)entity.level().dimension(), TBSDimensions.NULL_TORTURE) ? TBSDimensions.NULL_TORTURE : TBSDimensions.CLAN_VOID));
        Intrinsics.checkNotNull((Object)serverLevel);
        return new DimensionTransition(serverLevel, pos.getCenter(), entity.getDeltaMovement(), entity.getYRot(), entity.getXRot(), DimensionTransition.PLACE_PORTAL_TICKET);
    }

    @NotNull
    public final MapCodec<AllDeadBlock> getCodec() {
        return this.codec;
    }

    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return this.codec;
    }

    @NotNull
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        return TBSBlockEntities.ALL_DEAD.create(pos, state);
    }

    @NotNull
    protected RenderShape getRenderShape(@NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    private static final Unit entityInside$lambda$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setFixPos(true);
        return Unit.INSTANCE;
    }

    private static final Unit getPortalDestination$lambda$0(Entity $entity) {
        if ($entity instanceof ServerPlayer) {
            PlayerExt.tryPlaySound$default(PlayerExt.INSTANCE, (Player)$entity, (SoundEvent)TBSSounds.TRAVEL.invoke(), false, 0.0f, 0.0f, 0.0f, 30, null);
        }
        return Unit.INSTANCE;
    }

    private static final AllDeadBlock codec$lambda$0(BlockBehaviour.Properties properties) {
        Intrinsics.checkNotNullParameter((Object)properties, (String)"properties");
        return new AllDeadBlock(properties);
    }
}

