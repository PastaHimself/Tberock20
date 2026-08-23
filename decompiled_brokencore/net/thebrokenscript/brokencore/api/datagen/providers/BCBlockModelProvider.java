/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.data.PackOutput
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.level.block.Block
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.datagen.providers;

import compat.net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.thebrokenscript.brokencore.api.platform.PlatformDatagen;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\u00028\u0000\u00a2\u0006\u0010\n\u0002\u0010\u0011\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/brokencore/api/datagen/providers/BCBlockModelProvider;", "B", "Lnet/minecraft/world/level/block/Block;", "Lcompat/net/neoforged/neoforge/client/model/generators/BlockModelProvider;", "output", "Lnet/minecraft/data/PackOutput;", "parent", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "id", "Lnet/minecraft/resources/ResourceLocation;", "<init>", "(Lnet/minecraft/data/PackOutput;Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Lnet/minecraft/resources/ResourceLocation;)V", "block", "getBlock$annotations", "()V", "getBlock", "()Lnet/minecraft/world/level/block/Block;", "Lnet/minecraft/world/level/block/Block;", "registerModels", "", "brokencore-common"})
public final class BCBlockModelProvider<B extends Block>
extends BlockModelProvider {
    @NotNull
    private final BrokenReg parent;
    @NotNull
    private final B block;

    public BCBlockModelProvider(@NotNull PackOutput output, @NotNull BrokenReg parent, @NotNull ResourceLocation id) {
        Intrinsics.checkNotNullParameter((Object)output, (String)"output");
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        super(output, id, PlatformDatagen.Companion.createFileHelper());
        this.parent = parent;
        Object object = BuiltInRegistries.BLOCK.getOrThrow(ResourceKey.create((ResourceKey)Registries.BLOCK, (ResourceLocation)id));
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type B of net.thebrokenscript.brokencore.api.datagen.providers.BCBlockModelProvider");
        this.block = (Block)object;
    }

    @NotNull
    public final B getBlock() {
        return this.block;
    }

    public static /* synthetic */ void getBlock$annotations() {
    }

    @Override
    public void registerModels() {
        this.parent.getData().getBlockModels().plusAssign(this.getJsons());
    }
}

