/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  net.thebrokenscript.brokencore.api.registry.BrokenReg
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import kotlin.Metadata;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.registry.TBSCreativeTabs;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/registry/TBSReg;", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "<init>", "()V", "thebrokenscript-common"})
public final class TBSReg
extends BrokenReg {
    @NotNull
    public static final TBSReg INSTANCE = new TBSReg();

    private TBSReg() {
        super("thebrokenscript");
    }

    static {
        INSTANCE.setCreativeTab(TBSCreativeTabs.MAIN.getKey());
    }
}

