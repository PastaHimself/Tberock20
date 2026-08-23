/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.memory.MemoryModuleType
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.brain.sensors;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.BCApi;
import net.thebrokenscript.brokencore.api.brain.dsl.BrainDslKt;
import net.thebrokenscript.brokencore.api.brain.impl.BaseSensor;
import net.thebrokenscript.brokencore.api.brain.util.BrainRegistryHelper;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u00a2\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u0000H\u0014\u00a2\u0006\u0002\u0010\u001aJ\u0014\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2={"Lnet/thebrokenscript/brokencore/api/brain/sensors/LineOfSightSensor;", "T", "Lnet/minecraft/world/entity/LivingEntity;", "Lnet/thebrokenscript/brokencore/api/brain/impl/BaseSensor;", "scanTime", "", "bounds", "Lnet/minecraft/world/phys/AABB;", "predicate", "Lkotlin/Function1;", "Lnet/minecraft/world/entity/Entity;", "", "<init>", "(ILnet/minecraft/world/phys/AABB;Lkotlin/jvm/functions/Function1;)V", "getBounds", "()Lnet/minecraft/world/phys/AABB;", "getPredicate", "()Lkotlin/jvm/functions/Function1;", "lastSeenAt", "Lnet/minecraft/world/entity/ai/memory/MemoryModuleType;", "Lnet/minecraft/world/phys/Vec3;", "doTick", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "entity", "(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/LivingEntity;)V", "requires", "", "register", "location", "Lnet/minecraft/resources/ResourceLocation;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nLineOfSightSensor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LineOfSightSensor.kt\nnet/thebrokenscript/brokencore/api/brain/sensors/LineOfSightSensor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,33:1\n1869#2,2:34\n*S KotlinDebug\n*F\n+ 1 LineOfSightSensor.kt\nnet/thebrokenscript/brokencore/api/brain/sensors/LineOfSightSensor\n*L\n23#1:34,2\n*E\n"})
public final class LineOfSightSensor<T extends LivingEntity>
extends BaseSensor<T> {
    @NotNull
    private final AABB bounds;
    @NotNull
    private final Function1<Entity, Boolean> predicate;
    @NotNull
    private final MemoryModuleType<Vec3> lastSeenAt;

    public LineOfSightSensor(int scanTime, @NotNull AABB bounds, @NotNull Function1<? super Entity, Boolean> predicate) {
        Intrinsics.checkNotNullParameter((Object)bounds, (String)"bounds");
        Intrinsics.checkNotNullParameter(predicate, (String)"predicate");
        super(scanTime);
        this.bounds = bounds;
        this.predicate = predicate;
        this.lastSeenAt = new MemoryModuleType(Optional.of(Vec3.CODEC));
    }

    public /* synthetic */ LineOfSightSensor(int n, AABB aABB, Function1 function1, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            AABB aABB2 = AABB.of((BoundingBox)BoundingBox.infinite());
            Intrinsics.checkNotNullExpressionValue((Object)aABB2, (String)"of(...)");
            aABB = aABB2;
        }
        this(n, aABB, (Function1<? super Entity, Boolean>)function1);
    }

    @NotNull
    public final AABB getBounds() {
        return this.bounds;
    }

    @NotNull
    public final Function1<Entity, Boolean> getPredicate() {
        return this.predicate;
    }

    protected void doTick(@NotNull ServerLevel level, @NotNull T entity) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        List list = ((Entity)entity).level().getEntities((Entity)entity, this.bounds, arg_0 -> LineOfSightSensor.doTick$lambda$0(this.predicate, arg_0));
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getEntities(...)");
        Iterable $this$forEach$iv = list;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Entity it = (Entity)element$iv;
            boolean bl = false;
            if (!entity.hasLineOfSight(it)) continue;
            BrainDslKt.set(this.lastSeenAt, entity, it.position());
        }
    }

    @NotNull
    public Set<MemoryModuleType<Vec3>> requires() {
        return SetsKt.setOf(this.lastSeenAt);
    }

    @Override
    public void register(@NotNull ResourceLocation location) {
        Intrinsics.checkNotNullParameter((Object)location, (String)"location");
        BrainRegistryHelper.INSTANCE.registerMemory(BCApi.id("last_seen_at"), this.lastSeenAt);
    }

    private static final boolean doTick$lambda$0(Function1 $tmp0, Object p0) {
        return (Boolean)$tmp0.invoke(p0);
    }
}

