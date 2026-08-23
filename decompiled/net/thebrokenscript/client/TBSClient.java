/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  net.thebrokenscript.brokencore.api.client.shader.PostShaderManager
 *  net.thebrokenscript.brokencore.api.client.shader.ShaderStage
 *  net.thebrokenscript.brokencore.api.event.GameEvent
 *  net.thebrokenscript.brokencore.api.event.game.ClientEvents
 *  net.thebrokenscript.brokencore.api.event.game.ClientEvents$Data
 *  net.thebrokenscript.brokencore.api.queue.WorkQueue
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.client;

import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.misc.CapeLoader;
import net.thebrokenscript.api.misc.FunnyChecker;
import net.thebrokenscript.brokencore.api.client.shader.PostShaderManager;
import net.thebrokenscript.brokencore.api.client.shader.ShaderStage;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.ClientEvents;
import net.thebrokenscript.brokencore.api.queue.WorkQueue;
import net.thebrokenscript.client.window.FigureWin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0015R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@BX\u0086.\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2={"Lnet/thebrokenscript/client/TBSClient;", "", "<init>", "()V", "queue", "Lnet/thebrokenscript/brokencore/api/queue/WorkQueue;", "getQueue", "()Lnet/thebrokenscript/brokencore/api/queue/WorkQueue;", "win", "Lnet/thebrokenscript/client/window/FigureWin;", "getWin", "()Lnet/thebrokenscript/client/window/FigureWin;", "setWin", "(Lnet/thebrokenscript/client/window/FigureWin;)V", "loaded", "", "getLoaded", "()Z", "setLoaded", "(Z)V", "value", "Ljava/io/File;", "modFile", "getModFile", "()Ljava/io/File;", "init", "", "thebrokenscript-common"})
public final class TBSClient {
    @NotNull
    public static final TBSClient INSTANCE = new TBSClient();
    @NotNull
    private static final WorkQueue queue = new WorkQueue(null, 1, null);
    @Nullable
    private static FigureWin win;
    private static boolean loaded;
    private static File modFile;

    private TBSClient() {
    }

    @NotNull
    public final WorkQueue getQueue() {
        return queue;
    }

    @Nullable
    public final FigureWin getWin() {
        return win;
    }

    public final void setWin(@Nullable FigureWin figureWin) {
        win = figureWin;
    }

    public final boolean getLoaded() {
        return loaded;
    }

    public final void setLoaded(boolean bl) {
        loaded = bl;
    }

    @NotNull
    public final File getModFile() {
        File file = modFile;
        if (file != null) {
            return file;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"modFile");
        return null;
    }

    public final void init(@NotNull File modFile) {
        Intrinsics.checkNotNullParameter((Object)modFile, (String)"modFile");
        TBSClient.modFile = modFile;
        FunnyChecker.INSTANCE.check();
        CapeLoader.load();
        GameEvent.Companion.on(ClientEvents.INACTIVE_TICK_END, TBSClient::init$lambda$0);
        PostShaderManager.register$default((PostShaderManager)PostShaderManager.INSTANCE, (ResourceLocation)TBSConstants.id("shaders/post/aberration.json"), (boolean)false, null, (int)4, null);
        PostShaderManager.register$default((PostShaderManager)PostShaderManager.INSTANCE, (ResourceLocation)TBSConstants.id("shaders/post/vhs.json"), (boolean)false, null, (int)4, null);
        PostShaderManager.register$default((PostShaderManager)PostShaderManager.INSTANCE, (ResourceLocation)TBSConstants.id("shaders/post/testing.json"), (boolean)true, null, (int)4, null);
        PostShaderManager.register$default((PostShaderManager)PostShaderManager.INSTANCE, (ResourceLocation)TBSConstants.id("shaders/post/pixelate.json"), (boolean)false, null, (int)4, null);
        PostShaderManager.INSTANCE.register(TBSConstants.id("shaders/post/glitches.json"), false, ShaderStage.OVERLAY);
        PostShaderManager.INSTANCE.register(TBSConstants.id("shaders/post/dream.json"), false, ShaderStage.LEVEL);
        PostShaderManager.INSTANCE.register(TBSConstants.id("shaders/post/sky_void.json"), false, ShaderStage.LEVEL);
        PostShaderManager.INSTANCE.register(TBSConstants.id("shaders/post/ripple.json"), true, ShaderStage.LEVEL);
        PostShaderManager.INSTANCE.register(TBSConstants.id("shaders/post/shockwave.json"), true, ShaderStage.LEVEL);
        PostShaderManager.INSTANCE.register(TBSConstants.id("shaders/post/void_box.json"), true, ShaderStage.LEVEL);
        PostShaderManager.INSTANCE.register(TBSConstants.id("shaders/post/fever.json"), false, ShaderStage.OVERLAY);
        ResourceLocation resourceLocation = ResourceLocation.withDefaultNamespace((String)"shaders/post/invert.json");
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"withDefaultNamespace(...)");
        PostShaderManager.INSTANCE.register(resourceLocation, false, ShaderStage.OVERLAY);
    }

    private static final Unit init$lambda$0(ClientEvents.Data $this$on) {
        block0: {
            Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
            FigureWin figureWin = win;
            if (figureWin == null) break block0;
            figureWin.update();
        }
        return Unit.INSTANCE;
    }
}

