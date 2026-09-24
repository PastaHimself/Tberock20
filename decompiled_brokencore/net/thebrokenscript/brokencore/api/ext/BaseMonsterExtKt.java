/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.IntRange
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LightLayer
 *  net.minecraft.world.level.biome.Biomes
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.ext;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.impl.registry.BCTags;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000:\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001c\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u000b\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\r\u001a\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u00a8\u0006\u0014"}, d2={"hasLineOfSightThroughTransparent", "", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster;", "target", "Lnet/minecraft/world/entity/player/Player;", "isPlayerInFovCone", "player", "fovDegrees", "", "shouldCrouch", "range", "Lkotlin/ranges/IntRange;", "isInCave", "Lnet/minecraft/world/entity/LivingEntity;", "checkAirSpace", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "center", "Lnet/minecraft/core/BlockPos;", "brokencore-common"})
public final class BaseMonsterExtKt {
    public static final boolean hasLineOfSightThroughTransparent(@NotNull BaseMonster $this$hasLineOfSightThroughTransparent, @NotNull Player target) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$hasLineOfSightThroughTransparent), (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        Level level = $this$hasLineOfSightThroughTransparent.level();
        if (level == null) {
            return false;
        }
        Level level2 = level;
        Vec3 start = $this$hasLineOfSightThroughTransparent.getEyePosition();
        Vec3 end = target.getEyePosition();
        Vec3 dir = end.subtract(start);
        double distance = dir.length();
        int steps = (int)(distance * (double)10);
        if (steps == 0) {
            return true;
        }
        Vec3 stepVec = dir.scale(1.0 / (double)steps);
        Vec3 current = null;
        current = start;
        for (int i = 0; i < steps; ++i) {
            int it = i;
            boolean bl = false;
            BlockPos pos = BlockPos.containing((double)current.x, (double)current.y, (double)current.z);
            BlockState state = level2.getBlockState(pos);
            if (!state.isAir()) {
                boolean hasCollision = !state.getCollisionShape((BlockGetter)level2, pos).isEmpty();
                boolean isTransparent = state.is(BCTags.TRANSPARENT);
                if (hasCollision && !isTransparent) {
                    return false;
                }
            }
            current = current.add(stepVec);
        }
        return true;
    }

    public static final boolean isPlayerInFovCone(@NotNull BaseMonster $this$isPlayerInFovCone, @NotNull Player player, double fovDegrees) {
        double threshold;
        Intrinsics.checkNotNullParameter((Object)((Object)$this$isPlayerInFovCone), (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        if (!Intrinsics.areEqual((Object)$this$isPlayerInFovCone.level().dimension(), (Object)player.level().dimension())) {
            return false;
        }
        Vec3 eyePos = $this$isPlayerInFovCone.getEyePosition();
        Vec3 toEntity = player.position().subtract(eyePos).normalize();
        Vec3 lookVec = $this$isPlayerInFovCone.getViewVector(1.0f).normalize();
        double dot = lookVec.dot(toEntity);
        return dot >= (threshold = Math.cos(Math.toRadians(fovDegrees / 2.0)));
    }

    public static /* synthetic */ boolean isPlayerInFovCone$default(BaseMonster baseMonster, Player player, double d, int n, Object object) {
        if ((n & 2) != 0) {
            d = 70.0;
        }
        return BaseMonsterExtKt.isPlayerInFovCone(baseMonster, player, d);
    }

    public static final boolean shouldCrouch(@NotNull BaseMonster $this$shouldCrouch, @NotNull IntRange range) {
        int startY;
        Intrinsics.checkNotNullParameter((Object)((Object)$this$shouldCrouch), (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)range, (String)"range");
        Level level = $this$shouldCrouch.level();
        BlockPos pos = $this$shouldCrouch.blockPosition();
        int n = startY + range.getLast();
        for (int y = startY = (int)($this$shouldCrouch.getBoundingBox().maxY + 0.1); y < n; ++y) {
            boolean hasCollision;
            BlockPos checkPos = new BlockPos(pos.getX(), y, pos.getZ());
            BlockState state = level.getBlockState(checkPos);
            boolean bl = hasCollision = !state.getCollisionShape((BlockGetter)$this$shouldCrouch.level(), checkPos).isEmpty();
            if (state.isAir() || !hasCollision) continue;
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean shouldCrouch$default(BaseMonster baseMonster, IntRange intRange, int n, Object object) {
        if ((n & 1) != 0) {
            intRange = new IntRange(1, 6);
        }
        return BaseMonsterExtKt.shouldCrouch(baseMonster, intRange);
    }

    public static final boolean isInCave(@NotNull LivingEntity $this$isInCave) {
        boolean isInCaveBiome;
        Intrinsics.checkNotNullParameter((Object)$this$isInCave, (String)"<this>");
        if (!($this$isInCave.level() instanceof ServerLevel)) {
            return false;
        }
        Level level = $this$isInCave.level();
        Intrinsics.checkNotNull((Object)level, (String)"null cannot be cast to non-null type net.minecraft.server.level.ServerLevel");
        ServerLevel level2 = (ServerLevel)level;
        BlockPos playerPos = $this$isInCave.blockPosition();
        Holder biome = level2.getBiome(playerPos);
        boolean bl = isInCaveBiome = biome.is(Biomes.LUSH_CAVES) || biome.is(Biomes.DRIPSTONE_CAVES) || biome.is(Biomes.DEEP_DARK);
        if (isInCaveBiome) {
            return true;
        }
        if (level2.canSeeSky(playerPos)) {
            return false;
        }
        int skyLight = level2.getBrightness(LightLayer.SKY, playerPos);
        if (skyLight > 0) {
            return false;
        }
        int surfaceY = level2.getHeight(Heightmap.Types.WORLD_SURFACE, playerPos.getX(), playerPos.getZ());
        int depthBelowSurface = surfaceY - playerPos.getY();
        if (depthBelowSurface < 5) {
            return false;
        }
        Intrinsics.checkNotNull((Object)playerPos);
        int airSpaceScore = BaseMonsterExtKt.checkAirSpace(level2, playerPos);
        return airSpaceScore >= 5;
    }

    private static final int checkAirSpace(ServerLevel level, BlockPos center) {
        int airBlocks = 0;
        int radius = 3;
        int x = -radius;
        if (x <= radius) {
            while (true) {
                block1: for (int y = -1; y < 3; ++y) {
                    int z = -radius;
                    if (z > radius) continue;
                    while (true) {
                        BlockPos checkPos;
                        BlockState state;
                        if ((state = level.getBlockState(checkPos = center.offset(x, y, z))).isAir()) {
                            ++airBlocks;
                        }
                        if (z == radius) continue block1;
                        ++z;
                    }
                }
                if (x == radius) break;
                ++x;
            }
        }
        return airBlocks;
    }
}

