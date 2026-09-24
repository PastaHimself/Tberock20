/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$IntRef
 */
package net.thebrokenscript.brokencore.api.client.gui.container;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractContainer;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractGuiNode2D;
import net.thebrokenscript.brokencore.api.client.gui.impl.GuiElement;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/container/VListContainer;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractContainer;", "padding", "", "<init>", "(I)V", "getPadding", "()I", "updateChildren", "", "brokencore-common"})
public final class VListContainer
extends AbstractContainer {
    private final int padding;

    public VListContainer(int padding) {
        this.padding = padding;
    }

    public /* synthetic */ VListContainer(int n, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            n = 1;
        }
        this(n);
    }

    public final int getPadding() {
        return this.padding;
    }

    @Override
    public void updateChildren() {
        Ref.IntRef minHeight = new Ref.IntRef();
        Ref.IntRef maxWidth = new Ref.IntRef();
        Ref.IntRef lastHeight = new Ref.IntRef();
        this.forEachChild((Function1<? super GuiElement, Unit>)((Function1)arg_0 -> VListContainer.updateChildren$lambda$0(minHeight, this, maxWidth, lastHeight, arg_0)));
        minHeight.element -= this.padding * this.childCount() + lastHeight.element;
        this.setMinHeight(minHeight.element);
        this.setMinWidth(maxWidth.element);
    }

    private static final Unit updateChildren$lambda$0(Ref.IntRef $minHeight, VListContainer this$0, Ref.IntRef $maxWidth, Ref.IntRef $lastHeight, GuiElement it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        if (it instanceof AbstractGuiNode2D) {
            ((AbstractGuiNode2D)it).setY($minHeight.element);
            $minHeight.element += ((AbstractGuiNode2D)it).getH() + this$0.padding;
            $maxWidth.element = Math.max($maxWidth.element, ((AbstractGuiNode2D)it).getW());
            $lastHeight.element = ((AbstractGuiNode2D)it).getH() + this$0.padding;
            ((AbstractGuiNode2D)it).setW(this$0.getW());
        }
        return Unit.INSTANCE;
    }

    public VListContainer() {
        this(0, 1, null);
    }
}

