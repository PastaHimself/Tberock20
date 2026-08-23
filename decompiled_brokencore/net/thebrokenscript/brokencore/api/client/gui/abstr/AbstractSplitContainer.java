/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector2i
 */
package net.thebrokenscript.brokencore.api.client.gui.abstr;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractContainer;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractGuiNode2D;
import net.thebrokenscript.brokencore.api.client.gui.impl.GuiElement;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2i;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000f\u001a\u00020\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u0012\u0010\t\u001a\u00020\nX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\nX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractSplitContainer;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractContainer;", "ratio", "", "<init>", "(F)V", "getRatio", "()F", "setRatio", "lowerSize", "Lorg/joml/Vector2i;", "getLowerSize", "()Lorg/joml/Vector2i;", "upperSize", "getUpperSize", "updateChildren", "", "brokencore-common"})
public abstract class AbstractSplitContainer
extends AbstractContainer {
    private float ratio;

    public AbstractSplitContainer(float ratio) {
        this.ratio = ratio;
    }

    public final float getRatio() {
        return this.ratio;
    }

    public final void setRatio(float f) {
        this.ratio = f;
    }

    @NotNull
    public abstract Vector2i getLowerSize();

    @NotNull
    public abstract Vector2i getUpperSize();

    @Override
    public final void updateChildren() {
        block3: {
            GuiElement guiElement = (GuiElement)CollectionsKt.firstOrNull(this.getChildren());
            if (guiElement == null) break block3;
            GuiElement first = guiElement;
            boolean bl = false;
            if (first instanceof AbstractGuiNode2D) {
                GuiElement guiElement2 = (GuiElement)CollectionsKt.getOrNull(this.getChildren(), (int)1);
                if (guiElement2 != null) {
                    GuiElement second = guiElement2;
                    boolean bl2 = false;
                    if (second instanceof AbstractGuiNode2D) {
                        Vector2i lower = this.getLowerSize();
                        Vector2i upper = this.getUpperSize();
                        ((AbstractGuiNode2D)first).setW(lower.x);
                        ((AbstractGuiNode2D)first).setH(lower.y);
                        ((AbstractGuiNode2D)second).setW(upper.x);
                        ((AbstractGuiNode2D)second).setH(upper.y);
                        ((AbstractGuiNode2D)second).setX(lower.x);
                        ((AbstractGuiNode2D)second).setY(lower.y);
                    }
                }
            }
        }
    }
}

