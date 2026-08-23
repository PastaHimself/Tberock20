/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 *  net.minecraft.server.level.ServerLevel
 *  net.thebrokenscript.brokencore.api.engine.EngineController
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import net.minecraft.server.level.ServerLevel;
import net.thebrokenscript.boss.integrity.Arena;
import net.thebrokenscript.brokencore.api.engine.EngineController;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/TBSEngineControl;", "Lnet/thebrokenscript/brokencore/api/engine/EngineController;", "<init>", "()V", "enableEvents", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "eventFrequency", "", "Companion", "thebrokenscript-common"})
public final class TBSEngineControl
implements EngineController {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final float CUTOFF = 55.0f;

    public boolean enableEvents(@NotNull ServerLevel level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        return !Intrinsics.areEqual((Object)level.dimension().location().getNamespace(), (Object)"thebrokenscript") && Arena.Companion.getInstance() == null;
    }

    public float eventFrequency(@NotNull ServerLevel level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        return Companion.eventFrequency(level.getGameTime());
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0002R\u000e\u0010\b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/TBSEngineControl$Companion;", "", "<init>", "()V", "eventFrequency", "", "gameTime", "", "CUTOFF", "quadCurve", "x", "logCurve", "evalCurve", "evalCurveTicks", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public final float eventFrequency(long gameTime) {
            float freq = this.evalCurveTicks(gameTime) / (float)24000;
            return freq - 2.9166666E-4f;
        }

        private final float quadCurve(float x) {
            return (float)Math.pow(0.03125f * x, 2.0f);
        }

        private final float logCurve(float x) {
            return (float)Math.log10(x + 1.0f - 55.0f) + this.quadCurve(55.0f);
        }

        private final float evalCurve(float x) {
            return RangesKt.coerceAtMost((float)(x < 55.0f ? this.quadCurve(x) : this.logCurve(x)), (float)7.0f);
        }

        private final float evalCurveTicks(float x) {
            return this.evalCurve(x / (float)24000);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

