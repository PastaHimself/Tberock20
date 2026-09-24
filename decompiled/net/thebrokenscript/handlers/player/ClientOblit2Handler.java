/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.client.overlay.AnimatedOverlayRenderer
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.event.GameEvent
 *  net.thebrokenscript.brokencore.api.event.game.ClientEvents
 *  net.thebrokenscript.brokencore.api.event.game.ClientEvents$Data
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  net.thebrokenscript.brokencore.impl.client.OverlayLayer
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.player;

import java.util.Collection;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.client.overlay.AnimatedOverlayRenderer;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.ClientEvents;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.brokencore.impl.client.OverlayLayer;
import net.thebrokenscript.entity.oblit.Obliteration2Entity;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSEntities;
import org.jetbrains.annotations.NotNull;

@SideOnly(side=Side.CLIENT)
@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/handlers/player/ClientOblit2Handler;", "", "<init>", "()V", "overlay", "Lnet/thebrokenscript/brokencore/api/client/overlay/AnimatedOverlayRenderer;", "getOverlay", "()Lnet/thebrokenscript/brokencore/api/client/overlay/AnimatedOverlayRenderer;", "overlay$delegate", "Lkotlin/Lazy;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nClientOblit2Handler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClientOblit2Handler.kt\nnet/thebrokenscript/handlers/player/ClientOblit2Handler\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,37:1\n1788#2,4:38\n*S KotlinDebug\n*F\n+ 1 ClientOblit2Handler.kt\nnet/thebrokenscript/handlers/player/ClientOblit2Handler\n*L\n25#1:38,4\n*E\n"})
public final class ClientOblit2Handler {
    @NotNull
    public static final ClientOblit2Handler INSTANCE = new ClientOblit2Handler();
    @NotNull
    private static final Lazy overlay$delegate = LazyKt.lazy(ClientOblit2Handler::overlay_delegate$lambda$0);

    private ClientOblit2Handler() {
    }

    private final AnimatedOverlayRenderer getOverlay() {
        Lazy lazy = overlay$delegate;
        return (AnimatedOverlayRenderer)lazy.getValue();
    }

    private static final AnimatedOverlayRenderer overlay_delegate$lambda$0() {
        return new AnimatedOverlayRenderer(TBSConstants.id("textures/screens/oblit_2_effect.png"), 0L);
    }

    private static final Unit _init_$lambda$0(ClientEvents.Data $this$on) {
        int oblitCount;
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        LocalPlayer localPlayer = ClientDSLKt.getMC().player;
        if (localPlayer == null) {
            return Unit.INSTANCE;
        }
        LocalPlayer player = localPlayer;
        ClientLevel clientLevel = ClientDSLKt.getMC().level;
        if (clientLevel == null) {
            return Unit.INSTANCE;
        }
        ClientLevel level = clientLevel;
        Iterable iterable = level.entitiesForRendering();
        Intrinsics.checkNotNullExpressionValue((Object)iterable, (String)"entitiesForRendering(...)");
        Iterable $this$count$iv = iterable;
        boolean $i$f$count = false;
        if ($this$count$iv instanceof Collection && ((Collection)$this$count$iv).isEmpty()) {
            v3 = 0;
        } else {
            int count$iv = 0;
            for (Object element$iv : $this$count$iv) {
                Entity it = (Entity)element$iv;
                boolean bl = false;
                if (!Intrinsics.areEqual((Object)it.getType(), (Object)TBSEntities.THE_OBLITERATION_2.get()) || ++count$iv >= 0) continue;
                CollectionsKt.throwCountOverflow();
            }
            v3 = oblitCount = count$iv;
        }
        if (oblitCount == 0) {
            return Unit.INSTANCE;
        }
        LevelAccessor levelAccessor = (LevelAccessor)level;
        Vec3 vec3 = player.position();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
        Obliteration2Entity obliteration2Entity = (Obliteration2Entity)EntityFinder.findClosestEntityInRange((LevelAccessor)levelAccessor, Obliteration2Entity.class, (Vec3)vec3, (Number)150);
        if (obliteration2Entity == null) {
            return Unit.INSTANCE;
        }
        Obliteration2Entity oblit2 = obliteration2Entity;
        if (player.getBoundingBox().intersects(oblit2.underneathBox()) && !OverlayLayer.INSTANCE.getActiveOverlays().contains(INSTANCE.getOverlay())) {
            INSTANCE.getOverlay().reset();
            OverlayLayer.forceActivateAnimatedOverlay((AnimatedOverlayRenderer)INSTANCE.getOverlay());
        }
        return Unit.INSTANCE;
    }

    static {
        GameEvent.Companion.on(ClientEvents.TICK_END, ClientOblit2Handler::_init_$lambda$0);
    }
}

