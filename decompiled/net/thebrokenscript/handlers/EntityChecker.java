/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.Random
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.data.MapVariables;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.handlers.subs.EntitySpawnSubscriber;
import net.thebrokenscript.handlers.subs.ServerTickSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSEntities;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0002R%\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR%\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR%\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\bR%\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0012\u0010\bR%\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0015\u0010\b\u00a8\u0006%"}, d2={"Lnet/thebrokenscript/handlers/EntityChecker;", "", "<init>", "()V", "nullEntities", "", "Lnet/minecraft/world/entity/EntityType;", "getNullEntities", "()Ljava/util/Set;", "nullEntities$delegate", "Lkotlin/Lazy;", "circuitStalkers", "getCircuitStalkers", "circuitStalkers$delegate", "circuitChasers", "getCircuitChasers", "circuitChasers$delegate", "siluetEntities", "getSiluetEntities", "siluetEntities$delegate", "tbeEntities", "getTbeEntities", "tbeEntities$delegate", "isNullEntity", "", "entity", "Lnet/minecraft/world/entity/Entity;", "isSiluetEntity", "isCircuitStalker", "isTBEEntity", "onEntitySpawned", "", "cancelProxy", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "onServerTick", "server", "Lnet/minecraft/server/MinecraftServer;", "thebrokenscript-common"})
public final class EntityChecker {
    @NotNull
    public static final EntityChecker INSTANCE = new EntityChecker();
    @NotNull
    private static final Lazy nullEntities$delegate;
    @NotNull
    private static final Lazy circuitStalkers$delegate;
    @NotNull
    private static final Lazy circuitChasers$delegate;
    @NotNull
    private static final Lazy siluetEntities$delegate;
    @NotNull
    private static final Lazy tbeEntities$delegate;

    private EntityChecker() {
    }

    @NotNull
    public final Set<EntityType<?>> getNullEntities() {
        Lazy lazy = nullEntities$delegate;
        return (Set)lazy.getValue();
    }

    @NotNull
    public final Set<EntityType<?>> getCircuitStalkers() {
        Lazy lazy = circuitStalkers$delegate;
        return (Set)lazy.getValue();
    }

    @NotNull
    public final Set<EntityType<?>> getCircuitChasers() {
        Lazy lazy = circuitChasers$delegate;
        return (Set)lazy.getValue();
    }

    @NotNull
    public final Set<EntityType<?>> getSiluetEntities() {
        Lazy lazy = siluetEntities$delegate;
        return (Set)lazy.getValue();
    }

    @NotNull
    public final Set<EntityType<?>> getTbeEntities() {
        Lazy lazy = tbeEntities$delegate;
        return (Set)lazy.getValue();
    }

    private final boolean isNullEntity(Entity entity) {
        return this.getNullEntities().contains(entity.getType());
    }

    private final boolean isSiluetEntity(Entity entity) {
        return this.getSiluetEntities().contains(entity.getType());
    }

    private final boolean isCircuitStalker(Entity entity) {
        return this.getCircuitStalkers().contains(entity.getType());
    }

    private final boolean isTBEEntity(Entity entity) {
        return this.getTbeEntities().contains(entity.getType());
    }

    private final void onEntitySpawned(Entity entity, CancelProxy cancelProxy) {
        ResourceLocation resourceLocation = BuiltInRegistries.ENTITY_TYPE.getKey((Object)entity.getType());
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"getKey(...)");
        ResourceLocation id = resourceLocation;
        Level level = entity.level();
        if (!(level instanceof ServerLevel)) {
            return;
        }
        if (Intrinsics.areEqual((Object)id.getNamespace(), (Object)"thebrokenscript")) {
            if (this.isNullEntity(entity)) {
                LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)EntityChecker::onEntitySpawned$lambda$0));
            } else if (this.isSiluetEntity(entity)) {
                LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)EntityChecker::onEntitySpawned$lambda$1));
            } else if (this.isCircuitStalker(entity)) {
                LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)EntityChecker::onEntitySpawned$lambda$2));
            } else if (this.isTBEEntity(entity)) {
                LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)EntityChecker::onEntitySpawned$lambda$3));
            }
        }
    }

    private final void onServerTick(MinecraftServer server) {
        List list = server.getPlayerList().getPlayers();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getPlayers(...)");
        ServerPlayer serverPlayer = (ServerPlayer)CollectionsKt.randomOrNull((Collection)list, (Random)((Random)Random.Default));
        if (serverPlayer == null) {
            return;
        }
        ServerPlayer player = serverPlayer;
        ServerLevel level = player.serverLevel();
        if (level == null) {
            return;
        }
        if (level.getGameTime() % (long)20 != 0L) {
            return;
        }
        if (!EntityFinder.hasEntities((ServerLevel)level, this.getNullEntities())) {
            LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)EntityChecker::onServerTick$lambda$0));
        }
        if (!EntityFinder.hasEntities((ServerLevel)level, this.getSiluetEntities())) {
            LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)EntityChecker::onServerTick$lambda$1));
        }
        if (!EntityFinder.hasEntities((ServerLevel)level, this.getCircuitStalkers())) {
            LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)EntityChecker::onServerTick$lambda$2));
        }
        if (!EntityFinder.hasEntities((ServerLevel)level, this.getCircuitChasers())) {
            for (ServerPlayer player2 : level.getServer().getPlayerList().getPlayers()) {
                Intrinsics.checkNotNull((Object)player2);
                if (PlayerExt.INSTANCE.getVars((Player)player2).getNoWayOutFrame() == 0) continue;
                PlayerExt.INSTANCE.updateVars((Player)player2, (Function1<? super PlayerVariables, Unit>)((Function1)EntityChecker::onServerTick$lambda$3));
            }
        }
        if (!EntityFinder.hasEntities((ServerLevel)level, this.getTbeEntities())) {
            LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)EntityChecker::onServerTick$lambda$4));
        }
    }

    private static final Set nullEntities_delegate$lambda$0() {
        Object[] objectArray = new EntityType[]{TBSEntities.NULL_FLYING.get(), TBSEntities.NULL_MINING.get(), TBSEntities.NULL_INVADE_BASE.get(), TBSEntities.NULL_WATCHING.get(), TBSEntities.NULL_IS_HERE.get()};
        return SetsKt.setOf((Object[])objectArray);
    }

    private static final Set circuitStalkers_delegate$lambda$0() {
        Object[] objectArray = new EntityType[]{TBSEntities.CIRCUIT_STALK.get(), TBSEntities.CIRCUIT_STARE.get(), TBSEntities.CIRCUIT_MINESHAFT_STARE.get(), TBSEntities.CIRCUIT_MINESHAFT_WALK.get(), TBSEntities.CIRCUIT.get()};
        return SetsKt.setOf((Object[])objectArray);
    }

    private static final Set circuitChasers_delegate$lambda$0() {
        return SetsKt.setOf((Object)TBSEntities.CIRCUIT.get());
    }

    private static final Set siluetEntities_delegate$lambda$0() {
        Object[] objectArray = new EntityType[]{TBSEntities.SILUET.get(), TBSEntities.SILUET_STARE.get(), TBSEntities.HE.get()};
        return SetsKt.setOf((Object[])objectArray);
    }

    private static final Set tbeEntities_delegate$lambda$0() {
        Object[] objectArray = new EntityType[]{TBSEntities.THE_BROKEN_END.get(), TBSEntities.THE_BROKEN_END_STALK.get()};
        return SetsKt.setOf((Object[])objectArray);
    }

    private static final Unit onEntitySpawned$lambda$0(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setHasNullSpawned(true);
        return Unit.INSTANCE;
    }

    private static final Unit onEntitySpawned$lambda$1(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setHasSiluetSpawned(true);
        return Unit.INSTANCE;
    }

    private static final Unit onEntitySpawned$lambda$2(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setHasCircuitSpawned(true);
        return Unit.INSTANCE;
    }

    private static final Unit onEntitySpawned$lambda$3(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setHasTheBrokenEndSpawned(true);
        return Unit.INSTANCE;
    }

    private static final Unit onServerTick$lambda$0(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setHasNullSpawned(false);
        return Unit.INSTANCE;
    }

    private static final Unit onServerTick$lambda$1(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setHasSiluetSpawned(false);
        return Unit.INSTANCE;
    }

    private static final Unit onServerTick$lambda$2(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setHasCircuitSpawned(false);
        return Unit.INSTANCE;
    }

    private static final Unit onServerTick$lambda$3(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setNoWayOutFrame(0);
        return Unit.INSTANCE;
    }

    private static final Unit onServerTick$lambda$4(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setHasTheBrokenEndSpawned(false);
        return Unit.INSTANCE;
    }

    static {
        EntitySpawnSubscriber.INSTANCE.add((Function2<? super Entity, ? super CancelProxy, Unit>)((Function2)new Function2<Entity, CancelProxy, Unit>((Object)INSTANCE){

            public final void invoke(Entity p0, CancelProxy p1) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                Intrinsics.checkNotNullParameter((Object)p1, (String)"p1");
                ((EntityChecker)this.receiver).onEntitySpawned(p0, p1);
            }
        }));
        ServerTickSubscriber.INSTANCE.add((Function1<? super MinecraftServer, Unit>)((Function1)new Function1<MinecraftServer, Unit>((Object)INSTANCE){

            public final void invoke(MinecraftServer p0) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                ((EntityChecker)this.receiver).onServerTick(p0);
            }
        }));
        nullEntities$delegate = LazyKt.lazy(EntityChecker::nullEntities_delegate$lambda$0);
        circuitStalkers$delegate = LazyKt.lazy(EntityChecker::circuitStalkers_delegate$lambda$0);
        circuitChasers$delegate = LazyKt.lazy(EntityChecker::circuitChasers_delegate$lambda$0);
        siluetEntities$delegate = LazyKt.lazy(EntityChecker::siluetEntities_delegate$lambda$0);
        tbeEntities$delegate = LazyKt.lazy(EntityChecker::tbeEntities_delegate$lambda$0);
    }
}

