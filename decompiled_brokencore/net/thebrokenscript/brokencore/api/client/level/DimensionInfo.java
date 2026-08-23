/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.endec.StructEndec
 *  io.wispforest.endec.impl.StructEndecBuilder
 *  io.wispforest.endec.impl.StructField
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KProperty1
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.level.Level
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.client.level;

import io.wispforest.endec.StructEndec;
import io.wispforest.endec.impl.StructEndecBuilder;
import io.wispforest.endec.impl.StructField;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.thebrokenscript.brokencore.api.client.level.DimensionInfo;
import net.thebrokenscript.brokencore.api.util.serde.Endecs;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J)\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/brokencore/api/client/level/DimensionInfo;", "", "from", "Lnet/minecraft/resources/ResourceKey;", "Lnet/minecraft/world/level/Level;", "to", "<init>", "(Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/resources/ResourceKey;)V", "getFrom", "()Lnet/minecraft/resources/ResourceKey;", "getTo", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "brokencore-common"})
public final class DimensionInfo {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ResourceKey<Level> from;
    @NotNull
    private final ResourceKey<Level> to;
    @NotNull
    private static final StructEndec<DimensionInfo> ENDEC;

    public DimensionInfo(@NotNull ResourceKey<Level> from, @NotNull ResourceKey<Level> to) {
        Intrinsics.checkNotNullParameter(from, (String)"from");
        Intrinsics.checkNotNullParameter(to, (String)"to");
        this.from = from;
        this.to = to;
    }

    @NotNull
    public final ResourceKey<Level> getFrom() {
        return this.from;
    }

    @NotNull
    public final ResourceKey<Level> getTo() {
        return this.to;
    }

    @NotNull
    public final ResourceKey<Level> component1() {
        return this.from;
    }

    @NotNull
    public final ResourceKey<Level> component2() {
        return this.to;
    }

    @NotNull
    public final DimensionInfo copy(@NotNull ResourceKey<Level> from, @NotNull ResourceKey<Level> to) {
        Intrinsics.checkNotNullParameter(from, (String)"from");
        Intrinsics.checkNotNullParameter(to, (String)"to");
        return new DimensionInfo(from, to);
    }

    public static /* synthetic */ DimensionInfo copy$default(DimensionInfo dimensionInfo, ResourceKey resourceKey, ResourceKey resourceKey2, int n, Object object) {
        if ((n & 1) != 0) {
            resourceKey = dimensionInfo.from;
        }
        if ((n & 2) != 0) {
            resourceKey2 = dimensionInfo.to;
        }
        return dimensionInfo.copy(resourceKey, resourceKey2);
    }

    @NotNull
    public String toString() {
        return "DimensionInfo(from=" + this.from + ", to=" + this.to + ")";
    }

    public int hashCode() {
        int result = this.from.hashCode();
        result = result * 31 + this.to.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DimensionInfo)) {
            return false;
        }
        DimensionInfo dimensionInfo = (DimensionInfo)other;
        if (!Intrinsics.areEqual(this.from, dimensionInfo.from)) {
            return false;
        }
        return Intrinsics.areEqual(this.to, dimensionInfo.to);
    }

    private static final ResourceKey ENDEC$lambda$0(KProperty1 $tmp0, DimensionInfo p0) {
        return (ResourceKey)((Function1)$tmp0).invoke((Object)p0);
    }

    private static final ResourceKey ENDEC$lambda$1(KProperty1 $tmp0, DimensionInfo p0) {
        return (ResourceKey)((Function1)$tmp0).invoke((Object)p0);
    }

    static {
        ResourceKey resourceKey = Registries.DIMENSION;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"DIMENSION");
        StructField structField = Endecs.INSTANCE.resourceKey(resourceKey).fieldOf("from", arg_0 -> DimensionInfo.ENDEC$lambda$0((KProperty1)Companion.ENDEC.1.INSTANCE, arg_0));
        ResourceKey resourceKey2 = Registries.DIMENSION;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey2, (String)"DIMENSION");
        StructEndec structEndec = StructEndecBuilder.of((StructField)structField, (StructField)Endecs.INSTANCE.resourceKey(resourceKey2).fieldOf("to", arg_0 -> DimensionInfo.ENDEC$lambda$1((KProperty1)Companion.ENDEC.2.INSTANCE, arg_0)), DimensionInfo::new);
        Intrinsics.checkNotNullExpressionValue((Object)structEndec, (String)"of(...)");
        ENDEC = structEndec;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/client/level/DimensionInfo$Companion;", "", "<init>", "()V", "ENDEC", "Lio/wispforest/endec/StructEndec;", "Lnet/thebrokenscript/brokencore/api/client/level/DimensionInfo;", "getENDEC", "()Lio/wispforest/endec/StructEndec;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final StructEndec<DimensionInfo> getENDEC() {
            return ENDEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

