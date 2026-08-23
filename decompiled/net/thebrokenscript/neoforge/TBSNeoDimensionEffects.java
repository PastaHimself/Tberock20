/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Camera
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.renderer.DimensionSpecialEffects
 *  net.minecraft.client.renderer.DimensionSpecialEffects$SkyType
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Matrix4f
 */
package net.thebrokenscript.neoforge;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.util.CustomSkyRender;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJH\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000fH\u0016J\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2={"Lnet/thebrokenscript/neoforge/TBSNeoDimensionEffects;", "Lnet/minecraft/client/renderer/DimensionSpecialEffects;", "renderer", "Lnet/thebrokenscript/util/CustomSkyRender;", "isLimboFX", "", "isVoidFX", "<init>", "(Lnet/thebrokenscript/util/CustomSkyRender;ZZ)V", "renderSky", "level", "Lnet/minecraft/client/multiplayer/ClientLevel;", "ticks", "", "partialTick", "", "modelViewMatrix", "Lorg/joml/Matrix4f;", "camera", "Lnet/minecraft/client/Camera;", "projectionMatrix", "isFoggy", "setupFog", "Ljava/lang/Runnable;", "getCloudHeight", "getBrightnessDependentFogColor", "Lnet/minecraft/world/phys/Vec3;", "color", "sunHeight", "isFoggyAt", "x", "y", "thebrokenscript-neoforge"})
public final class TBSNeoDimensionEffects
extends DimensionSpecialEffects {
    @NotNull
    private final CustomSkyRender renderer;
    private final boolean isLimboFX;
    private final boolean isVoidFX;

    public TBSNeoDimensionEffects(@NotNull CustomSkyRender renderer, boolean isLimboFX, boolean isVoidFX) {
        Intrinsics.checkNotNullParameter((Object)renderer, (String)"renderer");
        super(Float.NaN, true, DimensionSpecialEffects.SkyType.NONE, false, false);
        this.renderer = renderer;
        this.isLimboFX = isLimboFX;
        this.isVoidFX = isVoidFX;
    }

    public /* synthetic */ TBSNeoDimensionEffects(CustomSkyRender customSkyRender, boolean bl, boolean bl2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            bl = false;
        }
        if ((n & 4) != 0) {
            bl2 = false;
        }
        this(customSkyRender, bl, bl2);
    }

    public boolean renderSky(@NotNull ClientLevel level, int ticks, float partialTick, @NotNull Matrix4f modelViewMatrix, @NotNull Camera camera, @NotNull Matrix4f projectionMatrix, boolean isFoggy, @NotNull Runnable setupFog) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)modelViewMatrix, (String)"modelViewMatrix");
        Intrinsics.checkNotNullParameter((Object)camera, (String)"camera");
        Intrinsics.checkNotNullParameter((Object)projectionMatrix, (String)"projectionMatrix");
        Intrinsics.checkNotNullParameter((Object)setupFog, (String)"setupFog");
        this.renderer.renderSky(level, ticks, partialTick, modelViewMatrix, camera, projectionMatrix, isFoggy, setupFog);
        return true;
    }

    public float getCloudHeight() {
        return Float.NaN;
    }

    @NotNull
    public Vec3 getBrightnessDependentFogColor(@NotNull Vec3 color, float sunHeight) {
        Vec3 vec3;
        Intrinsics.checkNotNullParameter((Object)color, (String)"color");
        if (this.isVoidFX) {
            return new Vec3(0.0, 0.0, 0.0);
        }
        if (this.isLimboFX) {
            Vec3 vec32 = color.scale(0.15);
            Intrinsics.checkNotNull((Object)vec32);
            vec3 = vec32;
        } else {
            vec3 = color;
        }
        return vec3;
    }

    public boolean isFoggyAt(int x, int y) {
        return false;
    }
}

