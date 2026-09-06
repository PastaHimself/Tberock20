/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.client.resources.language.I18n
 *  net.minecraft.network.chat.Component
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.ComponentUtil
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.event.GameEvent
 *  net.thebrokenscript.brokencore.api.event.game.ClientEvents
 *  net.thebrokenscript.brokencore.api.event.game.ClientEvents$Data
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.ComponentUtil;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.ClientEvents;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.entity.circuit.CircuitEntity;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSLang;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/handlers/player/CircuitWindowRenamer;", "", "<init>", "()V", "onPlayerTick", "", "mc", "Lnet/minecraft/client/Minecraft;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nCircuitWindowRenamer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CircuitWindowRenamer.kt\nnet/thebrokenscript/handlers/player/CircuitWindowRenamer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,45:1\n808#2,11:46\n1761#2,3:57\n*S KotlinDebug\n*F\n+ 1 CircuitWindowRenamer.kt\nnet/thebrokenscript/handlers/player/CircuitWindowRenamer\n*L\n34#1:46,11\n38#1:57,3\n*E\n"})
public final class CircuitWindowRenamer {
    @NotNull
    public static final CircuitWindowRenamer INSTANCE = new CircuitWindowRenamer();

    private CircuitWindowRenamer() {
    }

    /*
     * WARNING - void declaration
     */
    private final void onPlayerTick(Minecraft mc) {
        boolean bl;
        LocalPlayer player;
        ClientLevel level;
        block12: {
            Collection destination$iv$iv;
            ClientLevel clientLevel = mc.level;
            if (clientLevel == null) {
                return;
            }
            level = clientLevel;
            LocalPlayer localPlayer = mc.player;
            if (localPlayer == null) {
                return;
            }
            player = localPlayer;
            if (player.isSpectator()) {
                return;
            }
            Object object = ClientDSLKt.getMC().level;
            if (object != null && (object = object.entitiesForRendering()) != null) {
                void $this$filterIsInstanceTo$iv$iv;
                Object $this$filterIsInstance$iv = object;
                boolean $i$f$filterIsInstance = false;
                Object object2 = $this$filterIsInstance$iv;
                destination$iv$iv = new ArrayList();
                boolean $i$f$filterIsInstanceTo = false;
                for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
                    if (!(element$iv$iv instanceof CircuitEntity)) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
            } else {
                return;
            }
            List circuits = (List)destination$iv$iv;
            if (circuits.isEmpty()) {
                return;
            }
            Iterable $this$any$iv = circuits;
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    CircuitEntity it = (CircuitEntity)((Object)element$iv);
                    boolean bl2 = false;
                    if (!Intrinsics.areEqual((Object)EntityUtil.clientTargetUUID((Entity)((Entity)it)), (Object)player.getUUID())) continue;
                    bl = true;
                    break block12;
                }
                bl = false;
            }
        }
        if (!bl) {
            return;
        }
        if (level.getGameTime() % 5L != 0L) {
            return;
        }
        Player player2 = (Player)player;
        String string = ComponentUtil.getTranslationKey((Component)((Component)TBSLang.INSTANCE.getNO_ESCAPE_TITLE()));
        Intrinsics.checkNotNull((Object)string);
        String string2 = I18n.get((String)string, (Object[])new Object[0]);
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"get(...)");
        PlayerExt.INSTANCE.trySetWindowTitle(player2, string2);
    }

    private static final Unit _init_$lambda$0(ClientEvents.Data $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        INSTANCE.onPlayerTick(ClientDSLKt.getMC());
        return Unit.INSTANCE;
    }

    static {
        GameEvent.Companion.on(ClientEvents.TICK_END, CircuitWindowRenamer::_init_$lambda$0);
    }
}

