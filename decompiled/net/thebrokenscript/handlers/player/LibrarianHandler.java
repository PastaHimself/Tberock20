/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function5
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.animal.allay.Allay
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.CandleBlock
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.LevelUtil
 *  net.thebrokenscript.brokencore.api.dsl.SoundUtil
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.handlers.player;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.LevelUtil;
import net.thebrokenscript.brokencore.api.dsl.SoundUtil;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.handlers.subs.EntityPlaceSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSLang;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/handlers/player/LibrarianHandler;", "", "<init>", "()V", "checkState", "", "pos", "Lnet/minecraft/core/BlockPos;", "level", "Lnet/minecraft/world/level/LevelAccessor;", "entity", "Lnet/minecraft/world/entity/Entity;", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "proxy", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "thebrokenscript-common"})
public final class LibrarianHandler {
    @NotNull
    public static final LibrarianHandler INSTANCE = new LibrarianHandler();

    private LibrarianHandler() {
    }

    public final void checkState(@NotNull BlockPos pos, @NotNull LevelAccessor level, @Nullable Entity entity, @NotNull BlockState state, @NotNull CancelProxy proxy) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)proxy, (String)"proxy");
        BlockState blockState = level.getBlockState(pos);
        Intrinsics.checkNotNullExpressionValue((Object)blockState, (String)"getBlockState(...)");
        BlockState state2 = blockState;
        if (state2.is(Blocks.CANDLE) && ((Boolean)state2.getValue((Property)CandleBlock.LIT)).booleanValue() && level instanceof ServerLevel) {
            BlockState blockState2 = ((ServerLevel)level).getBlockState(pos.below());
            Intrinsics.checkNotNullExpressionValue((Object)blockState2, (String)"getBlockState(...)");
            BlockState belowState = blockState2;
            if (belowState.is(Blocks.GOLD_BLOCK)) {
                ((ServerLevel)level).setBlock(pos.below(), Blocks.GLOWSTONE.defaultBlockState(), 3);
                Vec3 vec3 = pos.getCenter();
                Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getCenter(...)");
                SoundEvent soundEvent = SoundEvents.REDSTONE_TORCH_BURNOUT;
                Intrinsics.checkNotNullExpressionValue((Object)soundEvent, (String)"REDSTONE_TORCH_BURNOUT");
                SoundUtil.playSound$default((LevelAccessor)level, (Vec3)vec3, (SoundEvent)soundEvent, (float)0.0f, (float)0.0f, null, (int)28, null);
                TBSConfigs.INSTANCE.getServer().setDisableNewMobSpawning(false);
                LevelUtil.getQueue((Level)((Level)level)).add(20L, () -> LibrarianHandler.checkState$lambda$0(level, pos));
                LevelUtil.getQueue((Level)((Level)level)).add(60L, () -> LibrarianHandler.checkState$lambda$1(level, pos));
                LevelUtil.getQueue((Level)((Level)level)).add(80L, () -> LibrarianHandler.checkState$lambda$2(level, pos));
            }
        }
    }

    private static final Unit checkState$lambda$0(LevelAccessor $level, BlockPos $pos) {
        Vec3 vec3 = $pos.getCenter();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getCenter(...)");
        SoundEvent soundEvent = SoundEvents.ALLAY_AMBIENT_WITH_ITEM;
        Intrinsics.checkNotNullExpressionValue((Object)soundEvent, (String)"ALLAY_AMBIENT_WITH_ITEM");
        SoundUtil.playSound$default((LevelAccessor)$level, (Vec3)vec3, (SoundEvent)soundEvent, (float)0.0f, (float)0.0f, null, (int)28, null);
        ((ServerLevel)$level).setBlock($pos, (BlockState)Blocks.CYAN_CANDLE.defaultBlockState().setValue((Property)CandleBlock.LIT, (Comparable)Boolean.valueOf(true)), 3);
        return Unit.INSTANCE;
    }

    private static final Unit checkState$lambda$1(LevelAccessor $level, BlockPos $pos) {
        ((ServerLevel)$level).setBlock($pos, Blocks.AIR.defaultBlockState(), 3);
        Allay libertyEntity = new Allay(EntityType.ALLAY, (Level)$level);
        libertyEntity.setItemInHand(InteractionHand.MAIN_HAND, Items.LANTERN.getDefaultInstance());
        libertyEntity.setCustomName((Component)TBSLang.INSTANCE.getLIBERTY());
        libertyEntity.setCustomNameVisible(true);
        libertyEntity.setPos($pos.getCenter());
        Vec3 vec3 = $pos.getCenter();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getCenter(...)");
        SoundEvent soundEvent = SoundEvents.ENDERMAN_TELEPORT;
        Intrinsics.checkNotNullExpressionValue((Object)soundEvent, (String)"ENDERMAN_TELEPORT");
        SoundUtil.playSound$default((LevelAccessor)$level, (Vec3)vec3, (SoundEvent)soundEvent, (float)0.0f, (float)0.0f, null, (int)28, null);
        ((ServerLevel)$level).addFreshEntity((Entity)libertyEntity);
        return Unit.INSTANCE;
    }

    private static final Unit checkState$lambda$2(LevelAccessor $level, BlockPos $pos) {
        ((ServerLevel)$level).setBlock($pos.below(), Blocks.AIR.defaultBlockState(), 3);
        return Unit.INSTANCE;
    }

    static {
        EntityPlaceSubscriber.INSTANCE.add((Function5<? super BlockPos, ? super LevelAccessor, ? super Entity, ? super BlockState, ? super CancelProxy, Unit>)((Function5)new Function5<BlockPos, LevelAccessor, Entity, BlockState, CancelProxy, Unit>((Object)INSTANCE){

            public final void invoke(BlockPos p0, LevelAccessor p1, Entity p2, BlockState p3, CancelProxy p4) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                Intrinsics.checkNotNullParameter((Object)p1, (String)"p1");
                Intrinsics.checkNotNullParameter((Object)p3, (String)"p3");
                Intrinsics.checkNotNullParameter((Object)p4, (String)"p4");
                ((LibrarianHandler)this.receiver).checkState(p0, p1, p2, p3, p4);
            }
        }));
    }
}

