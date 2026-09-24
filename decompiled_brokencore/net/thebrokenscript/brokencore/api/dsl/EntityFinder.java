/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$BooleanRef
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.util.AbortableIterationConsumer
 *  net.minecraft.util.AbortableIterationConsumer$Continuation
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntitySelector
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.entity.EntityTypeTest
 *  net.minecraft.world.level.entity.LevelEntityGetterAdapter
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.dsl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.AbortableIterationConsumer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.level.entity.LevelEntityGetterAdapter;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.entity.MultiTypeTest;
import net.thebrokenscript.brokencore.api.mixinterfaces.ServerLevelExt;
import net.thebrokenscript.brokencore.api.util.math.Boxes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\u001a9\u0010\u0006\u001a\u0004\u0018\u0001H\u0007\"\b\b\u0000\u0010\u0007*\u00020\u0002*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000f\u001a\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e\u001a\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0012*\u00020\u00132\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e\u001a\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0012*\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000e\u001a\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0012*\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e\u001a \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0016*\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e\u001a \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016*\u00020\u00132\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e\u001a \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016*\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e\u001a8\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0016\"\b\b\u0000\u0010\u0007*\u00020\u0002*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e\u001aI\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016*\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\"\u0010\u0018\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\n0\u0019\"\n\u0012\u0006\b\u0001\u0012\u00020\u00020\n\u00a2\u0006\u0002\u0010\u001a\u001a/\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0016\"\n\b\u0000\u0010\u0007\u0018\u0001*\u00020\u0002*\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086\b\u001a8\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0016\"\b\b\u0000\u0010\u0007*\u00020\u0002*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e\u001a2\u0010\u001c\u001a\u00020\u001d\"\b\b\u0000\u0010\u0007*\u00020\u0002*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e\u001aI\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016*\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\"\u0010\u0018\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\n0\u0019\"\n\u0012\u0006\b\u0001\u0012\u00020\u00020\n\u00a2\u0006\u0002\u0010\u001a\u001aC\u0010\u001c\u001a\u00020\u001d*\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\"\u0010\u0018\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\n0\u0019\"\n\u0012\u0006\b\u0001\u0012\u00020\u00020\n\u00a2\u0006\u0002\u0010\u001e\u001a)\u0010\u001c\u001a\u00020\u001d\"\n\b\u0000\u0010\u0007\u0018\u0001*\u00020\u0002*\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086\b\u001aM\u0010\u001f\u001a\u00020\u001d*\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\"\u0010\u0018\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\n0\u0019\"\n\u0012\u0006\b\u0001\u0012\u00020\u00020\n\u00a2\u0006\u0002\u0010!\u001a\"\u0010\"\u001a\u00020\u001d\"\b\b\u0000\u0010\u0007*\u00020\u0002*\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n\u001a3\u0010\"\u001a\u00020\u001d*\u00020\u00032\"\u0010\u0018\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\n0\u0019\"\n\u0012\u0006\b\u0001\u0012\u00020\u00020\n\u00a2\u0006\u0002\u0010#\u001a\u001c\u0010\"\u001a\u00020\u001d*\u00020\u00032\u0010\u0010\u0018\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030%0$\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006&"}, d2={"entities", "Lnet/minecraft/world/level/entity/LevelEntityGetterAdapter;", "Lnet/minecraft/world/entity/Entity;", "Lnet/minecraft/server/level/ServerLevel;", "getEntities", "(Lnet/minecraft/server/level/ServerLevel;)Lnet/minecraft/world/level/entity/LevelEntityGetterAdapter;", "findClosestEntityInRange", "T", "Lnet/minecraft/world/level/LevelAccessor;", "clazz", "Ljava/lang/Class;", "base", "Lnet/minecraft/world/phys/Vec3;", "radius", "", "(Lnet/minecraft/world/level/LevelAccessor;Ljava/lang/Class;Lnet/minecraft/world/phys/Vec3;Ljava/lang/Number;)Lnet/minecraft/world/entity/Entity;", "findClosestPlayerInRange", "Lnet/minecraft/world/entity/player/Player;", "Lnet/minecraft/server/level/ServerPlayer;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "Lnet/minecraft/core/BlockPos;", "findPlayersInRange", "", "findSortedEntitiesInRange", "types", "", "(Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/phys/Vec3;Ljava/lang/Number;[Ljava/lang/Class;)Ljava/util/List;", "findEntitiesInRange", "hasEntitiesInRange", "", "(Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/phys/Vec3;Ljava/lang/Number;[Ljava/lang/Class;)Z", "hasEntitiesInRangeExcluding", "self", "(Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/phys/Vec3;Ljava/lang/Number;[Ljava/lang/Class;)Z", "hasEntities", "(Lnet/minecraft/server/level/ServerLevel;[Ljava/lang/Class;)Z", "", "Lnet/minecraft/world/entity/EntityType;", "brokencore-common"})
@JvmName(name="EntityFinder")
@SourceDebugExtension(value={"SMAP\nEntityFinderDSL.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EntityFinderDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/EntityFinder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,168:1\n1617#2,9:169\n1869#2:178\n1870#2:180\n1626#2:181\n1617#2,9:182\n1869#2:191\n1870#2:193\n1626#2:194\n1761#2,3:195\n1#3:179\n1#3:192\n*S KotlinDebug\n*F\n+ 1 EntityFinderDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/EntityFinder\n*L\n43#1:169,9\n43#1:178\n43#1:180\n43#1:181\n46#1:182,9\n46#1:191\n46#1:193\n46#1:194\n128#1:195,3\n43#1:179\n46#1:192\n*E\n"})
public final class EntityFinder {
    @NotNull
    public static final LevelEntityGetterAdapter<Entity> getEntities(@NotNull ServerLevel $this$entities) {
        Intrinsics.checkNotNullParameter((Object)$this$entities, (String)"<this>");
        return ((ServerLevelExt)$this$entities).brokencore_getEntities();
    }

    @Nullable
    public static final <T extends Entity> T findClosestEntityInRange(@NotNull LevelAccessor $this$findClosestEntityInRange, @NotNull Class<T> clazz, @NotNull Vec3 base, @NotNull Number radius) {
        Intrinsics.checkNotNullParameter((Object)$this$findClosestEntityInRange, (String)"<this>");
        Intrinsics.checkNotNullParameter(clazz, (String)"clazz");
        Intrinsics.checkNotNullParameter((Object)base, (String)"base");
        Intrinsics.checkNotNullParameter((Object)radius, (String)"radius");
        return (T)((Entity)CollectionsKt.firstOrNull(EntityFinder.findSortedEntitiesInRange($this$findClosestEntityInRange, clazz, base, radius)));
    }

    @Nullable
    public static final Player findClosestPlayerInRange(@NotNull LevelAccessor $this$findClosestPlayerInRange, @NotNull Vec3 base, @NotNull Number radius) {
        Intrinsics.checkNotNullParameter((Object)$this$findClosestPlayerInRange, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)base, (String)"base");
        Intrinsics.checkNotNullParameter((Object)radius, (String)"radius");
        return EntityFinder.findClosestEntityInRange($this$findClosestPlayerInRange, Player.class, base, radius);
    }

    @Nullable
    public static final ServerPlayer findClosestPlayerInRange(@NotNull ServerLevelAccessor $this$findClosestPlayerInRange, @NotNull Vec3 base, @NotNull Number radius) {
        Intrinsics.checkNotNullParameter((Object)$this$findClosestPlayerInRange, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)base, (String)"base");
        Intrinsics.checkNotNullParameter((Object)radius, (String)"radius");
        Player player = EntityFinder.findClosestEntityInRange((LevelAccessor)$this$findClosestPlayerInRange, Player.class, base, radius);
        return player instanceof ServerPlayer ? (ServerPlayer)player : null;
    }

    @Nullable
    public static final ServerPlayer findClosestPlayerInRange(@NotNull ServerLevelAccessor $this$findClosestPlayerInRange, @NotNull BlockPos base, @NotNull Number radius) {
        Intrinsics.checkNotNullParameter((Object)$this$findClosestPlayerInRange, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)base, (String)"base");
        Intrinsics.checkNotNullParameter((Object)radius, (String)"radius");
        LevelAccessor levelAccessor = (LevelAccessor)$this$findClosestPlayerInRange;
        Vec3 vec3 = base.getCenter();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getCenter(...)");
        Player player = EntityFinder.findClosestEntityInRange(levelAccessor, Player.class, vec3, radius);
        return player instanceof ServerPlayer ? (ServerPlayer)player : null;
    }

    @Nullable
    public static final ServerPlayer findClosestPlayerInRange(@NotNull ServerLevel $this$findClosestPlayerInRange, @NotNull Vec3 base, @NotNull Number radius) {
        Intrinsics.checkNotNullParameter((Object)$this$findClosestPlayerInRange, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)base, (String)"base");
        Intrinsics.checkNotNullParameter((Object)radius, (String)"radius");
        Player player = EntityFinder.findClosestEntityInRange((LevelAccessor)$this$findClosestPlayerInRange, Player.class, base, radius);
        return player instanceof ServerPlayer ? (ServerPlayer)player : null;
    }

    @NotNull
    public static final List<Player> findPlayersInRange(@NotNull LevelAccessor $this$findPlayersInRange, @NotNull Vec3 base, @NotNull Number radius) {
        Intrinsics.checkNotNullParameter((Object)$this$findPlayersInRange, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)base, (String)"base");
        Intrinsics.checkNotNullParameter((Object)radius, (String)"radius");
        return EntityFinder.findEntitiesInRange($this$findPlayersInRange, Player.class, base, radius);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<ServerPlayer> findPlayersInRange(@NotNull ServerLevelAccessor $this$findPlayersInRange, @NotNull Vec3 base, @NotNull Number radius) {
        void $this$mapNotNullTo$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$findPlayersInRange, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)base, (String)"base");
        Intrinsics.checkNotNullParameter((Object)radius, (String)"radius");
        Iterable $this$mapNotNull$iv = EntityFinder.findEntitiesInRange((LevelAccessor)$this$findPlayersInRange, Player.class, base, radius);
        boolean $i$f$mapNotNull = false;
        Iterable iterable = $this$mapNotNull$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        boolean $i$f$forEach = false;
        Iterator iterator = $this$forEach$iv$iv$iv.iterator();
        while (iterator.hasNext()) {
            ServerPlayer it$iv$iv;
            Object element$iv$iv$iv;
            Object element$iv$iv = element$iv$iv$iv = iterator.next();
            boolean bl = false;
            Player it = (Player)element$iv$iv;
            boolean bl2 = false;
            if ((it instanceof ServerPlayer ? (ServerPlayer)it : null) == null) continue;
            it$iv$iv = it$iv$iv;
            boolean bl3 = false;
            destination$iv$iv.add(it$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<ServerPlayer> findPlayersInRange(@NotNull ServerLevel $this$findPlayersInRange, @NotNull Vec3 base, @NotNull Number radius) {
        void $this$mapNotNullTo$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$findPlayersInRange, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)base, (String)"base");
        Intrinsics.checkNotNullParameter((Object)radius, (String)"radius");
        Iterable $this$mapNotNull$iv = EntityFinder.findEntitiesInRange((LevelAccessor)$this$findPlayersInRange, Player.class, base, radius);
        boolean $i$f$mapNotNull = false;
        Iterable iterable = $this$mapNotNull$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        boolean $i$f$forEach = false;
        Iterator iterator = $this$forEach$iv$iv$iv.iterator();
        while (iterator.hasNext()) {
            ServerPlayer it$iv$iv;
            Object element$iv$iv$iv;
            Object element$iv$iv = element$iv$iv$iv = iterator.next();
            boolean bl = false;
            Player it = (Player)element$iv$iv;
            boolean bl2 = false;
            if ((it instanceof ServerPlayer ? (ServerPlayer)it : null) == null) continue;
            it$iv$iv = it$iv$iv;
            boolean bl3 = false;
            destination$iv$iv.add(it$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    @NotNull
    public static final <T extends Entity> List<T> findSortedEntitiesInRange(@NotNull LevelAccessor $this$findSortedEntitiesInRange, @NotNull Class<T> clazz, @NotNull Vec3 base, @NotNull Number radius) {
        Intrinsics.checkNotNullParameter((Object)$this$findSortedEntitiesInRange, (String)"<this>");
        Intrinsics.checkNotNullParameter(clazz, (String)"clazz");
        Intrinsics.checkNotNullParameter((Object)base, (String)"base");
        Intrinsics.checkNotNullParameter((Object)radius, (String)"radius");
        List<Object> list = $this$findSortedEntitiesInRange.getEntitiesOfClass(clazz, Boxes.INSTANCE.aabb(base, radius)).stream().sorted(Comparator.comparingDouble(arg_0 -> EntityFinder.findSortedEntitiesInRange$lambda$1(arg_0 -> EntityFinder.findSortedEntitiesInRange$lambda$0(base, arg_0), arg_0))).toList();
        Intrinsics.checkNotNullExpressionValue(list, (String)"toList(...)");
        return list;
    }

    @NotNull
    public static final List<Entity> findSortedEntitiesInRange(@NotNull LevelAccessor $this$findSortedEntitiesInRange, @NotNull Vec3 base, @NotNull Number radius, Class<? extends Entity> ... types) {
        Intrinsics.checkNotNullParameter((Object)$this$findSortedEntitiesInRange, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)base, (String)"base");
        Intrinsics.checkNotNullParameter((Object)radius, (String)"radius");
        Intrinsics.checkNotNullParameter(types, (String)"types");
        List<Object> list = $this$findSortedEntitiesInRange.getEntities(MultiTypeTest.INSTANCE.forClasses(Arrays.copyOf(types, types.length)), Boxes.INSTANCE.aabb(base, radius), EntitySelector.NO_SPECTATORS).stream().sorted(Comparator.comparingDouble(arg_0 -> EntityFinder.findSortedEntitiesInRange$lambda$3(arg_0 -> EntityFinder.findSortedEntitiesInRange$lambda$2(base, arg_0), arg_0))).toList();
        Intrinsics.checkNotNullExpressionValue(list, (String)"toList(...)");
        return list;
    }

    public static final /* synthetic */ <T extends Entity> List<T> findEntitiesInRange(LevelAccessor $this$findEntitiesInRange, Vec3 base, Number radius) {
        Intrinsics.checkNotNullParameter((Object)$this$findEntitiesInRange, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)base, (String)"base");
        Intrinsics.checkNotNullParameter((Object)radius, (String)"radius");
        boolean $i$f$findEntitiesInRange = false;
        Intrinsics.reifiedOperationMarker((int)4, (String)"T");
        return EntityFinder.findEntitiesInRange($this$findEntitiesInRange, Entity.class, base, radius);
    }

    @NotNull
    public static final <T extends Entity> List<T> findEntitiesInRange(@NotNull LevelAccessor $this$findEntitiesInRange, @NotNull Class<T> clazz, @NotNull Vec3 base, @NotNull Number radius) {
        Intrinsics.checkNotNullParameter((Object)$this$findEntitiesInRange, (String)"<this>");
        Intrinsics.checkNotNullParameter(clazz, (String)"clazz");
        Intrinsics.checkNotNullParameter((Object)base, (String)"base");
        Intrinsics.checkNotNullParameter((Object)radius, (String)"radius");
        List list = $this$findEntitiesInRange.getEntitiesOfClass(clazz, Boxes.INSTANCE.aabb(base, radius));
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getEntitiesOfClass(...)");
        return list;
    }

    public static final <T extends Entity> boolean hasEntitiesInRange(@NotNull LevelAccessor $this$hasEntitiesInRange, @NotNull Class<T> clazz, @NotNull Vec3 base, @NotNull Number radius) {
        Intrinsics.checkNotNullParameter((Object)$this$hasEntitiesInRange, (String)"<this>");
        Intrinsics.checkNotNullParameter(clazz, (String)"clazz");
        Intrinsics.checkNotNullParameter((Object)base, (String)"base");
        Intrinsics.checkNotNullParameter((Object)radius, (String)"radius");
        if ($this$hasEntitiesInRange instanceof ServerLevel) {
            Ref.BooleanRef found = new Ref.BooleanRef();
            EntityFinder.getEntities((ServerLevel)$this$hasEntitiesInRange).get(EntityTypeTest.forClass(clazz), Boxes.INSTANCE.aabb(base, radius), arg_0 -> EntityFinder.hasEntitiesInRange$lambda$0(found, arg_0));
            return found.element;
        }
        List list = $this$hasEntitiesInRange.getEntitiesOfClass(clazz, Boxes.INSTANCE.aabb(base, radius));
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getEntitiesOfClass(...)");
        return !((Collection)list).isEmpty();
    }

    @NotNull
    public static final List<Entity> findEntitiesInRange(@NotNull LevelAccessor $this$findEntitiesInRange, @NotNull Vec3 base, @NotNull Number radius, Class<? extends Entity> ... types) {
        Intrinsics.checkNotNullParameter((Object)$this$findEntitiesInRange, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)base, (String)"base");
        Intrinsics.checkNotNullParameter((Object)radius, (String)"radius");
        Intrinsics.checkNotNullParameter(types, (String)"types");
        List list = $this$findEntitiesInRange.getEntities(MultiTypeTest.INSTANCE.forClasses(Arrays.copyOf(types, types.length)), Boxes.INSTANCE.aabb(base, radius), EntitySelector.NO_SPECTATORS);
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getEntities(...)");
        return list;
    }

    public static final boolean hasEntitiesInRange(@NotNull LevelAccessor $this$hasEntitiesInRange, @NotNull Vec3 base, @NotNull Number radius, Class<? extends Entity> ... types) {
        Intrinsics.checkNotNullParameter((Object)$this$hasEntitiesInRange, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)base, (String)"base");
        Intrinsics.checkNotNullParameter((Object)radius, (String)"radius");
        Intrinsics.checkNotNullParameter(types, (String)"types");
        if ($this$hasEntitiesInRange instanceof ServerLevel) {
            Ref.BooleanRef found = new Ref.BooleanRef();
            EntityFinder.getEntities((ServerLevel)$this$hasEntitiesInRange).get(MultiTypeTest.INSTANCE.forClasses(Arrays.copyOf(types, types.length)), Boxes.INSTANCE.aabb(base, radius), arg_0 -> EntityFinder.hasEntitiesInRange$lambda$1(found, arg_0));
            return found.element;
        }
        List list = $this$hasEntitiesInRange.getEntities(MultiTypeTest.INSTANCE.forClasses(Arrays.copyOf(types, types.length)), Boxes.INSTANCE.aabb(base, radius), EntitySelector.NO_SPECTATORS);
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getEntities(...)");
        return !((Collection)list).isEmpty();
    }

    public static final /* synthetic */ <T extends Entity> boolean hasEntitiesInRange(LevelAccessor $this$hasEntitiesInRange, Vec3 base, Number radius) {
        Intrinsics.checkNotNullParameter((Object)$this$hasEntitiesInRange, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)base, (String)"base");
        Intrinsics.checkNotNullParameter((Object)radius, (String)"radius");
        boolean $i$f$hasEntitiesInRange = false;
        Class[] classArray = new Class[1];
        Intrinsics.reifiedOperationMarker((int)4, (String)"T");
        classArray[0] = Entity.class;
        return EntityFinder.hasEntitiesInRange($this$hasEntitiesInRange, base, radius, classArray);
    }

    /*
     * WARNING - void declaration
     */
    public static final boolean hasEntitiesInRangeExcluding(@NotNull LevelAccessor $this$hasEntitiesInRangeExcluding, @Nullable Entity self, @NotNull Vec3 base, @NotNull Number radius, Class<? extends Entity> ... types) {
        boolean bl;
        block4: {
            void $this$any$iv;
            Intrinsics.checkNotNullParameter((Object)$this$hasEntitiesInRangeExcluding, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)base, (String)"base");
            Intrinsics.checkNotNullParameter((Object)radius, (String)"radius");
            Intrinsics.checkNotNullParameter(types, (String)"types");
            if ($this$hasEntitiesInRangeExcluding instanceof ServerLevel) {
                Ref.BooleanRef found = new Ref.BooleanRef();
                EntityFinder.getEntities((ServerLevel)$this$hasEntitiesInRangeExcluding).get(MultiTypeTest.INSTANCE.forClasses(Arrays.copyOf(types, types.length)), Boxes.INSTANCE.aabb(base, radius), arg_0 -> EntityFinder.hasEntitiesInRangeExcluding$lambda$0(self, found, arg_0));
                return found.element;
            }
            List list = $this$hasEntitiesInRangeExcluding.getEntities(MultiTypeTest.INSTANCE.forClasses(Arrays.copyOf(types, types.length)), Boxes.INSTANCE.aabb(base, radius), EntitySelector.NO_SPECTATORS);
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getEntities(...)");
            Iterable found = list;
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    Entity it = (Entity)element$iv;
                    boolean bl2 = false;
                    if (!(!Intrinsics.areEqual((Object)it, (Object)self))) continue;
                    bl = true;
                    break block4;
                }
                bl = false;
            }
        }
        return bl;
    }

    public static final <T extends Entity> boolean hasEntities(@NotNull ServerLevel $this$hasEntities, @NotNull Class<T> clazz) {
        Intrinsics.checkNotNullParameter((Object)$this$hasEntities, (String)"<this>");
        Intrinsics.checkNotNullParameter(clazz, (String)"clazz");
        Ref.BooleanRef found = new Ref.BooleanRef();
        EntityFinder.getEntities($this$hasEntities).get(EntityTypeTest.forClass(clazz), arg_0 -> EntityFinder.hasEntities$lambda$0(found, arg_0));
        return found.element;
    }

    public static final boolean hasEntities(@NotNull ServerLevel $this$hasEntities, Class<? extends Entity> ... types) {
        Intrinsics.checkNotNullParameter((Object)$this$hasEntities, (String)"<this>");
        Intrinsics.checkNotNullParameter(types, (String)"types");
        Ref.BooleanRef found = new Ref.BooleanRef();
        EntityFinder.getEntities($this$hasEntities).get(MultiTypeTest.INSTANCE.forClasses(Arrays.copyOf(types, types.length)), arg_0 -> EntityFinder.hasEntities$lambda$1(found, arg_0));
        return found.element;
    }

    public static final boolean hasEntities(@NotNull ServerLevel $this$hasEntities, @NotNull Set<? extends EntityType<?>> types) {
        Intrinsics.checkNotNullParameter((Object)$this$hasEntities, (String)"<this>");
        Intrinsics.checkNotNullParameter(types, (String)"types");
        Ref.BooleanRef found = new Ref.BooleanRef();
        for (EntityType<?> type : types) {
            EntityFinder.getEntities($this$hasEntities).get((EntityTypeTest)type, new AbortableIterationConsumer(found){
                final /* synthetic */ Ref.BooleanRef $found;
                {
                    this.$found = $found;
                }

                public final AbortableIterationConsumer.Continuation accept(Entity it) {
                    this.$found.element = true;
                    return AbortableIterationConsumer.Continuation.ABORT;
                }
            });
            if (!found.element) continue;
            break;
        }
        return found.element;
    }

    private static final double findSortedEntitiesInRange$lambda$0(Vec3 $base, Entity it) {
        return it.distanceToSqr($base);
    }

    private static final double findSortedEntitiesInRange$lambda$1(Function1 $tmp0, Object p0) {
        return ((Number)$tmp0.invoke(p0)).doubleValue();
    }

    private static final double findSortedEntitiesInRange$lambda$2(Vec3 $base, Entity it) {
        return it.distanceToSqr($base);
    }

    private static final double findSortedEntitiesInRange$lambda$3(Function1 $tmp0, Object p0) {
        return ((Number)$tmp0.invoke(p0)).doubleValue();
    }

    private static final AbortableIterationConsumer.Continuation hasEntitiesInRange$lambda$0(Ref.BooleanRef $found, Entity it) {
        $found.element = true;
        return AbortableIterationConsumer.Continuation.ABORT;
    }

    private static final AbortableIterationConsumer.Continuation hasEntitiesInRange$lambda$1(Ref.BooleanRef $found, Entity it) {
        $found.element = true;
        return AbortableIterationConsumer.Continuation.ABORT;
    }

    private static final AbortableIterationConsumer.Continuation hasEntitiesInRangeExcluding$lambda$0(Entity $self, Ref.BooleanRef $found, Entity it) {
        if ($self != null && Intrinsics.areEqual((Object)it, (Object)$self)) {
            return AbortableIterationConsumer.Continuation.CONTINUE;
        }
        $found.element = true;
        return AbortableIterationConsumer.Continuation.ABORT;
    }

    private static final AbortableIterationConsumer.Continuation hasEntities$lambda$0(Ref.BooleanRef $found, Entity it) {
        $found.element = true;
        return AbortableIterationConsumer.Continuation.ABORT;
    }

    private static final AbortableIterationConsumer.Continuation hasEntities$lambda$1(Ref.BooleanRef $found, Entity it) {
        $found.element = true;
        return AbortableIterationConsumer.Continuation.ABORT;
    }
}

