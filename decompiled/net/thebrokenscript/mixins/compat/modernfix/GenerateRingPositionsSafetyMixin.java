/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.Util
 *  net.minecraft.world.level.chunk.ChunkGeneratorStructureState
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.ModifyArg
 */
package net.thebrokenscript.mixins.compat.modernfix;

import java.util.concurrent.Executor;
import net.minecraft.Util;
import net.minecraft.world.level.chunk.ChunkGeneratorStructureState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value={ChunkGeneratorStructureState.class})
public class GenerateRingPositionsSafetyMixin {
    @ModifyArg(method={"generateRingPositions"}, at=@At(value="INVOKE", target="Ljava/util/concurrent/CompletableFuture;supplyAsync(Ljava/util/function/Supplier;Ljava/util/concurrent/Executor;)Ljava/util/concurrent/CompletableFuture;"), index=1)
    private static Executor tbs$fallbackExecutor(Executor executor) {
        return executor != null ? executor : Util.backgroundExecutor();
    }
}

