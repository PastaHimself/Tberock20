/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType$Builder
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.neoforge.api.ext;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R8\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\t2\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR8\u0010\u000f\u001a\u00020\u000e\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\t2\u0006\u0010\u0004\u001a\u00020\u000e8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/brokencore/neoforge/api/ext/EntityTypeBuilderExt;", "", "<init>", "()V", "value", "", "receivesVelocityUpdates", "T", "Lnet/minecraft/world/entity/Entity;", "Lnet/minecraft/world/entity/EntityType$Builder;", "getReceivesVelocityUpdates", "(Lnet/minecraft/world/entity/EntityType$Builder;)Z", "setReceivesVelocityUpdates", "(Lnet/minecraft/world/entity/EntityType$Builder;Z)V", "", "trackingRange", "getTrackingRange", "(Lnet/minecraft/world/entity/EntityType$Builder;)I", "setTrackingRange", "(Lnet/minecraft/world/entity/EntityType$Builder;I)V", "brokencore-neoforge"})
@SourceDebugExtension(value={"SMAP\nEntityTypeBuilderExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EntityTypeBuilderExt.kt\nnet/thebrokenscript/brokencore/neoforge/api/ext/EntityTypeBuilderExt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,20:1\n1#2:21\n*E\n"})
public final class EntityTypeBuilderExt {
    @NotNull
    public static final EntityTypeBuilderExt INSTANCE = new EntityTypeBuilderExt();

    private EntityTypeBuilderExt() {
    }

    public final <T extends Entity> boolean getReceivesVelocityUpdates(@NotNull EntityType.Builder<T> $this$receivesVelocityUpdates) {
        Intrinsics.checkNotNullParameter($this$receivesVelocityUpdates, (String)"<this>");
        return false;
    }

    public final <T extends Entity> void setReceivesVelocityUpdates(@NotNull EntityType.Builder<T> $this$receivesVelocityUpdates, boolean value) {
        Intrinsics.checkNotNullParameter($this$receivesVelocityUpdates, (String)"<this>");
        EntityType.Builder<T> $this$_set_receivesVelocityUpdates__u24lambda_u240 = $this$receivesVelocityUpdates;
        boolean bl = false;
        $this$_set_receivesVelocityUpdates__u24lambda_u240.setShouldReceiveVelocityUpdates(value);
    }

    public final <T extends Entity> int getTrackingRange(@NotNull EntityType.Builder<T> $this$trackingRange) {
        Intrinsics.checkNotNullParameter($this$trackingRange, (String)"<this>");
        return 0;
    }

    public final <T extends Entity> void setTrackingRange(@NotNull EntityType.Builder<T> $this$trackingRange, int value) {
        Intrinsics.checkNotNullParameter($this$trackingRange, (String)"<this>");
        EntityType.Builder<T> $this$_set_trackingRange__u24lambda_u240 = $this$trackingRange;
        boolean bl = false;
        $this$_set_trackingRange__u24lambda_u240.setTrackingRange(value);
    }
}

