/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.math.Axis
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.Random
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.util.FastColor$ARGB32
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.thebrokenscript.brokencore.api.animation.value_animation.Easing
 *  net.thebrokenscript.brokencore.api.client.util.ClientTickTimer
 *  net.thebrokenscript.brokencore.api.ext.MiscExt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.client.gui;

import com.mojang.math.Axis;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.animation.value_animation.Easing;
import net.thebrokenscript.brokencore.api.client.util.ClientTickTimer;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0017J\u001e\u0010\"\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0017J\u001e\u0010#\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0017R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006%"}, d2={"Lnet/thebrokenscript/client/gui/FakeExitButton;", "", "<init>", "()V", "rotation", "", "getRotation", "()F", "setRotation", "(F)V", "yOffset", "getYOffset", "setYOffset", "maxShakeOffset", "getMaxShakeOffset", "setMaxShakeOffset", "started", "", "getStarted", "()Z", "setStarted", "(Z)V", "stage", "", "getStage", "()I", "setStage", "(I)V", "render", "", "cx", "Lnet/minecraft/client/gui/GuiGraphics;", "x", "y", "renderGlitched", "renderFalling", "Companion", "thebrokenscript-common"})
public final class FakeExitButton {
    @NotNull
    private static final Companion Companion = new Companion(null);
    private float rotation;
    private float yOffset;
    private float maxShakeOffset = 20.0f;
    private boolean started;
    private int stage;
    @Deprecated
    @JvmField
    @NotNull
    public static String metaType = "glitch";

    public final float getRotation() {
        return this.rotation;
    }

    public final void setRotation(float f) {
        this.rotation = f;
    }

    public final float getYOffset() {
        return this.yOffset;
    }

    public final void setYOffset(float f) {
        this.yOffset = f;
    }

    public final float getMaxShakeOffset() {
        return this.maxShakeOffset;
    }

    public final void setMaxShakeOffset(float f) {
        this.maxShakeOffset = f;
    }

    public final boolean getStarted() {
        return this.started;
    }

    public final void setStarted(boolean bl) {
        this.started = bl;
    }

    public final int getStage() {
        return this.stage;
    }

    public final void setStage(int n) {
        this.stage = n;
    }

    public final void render(@NotNull GuiGraphics cx, int x, int y) {
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        String string = metaType;
        if (Intrinsics.areEqual((Object)string, (Object)"corrupt")) {
            this.renderFalling(cx, x, y);
        } else if (Intrinsics.areEqual((Object)string, (Object)"glitch")) {
            this.renderGlitched(cx, x, y);
        }
    }

    public final void renderGlitched(@NotNull GuiGraphics cx, int x, int y) {
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        ResourceLocation texture = TBSConstants.id("textures/gui/glitched_quit_button.png");
        ClientTickTimer shakeTimer = new ClientTickTimer();
        if (this.started && this.stage == 0) {
            this.stage = 1;
            shakeTimer.doOnTick((arg_0, arg_1, arg_2) -> FakeExitButton.renderGlitched$lambda$0(this, arg_0, arg_1, arg_2));
            shakeTimer.start(20);
        }
        float shakeDelta = this.maxShakeOffset / 20.0f;
        float rx = Mth.nextFloat((RandomSource)RandomSource.create(), (float)-3.0f, (float)3.0f) * shakeDelta;
        float ry = Mth.nextFloat((RandomSource)RandomSource.create(), (float)-3.0f, (float)3.0f) * shakeDelta;
        int col = FastColor.ARGB32.colorFromFloat((float)shakeDelta, (float)1.0f, (float)1.0f, (float)1.0f);
        cx.pose().pushPose();
        cx.pose().translate(rx + (float)x - (float)3, ry + this.yOffset + (float)y, 0.0f);
        MiscExt.blit((GuiGraphics)cx, (ResourceLocation)texture, (int)0, (int)0, (float)0.0f, (float)0.0f, (int)204, (int)20, (int)204, (int)20, (int)0, (int)col);
        cx.pose().popPose();
    }

    public final void renderFalling(@NotNull GuiGraphics cx, int x, int y) {
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        if (this.started && this.stage == 0) {
            this.stage = 1;
            ClientTickTimer shakeTimer = new ClientTickTimer();
            shakeTimer.doOnTick((arg_0, arg_1, arg_2) -> FakeExitButton.renderFalling$lambda$0(this, arg_0, arg_1, arg_2));
            shakeTimer.doOnEnd(arg_0 -> FakeExitButton.renderFalling$lambda$1(shakeTimer, this, arg_0));
            shakeTimer.start(20);
        }
        if (this.stage == 1) {
            cx.pose().pushPose();
            float shakeDelta = this.maxShakeOffset / 20.0f;
            float rx = Mth.nextFloat((RandomSource)RandomSource.create(), (float)-3.0f, (float)3.0f) * shakeDelta;
            float ry = Mth.nextFloat((RandomSource)RandomSource.create(), (float)-3.0f, (float)3.0f) * shakeDelta;
            cx.pose().translate(rx + (float)x, ry + this.yOffset + (float)y, 0.0f);
            cx.pose().mulPose(Axis.ZP.rotationDegrees(this.rotation));
            cx.pose().translate(-2.0f, 0.0f, 0.0f);
            Object[] objectArray = new ResourceLocation[]{TBSConstants.id("textures/gui/corrupted_quit_button_1.png"), TBSConstants.id("textures/gui/corrupted_quit_button_2.png"), TBSConstants.id("textures/gui/corrupted_quit_button_3.png")};
            ResourceLocation texture = (ResourceLocation)ArraysKt.random((Object[])objectArray, (Random)((Random)Random.Default));
            cx.blit(texture, 0, 0, 0.0f, 0.0f, 204, 20, 204, 20);
            cx.pose().translate(rx, ry + this.yOffset, 0.0f);
            cx.pose().popPose();
        }
    }

    private static final Unit renderGlitched$lambda$0(FakeExitButton this$0, int n, float f, Minecraft minecraft) {
        Intrinsics.checkNotNullParameter((Object)minecraft, (String)"<unused var>");
        this$0.maxShakeOffset = Math.max(0.0f, this$0.maxShakeOffset - 1.0f);
        return Unit.INSTANCE;
    }

    private static final Unit renderFalling$lambda$0(FakeExitButton this$0, int n, float f, Minecraft minecraft) {
        Intrinsics.checkNotNullParameter((Object)minecraft, (String)"<unused var>");
        this$0.maxShakeOffset = Math.max(0.0f, this$0.maxShakeOffset - 1.0f);
        return Unit.INSTANCE;
    }

    private static final Unit renderFalling$lambda$1(ClientTickTimer $shakeTimer, FakeExitButton this$0, Minecraft it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ClientTickTimer rotateTimerA = new ClientTickTimer();
        rotateTimerA.doOnTick((arg_0, arg_1, arg_2) -> FakeExitButton.renderFalling$lambda$1$0(this$0, rotateTimerA, arg_0, arg_1, arg_2));
        rotateTimerA.doOnEnd(arg_0 -> FakeExitButton.renderFalling$lambda$1$1(rotateTimerA, this$0, arg_0));
        rotateTimerA.start(20);
        $shakeTimer.free();
        return Unit.INSTANCE;
    }

    private static final Unit renderFalling$lambda$1$0(FakeExitButton this$0, ClientTickTimer $rotateTimerA, int n, float f, Minecraft minecraft) {
        Intrinsics.checkNotNullParameter((Object)minecraft, (String)"<unused var>");
        this$0.rotation = Easing.Companion.getCUBIC_IN().ease($rotateTimerA.getTimeLeft(), 0.0f, 45.0f, 20.0f);
        return Unit.INSTANCE;
    }

    private static final Unit renderFalling$lambda$1$1(ClientTickTimer $rotateTimerA, FakeExitButton this$0, Minecraft it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ClientTickTimer rotateTimerB = new ClientTickTimer();
        rotateTimerB.doOnTick((arg_0, arg_1, arg_2) -> FakeExitButton.renderFalling$lambda$1$1$0(this$0, rotateTimerB, arg_0, arg_1, arg_2));
        rotateTimerB.doOnEnd(arg_0 -> FakeExitButton.renderFalling$lambda$1$1$1(rotateTimerB, arg_0));
        rotateTimerB.start(20);
        $rotateTimerA.free();
        return Unit.INSTANCE;
    }

    private static final Unit renderFalling$lambda$1$1$0(FakeExitButton this$0, ClientTickTimer $rotateTimerB, int n, float f, Minecraft minecraft) {
        Intrinsics.checkNotNullParameter((Object)minecraft, (String)"<unused var>");
        this$0.rotation = Easing.Companion.getBACK_OUT().ease($rotateTimerB.getTimeLeft(), 45.0f, 45.0f, 20.0f);
        if (Math.floor($rotateTimerB.getTimeLeft()) == 15.0) {
            ClientTickTimer fallTimer = new ClientTickTimer();
            fallTimer.doOnTick((arg_0, arg_1, arg_2) -> FakeExitButton.renderFalling$lambda$1$1$0$0(this$0, fallTimer, arg_0, arg_1, arg_2));
            fallTimer.doOnEnd(arg_0 -> FakeExitButton.renderFalling$lambda$1$1$0$1(fallTimer, arg_0));
            fallTimer.start(200);
        }
        return Unit.INSTANCE;
    }

    private static final Unit renderFalling$lambda$1$1$0$0(FakeExitButton this$0, ClientTickTimer $fallTimer, int n, float f, Minecraft minecraft) {
        Intrinsics.checkNotNullParameter((Object)minecraft, (String)"<unused var>");
        this$0.yOffset = Easing.Companion.getSINE_IN().ease($fallTimer.getTimeLeft(), 0.0f, 8000.0f, 200.0f);
        return Unit.INSTANCE;
    }

    private static final Unit renderFalling$lambda$1$1$0$1(ClientTickTimer $fallTimer, Minecraft it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        $fallTimer.free();
        return Unit.INSTANCE;
    }

    private static final Unit renderFalling$lambda$1$1$1(ClientTickTimer $rotateTimerB, Minecraft it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        $rotateTimerB.free();
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/client/gui/FakeExitButton$Companion;", "", "<init>", "()V", "metaType", "", "thebrokenscript-common"})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

