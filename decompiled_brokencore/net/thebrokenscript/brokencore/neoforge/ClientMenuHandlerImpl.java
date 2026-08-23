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
 *  net.minecraft.client.gui.screens.Screen
 *  net.minecraft.world.inventory.AbstractContainerMenu
 *  net.minecraft.world.inventory.MenuType
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.EventBusSubscriber
 *  net.neoforged.neoforge.client.event.RegisterMenuScreensEvent
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
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.thebrokenscript.brokencore.api.registry.builders.interfaces.ScreenFactory;
import net.thebrokenscript.brokencore.api.registry.handlers.ClientMenuHandler;
import net.thebrokenscript.brokencore.neoforge.BCNeoForge;
import org.jetbrains.annotations.NotNull;

@OnlyIn(value=Dist.CLIENT)
@EventBusSubscriber(value={Dist.CLIENT})
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0007H\u0007JN\u0010\r\u001a\u00020\b\"\b\b\u0000\u0010\u000e*\u00020\u000f\"\u0012\b\u0001\u0010\u0010*\u00020\u0011*\b\u0012\u0004\u0012\u0002H\u000e0\u00122\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u00150\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u00100\u0017H\u0016R \u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Lnet/thebrokenscript/brokencore/neoforge/ClientMenuHandlerImpl;", "Lnet/thebrokenscript/brokencore/api/registry/handlers/ClientMenuHandler$Consumer;", "<init>", "()V", "screenQueue", "", "Lkotlin/Function1;", "Lnet/neoforged/neoforge/client/event/RegisterMenuScreensEvent;", "", "registeredScreens", "", "registerScreens", "event", "registerScreen", "M", "Lnet/minecraft/world/inventory/AbstractContainerMenu;", "S", "Lnet/minecraft/client/gui/screens/Screen;", "Lnet/minecraft/client/gui/screens/inventory/MenuAccess;", "menuType", "Lkotlin/Function0;", "Lnet/minecraft/world/inventory/MenuType;", "screen", "Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/ScreenFactory;", "brokencore-neoforge"})
@SourceDebugExtension(value={"SMAP\nClientMenuHandlerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClientMenuHandlerImpl.kt\nnet/thebrokenscript/brokencore/neoforge/ClientMenuHandlerImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,45:1\n1869#2,2:46\n*S KotlinDebug\n*F\n+ 1 ClientMenuHandlerImpl.kt\nnet/thebrokenscript/brokencore/neoforge/ClientMenuHandlerImpl\n*L\n30#1:46,2\n*E\n"})
public final class ClientMenuHandlerImpl
implements ClientMenuHandler.Consumer {
    @NotNull
    public static final ClientMenuHandlerImpl INSTANCE = new ClientMenuHandlerImpl();
    @NotNull
    private static final List<Function1<RegisterMenuScreensEvent, Unit>> screenQueue = new ArrayList();
    private static boolean registeredScreens;

    private ClientMenuHandlerImpl() {
    }

    @JvmStatic
    @SubscribeEvent
    public static final void registerScreens(@NotNull RegisterMenuScreensEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        if (registeredScreens) {
            return;
        }
        ClientMenuHandler.INSTANCE.pushScreens(INSTANCE);
        BCNeoForge.LOGGER.info("Registering menu screens!");
        Iterable $this$forEach$iv = screenQueue;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Function1 it = (Function1)element$iv;
            boolean bl = false;
            it.invoke((Object)event);
        }
        registeredScreens = true;
    }

    @Override
    public <M extends AbstractContainerMenu, S extends Screen> void registerScreen(@NotNull Function0<? extends MenuType<M>> menuType, @NotNull ScreenFactory<M, S> screen) {
        Intrinsics.checkNotNullParameter(menuType, (String)"menuType");
        Intrinsics.checkNotNullParameter(screen, (String)"screen");
        if (registeredScreens) {
            throw new IllegalStateException("Menu screens have already been registered, cannot re-register!");
        }
        screenQueue.add((Function1<RegisterMenuScreensEvent, Unit>)((Function1)arg_0 -> ClientMenuHandlerImpl.registerScreen$lambda$0(menuType, screen, arg_0)));
    }

    private static final Unit registerScreen$lambda$0(Function0 $menuType, ScreenFactory $screen, RegisterMenuScreensEvent it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        it.register((MenuType)$menuType.invoke(), $screen::create);
        return Unit.INSTANCE;
    }
}

