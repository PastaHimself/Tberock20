/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.anim;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.api.anim.BakedKeyframe;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/api/anim/BoneTrack;", "", "rotation", "", "Lnet/thebrokenscript/api/anim/BakedKeyframe;", "position", "<init>", "(Ljava/util/Set;Ljava/util/Set;)V", "getRotation", "()Ljava/util/Set;", "getPosition", "thebrokenscript-common"})
public final class BoneTrack {
    @NotNull
    private final Set<BakedKeyframe> rotation;
    @NotNull
    private final Set<BakedKeyframe> position;

    public BoneTrack(@NotNull Set<BakedKeyframe> rotation, @NotNull Set<BakedKeyframe> position) {
        Intrinsics.checkNotNullParameter(rotation, (String)"rotation");
        Intrinsics.checkNotNullParameter(position, (String)"position");
        this.rotation = rotation;
        this.position = position;
    }

    @NotNull
    public final Set<BakedKeyframe> getRotation() {
        return this.rotation;
    }

    @NotNull
    public final Set<BakedKeyframe> getPosition() {
        return this.position;
    }
}

