/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.goal.Goal
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.entity.ecs;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.Goal;
import net.thebrokenscript.brokencore.api.entity.ecs.ComponentBasedEntity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\r0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R#\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\r0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/brokencore/api/entity/ecs/ComponentBasedEntityAttributes;", "", "<init>", "()V", "entityAttributes", "Lnet/minecraft/world/entity/ai/attributes/AttributeSupplier$Builder;", "getEntityAttributes", "()Lnet/minecraft/world/entity/ai/attributes/AttributeSupplier$Builder;", "pushable", "", "getPushable", "()Z", "removeWhenFarAway", "Lkotlin/Function1;", "", "getRemoveWhenFarAway", "()Lkotlin/jvm/functions/Function1;", "goals", "", "Lnet/thebrokenscript/brokencore/api/entity/ecs/ComponentBasedEntity;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "getGoals", "()Ljava/util/List;", "targets", "getTargets", "brokencore-common"})
public final class ComponentBasedEntityAttributes {
    @NotNull
    private final AttributeSupplier.Builder entityAttributes;
    private final boolean pushable;
    @NotNull
    private final Function1<Double, Boolean> removeWhenFarAway;
    @NotNull
    private final List<Function1<ComponentBasedEntity, Goal>> goals;
    @NotNull
    private final List<Function1<ComponentBasedEntity, Goal>> targets;

    public ComponentBasedEntityAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        Intrinsics.checkNotNullExpressionValue((Object)builder, (String)"createMobAttributes(...)");
        this.entityAttributes = builder;
        this.removeWhenFarAway = ComponentBasedEntityAttributes::removeWhenFarAway$lambda$0;
        this.goals = new ArrayList();
        this.targets = new ArrayList();
    }

    @NotNull
    public final AttributeSupplier.Builder getEntityAttributes() {
        return this.entityAttributes;
    }

    public final boolean getPushable() {
        return this.pushable;
    }

    @NotNull
    public final Function1<Double, Boolean> getRemoveWhenFarAway() {
        return this.removeWhenFarAway;
    }

    @NotNull
    public final List<Function1<ComponentBasedEntity, Goal>> getGoals() {
        return this.goals;
    }

    @NotNull
    public final List<Function1<ComponentBasedEntity, Goal>> getTargets() {
        return this.targets;
    }

    private static final boolean removeWhenFarAway$lambda$0(double it) {
        return true;
    }
}

