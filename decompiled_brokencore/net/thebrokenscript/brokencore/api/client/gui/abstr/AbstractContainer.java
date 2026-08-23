/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.gui.abstr;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractGuiNode2D;
import net.thebrokenscript.brokencore.api.client.gui.impl.GuiElement;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u000e\u001a\u0002H\u000f\"\b\b\u0000\u0010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u0002H\u000f\u00a2\u0006\u0002\u0010\u0012J\u001f\u0010\u0013\u001a\u0002H\u000f\"\b\b\u0000\u0010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u0002H\u000fH\u0016\u00a2\u0006\u0002\u0010\u0012J\b\u0010\u0014\u001a\u00020\u0015H&R$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractContainer;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractGuiNode2D;", "<init>", "()V", "v", "", "w", "getW", "()I", "setW", "(I)V", "h", "getH", "setH", "addChildInit", "T", "Lnet/thebrokenscript/brokencore/api/client/gui/impl/GuiElement;", "child", "(Lnet/thebrokenscript/brokencore/api/client/gui/impl/GuiElement;)Lnet/thebrokenscript/brokencore/api/client/gui/impl/GuiElement;", "addChild", "updateChildren", "", "brokencore-common"})
public abstract class AbstractContainer
extends AbstractGuiNode2D {
    public AbstractContainer() {
        super(0, 0, 0, 0, 15, null);
    }

    @Override
    public int getW() {
        return super.getW();
    }

    @Override
    public void setW(int v) {
        super.setW(v);
        this.updateChildren();
    }

    @Override
    public int getH() {
        return super.getH();
    }

    @Override
    public void setH(int v) {
        super.setH(v);
        this.updateChildren();
    }

    @NotNull
    public final <T extends GuiElement> T addChildInit(@NotNull T child) {
        Intrinsics.checkNotNullParameter(child, (String)"child");
        return super.addChild(child);
    }

    @Override
    @NotNull
    public <T extends GuiElement> T addChild(@NotNull T child) {
        Intrinsics.checkNotNullParameter(child, (String)"child");
        T c = super.addChild(child);
        this.updateChildren();
        return c;
    }

    public abstract void updateChildren();
}

