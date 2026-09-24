/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.level.Level
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.entity.ecs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.entity.ecs.ComponentBasedEntityAttributes;
import net.thebrokenscript.brokencore.api.entity.ecs.EntityComponentBase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0014J\u0006\u0010\u001b\u001a\u00020\u001cR(\u0010\t\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\r0\nX\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R$\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006$"}, d2={"Lnet/thebrokenscript/brokencore/api/entity/ecs/ComponentBasedEntity;", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster;", "type", "Lnet/minecraft/world/entity/EntityType;", "Lnet/minecraft/world/entity/monster/Monster;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "components", "", "Lkotlin/Function1;", "Lnet/thebrokenscript/brokencore/api/entity/ecs/EntityComponentBase;", "Lnet/thebrokenscript/brokencore/api/entity/ecs/ComponentProvider;", "getComponents", "()Ljava/util/List;", "initializedComponents", "componentsNeedingInit", "componentsNeedingTick", "componentsNeedingDeath", "attributes", "Lnet/thebrokenscript/brokencore/api/entity/ecs/ComponentBasedEntityAttributes;", "getAttributes", "()Lnet/thebrokenscript/brokencore/api/entity/ecs/ComponentBasedEntityAttributes;", "tick", "", "registerGoals", "createEntityAttributes", "Lnet/minecraft/world/entity/ai/attributes/AttributeSupplier$Builder;", "value", "", "xpReward", "getXpReward", "()I", "setXpReward", "(I)V", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nComponentBasedEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ComponentBasedEntity.kt\nnet/thebrokenscript/brokencore/api/entity/ecs/ComponentBasedEntity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,52:1\n1563#2:53\n1634#2,3:54\n774#2:57\n865#2,2:58\n774#2:60\n865#2,2:61\n774#2:63\n865#2,2:64\n1869#2,2:67\n1869#2,2:69\n1869#2,2:71\n1#3:66\n*S KotlinDebug\n*F\n+ 1 ComponentBasedEntity.kt\nnet/thebrokenscript/brokencore/api/entity/ecs/ComponentBasedEntity\n*L\n11#1:53\n11#1:54,3\n12#1:57\n12#1:58,2\n13#1:60\n13#1:61,2\n14#1:63\n14#1:64,2\n17#1:67,2\n20#1:69,2\n25#1:71,2\n*E\n"})
public abstract class ComponentBasedEntity
extends BaseMonster {
    @NotNull
    private final List<EntityComponentBase> initializedComponents;
    @NotNull
    private final List<EntityComponentBase> componentsNeedingInit;
    @NotNull
    private final List<EntityComponentBase> componentsNeedingTick;
    @NotNull
    private final List<EntityComponentBase> componentsNeedingDeath;
    @NotNull
    private final ComponentBasedEntityAttributes attributes;

    /*
     * WARNING - void declaration
     */
    public ComponentBasedEntity(@NotNull EntityType<? extends Monster> type, @NotNull Level level) {
        Iterable $this$filterTo$iv$iv;
        Object $this$filter$iv;
        EntityComponentBase it;
        void $this$mapTo$iv$iv;
        Iterable $this$map$iv;
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        Iterable iterable = this.getComponents();
        ComponentBasedEntity componentBasedEntity = this;
        boolean $i$f$map = false;
        void var5_8 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            Function1 function1 = (Function1)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add((EntityComponentBase)it.invoke((Object)this));
        }
        componentBasedEntity.initializedComponents = (List)destination$iv$iv;
        $this$map$iv = this.initializedComponents;
        componentBasedEntity = this;
        boolean $i$f$filter = false;
        $this$mapTo$iv$iv = $this$filter$iv;
        destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            it = (EntityComponentBase)element$iv$iv;
            boolean bl = false;
            if (!it.getNeedsInit$brokencore_common()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        componentBasedEntity.componentsNeedingInit = (List)destination$iv$iv;
        $this$filter$iv = this.initializedComponents;
        componentBasedEntity = this;
        $i$f$filter = false;
        $this$filterTo$iv$iv = $this$filter$iv;
        destination$iv$iv = new ArrayList();
        $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            it = (EntityComponentBase)element$iv$iv;
            boolean bl = false;
            if (!it.getNeedsTick$brokencore_common()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        componentBasedEntity.componentsNeedingTick = (List)destination$iv$iv;
        $this$filter$iv = this.initializedComponents;
        componentBasedEntity = this;
        $i$f$filter = false;
        $this$filterTo$iv$iv = $this$filter$iv;
        destination$iv$iv = new ArrayList();
        $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            it = (EntityComponentBase)element$iv$iv;
            boolean bl = false;
            if (!it.getNeedsDeath$brokencore_common()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        componentBasedEntity.componentsNeedingDeath = (List)destination$iv$iv;
        Object $i$f$filter2 = $this$filter$iv = new ComponentBasedEntityAttributes();
        componentBasedEntity = this;
        boolean bl = false;
        Iterable $this$forEach$iv = this.initializedComponents;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            void it2;
            EntityComponentBase c = (EntityComponentBase)element$iv;
            boolean bl2 = false;
            c.modifyAttributes().invoke((Object)it2);
        }
        componentBasedEntity.attributes = $this$filter$iv;
        Iterable $this$forEach$iv2 = this.componentsNeedingInit;
        boolean $i$f$forEach2 = false;
        for (Object element$iv : $this$forEach$iv2) {
            EntityComponentBase p0 = (EntityComponentBase)element$iv;
            boolean bl3 = false;
            p0.onInit();
        }
    }

    @NotNull
    protected abstract List<Function1<ComponentBasedEntity, EntityComponentBase>> getComponents();

    @NotNull
    public final ComponentBasedEntityAttributes getAttributes() {
        return this.attributes;
    }

    public void tick() {
        super.tick();
        Iterable $this$forEach$iv = this.componentsNeedingTick;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            EntityComponentBase p0 = (EntityComponentBase)element$iv;
            boolean bl = false;
            p0.onTick();
        }
    }

    protected void registerGoals() {
        Function1 goal;
        int i;
        super.registerGoals();
        Iterator iterator = ((Iterable)this.attributes.getGoals()).iterator();
        int n = 0;
        while (iterator.hasNext()) {
            i = n++;
            goal = (Function1)iterator.next();
            this.goalSelector.addGoal(i + 1, (Goal)goal.invoke((Object)this));
        }
        iterator = ((Iterable)this.attributes.getTargets()).iterator();
        n = 0;
        while (iterator.hasNext()) {
            i = n++;
            goal = (Function1)iterator.next();
            this.targetSelector.addGoal(i + 1, (Goal)goal.invoke((Object)this));
        }
    }

    @NotNull
    public final AttributeSupplier.Builder createEntityAttributes() {
        return this.attributes.getEntityAttributes();
    }

    public final int getXpReward() {
        return this.xpReward;
    }

    public final void setXpReward(int value) {
        this.xpReward = value;
    }
}

