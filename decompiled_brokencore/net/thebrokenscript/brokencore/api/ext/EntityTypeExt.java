/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Position
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.ext;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00060\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J,\u0010\r\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00060\b2\u0006\u0010\t\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0007J,\u0010\u0004\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00060\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000fH\u0007J,\u0010\r\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00060\b2\u0006\u0010\t\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u000fH\u0007J3\u0010\u0010\u001a\u0004\u0018\u0001H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00060\b2\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0007\u00a2\u0006\u0002\u0010\u0012J3\u0010\u0010\u001a\u0004\u0018\u0001H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00060\b2\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u000fH\u0007\u00a2\u0006\u0002\u0010\u0013J\"\u0010\u0014\u001a\u0004\u0018\u00010\u0007*\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0007J\"\u0010\u0014\u001a\u0004\u0018\u00010\u0007*\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u000fH\u0007\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/brokencore/api/ext/EntityTypeExt;", "", "<init>", "()V", "trySpawnOneThousand", "", "T", "Lnet/minecraft/world/entity/Entity;", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "pos", "Lnet/minecraft/world/phys/Vec3;", "spawnOneThousand", "Lnet/minecraft/server/level/ServerLevel;", "Lnet/minecraft/core/BlockPos;", "trySummonTyped", "Lnet/minecraft/world/level/LevelAccessor;", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/entity/Entity;", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/entity/Entity;", "trySummon", "brokencore-common"})
public final class EntityTypeExt {
    @NotNull
    public static final EntityTypeExt INSTANCE = new EntityTypeExt();

    private EntityTypeExt() {
    }

    @JvmStatic
    public static final <T extends Entity> void trySpawnOneThousand(@NotNull EntityType<T> $this$trySpawnOneThousand, @NotNull Level level, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter($this$trySpawnOneThousand, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        BlockPos blockPos = BlockPos.containing((Position)((Position)pos));
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"containing(...)");
        EntityTypeExt.trySpawnOneThousand($this$trySpawnOneThousand, level, blockPos);
    }

    @JvmStatic
    public static final <T extends Entity> void spawnOneThousand(@NotNull EntityType<T> $this$spawnOneThousand, @NotNull ServerLevel level, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter($this$spawnOneThousand, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        BlockPos blockPos = BlockPos.containing((Position)((Position)pos));
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"containing(...)");
        EntityTypeExt.spawnOneThousand($this$spawnOneThousand, level, blockPos);
    }

    @JvmStatic
    public static final <T extends Entity> void trySpawnOneThousand(@NotNull EntityType<T> $this$trySpawnOneThousand, @NotNull Level level, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter($this$trySpawnOneThousand, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        if (level instanceof ServerLevel) {
            EntityTypeExt.spawnOneThousand($this$trySpawnOneThousand, (ServerLevel)level, pos);
        }
    }

    @JvmStatic
    public static final <T extends Entity> void spawnOneThousand(@NotNull EntityType<T> $this$spawnOneThousand, @NotNull ServerLevel level, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter($this$spawnOneThousand, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        int n = 1000;
        int n2 = 0;
        while (n2 < n) {
            int it = n2++;
            boolean bl = false;
            EntityUtil.applyRandomRotation(EntityTypeExt.trySummon($this$spawnOneThousand, (LevelAccessor)level, pos));
        }
    }

    @JvmStatic
    @Nullable
    public static final <T extends Entity> T trySummonTyped(@NotNull EntityType<T> $this$trySummonTyped, @NotNull LevelAccessor level, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter($this$trySummonTyped, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        BlockPos blockPos = BlockPos.containing((Position)((Position)pos));
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"containing(...)");
        return EntityTypeExt.trySummonTyped($this$trySummonTyped, level, blockPos);
    }

    @JvmStatic
    @Nullable
    public static final <T extends Entity> T trySummonTyped(@NotNull EntityType<T> $this$trySummonTyped, @NotNull LevelAccessor level, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter($this$trySummonTyped, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return (T)(level instanceof ServerLevel ? $this$trySummonTyped.spawn((ServerLevel)level, pos, MobSpawnType.MOB_SUMMONED) : null);
    }

    @JvmStatic
    @Nullable
    public static final Entity trySummon(@NotNull EntityType<?> $this$trySummon, @NotNull LevelAccessor level, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter($this$trySummon, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        BlockPos blockPos = BlockPos.containing((Position)((Position)pos));
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"containing(...)");
        return EntityTypeExt.trySummon($this$trySummon, level, blockPos);
    }

    @JvmStatic
    @Nullable
    public static final Entity trySummon(@NotNull EntityType<?> $this$trySummon, @NotNull LevelAccessor level, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter($this$trySummon, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return level instanceof ServerLevel ? $this$trySummon.spawn((ServerLevel)level, pos, MobSpawnType.MOB_SUMMONED) : null;
    }
}

