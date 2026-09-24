/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  net.minecraft.world.level.entity.EntityAccess
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.mixinterfaces;

import java.util.Collection;
import kotlin.Metadata;
import net.minecraft.world.level.entity.EntityAccess;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J&\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0001\u0010\u0006*\u00028\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\bH&\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/mixinterfaces/EntityLookupExt;", "T", "Lnet/minecraft/world/level/entity/EntityAccess;", "", "bc$getByClass", "", "U", "clazz", "Ljava/lang/Class;", "brokencore-common"})
public interface EntityLookupExt<T extends EntityAccess> {
    @NotNull
    public <U extends T> Collection<U> bc$getByClass(@NotNull Class<U> var1);
}

