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
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/boss/integrity/BossGlobals;", "", "<init>", "()V", "FLIP_GRAVITY", "", "INVERSE_GRAVITY_STRENGTH", "", "CUTSCENE_TICKS", "", "thebrokenscript-common"})
public final class BossGlobals {
    @NotNull
    public static final BossGlobals INSTANCE = new BossGlobals();
    @JvmField
    public static boolean FLIP_GRAVITY;
    @JvmField
    public static double INVERSE_GRAVITY_STRENGTH;
    @JvmField
    public static int CUTSCENE_TICKS;

    private BossGlobals() {
    }

    static {
        INVERSE_GRAVITY_STRENGTH = -0.0125;
        CUTSCENE_TICKS = -1;
    }
}

