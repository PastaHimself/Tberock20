/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.server.MinecraftServer
 *  org.jetbrains.annotations.NotNull
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.brokencore.impl.mixin.features.queue;

import net.minecraft.server.MinecraftServer;
import net.thebrokenscript.brokencore.api.ext.MinecraftServerExt;
import net.thebrokenscript.brokencore.api.queue.WorkQueue;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={MinecraftServer.class})
public abstract class MinecraftServerMixin
implements MinecraftServerExt {
    @Unique
    private WorkQueue bc$queue;

    @Shadow
    public abstract void addTickable(Runnable var1);

    @Inject(method={"<init>"}, at={@At(value="TAIL")})
    public void bc$init(CallbackInfo ci) {
        this.bc$queue = new WorkQueue();
        this.addTickable(this.bc$queue::tick);
    }

    @Override
    @NotNull
    public WorkQueue getBc_queue() {
        return this.bc$queue;
    }
}

