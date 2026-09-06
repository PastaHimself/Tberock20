/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  net.thebrokenscript.brokencore.api.registry.BrokenReg
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSReg;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/registry/TBSStoryEvents;", "", "<init>", "()V", "thebrokenscript-common"})
public final class TBSStoryEvents {
    @NotNull
    public static final TBSStoryEvents INSTANCE = new TBSStoryEvents();

    private TBSStoryEvents() {
    }

    static {
        BrokenReg.storyEvent$default((BrokenReg)TBSReg.INSTANCE, (String)"moon_corruption_story", (Function0)1.INSTANCE, null, (int)4, null);
        BrokenReg.storyEvent$default((BrokenReg)TBSReg.INSTANCE, (String)"txt_story", (Function0)2.INSTANCE, null, (int)4, null);
        BrokenReg.storyEvent$default((BrokenReg)TBSReg.INSTANCE, (String)"null_book_hint", (Function0)3.INSTANCE, null, (int)4, null);
        BrokenReg.storyEvent$default((BrokenReg)TBSReg.INSTANCE, (String)"coords_hint", (Function0)4.INSTANCE, null, (int)4, null);
    }
}

