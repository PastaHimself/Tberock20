/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.cutscene;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.thebrokenscript.brokencore.api.client.event.RenderEvents;
import net.thebrokenscript.brokencore.api.cutscene.Cutscene;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.brokencore.impl.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@SideOnly(side=Side.CLIENT)
@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/brokencore/api/client/cutscene/CutsceneHandler;", "", "<init>", "()V", "loaded", "", "Ljava/util/UUID;", "Lnet/thebrokenscript/brokencore/api/cutscene/Cutscene;", "getLoaded", "()Ljava/util/Map;", "play", "", "cutscene", "stop", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nCutsceneHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CutsceneHandler.kt\nnet/thebrokenscript/brokencore/api/client/cutscene/CutsceneHandler\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,30:1\n1869#2,2:31\n*S KotlinDebug\n*F\n+ 1 CutsceneHandler.kt\nnet/thebrokenscript/brokencore/api/client/cutscene/CutsceneHandler\n*L\n18#1:31,2\n*E\n"})
public final class CutsceneHandler {
    @NotNull
    public static final CutsceneHandler INSTANCE = new CutsceneHandler();
    @NotNull
    private static final Map<UUID, Cutscene> loaded = new LinkedHashMap();

    private CutsceneHandler() {
    }

    @NotNull
    public final Map<UUID, Cutscene> getLoaded() {
        return loaded;
    }

    public final void play(@NotNull Cutscene cutscene) {
        Intrinsics.checkNotNullParameter((Object)cutscene, (String)"cutscene");
        loaded.put(cutscene.getUuid(), cutscene);
        cutscene.play();
    }

    public final void stop(@NotNull UUID cutscene) {
        block0: {
            Intrinsics.checkNotNullParameter((Object)cutscene, (String)"cutscene");
            Cutscene cutscene2 = loaded.remove(cutscene);
            if (cutscene2 == null) break block0;
            cutscene2.stop();
        }
    }

    private static final Unit _init_$lambda$0(RenderEvents.LevelStageData $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        Iterable $this$forEach$iv = loaded.values();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Cutscene it = (Cutscene)element$iv;
            boolean bl = false;
            it.render($this$on, $this$on.getPartialTick().getGameTimeDeltaTicks() / 10.0f);
        }
        return Unit.INSTANCE;
    }

    static {
        GameEvent.Companion.on(RenderEvents.LEVEL_STAGE, CutsceneHandler::_init_$lambda$0);
    }
}

