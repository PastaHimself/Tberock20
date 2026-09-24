/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 */
package net.thebrokenscript.brokencore.api.client.gui.container;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractContainer;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractGuiNode2D;
import net.thebrokenscript.brokencore.api.client.gui.impl.GuiElement;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/container/HBoxContainer;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractContainer;", "padding", "", "fitHeight", "", "<init>", "(IZ)V", "getPadding", "()I", "setPadding", "(I)V", "getFitHeight", "()Z", "setFitHeight", "(Z)V", "updateChildren", "", "brokencore-common"})
public final class HBoxContainer
extends AbstractContainer {
    private int padding;
    private boolean fitHeight;

    public HBoxContainer(int padding, boolean fitHeight) {
        this.padding = padding;
        this.fitHeight = fitHeight;
    }

    public /* synthetic */ HBoxContainer(int n, boolean bl, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            n = 0;
        }
        if ((n2 & 2) != 0) {
            bl = true;
        }
        this(n, bl);
    }

    public final int getPadding() {
        return this.padding;
    }

    public final void setPadding(int n) {
        this.padding = n;
    }

    public final boolean getFitHeight() {
        return this.fitHeight;
    }

    public final void setFitHeight(boolean bl) {
        this.fitHeight = bl;
    }

    @Override
    public void updateChildren() {
        int elemWidth = (int)((float)this.getW() / (float)Math.max(this.childCount(), 1) - (float)((this.getW() & 1) == 0 ? 1 : 0));
        int curPos = 0;
        for (GuiElement it : this.getChildren()) {
            if (!(it instanceof AbstractGuiNode2D)) continue;
            ((AbstractGuiNode2D)it).setX(curPos);
            this.setMinWidth(curPos += elemWidth + this.padding);
            this.setMinHeight(Math.max(this.getH(), ((AbstractGuiNode2D)it).getH()));
            ((AbstractGuiNode2D)it).setW(elemWidth - this.padding);
            if (!this.fitHeight) continue;
            ((AbstractGuiNode2D)it).setH(this.getH());
        }
        this.setMinWidth(this.getMinWidth() - this.padding);
    }

    public HBoxContainer() {
        this(0, false, 3, null);
    }
}

