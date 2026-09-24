/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.commands.arguments.EntityAnchorArgument$Anchor
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  net.thebrokenscript.brokencore.api.dsl.SoundUtil
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.behaviors;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.entity.BaseCircuitEntity;
import net.thebrokenscript.behaviors.CircuitDefaultStareBehavior;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.brokencore.api.dsl.SoundUtil;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.entity.circuit.CircuitEntity;
import net.thebrokenscript.entity.circuit.CircuitMineshaftStareEntity;
import net.thebrokenscript.entity.circuit.CircuitMineshaftWalkEntity;
import net.thebrokenscript.entity.players.CurvedEntity;
import net.thebrokenscript.registry.TBSEntities;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/behaviors/CircuitMineshaftStalkBehaviour;", "", "<init>", "()V", "tick", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "pos", "Lnet/minecraft/world/phys/Vec3;", "entity", "Lnet/thebrokenscript/api/entity/BaseCircuitEntity;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nCircuitMineshaftStalkBehaviour.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CircuitMineshaftStalkBehaviour.kt\nnet/thebrokenscript/behaviors/CircuitMineshaftStalkBehaviour\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,60:1\n1#2:61\n*E\n"})
public final class CircuitMineshaftStalkBehaviour {
    @NotNull
    public static final CircuitMineshaftStalkBehaviour INSTANCE = new CircuitMineshaftStalkBehaviour();

    private CircuitMineshaftStalkBehaviour() {
    }

    public final void tick(@NotNull ServerLevel level, @NotNull Vec3 pos, @NotNull BaseCircuitEntity entity) {
        block9: {
            Class[] classArray;
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
            if (entity instanceof CircuitMineshaftStareEntity) {
                Vec3 vec3 = player.position();
                Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
                entity.lookAt(EntityAnchorArgument.Anchor.EYES, PositionUtil.above$default((Vec3)vec3, null, (int)1, null));
                Entity entity2 = (Entity)player;
                Vec3 vec32 = entity.position();
                Intrinsics.checkNotNullExpressionValue((Object)vec32, (String)"position(...)");
                if (EntityUtil.isWithin((Entity)entity2, (Vec3)vec32, (Number)8)) {
                    if (level.random.nextBoolean()) {
                        player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 10, 2, false, false));
                        SoundUtil.tryPlaySound$default((Level)((Level)level), (Vec3)pos, (SoundEvent)((SoundEvent)TBSSounds.YOU_KNOW_NOTHING.get()), (float)10.0f, (float)0.0f, null, (int)16, null);
                    } else {
                        EntityType entityType = (EntityType)TBSEntities.CIRCUIT.get();
                        LevelAccessor levelAccessor = (LevelAccessor)level;
                        Vec3 vec33 = entity.position();
                        Intrinsics.checkNotNullExpressionValue((Object)vec33, (String)"position(...)");
                        Class[] it = classArray = EntityTypeExt.trySummon((EntityType)entityType, (LevelAccessor)levelAccessor, (Vec3)vec33);
                        boolean bl = false;
                        Intrinsics.checkNotNull((Object)it, (String)"null cannot be cast to non-null type net.thebrokenscript.entity.circuit.CircuitEntity");
                        ((CircuitEntity)it).setSpotted(true);
                    }
                    entity.discard();
                }
                if (PlayerUtil.isLookingAtEntityHitbox((Player)((Player)player), (Entity)((Entity)entity))) {
                    PlayerUtil.trySendOverlay((Player)((Player)player), (ResourceLocation)TBSConstants.id("textures/screens/blick.png"), (long)10L);
                    entity.discard();
                    SoundUtil.playSound$default((LevelAccessor)((LevelAccessor)level), (Vec3)entity.getPos(), (SoundEvent)((SoundEvent)TBSSounds.YOU_KNOW_NOTHING.get()), (float)10.0f, (float)0.0f, null, (int)16, null);
                }
            }
            if (!(entity instanceof CircuitMineshaftWalkEntity)) break block9;
            entity.lookAt(EntityAnchorArgument.Anchor.EYES, player.position());
            if (PlayerUtil.isLookingAtEntityHitbox((Player)((Player)player), (Entity)((Entity)entity))) {
                classArray = new Class[]{CircuitEntity.class, CurvedEntity.class};
                if (!EntityFinder.hasEntitiesInRangeExcluding((LevelAccessor)((LevelAccessor)level), (Entity)((Entity)entity), (Vec3)pos, (Number)20, (Class[])classArray)) {
                    entity.discard();
                    Entity entity3 = EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.CIRCUIT_MINESHAFT_FLEE.get()), (LevelAccessor)((LevelAccessor)level), (Vec3)pos);
                    if (entity3 != null) {
                        Entity entity4;
                        Entity $this$tick_u24lambda_u241 = entity4 = entity3;
                        boolean bl = false;
                        $this$tick_u24lambda_u241.copyPosition((Entity)entity);
                    }
                }
            }
        }
    }
}

