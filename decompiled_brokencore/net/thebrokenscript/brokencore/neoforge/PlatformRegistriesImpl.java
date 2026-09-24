/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.optionals.OptionalsKt
 *  net.minecraft.core.Registry
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.data.DataGenerator
 *  net.minecraft.data.DataProvider
 *  net.minecraft.data.PackOutput
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.packs.resources.PreparableReloadListener
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.neoforged.bus.api.IEventBus
 *  net.neoforged.fml.ModContainer
 *  net.neoforged.fml.ModList
 *  net.neoforged.neoforge.common.NeoForge
 *  net.neoforged.neoforge.data.event.GatherDataEvent
 *  net.neoforged.neoforge.event.AddReloadListenerEvent
 *  net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent
 *  net.neoforged.neoforge.registries.RegisterEvent
 *  net.neoforged.neoforge.registries.RegistryBuilder
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.neoforge;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.optionals.OptionalsKt;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.AddReloadListenerEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import net.neoforged.neoforge.registries.RegistryBuilder;
import net.thebrokenscript.brokencore.api.platform.PlatformRegistries;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.brokencore.impl.BrokenCore;
import net.thebrokenscript.brokencore.impl.config.BCConfigs;
import net.thebrokenscript.brokencore.impl.registry.RegistrationHandler;
import net.thebrokenscript.brokencore.neoforge.BiomeSpawnGenerator;
import net.thebrokenscript.brokencore.neoforge.PlatformRegistriesImpl;
import net.thebrokenscript.brokencore.neoforge.PlatformRegistryEvents;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005H\u0016J(\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00050\nH\u0016J6\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00050\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00060\nH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/brokencore/neoforge/PlatformRegistriesImpl;", "Lnet/thebrokenscript/brokencore/api/platform/PlatformRegistries;", "<init>", "()V", "registerRegistry", "Lnet/minecraft/core/Registry;", "T", "registry", "createSyncedRegistry", "key", "Lnet/minecraft/resources/ResourceKey;", "createDefaultedSyncedRegistry", "defaultKey", "setup", "", "reg", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "brokencore-neoforge"})
@SourceDebugExtension(value={"SMAP\nPlatformRegistriesImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlatformRegistriesImpl.kt\nnet/thebrokenscript/brokencore/neoforge/PlatformRegistriesImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,104:1\n1#2:105\n1869#3,2:106\n*S KotlinDebug\n*F\n+ 1 PlatformRegistriesImpl.kt\nnet/thebrokenscript/brokencore/neoforge/PlatformRegistriesImpl\n*L\n87#1:106,2\n*E\n"})
public final class PlatformRegistriesImpl
implements PlatformRegistries {
    @Override
    @NotNull
    public <T> Registry<T> registerRegistry(@NotNull Registry<T> registry) {
        Registry<T> registry2;
        Intrinsics.checkNotNullParameter(registry, (String)"registry");
        Registry<T> it = registry2 = registry;
        boolean bl = false;
        PlatformRegistryEvents.INSTANCE.getRegistries$brokencore_neoforge().add(it);
        return registry2;
    }

    @Override
    @NotNull
    public <T> Registry<T> createSyncedRegistry(@NotNull ResourceKey<Registry<T>> key) {
        Intrinsics.checkNotNullParameter(key, (String)"key");
        Registry registry = new RegistryBuilder(key).sync(true).create();
        Intrinsics.checkNotNullExpressionValue((Object)registry, (String)"create(...)");
        return this.registerRegistry(registry);
    }

    @Override
    @NotNull
    public <T> Registry<T> createDefaultedSyncedRegistry(@NotNull ResourceKey<Registry<T>> key, @NotNull ResourceKey<T> defaultKey) {
        Intrinsics.checkNotNullParameter(key, (String)"key");
        Intrinsics.checkNotNullParameter(defaultKey, (String)"defaultKey");
        Registry registry = new RegistryBuilder(key).defaultKey(defaultKey).sync(true).create();
        Intrinsics.checkNotNullExpressionValue((Object)registry, (String)"create(...)");
        return this.registerRegistry(registry);
    }

    @Override
    public void setup(@NotNull BrokenReg reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        Optional optional = ModList.get().getModContainerById(reg.getModId());
        Intrinsics.checkNotNullExpressionValue((Object)optional, (String)"getModContainerById(...)");
        ModContainer modContainer = (ModContainer)OptionalsKt.getOrNull((Optional)optional);
        Object object = modContainer != null ? modContainer.getEventBus() : null;
        if (object == null) {
            boolean bl = false;
            String string = "Could not get mod event bus for " + reg.getModId() + "!";
            throw new IllegalStateException(string.toString());
        }
        IEventBus modBus = object;
        modBus.addListener(RegisterEvent.class, arg_0 -> PlatformRegistriesImpl.setup$lambda$1(reg, arg_0));
        modBus.addListener(BuildCreativeModeTabContentsEvent.class, arg_0 -> PlatformRegistriesImpl.setup$lambda$2(reg, arg_0));
        modBus.addListener(GatherDataEvent.class, arg_0 -> PlatformRegistriesImpl.setup$lambda$3(reg, arg_0));
        NeoForge.EVENT_BUS.addListener(AddReloadListenerEvent.class, arg_0 -> PlatformRegistriesImpl.setup$lambda$4(reg, arg_0));
    }

    private static final void setup$lambda$1(BrokenReg $reg, RegisterEvent event) {
        $reg.registerAll(new RegistrationHandler(event){
            final /* synthetic */ RegisterEvent $event;
            {
                this.$event = $event;
            }

            public <R, T extends R, E extends RegistryEntry<R, T>> E register(ResourceKey<Registry<R>> registry, ResourceLocation id, Function0<? extends T> getter, Function1<? super E, Unit> callback, Function1<? super ResourceKey<R>, ? extends E> entryCtor) {
                Intrinsics.checkNotNullParameter(registry, (String)"registry");
                Intrinsics.checkNotNullParameter((Object)id, (String)"id");
                Intrinsics.checkNotNullParameter(getter, (String)"getter");
                Intrinsics.checkNotNullParameter(callback, (String)"callback");
                Intrinsics.checkNotNullParameter(entryCtor, (String)"entryCtor");
                if (BCConfigs.INSTANCE.getStartup().getDebug().getRegistryDebugLogging()) {
                    BrokenCore.LOGGER.debug("Registering {} to registry {}...", (Object)id, (Object)registry.location());
                }
                this.$event.register(registry, id, () -> setup.1.1.register$lambda$0(getter));
                ResourceKey resourceKey = ResourceKey.create(registry, (ResourceLocation)id);
                Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"create(...)");
                Object object = entryCtor.invoke((Object)resourceKey);
                RegistryEntry it = (RegistryEntry)object;
                boolean bl = false;
                callback.invoke((Object)it);
                return (E)((RegistryEntry)object);
            }

            private static final Object register$lambda$0(Function0 $tmp0) {
                return $tmp0.invoke();
            }
        });
    }

    private static final void setup$lambda$2(BrokenReg $reg, BuildCreativeModeTabContentsEvent event) {
        List<ResourceKey<Item>> list = $reg.getCreativeTabs().get(event.getTabKey());
        if (list == null) {
            return;
        }
        List<ResourceKey<Item>> contents = list;
        for (ResourceKey<Item> item2 : contents) {
            ItemStack stack = ((Item)BuiltInRegistries.ITEM.getOrThrow(item2)).getDefaultInstance();
            if (event.getParentEntries().contains((Object)stack)) continue;
            event.accept(stack);
        }
    }

    private static final void setup$lambda$3(BrokenReg $reg, GatherDataEvent event) {
        PackOutput packOutput = event.getGenerator().getPackOutput();
        Intrinsics.checkNotNullExpressionValue((Object)packOutput, (String)"getPackOutput(...)");
        CompletableFuture completableFuture = event.getLookupProvider();
        Intrinsics.checkNotNullExpressionValue((Object)completableFuture, (String)"getLookupProvider(...)");
        Intrinsics.checkNotNull((Object)event);
        $reg.registerDataGenerators(packOutput, completableFuture, (Function1<? super DataProvider, Unit>)((Function1)new Function1<DataProvider, Unit>((Object)event){

            public final void invoke(DataProvider p0) {
                ((GatherDataEvent)this.receiver).addProvider(p0);
            }
        }));
        if (!((Collection)$reg.getBiomeSpawns()).isEmpty()) {
            DataGenerator dataGenerator = event.getGenerator();
            boolean bl = event.includeServer();
            PackOutput packOutput2 = event.getGenerator().getPackOutput();
            Intrinsics.checkNotNullExpressionValue((Object)packOutput2, (String)"getPackOutput(...)");
            dataGenerator.addProvider(bl, (DataProvider)new BiomeSpawnGenerator(packOutput2, $reg));
        }
    }

    private static final void setup$lambda$4(BrokenReg $reg, AddReloadListenerEvent it) {
        Iterable $this$forEach$iv = $reg.getReloadListeners();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            PreparableReloadListener listener = (PreparableReloadListener)element$iv;
            boolean bl = false;
            it.addListener(listener);
        }
    }
}

