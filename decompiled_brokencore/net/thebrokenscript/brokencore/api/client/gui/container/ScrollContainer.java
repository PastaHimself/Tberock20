/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.ClosedRange
 *  kotlin.ranges.RangesKt
 *  net.minecraft.client.gui.components.events.GuiEventListener
 *  net.minecraft.client.gui.navigation.ScreenRectangle
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.client.gui.container;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractContainer;
import net.thebrokenscript.brokencore.api.client.gui.container.ScrollableContainer;
import net.thebrokenscript.brokencore.api.client.gui.impl.GuiElement;
import net.thebrokenscript.brokencore.api.client.gui.range.HSlider;
import net.thebrokenscript.brokencore.api.client.gui.range.VSlider;
import net.thebrokenscript.brokencore.api.client.gui.settings.ScrollContainerSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020 H\u0002J\u001a\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020 H\u0002J(\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020%H\u0016J\u0016\u0010)\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020 J\u001f\u0010*\u001a\u0002H+\"\b\b\u0000\u0010+*\u00020,2\u0006\u0010-\u001a\u0002H+H\u0016\u00a2\u0006\u0002\u0010.J\b\u0010/\u001a\u00020\u0011H\u0016J\u001e\u00100\u001a\u0004\u0018\u00010,2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020 02H\u0016J\b\u00103\u001a\u00020\u001dH\u0016J\b\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020\u001d2\u0006\u00107\u001a\u00020 H\u0016J\b\u00108\u001a\u00020 H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00118V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00118V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018\u00a8\u00069"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/container/ScrollContainer;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractContainer;", "Lnet/minecraft/client/gui/components/events/GuiEventListener;", "settings", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/ScrollContainerSettings;", "<init>", "(Lnet/thebrokenscript/brokencore/api/client/gui/settings/ScrollContainerSettings;)V", "getSettings", "()Lnet/thebrokenscript/brokencore/api/client/gui/settings/ScrollContainerSettings;", "scrollableContainer", "Lnet/thebrokenscript/brokencore/api/client/gui/container/ScrollableContainer;", "vScrollbar", "Lnet/thebrokenscript/brokencore/api/client/gui/range/VSlider;", "", "hScrollbar", "Lnet/thebrokenscript/brokencore/api/client/gui/range/HSlider;", "lastW", "", "lastH", "v", "w", "getW", "()I", "setW", "(I)V", "h", "getH", "setH", "checkWidth", "", "newWidth", "recursionGuard", "", "checkHeight", "newHeight", "mouseScrolled", "mouseX", "", "mouseY", "scrollX", "scrollY", "updateScrollbars", "addChild", "T", "Lnet/thebrokenscript/brokencore/api/client/gui/impl/GuiElement;", "child", "(Lnet/thebrokenscript/brokencore/api/client/gui/impl/GuiElement;)Lnet/thebrokenscript/brokencore/api/client/gui/impl/GuiElement;", "childCount", "findChild", "cond", "Lkotlin/Function1;", "updateChildren", "getRectangle", "Lnet/minecraft/client/gui/navigation/ScreenRectangle;", "setFocused", "focused", "isFocused", "brokencore-common"})
public final class ScrollContainer
extends AbstractContainer
implements GuiEventListener {
    @NotNull
    private final ScrollContainerSettings settings;
    @NotNull
    private final ScrollableContainer scrollableContainer;
    @NotNull
    private final VSlider<Float> vScrollbar;
    @NotNull
    private final HSlider<Float> hScrollbar;
    private int lastW;
    private int lastH;

    public ScrollContainer(@NotNull ScrollContainerSettings settings) {
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        this.settings = settings;
        this.scrollableContainer = (ScrollableContainer)this.addChildInit((GuiElement)new ScrollableContainer());
        this.vScrollbar = (VSlider)this.addChildInit((GuiElement)new VSlider<Comparable>((ClosedRange)RangesKt.rangeTo((float)0.0f, (float)1.0f), Float.valueOf(0.0f), this.settings.getScrollbarBgScalingV(), this.settings.getScrollbarBgSpriteV(), this.settings.getGrabberScalingV(), this.settings.getGrabberNormalV(), this.settings.getGrabberHoveredV(), this.settings.getGrabberHeldV(), (arg_0, arg_1) -> ScrollContainer.vScrollbar$lambda$0(this, arg_0, arg_1)));
        this.hScrollbar = (HSlider)this.addChildInit((GuiElement)new HSlider<Comparable>((ClosedRange)RangesKt.rangeTo((float)0.0f, (float)1.0f), Float.valueOf(0.0f), this.settings.getScrollbarBgScalingH(), this.settings.getScrollbarBgSpriteH(), this.settings.getGrabberScalingH(), this.settings.getGrabberNormalH(), this.settings.getGrabberHoveredH(), this.settings.getGrabberHeldH(), (arg_0, arg_1) -> ScrollContainer.hScrollbar$lambda$0(this, arg_0, arg_1)));
        this.updateScrollbars(true, true);
    }

    @NotNull
    public final ScrollContainerSettings getSettings() {
        return this.settings;
    }

    @Override
    public int getW() {
        return super.getW();
    }

    @Override
    public void setW(int v) {
        int old = this.getW();
        super.setW(v);
        if (old != v) {
            this.updateScrollbars(true, false);
        }
    }

    @Override
    public int getH() {
        return super.getH();
    }

    @Override
    public void setH(int v) {
        int old = this.getH();
        super.setH(v);
        if (old != v) {
            this.updateScrollbars(false, true);
        }
    }

    private final void checkWidth(int newWidth, boolean recursionGuard) {
        boolean changed;
        boolean bl = changed = this.lastW != newWidth;
        if (changed) {
            this.lastW = newWidth;
            if (!recursionGuard) {
                this.checkHeight(this.getH() - this.settings.getScrollbarThicknessH(), true);
            }
        } else {
            this.hScrollbar.resetGrabber();
        }
    }

    static /* synthetic */ void checkWidth$default(ScrollContainer scrollContainer, int n, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl = false;
        }
        scrollContainer.checkWidth(n, bl);
    }

    private final void checkHeight(int newHeight, boolean recursionGuard) {
        boolean changed;
        boolean bl = changed = this.lastH != newHeight;
        if (changed) {
            this.lastH = newHeight;
            if (!recursionGuard) {
                this.checkWidth(this.getW() - this.settings.getScrollbarThicknessV(), true);
            }
        } else {
            this.vScrollbar.resetGrabber();
        }
    }

    static /* synthetic */ void checkHeight$default(ScrollContainer scrollContainer, int n, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl = false;
        }
        scrollContainer.checkHeight(n, bl);
    }

    public boolean mouseScrolled(double mouseX, double mouseY, double scrollX, double scrollY) {
        this.vScrollbar.mouseScrolled(mouseX, mouseY, scrollX, scrollY);
        return super.mouseScrolled(mouseX, mouseY, scrollX, scrollY);
    }

    public final void updateScrollbars(boolean h, boolean v) {
        int w = this.scrollableContainer.getInVerticalBounds() ? this.getW() : this.getW() - this.settings.getScrollbarThicknessH();
        this.scrollableContainer.setW(w);
        this.scrollableContainer.setH(this.scrollableContainer.getInHorizontalBounds() ? this.getH() : this.getH() - this.settings.getScrollbarThicknessV());
        if (h) {
            this.hScrollbar.setW(w - this.settings.getScrollbarThicknessV());
            this.hScrollbar.setH(this.settings.getScrollbarThicknessH());
            this.hScrollbar.setY(this.getH() - this.settings.getScrollbarThicknessH());
            ScrollContainer.checkWidth$default(this, this.getW(), false, 2, null);
        }
        if (v) {
            this.vScrollbar.setH(this.getH());
            this.vScrollbar.setW(this.settings.getScrollbarThicknessV());
            this.vScrollbar.setX(this.getW() - this.settings.getScrollbarThicknessV());
            ScrollContainer.checkHeight$default(this, this.getH(), false, 2, null);
        }
        this.scrollableContainer.setW(w);
        this.scrollableContainer.setH(this.scrollableContainer.getInHorizontalBounds() ? this.getH() : this.getH() - this.settings.getScrollbarThicknessV());
        this.scrollableContainer.updateChildren();
    }

    @Override
    @NotNull
    public <T extends GuiElement> T addChild(@NotNull T child) {
        Intrinsics.checkNotNullParameter(child, (String)"child");
        return this.scrollableContainer.addChild(child);
    }

    @Override
    public int childCount() {
        return this.scrollableContainer.childCount();
    }

    @Override
    @Nullable
    public GuiElement findChild(@NotNull Function1<? super GuiElement, Boolean> cond) {
        Intrinsics.checkNotNullParameter(cond, (String)"cond");
        return this.scrollableContainer.findChild(cond);
    }

    @Override
    public void updateChildren() {
        this.scrollableContainer.updateChildren();
        this.updateScrollbars(true, true);
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

    private static final Unit vScrollbar$lambda$0(ScrollContainer this$0, float v, float f) {
        this$0.scrollableContainer.setScrollY(v);
        return Unit.INSTANCE;
    }

    private static final Unit hScrollbar$lambda$0(ScrollContainer this$0, float v, float f) {
        this$0.scrollableContainer.setScrollX(v);
        return Unit.INSTANCE;
    }
}

