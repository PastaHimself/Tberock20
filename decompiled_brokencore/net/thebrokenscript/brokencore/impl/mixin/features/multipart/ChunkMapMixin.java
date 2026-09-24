/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.server.level.ChunkMap
 *  net.minecraft.world.entity.Entity
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.brokencore.impl.mixin.features.multipart;

import net.minecraft.server.level.ChunkMap;
import net.minecraft.world.entity.Entity;
import net.thebrokenscript.brokencore.api.entity.multipart.MultipartEntityPart;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={ChunkMap.class})
public class ChunkMapMixin {
    @Inject(method={"addEntity"}, at={@At(value="HEAD")}, cancellable=true)
    public void bc$preventMultipartAdd(Entity entity, CallbackInfo ci) {
        if (entity instanceof MultipartEntityPart) {
            ci.cancel();
        }
    }
}

