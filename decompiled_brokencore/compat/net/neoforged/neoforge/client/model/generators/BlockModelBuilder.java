/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package compat.net.neoforged.neoforge.client.model.generators;

import compat.net.neoforged.neoforge.client.model.generators.ModelBuilder;
import compat.net.neoforged.neoforge.common.data.ExistingFileHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/BlockModelBuilder;", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "outputLocation", "Lnet/minecraft/resources/ResourceLocation;", "existingFileHelper", "Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;", "<init>", "(Lnet/minecraft/resources/ResourceLocation;Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;)V", "brokencore-common"})
public final class BlockModelBuilder
extends ModelBuilder<BlockModelBuilder> {
    public BlockModelBuilder(@NotNull ResourceLocation outputLocation, @NotNull ExistingFileHelper existingFileHelper) {
        Intrinsics.checkNotNullParameter((Object)outputLocation, (String)"outputLocation");
        Intrinsics.checkNotNullParameter((Object)existingFileHelper, (String)"existingFileHelper");
        super(outputLocation, existingFileHelper);
    }
}

