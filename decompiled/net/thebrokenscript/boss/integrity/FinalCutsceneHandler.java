/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.boss.integrity;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import net.thebrokenscript.boss.integrity.FinalCutscene;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/boss/integrity/FinalCutsceneHandler;", "", "<init>", "()V", "CUTSCENE", "Lnet/thebrokenscript/boss/integrity/FinalCutscene;", "thebrokenscript-common"})
public final class FinalCutsceneHandler {
    @NotNull
    public static final FinalCutsceneHandler INSTANCE = new FinalCutsceneHandler();
    @JvmField
    @NotNull
    public static final FinalCutscene CUTSCENE = new FinalCutscene();

    private FinalCutsceneHandler() {
    }
}

