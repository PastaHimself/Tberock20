/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.level.LevelAccessor
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.world;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.LevelAccessor;
import net.thebrokenscript.brokencore.api.network.PacketSender;
import net.thebrokenscript.brokencore.impl.registry.BCPackets;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\rJ\u001f\u0010\u0011\u001a\u00020\r2\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u0015\u00a2\u0006\u0002\u0010\u0016J\u001f\u0010\u0012\u001a\u00020\r2\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u0015\u00a2\u0006\u0002\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\u0018"}, d2={"Lnet/thebrokenscript/brokencore/api/world/TimeOfDay;", "", "time", "", "<init>", "(Ljava/lang/String;IJ)V", "getTime", "()J", "DAY", "NOON", "NIGHT", "MIDNIGHT", "set", "", "level", "Lnet/minecraft/world/level/LevelAccessor;", "Lnet/minecraft/server/level/ServerLevel;", "setFake", "disableFake", "players", "", "Lnet/minecraft/server/level/ServerPlayer;", "([Lnet/minecraft/server/level/ServerPlayer;)V", "Companion", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nTimeOfDay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TimeOfDay.kt\nnet/thebrokenscript/brokencore/api/world/TimeOfDay\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,125:1\n13805#2,2:126\n13805#2,2:128\n*S KotlinDebug\n*F\n+ 1 TimeOfDay.kt\nnet/thebrokenscript/brokencore/api/world/TimeOfDay\n*L\n47#1:126,2\n54#1:128,2\n*E\n"})
public final class TimeOfDay
extends Enum<TimeOfDay> {
    @NotNull
    public static final Companion Companion;
    private final long time;
    private static final int TICKS_PER_DAY = 24000;
    public static final /* enum */ TimeOfDay DAY;
    public static final /* enum */ TimeOfDay NOON;
    public static final /* enum */ TimeOfDay NIGHT;
    public static final /* enum */ TimeOfDay MIDNIGHT;
    private static final /* synthetic */ TimeOfDay[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private TimeOfDay(long time2) {
        this.time = time2;
    }

    public final long getTime() {
        return this.time;
    }

    public final void set(@NotNull LevelAccessor level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        if (level instanceof ServerLevel) {
            this.set((ServerLevel)level);
        }
    }

    public final void set(@NotNull ServerLevel level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Companion.set((LevelAccessor)level, this);
    }

    public final void setFake() {
        PacketSender.INSTANCE.sendToAllPlayers(BCPackets.FAKE_TIME_OF_DAY.of(this.time, true), new CustomPacketPayload[0]);
    }

    public final void disableFake() {
        PacketSender.INSTANCE.sendToAllPlayers(BCPackets.FAKE_TIME_OF_DAY.of(this.time, false), new CustomPacketPayload[0]);
    }

    public final void setFake(ServerPlayer ... players) {
        Intrinsics.checkNotNullParameter((Object)players, (String)"players");
        ServerPlayer[] $this$forEach$iv = players;
        boolean $i$f$forEach = false;
        int n = $this$forEach$iv.length;
        for (int i = 0; i < n; ++i) {
            ServerPlayer element$iv;
            ServerPlayer it = element$iv = $this$forEach$iv[i];
            boolean bl = false;
            PacketSender.INSTANCE.sendToPlayer(it, BCPackets.FAKE_TIME_OF_DAY.of(this.time, true), new CustomPacketPayload[0]);
        }
    }

    public final void disableFake(ServerPlayer ... players) {
        Intrinsics.checkNotNullParameter((Object)players, (String)"players");
        ServerPlayer[] $this$forEach$iv = players;
        boolean $i$f$forEach = false;
        int n = $this$forEach$iv.length;
        for (int i = 0; i < n; ++i) {
            ServerPlayer element$iv;
            ServerPlayer it = element$iv = $this$forEach$iv[i];
            boolean bl = false;
            PacketSender.INSTANCE.sendToPlayer(it, BCPackets.FAKE_TIME_OF_DAY.of(this.time, false), new CustomPacketPayload[0]);
        }
    }

    public static TimeOfDay[] values() {
        return (TimeOfDay[])$VALUES.clone();
    }

    public static TimeOfDay valueOf(String value) {
        return Enum.valueOf(TimeOfDay.class, value);
    }

    @NotNull
    public static EnumEntries<TimeOfDay> getEntries() {
        return $ENTRIES;
    }

    static {
        DAY = new TimeOfDay(1000L);
        NOON = new TimeOfDay(6000L);
        NIGHT = new TimeOfDay(13000L);
        MIDNIGHT = new TimeOfDay(18000L);
        $VALUES = timeOfDayArray = new TimeOfDay[]{TimeOfDay.DAY, TimeOfDay.NOON, TimeOfDay.NIGHT, TimeOfDay.MIDNIGHT};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        Companion = new Companion(null);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ'\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010\"\u00020\u0011\u00a2\u0006\u0002\u0010\u0012J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005J'\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010\"\u00020\u0011\u00a2\u0006\u0002\u0010\u0013J\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ'\u0010\u0014\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010\"\u00020\u0011\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/brokencore/api/world/TimeOfDay$Companion;", "", "<init>", "()V", "TICKS_PER_DAY", "", "set", "", "level", "Lnet/minecraft/world/level/LevelAccessor;", "target", "Lnet/thebrokenscript/brokencore/api/world/TimeOfDay;", "Lnet/minecraft/server/level/ServerLevel;", "", "setFake", "players", "", "Lnet/minecraft/server/level/ServerPlayer;", "(Lnet/thebrokenscript/brokencore/api/world/TimeOfDay;[Lnet/minecraft/server/level/ServerPlayer;)V", "(I[Lnet/minecraft/server/level/ServerPlayer;)V", "disableFake", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nTimeOfDay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TimeOfDay.kt\nnet/thebrokenscript/brokencore/api/world/TimeOfDay$Companion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,125:1\n13805#2,2:126\n*S KotlinDebug\n*F\n+ 1 TimeOfDay.kt\nnet/thebrokenscript/brokencore/api/world/TimeOfDay$Companion\n*L\n108#1:126,2\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        public final void set(@NotNull LevelAccessor level, @NotNull TimeOfDay target) {
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            Intrinsics.checkNotNullParameter((Object)((Object)target), (String)"target");
            if (level instanceof ServerLevel) {
                this.set((ServerLevel)level, target.getTime());
            }
        }

        public final void set(@NotNull ServerLevel level, long target) {
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            long currentTime = level.getDayTime();
            long currentTimeInDay = currentTime % (long)24000;
            if (currentTimeInDay > target) {
                long needed = (long)24000 - currentTimeInDay + target;
                level.setDayTime(level.getDayTime() + needed);
            } else if (target > currentTimeInDay) {
                level.setDayTime(level.getDayTime() + (target - currentTimeInDay));
            }
        }

        public final void setFake(@NotNull TimeOfDay target) {
            Intrinsics.checkNotNullParameter((Object)((Object)target), (String)"target");
            target.setFake();
        }

        public final void setFake(@NotNull TimeOfDay target, ServerPlayer ... players) {
            Intrinsics.checkNotNullParameter((Object)((Object)target), (String)"target");
            Intrinsics.checkNotNullParameter((Object)players, (String)"players");
            target.setFake(Arrays.copyOf(players, players.length));
        }

        public final void setFake(int target) {
            PacketSender.INSTANCE.sendToAllPlayers(BCPackets.FAKE_TIME_OF_DAY.of(target, true), new CustomPacketPayload[0]);
        }

        public final void setFake(int target, ServerPlayer ... players) {
            Intrinsics.checkNotNullParameter((Object)players, (String)"players");
            ServerPlayer[] $this$forEach$iv = players;
            boolean $i$f$forEach = false;
            int n = $this$forEach$iv.length;
            for (int i = 0; i < n; ++i) {
                ServerPlayer element$iv;
                ServerPlayer it = element$iv = $this$forEach$iv[i];
                boolean bl = false;
                PacketSender.INSTANCE.sendToPlayer(it, BCPackets.FAKE_TIME_OF_DAY.of(target, true), new CustomPacketPayload[0]);
            }
        }

        public final void disableFake(@NotNull TimeOfDay target) {
            Intrinsics.checkNotNullParameter((Object)((Object)target), (String)"target");
            target.disableFake();
        }

        public final void disableFake(@NotNull TimeOfDay target, ServerPlayer ... players) {
            Intrinsics.checkNotNullParameter((Object)((Object)target), (String)"target");
            Intrinsics.checkNotNullParameter((Object)players, (String)"players");
            target.disableFake(Arrays.copyOf(players, players.length));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

