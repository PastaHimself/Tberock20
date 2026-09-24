/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.DeltaTracker
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.LayeredDraw$Layer
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.client.debug;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import org.jetbrains.annotations.NotNull;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/client/debug/TBSDebugOverlays;", "Lnet/minecraft/client/gui/LayeredDraw$Layer;", "<init>", "()V", "render", "", "gg", "Lnet/minecraft/client/gui/GuiGraphics;", "deltaTracker", "Lnet/minecraft/client/DeltaTracker;", "thebrokenscript-common"})
public final class TBSDebugOverlays
implements LayeredDraw.Layer {
    @NotNull
    public static final TBSDebugOverlays INSTANCE = new TBSDebugOverlays();

    private TBSDebugOverlays() {
    }

    public void render(@NotNull GuiGraphics gg, @NotNull DeltaTracker deltaTracker) {
        Intrinsics.checkNotNullParameter((Object)gg, (String)"gg");
        Intrinsics.checkNotNullParameter((Object)deltaTracker, (String)"deltaTracker");
        if (ClientDSLKt.getMC().player == null) {
            return;
        }
    }
}

