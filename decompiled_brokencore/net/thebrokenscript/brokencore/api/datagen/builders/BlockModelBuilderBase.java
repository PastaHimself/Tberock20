/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.level.block.Block
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.datagen.builders;

import compat.net.neoforged.neoforge.common.data.ExistingFileHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.level.block.Block;
import net.thebrokenscript.brokencore.api.datagen.util.ModelBuilderBase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/brokencore/api/datagen/builders/BlockModelBuilderBase;", "Lnet/thebrokenscript/brokencore/api/datagen/util/ModelBuilderBase;", "block", "Lnet/minecraft/world/level/block/Block;", "files", "Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;", "<init>", "(Lnet/minecraft/world/level/block/Block;Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;)V", "getBlock", "()Lnet/minecraft/world/level/block/Block;", "brokencore-common"})
public abstract class BlockModelBuilderBase
extends ModelBuilderBase {
    @NotNull
    private final Block block;

    public BlockModelBuilderBase(@NotNull Block block2, @NotNull ExistingFileHelper files) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)files, (String)"files");
        super(files);
        this.block = block2;
    }

    @NotNull
    protected final Block getBlock() {
        return this.block;
    }
}

