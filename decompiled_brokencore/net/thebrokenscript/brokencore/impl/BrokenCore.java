/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.packs.resources.PreparableReloadListener
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 *  org.jetbrains.annotations.ApiStatus$Internal
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.thebrokenscript.brokencore.api.client.level.FakeTimeOfDay;
import net.thebrokenscript.brokencore.api.engine.EventEngine;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.RegistryEvents;
import net.thebrokenscript.brokencore.api.util.reflect.AnnotationScannerKt;
import net.thebrokenscript.brokencore.impl.ForceRuntimeInit;
import net.thebrokenscript.brokencore.impl.commands.BCCommands;
import net.thebrokenscript.brokencore.impl.config.BCConfigs;
import net.thebrokenscript.brokencore.impl.event.StoryEvents;
import net.thebrokenscript.brokencore.impl.registry.BCReg;
import net.thebrokenscript.brokencore.impl.resources.ReloadListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\rH\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/brokencore/impl/BrokenCore;", "", "<init>", "()V", "LOGGER", "Lorg/apache/logging/log4j/Logger;", "init", "", "tick", "server", "Lnet/minecraft/server/MinecraftServer;", "id", "Lnet/minecraft/resources/ResourceLocation;", "", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nBrokenCore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BrokenCore.kt\nnet/thebrokenscript/brokencore/impl/BrokenCore\n+ 2 ForceClassInitializer.kt\nnet/thebrokenscript/brokencore/api/util/reflect/ForceClassInitializerKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,81:1\n12#2,3:82\n15#2,2:86\n1869#3:85\n1870#3:88\n*S KotlinDebug\n*F\n+ 1 BrokenCore.kt\nnet/thebrokenscript/brokencore/impl/BrokenCore\n*L\n53#1:82,3\n53#1:86,2\n53#1:85\n53#1:88\n*E\n"})
public final class BrokenCore {
    @NotNull
    public static final BrokenCore INSTANCE = new BrokenCore();
    @JvmField
    @ApiStatus.Internal
    @NotNull
    public static final Logger LOGGER;

    private BrokenCore() {
    }

    @ApiStatus.Internal
    public final void init() {
        ClassLoader classLoader = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass().getClassLoader();
        Intrinsics.checkNotNullExpressionValue((Object)classLoader, (String)"getClassLoader(...)");
        ClassLoader classLoader$iv = classLoader;
        boolean $i$f$forceInitializeClasses = false;
        Iterable $this$forEach$iv$iv = AnnotationScannerKt.scanClasses(ForceRuntimeInit.class, true, classLoader$iv);
        boolean $i$f$forEach = false;
        for (Object element$iv$iv : $this$forEach$iv$iv) {
            String it$iv = (String)element$iv$iv;
            boolean bl = false;
            Class.forName(it$iv, true, classLoader$iv);
        }
        BCConfigs.INSTANCE.init();
        BCReg.INSTANCE.reloadListener((PreparableReloadListener)ReloadListener.INSTANCE);
        GameEvent.Companion.on(RegistryEvents.REGISTER_COMMANDS, BrokenCore::init$lambda$0);
    }

    @ApiStatus.Internal
    public final void tick(@NotNull MinecraftServer server) {
        Intrinsics.checkNotNullParameter((Object)server, (String)"server");
        FakeTimeOfDay.INSTANCE.tick();
        EventEngine.INSTANCE.tick(server);
        StoryEvents.INSTANCE.tick(server);
    }

    @JvmStatic
    @NotNull
    public static final ResourceLocation id(@NotNull String id) {
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath((String)"brokencore", (String)id);
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"fromNamespaceAndPath(...)");
        return resourceLocation;
    }

    private static final Unit init$lambda$0(RegistryEvents.RegisterCommands $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        BCCommands.INSTANCE.register($this$on.getDispatcher());
        return Unit.INSTANCE;
    }

    static {
        Logger logger = LogManager.getLogger(BrokenCore.class);
        Intrinsics.checkNotNullExpressionValue((Object)logger, (String)"getLogger(...)");
        LOGGER = logger;
    }
}

