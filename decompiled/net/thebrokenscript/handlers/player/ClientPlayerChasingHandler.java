/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Mob
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.event.GameEvent
 *  net.thebrokenscript.brokencore.api.event.game.ClientEvents
 *  net.thebrokenscript.brokencore.api.event.game.ClientEvents$Data
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.player;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.ClientEvents;
import net.thebrokenscript.misc.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/handlers/player/ClientPlayerChasingHandler;", "", "<init>", "()V", "isBeingChased", "", "onTick", "", "mc", "Lnet/minecraft/client/Minecraft;", "thebrokenscript-common"})
public final class ClientPlayerChasingHandler {
    @NotNull
    public static final ClientPlayerChasingHandler INSTANCE = new ClientPlayerChasingHandler();
    @JvmField
    public static boolean isBeingChased;

    private ClientPlayerChasingHandler() {
    }

    public final void onTick(@NotNull Minecraft mc) {
        Intrinsics.checkNotNullParameter((Object)mc, (String)"mc");
        ClientLevel clientLevel = mc.level;
        if (clientLevel == null) {
            return;
        }
        ClientLevel level = clientLevel;
        LocalPlayer localPlayer = mc.player;
        if (localPlayer == null) {
            return;
        }
        LocalPlayer player = localPlayer;
        boolean targetting = false;
        for (Entity entity : level.entitiesForRendering()) {
            String namespace = BuiltInRegistries.ENTITY_TYPE.getKey((Object)entity.getType()).getNamespace();
            if (!Intrinsics.areEqual((Object)namespace, (Object)"thebrokenscript") || !(entity instanceof Mob) || ((Mob)entity).isNoAi()) continue;
            UUID targetUUID = EntityUtil.clientTargetUUID((Entity)entity);
            if (!Intrinsics.areEqual((Object)player.getUUID(), (Object)targetUUID)) continue;
            targetting = true;
            break;
        }
        if (isBeingChased != targetting) {
            isBeingChased = targetting;
        }
    }

    private static final Unit _init_$lambda$0(ClientEvents.Data $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        INSTANCE.onTick(ClientDSLKt.getMC());
        return Unit.INSTANCE;
    }

    static {
        GameEvent.Companion.on(ClientEvents.TICK_END, ClientPlayerChasingHandler::_init_$lambda$0);
    }
}

