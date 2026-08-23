/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.world.entity.Entity
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.registry.util;

import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Entity;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.ClientPlayerDSLKt;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.EntityEvents;
import net.thebrokenscript.brokencore.api.event.game.PlayerEvents;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.brokencore.impl.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@SideOnly(side=Side.CLIENT)
@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0006J\u0006\u0010\u0012\u001a\u00020\rR\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/util/ChaseSightTracker;", "", "<init>", "()V", "spotted", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "hasSeen", "", "entity", "Lnet/minecraft/world/entity/Entity;", "update", "", "player", "Lnet/minecraft/client/player/LocalPlayer;", "clear", "entityId", "clearAll", "brokencore-common"})
public final class ChaseSightTracker {
    @NotNull
    public static final ChaseSightTracker INSTANCE = new ChaseSightTracker();
    @NotNull
    private static final HashSet<Integer> spotted;

    private ChaseSightTracker() {
    }

    public final boolean hasSeen(@NotNull Entity entity) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        return spotted.contains(entity.getId());
    }

    public final void update(@NotNull Entity entity, @NotNull LocalPlayer player) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        if (spotted.contains(entity.getId())) {
            return;
        }
        if (ClientPlayerDSLKt.isEntityInFovCone$default(player, entity, null, 2, null) && player.hasLineOfSight(entity)) {
            spotted.add(entity.getId());
        }
    }

    public final void clear(int entityId) {
        spotted.remove(entityId);
    }

    public final void clearAll() {
        spotted.clear();
    }

    private static final Unit _init_$lambda$0(EntityEvents.Spawn $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        LocalPlayer localPlayer = ClientDSLKt.getMC().player;
        if (Intrinsics.areEqual((Object)$this$on.getEntity().getUUID(), (Object)(localPlayer != null ? localPlayer.getUUID() : null))) {
            INSTANCE.clearAll();
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$1(PlayerEvents.ChangeDimensionClient $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        INSTANCE.clearAll();
        return Unit.INSTANCE;
    }

    static {
        GameEvent.Companion.on(EntityEvents.SPAWN, ChaseSightTracker::_init_$lambda$0);
        GameEvent.Companion.on(PlayerEvents.CHANGE_DIMENSION_CLIENT, ChaseSightTracker::_init_$lambda$1);
        spotted = new HashSet();
    }
}

