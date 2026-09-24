/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.gui.screens.Screen
 *  net.minecraft.world.inventory.AbstractContainerMenu
 *  net.minecraft.world.inventory.MenuType
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.registry.handlers;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.thebrokenscript.brokencore.api.registry.builders.interfaces.ScreenFactory;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR(\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00070\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/handlers/ClientMenuHandler;", "", "<init>", "()V", "screens", "", "", "Lnet/thebrokenscript/brokencore/api/registry/handlers/ClientMenuHandler$ScreenInfo;", "getScreens$brokencore_common", "()Ljava/util/Map;", "pushScreens", "", "cons", "Lnet/thebrokenscript/brokencore/api/registry/handlers/ClientMenuHandler$Consumer;", "ScreenInfo", "Consumer", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nClientMenuHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClientMenuHandler.kt\nnet/thebrokenscript/brokencore/api/registry/handlers/ClientMenuHandler\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,45:1\n1869#2,2:46\n*S KotlinDebug\n*F\n+ 1 ClientMenuHandler.kt\nnet/thebrokenscript/brokencore/api/registry/handlers/ClientMenuHandler\n*L\n19#1:46,2\n*E\n"})
public final class ClientMenuHandler {
    @NotNull
    public static final ClientMenuHandler INSTANCE = new ClientMenuHandler();
    @NotNull
    private static final Map<String, ScreenInfo<?, ?>> screens = new LinkedHashMap();

    private ClientMenuHandler() {
    }

    @NotNull
    public final Map<String, ScreenInfo<?, ?>> getScreens$brokencore_common() {
        return screens;
    }

    public final void pushScreens(@NotNull Consumer cons) {
        Intrinsics.checkNotNullParameter((Object)cons, (String)"cons");
        Iterable $this$forEach$iv = screens.values();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ScreenInfo info = (ScreenInfo)element$iv;
            boolean bl = false;
            info.push(cons);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JN\u0010\u0002\u001a\u00020\u0003\"\b\b\u0000\u0010\u0004*\u00020\u0005\"\u0012\b\u0001\u0010\u0006*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00040\b2\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b0\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00060\rH&\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/handlers/ClientMenuHandler$Consumer;", "", "registerScreen", "", "M", "Lnet/minecraft/world/inventory/AbstractContainerMenu;", "S", "Lnet/minecraft/client/gui/screens/Screen;", "Lnet/minecraft/client/gui/screens/inventory/MenuAccess;", "menuType", "Lkotlin/Function0;", "Lnet/minecraft/world/inventory/MenuType;", "screen", "Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/ScreenFactory;", "brokencore-common"})
    public static interface Consumer {
        public <M extends AbstractContainerMenu, S extends Screen> void registerScreen(@NotNull Function0<? extends MenuType<M>> var1, @NotNull ScreenFactory<M, S> var2);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0012\b\u0001\u0010\u0003*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00010\u00052\u00020\u0006B/\u0012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\b\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/handlers/ClientMenuHandler$ScreenInfo;", "M", "Lnet/minecraft/world/inventory/AbstractContainerMenu;", "S", "Lnet/minecraft/client/gui/screens/Screen;", "Lnet/minecraft/client/gui/screens/inventory/MenuAccess;", "", "menuType", "Lkotlin/Function0;", "Lnet/minecraft/world/inventory/MenuType;", "screen", "Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/ScreenFactory;", "<init>", "(Lkotlin/jvm/functions/Function0;Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/ScreenFactory;)V", "push", "", "cons", "Lnet/thebrokenscript/brokencore/api/registry/handlers/ClientMenuHandler$Consumer;", "brokencore-common"})
    public static final class ScreenInfo<M extends AbstractContainerMenu, S extends Screen> {
        @NotNull
        private final Function0<MenuType<M>> menuType;
        @NotNull
        private final ScreenFactory<M, S> screen;

        public ScreenInfo(@NotNull Function0<? extends MenuType<M>> menuType, @NotNull ScreenFactory<M, S> screen) {
            Intrinsics.checkNotNullParameter(menuType, (String)"menuType");
            Intrinsics.checkNotNullParameter(screen, (String)"screen");
            this.menuType = menuType;
            this.screen = screen;
        }

        public final void push(@NotNull Consumer cons) {
            Intrinsics.checkNotNullParameter((Object)cons, (String)"cons");
            cons.registerScreen(this.menuType, this.screen);
        }
    }
}

