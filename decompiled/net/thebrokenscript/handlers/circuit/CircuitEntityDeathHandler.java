/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.circuit;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.data.CircuitInhabited;
import net.thebrokenscript.handlers.subs.AttackEntitySubscriber;
import net.thebrokenscript.handlers.subs.LivingDeathSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSDataAttachments;
import net.thebrokenscript.registry.TBSEntities;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/handlers/circuit/CircuitEntityDeathHandler;", "", "<init>", "()V", "thebrokenscript-common"})
public final class CircuitEntityDeathHandler {
    @NotNull
    public static final CircuitEntityDeathHandler INSTANCE = new CircuitEntityDeathHandler();

    private CircuitEntityDeathHandler() {
    }

    private static final Unit _init_$lambda$0(Entity ent, Player player) {
        Intrinsics.checkNotNullParameter((Object)ent, (String)"ent");
        Intrinsics.checkNotNullParameter((Object)player, (String)"<unused var>");
        if (((CircuitInhabited)EntityUtil.getData((Entity)ent, TBSDataAttachments.CIRCUIT_INHABITED)).getInhabited()) {
            Level level = ent.level();
            Intrinsics.checkNotNullExpressionValue((Object)level, (String)"level(...)");
            if (!LevelExt.INSTANCE.getVars((LevelAccessor)level).getHasCircuitSpawned()) {
                EntityType entityType = (EntityType)TBSEntities.CIRCUIT.get();
                Level level2 = ent.level();
                Intrinsics.checkNotNullExpressionValue((Object)level2, (String)"level(...)");
                LevelAccessor levelAccessor = (LevelAccessor)level2;
                Vec3 vec3 = ent.position();
                Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
                Entity entity = EntityTypeExt.trySummon((EntityType)entityType, (LevelAccessor)levelAccessor, (Vec3)vec3);
                if (entity != null) {
                    EntityUtil.applyRandomRotation((Entity)entity);
                }
                if (!(ent instanceof Player)) {
                    ent.discard();
                } else {
                    ((Player)ent).kill();
                }
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$1(LivingEntity ent, DamageSource damageSource) {
        Intrinsics.checkNotNullParameter((Object)ent, (String)"ent");
        Intrinsics.checkNotNullParameter((Object)damageSource, (String)"<unused var>");
        if (!(ent instanceof Player)) {
            return Unit.INSTANCE;
        }
        if (((CircuitInhabited)EntityUtil.getData((Entity)((Entity)ent), TBSDataAttachments.CIRCUIT_INHABITED)).getInhabited()) {
            EntityUtil.updateData((Entity)((Entity)ent), TBSDataAttachments.CIRCUIT_INHABITED, CircuitEntityDeathHandler::lambda$1$0);
        }
        return Unit.INSTANCE;
    }

    private static final Unit lambda$1$0(CircuitInhabited dat) {
        Intrinsics.checkNotNullParameter((Object)dat, (String)"dat");
        dat.setInhabited(false);
        return Unit.INSTANCE;
    }

    static {
        AttackEntitySubscriber.INSTANCE.add((Function2<? super Entity, ? super Player, Unit>)((Function2)CircuitEntityDeathHandler::_init_$lambda$0));
        LivingDeathSubscriber.INSTANCE.add((Function2<? super LivingEntity, ? super DamageSource, Unit>)((Function2)CircuitEntityDeathHandler::_init_$lambda$1));
    }
}

