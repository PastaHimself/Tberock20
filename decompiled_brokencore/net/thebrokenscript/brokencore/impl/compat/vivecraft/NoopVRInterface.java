/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package net.thebrokenscript.brokencore.impl.compat.vivecraft;

import kotlin.Metadata;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.brokencore.impl.compat.vivecraft.VRInterface;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/brokencore/impl/compat/vivecraft/NoopVRInterface;", "Lnet/thebrokenscript/brokencore/impl/compat/vivecraft/VRInterface;", "<init>", "()V", "isVrEnabled", "", "brokencore-common"})
public final class NoopVRInterface
implements VRInterface {
    @Override
    public boolean isVrEnabled() {
        return false;
    }
}

