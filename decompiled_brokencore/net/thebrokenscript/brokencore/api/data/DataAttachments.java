/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.data;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.data.DataAttachment;
import net.thebrokenscript.brokencore.api.data.NbtSerializable;
import net.thebrokenscript.brokencore.api.platform.PlatformAttachments;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00060\r\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/brokencore/api/data/DataAttachments;", "", "<init>", "()V", "register", "Lnet/thebrokenscript/brokencore/api/data/DataAttachment;", "T", "Lnet/thebrokenscript/brokencore/api/data/NbtSerializable;", "reg", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "id", "", "ctor", "Lkotlin/Function0;", "brokencore-common"})
public final class DataAttachments {
    @NotNull
    public static final DataAttachments INSTANCE = new DataAttachments();

    private DataAttachments() {
    }

    @NotNull
    public final <T extends NbtSerializable> DataAttachment<T> register(@NotNull BrokenReg reg, @NotNull String id, @NotNull Function0<? extends T> ctor) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        return PlatformAttachments.Companion.register(reg, id, ctor);
    }
}

