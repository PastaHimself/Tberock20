/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.data.PackOutput
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package compat.net.neoforged.neoforge.client.model.generators;

import compat.net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import compat.net.neoforged.neoforge.client.model.generators.ModelProvider;
import compat.net.neoforged.neoforge.common.data.ExistingFileHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\r"}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/BlockModelProvider;", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelProvider;", "Lcompat/net/neoforged/neoforge/client/model/generators/BlockModelBuilder;", "output", "Lnet/minecraft/data/PackOutput;", "id", "Lnet/minecraft/resources/ResourceLocation;", "existingFileHelper", "Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;", "<init>", "(Lnet/minecraft/data/PackOutput;Lnet/minecraft/resources/ResourceLocation;Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;)V", "getName", "", "brokencore-common"})
public abstract class BlockModelProvider
extends ModelProvider<BlockModelBuilder> {
    public BlockModelProvider(@NotNull PackOutput output, @NotNull ResourceLocation id, @NotNull ExistingFileHelper existingFileHelper) {
        Intrinsics.checkNotNullParameter((Object)output, (String)"output");
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        Intrinsics.checkNotNullParameter((Object)existingFileHelper, (String)"existingFileHelper");
        super(output, id, "block", 1.INSTANCE, existingFileHelper);
    }

    @NotNull
    public String getName() {
        return "Block Models: " + this.id.getNamespace();
    }
}

