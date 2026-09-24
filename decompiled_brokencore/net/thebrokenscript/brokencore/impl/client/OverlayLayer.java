/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.DeltaTracker
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.LayeredDraw$Layer
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.client.overlay.AnimatedOverlayRenderer;
import net.thebrokenscript.brokencore.api.client.overlay.OverlayRenderer;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.brokencore.impl.compat.vivecraft.VRInterface;
import org.jetbrains.annotations.NotNull;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\b\u0010\u0011\u001a\u00020\bH\u0007J\u0006\u0010\u0012\u001a\u00020\bJ\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/brokencore/impl/client/OverlayLayer;", "Lnet/minecraft/client/gui/LayeredDraw$Layer;", "<init>", "()V", "activeOverlays", "", "Lnet/thebrokenscript/brokencore/api/client/overlay/OverlayRenderer;", "activateOverlay", "", "texture", "Lnet/minecraft/resources/ResourceLocation;", "ticks", "", "forceActivateAnimatedOverlay", "overlay", "Lnet/thebrokenscript/brokencore/api/client/overlay/AnimatedOverlayRenderer;", "getActiveOverlays", "clearOverlays", "tick", "render", "g", "Lnet/minecraft/client/gui/GuiGraphics;", "deltaTracker", "Lnet/minecraft/client/DeltaTracker;", "actuallyRender", "brokencore-common"})
public final class OverlayLayer
implements LayeredDraw.Layer {
    @NotNull
    public static final OverlayLayer INSTANCE = new OverlayLayer();
    @NotNull
    private static final List<OverlayRenderer> activeOverlays = new ArrayList();

    private OverlayLayer() {
    }

    @JvmStatic
    public static final synchronized void activateOverlay(@NotNull ResourceLocation texture, long ticks) {
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        ((Collection)activeOverlays).add(AnimatedOverlayRenderer.Companion.hasAnimationDef(texture) ? (OverlayRenderer)new AnimatedOverlayRenderer(texture, ticks) : new OverlayRenderer(texture, ticks));
    }

    @JvmStatic
    public static final synchronized void forceActivateAnimatedOverlay(@NotNull AnimatedOverlayRenderer overlay) {
        Intrinsics.checkNotNullParameter((Object)overlay, (String)"overlay");
        ((Collection)activeOverlays).add(overlay);
    }

    @NotNull
    public final List<OverlayRenderer> getActiveOverlays() {
        return activeOverlays;
    }

    @JvmStatic
    public static final void clearOverlays() {
        activeOverlays.clear();
    }

    public final void tick() {
        for (OverlayRenderer overlay : activeOverlays) {
            overlay.tick();
        }
    }

    public void render(@NotNull GuiGraphics g, @NotNull DeltaTracker deltaTracker) {
        Intrinsics.checkNotNullParameter((Object)g, (String)"g");
        Intrinsics.checkNotNullParameter((Object)deltaTracker, (String)"deltaTracker");
        VRInterface vRInterface = VRInterface.Companion.getInstance();
        boolean bl = vRInterface != null ? vRInterface.isVrEnabled() : false;
        if (bl) {
            return;
        }
        this.actuallyRender(g);
    }

    public final void actuallyRender(@NotNull GuiGraphics g) {
        Intrinsics.checkNotNullParameter((Object)g, (String)"g");
        RenderSystem.enableBlend();
        int w = g.guiWidth();
        int h = g.guiHeight();
        List removalQueue = new ArrayList();
        for (OverlayRenderer overlay : activeOverlays) {
            if (overlay.isComplete()) {
                removalQueue.add(overlay);
            }
            overlay.render(g, w, h);
        }
        activeOverlays.removeAll(removalQueue);
        RenderSystem.disableBlend();
    }
}

