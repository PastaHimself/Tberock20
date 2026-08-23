/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.boss.jimmy;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.client.overlay.JimmyBossBarUpdate;
import net.thebrokenscript.network.UpdateJimmyBossBarPacket;
import net.thebrokenscript.registry.TBSPackets;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0012J\u0006\u0010\u0017\u001a\u00020\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Lnet/thebrokenscript/boss/jimmy/JimmyBossBarHandler;", "", "<init>", "()V", "value", "", "getValue", "()F", "setValue", "(F)V", "show", "", "getShow", "()Z", "setShow", "(Z)V", "players", "", "Lnet/minecraft/server/level/ServerPlayer;", "set", "", "addPlayer", "player", "reset", "thebrokenscript-common"})
public final class JimmyBossBarHandler {
    private float value;
    private boolean show;
    @NotNull
    private final Set<ServerPlayer> players = new LinkedHashSet();

    public final float getValue() {
        return this.value;
    }

    public final void setValue(float f) {
        this.value = f;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final void setShow(boolean bl) {
        this.show = bl;
    }

    public final void set(float value, boolean show) {
        if (!(this.value == value) || this.show != show) {
            this.value = value;
            this.show = show;
            UpdateJimmyBossBarPacket packet = (UpdateJimmyBossBarPacket)TBSPackets.UPDATE_JIMMY_BOSS_BAR.of(new JimmyBossBarUpdate(value, show));
            for (ServerPlayer player : this.players) {
                PlayerUtil.trySendCustomPacket((Player)((Player)player), (CustomPacketPayload)((CustomPacketPayload)packet));
            }
        }
    }

    public final void addPlayer(@NotNull ServerPlayer player) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        this.players.add(player);
        PlayerUtil.trySendCustomPacket((Player)((Player)player), (CustomPacketPayload)((CustomPacketPayload)TBSPackets.UPDATE_JIMMY_BOSS_BAR.of(new JimmyBossBarUpdate(this.value, this.show))));
    }

    public final void reset() {
        this.set(0.0f, false);
        this.players.clear();
    }
}

