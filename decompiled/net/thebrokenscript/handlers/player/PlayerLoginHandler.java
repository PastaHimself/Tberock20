/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.player;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.handlers.subs.PlayerLoggedInSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/handlers/player/PlayerLoginHandler;", "", "<init>", "()V", "onPlayerLoggedIn", "", "player", "Lnet/minecraft/world/entity/player/Player;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nPlayerLoginHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayerLoginHandler.kt\nnet/thebrokenscript/handlers/player/PlayerLoginHandler\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,30:1\n478#2:31\n424#2:32\n1252#3,4:33\n*S KotlinDebug\n*F\n+ 1 PlayerLoginHandler.kt\nnet/thebrokenscript/handlers/player/PlayerLoginHandler\n*L\n24#1:31\n24#1:32\n24#1:33,4\n*E\n"})
public final class PlayerLoginHandler {
    @NotNull
    public static final PlayerLoginHandler INSTANCE = new PlayerLoginHandler();

    private PlayerLoginHandler() {
    }

    /*
     * WARNING - void declaration
     */
    private final void onPlayerLoggedIn(Player player) {
        void $this$associateByTo$iv$iv$iv;
        void $this$mapKeysTo$iv$iv;
        Object object = new Pair[]{TuplesKt.to((Object)"xXram2dieXx", (Object)"Player is already playing on this server."), TuplesKt.to((Object)"DyeXD412", (Object)"Player is already playing on this server."), TuplesKt.to((Object)"null", (Object)"Player is already playing on this server."), TuplesKt.to((Object)"Integrity", (Object)"I am watching you."), TuplesKt.to((Object)"Modrome", (Object)"I am right behind you <o>"), TuplesKt.to((Object)"dyaoff", (Object)"You are not welcome here")};
        Map $this$mapKeys$iv = MapsKt.mapOf((Pair[])object);
        boolean $i$f$mapKeys = false;
        Map map = $this$mapKeys$iv;
        Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity((int)$this$mapKeys$iv.size()));
        boolean $i$f$mapKeysTo = false;
        Iterable iterable = $this$mapKeysTo$iv$iv.entrySet();
        Map destination$iv$iv$iv = destination$iv$iv;
        boolean $i$f$associateByTo = false;
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            String string;
            void it$iv$iv;
            void it;
            Map.Entry entry = (Map.Entry)element$iv$iv$iv;
            Map map2 = destination$iv$iv$iv;
            boolean bl = false;
            Intrinsics.checkNotNullExpressionValue((Object)((String)it.getKey()).toLowerCase(Locale.ROOT), (String)"toLowerCase(...)");
            Map.Entry entry2 = (Map.Entry)element$iv$iv$iv;
            Map map3 = map2;
            boolean bl2 = false;
            entry = it$iv$iv.getValue();
            map3.put(string, entry);
        }
        Map responses = destination$iv$iv$iv;
        if (player instanceof ServerPlayer) {
            object = responses;
            Component component = ((ServerPlayer)player).getDisplayName();
            Intrinsics.checkNotNull((Object)component);
            String string = component.getString();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getString(...)");
            String string2 = string.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"toLowerCase(...)");
            if (object.containsKey(string2)) {
                ServerPlayer serverPlayer = (ServerPlayer)player;
                Component component2 = ((ServerPlayer)player).getDisplayName();
                Intrinsics.checkNotNull((Object)component2);
                Object v = responses.get(component2.getString());
                Intrinsics.checkNotNull(v);
                MutableComponent mutableComponent = Component.literal((String)((String)v));
                Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"literal(...)");
                PlayerUtil.kick((ServerPlayer)serverPlayer, (Component)((Component)mutableComponent));
            }
        }
    }

    static {
        PlayerLoggedInSubscriber.INSTANCE.add((Function1<? super Player, Unit>)((Function1)new Function1<Player, Unit>((Object)INSTANCE){

            public final void invoke(Player p0) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                ((PlayerLoginHandler)this.receiver).onPlayerLoggedIn(p0);
            }
        }));
    }
}

