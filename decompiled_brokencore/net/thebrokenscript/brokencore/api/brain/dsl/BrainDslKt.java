/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.memory.MemoryModuleType
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.brain.dsl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u00000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a+\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u0002H\u0005\u00a2\u0006\u0002\u0010\u0011\u001a%\u0010\u0012\u001a\u0004\u0018\u0001H\u0005\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u000e2\u0006\u0010\u000f\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\u0013*0\b\u0002\u0010\u0000\u001a\u0004\b\u0000\u0010\u0001\u001a\u0004\b\u0001\u0010\u0002\"\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003*X\b\u0002\u0010\u0004\u001a\u0004\b\u0000\u0010\u0005\"\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\t`\u00070\u000620\u0012,\u0012*\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\t0\u0003j\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\t`\u00070\u0006*R\b\u0002\u0010\n\"\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\t`\u00070\u000620\u0012,\u0012*\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\t0\u0003j\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\t`\u00070\u0006\u00a8\u0006\u0014"}, d2={"MojPair", "A", "B", "Lcom/mojang/datafixers/util/Pair;", "BehaviorList", "T", "Lcom/google/common/collect/ImmutableList;", "Lnet/thebrokenscript/brokencore/api/brain/dsl/MojPair;", "", "Lnet/minecraft/world/entity/ai/behavior/BehaviorControl;", "BehaviorCast", "Lnet/minecraft/world/entity/LivingEntity;", "set", "", "Lnet/minecraft/world/entity/ai/memory/MemoryModuleType;", "entity", "value", "(Lnet/minecraft/world/entity/ai/memory/MemoryModuleType;Lnet/minecraft/world/entity/LivingEntity;Ljava/lang/Object;)V", "get", "(Lnet/minecraft/world/entity/ai/memory/MemoryModuleType;Lnet/minecraft/world/entity/LivingEntity;)Ljava/lang/Object;", "brokencore-common"})
public final class BrainDslKt {
    public static final <T> void set(@NotNull MemoryModuleType<T> $this$set, @NotNull LivingEntity entity, T value) {
        Intrinsics.checkNotNullParameter($this$set, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        entity.getBrain().setMemory($this$set, value);
    }

    @Nullable
    public static final <T> T get(@NotNull MemoryModuleType<T> $this$get, @NotNull LivingEntity entity) {
        Intrinsics.checkNotNullParameter($this$get, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        return entity.getBrain().getMemory($this$get).orElse(null);
    }
}

