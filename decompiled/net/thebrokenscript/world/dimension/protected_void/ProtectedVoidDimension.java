/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.game.ClientboundPlayerPositionPacket
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.chunk.ChunkAccess
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  net.thebrokenscript.brokencore.api.event.GameEvent
 *  net.thebrokenscript.brokencore.api.event.game.PlayerEvents
 *  net.thebrokenscript.brokencore.api.event.game.PlayerEvents$ChangeDimension
 *  net.thebrokenscript.brokencore.api.queue.WorkQueue
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.world.dimension.protected_void;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundPlayerPositionPacket;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.TheBrokenScript;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.PlayerEvents;
import net.thebrokenscript.brokencore.api.queue.WorkQueue;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSDimensions;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/world/dimension/protected_void/ProtectedVoidDimension;", "", "<init>", "()V", "thebrokenscript-common"})
public final class ProtectedVoidDimension {
    @NotNull
    public static final ProtectedVoidDimension INSTANCE = new ProtectedVoidDimension();

    private ProtectedVoidDimension() {
    }

    private static final Unit _init_$lambda$0(PlayerEvents.ChangeDimension $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        if (!Intrinsics.areEqual((Object)$this$on.getTo(), TBSDimensions.PROTECTED_VOID)) {
            return Unit.INSTANCE;
        }
        if (PlayerExt.INSTANCE.getVars((Player)$this$on.getPlayer()).getFixPos()) {
            $this$on.getPlayer().getAbilities().flying = true;
            $this$on.getPlayer().getAbilities().mayfly = true;
            $this$on.getPlayer().onUpdateAbilities();
            $this$on.getPlayer().setDeltaMovement(Vec3.ZERO);
            WorkQueue.add$default((WorkQueue)TheBrokenScript.serverWorkQueue, (long)0L, () -> ProtectedVoidDimension.lambda$0$0($this$on), (int)1, null);
        }
        return Unit.INSTANCE;
    }

    private static final Unit lambda$0$0(PlayerEvents.ChangeDimension $this_on) {
        ChunkAccess chunkAccess = $this_on.getPlayer().level().getChunk($this_on.getPlayer().blockPosition());
        Intrinsics.checkNotNullExpressionValue((Object)chunkAccess, (String)"getChunk(...)");
        ChunkAccess chunk = chunkAccess;
        BlockPos blockPos = chunk.getPos().getWorldPosition().offset(11, 0, 6);
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"offset(...)");
        Vec3 targetPos = PositionUtil.withY((BlockPos)blockPos, (Number)71).getCenter();
        Entity entity = (Entity)$this_on.getPlayer();
        Intrinsics.checkNotNull((Object)targetPos);
        EntityUtil.teleport((Entity)entity, (Vec3)targetPos);
        $this_on.getPlayer().setYRot(180.0f);
        $this_on.getPlayer().setXRot(0.0f);
        $this_on.getPlayer().connection.send((Packet)new ClientboundPlayerPositionPacket(targetPos.x, targetPos.y, targetPos.z, 180.0f, 0.0f, SetsKt.emptySet(), 0));
        $this_on.getPlayer().getAbilities().flying = false;
        if (!$this_on.getPlayer().isCreative() && !$this_on.getPlayer().isSpectator()) {
            $this_on.getPlayer().getAbilities().mayfly = false;
        }
        $this_on.getPlayer().onUpdateAbilities();
        $this_on.getPlayer().setDeltaMovement(Vec3.ZERO);
        PlayerExt.INSTANCE.getVars((Player)$this_on.getPlayer()).setFixPos(false);
        PlayerExt.INSTANCE.syncVars((Player)$this_on.getPlayer());
        return Unit.INSTANCE;
    }

    static {
        GameEvent.Companion.on(PlayerEvents.CHANGE_DIMENSION, ProtectedVoidDimension::_init_$lambda$0);
    }
}

