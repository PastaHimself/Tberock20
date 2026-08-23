/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.client.renderer.PostChain
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.thebrokenscript.brokencore.api.client.shader.PostShaderManager
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.ClientPlayerDSLKt
 *  net.thebrokenscript.brokencore.api.event.GameEvent
 *  net.thebrokenscript.brokencore.api.event.game.ClientEvents
 *  net.thebrokenscript.brokencore.api.event.game.ClientEvents$Data
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.PostChain;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.client.shader.PostShaderManager;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.ClientPlayerDSLKt;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.ClientEvents;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSEntities;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/handlers/client/ClientFeverHandler;", "", "<init>", "()V", "RANGE", "", "MAX_STARE_TICKS", "RAMP_PER_SECOND", "DECAY_PER_SECOND", "EASE_POWER", "lastUpdateNanos", "", "staredTicks", "Ljava/util/WeakHashMap;", "Lnet/minecraft/world/entity/player/Player;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nClientFeverHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClientFeverHandler.kt\nnet/thebrokenscript/handlers/client/ClientFeverHandler\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,81:1\n774#2:82\n865#2,2:83\n774#2:85\n865#2,2:86\n774#2:88\n865#2,2:89\n*S KotlinDebug\n*F\n+ 1 ClientFeverHandler.kt\nnet/thebrokenscript/handlers/client/ClientFeverHandler\n*L\n56#1:82\n56#1:83,2\n57#1:85\n57#1:86,2\n58#1:88\n58#1:89,2\n*E\n"})
public final class ClientFeverHandler {
    @NotNull
    public static final ClientFeverHandler INSTANCE = new ClientFeverHandler();
    private static final float RANGE = 130.0f;
    private static final float MAX_STARE_TICKS = 75.0f;
    private static final float RAMP_PER_SECOND = 12.5f;
    private static final float DECAY_PER_SECOND = 10.0f;
    private static final float EASE_POWER = 2.0f;
    private static long lastUpdateNanos;
    @NotNull
    private static final WeakHashMap<Player, Float> staredTicks;

    private ClientFeverHandler() {
    }

    private static final Unit _init_$lambda$0(ClientEvents.Data $this$on) {
        Entity it;
        Iterable $this$filterTo$iv$iv;
        Iterable $this$filter$iv;
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        LocalPlayer localPlayer = ClientDSLKt.getMC().player;
        if (localPlayer == null) {
            ClientEvents.Data $this$lambda_u240_u240 = $this$on;
            boolean bl = false;
            PostShaderManager.INSTANCE.setEnabled(TBSConstants.id("shaders/post/fever.json"), false);
            return Unit.INSTANCE;
        }
        LocalPlayer player = localPlayer;
        ClientLevel level = ClientDSLKt.getMC().level;
        PostChain fx = PostShaderManager.INSTANCE.get(TBSConstants.id("shaders/post/fever.json"));
        if (level == null || fx == null) {
            return Unit.INSTANCE;
        }
        if (ClientDSLKt.getMC().isPaused()) {
            lastUpdateNanos = 0L;
            Float frozen = staredTicks.getOrDefault(player, Float.valueOf(0.0f));
            if (frozen.floatValue() <= 0.0f) {
                PostShaderManager.INSTANCE.setEnabled(TBSConstants.id("shaders/post/fever.json"), false);
                return Unit.INSTANCE;
            }
            PostShaderManager.INSTANCE.setEnabled(TBSConstants.id("shaders/post/fever.json"), true);
            float linear = frozen.floatValue() / 75.0f;
            fx.setUniform("Strength", (float)Math.pow(linear, 2.0f));
            return Unit.INSTANCE;
        }
        fx.setUniform("CustomTime", (float)level.getGameTime() % 1200.0f);
        Iterable iterable = level.entitiesForRendering();
        Intrinsics.checkNotNullExpressionValue((Object)iterable, (String)"entitiesForRendering(...)");
        Iterable linear = iterable;
        boolean $i$f$filter = false;
        void var7_12 = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            it = (Entity)element$iv$iv;
            boolean bl = false;
            if (!Intrinsics.areEqual((Object)it.getType(), (Object)TBSEntities.FEVER.get())) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $this$filter$iv = (List)destination$iv$iv;
        $i$f$filter = false;
        $this$filterTo$iv$iv = $this$filter$iv;
        destination$iv$iv = new ArrayList();
        $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            it = (Entity)element$iv$iv;
            boolean bl = false;
            if (!(player.distanceTo(it) <= 130.0f)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $this$filter$iv = (List)destination$iv$iv;
        $i$f$filter = false;
        $this$filterTo$iv$iv = $this$filter$iv;
        destination$iv$iv = new ArrayList();
        $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            it = (Entity)element$iv$iv;
            boolean bl = false;
            Intrinsics.checkNotNull((Object)it);
            if (!ClientPlayerDSLKt.isEntityInFovCone((LocalPlayer)player, (Entity)it, (Double)75.0)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        List fever = (List)destination$iv$iv;
        long now = System.nanoTime();
        float deltaSeconds = lastUpdateNanos == 0L ? 0.0f : RangesKt.coerceAtMost((float)((float)(now - lastUpdateNanos) / 1.0E9f), (float)0.1f);
        lastUpdateNanos = now;
        Float current = staredTicks.getOrDefault(player, Float.valueOf(0.0f));
        float updated = !((Collection)fever).isEmpty() ? RangesKt.coerceAtMost((float)(current.floatValue() + 12.5f * deltaSeconds), (float)75.0f) : RangesKt.coerceAtLeast((float)(current.floatValue() - 10.0f * deltaSeconds), (float)0.0f);
        ((Map)staredTicks).put(player, Float.valueOf(updated));
        if (updated <= 0.0f) {
            PostShaderManager.INSTANCE.setEnabled(TBSConstants.id("shaders/post/fever.json"), false);
            return Unit.INSTANCE;
        }
        PostShaderManager.INSTANCE.setEnabled(TBSConstants.id("shaders/post/fever.json"), true);
        float linear2 = updated / 75.0f;
        float strength = (float)Math.pow(linear2, 2.0f);
        fx.setUniform("Strength", strength);
        return Unit.INSTANCE;
    }

    static {
        staredTicks = new WeakHashMap();
        GameEvent.Companion.on(ClientEvents.TICK_END, ClientFeverHandler::_init_$lambda$0);
    }
}

