/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.BlockHitResult
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.event.game;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.thebrokenscript.brokencore.api.event.Cancelable;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u000b\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001dB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2={"Lnet/thebrokenscript/brokencore/api/event/game/PlayerEvents;", "", "<init>", "()V", "CHANGE_DIMENSION", "Lnet/thebrokenscript/brokencore/api/event/GameEvent;", "Lnet/thebrokenscript/brokencore/api/event/game/PlayerEvents$ChangeDimension;", "CHANGE_DIMENSION_CLIENT", "Lnet/thebrokenscript/brokencore/api/event/game/PlayerEvents$ChangeDimensionClient;", "INTERACT_BLOCK", "Lnet/thebrokenscript/brokencore/api/event/game/PlayerEvents$InteractBlock;", "BLOCK_HITSOUND_EMIT", "Lnet/thebrokenscript/brokencore/api/event/game/PlayerEvents$BlockHitSoundEmit;", "INTERACT_ENTITY", "Lnet/thebrokenscript/brokencore/api/event/game/PlayerEvents$InteractEntity;", "USE_ITEM", "Lnet/thebrokenscript/brokencore/api/event/game/PlayerEvents$UseItem;", "SLEEP", "Lnet/thebrokenscript/brokencore/api/event/game/PlayerEvents$Sleep;", "PlayerData", "HitResultData", "BlockHitSoundEmitData", "ServerPlayerData", "ChangeDimension", "ChangeDimensionClient", "InteractBlock", "BlockHitSoundEmit", "InteractEntity", "UseItem", "Sleep", "brokencore-common"})
public final class PlayerEvents {
    @NotNull
    public static final PlayerEvents INSTANCE = new PlayerEvents();
    @JvmField
    @NotNull
    public static final GameEvent<ChangeDimension> CHANGE_DIMENSION = new GameEvent();
    @JvmField
    @NotNull
    public static final GameEvent<ChangeDimensionClient> CHANGE_DIMENSION_CLIENT = new GameEvent();
    @JvmField
    @NotNull
    public static final GameEvent<InteractBlock> INTERACT_BLOCK = new GameEvent();
    @JvmField
    @NotNull
    public static final GameEvent<BlockHitSoundEmit> BLOCK_HITSOUND_EMIT = new GameEvent();
    @JvmField
    @NotNull
    public static final GameEvent<InteractEntity> INTERACT_ENTITY = new GameEvent();
    @JvmField
    @NotNull
    public static final GameEvent<UseItem> USE_ITEM = new GameEvent();
    @JvmField
    @NotNull
    public static final GameEvent<Sleep> SLEEP = new GameEvent();

    private PlayerEvents() {
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B;\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\r\u001a\u00020\u000eX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/brokencore/api/event/game/PlayerEvents$BlockHitSoundEmit;", "Lnet/thebrokenscript/brokencore/api/event/game/PlayerEvents$BlockHitSoundEmitData;", "Lnet/thebrokenscript/brokencore/api/event/Cancelable;", "hitPos", "Lnet/minecraft/core/BlockPos;", "hitDirection", "Lnet/minecraft/core/Direction;", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "level", "Lnet/minecraft/world/level/Level;", "soundType", "Lnet/minecraft/world/level/block/SoundType;", "canceled", "", "<init>", "(Lnet/minecraft/core/BlockPos;Lnet/minecraft/core/Direction;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/Level;Lnet/minecraft/world/level/block/SoundType;Z)V", "getCanceled", "()Z", "setCanceled", "(Z)V", "brokencore-common"})
    public static final class BlockHitSoundEmit
    extends BlockHitSoundEmitData
    implements Cancelable {
        private boolean canceled;

        @JvmOverloads
        public BlockHitSoundEmit(@NotNull BlockPos hitPos, @NotNull Direction hitDirection, @NotNull BlockState state, @NotNull Level level, @NotNull SoundType soundType, boolean canceled) {
            Intrinsics.checkNotNullParameter((Object)hitPos, (String)"hitPos");
            Intrinsics.checkNotNullParameter((Object)hitDirection, (String)"hitDirection");
            Intrinsics.checkNotNullParameter((Object)state, (String)"state");
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            Intrinsics.checkNotNullParameter((Object)soundType, (String)"soundType");
            super(hitPos, hitDirection, state, level, soundType);
            this.canceled = canceled;
        }

        public /* synthetic */ BlockHitSoundEmit(BlockPos blockPos, Direction direction, BlockState blockState, Level level, SoundType soundType, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 0x20) != 0) {
                bl = false;
            }
            this(blockPos, direction, blockState, level, soundType, bl);
        }

        @Override
        public boolean getCanceled() {
            return this.canceled;
        }

        @Override
        public void setCanceled(boolean bl) {
            this.canceled = bl;
        }

        @JvmOverloads
        public BlockHitSoundEmit(@NotNull BlockPos hitPos, @NotNull Direction hitDirection, @NotNull BlockState state, @NotNull Level level, @NotNull SoundType soundType) {
            Intrinsics.checkNotNullParameter((Object)hitPos, (String)"hitPos");
            Intrinsics.checkNotNullParameter((Object)hitDirection, (String)"hitDirection");
            Intrinsics.checkNotNullParameter((Object)state, (String)"state");
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            Intrinsics.checkNotNullParameter((Object)soundType, (String)"soundType");
            this(hitPos, hitDirection, state, level, soundType, false, 32, null);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0018"}, d2={"Lnet/thebrokenscript/brokencore/api/event/game/PlayerEvents$BlockHitSoundEmitData;", "", "hitPos", "Lnet/minecraft/core/BlockPos;", "hitDirection", "Lnet/minecraft/core/Direction;", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "level", "Lnet/minecraft/world/level/Level;", "soundType", "Lnet/minecraft/world/level/block/SoundType;", "<init>", "(Lnet/minecraft/core/BlockPos;Lnet/minecraft/core/Direction;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/Level;Lnet/minecraft/world/level/block/SoundType;)V", "getHitPos", "()Lnet/minecraft/core/BlockPos;", "getHitDirection", "()Lnet/minecraft/core/Direction;", "getState", "()Lnet/minecraft/world/level/block/state/BlockState;", "getLevel", "()Lnet/minecraft/world/level/Level;", "getSoundType", "()Lnet/minecraft/world/level/block/SoundType;", "brokencore-common"})
    public static class BlockHitSoundEmitData {
        @NotNull
        private final BlockPos hitPos;
        @NotNull
        private final Direction hitDirection;
        @NotNull
        private final BlockState state;
        @NotNull
        private final Level level;
        @NotNull
        private final SoundType soundType;

        public BlockHitSoundEmitData(@NotNull BlockPos hitPos, @NotNull Direction hitDirection, @NotNull BlockState state, @NotNull Level level, @NotNull SoundType soundType) {
            Intrinsics.checkNotNullParameter((Object)hitPos, (String)"hitPos");
            Intrinsics.checkNotNullParameter((Object)hitDirection, (String)"hitDirection");
            Intrinsics.checkNotNullParameter((Object)state, (String)"state");
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            Intrinsics.checkNotNullParameter((Object)soundType, (String)"soundType");
            this.hitPos = hitPos;
            this.hitDirection = hitDirection;
            this.state = state;
            this.level = level;
            this.soundType = soundType;
        }

        @NotNull
        public final BlockPos getHitPos() {
            return this.hitPos;
        }

        @NotNull
        public final Direction getHitDirection() {
            return this.hitDirection;
        }

        @NotNull
        public final BlockState getState() {
            return this.state;
        }

        @NotNull
        public final Level getLevel() {
            return this.level;
        }

        @NotNull
        public final SoundType getSoundType() {
            return this.soundType;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B7\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001a\u0010\t\u001a\u00020\nX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/brokencore/api/event/game/PlayerEvents$ChangeDimension;", "Lnet/thebrokenscript/brokencore/api/event/game/PlayerEvents$ServerPlayerData;", "Lnet/thebrokenscript/brokencore/api/event/Cancelable;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "from", "Lnet/minecraft/resources/ResourceKey;", "Lnet/minecraft/world/level/Level;", "to", "canceled", "", "<init>", "(Lnet/minecraft/server/level/ServerPlayer;Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/resources/ResourceKey;Z)V", "getFrom", "()Lnet/minecraft/resources/ResourceKey;", "getTo", "getCanceled", "()Z", "setCanceled", "(Z)V", "brokencore-common"})
    public static final class ChangeDimension
    extends ServerPlayerData
    implements Cancelable {
        @NotNull
        private final ResourceKey<Level> from;
        @NotNull
        private final ResourceKey<Level> to;
        private boolean canceled;

        @JvmOverloads
        public ChangeDimension(@NotNull ServerPlayer player, @NotNull ResourceKey<Level> from, @NotNull ResourceKey<Level> to, boolean canceled) {
            Intrinsics.checkNotNullParameter((Object)player, (String)"player");
            Intrinsics.checkNotNullParameter(from, (String)"from");
            Intrinsics.checkNotNullParameter(to, (String)"to");
            super(player);
            this.from = from;
            this.to = to;
            this.canceled = canceled;
        }

        public /* synthetic */ ChangeDimension(ServerPlayer serverPlayer, ResourceKey resourceKey, ResourceKey resourceKey2, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 8) != 0) {
                bl = false;
            }
            this(serverPlayer, (ResourceKey<Level>)resourceKey, (ResourceKey<Level>)resourceKey2, bl);
        }

        @NotNull
        public final ResourceKey<Level> getFrom() {
            return this.from;
        }

        @NotNull
        public final ResourceKey<Level> getTo() {
            return this.to;
        }

        @Override
        public boolean getCanceled() {
            return this.canceled;
        }

        @Override
        public void setCanceled(boolean bl) {
            this.canceled = bl;
        }

        @JvmOverloads
        public ChangeDimension(@NotNull ServerPlayer player, @NotNull ResourceKey<Level> from, @NotNull ResourceKey<Level> to) {
            Intrinsics.checkNotNullParameter((Object)player, (String)"player");
            Intrinsics.checkNotNullParameter(from, (String)"from");
            Intrinsics.checkNotNullParameter(to, (String)"to");
            this(player, from, to, false, 8, null);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/brokencore/api/event/game/PlayerEvents$ChangeDimensionClient;", "Lnet/thebrokenscript/brokencore/api/event/game/PlayerEvents$PlayerData;", "player", "Lnet/minecraft/world/entity/player/Player;", "from", "Lnet/minecraft/resources/ResourceKey;", "Lnet/minecraft/world/level/Level;", "to", "<init>", "(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/resources/ResourceKey;)V", "getFrom", "()Lnet/minecraft/resources/ResourceKey;", "getTo", "brokencore-common"})
    public static final class ChangeDimensionClient
    extends PlayerData {
        @NotNull
        private final ResourceKey<Level> from;
        @NotNull
        private final ResourceKey<Level> to;

        public ChangeDimensionClient(@NotNull Player player, @NotNull ResourceKey<Level> from, @NotNull ResourceKey<Level> to) {
            Intrinsics.checkNotNullParameter((Object)player, (String)"player");
            Intrinsics.checkNotNullParameter(from, (String)"from");
            Intrinsics.checkNotNullParameter(to, (String)"to");
            super(player);
            this.from = from;
            this.to = to;
        }

        @NotNull
        public final ResourceKey<Level> getFrom() {
            return this.from;
        }

        @NotNull
        public final ResourceKey<Level> getTo() {
            return this.to;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/brokencore/api/event/game/PlayerEvents$HitResultData;", "", "player", "Lnet/minecraft/world/entity/player/Player;", "hitResult", "Lnet/minecraft/world/phys/BlockHitResult;", "<init>", "(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/phys/BlockHitResult;)V", "getPlayer", "()Lnet/minecraft/world/entity/player/Player;", "getHitResult", "()Lnet/minecraft/world/phys/BlockHitResult;", "brokencore-common"})
    public static class HitResultData {
        @NotNull
        private final Player player;
        @NotNull
        private final BlockHitResult hitResult;

        public HitResultData(@NotNull Player player, @NotNull BlockHitResult hitResult) {
            Intrinsics.checkNotNullParameter((Object)player, (String)"player");
            Intrinsics.checkNotNullParameter((Object)hitResult, (String)"hitResult");
            this.player = player;
            this.hitResult = hitResult;
        }

        @NotNull
        public final Player getPlayer() {
            return this.player;
        }

        @NotNull
        public final BlockHitResult getHitResult() {
            return this.hitResult;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B#\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/api/event/game/PlayerEvents$InteractBlock;", "Lnet/thebrokenscript/brokencore/api/event/game/PlayerEvents$HitResultData;", "Lnet/thebrokenscript/brokencore/api/event/Cancelable;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "hitResult", "Lnet/minecraft/world/phys/BlockHitResult;", "canceled", "", "<init>", "(Lnet/minecraft/server/level/ServerPlayer;Lnet/minecraft/world/phys/BlockHitResult;Z)V", "getCanceled", "()Z", "setCanceled", "(Z)V", "brokencore-common"})
    public static final class InteractBlock
    extends HitResultData
    implements Cancelable {
        private boolean canceled;

        @JvmOverloads
        public InteractBlock(@NotNull ServerPlayer player, @NotNull BlockHitResult hitResult, boolean canceled) {
            Intrinsics.checkNotNullParameter((Object)player, (String)"player");
            Intrinsics.checkNotNullParameter((Object)hitResult, (String)"hitResult");
            super((Player)player, hitResult);
            this.canceled = canceled;
        }

        public /* synthetic */ InteractBlock(ServerPlayer serverPlayer, BlockHitResult blockHitResult, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 4) != 0) {
                bl = false;
            }
            this(serverPlayer, blockHitResult, bl);
        }

        @Override
        public boolean getCanceled() {
            return this.canceled;
        }

        @Override
        public void setCanceled(boolean bl) {
            this.canceled = bl;
        }

        @JvmOverloads
        public InteractBlock(@NotNull ServerPlayer player, @NotNull BlockHitResult hitResult) {
            Intrinsics.checkNotNullParameter((Object)player, (String)"player");
            Intrinsics.checkNotNullParameter((Object)hitResult, (String)"hitResult");
            this(player, hitResult, false, 4, null);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u00012\u00020\u0002B=\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\r\u001a\u00020\u000eX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001d"}, d2={"Lnet/thebrokenscript/brokencore/api/event/game/PlayerEvents$InteractEntity;", "Lnet/thebrokenscript/brokencore/api/event/game/PlayerEvents$PlayerData;", "Lnet/thebrokenscript/brokencore/api/event/Cancelable;", "player", "Lnet/minecraft/world/entity/player/Player;", "hand", "Lnet/minecraft/world/InteractionHand;", "pos", "Lnet/minecraft/core/BlockPos;", "face", "Lnet/minecraft/core/Direction;", "target", "Lnet/minecraft/world/entity/Entity;", "canceled", "", "<init>", "(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/InteractionHand;Lnet/minecraft/core/BlockPos;Lnet/minecraft/core/Direction;Lnet/minecraft/world/entity/Entity;Z)V", "getHand", "()Lnet/minecraft/world/InteractionHand;", "getPos", "()Lnet/minecraft/core/BlockPos;", "getFace", "()Lnet/minecraft/core/Direction;", "getTarget", "()Lnet/minecraft/world/entity/Entity;", "getCanceled", "()Z", "setCanceled", "(Z)V", "brokencore-common"})
    public static final class InteractEntity
    extends PlayerData
    implements Cancelable {
        @NotNull
        private final InteractionHand hand;
        @NotNull
        private final BlockPos pos;
        @Nullable
        private final Direction face;
        @NotNull
        private final Entity target;
        private boolean canceled;

        @JvmOverloads
        public InteractEntity(@NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockPos pos, @Nullable Direction face2, @NotNull Entity target, boolean canceled) {
            Intrinsics.checkNotNullParameter((Object)player, (String)"player");
            Intrinsics.checkNotNullParameter((Object)hand, (String)"hand");
            Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
            Intrinsics.checkNotNullParameter((Object)target, (String)"target");
            super(player);
            this.hand = hand;
            this.pos = pos;
            this.face = face2;
            this.target = target;
            this.canceled = canceled;
        }

        public /* synthetic */ InteractEntity(Player player, InteractionHand interactionHand, BlockPos blockPos, Direction direction, Entity entity, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 0x20) != 0) {
                bl = false;
            }
            this(player, interactionHand, blockPos, direction, entity, bl);
        }

        @NotNull
        public final InteractionHand getHand() {
            return this.hand;
        }

        @NotNull
        public final BlockPos getPos() {
            return this.pos;
        }

        @Nullable
        public final Direction getFace() {
            return this.face;
        }

        @NotNull
        public final Entity getTarget() {
            return this.target;
        }

        @Override
        public boolean getCanceled() {
            return this.canceled;
        }

        @Override
        public void setCanceled(boolean bl) {
            this.canceled = bl;
        }

        @JvmOverloads
        public InteractEntity(@NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockPos pos, @Nullable Direction face2, @NotNull Entity target) {
            Intrinsics.checkNotNullParameter((Object)player, (String)"player");
            Intrinsics.checkNotNullParameter((Object)hand, (String)"hand");
            Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
            Intrinsics.checkNotNullParameter((Object)target, (String)"target");
            this(player, hand, pos, face2, target, false, 32, null);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/api/event/game/PlayerEvents$PlayerData;", "", "player", "Lnet/minecraft/world/entity/player/Player;", "<init>", "(Lnet/minecraft/world/entity/player/Player;)V", "getPlayer", "()Lnet/minecraft/world/entity/player/Player;", "brokencore-common"})
    public static class PlayerData {
        @NotNull
        private final Player player;

        public PlayerData(@NotNull Player player) {
            Intrinsics.checkNotNullParameter((Object)player, (String)"player");
            this.player = player;
        }

        @NotNull
        public final Player getPlayer() {
            return this.player;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/api/event/game/PlayerEvents$ServerPlayerData;", "", "player", "Lnet/minecraft/server/level/ServerPlayer;", "<init>", "(Lnet/minecraft/server/level/ServerPlayer;)V", "getPlayer", "()Lnet/minecraft/server/level/ServerPlayer;", "brokencore-common"})
    public static class ServerPlayerData {
        @NotNull
        private final ServerPlayer player;

        public ServerPlayerData(@NotNull ServerPlayer player) {
            Intrinsics.checkNotNullParameter((Object)player, (String)"player");
            this.player = player;
        }

        @NotNull
        public final ServerPlayer getPlayer() {
            return this.player;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/brokencore/api/event/game/PlayerEvents$Sleep;", "Lnet/thebrokenscript/brokencore/api/event/game/PlayerEvents$ServerPlayerData;", "Lnet/thebrokenscript/brokencore/api/event/Cancelable;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "canceled", "", "<init>", "(Lnet/minecraft/server/level/ServerPlayer;Z)V", "getCanceled", "()Z", "setCanceled", "(Z)V", "brokencore-common"})
    public static final class Sleep
    extends ServerPlayerData
    implements Cancelable {
        private boolean canceled;

        @JvmOverloads
        public Sleep(@NotNull ServerPlayer player, boolean canceled) {
            Intrinsics.checkNotNullParameter((Object)player, (String)"player");
            super(player);
            this.canceled = canceled;
        }

        public /* synthetic */ Sleep(ServerPlayer serverPlayer, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 2) != 0) {
                bl = false;
            }
            this(serverPlayer, bl);
        }

        @Override
        public boolean getCanceled() {
            return this.canceled;
        }

        @Override
        public void setCanceled(boolean bl) {
            this.canceled = bl;
        }

        @JvmOverloads
        public Sleep(@NotNull ServerPlayer player) {
            Intrinsics.checkNotNullParameter((Object)player, (String)"player");
            this(player, false, 2, null);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B#\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/brokencore/api/event/game/PlayerEvents$UseItem;", "Lnet/thebrokenscript/brokencore/api/event/game/PlayerEvents$PlayerData;", "Lnet/thebrokenscript/brokencore/api/event/Cancelable;", "player", "Lnet/minecraft/world/entity/player/Player;", "item", "Lnet/minecraft/world/item/ItemStack;", "canceled", "", "<init>", "(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/item/ItemStack;Z)V", "getItem", "()Lnet/minecraft/world/item/ItemStack;", "getCanceled", "()Z", "setCanceled", "(Z)V", "brokencore-common"})
    public static final class UseItem
    extends PlayerData
    implements Cancelable {
        @NotNull
        private final ItemStack item;
        private boolean canceled;

        @JvmOverloads
        public UseItem(@NotNull Player player, @NotNull ItemStack item2, boolean canceled) {
            Intrinsics.checkNotNullParameter((Object)player, (String)"player");
            Intrinsics.checkNotNullParameter((Object)item2, (String)"item");
            super(player);
            this.item = item2;
            this.canceled = canceled;
        }

        public /* synthetic */ UseItem(Player player, ItemStack itemStack, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 4) != 0) {
                bl = false;
            }
            this(player, itemStack, bl);
        }

        @NotNull
        public final ItemStack getItem() {
            return this.item;
        }

        @Override
        public boolean getCanceled() {
            return this.canceled;
        }

        @Override
        public void setCanceled(boolean bl) {
            this.canceled = bl;
        }

        @JvmOverloads
        public UseItem(@NotNull Player player, @NotNull ItemStack item2) {
            Intrinsics.checkNotNullParameter((Object)player, (String)"player");
            Intrinsics.checkNotNullParameter((Object)item2, (String)"item");
            this(player, item2, false, 4, null);
        }
    }
}

