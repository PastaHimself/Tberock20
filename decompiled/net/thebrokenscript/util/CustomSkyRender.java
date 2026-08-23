/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  net.minecraft.client.Camera
 *  net.minecraft.client.multiplayer.ClientLevel
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Matrix4f
 */
package net.thebrokenscript.util;

import kotlin.Metadata;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JH\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/util/CustomSkyRender;", "", "renderSky", "", "level", "Lnet/minecraft/client/multiplayer/ClientLevel;", "ticks", "", "partialTick", "", "modelViewMatrix", "Lorg/joml/Matrix4f;", "camera", "Lnet/minecraft/client/Camera;", "projectionMatrix", "isFoggy", "", "setupFog", "Ljava/lang/Runnable;", "thebrokenscript-common"})
public interface CustomSkyRender {
    public void renderSky(@NotNull ClientLevel var1, int var2, float var3, @NotNull Matrix4f var4, @NotNull Camera var5, @NotNull Matrix4f var6, boolean var7, @NotNull Runnable var8);
}

