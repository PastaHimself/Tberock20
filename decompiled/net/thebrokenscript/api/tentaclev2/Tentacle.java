/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.tentaclev2;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.api.tentaclev2.TentacleNode;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/api/tentaclev2/Tentacle;", "", "nodes", "", "Lnet/thebrokenscript/api/tentaclev2/TentacleNode;", "<init>", "(Ljava/util/List;)V", "getNodes", "()Ljava/util/List;", "thebrokenscript-common"})
public final class Tentacle {
    @NotNull
    private final List<TentacleNode> nodes;

    public Tentacle(@NotNull List<TentacleNode> nodes) {
        Intrinsics.checkNotNullParameter(nodes, (String)"nodes");
        this.nodes = nodes;
    }

    public /* synthetic */ Tentacle(List list, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            list = new ArrayList();
        }
        this(list);
    }

    @NotNull
    public final List<TentacleNode> getNodes() {
        return this.nodes;
    }

    public Tentacle() {
        this(null, 1, null);
    }
}

