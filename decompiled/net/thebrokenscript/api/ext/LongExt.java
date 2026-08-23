/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.ext;

import kotlin.Metadata;
import net.thebrokenscript.TBSEngineControl;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/api/ext/LongExt;", "", "<init>", "()V", "eventFrequency", "", "", "thebrokenscript-common"})
public final class LongExt {
    @NotNull
    public static final LongExt INSTANCE = new LongExt();

    private LongExt() {
    }

    public final float eventFrequency(long $this$eventFrequency) {
        return TBSEngineControl.Companion.eventFrequency($this$eventFrequency);
    }
}

