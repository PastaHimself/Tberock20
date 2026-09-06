/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.optionals.OptionalsKt
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Registry
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.thebrokenscript.brokencore.api.dsl.BlockUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.boss.integrity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.optionals.OptionalsKt;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.thebrokenscript.boss.integrity.PartialBlockPos;
import net.thebrokenscript.brokencore.api.dsl.BlockUtil;
import net.thebrokenscript.registry.TBSBlocks;
import net.thebrokenscript.registry.TBSTags;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000(\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t\u001a$\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t\u00a8\u0006\f"}, d2={"createTerrainCorruptionQueue", "", "Lnet/thebrokenscript/boss/integrity/PartialBlockPos;", "Lnet/minecraft/world/level/Level;", "center", "Lnet/minecraft/core/BlockPos;", "radius", "", "ratio", "", "corruptTerrain", "", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nTerrainCorrupter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TerrainCorrupter.kt\nnet/thebrokenscript/boss/integrity/TerrainCorrupterKt\n+ 2 Timing.kt\nkotlin/system/TimingKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,59:1\n29#2,3:60\n774#3:63\n865#3,2:64\n*S KotlinDebug\n*F\n+ 1 TerrainCorrupter.kt\nnet/thebrokenscript/boss/integrity/TerrainCorrupterKt\n*L\n30#1:60,3\n42#1:63\n42#1:64,2\n*E\n"})
public final class TerrainCorrupterKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<PartialBlockPos> createTerrainCorruptionQueue(@NotNull Level $this$createTerrainCorruptionQueue, @NotNull BlockPos center, int radius, float ratio) {
        void $this$filterTo$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$createTerrainCorruptionQueue, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)center, (String)"center");
        int radiusSq = radius * radius;
        ArrayList<PartialBlockPos> locations = new ArrayList<PartialBlockPos>((int)(Math.PI * (double)radiusSq));
        boolean $i$f$measureTimeMillis = false;
        long start$iv = System.currentTimeMillis();
        boolean bl = false;
        int xo = -radius;
        if (xo <= radius) {
            while (true) {
                int zo;
                if ((zo = -radius) <= radius) {
                    while (true) {
                        if (xo * xo + zo * zo <= radiusSq) {
                            locations.add(new PartialBlockPos(center.getX() + xo, center.getZ() + zo));
                        }
                        if (zo == radius) break;
                        ++zo;
                    }
                }
                if (xo == radius) break;
                ++xo;
            }
        }
        long time = System.currentTimeMillis() - start$iv;
        System.out.println((Object)("Gathered positions in " + time + " milliseconds!"));
        Iterable $this$filter$iv = locations;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            PartialBlockPos it = (PartialBlockPos)element$iv$iv;
            boolean bl2 = false;
            if (!($this$createTerrainCorruptionQueue.random.nextFloat() <= ratio)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return CollectionsKt.shuffled((Iterable)((List)destination$iv$iv));
    }

    public static /* synthetic */ List createTerrainCorruptionQueue$default(Level level, BlockPos blockPos, int n, float f, int n2, Object object) {
        if ((n2 & 4) != 0) {
            f = 0.3f;
        }
        return TerrainCorrupterKt.createTerrainCorruptionQueue(level, blockPos, n, f);
    }

    public static final void corruptTerrain(@NotNull Level $this$corruptTerrain, @NotNull BlockPos center, int radius, float ratio) {
        Intrinsics.checkNotNullParameter((Object)$this$corruptTerrain, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)center, (String)"center");
        Registry reg = $this$corruptTerrain.registryAccess().registryOrThrow(Registries.BLOCK);
        for (PartialBlockPos loc : TerrainCorrupterKt.createTerrainCorruptionQueue($this$corruptTerrain, center, radius, ratio)) {
            Holder block;
            BlockPos pos;
            Optional optional = reg.getOrCreateTag(TBSTags.TERRAIN_CORRUPT_REPLACE).getRandomElement($this$corruptTerrain.random);
            Intrinsics.checkNotNullExpressionValue((Object)optional, (String)"getRandomElement(...)");
            if ((Holder)OptionalsKt.getOrNull((Optional)optional) == null || $this$corruptTerrain.getBlockState(pos = loc.finish($this$corruptTerrain)).is((Holder)TBSBlocks.CORRUPTED_COMMAND_BLOCK)) continue;
            Object object = block.value();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"value(...)");
            $this$corruptTerrain.setBlock(pos, BlockUtil.default((Block)((Block)object)), 3);
        }
    }

    public static /* synthetic */ void corruptTerrain$default(Level level, BlockPos blockPos, int n, float f, int n2, Object object) {
        if ((n2 & 4) != 0) {
            f = 0.3f;
        }
        TerrainCorrupterKt.corruptTerrain(level, blockPos, n, f);
    }
}

