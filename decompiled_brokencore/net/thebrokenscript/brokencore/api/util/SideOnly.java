/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package net.thebrokenscript.brokencore.api.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import net.thebrokenscript.brokencore.api.util.Side;

@Retention(value=RetentionPolicy.RUNTIME)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0002\u0018\u00002\u00020\u0001B\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2={"Lnet/thebrokenscript/brokencore/api/util/SideOnly;", "", "side", "Lnet/thebrokenscript/brokencore/api/util/Side;", "()Lnet/thebrokenscript/brokencore/api/util/Side;", "brokencore-common"})
public @interface SideOnly {
    public Side side();
}

