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
 *  net.minecraft.core.BlockPos$MutableBlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.ItemInteractionResult
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.BaseEntityBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.phys.BlockHitResult
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
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
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.BlockHitResult;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.block.entity.TetherBloomBlockEntity;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.data.MapVariables;
import net.thebrokenscript.registry.TBSBlockEntities;
import net.thebrokenscript.registry.TBSEntities;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J0\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J@\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J(\u0010\u0018\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000fH\u0002J\u0012\u0010\u001c\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001dH\u0014J\u0018\u0010 \u001a\u00020!2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0016R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00000\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006\""}, d2={"Lnet/thebrokenscript/block/TetherBloomBlock;", "Lnet/minecraft/world/level/block/BaseEntityBlock;", "properties", "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;", "<init>", "(Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)V", "useWithoutItem", "Lnet/minecraft/world/InteractionResult;", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "level", "Lnet/minecraft/world/level/Level;", "pos", "Lnet/minecraft/core/BlockPos;", "player", "Lnet/minecraft/world/entity/player/Player;", "hitResult", "Lnet/minecraft/world/phys/BlockHitResult;", "useItemOn", "Lnet/minecraft/world/ItemInteractionResult;", "stack", "Lnet/minecraft/world/item/ItemStack;", "hand", "Lnet/minecraft/world/InteractionHand;", "attack", "", "spawnJimbo", "victim", "codec", "Lcom/mojang/serialization/MapCodec;", "getCodec", "()Lcom/mojang/serialization/MapCodec;", "newBlockEntity", "Lnet/thebrokenscript/block/entity/TetherBloomBlockEntity;", "thebrokenscript-common"})
public final class TetherBloomBlock
extends BaseEntityBlock {
    @NotNull
    private final MapCodec<TetherBloomBlock> codec;

    public TetherBloomBlock(@NotNull BlockBehaviour.Properties properties) {
        Intrinsics.checkNotNullParameter((Object)properties, (String)"properties");
        super(properties);
        MapCodec mapCodec = BaseEntityBlock.simpleCodec(TetherBloomBlock::codec$lambda$0);
        Intrinsics.checkNotNullExpressionValue((Object)mapCodec, (String)"simpleCodec(...)");
        this.codec = mapCodec;
    }

    @NotNull
    protected InteractionResult useWithoutItem(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull BlockHitResult hitResult) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)hitResult, (String)"hitResult");
        if (level instanceof ServerLevel) {
            if (LevelExt.INSTANCE.getVars((LevelAccessor)level).getCanFracturedSpawn()) {
                return InteractionResult.PASS;
            }
            LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)arg_0 -> TetherBloomBlock.useWithoutItem$lambda$0(this, level, player, arg_0)));
        }
        return InteractionResult.SUCCESS;
    }

    @NotNull
    protected ItemInteractionResult useItemOn(@NotNull ItemStack stack, @NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        Intrinsics.checkNotNullParameter((Object)stack, (String)"stack");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)hand, (String)"hand");
        Intrinsics.checkNotNullParameter((Object)hitResult, (String)"hitResult");
        if (level instanceof ServerLevel) {
            if (LevelExt.INSTANCE.getVars((LevelAccessor)level).getCanFracturedSpawn()) {
                return ItemInteractionResult.FAIL;
            }
            LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)arg_0 -> TetherBloomBlock.useItemOn$lambda$0(this, level, player, arg_0)));
        }
        return ItemInteractionResult.SUCCESS;
    }

    protected void attack(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        if (level instanceof ServerLevel) {
            if (LevelExt.INSTANCE.getVars((LevelAccessor)level).getCanFracturedSpawn()) {
                return;
            }
            LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)arg_0 -> TetherBloomBlock.attack$lambda$0(this, level, player, arg_0)));
        }
    }

    private final void spawnJimbo(Level level, Player victim) {
        if (level.isClientSide) {
            return;
        }
        BlockPos victimPos = victim.blockPosition();
        int bigManX = victim.getRandom().nextBoolean() ? victimPos.getX() + 100 : victimPos.getX() - 100;
        int bigManZ = victim.getRandom().nextBoolean() ? victimPos.getZ() + 100 : victimPos.getZ() - 100;
        Intrinsics.checkNotNull((Object)level, (String)"null cannot be cast to non-null type net.minecraft.server.level.ServerLevel");
        int bigManY = ((ServerLevel)level).getHeightmapPos(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, new BlockPos(bigManX, 0, bigManZ)).getY();
        BlockPos.MutableBlockPos bigManPos = new BlockPos.MutableBlockPos(bigManX, bigManY, bigManZ);
        EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.FRACTURED_ROAM.get()), (LevelAccessor)((LevelAccessor)level), (BlockPos)((BlockPos)bigManPos));
    }

    @NotNull
    public final MapCodec<TetherBloomBlock> getCodec() {
        return this.codec;
    }

    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return this.codec;
    }

    @NotNull
    public TetherBloomBlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        return (TetherBloomBlockEntity)TBSBlockEntities.A_FLOWER.create(pos, state);
    }

    private static final Unit useWithoutItem$lambda$0(TetherBloomBlock this$0, Level $level, Player $player, MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setCanFracturedSpawn(true);
        this$0.spawnJimbo($level, $player);
        return Unit.INSTANCE;
    }

    private static final Unit useItemOn$lambda$0(TetherBloomBlock this$0, Level $level, Player $player, MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setCanFracturedSpawn(true);
        this$0.spawnJimbo($level, $player);
        return Unit.INSTANCE;
    }

    private static final Unit attack$lambda$0(TetherBloomBlock this$0, Level $level, Player $player, MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setCanFracturedSpawn(true);
        this$0.spawnJimbo($level, $player);
        return Unit.INSTANCE;
    }

    private static final TetherBloomBlock codec$lambda$0(BlockBehaviour.Properties properties) {
        Intrinsics.checkNotNullParameter((Object)properties, (String)"properties");
        return new TetherBloomBlock(properties);
    }
}

