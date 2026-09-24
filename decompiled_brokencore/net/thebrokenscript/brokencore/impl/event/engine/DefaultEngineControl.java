/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.server.level.ServerLevel
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.event.engine;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.level.ServerLevel;
import net.thebrokenscript.brokencore.api.engine.EngineController;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/impl/event/engine/DefaultEngineControl;", "Lnet/thebrokenscript/brokencore/api/engine/EngineController;", "<init>", "()V", "eventFrequency", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "brokencore-common"})
public final class DefaultEngineControl
implements EngineController {
    @NotNull
    public static final DefaultEngineControl INSTANCE = new DefaultEngineControl();

    private DefaultEngineControl() {
    }

    @Override
    public float eventFrequency(@NotNull ServerLevel level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        return 2.9166666E-4f;
    }
}

