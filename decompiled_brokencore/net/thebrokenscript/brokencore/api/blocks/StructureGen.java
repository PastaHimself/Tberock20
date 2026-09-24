/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.level.block.Block
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.blocks;

import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0004\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007\"\b\b\u0001\u0010\b*\u00020\u0007*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00060\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\b0\r\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/api/blocks/StructureGen;", "", "<init>", "()V", "recurseGenerator", "", "I", "Lnet/minecraft/world/level/block/Block;", "G", "Lnet/minecraft/server/level/ServerLevel;", "pos", "Lnet/minecraft/core/BlockPos;", "ignoreTrigger", "Ljava/util/function/Supplier;", "generator", "brokencore-common"})
public final class StructureGen {
    @NotNull
    public static final StructureGen INSTANCE = new StructureGen();

    private StructureGen() {
    }

    public final <I extends Block, G extends Block> void recurseGenerator(@NotNull ServerLevel $this$recurseGenerator, @NotNull BlockPos pos, @NotNull Supplier<I> ignoreTrigger, @NotNull Supplier<G> generator) {
        Intrinsics.checkNotNullParameter((Object)$this$recurseGenerator, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter(ignoreTrigger, (String)"ignoreTrigger");
        Intrinsics.checkNotNullParameter(generator, (String)"generator");
        if (!$this$recurseGenerator.getBlockState(pos).is((Block)ignoreTrigger.get())) {
            $this$recurseGenerator.setBlock(pos, ((Block)generator.get()).defaultBlockState(), 3);
        }
    }
}

