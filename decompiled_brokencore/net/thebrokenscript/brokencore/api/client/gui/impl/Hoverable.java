/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.gui.impl;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0018\u0010\u0002\u001a\u00020\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/impl/Hoverable;", "", "hovered", "", "getHovered", "()Z", "setHovered", "(Z)V", "mouseEntered", "", "mouseX", "", "mouseY", "mouseExited", "brokencore-common"})
public interface Hoverable {
    public boolean getHovered();

    public void setHovered(boolean var1);

    public void mouseEntered(int var1, int var2);

    public void mouseExited(int var1, int var2);

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        public static void mouseEntered(@NotNull Hoverable $this, int mouseX, int mouseY) {
            $this.setHovered(true);
        }

        public static void mouseExited(@NotNull Hoverable $this, int mouseX, int mouseY) {
            $this.setHovered(false);
        }
    }
}

