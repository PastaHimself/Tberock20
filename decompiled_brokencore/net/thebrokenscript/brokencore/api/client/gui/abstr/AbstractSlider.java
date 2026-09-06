/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.ClosedFloatingPointRange
 *  kotlin.ranges.ClosedRange
 *  net.minecraft.client.gui.components.Renderable
 *  net.minecraft.client.gui.components.events.GuiEventListener
 *  net.minecraft.client.gui.navigation.ScreenRectangle
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector2i
 */
package net.thebrokenscript.brokencore.api.client.gui.abstr;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.ClosedRange;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractGuiNode2D;
import net.thebrokenscript.brokencore.api.client.gui.impl.GuiElement;
import net.thebrokenscript.brokencore.api.client.gui.impl.Hoverable;
import net.thebrokenscript.brokencore.api.client.gui.misc.DragBox;
import net.thebrokenscript.brokencore.api.client.gui.misc.GuiSprite;
import net.thebrokenscript.brokencore.api.client.gui.settings.SliderSettings;
import net.thebrokenscript.brokencore.api.client.gui.settings.SpriteScalingSettings;
import net.thebrokenscript.brokencore.api.util.math.MathUtilKt;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2i;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0085\u0001\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\r\u00126\u0010\u0012\u001a2\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00190\u0013\u00a2\u0006\u0004\b\u001a\u0010\u001bB_\b\u0016\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u00126\u0010\u0012\u001a2\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00190\u0013\u00a2\u0006\u0004\b\u001a\u0010\u001eJ\u0018\u0010I\u001a\u00020\u00192\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020KH\u0016J\u0016\u0010M\u001a\u00020\u00192\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020KJ\b\u0010N\u001a\u00020\u0019H\u0002J \u0010O\u001a\u0002022\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020K2\u0006\u0010P\u001a\u00020<H\u0016J \u0010Q\u001a\u0002022\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020K2\u0006\u0010P\u001a\u00020<H\u0016J\b\u0010[\u001a\u00020\u0019H&J\b\u0010\\\u001a\u00020\u0017H&J(\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020<2\u0006\u0010`\u001a\u00020<2\u0006\u0010a\u001a\u00020<2\u0006\u0010b\u001a\u00020<H&J\u0015\u0010c\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0017H\u0016\u00a2\u0006\u0002\u0010dJ\b\u0010e\u001a\u00020fH\u0016J\u0010\u0010g\u001a\u00020\u00192\u0006\u0010h\u001a\u000202H\u0016J\b\u0010i\u001a\u000202H\u0016R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\t\u001a\u00028\u0000X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0011\u0010\u000f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0010\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010,R\u0011\u0010\u0011\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010,RD\u0010\u0012\u001a2\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00190\u0013X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0014\u00101\u001a\u000202X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u001a\u00105\u001a\u000202X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00104\"\u0004\b7\u00108R\u000e\u00109\u001a\u000202X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u000202X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010;\u001a\u00020<X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020BX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0011\u0010E\u001a\u00020F\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0011\u0010R\u001a\u00020F\u00a2\u0006\b\n\u0000\u001a\u0004\bS\u0010HR$\u0010U\u001a\u00020<2\u0006\u0010T\u001a\u00020<8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\bV\u0010>\"\u0004\bW\u0010@R$\u0010X\u001a\u00020<2\u0006\u0010T\u001a\u00020<8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\bY\u0010>\"\u0004\bZ\u0010@\u00a8\u0006j"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractSlider;", "T", "", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractGuiNode2D;", "Lnet/minecraft/client/gui/components/events/GuiEventListener;", "Lnet/thebrokenscript/brokencore/api/client/gui/impl/Hoverable;", "Lnet/minecraft/client/gui/components/Renderable;", "range", "Lkotlin/ranges/ClosedRange;", "step", "bgScaling", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;", "bgSprite", "Lnet/minecraft/resources/ResourceLocation;", "grabberScaling", "grabberNormal", "grabberHovered", "grabberHeld", "changeCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "newValue", "", "delta", "", "<init>", "(Lkotlin/ranges/ClosedRange;Ljava/lang/Comparable;Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;Lnet/minecraft/resources/ResourceLocation;Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lkotlin/jvm/functions/Function2;)V", "sliderSettings", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/SliderSettings;", "(Lkotlin/ranges/ClosedRange;Ljava/lang/Comparable;Lnet/thebrokenscript/brokencore/api/client/gui/settings/SliderSettings;Lkotlin/jvm/functions/Function2;)V", "getRange", "()Lkotlin/ranges/ClosedRange;", "setRange", "(Lkotlin/ranges/ClosedRange;)V", "getStep", "()Ljava/lang/Comparable;", "setStep", "(Ljava/lang/Comparable;)V", "Ljava/lang/Comparable;", "getBgScaling", "()Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;", "getGrabberScaling", "getGrabberNormal", "()Lnet/minecraft/resources/ResourceLocation;", "getGrabberHovered", "getGrabberHeld", "getChangeCallback", "()Lkotlin/jvm/functions/Function2;", "autoDelta", "", "getAutoDelta", "()Z", "hovered", "getHovered", "setHovered", "(Z)V", "grabberIsHovered", "grabberPressed", "grabberLength", "", "getGrabberLength", "()I", "setGrabberLength", "(I)V", "dragBox", "Lnet/thebrokenscript/brokencore/api/client/gui/misc/DragBox;", "getDragBox", "()Lnet/thebrokenscript/brokencore/api/client/gui/misc/DragBox;", "grabber", "Lnet/thebrokenscript/brokencore/api/client/gui/misc/GuiSprite;", "getGrabber", "()Lnet/thebrokenscript/brokencore/api/client/gui/misc/GuiSprite;", "mouseMoved", "mouseX", "", "mouseY", "baseMouseMoved", "updateSprite", "mouseClicked", "button", "mouseReleased", "bg", "getBg", "value", "w", "getW", "setW", "h", "getH", "setH", "resetGrabber", "getLerpDelta", "grabberMoved", "Lorg/joml/Vector2i;", "localMouseX", "localMouseY", "localClickX", "localClickY", "getLerpedValue", "(F)Ljava/lang/Comparable;", "getRectangle", "Lnet/minecraft/client/gui/navigation/ScreenRectangle;", "setFocused", "focused", "isFocused", "brokencore-common"})
public abstract class AbstractSlider<T extends Comparable<? super T>>
extends AbstractGuiNode2D
implements GuiEventListener,
Hoverable,
Renderable {
    @NotNull
    private ClosedRange<T> range;
    @NotNull
    private T step;
    @NotNull
    private final SpriteScalingSettings bgScaling;
    @NotNull
    private final SpriteScalingSettings grabberScaling;
    @NotNull
    private final ResourceLocation grabberNormal;
    @NotNull
    private final ResourceLocation grabberHovered;
    @NotNull
    private final ResourceLocation grabberHeld;
    @NotNull
    private final Function2<T, Float, Unit> changeCallback;
    private final boolean autoDelta;
    private boolean hovered;
    private boolean grabberIsHovered;
    private boolean grabberPressed;
    @NotNull
    private final DragBox dragBox;
    @NotNull
    private final GuiSprite grabber;
    @NotNull
    private final GuiSprite bg;

    /*
     * WARNING - void declaration
     */
    public AbstractSlider(@NotNull ClosedRange<T> range, @NotNull T step, @NotNull SpriteScalingSettings bgScaling, @NotNull ResourceLocation bgSprite, @NotNull SpriteScalingSettings grabberScaling, @NotNull ResourceLocation grabberNormal, @NotNull ResourceLocation grabberHovered, @NotNull ResourceLocation grabberHeld, @NotNull Function2<? super T, ? super Float, Unit> changeCallback) {
        void $this$bg_u24lambda_u240;
        AbstractSlider $this$grabber_u24lambda_u240;
        Intrinsics.checkNotNullParameter(range, (String)"range");
        Intrinsics.checkNotNullParameter(step, (String)"step");
        Intrinsics.checkNotNullParameter((Object)bgScaling, (String)"bgScaling");
        Intrinsics.checkNotNullParameter((Object)bgSprite, (String)"bgSprite");
        Intrinsics.checkNotNullParameter((Object)grabberScaling, (String)"grabberScaling");
        Intrinsics.checkNotNullParameter((Object)grabberNormal, (String)"grabberNormal");
        Intrinsics.checkNotNullParameter((Object)grabberHovered, (String)"grabberHovered");
        Intrinsics.checkNotNullParameter((Object)grabberHeld, (String)"grabberHeld");
        Intrinsics.checkNotNullParameter(changeCallback, (String)"changeCallback");
        super(0, 0, 0, 0, 15, null);
        this.range = range;
        this.step = step;
        this.bgScaling = bgScaling;
        this.grabberScaling = grabberScaling;
        this.grabberNormal = grabberNormal;
        this.grabberHovered = grabberHovered;
        this.grabberHeld = grabberHeld;
        this.changeCallback = changeCallback;
        this.autoDelta = this.range instanceof ClosedFloatingPointRange && this.step instanceof Float && Intrinsics.areEqual((Object)this.range.getStart(), (Object)Float.valueOf(0.0f)) && Intrinsics.areEqual((Object)this.range.getEndInclusive(), (Object)Float.valueOf(1.0f));
        this.dragBox = new DragBox((Function3<? super DragBox, ? super Vector2i, ? super Vector2i, Unit>)((Function3)(arg_0, arg_1, arg_2) -> AbstractSlider.dragBox$lambda$0(this, arg_0, arg_1, arg_2)));
        AbstractSlider abstractSlider = this;
        AbstractSlider abstractSlider2 = this;
        boolean bl = false;
        GuiSprite grabberSprite = new GuiSprite($this$grabber_u24lambda_u240.grabberNormal, $this$grabber_u24lambda_u240.grabberScaling);
        grabberSprite.addChild((GuiElement)$this$grabber_u24lambda_u240.dragBox);
        abstractSlider2.grabber = grabberSprite;
        $this$grabber_u24lambda_u240 = this;
        abstractSlider2 = this;
        boolean bl2 = false;
        GuiSprite bg = new GuiSprite(bgSprite, $this$bg_u24lambda_u240.bgScaling);
        bg.addChild((GuiElement)$this$bg_u24lambda_u240.grabber);
        $this$bg_u24lambda_u240.addChild((GuiElement)bg);
        abstractSlider2.bg = bg;
    }

    @NotNull
    public final ClosedRange<T> getRange() {
        return this.range;
    }

    public final void setRange(@NotNull ClosedRange<T> closedRange) {
        Intrinsics.checkNotNullParameter(closedRange, (String)"<set-?>");
        this.range = closedRange;
    }

    @NotNull
    public final T getStep() {
        return this.step;
    }

    public final void setStep(@NotNull T t) {
        Intrinsics.checkNotNullParameter(t, (String)"<set-?>");
        this.step = t;
    }

    @NotNull
    public final SpriteScalingSettings getBgScaling() {
        return this.bgScaling;
    }

    @NotNull
    public final SpriteScalingSettings getGrabberScaling() {
        return this.grabberScaling;
    }

    @NotNull
    public final ResourceLocation getGrabberNormal() {
        return this.grabberNormal;
    }

    @NotNull
    public final ResourceLocation getGrabberHovered() {
        return this.grabberHovered;
    }

    @NotNull
    public final ResourceLocation getGrabberHeld() {
        return this.grabberHeld;
    }

    @NotNull
    protected final Function2<T, Float, Unit> getChangeCallback() {
        return this.changeCallback;
    }

    public AbstractSlider(@NotNull ClosedRange<T> range, @NotNull T step, @NotNull SliderSettings sliderSettings, @NotNull Function2<? super T, ? super Float, Unit> changeCallback) {
        Intrinsics.checkNotNullParameter(range, (String)"range");
        Intrinsics.checkNotNullParameter(step, (String)"step");
        Intrinsics.checkNotNullParameter((Object)sliderSettings, (String)"sliderSettings");
        Intrinsics.checkNotNullParameter(changeCallback, (String)"changeCallback");
        this((ClosedRange<? super T>)range, (T)step, sliderSettings.getBgScaling(), sliderSettings.getBgSprite(), sliderSettings.getGrabberScaling(), sliderSettings.getGrabberNormal(), sliderSettings.getGrabberHovered(), sliderSettings.getGrabberHeld(), (Function2<? super T, Float, Unit>)changeCallback);
    }

    protected final boolean getAutoDelta() {
        return this.autoDelta;
    }

    @Override
    public boolean getHovered() {
        return this.hovered;
    }

    @Override
    public void setHovered(boolean bl) {
        this.hovered = bl;
    }

    public abstract int getGrabberLength();

    public abstract void setGrabberLength(int var1);

    @NotNull
    protected final DragBox getDragBox() {
        return this.dragBox;
    }

    @NotNull
    public final GuiSprite getGrabber() {
        return this.grabber;
    }

    public void mouseMoved(double mouseX, double mouseY) {
        this.baseMouseMoved(mouseX, mouseY);
    }

    public final void baseMouseMoved(double mouseX, double mouseY) {
        this.dragBox.mouseMoved(mouseX, mouseY);
        if (this.isMouseOver(mouseX, mouseY) && !this.getHovered()) {
            this.mouseEntered((int)mouseX, (int)mouseY);
        } else if (this.getHovered()) {
            this.mouseExited((int)mouseX, (int)mouseY);
        }
        this.grabberIsHovered = this.grabber.isMouseOver(mouseX, mouseY);
        this.updateSprite();
    }

    private final void updateSprite() {
        ResourceLocation sprite;
        ResourceLocation resourceLocation = this.grabberPressed ? this.grabberHeld : (sprite = this.grabberIsHovered ? this.grabberHovered : this.grabberNormal);
        if (sprite != this.grabber.getSprite()) {
            this.grabber.setSprite(sprite);
        }
    }

    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 0) {
            this.grabberPressed = this.grabberIsHovered;
        }
        this.updateSprite();
        this.dragBox.mouseClicked(mouseX, mouseY, button);
        return super.mouseClicked(mouseX, mouseY, button);
    }

    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        if (button == 0) {
            this.grabberPressed = false;
        }
        this.updateSprite();
        this.dragBox.mouseReleased(mouseX, mouseY, button);
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @NotNull
    public final GuiSprite getBg() {
        return this.bg;
    }

    @Override
    public int getW() {
        return super.getW();
    }

    @Override
    public void setW(int value) {
        this.bg.setW(value);
        super.setW(value);
    }

    @Override
    public int getH() {
        return super.getH();
    }

    @Override
    public void setH(int value) {
        this.bg.setH(value);
        super.setH(value);
    }

    public abstract void resetGrabber();

    public abstract float getLerpDelta();

    @NotNull
    public abstract Vector2i grabberMoved(int var1, int var2, int var3, int var4);

    @NotNull
    public T getLerpedValue(float delta) {
        if (this.autoDelta) {
            return (T)Float.valueOf(Math.clamp(delta, 0.0f, 1.0f));
        }
        float delta2 = Math.clamp(delta, 0.0f, 1.0f);
        Comparable comparable = this.range.getStart();
        Intrinsics.checkNotNull((Object)comparable, (String)"null cannot be cast to non-null type kotlin.Number");
        Number number = (Number)((Object)comparable);
        Comparable comparable2 = this.range.getEndInclusive();
        Intrinsics.checkNotNull((Object)comparable2, (String)"null cannot be cast to non-null type kotlin.Number");
        Number lerped = MathUtilKt.lerpN(delta2, number, (Number)((Object)comparable2));
        Comparable sign = Integer.valueOf(lerped.floatValue() >= 0.0f ? 1 : -1);
        Number absolute = MathUtilKt.absN(lerped);
        T t = this.step;
        Intrinsics.checkNotNull(t, (String)"null cannot be cast to non-null type kotlin.Number");
        Number number2 = MathUtilKt.times(MathUtilKt.minus(absolute, MathUtilKt.rem(absolute, (Number)t)), (Number)((Object)sign));
        Intrinsics.checkNotNull((Object)number2, (String)"null cannot be cast to non-null type T of net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractSlider");
        return (T)((Comparable)((Object)number2));
    }

    @Override
    @NotNull
    public ScreenRectangle getRectangle() {
        return super.getRectangle();
    }

    public void setFocused(boolean focused) {
    }

    public boolean isFocused() {
        return false;
    }

    private static final Unit dragBox$lambda$0(AbstractSlider this$0, DragBox $this$DragBox, Vector2i localClickPos, Vector2i localPos) {
        Intrinsics.checkNotNullParameter((Object)$this$DragBox, (String)"$this$DragBox");
        Intrinsics.checkNotNullParameter((Object)localClickPos, (String)"localClickPos");
        Intrinsics.checkNotNullParameter((Object)localPos, (String)"localPos");
        Vector2i newPos = this$0.grabberMoved(localPos.x, localPos.y, localClickPos.x, localClickPos.y);
        this$0.grabber.setX(newPos.x);
        this$0.grabber.setY(newPos.y);
        $this$DragBox.setX(newPos.x - this$0.grabber.getX());
        $this$DragBox.setY(newPos.y - this$0.grabber.getY());
        float delta = this$0.getLerpDelta();
        Object value = this$0.getLerpedValue(delta);
        this$0.changeCallback.invoke(value, (Object)Float.valueOf(delta));
        return Unit.INSTANCE;
    }
}

