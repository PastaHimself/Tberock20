/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.BedBlock
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.event.GameEvent
 *  net.thebrokenscript.brokencore.api.event.game.PlayerEvents
 *  net.thebrokenscript.brokencore.api.event.game.PlayerEvents$ChangeDimension
 *  net.thebrokenscript.brokencore.api.event.game.PlayerEvents$InteractBlock
 *  net.thebrokenscript.brokencore.api.learner.util.PlayerBase
 *  net.thebrokenscript.brokencore.api.learner.util.UnfinalizedPlayerBase
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.data;

import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.PlayerEvents;
import net.thebrokenscript.brokencore.api.learner.util.PlayerBase;
import net.thebrokenscript.brokencore.api.learner.util.UnfinalizedPlayerBase;
import net.thebrokenscript.handlers.subs.PlayerCloneSubscriber;
import net.thebrokenscript.handlers.subs.PlayerLoggedInSubscriber;
import net.thebrokenscript.handlers.subs.PlayerLoggedOutSubscriber;
import net.thebrokenscript.handlers.subs.PlayerRespawnSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSDataAttachments;
import net.thebrokenscript.util.InteractionTracker;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J,\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/data/PlayerVarsSyncer;", "", "<init>", "()V", "unfinalizedBases", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lnet/thebrokenscript/brokencore/api/learner/util/UnfinalizedPlayerBase;", "getUnfinalizedBases$thebrokenscript_common", "()Ljava/util/concurrent/ConcurrentLinkedQueue;", "setUnfinalizedBases$thebrokenscript_common", "(Ljava/util/concurrent/ConcurrentLinkedQueue;)V", "onPlayerLoggedIn", "", "player", "Lnet/minecraft/world/entity/player/Player;", "onPlayerLoggedOut", "clonePlayer", "orig", "new", "onPlayerRespawned", "onPlayerChangedDimension", "to", "Lnet/minecraft/resources/ResourceKey;", "Lnet/minecraft/world/level/Level;", "from", "thebrokenscript-common"})
public final class PlayerVarsSyncer {
    @NotNull
    public static final PlayerVarsSyncer INSTANCE = new PlayerVarsSyncer();
    @NotNull
    private static ConcurrentLinkedQueue<UnfinalizedPlayerBase> unfinalizedBases = new ConcurrentLinkedQueue();

    private PlayerVarsSyncer() {
    }

    @NotNull
    public final ConcurrentLinkedQueue<UnfinalizedPlayerBase> getUnfinalizedBases$thebrokenscript_common() {
        return unfinalizedBases;
    }

    public final void setUnfinalizedBases$thebrokenscript_common(@NotNull ConcurrentLinkedQueue<UnfinalizedPlayerBase> concurrentLinkedQueue) {
        Intrinsics.checkNotNullParameter(concurrentLinkedQueue, (String)"<set-?>");
        unfinalizedBases = concurrentLinkedQueue;
    }

    private final void onPlayerLoggedIn(Player player) {
        ServerPlayer serverPlayer = player instanceof ServerPlayer ? (ServerPlayer)player : null;
        if (serverPlayer == null) {
            return;
        }
        ServerPlayer player2 = serverPlayer;
        Level level = player2.level();
        Intrinsics.checkNotNullExpressionValue((Object)level, (String)"level(...)");
        LevelExt.INSTANCE.syncVarsTo((LevelAccessor)level, player2);
        PlayerExt.INSTANCE.syncVars((Player)player2);
    }

    private final void onPlayerLoggedOut(Player player) {
        PlayerExt.INSTANCE.getInteractionTracker(player).save(player);
    }

    private final void clonePlayer(Player orig, Player player) {
        PlayerExt.INSTANCE.setVars(player, PlayerExt.INSTANCE.getVars(orig));
    }

    private final void onPlayerRespawned(Player player) {
        PlayerExt.INSTANCE.syncVars(player);
    }

    private final void onPlayerChangedDimension(Player player, ResourceKey<Level> to, ResourceKey<Level> from) {
        PlayerExt.INSTANCE.syncVars(player);
    }

    private static final Unit _init_$lambda$0(PlayerEvents.ChangeDimension $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        PlayerExt.INSTANCE.syncVars((Player)$this$on.getPlayer());
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$1(PlayerEvents.InteractBlock $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        Level level = $this$on.getPlayer().level();
        InteractionTracker interactionTracker = PlayerExt.INSTANCE.getInteractionTracker($this$on.getPlayer());
        long l = level.getGameTime();
        BlockPos blockPos = $this$on.getHitResult().getBlockPos();
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"getBlockPos(...)");
        Vec3 vec3 = $this$on.getPlayer().position();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
        Intrinsics.checkNotNull((Object)level);
        interactionTracker.track(l, blockPos, vec3, level);
        if (PlayerExt.INSTANCE.getVars($this$on.getPlayer()).getBaseRescanCooldown() <= 0 && level.getBlockState($this$on.getHitResult().getBlockPos()).getBlock() instanceof BedBlock) {
            PlayerExt.INSTANCE.getVars($this$on.getPlayer()).setBaseRescanCooldown(6000);
            BlockPos blockPos2 = $this$on.getHitResult().getBlockPos();
            Intrinsics.checkNotNullExpressionValue((Object)blockPos2, (String)"getBlockPos(...)");
            unfinalizedBases.offer(PlayerBase.Companion.scanAt(blockPos2, level, arg_0 -> PlayerVarsSyncer.lambda$1$0($this$on, arg_0)));
        }
        return Unit.INSTANCE;
    }

    private static final Unit lambda$1$0(PlayerEvents.InteractBlock $this_on, PlayerBase it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        TBSDataAttachments.PLAYER_BASE.set((Entity)$this_on.getPlayer(), (Object)it);
        return Unit.INSTANCE;
    }

    static {
        GameEvent.Companion.on(PlayerEvents.CHANGE_DIMENSION, PlayerVarsSyncer::_init_$lambda$0);
        GameEvent.Companion.on(PlayerEvents.INTERACT_BLOCK, PlayerVarsSyncer::_init_$lambda$1);
        PlayerLoggedInSubscriber.INSTANCE.add((Function1<? super Player, Unit>)((Function1)new Function1<Player, Unit>((Object)INSTANCE){

            public final void invoke(Player p0) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                ((PlayerVarsSyncer)this.receiver).onPlayerLoggedIn(p0);
            }
        }));
        PlayerLoggedOutSubscriber.INSTANCE.add((Function1<? super Player, Unit>)((Function1)new Function1<Player, Unit>((Object)INSTANCE){

            public final void invoke(Player p0) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                ((PlayerVarsSyncer)this.receiver).onPlayerLoggedOut(p0);
            }
        }));
        PlayerRespawnSubscriber.INSTANCE.add((Function1<? super Player, Unit>)((Function1)new Function1<Player, Unit>((Object)INSTANCE){

            public final void invoke(Player p0) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                ((PlayerVarsSyncer)this.receiver).onPlayerRespawned(p0);
            }
        }));
        PlayerCloneSubscriber.INSTANCE.add((Function2<? super Player, ? super Player, Unit>)((Function2)new Function2<Player, Player, Unit>((Object)INSTANCE){

            public final void invoke(Player p0, Player p1) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                Intrinsics.checkNotNullParameter((Object)p1, (String)"p1");
                ((PlayerVarsSyncer)this.receiver).clonePlayer(p0, p1);
            }
        }));
    }
}

