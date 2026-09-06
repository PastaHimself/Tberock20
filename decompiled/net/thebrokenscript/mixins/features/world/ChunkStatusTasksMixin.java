/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.server.level.GenerationChunkHolder
 *  net.minecraft.util.StaticCache2D
 *  net.minecraft.world.level.chunk.ChunkAccess
 *  net.minecraft.world.level.chunk.status.ChunkStatusTasks
 *  net.minecraft.world.level.chunk.status.ChunkStep
 *  net.minecraft.world.level.chunk.status.WorldGenContext
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.mixins.features.world;

import java.util.concurrent.CompletableFuture;
import net.minecraft.server.level.GenerationChunkHolder;
import net.minecraft.util.StaticCache2D;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.status.ChunkStatusTasks;
import net.minecraft.world.level.chunk.status.ChunkStep;
import net.minecraft.world.level.chunk.status.WorldGenContext;
import net.thebrokenscript.world.ChunkDistTracker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={ChunkStatusTasks.class})
public class ChunkStatusTasksMixin {
    @Inject(method={"generateSurface"}, at={@At(value="HEAD")})
    private static void tbs$trackChunkPos(WorldGenContext worldGenContext, ChunkStep step, StaticCache2D<GenerationChunkHolder> cache, ChunkAccess chunk, CallbackInfoReturnable<CompletableFuture<ChunkAccess>> cir) {
        int cx = chunk.getPos().x;
        int cz = chunk.getPos().z;
        int minX = ChunkDistTracker.minChunkX.get();
        int minZ = ChunkDistTracker.minChunkZ.get();
        int maxX = ChunkDistTracker.maxChunkX.get();
        int maxZ = ChunkDistTracker.maxChunkZ.get();
        if (cx < minX) {
            ChunkDistTracker.minChunkX.set(cx);
        }
        if (cx > maxX) {
            ChunkDistTracker.maxChunkX.set(cx);
        }
        if (cz < minZ) {
            ChunkDistTracker.minChunkZ.set(cz);
        }
        if (cz > maxZ) {
            ChunkDistTracker.maxChunkZ.set(cz);
        }
    }
}

