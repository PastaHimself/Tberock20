/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.entity.fractured;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.thebrokenscript.entity.fractured.FracturedEntity;
import net.thebrokenscript.entity.fractured.attacks.JimAttack;
import net.thebrokenscript.entity.fractured.attacks.JimAttackType;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/entity/fractured/JimAttackSelectorGoal;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "jimmy", "Lnet/thebrokenscript/entity/fractured/FracturedEntity;", "<init>", "(Lnet/thebrokenscript/entity/fractured/FracturedEntity;)V", "canUse", "", "canContinueToUse", "start", "", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nFracturedEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FracturedEntity.kt\nnet/thebrokenscript/entity/fractured/JimAttackSelectorGoal\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,320:1\n774#2:321\n865#2,2:322\n1#3:324\n*S KotlinDebug\n*F\n+ 1 FracturedEntity.kt\nnet/thebrokenscript/entity/fractured/JimAttackSelectorGoal\n*L\n292#1:321\n292#1:322,2\n*E\n"})
public final class JimAttackSelectorGoal
extends Goal {
    @NotNull
    private final FracturedEntity jimmy;

    public JimAttackSelectorGoal(@NotNull FracturedEntity jimmy) {
        Intrinsics.checkNotNullParameter((Object)((Object)jimmy), (String)"jimmy");
        this.jimmy = jimmy;
        this.setFlags(EnumSet.noneOf(Goal.Flag.class));
    }

    public boolean canUse() {
        if (this.jimmy.getTarget() == null) {
            return false;
        }
        return this.jimmy.getAttackStateInternal().getType() == JimAttackType.NOOP && this.jimmy.getAttackDelay() <= 0L;
    }

    public boolean canContinueToUse() {
        return false;
    }

    /*
     * WARNING - void declaration
     */
    public void start() {
        JimAttack attack;
        Iterable $this$filterTo$iv$iv;
        LivingEntity livingEntity = this.jimmy.getTarget();
        if (livingEntity == null) {
            return;
        }
        LivingEntity target = livingEntity;
        double distSqr = this.jimmy.distanceToSqr((Entity)target);
        Collection collection = FracturedEntity.Companion.getATTACKS$thebrokenscript_common().values();
        Intrinsics.checkNotNullExpressionValue((Object)collection, (String)"<get-values>(...)");
        Iterable $this$filter$iv = collection;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv22 = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            boolean bl;
            attack = (JimAttack)element$iv$iv;
            boolean bl2 = false;
            if (!attack.canUse(this.jimmy)) {
                bl = false;
            } else {
                Pair<Integer, Integer> pair = attack.getDistanceRange();
                int min = ((Number)pair.component1()).intValue();
                int max = ((Number)pair.component2()).intValue();
                if (min == Integer.MIN_VALUE && max == Integer.MAX_VALUE) {
                    bl = true;
                } else {
                    double d = (double)min * (double)min;
                    bl = distSqr <= (double)max * (double)max ? d <= distSqr : false;
                }
            }
            if (!bl) continue;
            destination$iv$iv22.add(element$iv$iv);
        }
        List candidates = (List)destination$iv$iv22;
        if (candidates.isEmpty()) {
            return;
        }
        $this$filterTo$iv$iv = candidates;
        double destination$iv$iv22 = 0.0;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            void it;
            attack = (JimAttack)element$iv$iv;
            double d = destination$iv$iv22;
            boolean bl = false;
            double d2 = it.getChance();
            destination$iv$iv22 = d + d2;
        }
        double totalWeight = destination$iv$iv22;
        JimAttack selected = null;
        block2: while (selected == null) {
            double roll = this.jimmy.getRandom().nextDouble() * totalWeight;
            for (JimAttack attack2 : candidates) {
                if (!((roll -= (double)attack2.getChance()) <= 0.0)) continue;
                selected = attack2;
                continue block2;
            }
        }
        this.jimmy.setAttackStateInternal(selected);
        this.jimmy.setAttackTicks(0);
        this.jimmy.setAttackDelay(0L);
        selected.setup(this.jimmy);
    }
}

