/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$BooleanRef
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.events.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.event.TBSEvent;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.entity.siluet.HeHallucinationEntity;
import net.thebrokenscript.entity.siluet.SiluetHallucinationEntity;
import net.thebrokenscript.registry.TBSEntities;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J6\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\rJ\u0018\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/events/entities/HallucinationEvent;", "Lnet/thebrokenscript/api/event/TBSEvent;", "<init>", "()V", "execute", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "pos", "Lnet/minecraft/world/phys/Vec3;", "findValidSpawnPos", "Lnet/minecraft/core/BlockPos;", "attempts", "", "minYAngle", "", "maxYAngle", "isValidSpawnPosition", "", "findNearbyAirSpace", "thebrokenscript-common"})
public final class HallucinationEvent
extends TBSEvent {
    public HallucinationEvent() {
        super(1);
    }

    protected void execute(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        block5: {
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            Intrinsics.checkNotNullParameter((Object)player, (String)"player");
            Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
            BlockPos blockPos = HallucinationEvent.findValidSpawnPos$default(this, level, player, 0, 0.0, 0.0, 28, null);
            if (blockPos == null && (blockPos = this.findNearbyAirSpace(level, player)) == null) {
                blockPos = player.blockPosition().relative(player.getDirection().getOpposite(), 5);
            }
            BlockPos spawnPos = blockPos;
            Intrinsics.checkNotNull((Object)spawnPos);
            if (!this.isValidSpawnPosition(level, spawnPos)) {
                return;
            }
            EntityType entityType = level.random.nextBoolean() ? (EntityType)TBSEntities.SILUET_HALLUCINATION.get() : (EntityType)TBSEntities.HE_HALLUCINATION.get();
            Entity entity = entityType.create((Level)level);
            Ref.BooleanRef spawnCanceled = new Ref.BooleanRef();
            CancelProxy cancelProxy = new CancelProxy(arg_0 -> HallucinationEvent.execute$lambda$0(spawnCanceled, arg_0), () -> HallucinationEvent.execute$lambda$1(spawnCanceled));
            Entity entity2 = entity;
            if (entity2 == null) break block5;
            Entity it = entity2;
            boolean bl = false;
            if (entity instanceof HeHallucinationEntity) {
                ((HeHallucinationEntity)it).setPlayerUUID(player.getUUID());
            } else {
                ((SiluetHallucinationEntity)it).setPlayerUUID(player.getUUID());
            }
            it.setPos(spawnPos.getCenter().x, spawnPos.getCenter().y, spawnPos.getCenter().z);
            FinalizedSpawn finalizedSpawn = (FinalizedSpawn)it;
            ServerLevelAccessor serverLevelAccessor = (ServerLevelAccessor)level;
            DifficultyInstance difficultyInstance = level.getCurrentDifficultyAt(spawnPos);
            Intrinsics.checkNotNullExpressionValue((Object)difficultyInstance, (String)"getCurrentDifficultyAt(...)");
            finalizedSpawn.onFinalizeSpawn(serverLevelAccessor, difficultyInstance, MobSpawnType.MOB_SUMMONED, null, cancelProxy);
            if (!spawnCanceled.element) {
                level.addFreshEntity(it);
            }
        }
    }

    @Nullable
    public final BlockPos findValidSpawnPos(@NotNull ServerLevel level, @NotNull ServerPlayer player, int attempts, double minYAngle, double maxYAngle) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        for (int i = 0; i < attempts; ++i) {
            int it = i;
            boolean bl = false;
            double angle = (level.random.nextDouble() - 0.5) * (double)((float)Math.PI);
            double radius = level.random.nextDouble() * 10.0;
            double behindDistance = player.getRandom().nextInt(5, 11);
            Vec3 lookAngle = player.getLookAngle();
            double yAngle = Math.toDegrees(Math.asin(-lookAngle.y));
            Vec3 behindDir = (minYAngle <= yAngle ? yAngle <= maxYAngle : false) ? new Vec3(-lookAngle.x, 0.0, -lookAngle.z).normalize() : new Vec3(-lookAngle.x, 0.0, -lookAngle.z).normalize();
            Vec3 sideDir = new Vec3(-behindDir.z, 0.0, behindDir.x);
            Vec3 offsetDir = behindDir.add(sideDir.scale(Math.sin(angle))).normalize();
            double totalDistance = behindDistance + radius;
            int x = (int)(player.getX() + offsetDir.x * totalDistance);
            int z = (int)(player.getZ() + offsetDir.z * totalDistance);
            for (int yOffset = -1; yOffset < 4; ++yOffset) {
                int y = player.blockPosition().getY() + yOffset;
                BlockPos pos = new BlockPos(x, y, z);
                if (!this.isValidSpawnPosition(level, pos)) continue;
                return pos;
            }
        }
        return null;
    }

    public static /* synthetic */ BlockPos findValidSpawnPos$default(HallucinationEvent hallucinationEvent, ServerLevel serverLevel, ServerPlayer serverPlayer, int n, double d, double d2, int n2, Object object) {
        if ((n2 & 4) != 0) {
            n = 20;
        }
        if ((n2 & 8) != 0) {
            d = -60.0;
        }
        if ((n2 & 0x10) != 0) {
            d2 = 60.0;
        }
        return hallucinationEvent.findValidSpawnPos(serverLevel, serverPlayer, n, d, d2);
    }

    public final boolean isValidSpawnPosition(@NotNull ServerLevel level, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        BlockState ground = level.getBlockState(pos.below());
        BlockState feet = level.getBlockState(pos);
        BlockState head = level.getBlockState(pos.above());
        return !ground.isAir() && feet.isAir() && head.isAir() && !Intrinsics.areEqual((Object)feet.getBlock(), (Object)Blocks.WATER) && !Intrinsics.areEqual((Object)feet.getBlock(), (Object)Blocks.LAVA) && !Intrinsics.areEqual((Object)head.getBlock(), (Object)Blocks.WATER) && !Intrinsics.areEqual((Object)head.getBlock(), (Object)Blocks.LAVA);
    }

    @Nullable
    public final BlockPos findNearbyAirSpace(@NotNull ServerLevel level, @NotNull ServerPlayer player) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        BlockPos playerPos = player.blockPosition();
        List validPositions = new ArrayList();
        Vec3 lookAngle = player.getLookAngle();
        Vec3 behindDirection = new Vec3(-lookAngle.x, 0.0, -lookAngle.z).normalize();
        for (int x = -8; x < 9; ++x) {
            for (int z = -8; z < 9; ++z) {
                for (int y = -1; y < 4; ++y) {
                    if (x == 0 && z == 0) continue;
                    BlockPos pos = playerPos.offset(x, y, z);
                    Vec3 offsetVec = new Vec3((double)x, 0.0, (double)z).normalize();
                    if (!(offsetVec.dot(behindDirection) > 0.3)) continue;
                    Intrinsics.checkNotNull((Object)pos);
                    if (!this.isValidSpawnPosition(level, pos)) continue;
                    validPositions.add(pos);
                }
            }
        }
        return !((Collection)validPositions).isEmpty() ? (BlockPos)validPositions.get(level.random.nextInt(validPositions.size())) : null;
    }

    private static final Unit execute$lambda$0(Ref.BooleanRef $spawnCanceled, boolean it) {
        $spawnCanceled.element = it;
        return Unit.INSTANCE;
    }

    private static final boolean execute$lambda$1(Ref.BooleanRef $spawnCanceled) {
        return $spawnCanceled.element;
    }
}

