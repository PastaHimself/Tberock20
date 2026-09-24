/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.ClosedRange
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector2i
 */
package net.thebrokenscript.brokencore.api.client.gui.range;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractSlider;
import net.thebrokenscript.brokencore.api.client.gui.settings.SliderSettings;
import net.thebrokenscript.brokencore.api.client.gui.settings.SpriteScalingSettings;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2i;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0087\u0001\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n\u00128\b\u0002\u0010\u000f\u001a2\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0010\u00a2\u0006\u0004\b\u0017\u0010\u0018B_\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u00126\u0010\u000f\u001a2\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0010\u00a2\u0006\u0004\b\u0017\u0010\u001bJ\b\u0010\u001d\u001a\u00020\u0014H\u0002J(\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!H\u0016J(\u00102\u001a\u0002032\u0006\u00104\u001a\u00020&2\u0006\u00105\u001a\u00020&2\u0006\u00106\u001a\u00020&2\u0006\u00107\u001a\u00020&H\u0016J\b\u00108\u001a\u00020\u0016H\u0016J\b\u00109\u001a\u00020\u0014H\u0016R\u000e\u0010\u001c\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020&@VX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010,\u001a\u00020&2\u0006\u0010%\u001a\u00020&8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R$\u0010/\u001a\u00020&2\u0006\u0010%\u001a\u00020&8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b0\u0010)\"\u0004\b1\u0010+\u00a8\u0006:"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/range/HSlider;", "T", "", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractSlider;", "range", "Lkotlin/ranges/ClosedRange;", "step", "bgScaling", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;", "bgSprite", "Lnet/minecraft/resources/ResourceLocation;", "grabberScaling", "grabberNormal", "grabberHovered", "grabberHeld", "changeCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "newValue", "", "delta", "", "<init>", "(Lkotlin/ranges/ClosedRange;Ljava/lang/Comparable;Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;Lnet/minecraft/resources/ResourceLocation;Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lkotlin/jvm/functions/Function2;)V", "sliderSettings", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/SliderSettings;", "(Lkotlin/ranges/ClosedRange;Ljava/lang/Comparable;Lnet/thebrokenscript/brokencore/api/client/gui/settings/SliderSettings;Lkotlin/jvm/functions/Function2;)V", "deltaScalar", "calcDeltaScalar", "mouseScrolled", "", "mouseX", "", "mouseY", "scrollX", "scrollY", "value", "", "grabberLength", "getGrabberLength", "()I", "setGrabberLength", "(I)V", "h", "getH", "setH", "w", "getW", "setW", "grabberMoved", "Lorg/joml/Vector2i;", "localMouseX", "localMouseY", "localClickX", "localClickY", "resetGrabber", "getLerpDelta", "brokencore-common"})
public final class HSlider<T extends Comparable<? super T>>
extends AbstractSlider<T> {
    private float deltaScalar;
    private int grabberLength;

    public HSlider(@NotNull ClosedRange<T> range, @NotNull T step, @NotNull SpriteScalingSettings bgScaling, @NotNull ResourceLocation bgSprite, @NotNull SpriteScalingSettings grabberScaling, @NotNull ResourceLocation grabberNormal, @NotNull ResourceLocation grabberHovered, @NotNull ResourceLocation grabberHeld, @NotNull Function2<? super T, ? super Float, Unit> changeCallback) {
        Intrinsics.checkNotNullParameter(range, (String)"range");
        Intrinsics.checkNotNullParameter(step, (String)"step");
        Intrinsics.checkNotNullParameter((Object)bgScaling, (String)"bgScaling");
        Intrinsics.checkNotNullParameter((Object)bgSprite, (String)"bgSprite");
        Intrinsics.checkNotNullParameter((Object)grabberScaling, (String)"grabberScaling");
        Intrinsics.checkNotNullParameter((Object)grabberNormal, (String)"grabberNormal");
        Intrinsics.checkNotNullParameter((Object)grabberHovered, (String)"grabberHovered");
        Intrinsics.checkNotNullParameter((Object)grabberHeld, (String)"grabberHeld");
        Intrinsics.checkNotNullParameter(changeCallback, (String)"changeCallback");
        super(range, step, bgScaling, bgSprite, grabberScaling, grabberNormal, grabberHovered, grabberHeld, changeCallback);
        this.deltaScalar = this.calcDeltaScalar();
        this.grabberLength = 12;
    }

    public /* synthetic */ HSlider(ClosedRange closedRange, Comparable comparable, SpriteScalingSettings spriteScalingSettings, ResourceLocation resourceLocation, SpriteScalingSettings spriteScalingSettings2, ResourceLocation resourceLocation2, ResourceLocation resourceLocation3, ResourceLocation resourceLocation4, Function2 function2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 0x100) != 0) {
            function2 = HSlider::_init_$lambda$0;
        }
        this(closedRange, comparable, spriteScalingSettings, resourceLocation, spriteScalingSettings2, resourceLocation2, resourceLocation3, resourceLocation4, function2);
    }

    private final float calcDeltaScalar() {
        return 1.0f / (float)(this.getW() - this.getGrabberLength() - this.getBgScaling().getH());
    }

    public HSlider(@NotNull ClosedRange<T> range, @NotNull T step, @NotNull SliderSettings sliderSettings, @NotNull Function2<? super T, ? super Float, Unit> changeCallback) {
        Intrinsics.checkNotNullParameter(range, (String)"range");
        Intrinsics.checkNotNullParameter(step, (String)"step");
        Intrinsics.checkNotNullParameter((Object)sliderSettings, (String)"sliderSettings");
        Intrinsics.checkNotNullParameter(changeCallback, (String)"changeCallback");
        this((ClosedRange<? super T>)range, (T)step, sliderSettings.getBgScaling(), sliderSettings.getBgSprite(), sliderSettings.getGrabberScaling(), sliderSettings.getGrabberNormal(), sliderSettings.getGrabberHovered(), sliderSettings.getGrabberHeld(), (Function2<? super T, Float, Unit>)changeCallback);
    }

    public boolean mouseScrolled(double mouseX, double mouseY, double scrollX, double scrollY) {
        if (this.isMouseOver((int)mouseX, (int)mouseY)) {
            int ofs = Math.clamp((long)this.getGrabber().getX() - (long)scrollY * (long)4, 0, Math.max(this.getW() - this.getGrabber().getW(), 1));
            this.getGrabber().setX(ofs);
            this.getDragBox().setX(ofs);
            float delta = this.getLerpDelta();
            this.getChangeCallback().invoke(this.getLerpedValue(delta), (Object)Float.valueOf(delta));
        }
        return true;
    }

    @Override
    public int getGrabberLength() {
        return this.grabberLength;
    }

    @Override
    public void setGrabberLength(int value) {
        this.getGrabber().setW(value);
        this.getDragBox().setW(Math.min(value, this.getGrabber().getW()));
        this.grabberLength = value;
        this.deltaScalar = this.calcDeltaScalar();
    }

    @Override
    public int getH() {
        return super.getH();
    }

    @Override
    public void setH(int value) {
        super.setH(value);
        this.getGrabber().setH(value);
        this.getDragBox().setH(value);
    }

    @Override
    public int getW() {
        return super.getW();
    }

    @Override
    public void setW(int value) {
        if (value != this.getW()) {
            this.deltaScalar = this.calcDeltaScalar();
            super.setW(Math.max(this.getGrabberLength(), value));
        } else {
            super.setW(Math.max(this.getGrabberLength(), value));
        }
    }

    @Override
    @NotNull
    public Vector2i grabberMoved(int localMouseX, int localMouseY, int localClickX, int localClickY) {
        int ofs = Math.clamp((long)(localMouseX - localClickX - this.getGlobalX()), 0, Math.max(this.getW() - this.getGrabber().getW(), 1));
        return new Vector2i(ofs, 0);
    }

    @Override
    public void resetGrabber() {
        if (this.getGrabber().getX() != 0) {
            this.getGrabber().setX(0);
            this.getDragBox().setX(0);
            this.getChangeCallback().invoke(this.getLerpedValue(0.0f), (Object)Float.valueOf(0.0f));
        }
    }

    @Override
    public float getLerpDelta() {
        return (float)this.getGrabber().getX() * this.deltaScalar;
    }

    private static final Unit _init_$lambda$0(Comparable comparable, float f) {
        Intrinsics.checkNotNullParameter((Object)comparable, (String)"<unused var>");
        return Unit.INSTANCE;
    }
}

