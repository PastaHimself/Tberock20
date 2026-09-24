/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.server.level.ServerLevel
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.engine;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.server.level.ServerLevel;
import net.thebrokenscript.brokencore.api.engine.EngineController;
import net.thebrokenscript.brokencore.impl.event.engine.DefaultEngineControl;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/api/engine/EngineControl;", "", "<init>", "()V", "controls", "", "Lnet/thebrokenscript/brokencore/api/engine/EngineController;", "register", "", "control", "enableEvents", "level", "Lnet/minecraft/server/level/ServerLevel;", "globalEventWeight", "", "eventFrequency", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nEngineControl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EngineControl.kt\nnet/thebrokenscript/brokencore/api/engine/EngineControl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,61:1\n1740#2,3:62\n*S KotlinDebug\n*F\n+ 1 EngineControl.kt\nnet/thebrokenscript/brokencore/api/engine/EngineControl\n*L\n32#1:62,3\n*E\n"})
public final class EngineControl {
    @NotNull
    public static final EngineControl INSTANCE = new EngineControl();
    @NotNull
    private static List<EngineController> controls;

    private EngineControl() {
    }

    public final boolean register(@NotNull EngineController control) {
        Intrinsics.checkNotNullParameter((Object)control, (String)"control");
        return controls.add(control);
    }

    public final boolean enableEvents(@NotNull ServerLevel level) {
        boolean bl;
        block3: {
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            Iterable $this$all$iv = controls;
            boolean $i$f$all = false;
            if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                bl = true;
            } else {
                for (Object element$iv : $this$all$iv) {
                    EngineController it = (EngineController)element$iv;
                    boolean bl2 = false;
                    if (it.enableEvents(level)) continue;
                    bl = false;
                    break block3;
                }
                bl = true;
            }
        }
        return bl;
    }

    public final float globalEventWeight(@NotNull ServerLevel level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        float weight = 1.0f;
        for (EngineController c : controls) {
            weight *= c.globalEventWeight(level);
        }
        return weight;
    }

    public final float eventFrequency(@NotNull ServerLevel level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        float weight = 0.0f;
        for (EngineController c : controls) {
            weight += c.eventFrequency(level);
        }
        return weight;
    }

    static {
        Object[] objectArray = new EngineController[]{DefaultEngineControl.INSTANCE};
        controls = CollectionsKt.mutableListOf((Object[])objectArray);
    }
}

