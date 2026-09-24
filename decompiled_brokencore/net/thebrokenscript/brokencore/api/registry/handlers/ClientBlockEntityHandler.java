/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.registry.handlers;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.thebrokenscript.brokencore.api.registry.objects.BlockEntityEntry;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import org.jetbrains.annotations.NotNull;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0002\r\u000eB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001e\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/handlers/ClientBlockEntityHandler;", "", "<init>", "()V", "renderers", "", "Lnet/thebrokenscript/brokencore/api/registry/handlers/ClientBlockEntityHandler$BlockEntityRendererInfo;", "getRenderers$brokencore_common", "()Ljava/util/List;", "pushRenderers", "", "cons", "Lnet/thebrokenscript/brokencore/api/registry/handlers/ClientBlockEntityHandler$Consumer;", "BlockEntityRendererInfo", "Consumer", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nClientBlockEntityHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClientBlockEntityHandler.kt\nnet/thebrokenscript/brokencore/api/registry/handlers/ClientBlockEntityHandler\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,49:1\n1869#2,2:50\n*S KotlinDebug\n*F\n+ 1 ClientBlockEntityHandler.kt\nnet/thebrokenscript/brokencore/api/registry/handlers/ClientBlockEntityHandler\n*L\n23#1:50,2\n*E\n"})
public final class ClientBlockEntityHandler {
    @NotNull
    public static final ClientBlockEntityHandler INSTANCE = new ClientBlockEntityHandler();
    @NotNull
    private static final List<BlockEntityRendererInfo<?>> renderers = new ArrayList();

    private ClientBlockEntityHandler() {
    }

    @NotNull
    public final List<BlockEntityRendererInfo<?>> getRenderers$brokencore_common() {
        return renderers;
    }

    public final void pushRenderers(@NotNull Consumer cons) {
        Intrinsics.checkNotNullParameter((Object)cons, (String)"cons");
        Iterable $this$forEach$iv = renderers;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            BlockEntityRendererInfo info = (BlockEntityRendererInfo)element$iv;
            boolean bl = false;
            info.push(cons);
        }
    }

    @SideOnly(side=Side.CLIENT)
    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/handlers/ClientBlockEntityHandler$BlockEntityRendererInfo;", "T", "Lnet/minecraft/world/level/block/entity/BlockEntity;", "", "entry", "Lnet/thebrokenscript/brokencore/api/registry/objects/BlockEntityEntry;", "renderer", "Lkotlin/Function0;", "Lnet/minecraft/client/renderer/blockentity/BlockEntityRendererProvider;", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/objects/BlockEntityEntry;Lkotlin/jvm/functions/Function0;)V", "push", "", "cons", "Lnet/thebrokenscript/brokencore/api/registry/handlers/ClientBlockEntityHandler$Consumer;", "brokencore-common"})
    public static final class BlockEntityRendererInfo<T extends BlockEntity> {
        @NotNull
        private final BlockEntityEntry<T> entry;
        @NotNull
        private final Function0<BlockEntityRendererProvider<T>> renderer;

        public BlockEntityRendererInfo(@NotNull BlockEntityEntry<T> entry, @NotNull Function0<? extends BlockEntityRendererProvider<T>> renderer) {
            Intrinsics.checkNotNullParameter(entry, (String)"entry");
            Intrinsics.checkNotNullParameter(renderer, (String)"renderer");
            this.entry = entry;
            this.renderer = renderer;
        }

        public final void push(@NotNull Consumer cons) {
            Intrinsics.checkNotNullParameter((Object)cons, (String)"cons");
            cons.renderer(this.entry, this.renderer);
        }
    }

    @SideOnly(side=Side.CLIENT)
    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00072\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\t0\bH&\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/handlers/ClientBlockEntityHandler$Consumer;", "", "renderer", "", "T", "Lnet/minecraft/world/level/block/entity/BlockEntity;", "entry", "Lnet/thebrokenscript/brokencore/api/registry/objects/BlockEntityEntry;", "Lkotlin/Function0;", "Lnet/minecraft/client/renderer/blockentity/BlockEntityRendererProvider;", "brokencore-common"})
    public static interface Consumer {
        public <T extends BlockEntity> void renderer(@NotNull BlockEntityEntry<T> var1, @NotNull Function0<? extends BlockEntityRendererProvider<T>> var2);
    }
}

