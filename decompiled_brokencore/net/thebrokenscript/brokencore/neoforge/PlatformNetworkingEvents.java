/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.EventBusSubscriber
 *  net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent
 *  net.neoforged.neoforge.network.registration.PayloadRegistrar
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.neoforge;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0007R&\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/brokencore/neoforge/PlatformNetworkingEvents;", "", "<init>", "()V", "registrationQueue", "", "Lkotlin/Function1;", "Lnet/neoforged/neoforge/network/registration/PayloadRegistrar;", "", "getRegistrationQueue$brokencore_neoforge", "()Ljava/util/List;", "register", "event", "Lnet/neoforged/neoforge/network/event/RegisterPayloadHandlersEvent;", "brokencore-neoforge"})
public final class PlatformNetworkingEvents {
    @NotNull
    public static final PlatformNetworkingEvents INSTANCE = new PlatformNetworkingEvents();
    @NotNull
    private static final List<Function1<PayloadRegistrar, Unit>> registrationQueue = new ArrayList();

    private PlatformNetworkingEvents() {
    }

    @NotNull
    public final List<Function1<PayloadRegistrar, Unit>> getRegistrationQueue$brokencore_neoforge() {
        return registrationQueue;
    }

    @JvmStatic
    @SubscribeEvent
    public static final void register(@NotNull RegisterPayloadHandlersEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        PayloadRegistrar registrar = event.registrar("1");
        for (Function1<PayloadRegistrar, Unit> func : registrationQueue) {
            Intrinsics.checkNotNull((Object)registrar);
            func.invoke((Object)registrar);
        }
    }
}

