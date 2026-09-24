/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.Holder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.dsl.SoundUtil
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  net.thebrokenscript.brokencore.api.world.TimeOfDay
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.behaviors;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.entity.BaseCircuitEntity;
import net.thebrokenscript.behaviors.CircuitDefaultStareBehavior;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.dsl.SoundUtil;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.brokencore.api.world.TimeOfDay;
import net.thebrokenscript.entity.circuit.CircuitEntity;
import net.thebrokenscript.entity.circuit.CircuitStalkEntity;
import net.thebrokenscript.registry.TBSEntities;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/behaviors/CircuitStalkBehavior;", "", "<init>", "()V", "tick", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "pos", "Lnet/minecraft/world/phys/Vec3;", "entity", "Lnet/thebrokenscript/api/entity/BaseCircuitEntity;", "thebrokenscript-common"})
public final class CircuitStalkBehavior {
    @NotNull
    public static final CircuitStalkBehavior INSTANCE = new CircuitStalkBehavior();

    private CircuitStalkBehavior() {
    }

    public final void tick(@NotNull ServerLevel level, @NotNull Vec3 pos, @NotNull BaseCircuitEntity entity) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        ServerPlayer serverPlayer = EntityFinder.findClosestPlayerInRange((ServerLevel)level, (Vec3)pos, (Number)256);
        if (serverPlayer == null) {
            return;
        }
        ServerPlayer player = serverPlayer;
        entity.setTarget((LivingEntity)player);
        CircuitDefaultStareBehavior.INSTANCE.tick(level, pos, entity, player);
        if (entity instanceof CircuitStalkEntity) {
            Entity entity2 = (Entity)player;
            Vec3 vec3 = entity.position();
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
            if (EntityUtil.isWithin((Entity)entity2, (Vec3)vec3, (Number)8) && entity.hasLineOfSight((Entity)player) && level.random.nextBoolean()) {
                Player player2 = (Player)player;
                Holder holder2 = MobEffects.BLINDNESS;
                Intrinsics.checkNotNullExpressionValue((Object)holder2, (String)"BLINDNESS");
                PlayerUtil.effect$default((Player)player2, (Holder)holder2, (int)5, (int)0, (boolean)false, (boolean)false, (int)28, null);
                SoundUtil.playSound$default((LevelAccessor)((LevelAccessor)level), (Vec3)pos, (Holder)((Holder)TBSSounds.INTEGRITY_WATCHING), (float)10.0f, (float)0.0f, null, (int)16, null);
                if ((double)level.random.nextFloat() < 0.7) {
                    TimeOfDay.MIDNIGHT.setFake();
                } else {
                    Entity entity3;
                    EntityType entityType = (EntityType)TBSEntities.CIRCUIT.get();
                    LevelAccessor levelAccessor = (LevelAccessor)level;
                    Vec3 vec32 = entity.position();
                    Intrinsics.checkNotNullExpressionValue((Object)vec32, (String)"position(...)");
                    Entity it = entity3 = EntityTypeExt.trySummon((EntityType)entityType, (LevelAccessor)levelAccessor, (Vec3)vec32);
                    boolean bl = false;
                    if (((CircuitStalkEntity)entity).getCrouch()) {
                        Intrinsics.checkNotNull((Object)it, (String)"null cannot be cast to non-null type net.thebrokenscript.entity.circuit.CircuitEntity");
                        ((CircuitEntity)it).setSpotted(true);
                    }
                }
                entity.discard();
            }
        }
    }
}

