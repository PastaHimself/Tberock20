/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.endec.Endec
 *  kotlin.Metadata
 *  kotlin.io.TextStreamsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.packs.resources.Resource
 *  net.minecraft.server.packs.resources.ResourceManager
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.overlay;

import io.wispforest.endec.Endec;
import java.io.BufferedReader;
import java.io.Reader;
import kotlin.Metadata;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.thebrokenscript.brokencore.api.client.overlay.OverlayRenderer;
import net.thebrokenscript.brokencore.api.client.resource.TexAnimDef;
import net.thebrokenscript.brokencore.api.ext.EndecExt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0006\u0010\u0019\u001a\u00020\u0010R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\f0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018\u00a8\u0006\u001b"}, d2={"Lnet/thebrokenscript/brokencore/api/client/overlay/AnimatedOverlayRenderer;", "Lnet/thebrokenscript/brokencore/api/client/overlay/OverlayRenderer;", "id", "Lnet/minecraft/resources/ResourceLocation;", "ticks", "", "<init>", "(Lnet/minecraft/resources/ResourceLocation;J)V", "mc", "Lnet/minecraft/client/Minecraft;", "kotlin.jvm.PlatformType", "resources", "Lnet/minecraft/server/packs/resources/ResourceManager;", "animDef", "Lnet/thebrokenscript/brokencore/api/client/resource/TexAnimDef;", "render", "", "graphics", "Lnet/minecraft/client/gui/GuiGraphics;", "w", "", "h", "isComplete", "", "()Z", "reset", "Companion", "brokencore-common"})
public final class AnimatedOverlayRenderer
extends OverlayRenderer {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final Minecraft mc;
    private final ResourceManager resources;
    @NotNull
    private final TexAnimDef animDef;

    public AnimatedOverlayRenderer(@NotNull ResourceLocation id, long ticks) {
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        super(id, ticks);
        this.mc = Minecraft.getInstance();
        this.resources = this.mc.getResourceManager();
        Resource rawDef = this.resources.getResourceOrThrow(id.withSuffix(".anim.json"));
        BufferedReader bufferedReader = rawDef.openAsReader();
        Intrinsics.checkNotNullExpressionValue((Object)bufferedReader, (String)"openAsReader(...)");
        String defText = TextStreamsKt.readText((Reader)bufferedReader);
        TexAnimDef def = (TexAnimDef)EndecExt.INSTANCE.decodeJsonStringOrThrow((Endec)TexAnimDef.Companion.getENDEC(), defText);
        Intrinsics.checkNotNull((Object)def);
        this.animDef = def;
    }

    @Override
    public void render(@NotNull GuiGraphics graphics, int w, int h) {
        Intrinsics.checkNotNullParameter((Object)graphics, (String)"graphics");
        graphics.blit(this.getTex(), 0, 0, w, h, (float)this.animDef.frameU(this.getRunningTime()), (float)this.animDef.frameV(this.getRunningTime()), this.animDef.getFrameWidth(), this.animDef.getFrameHeight(), this.animDef.getTextureWidth(), this.animDef.getTextureHeight());
    }

    @Override
    public boolean isComplete() {
        return this.animDef.completed(this.getRunningTime());
    }

    public final void reset() {
        this.setRunningTime(0);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/api/client/overlay/AnimatedOverlayRenderer$Companion;", "", "<init>", "()V", "hasAnimationDef", "", "id", "Lnet/minecraft/resources/ResourceLocation;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        public final boolean hasAnimationDef(@NotNull ResourceLocation id) {
            Intrinsics.checkNotNullParameter((Object)id, (String)"id");
            return Minecraft.getInstance().getResourceManager().getResource(id.withSuffix(".anim.json")).isPresent();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

