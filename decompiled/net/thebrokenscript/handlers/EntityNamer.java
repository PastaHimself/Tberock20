/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.network.chat.Component
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.npc.Villager
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.Villager;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.handlers.subs.EntitySpawnSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSLang;
import net.thebrokenscript.registry.TBSTags;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/handlers/EntityNamer;", "", "<init>", "()V", "onEntitySpawned", "", "entity", "Lnet/minecraft/world/entity/Entity;", "cancelProxy", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "thebrokenscript-common"})
public final class EntityNamer {
    @NotNull
    public static final EntityNamer INSTANCE = new EntityNamer();

    private EntityNamer() {
    }

    private final void onEntitySpawned(Entity entity, CancelProxy cancelProxy) {
        if (entity instanceof Villager) {
            if ((double)((Villager)entity).getRandom().nextFloat() < 0.5) {
                ((Villager)entity).setCustomName((Component)TBSLang.INSTANCE.getVILLAGER_NICK());
            }
        } else if (entity.getType().is(TBSTags.DESPAWNABLE) && (double)entity.getRandom().nextFloat() < 0.01) {
            entity.setCustomName((double)entity.getRandom().nextFloat() < 0.7 ? (Component)TBSLang.INSTANCE.getRANDOM_NICK_1() : (Component)TBSLang.INSTANCE.getRANDOM_NICK_2());
        }
    }

    static {
        EntitySpawnSubscriber.INSTANCE.add((Function2<? super Entity, ? super CancelProxy, Unit>)((Function2)new Function2<Entity, CancelProxy, Unit>((Object)INSTANCE){

            public final void invoke(Entity p0, CancelProxy p1) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                Intrinsics.checkNotNullParameter((Object)p1, (String)"p1");
                ((EntityNamer)this.receiver).onEntitySpawned(p0, p1);
            }
        }));
    }
}

