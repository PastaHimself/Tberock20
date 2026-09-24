/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.ClosedFloatingPointRange
 *  kotlin.ranges.RangesKt
 */
package net.thebrokenscript.brokencore.api.client.gui.container;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractContainer;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractGuiNode2D;
import net.thebrokenscript.brokencore.api.global.GlobalMathKt;
import net.thebrokenscript.brokencore.api.util.math.MathUtilKt;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020'H\u0016R\u0011\u0010\u0004\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0007R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u001e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u001e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R$\u0010\u001f\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u00158V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\"R$\u0010#\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u00158V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b$\u0010\u0018\"\u0004\b%\u0010\"\u00a8\u0006)"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/container/ScrollableContainer;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractContainer;", "<init>", "()V", "inHorizontalBounds", "", "getInHorizontalBounds", "()Z", "inVerticalBounds", "getInVerticalBounds", "v", "", "scrollX", "getScrollX", "()F", "setScrollX", "(F)V", "scrollY", "getScrollY", "setScrollY", "value", "", "minX", "getMinX", "()I", "minY", "getMinY", "maxX", "getMaxX", "maxY", "getMaxY", "w", "getW", "setW", "(I)V", "h", "getH", "setH", "updateChildArea", "", "updateChildren", "brokencore-common"})
public final class ScrollableContainer
extends AbstractContainer {
    private float scrollX;
    private float scrollY;
    private int minX;
    private int minY;
    private int maxX = this.getW();
    private int maxY = this.getH();

    public ScrollableContainer() {
        AbstractGuiNode2D.enableChildClipping$default(this, 0, 0, 0, 0, 15, null);
    }

    public final boolean getInHorizontalBounds() {
        return this.minX >= 0 && this.maxX <= this.getW();
    }

    public final boolean getInVerticalBounds() {
        return this.minY >= 0 && this.maxY <= this.getH();
    }

    public final float getScrollX() {
        return this.scrollX;
    }

    public final void setScrollX(float v) {
        if (!(v == this.scrollX)) {
            this.scrollX = GlobalMathKt.clamp(v, (ClosedFloatingPointRange<Float>)RangesKt.rangeTo((float)0.0f, (float)1.0f));
            this.updateChildren();
        }
    }

    public final float getScrollY() {
        return this.scrollY;
    }

    public final void setScrollY(float v) {
        if (!(v == this.scrollY)) {
            this.scrollY = GlobalMathKt.clamp(v, (ClosedFloatingPointRange<Float>)RangesKt.rangeTo((float)0.0f, (float)1.0f));
            this.updateChildren();
        }
    }

    public final int getMinX() {
        return this.minX;
    }

    public final int getMinY() {
        return this.minY;
    }

    public final int getMaxX() {
        return this.maxX;
    }

    public final int getMaxY() {
        return this.maxY;
    }

    @Override
    public int getW() {
        return super.getW();
    }

    @Override
    public void setW(int v) {
        super.setW(v);
        if (this.getW() != this.maxX) {
            this.updateChildArea();
        }
    }

    @Override
    public int getH() {
        return super.getH();
    }

    @Override
    public void setH(int v) {
        super.setH(v);
        if (this.getH() != this.maxY) {
            this.updateChildArea();
        }
    }

    private final void updateChildArea() {
        this.minX = 0;
        this.minY = 0;
        this.maxX = this.getW();
        this.maxY = this.getH();
        this.forEachNode2d((Function1<? super AbstractGuiNode2D, Unit>)((Function1)arg_0 -> ScrollableContainer.updateChildArea$lambda$0(this, arg_0)));
    }

    @Override
    public void updateChildren() {
        this.updateChildArea();
        int xOfs = -MathUtilKt.lerpi(this.scrollX, this.minX, this.maxX);
        int yOfs = -MathUtilKt.lerpi(this.scrollY, this.minY, this.maxY);
        this.forEachNode2d((Function1<? super AbstractGuiNode2D, Unit>)((Function1)arg_0 -> ScrollableContainer.updateChildren$lambda$0(xOfs, yOfs, arg_0)));
        AbstractGuiNode2D.enableChildClipping$default(this, 0, 0, 0, 0, 15, null);
    }

    private static final Unit updateChildArea$lambda$0(ScrollableContainer this$0, AbstractGuiNode2D it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        this$0.minX = GlobalMathKt.min(this$0.minX, (Number)(it.getX() - it.getXOffset()));
        this$0.minY = GlobalMathKt.min(this$0.minY, (Number)(it.getY() - it.getYOffset()));
        this$0.maxX = GlobalMathKt.max(this$0.maxX, (Number)(it.getX() + it.getW() - it.getXOffset()));
        this$0.maxY = GlobalMathKt.max(this$0.maxY, (Number)(it.getY() + it.getH() - it.getYOffset()));
        return Unit.INSTANCE;
    }

    private static final Unit updateChildren$lambda$0(int $xOfs, int $yOfs, AbstractGuiNode2D it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        it.setXOffset($xOfs);
        it.setYOffset($yOfs);
        return Unit.INSTANCE;
    }
}

