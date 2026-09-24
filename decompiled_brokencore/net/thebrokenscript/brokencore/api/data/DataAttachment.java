/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  net.minecraft.world.entity.Entity
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.data;

import kotlin.Metadata;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a2\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\b\u00028\u0000H&\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b9\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/brokencore/api/data/DataAttachment;", "T", "", "get", "entity", "Lnet/minecraft/world/entity/Entity;", "(Lnet/minecraft/world/entity/Entity;)Ljava/lang/Object;", "set", "", "value", "(Lnet/minecraft/world/entity/Entity;Ljava/lang/Object;)V", "brokencore-common"})
public interface DataAttachment<T> {
    public T get(@NotNull Entity var1);

    public void set(@NotNull Entity var1, @NotNull T var2);
}

