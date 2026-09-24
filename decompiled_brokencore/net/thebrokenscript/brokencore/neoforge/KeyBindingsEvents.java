/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.KeyMapping
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.EventBusSubscriber
 *  net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.neoforge;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.thebrokenscript.brokencore.neoforge.PlatformKeyBindingsImpl;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber(value={Dist.CLIENT})
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/neoforge/KeyBindingsEvents;", "", "<init>", "()V", "registerBindings", "", "event", "Lnet/neoforged/neoforge/client/event/RegisterKeyMappingsEvent;", "brokencore-neoforge"})
public final class KeyBindingsEvents {
    @NotNull
    public static final KeyBindingsEvents INSTANCE = new KeyBindingsEvents();

    private KeyBindingsEvents() {
    }

    @JvmStatic
    @SubscribeEvent
    public static final void registerBindings(@NotNull RegisterKeyMappingsEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        event.register((KeyMapping)PlatformKeyBindingsImpl.Companion.getOPEN_CUTSCENE_EDITOR().getValue());
    }
}

