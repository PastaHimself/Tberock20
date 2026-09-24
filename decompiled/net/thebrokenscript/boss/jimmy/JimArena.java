/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.server.players.PlayerList
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.LevelUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.boss.jimmy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.PlayerList;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.entity.BaseFracturedEntity;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.boss.jimmy.JimmyBossBarHandler;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.LevelUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.entity.anomaly.sa2.SubAnomaly2Entity;
import net.thebrokenscript.entity.fractured.FracturedEntity;
import net.thebrokenscript.registry.TBSEntities;
import net.thebrokenscript.registry.TBSSounds;
import net.thebrokenscript.util.RadiusSpawnerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001!B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aJ\b\u0010\u001f\u001a\u00020\u001dH\u0002J\u0006\u0010 \u001a\u00020\u001aR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001e\u00a8\u0006\""}, d2={"Lnet/thebrokenscript/boss/jimmy/JimArena;", "", "center", "Lnet/minecraft/core/BlockPos;", "level", "Lnet/minecraft/server/level/ServerLevel;", "players", "", "Lnet/minecraft/server/level/ServerPlayer;", "<init>", "(Lnet/minecraft/core/BlockPos;Lnet/minecraft/server/level/ServerLevel;Ljava/util/List;)V", "getCenter", "()Lnet/minecraft/core/BlockPos;", "getLevel", "()Lnet/minecraft/server/level/ServerLevel;", "setLevel", "(Lnet/minecraft/server/level/ServerLevel;)V", "getPlayers", "()Ljava/util/List;", "jimmy", "Lnet/thebrokenscript/entity/fractured/FracturedEntity;", "event", "Lnet/thebrokenscript/boss/jimmy/JimmyBossBarHandler;", "sa2s", "Lnet/thebrokenscript/entity/anomaly/sa2/SubAnomaly2Entity;", "start", "", "tick", "isActive", "", "()Z", "checkLivingPlayers", "reset", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nJimArena.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JimArena.kt\nnet/thebrokenscript/boss/jimmy/JimArena\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,114:1\n1761#2,3:115\n1869#2,2:118\n*S KotlinDebug\n*F\n+ 1 JimArena.kt\nnet/thebrokenscript/boss/jimmy/JimArena\n*L\n95#1:115,3\n104#1:118,2\n*E\n"})
public final class JimArena {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final BlockPos center;
    @NotNull
    private ServerLevel level;
    @NotNull
    private final List<ServerPlayer> players;
    @Nullable
    private FracturedEntity jimmy;
    @NotNull
    private JimmyBossBarHandler event;
    @NotNull
    private final List<SubAnomaly2Entity> sa2s;
    public static final long START_MUSIC_TICKS = 340L;
    public static final int NUM_SA2S = 30;
    @JvmField
    @Nullable
    public static JimArena instance;

    public JimArena(@NotNull BlockPos center, @NotNull ServerLevel level, @NotNull List<ServerPlayer> players) {
        Intrinsics.checkNotNullParameter((Object)center, (String)"center");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter(players, (String)"players");
        this.center = center;
        this.level = level;
        this.players = players;
        this.event = new JimmyBossBarHandler();
        this.sa2s = new ArrayList();
    }

    public /* synthetic */ JimArena(BlockPos blockPos, ServerLevel serverLevel, List list, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            list = new ArrayList();
        }
        this(blockPos, serverLevel, list);
    }

    @NotNull
    public final BlockPos getCenter() {
        return this.center;
    }

    @NotNull
    public final ServerLevel getLevel() {
        return this.level;
    }

    public final void setLevel(@NotNull ServerLevel serverLevel) {
        Intrinsics.checkNotNullParameter((Object)serverLevel, (String)"<set-?>");
        this.level = serverLevel;
    }

    @NotNull
    public final List<ServerPlayer> getPlayers() {
        return this.players;
    }

    public final void start() {
        FracturedEntity fracturedEntity = this.jimmy = (FracturedEntity)EntityTypeExt.trySummonTyped((EntityType)((EntityType)TBSEntities.FRACTURED.get()), (LevelAccessor)((LevelAccessor)this.level), (BlockPos)this.center);
        if (fracturedEntity != null) {
            fracturedEntity.setCurrentState(BaseFracturedEntity.JimmyStates.RISING);
        }
        FracturedEntity fracturedEntity2 = this.jimmy;
        Intrinsics.checkNotNull((Object)((Object)fracturedEntity2));
        float f = fracturedEntity2.getAmountOfSA2AttacksNeeded();
        FracturedEntity fracturedEntity3 = this.jimmy;
        Intrinsics.checkNotNull((Object)((Object)fracturedEntity3));
        float f2 = f - (float)fracturedEntity3.getTimesAttacked();
        FracturedEntity fracturedEntity4 = this.jimmy;
        Intrinsics.checkNotNull((Object)((Object)fracturedEntity4));
        this.event.set(f2 / fracturedEntity4.getAmountOfSA2AttacksNeeded(), true);
        for (ServerPlayer player : this.players) {
            PlayerExt.tryPlayMusic$default(PlayerExt.INSTANCE, (Player)player, (SoundEvent)TBSSounds.JIMBOB_INTRO.get(), false, 0.0f, 0.0f, 12, null);
        }
        LevelUtil.getQueue((Level)((Level)this.level)).add(340L, () -> JimArena.start$lambda$0(this));
    }

    public final void tick() {
        if (!this.checkLivingPlayers()) {
            this.reset();
            return;
        }
        FracturedEntity fracturedEntity = this.jimmy;
        Intrinsics.checkNotNull((Object)((Object)fracturedEntity));
        float f = fracturedEntity.getAmountOfSA2AttacksNeeded();
        FracturedEntity fracturedEntity2 = this.jimmy;
        Intrinsics.checkNotNull((Object)((Object)fracturedEntity2));
        float f2 = f - (float)fracturedEntity2.getTimesAttacked();
        FracturedEntity fracturedEntity3 = this.jimmy;
        Intrinsics.checkNotNull((Object)((Object)fracturedEntity3));
        this.event.set(f2 / fracturedEntity3.getAmountOfSA2AttacksNeeded(), this.isActive());
    }

    private final boolean isActive() {
        FracturedEntity fracturedEntity = this.jimmy;
        Intrinsics.checkNotNull((Object)((Object)fracturedEntity));
        return fracturedEntity.isAlive();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean checkLivingPlayers() {
        ServerPlayer it;
        PlayerList playerList = this.level.getServer().getPlayerList();
        ListIterator<ServerPlayer> iterator = this.players.listIterator();
        while (iterator.hasNext()) {
            ServerPlayer cached = iterator.next();
            ServerPlayer live = playerList.getPlayer(cached.getUUID());
            if (live == null) {
                iterator.remove();
                continue;
            }
            if (live == cached) continue;
            iterator.set(live);
        }
        if (((Collection)this.players).isEmpty()) return false;
        boolean bl = true;
        if (!bl) return false;
        if (this.players.size() <= 2) return true;
        Iterable $this$any$iv = this.players;
        boolean $i$f$any = false;
        if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
            return false;
        }
        Iterator iterator2 = $this$any$iv.iterator();
        do {
            if (!iterator2.hasNext()) return false;
            Object element$iv = iterator2.next();
            it = (ServerPlayer)element$iv;
            boolean bl2 = false;
        } while (!it.isAlive());
        return true;
    }

    public final void reset() {
        this.event.reset();
        FracturedEntity fracturedEntity = this.jimmy;
        if (fracturedEntity != null) {
            fracturedEntity.discard();
        }
        this.jimmy = null;
        Iterable $this$forEach$iv = this.sa2s;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            SubAnomaly2Entity p0 = (SubAnomaly2Entity)((Object)element$iv);
            boolean bl = false;
            p0.discard();
        }
        this.sa2s.clear();
        for (ServerPlayer player : this.players) {
            PlayerUtil.stopAllSounds((Player)((Player)player));
        }
        this.players.clear();
        instance = null;
    }

    private static final Unit start$lambda$0(JimArena this$0) {
        for (ServerPlayer player : this$0.players) {
            PlayerExt.tryPlayMusic$default(PlayerExt.INSTANCE, (Player)player, (SoundEvent)TBSSounds.JIMBOB_LOOP.get(), true, 0.0f, 0.0f, 12, null);
            this$0.event.addPlayer(player);
        }
        CollectionsKt.addAll((Collection)this$0.sa2s, (Iterable)CollectionsKt.filterNotNull((Iterable)RadiusSpawnerKt.spawnRadius$default((EntityType)TBSEntities.SUB_ANOMALY_2.get(), this$0.level, this$0.center.getX(), this$0.center.getZ(), 20.0f, 0.0f, 30, 0.0f, true, 64, null)));
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/boss/jimmy/JimArena$Companion;", "", "<init>", "()V", "START_MUSIC_TICKS", "", "NUM_SA2S", "", "instance", "Lnet/thebrokenscript/boss/jimmy/JimArena;", "start", "pos", "Lnet/minecraft/core/BlockPos;", "level", "Lnet/minecraft/server/level/ServerLevel;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final JimArena start(@NotNull BlockPos pos, @NotNull ServerLevel level) {
            Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            JimArena jimArena = instance;
            if (jimArena != null) {
                jimArena.reset();
            }
            Vec3 vec3 = pos.getCenter();
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getCenter(...)");
            JimArena jimArena2 = instance = new JimArena(pos, level, CollectionsKt.toMutableList((Collection)EntityFinder.findPlayersInRange((ServerLevel)level, (Vec3)vec3, (Number)150)));
            if (jimArena2 != null) {
                jimArena2.start();
            }
            JimArena jimArena3 = instance;
            Intrinsics.checkNotNull((Object)jimArena3);
            return jimArena3;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

