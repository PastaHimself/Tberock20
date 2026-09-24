/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function5
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.BlockPos
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.BlockUtil
 *  net.thebrokenscript.brokencore.api.dsl.LevelUtil
 *  net.thebrokenscript.brokencore.api.dsl.SoundUtil
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.handlers;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.brokencore.api.dsl.BlockUtil;
import net.thebrokenscript.brokencore.api.dsl.LevelUtil;
import net.thebrokenscript.brokencore.api.dsl.SoundUtil;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.data.MapVariables;
import net.thebrokenscript.handlers.subs.EntityPlaceSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/handlers/HerobrineShrineChecker;", "", "<init>", "()V", "onBlockPlace", "", "pos", "Lnet/minecraft/core/BlockPos;", "level", "Lnet/minecraft/world/level/LevelAccessor;", "entity", "Lnet/minecraft/world/entity/Entity;", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "proxy", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nHerobrineShrineChecker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HerobrineShrineChecker.kt\nnet/thebrokenscript/handlers/HerobrineShrineChecker\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,63:1\n1740#2,3:64\n1740#2,3:67\n*S KotlinDebug\n*F\n+ 1 HerobrineShrineChecker.kt\nnet/thebrokenscript/handlers/HerobrineShrineChecker\n*L\n43#1:64,3\n50#1:67,3\n*E\n"})
public final class HerobrineShrineChecker {
    @NotNull
    public static final HerobrineShrineChecker INSTANCE = new HerobrineShrineChecker();

    private HerobrineShrineChecker() {
    }

    /*
     * WARNING - void declaration
     */
    public final void onBlockPlace(@NotNull BlockPos pos, @NotNull LevelAccessor level, @Nullable Entity entity, @NotNull BlockState state, @NotNull CancelProxy proxy) {
        boolean torch;
        boolean gold;
        boolean cobble;
        boolean nether;
        boolean fire;
        block9: {
            void $this$all$iv;
            boolean bl;
            BlockPos lower;
            block8: {
                void $this$all$iv2;
                Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
                Intrinsics.checkNotNullParameter((Object)level, (String)"level");
                Intrinsics.checkNotNullParameter((Object)state, (String)"state");
                Intrinsics.checkNotNullParameter((Object)proxy, (String)"proxy");
                lower = pos.below(1);
                BlockPos bottom = pos.below(2);
                BlockState blockState = LevelUtil.get((BlockGetter)((BlockGetter)level), (BlockPos)pos);
                Block block = Blocks.FIRE;
                Intrinsics.checkNotNullExpressionValue((Object)block, (String)"FIRE");
                fire = BlockUtil.matches((BlockState)blockState, (Block)block);
                BlockGetter blockGetter = (BlockGetter)level;
                Intrinsics.checkNotNull((Object)lower);
                BlockState blockState2 = LevelUtil.get((BlockGetter)blockGetter, (BlockPos)lower);
                Block block2 = Blocks.NETHERRACK;
                Intrinsics.checkNotNullExpressionValue((Object)block2, (String)"NETHERRACK");
                nether = BlockUtil.matches((BlockState)blockState2, (Block)block2);
                BlockGetter blockGetter2 = (BlockGetter)level;
                Intrinsics.checkNotNull((Object)bottom);
                BlockState blockState3 = LevelUtil.get((BlockGetter)blockGetter2, (BlockPos)bottom);
                Block block3 = Blocks.MOSSY_COBBLESTONE;
                Intrinsics.checkNotNullExpressionValue((Object)block3, (String)"MOSSY_COBBLESTONE");
                cobble = BlockUtil.matches((BlockState)blockState3, (Block)block3);
                Object object = new Boolean[8];
                BlockGetter blockGetter3 = (BlockGetter)level;
                BlockPos blockPos = bottom.offset(-1, 0, 0);
                Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"offset(...)");
                BlockState blockState4 = LevelUtil.get((BlockGetter)blockGetter3, (BlockPos)blockPos);
                Block block4 = Blocks.GOLD_BLOCK;
                Intrinsics.checkNotNullExpressionValue((Object)block4, (String)"GOLD_BLOCK");
                object[0] = BlockUtil.matches((BlockState)blockState4, (Block)block4);
                BlockGetter blockGetter4 = (BlockGetter)level;
                BlockPos blockPos2 = bottom.offset(1, 0, 0);
                Intrinsics.checkNotNullExpressionValue((Object)blockPos2, (String)"offset(...)");
                BlockState blockState5 = LevelUtil.get((BlockGetter)blockGetter4, (BlockPos)blockPos2);
                Block block5 = Blocks.GOLD_BLOCK;
                Intrinsics.checkNotNullExpressionValue((Object)block5, (String)"GOLD_BLOCK");
                object[1] = BlockUtil.matches((BlockState)blockState5, (Block)block5);
                BlockGetter blockGetter5 = (BlockGetter)level;
                BlockPos blockPos3 = bottom.offset(0, 0, -1);
                Intrinsics.checkNotNullExpressionValue((Object)blockPos3, (String)"offset(...)");
                BlockState blockState6 = LevelUtil.get((BlockGetter)blockGetter5, (BlockPos)blockPos3);
                Block block6 = Blocks.GOLD_BLOCK;
                Intrinsics.checkNotNullExpressionValue((Object)block6, (String)"GOLD_BLOCK");
                object[2] = BlockUtil.matches((BlockState)blockState6, (Block)block6);
                BlockGetter blockGetter6 = (BlockGetter)level;
                BlockPos blockPos4 = bottom.offset(0, 0, 1);
                Intrinsics.checkNotNullExpressionValue((Object)blockPos4, (String)"offset(...)");
                BlockState blockState7 = LevelUtil.get((BlockGetter)blockGetter6, (BlockPos)blockPos4);
                Block block7 = Blocks.GOLD_BLOCK;
                Intrinsics.checkNotNullExpressionValue((Object)block7, (String)"GOLD_BLOCK");
                object[3] = BlockUtil.matches((BlockState)blockState7, (Block)block7);
                BlockGetter blockGetter7 = (BlockGetter)level;
                BlockPos blockPos5 = bottom.offset(1, 0, 1);
                Intrinsics.checkNotNullExpressionValue((Object)blockPos5, (String)"offset(...)");
                BlockState blockState8 = LevelUtil.get((BlockGetter)blockGetter7, (BlockPos)blockPos5);
                Block block8 = Blocks.GOLD_BLOCK;
                Intrinsics.checkNotNullExpressionValue((Object)block8, (String)"GOLD_BLOCK");
                object[4] = BlockUtil.matches((BlockState)blockState8, (Block)block8);
                BlockGetter blockGetter8 = (BlockGetter)level;
                BlockPos blockPos6 = bottom.offset(-1, 0, -1);
                Intrinsics.checkNotNullExpressionValue((Object)blockPos6, (String)"offset(...)");
                BlockState blockState9 = LevelUtil.get((BlockGetter)blockGetter8, (BlockPos)blockPos6);
                Block block9 = Blocks.GOLD_BLOCK;
                Intrinsics.checkNotNullExpressionValue((Object)block9, (String)"GOLD_BLOCK");
                object[5] = BlockUtil.matches((BlockState)blockState9, (Block)block9);
                BlockGetter blockGetter9 = (BlockGetter)level;
                BlockPos blockPos7 = bottom.offset(-1, 0, 1);
                Intrinsics.checkNotNullExpressionValue((Object)blockPos7, (String)"offset(...)");
                BlockState blockState10 = LevelUtil.get((BlockGetter)blockGetter9, (BlockPos)blockPos7);
                Block block10 = Blocks.GOLD_BLOCK;
                Intrinsics.checkNotNullExpressionValue((Object)block10, (String)"GOLD_BLOCK");
                object[6] = BlockUtil.matches((BlockState)blockState10, (Block)block10);
                BlockGetter blockGetter10 = (BlockGetter)level;
                BlockPos blockPos8 = bottom.offset(1, 0, -1);
                Intrinsics.checkNotNullExpressionValue((Object)blockPos8, (String)"offset(...)");
                BlockState blockState11 = LevelUtil.get((BlockGetter)blockGetter10, (BlockPos)blockPos8);
                Block block11 = Blocks.GOLD_BLOCK;
                Intrinsics.checkNotNullExpressionValue((Object)block11, (String)"GOLD_BLOCK");
                object[7] = BlockUtil.matches((BlockState)blockState11, (Block)block11);
                object = CollectionsKt.listOf((Object[])object);
                boolean $i$f$all = false;
                if ($this$all$iv2 instanceof Collection && ((Collection)$this$all$iv2).isEmpty()) {
                    bl = true;
                } else {
                    for (Object element$iv : $this$all$iv2) {
                        boolean it = (Boolean)element$iv;
                        boolean bl2 = false;
                        if (it) continue;
                        bl = false;
                        break block8;
                    }
                    bl = true;
                }
            }
            gold = bl;
            Object $i$f$all = new Boolean[4];
            BlockGetter blockGetter = (BlockGetter)level;
            BlockPos blockPos = lower.offset(-1, 0, 0);
            Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"offset(...)");
            BlockState blockState = LevelUtil.get((BlockGetter)blockGetter, (BlockPos)blockPos);
            Block block = Blocks.REDSTONE_TORCH;
            Intrinsics.checkNotNullExpressionValue((Object)block, (String)"REDSTONE_TORCH");
            $i$f$all[0] = BlockUtil.matches((BlockState)blockState, (Block)block);
            BlockGetter blockGetter11 = (BlockGetter)level;
            BlockPos blockPos9 = lower.offset(1, 0, 0);
            Intrinsics.checkNotNullExpressionValue((Object)blockPos9, (String)"offset(...)");
            BlockState blockState12 = LevelUtil.get((BlockGetter)blockGetter11, (BlockPos)blockPos9);
            Block block12 = Blocks.REDSTONE_TORCH;
            Intrinsics.checkNotNullExpressionValue((Object)block12, (String)"REDSTONE_TORCH");
            $i$f$all[1] = BlockUtil.matches((BlockState)blockState12, (Block)block12);
            BlockGetter blockGetter12 = (BlockGetter)level;
            BlockPos blockPos10 = lower.offset(0, 0, -1);
            Intrinsics.checkNotNullExpressionValue((Object)blockPos10, (String)"offset(...)");
            BlockState blockState13 = LevelUtil.get((BlockGetter)blockGetter12, (BlockPos)blockPos10);
            Block block13 = Blocks.REDSTONE_TORCH;
            Intrinsics.checkNotNullExpressionValue((Object)block13, (String)"REDSTONE_TORCH");
            $i$f$all[2] = BlockUtil.matches((BlockState)blockState13, (Block)block13);
            BlockGetter blockGetter13 = (BlockGetter)level;
            BlockPos blockPos11 = lower.offset(0, 0, 1);
            Intrinsics.checkNotNullExpressionValue((Object)blockPos11, (String)"offset(...)");
            BlockState blockState14 = LevelUtil.get((BlockGetter)blockGetter13, (BlockPos)blockPos11);
            Block block14 = Blocks.REDSTONE_TORCH;
            Intrinsics.checkNotNullExpressionValue((Object)block14, (String)"REDSTONE_TORCH");
            $i$f$all[3] = BlockUtil.matches((BlockState)blockState14, (Block)block14);
            $i$f$all = CollectionsKt.listOf((Object[])$i$f$all);
            boolean $i$f$all2 = false;
            if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                v57 = true;
            } else {
                for (Object element$iv : $this$all$iv) {
                    boolean it = (Boolean)element$iv;
                    boolean bl3 = false;
                    if (it) continue;
                    v57 = false;
                    break block9;
                }
                v57 = torch = true;
            }
        }
        if (fire && nether && cobble && gold && torch) {
            Vec3 vec3 = pos.getCenter();
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getCenter(...)");
            SoundUtil.playSound$default((LevelAccessor)level, (Vec3)vec3, (SoundEvent)((SoundEvent)TBSSounds.CURVED_SPAWN.get()), (float)10.0f, (float)0.0f, null, (int)16, null);
            EntityType entityType = EntityType.LIGHTNING_BOLT;
            Intrinsics.checkNotNullExpressionValue((Object)entityType, (String)"LIGHTNING_BOLT");
            EntityTypeExt.trySummon((EntityType)entityType, (LevelAccessor)level, (BlockPos)pos);
            if (!LevelExt.INSTANCE.getVars(level).getHasBuiltHerobrineShrine()) {
                LevelExt.INSTANCE.updateVars(level, (Function1<? super MapVariables, Unit>)((Function1)HerobrineShrineChecker::onBlockPlace$lambda$2));
            }
        }
    }

    private static final Unit onBlockPlace$lambda$2(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setHasBuiltHerobrineShrine(true);
        return Unit.INSTANCE;
    }

    static {
        EntityPlaceSubscriber.INSTANCE.add((Function5<? super BlockPos, ? super LevelAccessor, ? super Entity, ? super BlockState, ? super CancelProxy, Unit>)((Function5)new Function5<BlockPos, LevelAccessor, Entity, BlockState, CancelProxy, Unit>((Object)INSTANCE){

            public final void invoke(BlockPos p0, LevelAccessor p1, Entity p2, BlockState p3, CancelProxy p4) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                Intrinsics.checkNotNullParameter((Object)p1, (String)"p1");
                Intrinsics.checkNotNullParameter((Object)p3, (String)"p3");
                Intrinsics.checkNotNullParameter((Object)p4, (String)"p4");
                ((HerobrineShrineChecker)this.receiver).onBlockPlace(p0, p1, p2, p3, p4);
            }
        }));
    }
}

