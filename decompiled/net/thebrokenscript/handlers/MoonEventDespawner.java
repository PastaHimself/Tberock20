/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.handlers.subs.EntitySpawnSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSTags;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/handlers/MoonEventDespawner;", "", "<init>", "()V", "onEntitySpawned", "", "entity", "Lnet/minecraft/world/entity/Entity;", "cancelProxy", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "shouldDespawn", "", "level", "Lnet/minecraft/world/level/Level;", "thebrokenscript-common"})
public final class MoonEventDespawner {
    @NotNull
    public static final MoonEventDespawner INSTANCE = new MoonEventDespawner();

    private MoonEventDespawner() {
    }

    private final void onEntitySpawned(Entity entity, CancelProxy cancelProxy) {
        Level level = entity.level();
        Intrinsics.checkNotNull((Object)level);
        if (!this.shouldDespawn(level)) {
            return;
        }
        if (!entity.getType().is(TBSTags.DESPAWNABLE)) {
            return;
        }
        cancelProxy.setCanceled(true);
        Entity vehicle = entity.getVehicle();
        if (vehicle != null && vehicle.getPassengers().size() == 1) {
            vehicle.discard();
        }
    }

    private final boolean shouldDespawn(Level level) {
        int n = level.dimensionType().moonPhase(level.dayTime());
        return (4 <= n ? n < 8 : false) && LevelExt.INSTANCE.getVars((LevelAccessor)level).getMoonStage() != 0;
    }

    static {
        EntitySpawnSubscriber.INSTANCE.add((Function2<? super Entity, ? super CancelProxy, Unit>)((Function2)new Function2<Entity, CancelProxy, Unit>((Object)INSTANCE){

            public final void invoke(Entity p0, CancelProxy p1) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                Intrinsics.checkNotNullParameter((Object)p1, (String)"p1");
                ((MoonEventDespawner)this.receiver).onEntitySpawned(p0, p1);
            }
        }));
    }
}

