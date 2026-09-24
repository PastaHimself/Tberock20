/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.gui.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.client.gui.impl.Hoverable;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0004\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0018\u0010\u0002\u001a\u00020\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\tX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/impl/GuiDraggable;", "Lnet/thebrokenscript/brokencore/api/client/gui/impl/Hoverable;", "dragging", "", "getDragging", "()Z", "setDragging", "(Z)V", "clickX", "", "getClickX", "()I", "setClickX", "(I)V", "clickY", "getClickY", "setClickY", "canDrag", "mouseX", "", "mouseY", "brokencore-common"})
public interface GuiDraggable
extends Hoverable {
    public boolean getDragging();

    public void setDragging(boolean var1);

    public int getClickX();

    public void setClickX(int var1);

    public int getClickY();

    public void setClickY(int var1);

    public boolean canDrag(@NotNull Number var1, @NotNull Number var2);

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        public static boolean canDrag(@NotNull GuiDraggable $this, @NotNull Number mouseX, @NotNull Number mouseY) {
            Intrinsics.checkNotNullParameter((Object)mouseX, (String)"mouseX");
            Intrinsics.checkNotNullParameter((Object)mouseY, (String)"mouseY");
            return false;
        }

        public static void mouseEntered(@NotNull GuiDraggable $this, int mouseX, int mouseY) {
            Hoverable.DefaultImpls.mouseEntered($this, mouseX, mouseY);
        }

        public static void mouseExited(@NotNull GuiDraggable $this, int mouseX, int mouseY) {
            Hoverable.DefaultImpls.mouseExited($this, mouseX, mouseY);
        }
    }
}

