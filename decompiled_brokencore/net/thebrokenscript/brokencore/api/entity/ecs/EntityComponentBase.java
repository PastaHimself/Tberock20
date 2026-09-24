/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KFunction
 *  kotlin.reflect.jvm.ReflectJvmMapping
 *  net.minecraft.core.BlockPos
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.entity.ecs;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlin.reflect.jvm.ReflectJvmMapping;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.entity.ecs.ComponentBasedEntity;
import net.thebrokenscript.brokencore.api.entity.ecs.ComponentBasedEntityAttributes;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0016J \u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%H\u0016J\u0019\u0010'\u001a\u0013\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00150(\u00a2\u0006\u0002\b*H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010+\u001a\u00020,X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020,X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010.R\u0014\u00101\u001a\u00020,X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010.R\u0014\u00103\u001a\u00020,X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010.R\u0014\u00105\u001a\u00020,X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010.R\u0014\u00107\u001a\u00020,X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010.R\u0014\u00109\u001a\u00020,X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010.R\u0014\u0010;\u001a\u00020,X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010.\u00a8\u0006="}, d2={"Lnet/thebrokenscript/brokencore/api/entity/ecs/EntityComponentBase;", "", "entity", "Lnet/thebrokenscript/brokencore/api/entity/ecs/ComponentBasedEntity;", "<init>", "(Lnet/thebrokenscript/brokencore/api/entity/ecs/ComponentBasedEntity;)V", "getEntity", "()Lnet/thebrokenscript/brokencore/api/entity/ecs/ComponentBasedEntity;", "level", "Lnet/minecraft/world/level/Level;", "getLevel", "()Lnet/minecraft/world/level/Level;", "blockPos", "Lnet/minecraft/core/BlockPos;", "getBlockPos", "()Lnet/minecraft/core/BlockPos;", "pos", "Lnet/minecraft/world/phys/Vec3;", "getPos", "()Lnet/minecraft/world/phys/Vec3;", "onInit", "", "onSpawned", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "onTick", "onDeath", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "onKill", "onKillEntity", "killed", "Lnet/minecraft/world/entity/Entity;", "score", "", "addSaveData", "tag", "Lnet/minecraft/nbt/CompoundTag;", "loadSaveData", "modifyAttributes", "Lkotlin/Function1;", "Lnet/thebrokenscript/brokencore/api/entity/ecs/ComponentBasedEntityAttributes;", "Lkotlin/ExtensionFunctionType;", "needsInit", "", "getNeedsInit$brokencore_common", "()Z", "needsSpawned", "getNeedsSpawned$brokencore_common", "needsTick", "getNeedsTick$brokencore_common", "needsDeath", "getNeedsDeath$brokencore_common", "needsKilled", "getNeedsKilled$brokencore_common", "needsKilledEntity", "getNeedsKilledEntity$brokencore_common", "needsSaveData", "getNeedsSaveData$brokencore_common", "needsLoadData", "getNeedsLoadData$brokencore_common", "brokencore-common"})
public class EntityComponentBase {
    @NotNull
    private final ComponentBasedEntity entity;
    private final boolean needsInit;
    private final boolean needsSpawned;
    private final boolean needsTick;
    private final boolean needsDeath;
    private final boolean needsKilled;
    private final boolean needsKilledEntity;
    private final boolean needsSaveData;
    private final boolean needsLoadData;

    public EntityComponentBase(@NotNull ComponentBasedEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        this.entity = entity;
        Method method = ReflectJvmMapping.getJavaMethod((KFunction)((KFunction)new Function0<Unit>((Object)this){

            public final void invoke() {
                ((EntityComponentBase)this.receiver).onInit();
            }
        }));
        Intrinsics.checkNotNull((Object)method);
        this.needsInit = !Intrinsics.areEqual(method.getDeclaringClass(), EntityComponentBase.class);
        Method method2 = ReflectJvmMapping.getJavaMethod((KFunction)((KFunction)new Function1<CancelProxy, Unit>((Object)this){

            public final void invoke(CancelProxy p0) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                ((EntityComponentBase)this.receiver).onSpawned(p0);
            }
        }));
        Intrinsics.checkNotNull((Object)method2);
        this.needsSpawned = !Intrinsics.areEqual(method2.getDeclaringClass(), EntityComponentBase.class);
        Method method3 = ReflectJvmMapping.getJavaMethod((KFunction)((KFunction)new Function0<Unit>((Object)this){

            public final void invoke() {
                ((EntityComponentBase)this.receiver).onTick();
            }
        }));
        Intrinsics.checkNotNull((Object)method3);
        this.needsTick = !Intrinsics.areEqual(method3.getDeclaringClass(), EntityComponentBase.class);
        Method method4 = ReflectJvmMapping.getJavaMethod((KFunction)((KFunction)new Function1<DamageSource, Unit>((Object)this){

            public final void invoke(DamageSource p0) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                ((EntityComponentBase)this.receiver).onDeath(p0);
            }
        }));
        Intrinsics.checkNotNull((Object)method4);
        this.needsDeath = !Intrinsics.areEqual(method4.getDeclaringClass(), EntityComponentBase.class);
        Method method5 = ReflectJvmMapping.getJavaMethod((KFunction)((KFunction)new Function0<Unit>((Object)this){

            public final void invoke() {
                ((EntityComponentBase)this.receiver).onKill();
            }
        }));
        Intrinsics.checkNotNull((Object)method5);
        this.needsKilled = !Intrinsics.areEqual(method5.getDeclaringClass(), EntityComponentBase.class);
        Method method6 = ReflectJvmMapping.getJavaMethod((KFunction)((KFunction)new Function3<Entity, Integer, DamageSource, Unit>((Object)this){

            public final void invoke(Entity p0, int p1, DamageSource p2) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                Intrinsics.checkNotNullParameter((Object)p2, (String)"p2");
                ((EntityComponentBase)this.receiver).onKillEntity(p0, p1, p2);
            }
        }));
        Intrinsics.checkNotNull((Object)method6);
        this.needsKilledEntity = !Intrinsics.areEqual(method6.getDeclaringClass(), EntityComponentBase.class);
        Method method7 = ReflectJvmMapping.getJavaMethod((KFunction)((KFunction)new Function1<CompoundTag, Unit>((Object)this){

            public final void invoke(CompoundTag p0) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                ((EntityComponentBase)this.receiver).addSaveData(p0);
            }
        }));
        Intrinsics.checkNotNull((Object)method7);
        this.needsSaveData = !Intrinsics.areEqual(method7.getDeclaringClass(), EntityComponentBase.class);
        Method method8 = ReflectJvmMapping.getJavaMethod((KFunction)((KFunction)new Function1<CompoundTag, Unit>((Object)this){

            public final void invoke(CompoundTag p0) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                ((EntityComponentBase)this.receiver).loadSaveData(p0);
            }
        }));
        Intrinsics.checkNotNull((Object)method8);
        this.needsLoadData = !Intrinsics.areEqual(method8.getDeclaringClass(), EntityComponentBase.class);
    }

    @NotNull
    protected final ComponentBasedEntity getEntity() {
        return this.entity;
    }

    @NotNull
    protected final Level getLevel() {
        return this.entity.getLevel();
    }

    @NotNull
    protected final BlockPos getBlockPos() {
        return this.entity.getBlockPos();
    }

    @NotNull
    protected final Vec3 getPos() {
        return this.entity.getPos();
    }

    public void onInit() {
    }

    public void onSpawned(@NotNull CancelProxy event) {
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
    }

    public void onTick() {
    }

    public void onDeath(@NotNull DamageSource source) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
    }

    public void onKill() {
    }

    public void onKillEntity(@NotNull Entity killed, int score, @NotNull DamageSource source) {
        Intrinsics.checkNotNullParameter((Object)killed, (String)"killed");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
    }

    public void addSaveData(@NotNull CompoundTag tag) {
        Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
    }

    public void loadSaveData(@NotNull CompoundTag tag) {
        Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
    }

    @NotNull
    public Function1<ComponentBasedEntityAttributes, Unit> modifyAttributes() {
        return EntityComponentBase::modifyAttributes$lambda$0;
    }

    public final boolean getNeedsInit$brokencore_common() {
        return this.needsInit;
    }

    public final boolean getNeedsSpawned$brokencore_common() {
        return this.needsSpawned;
    }

    public final boolean getNeedsTick$brokencore_common() {
        return this.needsTick;
    }

    public final boolean getNeedsDeath$brokencore_common() {
        return this.needsDeath;
    }

    public final boolean getNeedsKilled$brokencore_common() {
        return this.needsKilled;
    }

    public final boolean getNeedsKilledEntity$brokencore_common() {
        return this.needsKilledEntity;
    }

    public final boolean getNeedsSaveData$brokencore_common() {
        return this.needsSaveData;
    }

    public final boolean getNeedsLoadData$brokencore_common() {
        return this.needsLoadData;
    }

    private static final Unit modifyAttributes$lambda$0(ComponentBasedEntityAttributes componentBasedEntityAttributes) {
        Intrinsics.checkNotNullParameter((Object)componentBasedEntityAttributes, (String)"<this>");
        return Unit.INSTANCE;
    }
}

