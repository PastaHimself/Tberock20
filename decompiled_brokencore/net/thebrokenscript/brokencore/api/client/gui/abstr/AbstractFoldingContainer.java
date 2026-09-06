/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package net.thebrokenscript.brokencore.api.client.gui.abstr;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractContainer;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractGuiNode2D;
import net.thebrokenscript.brokencore.api.client.gui.impl.GuiElement;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u000e\u001a\u00020\fH\u0004J\b\u0010\u000f\u001a\u00020\fH\u0004R$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractFoldingContainer;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractContainer;", "<init>", "()V", "v", "", "folded", "getFolded", "()Z", "setFolded", "(Z)V", "onFold", "", "onUnfold", "baseFold", "baseUnfold", "brokencore-common"})
public abstract class AbstractFoldingContainer
extends AbstractContainer {
    private boolean folded;

    public final boolean getFolded() {
        return this.folded;
    }

    public final void setFolded(boolean v) {
        if (v) {
            this.onFold();
        } else {
            this.onUnfold();
        }
        this.folded = v;
    }

    protected void onFold() {
        this.baseFold();
    }

    protected void onUnfold() {
        this.baseUnfold();
    }

    protected final void baseFold() {
        this.setVisible(false);
        this.setActive(false);
        this.forEachChildInTree((Function1<? super GuiElement, Unit>)((Function1)AbstractFoldingContainer::baseFold$lambda$0));
    }

    protected final void baseUnfold() {
        this.setVisible(true);
        this.setActive(true);
        this.forEachChildInTree((Function1<? super GuiElement, Unit>)((Function1)AbstractFoldingContainer::baseUnfold$lambda$0));
    }

    private static final Unit baseFold$lambda$0(GuiElement it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        if (it instanceof AbstractGuiNode2D) {
            ((AbstractGuiNode2D)it).setActive(false);
            ((AbstractGuiNode2D)it).setVisible(false);
        }
        return Unit.INSTANCE;
    }

    private static final Unit baseUnfold$lambda$0(GuiElement it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        if (it instanceof AbstractGuiNode2D) {
            ((AbstractGuiNode2D)it).setActive(true);
            ((AbstractGuiNode2D)it).setVisible(true);
        }
        return Unit.INSTANCE;
    }
}

