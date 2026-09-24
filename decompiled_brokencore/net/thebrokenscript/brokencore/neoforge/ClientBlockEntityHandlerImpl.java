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
 *  net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.EventBusSubscriber
 *  net.neoforged.neoforge.client.event.EntityRenderersEvent$RegisterRenderers
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.neoforge;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.thebrokenscript.brokencore.api.registry.handlers.ClientBlockEntityHandler;
import net.thebrokenscript.brokencore.api.registry.objects.BlockEntityEntry;
import net.thebrokenscript.brokencore.neoforge.BCNeoForge;
import org.jetbrains.annotations.NotNull;

@OnlyIn(value=Dist.CLIENT)
@EventBusSubscriber(value={Dist.CLIENT})
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0007H\u0007J4\u0010\r\u001a\u00020\b\"\b\b\u0000\u0010\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00112\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u00130\u0012H\u0016R \u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/brokencore/neoforge/ClientBlockEntityHandlerImpl;", "Lnet/thebrokenscript/brokencore/api/registry/handlers/ClientBlockEntityHandler$Consumer;", "<init>", "()V", "rendererQueue", "", "Lkotlin/Function1;", "Lnet/neoforged/neoforge/client/event/EntityRenderersEvent$RegisterRenderers;", "", "registeredRenderers", "", "registerRenderers", "event", "renderer", "T", "Lnet/minecraft/world/level/block/entity/BlockEntity;", "entry", "Lnet/thebrokenscript/brokencore/api/registry/objects/BlockEntityEntry;", "Lkotlin/Function0;", "Lnet/minecraft/client/renderer/blockentity/BlockEntityRendererProvider;", "brokencore-neoforge"})
@SourceDebugExtension(value={"SMAP\nClientBlockEntityHandlerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClientBlockEntityHandlerImpl.kt\nnet/thebrokenscript/brokencore/neoforge/ClientBlockEntityHandlerImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,43:1\n1869#2,2:44\n*S KotlinDebug\n*F\n+ 1 ClientBlockEntityHandlerImpl.kt\nnet/thebrokenscript/brokencore/neoforge/ClientBlockEntityHandlerImpl\n*L\n28#1:44,2\n*E\n"})
public final class ClientBlockEntityHandlerImpl
implements ClientBlockEntityHandler.Consumer {
    @NotNull
    public static final ClientBlockEntityHandlerImpl INSTANCE = new ClientBlockEntityHandlerImpl();
    @NotNull
    private static final List<Function1<EntityRenderersEvent.RegisterRenderers, Unit>> rendererQueue = new ArrayList();
    private static boolean registeredRenderers;

    private ClientBlockEntityHandlerImpl() {
    }

    @JvmStatic
    @SubscribeEvent
    public static final void registerRenderers(@NotNull EntityRenderersEvent.RegisterRenderers event) {
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        if (registeredRenderers) {
            return;
        }
        ClientBlockEntityHandler.INSTANCE.pushRenderers(INSTANCE);
        BCNeoForge.LOGGER.info("Registering block entity renderers!");
        Iterable $this$forEach$iv = rendererQueue;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Function1 it = (Function1)element$iv;
            boolean bl = false;
            it.invoke((Object)event);
        }
        registeredRenderers = true;
    }

    @Override
    public <T extends BlockEntity> void renderer(@NotNull BlockEntityEntry<T> entry, @NotNull Function0<? extends BlockEntityRendererProvider<T>> renderer) {
        Intrinsics.checkNotNullParameter(entry, (String)"entry");
        Intrinsics.checkNotNullParameter(renderer, (String)"renderer");
        if (registeredRenderers) {
            throw new IllegalStateException("Block entity renderers have already been registered, cannot re-register!");
        }
        rendererQueue.add((Function1<EntityRenderersEvent.RegisterRenderers, Unit>)((Function1)arg_0 -> ClientBlockEntityHandlerImpl.renderer$lambda$0(entry, renderer, arg_0)));
    }

    private static final Unit renderer$lambda$0(BlockEntityEntry $entry, Function0 $renderer, EntityRenderersEvent.RegisterRenderers it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        it.registerBlockEntityRenderer((BlockEntityType)$entry.get(), (BlockEntityRendererProvider)$renderer.invoke());
        return Unit.INSTANCE;
    }
}

