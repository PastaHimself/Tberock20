/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.Holder
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.dsl.SoundUtil
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.behaviors;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.entity.BaseCircuitEntity;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.dsl.SoundUtil;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.entity.circuit.CircuitEntity;
import net.thebrokenscript.entity.circuit.CircuitMineshaftWalkEntity;
import net.thebrokenscript.entity.circuit.CircuitStalkEntity;
import net.thebrokenscript.entity.circuit.CircuitStareEntity;
import net.thebrokenscript.registry.TBSEntities;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/behaviors/CircuitDefaultStareBehavior;", "", "<init>", "()V", "tick", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "pos", "Lnet/minecraft/world/phys/Vec3;", "entity", "Lnet/thebrokenscript/api/entity/BaseCircuitEntity;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "thebrokenscript-common"})
public final class CircuitDefaultStareBehavior {
    @NotNull
    public static final CircuitDefaultStareBehavior INSTANCE = new CircuitDefaultStareBehavior();

    private CircuitDefaultStareBehavior() {
    }

    public final void tick(@NotNull ServerLevel level, @NotNull Vec3 pos, @NotNull BaseCircuitEntity entity, @NotNull ServerPlayer player) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        if (!EntityUtil.isWithin((Entity)((Entity)player), (Vec3)pos, (Number)100) || !PlayerUtil.isLookingAtEntityHitbox((Player)((Player)player), (Entity)((Entity)entity))) {
            return;
        }
        if (!(entity instanceof CircuitMineshaftWalkEntity)) {
            if (entity.hasLineOfSight((Entity)player)) {
                if (level.random.nextBoolean()) {
                    PlayerUtil.trySendOverlay((Player)((Player)player), (ResourceLocation)TBSConstants.id("textures/screens/blick.png"), (long)10L);
                    entity.discard();
                    SoundUtil.playSound$default((LevelAccessor)((LevelAccessor)level), (Vec3)entity.getPos(), (Holder)((Holder)TBSSounds.YOU_KNOW_NOTHING), (float)10.0f, (float)0.0f, null, (int)16, null);
                } else if ((double)level.random.nextFloat() < 0.7) {
                    Entity entity2;
                    EntityType entityType = (EntityType)TBSEntities.CIRCUIT.get();
                    LevelAccessor levelAccessor = (LevelAccessor)level;
                    Vec3 vec3 = entity.position();
                    Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
                    Entity it = entity2 = EntityTypeExt.trySummon((EntityType)entityType, (LevelAccessor)levelAccessor, (Vec3)vec3);
                    boolean bl = false;
                    CircuitStareEntity circuitStareEntity = entity instanceof CircuitStareEntity ? (CircuitStareEntity)entity : null;
                    Boolean stareCrouching = circuitStareEntity != null ? Boolean.valueOf(circuitStareEntity.getCrouch()) : null;
                    CircuitStalkEntity circuitStalkEntity = entity instanceof CircuitStalkEntity ? (CircuitStalkEntity)entity : null;
                    Boolean stalkCrouching = circuitStalkEntity != null ? Boolean.valueOf(circuitStalkEntity.getCrouch()) : null;
                    if (Intrinsics.areEqual((Object)stareCrouching, (Object)true)) {
                        Intrinsics.checkNotNull((Object)it, (String)"null cannot be cast to non-null type net.thebrokenscript.entity.circuit.CircuitEntity");
                        ((CircuitEntity)it).setSpotted(true);
                    } else if (Intrinsics.areEqual((Object)stalkCrouching, (Object)true)) {
                        Intrinsics.checkNotNull((Object)it, (String)"null cannot be cast to non-null type net.thebrokenscript.entity.circuit.CircuitEntity");
                        ((CircuitEntity)it).setSpotted(true);
                    }
                    Player player2 = (Player)player;
                    Holder holder2 = MobEffects.DARKNESS;
                    Intrinsics.checkNotNullExpressionValue((Object)holder2, (String)"DARKNESS");
                    PlayerUtil.effect$default((Player)player2, (Holder)holder2, (int)5, (int)0, (boolean)false, (boolean)false, (int)28, null);
                    entity.discard();
                } else {
                    entity.discard();
                    Player player3 = (Player)player;
                    Holder holder3 = MobEffects.DARKNESS;
                    Intrinsics.checkNotNullExpressionValue((Object)holder3, (String)"DARKNESS");
                    PlayerUtil.effect$default((Player)player3, (Holder)holder3, (int)5, (int)0, (boolean)false, (boolean)false, (int)28, null);
                }
            }
        } else if (EntityUtil.isWithin((Entity)((Entity)player), (Vec3)pos, (Number)20) && entity.hasLineOfSight((Entity)player)) {
            if (level.random.nextBoolean()) {
                PlayerUtil.trySendOverlay((Player)((Player)player), (ResourceLocation)TBSConstants.id("textures/screens/blick.png"), (long)10L);
                entity.discard();
                SoundUtil.playSound$default((LevelAccessor)((LevelAccessor)level), (Vec3)entity.getPos(), (Holder)((Holder)TBSSounds.YOU_KNOW_NOTHING), (float)10.0f, (float)0.0f, null, (int)16, null);
            } else if ((double)level.random.nextFloat() < 0.7) {
                CircuitEntity circuitEntity = (CircuitEntity)EntityUtil.applyRandomRotation((Entity)EntityTypeExt.trySummonTyped((EntityType)((EntityType)TBSEntities.CIRCUIT.get()), (LevelAccessor)((LevelAccessor)level), (Vec3)pos));
                if (circuitEntity != null) {
                    circuitEntity.setSpotted(true);
                }
                Player player4 = (Player)player;
                Holder holder4 = MobEffects.DARKNESS;
                Intrinsics.checkNotNullExpressionValue((Object)holder4, (String)"DARKNESS");
                PlayerUtil.effect$default((Player)player4, (Holder)holder4, (int)5, (int)0, (boolean)false, (boolean)false, (int)28, null);
                entity.discard();
            }
        }
    }
}

