/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.server.players.PlayerList
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.boss.integrity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.PlayerList;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.boss.integrity.ArenaPhase;
import net.thebrokenscript.boss.integrity.Phase;
import net.thebrokenscript.boss.integrity.Phase1;
import net.thebrokenscript.boss.integrity.Phase2;
import net.thebrokenscript.boss.integrity.Phase3;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.data.PlayerVariables;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 12\u00020\u0001:\u00011B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020*J\u0006\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020*J\u0006\u0010/\u001a\u00020*J\u0006\u00100\u001a\u00020*R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 \u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u00a8\u00062"}, d2={"Lnet/thebrokenscript/boss/integrity/Arena;", "", "center", "Lnet/minecraft/core/BlockPos;", "level", "Lnet/minecraft/server/level/ServerLevel;", "players", "", "Lnet/minecraft/server/level/ServerPlayer;", "<init>", "(Lnet/minecraft/core/BlockPos;Lnet/minecraft/server/level/ServerLevel;Ljava/util/List;)V", "getCenter", "()Lnet/minecraft/core/BlockPos;", "getLevel", "()Lnet/minecraft/server/level/ServerLevel;", "setLevel", "(Lnet/minecraft/server/level/ServerLevel;)V", "getPlayers", "()Ljava/util/List;", "phase1", "Lnet/thebrokenscript/boss/integrity/Phase1;", "getPhase1", "()Lnet/thebrokenscript/boss/integrity/Phase1;", "phase2", "Lnet/thebrokenscript/boss/integrity/Phase2;", "getPhase2", "()Lnet/thebrokenscript/boss/integrity/Phase2;", "phase3", "Lnet/thebrokenscript/boss/integrity/Phase3;", "getPhase3", "()Lnet/thebrokenscript/boss/integrity/Phase3;", "phases", "", "Lnet/thebrokenscript/boss/integrity/Phase;", "getPhases", "()Ljava/util/Set;", "phase", "getPhase", "()Lnet/thebrokenscript/boss/integrity/Phase;", "setPhase", "(Lnet/thebrokenscript/boss/integrity/Phase;)V", "start", "", "tick", "checkLivingPlayers", "", "nextPhase", "restartPhase", "reset", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nArena.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Arena.kt\nnet/thebrokenscript/boss/integrity/Arena\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,121:1\n1761#2,3:122\n1#3:125\n*S KotlinDebug\n*F\n+ 1 Arena.kt\nnet/thebrokenscript/boss/integrity/Arena\n*L\n74#1:122,3\n*E\n"})
public final class Arena {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final BlockPos center;
    @NotNull
    private ServerLevel level;
    @NotNull
    private final List<ServerPlayer> players;
    @NotNull
    private final Phase1 phase1;
    @NotNull
    private final Phase2 phase2;
    @NotNull
    private final Phase3 phase3;
    @NotNull
    private final Set<Phase> phases;
    @Nullable
    private Phase phase;
    @JvmField
    @Nullable
    public static Arena instance;

    public Arena(@NotNull BlockPos center, @NotNull ServerLevel level, @NotNull List<ServerPlayer> players) {
        Intrinsics.checkNotNullParameter((Object)center, (String)"center");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter(players, (String)"players");
        this.center = center;
        this.level = level;
        this.players = players;
        this.phase1 = new Phase1(this);
        this.phase2 = new Phase2(this);
        this.phase3 = new Phase3(this);
        Object[] objectArray = new Phase[]{this.phase1, this.phase2, this.phase3};
        this.phases = SetsKt.setOf((Object[])objectArray);
    }

    public /* synthetic */ Arena(BlockPos blockPos, ServerLevel serverLevel, List list, int n, DefaultConstructorMarker defaultConstructorMarker) {
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

    @NotNull
    public final Phase1 getPhase1() {
        return this.phase1;
    }

    @NotNull
    public final Phase2 getPhase2() {
        return this.phase2;
    }

    @NotNull
    public final Phase3 getPhase3() {
        return this.phase3;
    }

    @NotNull
    public final Set<Phase> getPhases() {
        return this.phases;
    }

    @Nullable
    public final Phase getPhase() {
        return this.phase;
    }

    public final void setPhase(@Nullable Phase phase) {
        this.phase = phase;
    }

    public final void start() {
        block0: {
            Phase phase = this.phase = (Phase)this.phase1;
            if (phase == null) break block0;
            phase.start();
        }
    }

    public final void tick() {
        block2: {
            if (!this.checkLivingPlayers()) {
                this.reset();
                return;
            }
            Phase phase = this.phase;
            boolean bl = phase != null ? phase.getEnded() : false;
            if (bl) {
                this.nextPhase();
            }
            Phase phase2 = this.phase;
            if (phase2 == null) break block2;
            phase2.tick();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean checkLivingPlayers() {
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

    public final void nextPhase() {
        block10: {
            Object object;
            Phase phase = this.phase;
            if (phase != null) {
                phase.end();
            }
            Phase phase2 = this.phase;
            if (phase2 != null) {
                phase2.cleanup();
            }
            ArenaPhase arenaPhase = (object = this.phase) != null && (object = ((Phase)object).getId()) != null ? ((ArenaPhase)((Object)object)).next() : null;
            this.phase = switch (arenaPhase == null ? -1 : WhenMappings.$EnumSwitchMapping$0[arenaPhase.ordinal()]) {
                case 1 -> this.phase1;
                case 2 -> this.phase2;
                case 3 -> this.phase3;
                case -1 -> null;
                default -> throw new NoWhenBranchMatchedException();
            };
            MinecraftServer minecraftServer = this.level.getServer();
            ResourceKey resourceKey = this.phase;
            if (resourceKey == null || (resourceKey = resourceKey.getDimension()) == null) {
                resourceKey = Level.OVERWORLD;
            }
            ServerLevel serverLevel = minecraftServer.getLevel(resourceKey);
            if (serverLevel != null) {
                ServerLevel it = serverLevel;
                boolean bl = false;
                this.level = it;
            }
            Phase phase3 = this.phase;
            if (phase3 == null) break block10;
            phase3.start();
        }
    }

    public final void restartPhase() {
        block4: {
            Phase phase = this.phase;
            if (phase != null) {
                phase.end();
            }
            Phase phase2 = this.phase;
            if (phase2 != null) {
                phase2.cleanup();
            }
            MinecraftServer minecraftServer = this.level.getServer();
            ResourceKey resourceKey = this.phase;
            if (resourceKey == null || (resourceKey = resourceKey.getDimension()) == null) {
                resourceKey = Level.OVERWORLD;
            }
            ServerLevel serverLevel = minecraftServer.getLevel(resourceKey);
            if (serverLevel != null) {
                ServerLevel it = serverLevel;
                boolean bl = false;
                this.level = it;
            }
            Phase phase3 = this.phase;
            if (phase3 == null) break block4;
            phase3.start();
        }
    }

    public final void reset() {
        for (Phase phase : this.phases) {
            phase.cleanup();
            phase.reset();
        }
        for (ServerPlayer player : this.players) {
            PlayerUtil.stopAllSounds((Player)((Player)player));
            PlayerExt.INSTANCE.updateVars((Player)player, (Function1<? super PlayerVariables, Unit>)((Function1)Arena::reset$lambda$0));
        }
        this.players.clear();
        this.phase = null;
        instance = null;
    }

    private static final Unit reset$lambda$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setEnableCustomSky(false);
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005J\b\u0010\f\u001a\u0004\u0018\u00010\rR\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/boss/integrity/Arena$Companion;", "", "<init>", "()V", "instance", "Lnet/thebrokenscript/boss/integrity/Arena;", "start", "pos", "Lnet/minecraft/core/BlockPos;", "level", "Lnet/minecraft/server/level/ServerLevel;", "getInstance", "getPhase", "Lnet/thebrokenscript/boss/integrity/ArenaPhase;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Arena start(@NotNull BlockPos pos, @NotNull ServerLevel level) {
            Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            Arena arena = instance;
            if (arena != null) {
                arena.reset();
            }
            Vec3 vec3 = pos.getCenter();
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getCenter(...)");
            Arena arena2 = instance = new Arena(pos, level, CollectionsKt.toMutableList((Collection)EntityFinder.findPlayersInRange((ServerLevel)level, (Vec3)vec3, (Number)150)));
            if (arena2 != null) {
                arena2.start();
            }
            Arena arena3 = instance;
            Intrinsics.checkNotNull((Object)arena3);
            return arena3;
        }

        @Nullable
        public final Arena getInstance() {
            return instance;
        }

        @Nullable
        public final ArenaPhase getPhase() {
            Object object = instance;
            return object != null && (object = ((Arena)object).getPhase()) != null ? ((Phase)object).getId() : null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[ArenaPhase.values().length];
            try {
                nArray[ArenaPhase.Phase1.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ArenaPhase.Phase2.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ArenaPhase.Phase3.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

