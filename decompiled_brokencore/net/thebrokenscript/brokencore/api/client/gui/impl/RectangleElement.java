/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  net.minecraft.client.gui.navigation.ScreenRectangle
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.gui.impl;

import kotlin.Metadata;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.thebrokenscript.brokencore.api.client.gui.impl.PositionalElement;
import net.thebrokenscript.brokencore.api.client.gui.impl.SizedElement;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/impl/RectangleElement;", "Lnet/thebrokenscript/brokencore/api/client/gui/impl/PositionalElement;", "Lnet/thebrokenscript/brokencore/api/client/gui/impl/SizedElement;", "setWidth", "", "w", "", "setHeight", "h", "getRectangle", "Lnet/minecraft/client/gui/navigation/ScreenRectangle;", "brokencore-common"})
public interface RectangleElement
extends PositionalElement,
SizedElement {
    public void setWidth(int var1);

    public void setHeight(int var1);

    @NotNull
    public ScreenRectangle getRectangle();

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        public static void setWidth(@NotNull RectangleElement $this, int w) {
            $this.setW(w);
        }

        public static void setHeight(@NotNull RectangleElement $this, int h) {
            $this.setH(h);
        }

        @NotNull
        public static ScreenRectangle getRectangle(@NotNull RectangleElement $this) {
            return new ScreenRectangle($this.getX(), $this.getY(), $this.getW(), $this.getH());
        }
    }
}

