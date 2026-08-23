/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3f
 */
package net.thebrokenscript.api.tentaclev2;

import java.text.NumberFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/api/tentaclev2/TentacleNode;", "", "position", "Lorg/joml/Vector3f;", "thickness", "", "<init>", "(Lorg/joml/Vector3f;F)V", "getPosition", "()Lorg/joml/Vector3f;", "getThickness", "()F", "toString", "", "thebrokenscript-common"})
public final class TentacleNode {
    @NotNull
    private final Vector3f position;
    private final float thickness;

    public TentacleNode(@NotNull Vector3f position, float thickness) {
        Intrinsics.checkNotNullParameter((Object)position, (String)"position");
        this.position = position;
        this.thickness = thickness;
    }

    @NotNull
    public final Vector3f getPosition() {
        return this.position;
    }

    public final float getThickness() {
        return this.thickness;
    }

    @NotNull
    public String toString() {
        return this.position.toString(NumberFormat.getInstance()) + "; " + this.thickness;
    }
}

