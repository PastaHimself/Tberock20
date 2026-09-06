/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.level.Level
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.boss.integrity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.thebrokenscript.boss.integrity.Arena;
import net.thebrokenscript.boss.integrity.ArenaPhase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001a\u001a\u00020\u001bH&J\b\u0010\u001c\u001a\u00020\u001bH&J\b\u0010\u001d\u001a\u00020\u001bH&J\b\u0010\u001e\u001a\u00020\u001bH&J\b\u0010\u001f\u001a\u00020\u001bH\u0016J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078D@DX\u0084\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\"\u001a\u00020\u0017X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u0019R\u0012\u0010$\u001a\u00020%X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010'R\u001c\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,\u00a8\u0006-"}, d2={"Lnet/thebrokenscript/boss/integrity/Phase;", "", "arena", "Lnet/thebrokenscript/boss/integrity/Arena;", "<init>", "(Lnet/thebrokenscript/boss/integrity/Arena;)V", "value", "Lnet/minecraft/server/level/ServerLevel;", "level", "getLevel", "()Lnet/minecraft/server/level/ServerLevel;", "setLevel", "(Lnet/minecraft/server/level/ServerLevel;)V", "center", "Lnet/minecraft/core/BlockPos;", "getCenter", "()Lnet/minecraft/core/BlockPos;", "players", "", "Lnet/minecraft/server/level/ServerPlayer;", "getPlayers", "()Ljava/util/List;", "active", "", "getActive", "()Z", "start", "", "tick", "end", "cleanup", "reset", "playerEnteredDimension", "player", "ended", "getEnded", "id", "Lnet/thebrokenscript/boss/integrity/ArenaPhase;", "getId", "()Lnet/thebrokenscript/boss/integrity/ArenaPhase;", "dimension", "Lnet/minecraft/resources/ResourceKey;", "Lnet/minecraft/world/level/Level;", "getDimension", "()Lnet/minecraft/resources/ResourceKey;", "thebrokenscript-common"})
public abstract class Phase {
    @NotNull
    private final Arena arena;
    @Nullable
    private final ResourceKey<Level> dimension;

    public Phase(@NotNull Arena arena) {
        Intrinsics.checkNotNullParameter((Object)arena, (String)"arena");
        this.arena = arena;
    }

    @NotNull
    protected final ServerLevel getLevel() {
        return this.arena.getLevel();
    }

    protected final void setLevel(@NotNull ServerLevel value) {
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        this.arena.setLevel(value);
    }

    @NotNull
    protected final BlockPos getCenter() {
        return this.arena.getCenter();
    }

    @NotNull
    protected final List<ServerPlayer> getPlayers() {
        return this.arena.getPlayers();
    }

    protected final boolean getActive() {
        Phase phase = this.arena.getPhase();
        return (phase != null ? phase.getId() : null) == this.getId();
    }

    public abstract void start();

    public abstract void tick();

    public abstract void end();

    public abstract void cleanup();

    public void reset() {
    }

    public void playerEnteredDimension(@NotNull ServerPlayer player) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
    }

    public abstract boolean getEnded();

    @NotNull
    public abstract ArenaPhase getId();

    @Nullable
    public ResourceKey<Level> getDimension() {
        return this.dimension;
    }
}

