/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.Blaze3D
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.MouseHandler
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.renderer.texture.TextureAtlasSprite
 *  net.minecraft.client.resources.metadata.gui.GuiSpriteScaling$NineSlice
 *  net.minecraft.client.resources.metadata.gui.GuiSpriteScaling$NineSlice$Border
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 */
package net.thebrokenscript.brokencore.api.client.util;

import com.mojang.blaze3d.Blaze3D;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHandler;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.metadata.gui.GuiSpriteScaling;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.impl.mixin.client.features.gui.GuiGraphicsInvoker;
import net.thebrokenscript.brokencore.impl.mixin.client.features.gui.MouseHandlerInvoker;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003Jj\u0010-\u001a\u00020.*\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u0002032\u0006\u00106\u001a\u0002032\u0006\u00107\u001a\u0002032\u0006\u00108\u001a\u0002032\u0006\u00109\u001a\u0002032\u0006\u0010:\u001a\u0002032\u0006\u0010;\u001a\u0002032\u0006\u0010<\u001a\u0002032\u0006\u0010=\u001a\u000203J\n\u0010>\u001a\u00020.*\u00020?Jj\u0010@\u001a\u00020.*\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u0002032\u0006\u00106\u001a\u0002032\u0006\u00107\u001a\u0002032\u0006\u0010A\u001a\u0002032\u0006\u0010B\u001a\u0002032\u0006\u0010C\u001a\u0002032\u0006\u0010D\u001a\u0002032\u0006\u0010E\u001a\u0002032\u0006\u0010F\u001a\u000203R$\u0010\u0004\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\f8\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\u00138\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u00138\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0003\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u001e8F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\f*\u00020\u001e8F\u00a2\u0006\f\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001b\u0010&\u001a\u00020\u0013*\u00020\u001e8F\u00a2\u0006\f\u0012\u0004\b'\u0010#\u001a\u0004\b(\u0010)R\u001b\u0010*\u001a\u00020\u0013*\u00020\u001e8F\u00a2\u0006\f\u0012\u0004\b+\u0010#\u001a\u0004\b,\u0010)\u00a8\u0006G"}, d2={"Lnet/thebrokenscript/brokencore/api/client/util/ClientMixinBridge;", "", "<init>", "()V", "trueFov", "", "getTrueFov$brokencore_common$annotations", "getTrueFov$brokencore_common", "()D", "setTrueFov$brokencore_common", "(D)V", "trueCameraQuaternion", "Lorg/joml/Quaternionf;", "getTrueCameraQuaternion$brokencore_common$annotations", "getTrueCameraQuaternion$brokencore_common", "()Lorg/joml/Quaternionf;", "setTrueCameraQuaternion$brokencore_common", "(Lorg/joml/Quaternionf;)V", "trueWorldProjMat", "Lorg/joml/Matrix4f;", "getTrueWorldProjMat$brokencore_common$annotations", "getTrueWorldProjMat$brokencore_common", "()Lorg/joml/Matrix4f;", "setTrueWorldProjMat$brokencore_common", "(Lorg/joml/Matrix4f;)V", "trueWorldModelMat", "getTrueWorldModelMat$brokencore_common$annotations", "getTrueWorldModelMat$brokencore_common", "setTrueWorldModelMat$brokencore_common", "fov", "Lnet/minecraft/client/Minecraft;", "getFov", "(Lnet/minecraft/client/Minecraft;)D", "cameraQuaternion", "getCameraQuaternion$annotations", "(Lnet/minecraft/client/Minecraft;)V", "getCameraQuaternion", "(Lnet/minecraft/client/Minecraft;)Lorg/joml/Quaternionf;", "worldProjectionMatrix", "getWorldProjectionMatrix$annotations", "getWorldProjectionMatrix", "(Lnet/minecraft/client/Minecraft;)Lorg/joml/Matrix4f;", "worldModelMatrix", "getWorldModelMatrix$annotations", "getWorldModelMatrix", "blitTiled", "", "Lnet/minecraft/client/gui/GuiGraphics;", "sprite", "Lnet/minecraft/resources/ResourceLocation;", "x", "", "y", "blitOffset", "width", "height", "uPosition", "vPosition", "spriteWidth", "spriteHeight", "nineSliceWidth", "nineSliceHeight", "turnPlayer", "Lnet/minecraft/client/MouseHandler;", "blitNineSliced", "npWidth", "npHeight", "lPadding", "rPadding", "tPadding", "bPadding", "brokencore-common"})
public final class ClientMixinBridge {
    @NotNull
    public static final ClientMixinBridge INSTANCE = new ClientMixinBridge();
    private static double trueFov;
    @NotNull
    private static Quaternionf trueCameraQuaternion;
    @NotNull
    private static Matrix4f trueWorldProjMat;
    @NotNull
    private static Matrix4f trueWorldModelMat;

    private ClientMixinBridge() {
    }

    public static final double getTrueFov$brokencore_common() {
        return trueFov;
    }

    public static final void setTrueFov$brokencore_common(double d) {
        trueFov = d;
    }

    @JvmStatic
    public static /* synthetic */ void getTrueFov$brokencore_common$annotations() {
    }

    @NotNull
    public static final Quaternionf getTrueCameraQuaternion$brokencore_common() {
        return trueCameraQuaternion;
    }

    public static final void setTrueCameraQuaternion$brokencore_common(@NotNull Quaternionf quaternionf) {
        Intrinsics.checkNotNullParameter((Object)quaternionf, (String)"<set-?>");
        trueCameraQuaternion = quaternionf;
    }

    @JvmStatic
    public static /* synthetic */ void getTrueCameraQuaternion$brokencore_common$annotations() {
    }

    @NotNull
    public static final Matrix4f getTrueWorldProjMat$brokencore_common() {
        return trueWorldProjMat;
    }

    public static final void setTrueWorldProjMat$brokencore_common(@NotNull Matrix4f matrix4f) {
        Intrinsics.checkNotNullParameter((Object)matrix4f, (String)"<set-?>");
        trueWorldProjMat = matrix4f;
    }

    @JvmStatic
    public static /* synthetic */ void getTrueWorldProjMat$brokencore_common$annotations() {
    }

    @NotNull
    public static final Matrix4f getTrueWorldModelMat$brokencore_common() {
        return trueWorldModelMat;
    }

    public static final void setTrueWorldModelMat$brokencore_common(@NotNull Matrix4f matrix4f) {
        Intrinsics.checkNotNullParameter((Object)matrix4f, (String)"<set-?>");
        trueWorldModelMat = matrix4f;
    }

    @JvmStatic
    public static /* synthetic */ void getTrueWorldModelMat$brokencore_common$annotations() {
    }

    public final double getFov(@NotNull Minecraft $this$fov) {
        Intrinsics.checkNotNullParameter((Object)$this$fov, (String)"<this>");
        return trueFov;
    }

    @NotNull
    public final Quaternionf getCameraQuaternion(@NotNull Minecraft $this$cameraQuaternion) {
        Intrinsics.checkNotNullParameter((Object)$this$cameraQuaternion, (String)"<this>");
        return new Quaternionf((Quaternionfc)trueCameraQuaternion);
    }

    public static /* synthetic */ void getCameraQuaternion$annotations(Minecraft minecraft) {
    }

    @NotNull
    public final Matrix4f getWorldProjectionMatrix(@NotNull Minecraft $this$worldProjectionMatrix) {
        Intrinsics.checkNotNullParameter((Object)$this$worldProjectionMatrix, (String)"<this>");
        return new Matrix4f((Matrix4fc)trueWorldProjMat);
    }

    public static /* synthetic */ void getWorldProjectionMatrix$annotations(Minecraft minecraft) {
    }

    @NotNull
    public final Matrix4f getWorldModelMatrix(@NotNull Minecraft $this$worldModelMatrix) {
        Intrinsics.checkNotNullParameter((Object)$this$worldModelMatrix, (String)"<this>");
        return new Matrix4f((Matrix4fc)trueWorldModelMat);
    }

    public static /* synthetic */ void getWorldModelMatrix$annotations(Minecraft minecraft) {
    }

    public final void blitTiled(@NotNull GuiGraphics $this$blitTiled, @NotNull ResourceLocation sprite, int x, int y, int blitOffset, int width, int height, int uPosition, int vPosition, int spriteWidth, int spriteHeight, int nineSliceWidth, int nineSliceHeight) {
        Intrinsics.checkNotNullParameter((Object)$this$blitTiled, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)sprite, (String)"sprite");
        TextureAtlasSprite sprite2 = ClientDSLKt.getMC().getGuiSprites().getSprite(sprite);
        GuiGraphicsInvoker cfr_ignored_0 = (GuiGraphicsInvoker)$this$blitTiled;
        ((GuiGraphicsInvoker)$this$blitTiled).bc$blitTiledSprite(sprite2, x, y, blitOffset, width, height, uPosition, vPosition, spriteWidth, spriteHeight, nineSliceWidth, nineSliceHeight);
    }

    public final void turnPlayer(@NotNull MouseHandler $this$turnPlayer) {
        Intrinsics.checkNotNullParameter((Object)$this$turnPlayer, (String)"<this>");
        MouseHandlerInvoker cfr_ignored_0 = (MouseHandlerInvoker)$this$turnPlayer;
        double lastTime = ((MouseHandlerInvoker)$this$turnPlayer).bc$getLastTime();
        double d0 = Blaze3D.getTime();
        double d1 = d0 - lastTime;
        ((MouseHandlerInvoker)$this$turnPlayer).bc$setLastTime(d0);
        ((MouseHandlerInvoker)$this$turnPlayer).bc$turnPlayer(d1);
    }

    public final void blitNineSliced(@NotNull GuiGraphics $this$blitNineSliced, @NotNull ResourceLocation sprite, int x, int y, int blitOffset, int width, int height, int npWidth, int npHeight, int lPadding, int rPadding, int tPadding, int bPadding) {
        Intrinsics.checkNotNullParameter((Object)$this$blitNineSliced, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)sprite, (String)"sprite");
        TextureAtlasSprite sprite2 = ClientDSLKt.getMC().getGuiSprites().getSprite(sprite);
        GuiSpriteScaling.NineSlice nineSlice = new GuiSpriteScaling.NineSlice(npWidth, npHeight, new GuiSpriteScaling.NineSlice.Border(lPadding, tPadding, rPadding, bPadding));
        GuiGraphicsInvoker cfr_ignored_0 = (GuiGraphicsInvoker)$this$blitNineSliced;
        ((GuiGraphicsInvoker)$this$blitNineSliced).bc$blitNineSlicedSprite(sprite2, nineSlice, x, y, blitOffset, width, height);
    }

    static {
        trueCameraQuaternion = new Quaternionf();
        trueWorldProjMat = new Matrix4f();
        trueWorldModelMat = new Matrix4f();
    }
}

