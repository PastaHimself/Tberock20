/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.thebrokenscript.brokencore.api.registry.objects.BlockEntityEntry
 *  net.thebrokenscript.brokencore.api.registry.objects.BlockEntry
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.block.PlushBlock;
import net.thebrokenscript.block.entity.PlushBlockEntity;
import net.thebrokenscript.brokencore.api.registry.objects.BlockEntityEntry;
import net.thebrokenscript.brokencore.api.registry.objects.BlockEntry;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/registry/DevPlush;", "", "block", "Lnet/thebrokenscript/brokencore/api/registry/objects/BlockEntry;", "Lnet/thebrokenscript/block/PlushBlock;", "entity", "Lnet/thebrokenscript/brokencore/api/registry/objects/BlockEntityEntry;", "Lnet/thebrokenscript/block/entity/PlushBlockEntity;", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/objects/BlockEntry;Lnet/thebrokenscript/brokencore/api/registry/objects/BlockEntityEntry;)V", "getBlock", "()Lnet/thebrokenscript/brokencore/api/registry/objects/BlockEntry;", "getEntity", "()Lnet/thebrokenscript/brokencore/api/registry/objects/BlockEntityEntry;", "thebrokenscript-common"})
public final class DevPlush {
    @NotNull
    private final BlockEntry<PlushBlock> block;
    @NotNull
    private final BlockEntityEntry<PlushBlockEntity> entity;

    public DevPlush(@NotNull BlockEntry<PlushBlock> block, @NotNull BlockEntityEntry<PlushBlockEntity> entity) {
        Intrinsics.checkNotNullParameter(block, (String)"block");
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        this.block = block;
        this.entity = entity;
    }

    @NotNull
    public final BlockEntry<PlushBlock> getBlock() {
        return this.block;
    }

    @NotNull
    public final BlockEntityEntry<PlushBlockEntity> getEntity() {
        return this.entity;
    }
}

