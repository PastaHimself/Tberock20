/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.entity.multipart.MultipartEntity
 *  net.thebrokenscript.brokencore.api.entity.multipart.MultipartSubEntity
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.entity.fractured;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.entity.BaseFracturedEntity;
import net.thebrokenscript.brokencore.api.entity.multipart.MultipartEntity;
import net.thebrokenscript.brokencore.api.entity.multipart.MultipartSubEntity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/entity/fractured/FracturedSubEntity;", "Lnet/thebrokenscript/brokencore/api/entity/multipart/MultipartSubEntity;", "Lnet/thebrokenscript/api/entity/BaseFracturedEntity;", "parent", "name", "", "width", "", "height", "offset", "Lnet/minecraft/world/phys/Vec3;", "<init>", "(Lnet/thebrokenscript/api/entity/BaseFracturedEntity;Ljava/lang/String;FFLnet/minecraft/world/phys/Vec3;)V", "thebrokenscript-common"})
public final class FracturedSubEntity
extends MultipartSubEntity<BaseFracturedEntity> {
    public FracturedSubEntity(@NotNull BaseFracturedEntity parent, @NotNull String name, float width, float height, @NotNull Vec3 offset) {
        Intrinsics.checkNotNullParameter((Object)((Object)parent), (String)"parent");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)offset, (String)"offset");
        super((MultipartEntity)parent, name, width, height, offset);
    }
}

