/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.ai.memory.MemoryModuleType
 *  net.minecraft.world.entity.ai.memory.MemoryStatus
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.brain.dsl;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0086\u0004J\u001d\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00070\rH\u0000\u00a2\u0006\u0002\b\u000eR\u001e\u0010\u0004\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/api/brain/dsl/MemoryRequireBuilder;", "", "<init>", "()V", "memoryMap", "", "Lnet/minecraft/world/entity/ai/memory/MemoryModuleType;", "Lnet/minecraft/world/entity/ai/memory/MemoryStatus;", "of", "", "T", "status", "build", "", "build$brokencore_common", "brokencore-common"})
public final class MemoryRequireBuilder {
    @NotNull
    private final Map<MemoryModuleType<?>, MemoryStatus> memoryMap = new LinkedHashMap();

    public final <T> void of(@NotNull MemoryModuleType<T> $this$of, @NotNull MemoryStatus status) {
        Intrinsics.checkNotNullParameter($this$of, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)status, (String)"status");
        this.memoryMap.put($this$of, status);
    }

    @NotNull
    public final Map<MemoryModuleType<?>, MemoryStatus> build$brokencore_common() {
        return MapsKt.toMap(this.memoryMap);
    }
}

