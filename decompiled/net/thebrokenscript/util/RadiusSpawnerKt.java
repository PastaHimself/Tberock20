/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.comparisons.ComparisonsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  net.thebrokenscript.brokencore.api.global.GlobalMathKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.brokencore.api.global.GlobalMathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000>\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aY\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000f\u001ao\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00110\u0001\"\b\b\u0000\u0010\u0011*\u00020\u0012*\b\u0012\u0004\u0012\u0002H\u00110\u00132\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u0014\u001aC\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00110\u0001\"\b\b\u0000\u0010\u0011*\u00020\u0012*\b\u0012\u0004\u0012\u0002H\u00110\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\u0018\u00a8\u0006\u0019"}, d2={"gatherSpawnPositions", "", "Lnet/minecraft/world/phys/Vec3;", "level", "Lnet/minecraft/server/level/ServerLevel;", "centerX", "", "centerZ", "radius", "initAngle", "max", "", "arc", "onFloor", "", "(Lnet/minecraft/server/level/ServerLevel;FFFFLjava/lang/Integer;FZ)Ljava/util/List;", "spawnRadius", "T", "Lnet/minecraft/world/entity/Entity;", "Lnet/minecraft/world/entity/EntityType;", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/server/level/ServerLevel;FFFFLjava/lang/Integer;FZ)Ljava/util/List;", "spawnCircleBehindPlayer", "player", "Lnet/minecraft/server/level/ServerPlayer;", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/server/level/ServerPlayer;FLjava/lang/Integer;)Ljava/util/List;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nRadiusSpawner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RadiusSpawner.kt\nnet/thebrokenscript/util/RadiusSpawnerKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,80:1\n1563#2:81\n1634#2,3:82\n1068#2:85\n1563#2:86\n1634#2,3:87\n1563#2:90\n1634#2,3:91\n1563#2:94\n1634#2,3:95\n*S KotlinDebug\n*F\n+ 1 RadiusSpawner.kt\nnet/thebrokenscript/util/RadiusSpawnerKt\n*L\n42#1:81\n42#1:82,3\n44#1:85\n44#1:86\n44#1:87,3\n52#1:90\n52#1:91,3\n64#1:94\n64#1:95,3\n*E\n"})
public final class RadiusSpawnerKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<Vec3> gatherSpawnPositions(@NotNull ServerLevel level, float centerX, float centerZ, float radius, float initAngle, @Nullable Integer max, float arc, boolean onFloor) {
        Iterable $this$mapTo$iv$iv;
        Collection collection;
        void $this$mapTo$iv$iv2;
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        List list = new ArrayList();
        float circumference = arc * radius;
        float steps = (float)Math.floor(circumference);
        float step = arc / steps;
        int n = (int)steps - 1;
        for (int i = 0; i < n; ++i) {
            float angle = (float)i * step + initAngle;
            float x = radius * Mth.cos((float)angle) + centerX;
            float z = radius * Mth.sin((float)angle) + centerZ;
            int y = level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int)x, (int)z) + 2;
            Vec3 pos = new Vec3((double)x, (double)y, (double)z);
            list.add(pos);
        }
        Iterable $this$map$iv = list;
        boolean $i$f$map = false;
        Iterable z = $this$map$iv;
        Iterable destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv2) {
            void it;
            Vec3 vec3 = (Vec3)item$iv$iv;
            collection = destination$iv$iv;
            boolean bl = false;
            collection.add(it.y);
        }
        double meanY = CollectionsKt.averageOfDouble((Iterable)((List)destination$iv$iv));
        Iterable $this$sortedByDescending$iv = list;
        boolean $i$f$sortedByDescending = false;
        Integer n2 = max;
        Iterable $this$map$iv2 = CollectionsKt.take((Iterable)CollectionsKt.sortedWith((Iterable)$this$sortedByDescending$iv, (Comparator)new Comparator(meanY){
            final /* synthetic */ double $meanY$inlined;
            {
                this.$meanY$inlined = d;
            }

            public final int compare(T a, T b) {
                Vec3 it = (Vec3)b;
                boolean bl = false;
                it = (Vec3)a;
                Comparable comparable = Double.valueOf(Math.pow(this.$meanY$inlined - it.y, 2));
                bl = false;
                return ComparisonsKt.compareValues((Comparable)comparable, (Comparable)Double.valueOf(Math.pow(this.$meanY$inlined - it.y, 2)));
            }
        }), (int)(n2 != null ? n2.intValue() : list.size()));
        boolean $i$f$map2 = false;
        destination$iv$iv = $this$map$iv2;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv2, (int)10));
        boolean $i$f$mapTo2 = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            Vec3 bl = (Vec3)item$iv$iv;
            collection = destination$iv$iv2;
            boolean bl2 = false;
            collection.add(onFloor ? PositionUtil.withY((Vec3)it, (Number)level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int)it.x, (int)it.z)) : it);
        }
        List list2 = (List)destination$iv$iv2;
        $this$map$iv2 = list2;
        $i$f$map2 = false;
        $this$mapTo$iv$iv = $this$map$iv2;
        destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv2, (int)10));
        $i$f$mapTo2 = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            Vec3 it = (Vec3)item$iv$iv;
            collection = destination$iv$iv2;
            boolean bl = false;
            collection.add(it.add(0.0, 5.0, 0.0));
        }
        return (List)destination$iv$iv2;
    }

    public static /* synthetic */ List gatherSpawnPositions$default(ServerLevel serverLevel, float f, float f2, float f3, float f4, Integer n, float f5, boolean bl, int n2, Object object) {
        if ((n2 & 0x20) != 0) {
            n = null;
        }
        if ((n2 & 0x40) != 0) {
            f5 = (float)Math.PI * 2;
        }
        if ((n2 & 0x80) != 0) {
            bl = false;
        }
        return RadiusSpawnerKt.gatherSpawnPositions(serverLevel, f, f2, f3, f4, n, f5, bl);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T extends Entity> List<T> spawnRadius(@NotNull EntityType<T> $this$spawnRadius, @NotNull ServerLevel level, float centerX, float centerZ, float radius, float initAngle, @Nullable Integer max, float arc, boolean onFloor) {
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter($this$spawnRadius, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Iterable $this$map$iv = RadiusSpawnerKt.gatherSpawnPositions(level, centerX, centerZ, radius, initAngle, max, arc, onFloor);
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            Vec3 vec3 = (Vec3)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(EntityTypeExt.trySummonTyped($this$spawnRadius, (LevelAccessor)((LevelAccessor)level), (Vec3)it));
        }
        return (List)destination$iv$iv;
    }

    public static /* synthetic */ List spawnRadius$default(EntityType entityType, ServerLevel serverLevel, float f, float f2, float f3, float f4, Integer n, float f5, boolean bl, int n2, Object object) {
        if ((n2 & 0x20) != 0) {
            n = null;
        }
        if ((n2 & 0x40) != 0) {
            f5 = (float)Math.PI * 2;
        }
        if ((n2 & 0x80) != 0) {
            bl = false;
        }
        return RadiusSpawnerKt.spawnRadius(entityType, serverLevel, f, f2, f3, f4, n, f5, bl);
    }

    @NotNull
    public static final <T extends Entity> List<T> spawnCircleBehindPlayer(@NotNull EntityType<T> $this$spawnCircleBehindPlayer, @NotNull ServerPlayer player, float radius, @Nullable Integer max) {
        Intrinsics.checkNotNullParameter($this$spawnCircleBehindPlayer, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        float centerX = (float)player.getX();
        float centerZ = (float)player.getZ();
        float initAngle = player.getViewYRot(0.0f);
        float fov = (float)Math.PI * 2 - (float)GlobalMathKt.getToRadians((double)PlayerExt.INSTANCE.getVars((Player)player).getFov());
        ServerLevel serverLevel = player.serverLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"serverLevel(...)");
        return RadiusSpawnerKt.spawnRadius$default($this$spawnCircleBehindPlayer, serverLevel, centerX, centerZ, radius, initAngle, max, fov, false, 128, null);
    }

    public static /* synthetic */ List spawnCircleBehindPlayer$default(EntityType entityType, ServerPlayer serverPlayer, float f, Integer n, int n2, Object object) {
        if ((n2 & 4) != 0) {
            n = null;
        }
        return RadiusSpawnerKt.spawnCircleBehindPlayer(entityType, serverPlayer, f, n);
    }
}

