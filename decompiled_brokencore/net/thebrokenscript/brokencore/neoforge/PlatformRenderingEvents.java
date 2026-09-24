/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Pair
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.renderer.ShaderInstance
 *  net.minecraft.server.packs.resources.ResourceProvider
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.EventBusSubscriber
 *  net.neoforged.neoforge.client.event.RegisterShadersEvent
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.neoforge;

import com.mojang.datafixers.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.server.packs.resources.ResourceProvider;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterShadersEvent;
import net.thebrokenscript.brokencore.api.client.shader.ShaderInfo;
import net.thebrokenscript.brokencore.neoforge.XShaderInstance;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber(value={Dist.CLIENT})
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007R,\u0010\b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\n0\tX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\tX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f\u00a8\u0006\u0018"}, d2={"Lnet/thebrokenscript/brokencore/neoforge/PlatformRenderingEvents;", "", "<init>", "()V", "registerShaders", "", "event", "Lnet/neoforged/neoforge/client/event/RegisterShadersEvent;", "shaderQueue", "", "Lcom/mojang/datafixers/util/Pair;", "Lnet/thebrokenscript/brokencore/api/client/shader/ShaderInfo;", "Ljava/util/function/Consumer;", "Lnet/minecraft/client/renderer/ShaderInstance;", "getShaderQueue$brokencore_neoforge", "()Ljava/util/List;", "registeredShaders", "", "getRegisteredShaders$brokencore_neoforge", "()Z", "setRegisteredShaders$brokencore_neoforge", "(Z)V", "customShaders", "getCustomShaders$brokencore_neoforge", "brokencore-neoforge"})
public final class PlatformRenderingEvents {
    @NotNull
    public static final PlatformRenderingEvents INSTANCE = new PlatformRenderingEvents();
    @NotNull
    private static final List<Pair<ShaderInfo, Consumer<ShaderInstance>>> shaderQueue = new ArrayList();
    private static boolean registeredShaders;
    @NotNull
    private static final List<ShaderInstance> customShaders;

    private PlatformRenderingEvents() {
    }

    @JvmStatic
    @SubscribeEvent
    public static final void registerShaders(@NotNull RegisterShadersEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        customShaders.clear();
        for (Pair<ShaderInfo, Consumer<ShaderInstance>> item2 : shaderQueue) {
            ResourceProvider resourceProvider = event.getResourceProvider();
            Intrinsics.checkNotNullExpressionValue((Object)resourceProvider, (String)"getResourceProvider(...)");
            XShaderInstance inst = new XShaderInstance(resourceProvider, ((ShaderInfo)item2.getFirst()).getName(), ((ShaderInfo)item2.getFirst()).getVertexFormat());
            event.registerShader((ShaderInstance)inst, arg_0 -> PlatformRenderingEvents.registerShaders$lambda$0(item2, arg_0));
        }
        registeredShaders = true;
    }

    @NotNull
    public final List<Pair<ShaderInfo, Consumer<ShaderInstance>>> getShaderQueue$brokencore_neoforge() {
        return shaderQueue;
    }

    public final boolean getRegisteredShaders$brokencore_neoforge() {
        return registeredShaders;
    }

    public final void setRegisteredShaders$brokencore_neoforge(boolean bl) {
        registeredShaders = bl;
    }

    @NotNull
    public final List<ShaderInstance> getCustomShaders$brokencore_neoforge() {
        return customShaders;
    }

    private static final void registerShaders$lambda$0(Pair $item, ShaderInstance it) {
        Intrinsics.checkNotNull((Object)it);
        customShaders.add(it);
        ((Consumer)$item.getSecond()).accept(it);
    }

    static {
        customShaders = new ArrayList();
    }
}

