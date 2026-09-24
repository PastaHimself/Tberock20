/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Holder$Reference
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.level.block.Block
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.client.blocks;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.thebrokenscript.brokencore.api.client.blocks.UniformsBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u001e\u001a\u00020\u001f\"\b\b\u0000\u0010 *\u00020\u00192\u0006\u0010\u001e\u001a\u0002H \u00a2\u0006\u0002\u0010!J\u001e\u0010\u001e\u001a\u00020\u001f\"\b\b\u0000\u0010 *\u00020\u00192\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H 0\u0018J\u001f\u0010\n\u001a\u00020\u000b2\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020$0#\u00a2\u0006\u0002\b%J\u0006\u0010&\u001a\u00020\u0000R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00190\u00180\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006'"}, d2={"Lnet/thebrokenscript/brokencore/api/client/blocks/BlockRenderLayerBuilder;", "", "<init>", "()V", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "setId", "(Lnet/minecraft/resources/ResourceLocation;)V", "uniforms", "Lnet/thebrokenscript/brokencore/api/client/blocks/UniformsBuilder;", "getUniforms", "()Lnet/thebrokenscript/brokencore/api/client/blocks/UniformsBuilder;", "setUniforms", "(Lnet/thebrokenscript/brokencore/api/client/blocks/UniformsBuilder;)V", "renderType", "Lnet/minecraft/client/renderer/RenderType;", "getRenderType", "()Lnet/minecraft/client/renderer/RenderType;", "setRenderType", "(Lnet/minecraft/client/renderer/RenderType;)V", "blocks", "", "Lnet/minecraft/core/Holder;", "Lnet/minecraft/world/level/block/Block;", "getBlocks", "()Ljava/util/List;", "setBlocks", "(Ljava/util/List;)V", "block", "", "B", "(Lnet/minecraft/world/level/block/Block;)Z", "cb", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "build", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nBlockRenderLayerBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BlockRenderLayerBuilder.kt\nnet/thebrokenscript/brokencore/api/client/blocks/BlockRenderLayerBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,27:1\n1#2:28\n*E\n"})
public final class BlockRenderLayerBuilder {
    @Nullable
    private ResourceLocation id;
    @NotNull
    private UniformsBuilder uniforms = new UniformsBuilder();
    @Nullable
    private RenderType renderType;
    @NotNull
    private List<Holder<? extends Block>> blocks = new ArrayList();

    @Nullable
    public final ResourceLocation getId() {
        return this.id;
    }

    public final void setId(@Nullable ResourceLocation resourceLocation) {
        this.id = resourceLocation;
    }

    @NotNull
    public final UniformsBuilder getUniforms() {
        return this.uniforms;
    }

    public final void setUniforms(@NotNull UniformsBuilder uniformsBuilder) {
        Intrinsics.checkNotNullParameter((Object)uniformsBuilder, (String)"<set-?>");
        this.uniforms = uniformsBuilder;
    }

    @Nullable
    public final RenderType getRenderType() {
        return this.renderType;
    }

    public final void setRenderType(@Nullable RenderType renderType) {
        this.renderType = renderType;
    }

    @NotNull
    public final List<Holder<? extends Block>> getBlocks() {
        return this.blocks;
    }

    public final void setBlocks(@NotNull List<Holder<? extends Block>> list) {
        Intrinsics.checkNotNullParameter(list, (String)"<set-?>");
        this.blocks = list;
    }

    public final <B extends Block> boolean block(@NotNull B block2) {
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        Holder.Reference reference = block2.builtInRegistryHolder();
        Intrinsics.checkNotNullExpressionValue((Object)reference, (String)"builtInRegistryHolder(...)");
        return this.blocks.add((Holder<? extends Block>)reference);
    }

    public final <B extends Block> boolean block(@NotNull Holder<B> block2) {
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        return this.blocks.add(block2);
    }

    @NotNull
    public final UniformsBuilder uniforms(@NotNull Function1<? super UniformsBuilder, Unit> cb) {
        Intrinsics.checkNotNullParameter(cb, (String)"cb");
        UniformsBuilder uniformsBuilder = this.uniforms;
        cb.invoke((Object)uniformsBuilder);
        return uniformsBuilder;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final BlockRenderLayerBuilder build() {
        void var1_1;
        BlockRenderLayerBuilder $this$build_u24lambda_u240 = this;
        boolean bl = false;
        if (!($this$build_u24lambda_u240.id != null)) {
            boolean $i$a$-require-BlockRenderLayerBuilder$build$1$32 = false;
            String $i$a$-require-BlockRenderLayerBuilder$build$1$32 = "id must be defined.";
            throw new IllegalArgumentException($i$a$-require-BlockRenderLayerBuilder$build$1$32.toString());
        }
        if (!($this$build_u24lambda_u240.renderType != null)) {
            boolean bl2 = false;
            String string = "renderType must be defined.";
            throw new IllegalArgumentException(string.toString());
        }
        return var1_1;
    }
}

