/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.model.geom.ModelLayerLocation
 *  net.minecraft.client.model.geom.builders.LayerDefinition
 *  net.minecraft.client.renderer.entity.EntityRendererProvider
 *  net.minecraft.world.entity.Entity
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.registry.handlers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.thebrokenscript.brokencore.api.registry.objects.EntityEntry;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import org.jetbrains.annotations.NotNull;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u001e\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR&\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\nX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0018"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/handlers/ClientEntityHandler;", "", "<init>", "()V", "renderers", "", "Lnet/thebrokenscript/brokencore/api/registry/handlers/ClientEntityHandler$EntityRendererInfo;", "getRenderers$brokencore_common", "()Ljava/util/List;", "layers", "", "Lnet/minecraft/client/model/geom/ModelLayerLocation;", "Ljava/util/function/Supplier;", "Lnet/minecraft/client/model/geom/builders/LayerDefinition;", "getLayers$brokencore_common", "()Ljava/util/Map;", "pushAll", "", "cons", "Lnet/thebrokenscript/brokencore/api/registry/handlers/ClientEntityHandler$Consumer;", "pushRenderers", "pushLayers", "EntityRendererInfo", "Consumer", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nClientEntityHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClientEntityHandler.kt\nnet/thebrokenscript/brokencore/api/registry/handlers/ClientEntityHandler\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,79:1\n1869#2,2:80\n216#3,2:82\n*S KotlinDebug\n*F\n+ 1 ClientEntityHandler.kt\nnet/thebrokenscript/brokencore/api/registry/handlers/ClientEntityHandler\n*L\n39#1:80,2\n46#1:82,2\n*E\n"})
public final class ClientEntityHandler {
    @NotNull
    public static final ClientEntityHandler INSTANCE = new ClientEntityHandler();
    @NotNull
    private static final List<EntityRendererInfo<?>> renderers = new ArrayList();
    @NotNull
    private static final Map<ModelLayerLocation, Supplier<LayerDefinition>> layers = new LinkedHashMap();

    private ClientEntityHandler() {
    }

    @NotNull
    public final List<EntityRendererInfo<?>> getRenderers$brokencore_common() {
        return renderers;
    }

    @NotNull
    public final Map<ModelLayerLocation, Supplier<LayerDefinition>> getLayers$brokencore_common() {
        return layers;
    }

    public final void pushAll(@NotNull Consumer cons) {
        Intrinsics.checkNotNullParameter((Object)cons, (String)"cons");
        this.pushRenderers(cons);
        this.pushLayers(cons);
    }

    public final void pushRenderers(@NotNull Consumer cons) {
        Intrinsics.checkNotNullParameter((Object)cons, (String)"cons");
        Iterable $this$forEach$iv = renderers;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            EntityRendererInfo info = (EntityRendererInfo)element$iv;
            boolean bl = false;
            info.push(cons);
        }
    }

    public final void pushLayers(@NotNull Consumer cons) {
        Intrinsics.checkNotNullParameter((Object)cons, (String)"cons");
        Map<ModelLayerLocation, Supplier<LayerDefinition>> $this$forEach$iv = layers;
        boolean $i$f$forEach = false;
        Iterator<Map.Entry<ModelLayerLocation, Supplier<LayerDefinition>>> iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<ModelLayerLocation, Supplier<LayerDefinition>> element$iv;
            Map.Entry<ModelLayerLocation, Supplier<LayerDefinition>> entry = element$iv = iterator.next();
            boolean bl = false;
            ModelLayerLocation loc = entry.getKey();
            Supplier<LayerDefinition> def = entry.getValue();
            cons.layer(loc, def);
        }
    }

    @SideOnly(side=Side.CLIENT)
    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00072\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\t0\bH&J\u001e\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/handlers/ClientEntityHandler$Consumer;", "", "renderer", "", "T", "Lnet/minecraft/world/entity/Entity;", "entry", "Lnet/thebrokenscript/brokencore/api/registry/objects/EntityEntry;", "Lkotlin/Function0;", "Lnet/minecraft/client/renderer/entity/EntityRendererProvider;", "layer", "loc", "Lnet/minecraft/client/model/geom/ModelLayerLocation;", "def", "Ljava/util/function/Supplier;", "Lnet/minecraft/client/model/geom/builders/LayerDefinition;", "brokencore-common"})
    public static interface Consumer {
        public <T extends Entity> void renderer(@NotNull EntityEntry<T> var1, @NotNull Function0<? extends EntityRendererProvider<T>> var2);

        public void layer(@NotNull ModelLayerLocation var1, @NotNull Supplier<LayerDefinition> var2);
    }

    @SideOnly(side=Side.CLIENT)
    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/handlers/ClientEntityHandler$EntityRendererInfo;", "T", "Lnet/minecraft/world/entity/Entity;", "", "entry", "Lnet/thebrokenscript/brokencore/api/registry/objects/EntityEntry;", "renderer", "Lkotlin/Function0;", "Lnet/minecraft/client/renderer/entity/EntityRendererProvider;", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/objects/EntityEntry;Lkotlin/jvm/functions/Function0;)V", "push", "", "cons", "Lnet/thebrokenscript/brokencore/api/registry/handlers/ClientEntityHandler$Consumer;", "brokencore-common"})
    public static final class EntityRendererInfo<T extends Entity> {
        @NotNull
        private final EntityEntry<T> entry;
        @NotNull
        private final Function0<EntityRendererProvider<T>> renderer;

        public EntityRendererInfo(@NotNull EntityEntry<T> entry, @NotNull Function0<? extends EntityRendererProvider<T>> renderer) {
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
}

