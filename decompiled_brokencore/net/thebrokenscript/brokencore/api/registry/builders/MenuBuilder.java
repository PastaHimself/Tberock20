/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.gui.screens.Screen
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.flag.FeatureFlagSet
 *  net.minecraft.world.flag.FeatureFlags
 *  net.minecraft.world.inventory.AbstractContainerMenu
 *  net.minecraft.world.inventory.MenuType
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.registry.builders;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.thebrokenscript.brokencore.api.ext.KFuncExt;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.builders.AbstractBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.interfaces.MenuConstructor;
import net.thebrokenscript.brokencore.api.registry.builders.interfaces.ScreenFactory;
import net.thebrokenscript.brokencore.api.registry.dsl.RegistryDslMarker;
import net.thebrokenscript.brokencore.api.registry.entries.CustomMenuType;
import net.thebrokenscript.brokencore.api.registry.handlers.ClientMenuHandler;
import net.thebrokenscript.brokencore.api.registry.objects.MenuEntry;
import net.thebrokenscript.brokencore.api.util.Side;
import org.jetbrains.annotations.NotNull;

@RegistryDslMarker
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u000220\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0000\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00060\u0003B%\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f\u00a2\u0006\u0004\b\r\u0010\u000eJ:\u0010\u001a\u001a\u00020\u0013\"\u0012\b\u0001\u0010\u001b*\u00020\u001c*\b\u0012\u0004\u0012\u00028\u00000\u001d2\u001e\u0010\u001e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u001b0 0\u001f0\u001fJ\u0016\u0010!\u001a\u00020\u00132\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0014J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0014J \u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0010\u0010%\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040&H\u0016R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R,\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0004\u0012\u00020\u00130\u0012X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006'"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/MenuBuilder;", "M", "Lnet/minecraft/world/inventory/AbstractContainerMenu;", "Lnet/thebrokenscript/brokencore/api/registry/builders/AbstractBuilder;", "Lnet/minecraft/world/inventory/MenuType;", "Lnet/thebrokenscript/brokencore/api/registry/entries/CustomMenuType;", "Lnet/thebrokenscript/brokencore/api/registry/objects/MenuEntry;", "parent", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "name", "", "ctor", "Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/MenuConstructor;", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Ljava/lang/String;Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/MenuConstructor;)V", "getCtor", "()Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/MenuConstructor;", "clientRegisterCallback", "Lkotlin/Function1;", "", "getClientRegisterCallback", "()Lkotlin/jvm/functions/Function1;", "setClientRegisterCallback", "(Lkotlin/jvm/functions/Function1;)V", "featureFlags", "Lnet/minecraft/world/flag/FeatureFlagSet;", "setScreen", "S", "Lnet/minecraft/client/gui/screens/Screen;", "Lnet/minecraft/client/gui/screens/inventory/MenuAccess;", "value", "Lkotlin/Function0;", "Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/ScreenFactory;", "onRegistered", "entry", "createObject", "createEntry", "key", "Lnet/minecraft/resources/ResourceKey;", "brokencore-common"})
public class MenuBuilder<M extends AbstractContainerMenu>
extends AbstractBuilder<MenuBuilder<M>, MenuType<?>, CustomMenuType<M>, MenuEntry<M>> {
    @NotNull
    private final MenuConstructor<M> ctor;
    @NotNull
    private Function1<? super MenuEntry<M>, Unit> clientRegisterCallback;
    @JvmField
    @NotNull
    public FeatureFlagSet featureFlags;

    public MenuBuilder(@NotNull BrokenReg parent, @NotNull String name, @NotNull MenuConstructor<M> ctor) {
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        ResourceKey resourceKey = Registries.MENU;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"MENU");
        super(parent, resourceKey, name);
        this.ctor = ctor;
        this.clientRegisterCallback = MenuBuilder::clientRegisterCallback$lambda$0;
        FeatureFlagSet featureFlagSet = FeatureFlags.DEFAULT_FLAGS;
        Intrinsics.checkNotNullExpressionValue((Object)featureFlagSet, (String)"DEFAULT_FLAGS");
        this.featureFlags = featureFlagSet;
    }

    @NotNull
    protected final MenuConstructor<M> getCtor() {
        return this.ctor;
    }

    @NotNull
    protected final Function1<MenuEntry<M>, Unit> getClientRegisterCallback() {
        return this.clientRegisterCallback;
    }

    protected final void setClientRegisterCallback(@NotNull Function1<? super MenuEntry<M>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, (String)"<set-?>");
        this.clientRegisterCallback = function1;
    }

    public final <S extends Screen> void setScreen(@NotNull Function0<? extends Function0<? extends ScreenFactory<M, S>>> value) {
        Intrinsics.checkNotNullParameter(value, (String)"value");
        PlatformUtil.Companion.runWhenOn(Side.CLIENT, (Function0<? extends Function0<Unit>>)((Function0)() -> MenuBuilder.setScreen$lambda$0(value, this)));
    }

    @Override
    protected void onRegistered(@NotNull MenuEntry<M> entry) {
        Intrinsics.checkNotNullParameter(entry, (String)"entry");
        PlatformUtil.Companion.runWhenOn(Side.CLIENT, (Function0<? extends Function0<Unit>>)((Function0)() -> MenuBuilder.onRegistered$lambda$0(this, entry)));
    }

    @Override
    @NotNull
    protected CustomMenuType<M> createObject() {
        return new CustomMenuType<M>(this.ctor, this.featureFlags);
    }

    @Override
    @NotNull
    public MenuEntry<M> createEntry(@NotNull ResourceKey<MenuType<?>> key) {
        Intrinsics.checkNotNullParameter(key, (String)"key");
        return new MenuEntry(key);
    }

    private static final Unit clientRegisterCallback$lambda$0(MenuEntry it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return Unit.INSTANCE;
    }

    private static final Function0 setScreen$lambda$0(Function0 $value, MenuBuilder this$0) {
        return () -> MenuBuilder.setScreen$lambda$0$0($value, this$0);
    }

    private static final Unit setScreen$lambda$0$0(Function0 $value, MenuBuilder this$0) {
        Function0 value = $value;
        boolean bl = false;
        this$0.clientRegisterCallback = KFuncExt.INSTANCE.chain(this$0.clientRegisterCallback, arg_0 -> MenuBuilder.setScreen$lambda$0$0$0$0(this$0, value, arg_0));
        return Unit.INSTANCE;
    }

    private static final Unit setScreen$lambda$0$0$0$0(MenuBuilder this$0, Function0 $value, MenuEntry it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ClientMenuHandler.INSTANCE.getScreens$brokencore_common().put(this$0.getName(), new ClientMenuHandler.ScreenInfo((Function0)new Function0<CustomMenuType<M>>(it){

            public final CustomMenuType<M> invoke() {
                return (CustomMenuType)((Object)((MenuEntry)this.receiver).get());
            }
        }, (ScreenFactory)((Function0)$value.invoke()).invoke()));
        return Unit.INSTANCE;
    }

    private static final Function0 onRegistered$lambda$0(MenuBuilder this$0, MenuEntry $entry) {
        return () -> MenuBuilder.onRegistered$lambda$0$0(this$0, $entry);
    }

    private static final Unit onRegistered$lambda$0$0(MenuBuilder this$0, MenuEntry $entry) {
        this$0.clientRegisterCallback.invoke((Object)$entry);
        return Unit.INSTANCE;
    }
}

