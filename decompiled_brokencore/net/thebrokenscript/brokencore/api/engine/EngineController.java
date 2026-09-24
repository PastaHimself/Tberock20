/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.server.level.ServerLevel
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.engine;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.level.ServerLevel;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/engine/EngineController;", "", "enableEvents", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "globalEventWeight", "", "eventFrequency", "brokencore-common"})
public interface EngineController {
    public boolean enableEvents(@NotNull ServerLevel var1);

    public float globalEventWeight(@NotNull ServerLevel var1);

    public float eventFrequency(@NotNull ServerLevel var1);

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        public static boolean enableEvents(@NotNull EngineController $this, @NotNull ServerLevel level) {
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            return true;
        }

        public static float globalEventWeight(@NotNull EngineController $this, @NotNull ServerLevel level) {
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            return 1.0f;
        }

        public static float eventFrequency(@NotNull EngineController $this, @NotNull ServerLevel level) {
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            return 1.0f;
        }
    }
}

