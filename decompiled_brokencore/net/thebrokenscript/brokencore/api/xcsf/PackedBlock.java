/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.xcsf;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/api/xcsf/PackedBlock;", "", "localX", "", "localY", "localZ", "stateDef", "", "<init>", "(IIILjava/lang/String;)V", "getLocalX", "()I", "getLocalY", "getLocalZ", "getStateDef", "()Ljava/lang/String;", "brokencore-common"})
public final class PackedBlock {
    private final int localX;
    private final int localY;
    private final int localZ;
    @NotNull
    private final String stateDef;

    public PackedBlock(int localX, int localY, int localZ, @NotNull String stateDef) {
        Intrinsics.checkNotNullParameter((Object)stateDef, (String)"stateDef");
        this.localX = localX;
        this.localY = localY;
        this.localZ = localZ;
        this.stateDef = stateDef;
    }

    public final int getLocalX() {
        return this.localX;
    }

    public final int getLocalY() {
        return this.localY;
    }

    public final int getLocalZ() {
        return this.localZ;
    }

    @NotNull
    public final String getStateDef() {
        return this.stateDef;
    }
}

