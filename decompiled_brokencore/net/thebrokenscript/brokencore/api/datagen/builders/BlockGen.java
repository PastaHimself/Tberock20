/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.level.block.Block
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.datagen.builders;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/api/datagen/builders/BlockGen;", "", "<init>", "()V", "blockId", "Lnet/minecraft/resources/ResourceLocation;", "block", "Lnet/minecraft/world/level/block/Block;", "brokencore-common"})
public final class BlockGen {
    @NotNull
    public static final BlockGen INSTANCE = new BlockGen();

    private BlockGen() {
    }

    @NotNull
    public final ResourceLocation blockId(@NotNull Block block2) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        ResourceLocation resourceLocation = BuiltInRegistries.BLOCK.getKey((Object)block2);
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"getKey(...)");
        return resourceLocation;
    }
}

