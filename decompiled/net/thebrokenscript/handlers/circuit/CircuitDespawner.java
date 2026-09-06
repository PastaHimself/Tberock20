/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.circuit;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.entity.circuit.CircuitStalkEntity;
import net.thebrokenscript.entity.circuit.CircuitStareEntity;
import net.thebrokenscript.handlers.subs.EntitySpawnSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSTags;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/handlers/circuit/CircuitDespawner;", "", "<init>", "()V", "onEntitySpawned", "", "entity", "Lnet/minecraft/world/entity/Entity;", "cancelProxy", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "thebrokenscript-common"})
public final class CircuitDespawner {
    @NotNull
    public static final CircuitDespawner INSTANCE = new CircuitDespawner();

    private CircuitDespawner() {
    }

    private final void onEntitySpawned(Entity entity, CancelProxy cancelProxy) {
        Level level = entity.level();
        if (!(level instanceof ServerLevel)) {
            return;
        }
        if (entity.getType().is(TBSTags.DESPAWNABLE)) {
            LevelAccessor levelAccessor = (LevelAccessor)level;
            Vec3 vec3 = entity.position();
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
            Class[] classArray = new Class[]{CircuitStalkEntity.class, CircuitStareEntity.class};
            if (EntityFinder.hasEntitiesInRange((LevelAccessor)levelAccessor, (Vec3)vec3, (Number)2000, (Class[])classArray)) {
                cancelProxy.setCanceled(true);
            }
        }
    }

    static {
        EntitySpawnSubscriber.INSTANCE.add((Function2<? super Entity, ? super CancelProxy, Unit>)((Function2)new Function2<Entity, CancelProxy, Unit>((Object)INSTANCE){

            public final void invoke(Entity p0, CancelProxy p1) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                Intrinsics.checkNotNullParameter((Object)p1, (String)"p1");
                ((CircuitDespawner)this.receiver).onEntitySpawned(p0, p1);
            }
        }));
    }
}

