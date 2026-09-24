/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.brigadier.CommandDispatcher
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Camera
 *  net.minecraft.client.DeltaTracker
 *  net.minecraft.client.gui.LayeredDraw$Layer
 *  net.minecraft.client.gui.screens.Screen
 *  net.minecraft.client.renderer.LevelRenderer
 *  net.minecraft.client.renderer.culling.Frustum
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.packs.resources.PreparableReloadListener
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.bus.api.IEventBus
 *  net.neoforged.fml.IExtensionPoint
 *  net.neoforged.fml.ModContainer
 *  net.neoforged.fml.ModList
 *  net.neoforged.fml.common.Mod
 *  net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
 *  net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent
 *  net.neoforged.neoforge.client.event.ClientTickEvent$Post
 *  net.neoforged.neoforge.client.event.RegisterClientCommandsEvent
 *  net.neoforged.neoforge.client.event.RegisterClientReloadListenersEvent
 *  net.neoforged.neoforge.client.event.RegisterGuiLayersEvent
 *  net.neoforged.neoforge.client.event.RenderLevelStageEvent
 *  net.neoforged.neoforge.client.event.RenderLevelStageEvent$Stage
 *  net.neoforged.neoforge.client.gui.IConfigScreenFactory
 *  net.neoforged.neoforge.common.NeoForge
 *  net.neoforged.neoforge.event.GameShuttingDownEvent
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Matrix4f
 */
package net.thebrokenscript.brokencore.neoforge;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.brigadier.CommandDispatcher;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.LayeredDraw;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.IExtensionPoint;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterClientCommandsEvent;
import net.neoforged.neoforge.client.event.RegisterClientReloadListenersEvent;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.GameShuttingDownEvent;
import net.thebrokenscript.brokencore.api.client.config.BrokenConfigScreen;
import net.thebrokenscript.brokencore.api.client.event.RenderEvents;
import net.thebrokenscript.brokencore.api.client.event.RenderStage;
import net.thebrokenscript.brokencore.api.client.shader.PostShaderManager;
import net.thebrokenscript.brokencore.api.config.ConfigContainer;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.ClientEvents;
import net.thebrokenscript.brokencore.impl.BrokenCore;
import net.thebrokenscript.brokencore.impl.client.BCClient;
import net.thebrokenscript.brokencore.impl.client.OverlayLayer;
import net.thebrokenscript.brokencore.impl.client.commands.BCClientCommands;
import net.thebrokenscript.brokencore.impl.config.BCConfigs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;

@Mod(value="brokencore", dist={Dist.CLIENT})
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/brokencore/neoforge/BCClientNeoForge;", "", "modBus", "Lnet/neoforged/bus/api/IEventBus;", "<init>", "(Lnet/neoforged/bus/api/IEventBus;)V", "Companion", "brokencore-neoforge"})
@SourceDebugExtension(value={"SMAP\nBCClientNeoForge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BCClientNeoForge.kt\nnet/thebrokenscript/brokencore/neoforge/BCClientNeoForge\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,116:1\n15#2:117\n*S KotlinDebug\n*F\n+ 1 BCClientNeoForge.kt\nnet/thebrokenscript/brokencore/neoforge/BCClientNeoForge\n*L\n44#1:117\n*E\n"})
public final class BCClientNeoForge {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public static final Logger LOGGER;
    private static boolean registeredOverlay;

    public BCClientNeoForge(@NotNull IEventBus modBus) {
        Intrinsics.checkNotNullParameter((Object)modBus, (String)"modBus");
        Object t = ModList.get().getModContainerById("brokencore").get();
        Intrinsics.checkNotNullExpressionValue(t, (String)"get(...)");
        ModContainer mod = (ModContainer)t;
        LOGGER.info("Initializing BrokenCore (Client) v" + mod.getModInfo().getVersion() + "...");
        mod.registerExtensionPoint(IConfigScreenFactory.class, (IExtensionPoint)((IConfigScreenFactory)(arg_0, arg_1) -> BCClientNeoForge._init_$lambda$0(mod, arg_0, arg_1)));
        BCClient.INSTANCE.init();
        NeoForge.EVENT_BUS.addListener(ClientTickEvent.Post.class, BCClientNeoForge::_init_$lambda$1);
        modBus.addListener(FMLClientSetupEvent.class, BCClientNeoForge::_init_$lambda$2);
        modBus.addListener(FMLLoadCompleteEvent.class, BCClientNeoForge::_init_$lambda$3);
        NeoForge.EVENT_BUS.addListener(GameShuttingDownEvent.class, BCClientNeoForge::_init_$lambda$4);
        NeoForge.EVENT_BUS.addListener(RegisterClientCommandsEvent.class, BCClientNeoForge::_init_$lambda$5);
        NeoForge.EVENT_BUS.addListener(RenderLevelStageEvent.class, BCClientNeoForge::_init_$lambda$6);
        modBus.addListener(RegisterGuiLayersEvent.class, BCClientNeoForge::_init_$lambda$7);
        modBus.addListener(RegisterClientReloadListenersEvent.class, BCClientNeoForge::_init_$lambda$8);
        LOGGER.info("Completed initialization!");
    }

    private static final Screen _init_$lambda$0(ModContainer $mod, ModContainer modContainer, Screen parent) {
        ConfigContainer configContainer = BCConfigs.INSTANCE;
        Intrinsics.checkNotNull((Object)parent);
        String $this$c$iv = $mod.getModInfo().getDisplayName();
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        return new BrokenConfigScreen(configContainer, parent, component);
    }

    private static final void _init_$lambda$1(ClientTickEvent.Post it) {
        BCClient.INSTANCE.tick();
        GameEvent.Companion.call(ClientEvents.TICK_END, new ClientEvents.Data());
    }

    private static final void _init_$lambda$2(FMLClientSetupEvent it) {
        GameEvent.Companion.call(ClientEvents.EARLY_STARTUP, new ClientEvents.Data());
    }

    private static final void _init_$lambda$3(FMLLoadCompleteEvent it) {
        GameEvent.Companion.call(ClientEvents.STARTUP, new ClientEvents.Data());
    }

    private static final void _init_$lambda$4(GameShuttingDownEvent it) {
        GameEvent.Companion.call(ClientEvents.SHUTDOWN, new ClientEvents.Data());
    }

    private static final void _init_$lambda$5(RegisterClientCommandsEvent it) {
        CommandDispatcher commandDispatcher = it.getDispatcher();
        Intrinsics.checkNotNullExpressionValue((Object)commandDispatcher, (String)"getDispatcher(...)");
        BCClientCommands.INSTANCE.register(commandDispatcher);
    }

    private static final void _init_$lambda$6(RenderLevelStageEvent it) {
        RenderStage renderStage;
        RenderLevelStageEvent.Stage stage = it.getStage();
        if (Intrinsics.areEqual((Object)stage, (Object)RenderLevelStageEvent.Stage.AFTER_SKY)) {
            renderStage = RenderStage.AFTER_SKY;
        } else if (Intrinsics.areEqual((Object)stage, (Object)RenderLevelStageEvent.Stage.AFTER_SOLID_BLOCKS)) {
            renderStage = RenderStage.AFTER_SOLID_BLOCKS;
        } else if (Intrinsics.areEqual((Object)stage, (Object)RenderLevelStageEvent.Stage.AFTER_CUTOUT_MIPPED_BLOCKS_BLOCKS)) {
            renderStage = RenderStage.AFTER_CUTOUT_MIPPED_BLOCKS_BLOCKS;
        } else if (Intrinsics.areEqual((Object)stage, (Object)RenderLevelStageEvent.Stage.AFTER_CUTOUT_BLOCKS)) {
            renderStage = RenderStage.AFTER_CUTOUT_BLOCKS;
        } else if (Intrinsics.areEqual((Object)stage, (Object)RenderLevelStageEvent.Stage.AFTER_ENTITIES)) {
            renderStage = RenderStage.AFTER_ENTITIES;
        } else if (Intrinsics.areEqual((Object)stage, (Object)RenderLevelStageEvent.Stage.AFTER_BLOCK_ENTITIES)) {
            renderStage = RenderStage.AFTER_BLOCK_ENTITIES;
        } else if (Intrinsics.areEqual((Object)stage, (Object)RenderLevelStageEvent.Stage.AFTER_TRANSLUCENT_BLOCKS)) {
            renderStage = RenderStage.AFTER_TRANSLUCENT_BLOCKS;
        } else if (Intrinsics.areEqual((Object)stage, (Object)RenderLevelStageEvent.Stage.AFTER_TRIPWIRE_BLOCKS)) {
            renderStage = RenderStage.AFTER_TRIPWIRE_BLOCKS;
        } else if (Intrinsics.areEqual((Object)stage, (Object)RenderLevelStageEvent.Stage.AFTER_PARTICLES)) {
            renderStage = RenderStage.AFTER_PARTICLES;
        } else if (Intrinsics.areEqual((Object)stage, (Object)RenderLevelStageEvent.Stage.AFTER_WEATHER)) {
            renderStage = RenderStage.AFTER_WEATHER;
        } else if (Intrinsics.areEqual((Object)stage, (Object)RenderLevelStageEvent.Stage.AFTER_LEVEL)) {
            renderStage = RenderStage.AFTER_LEVEL;
        } else {
            return;
        }
        RenderStage stage2 = renderStage;
        LevelRenderer levelRenderer = it.getLevelRenderer();
        Intrinsics.checkNotNullExpressionValue((Object)levelRenderer, (String)"getLevelRenderer(...)");
        PoseStack poseStack = it.getPoseStack();
        Intrinsics.checkNotNullExpressionValue((Object)poseStack, (String)"getPoseStack(...)");
        Matrix4f matrix4f = it.getModelViewMatrix();
        Intrinsics.checkNotNullExpressionValue((Object)matrix4f, (String)"getModelViewMatrix(...)");
        Matrix4f matrix4f2 = it.getProjectionMatrix();
        Intrinsics.checkNotNullExpressionValue((Object)matrix4f2, (String)"getProjectionMatrix(...)");
        int n = it.getRenderTick();
        DeltaTracker deltaTracker = it.getPartialTick();
        Intrinsics.checkNotNullExpressionValue((Object)deltaTracker, (String)"getPartialTick(...)");
        Camera camera = it.getCamera();
        Intrinsics.checkNotNullExpressionValue((Object)camera, (String)"getCamera(...)");
        Frustum frustum = it.getFrustum();
        Intrinsics.checkNotNullExpressionValue((Object)frustum, (String)"getFrustum(...)");
        RenderEvents.LevelStageData data2 = new RenderEvents.LevelStageData(stage2, levelRenderer, poseStack, matrix4f, matrix4f2, n, deltaTracker, camera, frustum);
        GameEvent.Companion.call(RenderEvents.LEVEL_STAGE, data2);
    }

    private static final void _init_$lambda$7(RegisterGuiLayersEvent it) {
        if (!registeredOverlay) {
            it.registerAboveAll(BrokenCore.id("overlays"), (LayeredDraw.Layer)OverlayLayer.INSTANCE);
            registeredOverlay = true;
        }
    }

    private static final void _init_$lambda$8(RegisterClientReloadListenersEvent it) {
        it.registerReloadListener((PreparableReloadListener)PostShaderManager.PostShaderReloadListener.INSTANCE);
    }

    static {
        Logger logger = LogManager.getLogger(BCClientNeoForge.class);
        Intrinsics.checkNotNullExpressionValue((Object)logger, (String)"getLogger(...)");
        LOGGER = logger;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/neoforge/BCClientNeoForge$Companion;", "", "<init>", "()V", "LOGGER", "Lorg/apache/logging/log4j/Logger;", "registeredOverlay", "", "brokencore-neoforge"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

