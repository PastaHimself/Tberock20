/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.KeyMapping
 *  net.minecraft.client.gui.screens.Screen
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.handlers;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.gui.screens.Screen;
import net.thebrokenscript.brokencore.api.client.cutscene_editor.CutsceneEditorScreen;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.ClientEvents;
import net.thebrokenscript.brokencore.api.platform.PlatformKeyBindings;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.brokencore.impl.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/brokencore/impl/handlers/KeyHandlers;", "", "<init>", "()V", "brokencore-common"})
public final class KeyHandlers {
    @NotNull
    public static final KeyHandlers INSTANCE = new KeyHandlers();

    private KeyHandlers() {
    }

    private static final Unit _init_$lambda$0(ClientEvents.Data $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        while (((KeyMapping)PlatformKeyBindings.Companion.getOpenCutsceneEditor().getValue()).consumeClick()) {
            if (ClientDSLKt.getMC().screen instanceof CutsceneEditorScreen) {
                ClientDSLKt.getMC().screen = null;
                continue;
            }
            ClientDSLKt.getMC().setScreen((Screen)new CutsceneEditorScreen());
        }
        return Unit.INSTANCE;
    }

    static {
        GameEvent.Companion.on(ClientEvents.TICK_END, KeyHandlers::_init_$lambda$0);
    }
}

