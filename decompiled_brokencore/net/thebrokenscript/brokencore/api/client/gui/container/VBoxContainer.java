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

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/container/VBoxContainer;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractContainer;", "padding", "", "fitWidth", "", "<init>", "(IZ)V", "getPadding", "()I", "setPadding", "(I)V", "getFitWidth", "()Z", "setFitWidth", "(Z)V", "updateChildren", "", "brokencore-common"})
public final class VBoxContainer
extends AbstractContainer {
    private int padding;
    private boolean fitWidth;

    public VBoxContainer(int padding, boolean fitWidth) {
        this.padding = padding;
        this.fitWidth = fitWidth;
    }

    public /* synthetic */ VBoxContainer(int n, boolean bl, int n2, DefaultConstructorMarker defaultConstructorMarker) {
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

    public final boolean getFitWidth() {
        return this.fitWidth;
    }

    public final void setFitWidth(boolean bl) {
        this.fitWidth = bl;
    }

    @Override
    public void updateChildren() {
        int elemHeight = this.getH() / Math.max(this.childCount(), 1);
        int curPos = 0;
        for (GuiElement it : this.getChildren()) {
            if (!(it instanceof AbstractGuiNode2D)) continue;
            ((AbstractGuiNode2D)it).setY(curPos);
            this.setMinWidth(Math.max(this.getW(), ((AbstractGuiNode2D)it).getW()));
            this.setMinHeight(curPos += elemHeight + this.padding);
            ((AbstractGuiNode2D)it).setH(elemHeight - this.padding * ((this.getH() & 1) != 0 ? 2 : 1));
            if (!this.fitWidth) continue;
            ((AbstractGuiNode2D)it).setW(this.getW());
        }
        this.setMinWidth(this.getMinWidth() - this.padding);
    }

    public VBoxContainer() {
        this(0, false, 3, null);
    }
}

