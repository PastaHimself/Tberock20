/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.CommandDispatcher
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.io.FilesKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.screens.Screen
 *  net.minecraft.client.renderer.ItemBlockRenderTypes
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.server.packs.repository.PackRepository
 *  net.minecraft.world.level.material.Fluid
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.bus.api.IEventBus
 *  net.neoforged.fml.IExtensionPoint
 *  net.neoforged.fml.ModContainer
 *  net.neoforged.fml.ModList
 *  net.neoforged.fml.common.Mod
 *  net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
 *  net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent$LoggingIn
 *  net.neoforged.neoforge.client.event.RegisterClientCommandsEvent
 *  net.neoforged.neoforge.client.event.ScreenEvent$Opening
 *  net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent
 *  net.neoforged.neoforge.client.gui.IConfigScreenFactory
 *  net.neoforged.neoforge.common.NeoForge
 *  net.neoforged.neoforge.fluids.FluidType
 *  net.thebrokenscript.brokencore.api.client.config.BrokenConfigScreen
 *  net.thebrokenscript.brokencore.api.config.ConfigContainer
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.neoforge;

import com.mojang.brigadier.CommandDispatcher;
import java.io.File;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.packs.repository.PackRepository;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.IExtensionPoint;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.neoforge.client.event.RegisterClientCommandsEvent;
import net.neoforged.neoforge.client.event.ScreenEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.fluids.FluidType;
import net.thebrokenscript.brokencore.api.client.config.BrokenConfigScreen;
import net.thebrokenscript.brokencore.api.config.ConfigContainer;
import net.thebrokenscript.client.TBSClient;
import net.thebrokenscript.client.TBSClientCommands;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.handlers.subs.ClientLoginSubscriber;
import net.thebrokenscript.handlers.subs.ScreenSubscriber;
import net.thebrokenscript.neoforge.fluids.VoidLiquidFluidType;
import net.thebrokenscript.neoforge.registry.TBSFluidTypes;
import net.thebrokenscript.neoforge.registry.TBSFluids;
import org.jetbrains.annotations.NotNull;

@Mod(value="thebrokenscript", dist={Dist.CLIENT})
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/neoforge/TBSNeoForgeClient;", "", "modBus", "Lnet/neoforged/bus/api/IEventBus;", "<init>", "(Lnet/neoforged/bus/api/IEventBus;)V", "thebrokenscript-neoforge"})
public final class TBSNeoForgeClient {
    public TBSNeoForgeClient(@NotNull IEventBus modBus) {
        Intrinsics.checkNotNullParameter((Object)modBus, (String)"modBus");
        Object t = ModList.get().getModContainerById("thebrokenscript").get();
        Intrinsics.checkNotNullExpressionValue(t, (String)"get(...)");
        ModContainer mod = (ModContainer)t;
        mod.registerExtensionPoint(IConfigScreenFactory.class, (IExtensionPoint)((IConfigScreenFactory)(arg_0, arg_1) -> TBSNeoForgeClient._init_$lambda$0(mod, arg_0, arg_1)));
        NeoForge.EVENT_BUS.addListener(RegisterClientCommandsEvent.class, TBSNeoForgeClient::_init_$lambda$1);
        NeoForge.EVENT_BUS.addListener(ScreenEvent.Opening.class, TBSNeoForgeClient::_init_$lambda$2);
        NeoForge.EVENT_BUS.addListener(ClientPlayerNetworkEvent.LoggingIn.class, TBSNeoForgeClient::_init_$lambda$3);
        modBus.addListener(FMLClientSetupEvent.class, TBSNeoForgeClient::_init_$lambda$4);
        modBus.addListener(FMLClientSetupEvent.class, TBSNeoForgeClient::_init_$lambda$5);
        modBus.addListener(RegisterClientExtensionsEvent.class, TBSNeoForgeClient::_init_$lambda$6);
        File file = mod.getModInfo().getOwningFile().getFile().getFilePath().toFile();
        Intrinsics.checkNotNullExpressionValue((Object)file, (String)"toFile(...)");
        TBSClient.INSTANCE.init(file);
    }

    private static final Screen _init_$lambda$0(ModContainer $mod, ModContainer modContainer, Screen parent) {
        ConfigContainer configContainer = TBSConfigs.INSTANCE;
        Intrinsics.checkNotNull((Object)parent);
        MutableComponent mutableComponent = Component.literal((String)$mod.getModInfo().getDisplayName());
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"literal(...)");
        return (Screen)new BrokenConfigScreen(configContainer, parent, (Component)mutableComponent);
    }

    private static final void _init_$lambda$1(RegisterClientCommandsEvent it) {
        CommandDispatcher commandDispatcher = it.getDispatcher();
        Intrinsics.checkNotNullExpressionValue((Object)commandDispatcher, (String)"getDispatcher(...)");
        TBSClientCommands.INSTANCE.register(commandDispatcher);
    }

    private static final void _init_$lambda$2(ScreenEvent.Opening it) {
        Screen screen = it.getScreen();
        Intrinsics.checkNotNullExpressionValue((Object)screen, (String)"getScreen(...)");
        ScreenSubscriber.INSTANCE.call(screen);
    }

    private static final void _init_$lambda$3(ClientPlayerNetworkEvent.LoggingIn it) {
        Minecraft minecraft = Minecraft.getInstance();
        Intrinsics.checkNotNullExpressionValue((Object)minecraft, (String)"getInstance(...)");
        ClientLoginSubscriber.INSTANCE.call(minecraft);
    }

    private static final void _init_$lambda$4(FMLClientSetupEvent it) {
        File file = Minecraft.getInstance().gameDirectory;
        Intrinsics.checkNotNullExpressionValue((Object)file, (String)"gameDirectory");
        File marker = FilesKt.resolve((File)file, (String)".tbs");
        if (marker.exists()) {
            return;
        }
        PackRepository packs = Minecraft.getInstance().getResourcePackRepository();
        Collection collection = packs.getSelectedIds();
        Intrinsics.checkNotNullExpressionValue((Object)collection, (String)"getSelectedIds(...)");
        Set selected = CollectionsKt.toMutableSet((Iterable)collection);
        if (!selected.contains("mod/thebrokenscript:nostalgia")) {
            selected.add("mod/thebrokenscript:nostalgia");
        }
        packs.setSelected((Collection)selected);
        Minecraft.getInstance().reloadResourcePacks();
        marker.createNewFile();
    }

    private static final void _init_$lambda$5(FMLClientSetupEvent it) {
        it.enqueueWork(TBSNeoForgeClient::lambda$5$0);
    }

    private static final void lambda$5$0() {
        ItemBlockRenderTypes.setRenderLayer((Fluid)((Fluid)TBSFluids.SOURCE_VOID_LIQUID.get()), (RenderType)RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer((Fluid)((Fluid)TBSFluids.FLOWING_VOID_LIQUID.get()), (RenderType)RenderType.translucent());
    }

    private static final void _init_$lambda$6(RegisterClientExtensionsEvent it) {
        FluidType[] fluidTypeArray = new FluidType[]{TBSFluidTypes.VOID_LIQUID.get()};
        it.registerFluidType(((VoidLiquidFluidType)((Object)TBSFluidTypes.VOID_LIQUID.get())).getClientFluidTypeExtensions(), fluidTypeArray);
    }
}

