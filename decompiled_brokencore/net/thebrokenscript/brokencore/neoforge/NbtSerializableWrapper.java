/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.nbt.Tag
 *  net.neoforged.neoforge.common.util.INBTSerializable
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.neoforge;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.Tag;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.thebrokenscript.brokencore.api.data.NbtSerializable;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016R\u0013\u0010\u0005\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/brokencore/neoforge/NbtSerializableWrapper;", "T", "Lnet/thebrokenscript/brokencore/api/data/NbtSerializable;", "Lnet/neoforged/neoforge/common/util/INBTSerializable;", "Lnet/minecraft/nbt/Tag;", "inner", "<init>", "(Lnet/thebrokenscript/brokencore/api/data/NbtSerializable;)V", "getInner", "()Lnet/thebrokenscript/brokencore/api/data/NbtSerializable;", "Lnet/thebrokenscript/brokencore/api/data/NbtSerializable;", "serializeNBT", "provider", "Lnet/minecraft/core/HolderLookup$Provider;", "deserializeNBT", "", "nbt", "brokencore-neoforge"})
public final class NbtSerializableWrapper<T extends NbtSerializable>
implements INBTSerializable<Tag> {
    @NotNull
    private final T inner;

    public NbtSerializableWrapper(@NotNull T inner) {
        Intrinsics.checkNotNullParameter(inner, (String)"inner");
        this.inner = inner;
    }

    @NotNull
    public final T getInner() {
        return this.inner;
    }

    @NotNull
    public Tag serializeNBT(@NotNull HolderLookup.Provider provider) {
        Intrinsics.checkNotNullParameter((Object)provider, (String)"provider");
        return this.inner.serializeNbt(provider);
    }

    public void deserializeNBT(@NotNull HolderLookup.Provider provider, @NotNull Tag nbt) {
        Intrinsics.checkNotNullParameter((Object)provider, (String)"provider");
        Intrinsics.checkNotNullParameter((Object)nbt, (String)"nbt");
        this.inner.deserializeNbt(provider, nbt);
    }
}

