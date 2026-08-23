/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.Entity
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.mixinterfaces;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.Entity;
import net.thebrokenscript.brokencore.api.mixinterfaces.EntityCollisionExt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\"(\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"value", "", "isCollidable", "Lnet/minecraft/world/entity/Entity;", "(Lnet/minecraft/world/entity/Entity;)Z", "setCollidable", "(Lnet/minecraft/world/entity/Entity;Z)V", "brokencore-common"})
public final class EntityCollisionExtKt {
    public static final boolean isCollidable(@NotNull Entity $this$isCollidable) {
        Intrinsics.checkNotNullParameter((Object)$this$isCollidable, (String)"<this>");
        return ((EntityCollisionExt)$this$isCollidable).getBc$isCollidable();
    }

    public static final void setCollidable(@NotNull Entity $this$isCollidable, boolean value) {
        Intrinsics.checkNotNullParameter((Object)$this$isCollidable, (String)"<this>");
        ((EntityCollisionExt)$this$isCollidable).setBc$isCollidable(value);
    }
}

