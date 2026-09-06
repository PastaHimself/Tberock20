/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MouseHandler
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package net.thebrokenscript.brokencore.impl.mixin.client.features.gui;

import net.minecraft.client.MouseHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={MouseHandler.class})
public interface MouseHandlerInvoker {
    @Invoker(value="turnPlayer")
    public void bc$turnPlayer(double var1);

    @Accessor(value="lastHandleMovementTime")
    public double bc$getLastTime();

    @Accessor(value="lastHandleMovementTime")
    public void bc$setLastTime(double var1);
}

