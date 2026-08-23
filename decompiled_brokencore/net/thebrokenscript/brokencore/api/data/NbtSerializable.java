/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.nbt.Tag
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.data;

import kotlin.Metadata;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.Tag;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H&\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/data/NbtSerializable;", "", "serializeNbt", "Lnet/minecraft/nbt/Tag;", "provider", "Lnet/minecraft/core/HolderLookup$Provider;", "deserializeNbt", "", "tag", "brokencore-common"})
public interface NbtSerializable {
    @NotNull
    public Tag serializeNbt(@NotNull HolderLookup.Provider var1);

    public void deserializeNbt(@NotNull HolderLookup.Provider var1, @NotNull Tag var2);
}

