/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.commands.arguments.EntityAnchorArgument$Anchor
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  net.thebrokenscript.brokencore.api.world.TimeOfDay
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.entity.siluet;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.brokencore.api.world.TimeOfDay;
import net.thebrokenscript.entity.siluet.SiluetEntity;
import net.thebrokenscript.registry.TBSEntities;
import net.thebrokenscript.registry.TBSParticleTypes;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/entity/siluet/SiluetStareEntity;", "Lnet/thebrokenscript/entity/siluet/SiluetEntity;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "baseTick", "", "thebrokenscript-common"})
public final class SiluetStareEntity
extends SiluetEntity {
    public SiluetStareEntity(@NotNull EntityType<SiluetStareEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super((EntityType<? extends SiluetEntity>)type, level);
        this.xpReward = 0;
        this.setNoAi(false);
        this.setPersistenceRequired();
        this.setPathfindingMalus(PathType.LAVA, 0.0f);
        this.setPathfindingMalus(PathType.FENCE, 0.0f);
        this.setPathfindingMalus(PathType.RAIL, 0.0f);
        this.setPathfindingMalus(PathType.WATER, 0.0f);
        this.setPathfindingMalus(PathType.WATER_BORDER, 0.0f);
    }

    @Override
    public void baseTick() {
        super.baseTick();
        Level level = this.level();
        if (!(level instanceof ServerLevel)) {
            return;
        }
        ServerPlayer player = EntityFinder.findClosestPlayerInRange((ServerLevel)((ServerLevel)level), (Vec3)this.getPos(), (Number)620.0);
        if (player != null) {
            this.lookAt(EntityAnchorArgument.Anchor.EYES, player.position());
            if (this.isWithin((Entity)player, 10)) {
                if (((ServerLevel)level).random.nextBoolean()) {
                    this.discard();
                    player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 35, 1, false, false));
                    List players = EntityFinder.findPlayersInRange((ServerLevel)((ServerLevel)level), (Vec3)this.getPos(), (Number)25);
                    for (ServerPlayer player2 : players) {
                        PlayerExt.tryPlaySound$default(PlayerExt.INSTANCE, (Player)player2, (SoundEvent)TBSSounds.NULL_IS_HERE_LOOP.get(), false, 0.0f, 0.0f, 0.0f, 22, null);
                    }
                    if ((double)((ServerLevel)level).random.nextFloat() < 0.7) {
                        TimeOfDay.MIDNIGHT.setFake();
                    }
                } else {
                    this.discard();
                    EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.SILUET_CHASE.get()), (LevelAccessor)((LevelAccessor)level), (Vec3)this.getPos());
                }
            }
            if (this.isWithin((Entity)player, 45.0) && PlayerUtil.isLookingAtEntityHitbox((Player)((Player)player), (Entity)((Entity)this))) {
                this.discard();
                player.lookAt(EntityAnchorArgument.Anchor.EYES, this.getPos().add(0.0, 1.0, 0.0));
                if (this.random.nextBoolean()) {
                    if (this.getOnSurface()) {
                        EntityType entityType = EntityType.LIGHTNING_BOLT;
                        Intrinsics.checkNotNullExpressionValue((Object)entityType, (String)"LIGHTNING_BOLT");
                        LevelAccessor levelAccessor = (LevelAccessor)level;
                        Vec3 vec3 = player.position();
                        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
                        EntityTypeExt.trySummon((EntityType)entityType, (LevelAccessor)levelAccessor, (Vec3)vec3);
                    }
                    EntityUtil.applyRandomRotation((Entity)EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.SILUET_CHASE.get()), (LevelAccessor)((LevelAccessor)level), (Vec3)this.getPos()));
                } else {
                    PlayerUtil.sendSound$default((ServerPlayer)player, (SoundEvent)((SoundEvent)TBSSounds.TEXT_MADNESS_1.get()), (float)10.0f, (float)0.0f, null, null, (long)0L, (int)60, null);
                    PlayerUtil.trySendOverlay((Player)((Player)player), (ResourceLocation)TBSConstants.id("textures/screens/cantyousee.png"), (long)10L);
                }
            }
        }
        if (((ServerLevel)level).isDay()) {
            this.discard();
            ((ServerLevel)level).sendParticles((ParticleOptions)TBSParticleTypes.NULL_PARTICLE.get(), this.getX(), this.getY(), this.getZ(), 50, 3.0, 3.0, 3.0, 0.0);
        }
        this.refreshDimensions();
    }
}

