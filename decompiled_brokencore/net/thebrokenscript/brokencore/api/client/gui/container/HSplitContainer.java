/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector2i
 */
package net.thebrokenscript.brokencore.api.client.gui.container;

import kotlin.Metadata;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractSplitContainer;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2i;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\t\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/container/HSplitContainer;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractSplitContainer;", "ratio", "", "<init>", "(F)V", "lowerSize", "Lorg/joml/Vector2i;", "getLowerSize", "()Lorg/joml/Vector2i;", "upperSize", "getUpperSize", "brokencore-common"})
public final class HSplitContainer
extends AbstractSplitContainer {
    public HSplitContainer(float ratio) {
        super(ratio);
    }

    @Override
    @NotNull
    public Vector2i getLowerSize() {
        return new Vector2i((int)((float)this.getW() * this.getRatio()), this.getH());
    }

    @Override
    @NotNull
    public Vector2i getUpperSize() {
        return new Vector2i(this.getW() - (int)((float)this.getW() * this.getRatio()), this.getH());
    }
}

