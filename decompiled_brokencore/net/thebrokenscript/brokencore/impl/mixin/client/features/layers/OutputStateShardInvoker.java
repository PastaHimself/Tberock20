/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.RenderStateShard$OutputStateShard
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package net.thebrokenscript.brokencore.impl.mixin.client.features.layers;

import net.minecraft.client.renderer.RenderStateShard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={RenderStateShard.OutputStateShard.class})
public interface OutputStateShardInvoker {
    @Invoker(value="<init>")
    public static RenderStateShard.OutputStateShard bc$newShard(String name, Runnable setup2, Runnable clear) {
        throw new AssertionError();
    }
}

