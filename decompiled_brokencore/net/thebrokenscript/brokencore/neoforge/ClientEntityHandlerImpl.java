/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.model.geom.ModelLayerLocation
 *  net.minecraft.client.model.geom.builders.LayerDefinition
 *  net.minecraft.client.renderer.entity.EntityRendererProvider
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.EventBusSubscriber
 *  net.neoforged.neoforge.client.event.EntityRenderersEvent$RegisterLayerDefinitions
 *  net.neoforged.neoforge.client.event.EntityRenderersEvent$RegisterRenderers
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.neoforge;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.thebrokenscript.brokencore.api.registry.handlers.ClientEntityHandler;
import net.thebrokenscript.brokencore.api.registry.objects.EntityEntry;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.brokencore.neoforge.BCNeoForge;
import org.jetbrains.annotations.NotNull;

@SideOnly(side=Side.CLIENT)
@EventBusSubscriber(value={Dist.CLIENT})
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0007H\u0007J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\fH\u0007J4\u0010\u0011\u001a\u00020\b\"\b\b\u0000\u0010\u0012*\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00152\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u00170\u0016H\u0016J\u001e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016R \u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2={"Lnet/thebrokenscript/brokencore/neoforge/ClientEntityHandlerImpl;", "Lnet/thebrokenscript/brokencore/api/registry/handlers/ClientEntityHandler$Consumer;", "<init>", "()V", "rendererQueue", "", "Lkotlin/Function1;", "Lnet/neoforged/neoforge/client/event/EntityRenderersEvent$RegisterRenderers;", "", "registeredRenderers", "", "layerQueue", "Lnet/neoforged/neoforge/client/event/EntityRenderersEvent$RegisterLayerDefinitions;", "registeredLayers", "registerRenderers", "event", "registerLayers", "renderer", "T", "Lnet/minecraft/world/entity/Entity;", "entry", "Lnet/thebrokenscript/brokencore/api/registry/objects/EntityEntry;", "Lkotlin/Function0;", "Lnet/minecraft/client/renderer/entity/EntityRendererProvider;", "layer", "loc", "Lnet/minecraft/client/model/geom/ModelLayerLocation;", "def", "Ljava/util/function/Supplier;", "Lnet/minecraft/client/model/geom/builders/LayerDefinition;", "brokencore-neoforge"})
@SourceDebugExtension(value={"SMAP\nClientEntityHandlerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClientEntityHandlerImpl.kt\nnet/thebrokenscript/brokencore/neoforge/ClientEntityHandlerImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,74:1\n1869#2,2:75\n1869#2,2:77\n*S KotlinDebug\n*F\n+ 1 ClientEntityHandlerImpl.kt\nnet/thebrokenscript/brokencore/neoforge/ClientEntityHandlerImpl\n*L\n35#1:75,2\n48#1:77,2\n*E\n"})
public final class ClientEntityHandlerImpl
implements ClientEntityHandler.Consumer {
    @NotNull
    public static final ClientEntityHandlerImpl INSTANCE = new ClientEntityHandlerImpl();
    @NotNull
    private static final List<Function1<EntityRenderersEvent.RegisterRenderers, Unit>> rendererQueue = new ArrayList();
    private static boolean registeredRenderers;
    @NotNull
    private static final List<Function1<EntityRenderersEvent.RegisterLayerDefinitions, Unit>> layerQueue;
    private static boolean registeredLayers;

    private ClientEntityHandlerImpl() {
    }

    @JvmStatic
    @SubscribeEvent
    public static final void registerRenderers(@NotNull EntityRenderersEvent.RegisterRenderers event) {
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        if (registeredRenderers) {
            return;
        }
        ClientEntityHandler.INSTANCE.pushRenderers(INSTANCE);
        BCNeoForge.LOGGER.info("Registering entity renderers!");
        Iterable $this$forEach$iv = rendererQueue;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Function1 it = (Function1)element$iv;
            boolean bl = false;
            it.invoke((Object)event);
        }
        registeredRenderers = true;
    }

    @JvmStatic
    @SubscribeEvent
    public static final void registerLayers(@NotNull EntityRenderersEvent.RegisterLayerDefinitions event) {
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        if (registeredLayers) {
            return;
        }
        ClientEntityHandler.INSTANCE.pushLayers(INSTANCE);
        BCNeoForge.LOGGER.info("Registering model layers!");
        Iterable $this$forEach$iv = layerQueue;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Function1 it = (Function1)element$iv;
            boolean bl = false;
            it.invoke((Object)event);
        }
        registeredLayers = true;
    }

    @Override
    public <T extends Entity> void renderer(@NotNull EntityEntry<T> entry, @NotNull Function0<? extends EntityRendererProvider<T>> renderer) {
        Intrinsics.checkNotNullParameter(entry, (String)"entry");
        Intrinsics.checkNotNullParameter(renderer, (String)"renderer");
        if (registeredRenderers) {
            throw new IllegalStateException("Entity renderers have already been registered, cannot re-register!");
        }
        rendererQueue.add((Function1<EntityRenderersEvent.RegisterRenderers, Unit>)((Function1)arg_0 -> ClientEntityHandlerImpl.renderer$lambda$0(entry, renderer, arg_0)));
    }

    @Override
    public void layer(@NotNull ModelLayerLocation loc, @NotNull Supplier<LayerDefinition> def) {
        Intrinsics.checkNotNullParameter((Object)loc, (String)"loc");
        Intrinsics.checkNotNullParameter(def, (String)"def");
        if (registeredLayers) {
            throw new IllegalStateException("Model layers have already been registered, cannot re-register!");
        }
        layerQueue.add((Function1<EntityRenderersEvent.RegisterLayerDefinitions, Unit>)((Function1)arg_0 -> ClientEntityHandlerImpl.layer$lambda$0(loc, def, arg_0)));
    }

    private static final Unit renderer$lambda$0(EntityEntry $entry, Function0 $renderer, EntityRenderersEvent.RegisterRenderers it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        it.registerEntityRenderer((EntityType)$entry.get(), (EntityRendererProvider)$renderer.invoke());
        return Unit.INSTANCE;
    }

    private static final Unit layer$lambda$0(ModelLayerLocation $loc, Supplier $def, EntityRenderersEvent.RegisterLayerDefinitions it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        it.registerLayerDefinition($loc, $def);
        return Unit.INSTANCE;
    }

    static {
        layerQueue = new ArrayList();
    }
}

