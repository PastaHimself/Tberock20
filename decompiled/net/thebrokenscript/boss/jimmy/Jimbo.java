/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.boss.jimmy;

import kotlin.Metadata;
import net.thebrokenscript.boss.jimmy.MoonRiseAmbience;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/boss/jimmy/Jimbo;", "", "<init>", "()V", "MOONRISE", "Lnet/thebrokenscript/boss/jimmy/MoonRiseAmbience;", "getMOONRISE", "()Lnet/thebrokenscript/boss/jimmy/MoonRiseAmbience;", "setMOONRISE", "(Lnet/thebrokenscript/boss/jimmy/MoonRiseAmbience;)V", "thebrokenscript-common"})
public final class Jimbo {
    @NotNull
    public static final Jimbo INSTANCE = new Jimbo();
    @Nullable
    private static MoonRiseAmbience MOONRISE;

    private Jimbo() {
    }

    @Nullable
    public final MoonRiseAmbience getMOONRISE() {
        return MOONRISE;
    }

    public final void setMOONRISE(@Nullable MoonRiseAmbience moonRiseAmbience) {
        MOONRISE = moonRiseAmbience;
    }
}

