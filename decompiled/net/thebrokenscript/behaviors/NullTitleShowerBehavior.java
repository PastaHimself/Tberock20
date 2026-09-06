/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.random.Random
 *  net.minecraft.client.resources.sounds.SoundInstance
 *  net.minecraft.client.sounds.SoundManager
 *  net.minecraft.commands.arguments.EntityAnchorArgument$Anchor
 *  net.minecraft.core.BlockPos
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.game.ClientboundSetTitleTextPacket
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.ClipContext
 *  net.minecraft.world.level.ClipContext$Block
 *  net.minecraft.world.level.ClipContext$Fluid
 *  net.minecraft.world.level.GameType
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.HitResult$Type
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.PacketUtil
 *  net.thebrokenscript.brokencore.api.dsl.SideUtil
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.sound.FancySoundInstance
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.behaviors;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundSetTitleTextPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.PacketUtil;
import net.thebrokenscript.brokencore.api.dsl.SideUtil;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.sound.FancySoundInstance;
import net.thebrokenscript.registry.TBSLang;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/behaviors/NullTitleShowerBehavior;", "", "<init>", "()V", "activeSoundInstance", "Lnet/thebrokenscript/brokencore/api/sound/FancySoundInstance;", "stopSound", "", "tick", "level", "Lnet/minecraft/world/level/Level;", "entity", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nNullTitleShowerBehavior.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NullTitleShowerBehavior.kt\nnet/thebrokenscript/behaviors/NullTitleShowerBehavior\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,137:1\n1#2:138\n*E\n"})
public final class NullTitleShowerBehavior {
    @NotNull
    public static final NullTitleShowerBehavior INSTANCE = new NullTitleShowerBehavior();
    @Nullable
    private static FancySoundInstance activeSoundInstance;

    private NullTitleShowerBehavior() {
    }

    public final void stopSound() {
        FancySoundInstance fancySoundInstance = activeSoundInstance;
        if (fancySoundInstance != null) {
            FancySoundInstance it = fancySoundInstance;
            boolean bl = false;
            ClientDSLKt.getMC().getSoundManager().stop((SoundInstance)it);
        }
        activeSoundInstance = null;
    }

    public final void tick(@NotNull Level level, @NotNull BaseMonster entity) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Player player = EntityFinder.findClosestPlayerInRange((LevelAccessor)((LevelAccessor)level), (Vec3)entity.getPos(), (Number)128.0);
        SideUtil.serverSide((Entity)((Entity)entity), () -> NullTitleShowerBehavior.tick$lambda$0(player, entity, level));
        SideUtil.clientSide((Entity)((Entity)entity), () -> NullTitleShowerBehavior.tick$lambda$1(level, entity));
    }

    private static final Unit tick$lambda$0(Player $player, BaseMonster $entity, Level $level) {
        if ($player != null && $player instanceof ServerPlayer) {
            $entity.setTarget((LivingEntity)$player);
            $entity.lookAt(EntityAnchorArgument.Anchor.EYES, ((ServerPlayer)$player).position().add(0.0, 1.0, 0.0));
            if ($level.getBlockState($entity.getBlockPos()).canOcclude()) {
                Entity entity = (Entity)$entity;
                BlockPos blockPos = $entity.getBlockPos().above();
                Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"above(...)");
                EntityUtil.teleport((Entity)entity, (BlockPos)blockPos);
            }
            if (((ServerPlayer)$player).gameMode.isCreative()) {
                ((ServerPlayer)$player).setGameMode(GameType.SURVIVAL);
            }
            int timer = EntityUtil.getPersistentData((Entity)((Entity)$entity)).getInt("timer") + 1;
            EntityUtil.getPersistentData((Entity)((Entity)$entity)).putInt("timer", timer);
            if (timer >= 5) {
                EntityUtil.getPersistentData((Entity)((Entity)$entity)).putInt("timer", 0);
                Vec3 dirToPlayer = ((ServerPlayer)$player).position().subtract($entity.position()).normalize();
                double approachSpeed = 1.5;
                Vec3 approachVector = dirToPlayer.scale(approachSpeed);
                double finalX = 0.0;
                finalX = $entity.getX();
                double finalY = 0.0;
                finalY = $entity.getY();
                double finalZ = 0.0;
                finalZ = $entity.getZ();
                boolean foundValidPos = false;
                double distSqToPlayer = $entity.distanceToSqr((Entity)$player);
                NullTitleShowerBehavior $this$tick_u24lambda_u240_u240 = INSTANCE;
                boolean bl = false;
                int n = 5;
                for (int i = 0; i < n; ++i) {
                    Vec3 endVec;
                    Vec3 startVec;
                    BlockHitResult rayCast;
                    double testZ;
                    double testY;
                    int it = i;
                    boolean bl2 = false;
                    double randomX = ($level.random.nextDouble() - 0.5) * 6.0;
                    double randomZ = ($level.random.nextDouble() - 0.5) * 6.0;
                    double randomY = ($level.random.nextDouble() - 0.5) * 1.5;
                    double testX = $entity.getX() + approachVector.x + randomX;
                    double testDistSq = ((ServerPlayer)$player).distanceToSqr(testX, testY = $entity.getY() + approachVector.y + randomY, testZ = $entity.getZ() + approachVector.z + randomZ);
                    if (testDistSq >= distSqToPlayer || (rayCast = $level.clip(new ClipContext(startVec = $entity.getEyePosition(1.0f), endVec = new Vec3(testX, testY + (double)$entity.getBbHeight() / 2.0, testZ), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (Entity)$entity))).getType() != HitResult.Type.MISS) continue;
                    finalX = testX;
                    finalY = testY;
                    finalZ = testZ;
                    foundValidPos = true;
                    break;
                }
                if (foundValidPos) {
                    $entity.moveTo(finalX, finalY, finalZ, $entity.getYRot(), $entity.getXRot());
                    $entity.setDeltaMovement(Vec3.ZERO);
                    if ($level instanceof ServerLevel) {
                        ((ServerLevel)$level).getChunkSource().removeEntity((Entity)$entity);
                        ((ServerLevel)$level).getChunkSource().addEntity((Entity)$entity);
                    }
                }
            }
            if (((ServerPlayer)$player).distanceToSqr((Entity)$entity) < 5.5) {
                $entity.doHurtTarget((Entity)$player);
            }
            if ($level.random.nextFloat() < 0.25f) {
                PacketUtil.tryBroadcastPacketInRange((LevelAccessor)((LevelAccessor)$level), (Vec3)$entity.getPos(), (Number)50, (Packet)((Packet)new ClientboundSetTitleTextPacket((Component)CollectionsKt.random((Collection)TBSLang.INSTANCE.getNULL_TITLES(), (Random)((Random)Random.Default)))));
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit tick$lambda$1(Level $level, BaseMonster $entity) {
        block6: {
            Player playerInRange;
            SoundManager soundManager;
            block5: {
                soundManager = ClientDSLKt.getMC().getSoundManager();
                if (activeSoundInstance == null) break block5;
                FancySoundInstance fancySoundInstance = activeSoundInstance;
                Intrinsics.checkNotNull((Object)fancySoundInstance);
                if (soundManager.isActive((SoundInstance)fancySoundInstance)) break block6;
            }
            if ((playerInRange = EntityFinder.findClosestPlayerInRange((LevelAccessor)((LevelAccessor)$level), (Vec3)$entity.getPos(), (Number)50.0)) != null) {
                if (activeSoundInstance == null) {
                    SoundEvent soundEvent = (SoundEvent)TBSSounds.NULL_IS_HERE_LOOP.get();
                    RandomSource randomSource = $level.random;
                    Intrinsics.checkNotNullExpressionValue((Object)randomSource, (String)"random");
                    activeSoundInstance = new FancySoundInstance(soundEvent, SoundSource.HOSTILE, 1.85f, 0.5f, true, randomSource);
                }
                FancySoundInstance fancySoundInstance = activeSoundInstance;
                Intrinsics.checkNotNull((Object)fancySoundInstance);
                soundManager.play((SoundInstance)fancySoundInstance);
            }
        }
        return Unit.INSTANCE;
    }
}

