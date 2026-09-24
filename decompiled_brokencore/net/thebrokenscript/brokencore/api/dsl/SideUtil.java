/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.Entity
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.dsl;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.Entity;
import net.thebrokenscript.brokencore.api.dsl.OnlyIfAvailable;
import net.thebrokenscript.brokencore.api.dsl.OnlyIfAvailableMut;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a$\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a$\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a$\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a$\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\u00a8\u0006\n"}, d2={"clientSide", "Lnet/thebrokenscript/brokencore/api/dsl/OnlyIfAvailable;", "T", "Lnet/minecraft/world/entity/Entity;", "ctor", "Lkotlin/Function0;", "clientSideMut", "Lnet/thebrokenscript/brokencore/api/dsl/OnlyIfAvailableMut;", "serverSide", "serverSideMut", "brokencore-common"})
@JvmName(name="SideUtil")
public final class SideUtil {
    @NotNull
    public static final <T> OnlyIfAvailable<T> clientSide(@NotNull Entity $this$clientSide, @NotNull Function0<? extends T> ctor) {
        Intrinsics.checkNotNullParameter((Object)$this$clientSide, (String)"<this>");
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        return new OnlyIfAvailable<T>($this$clientSide.level().isClientSide, ctor);
    }

    @NotNull
    public static final <T> OnlyIfAvailableMut<T> clientSideMut(@NotNull Entity $this$clientSideMut, @NotNull Function0<? extends T> ctor) {
        Intrinsics.checkNotNullParameter((Object)$this$clientSideMut, (String)"<this>");
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        return new OnlyIfAvailableMut<T>($this$clientSideMut.level().isClientSide, ctor);
    }

    @NotNull
    public static final <T> OnlyIfAvailable<T> serverSide(@NotNull Entity $this$serverSide, @NotNull Function0<? extends T> ctor) {
        Intrinsics.checkNotNullParameter((Object)$this$serverSide, (String)"<this>");
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        return new OnlyIfAvailable<T>(!$this$serverSide.level().isClientSide, ctor);
    }

    @NotNull
    public static final <T> OnlyIfAvailableMut<T> serverSideMut(@NotNull Entity $this$serverSideMut, @NotNull Function0<? extends T> ctor) {
        Intrinsics.checkNotNullParameter((Object)$this$serverSideMut, (String)"<this>");
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        return new OnlyIfAvailableMut<T>(!$this$serverSideMut.level().isClientSide, ctor);
    }
}

