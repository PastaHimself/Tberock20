/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.chunk.storage.RegionFileStorage
 *  net.minecraft.world.level.chunk.storage.RegionStorageInfo
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.mixins.features.bossfight;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.storage.RegionFileStorage;
import net.minecraft.world.level.chunk.storage.RegionStorageInfo;
import net.thebrokenscript.registry.TBSDimensions;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={RegionFileStorage.class})
public class Stage2RegionStorageMixin {
    @Shadow
    @Final
    private RegionStorageInfo info;

    @Inject(method={"write"}, at={@At(value="HEAD")}, cancellable=true)
    private void tbs$dontSaveDimension(ChunkPos chunkPos, CompoundTag chunkData, CallbackInfo ci) {
        ResourceKey dim = this.info.dimension();
        if (dim == TBSDimensions.STAGE2) {
            ci.cancel();
        }
    }
}

