/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.ShaderInstance
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.block.state.BlockState
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.platform;

import java.util.List;
import java.util.ServiceLoader;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.thebrokenscript.brokencore.api.client.shader.ShaderInfo;
import net.thebrokenscript.brokencore.impl.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aJ\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\rH&J&\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&\u00a8\u0006\u001b"}, d2={"Lnet/thebrokenscript/brokencore/api/platform/PlatformRendering;", "", "registerShader", "", "shader", "Lnet/thebrokenscript/brokencore/api/client/shader/ShaderInfo;", "consumer", "Ljava/util/function/Consumer;", "Lnet/minecraft/client/renderer/ShaderInstance;", "isCustomShader", "", "registerChunkRenderType", "rt", "Lnet/minecraft/client/renderer/RenderType;", "setChunkLayerId", "id", "", "getChunkLayerId", "getBlockStateRenderTypes", "", "level", "Lnet/minecraft/client/multiplayer/ClientLevel;", "blockState", "Lnet/minecraft/world/level/block/state/BlockState;", "pos", "Lnet/minecraft/core/BlockPos;", "Companion", "brokencore-common"})
public interface PlatformRendering {
    @NotNull
    public static final Companion Companion = net.thebrokenscript.brokencore.api.platform.PlatformRendering$Companion.$$INSTANCE;

    public void registerShader(@NotNull ShaderInfo var1, @NotNull Consumer<ShaderInstance> var2);

    public boolean isCustomShader(@NotNull ShaderInstance var1);

    public void registerChunkRenderType(@NotNull RenderType var1);

    public void setChunkLayerId(@NotNull RenderType var1, int var2);

    public int getChunkLayerId(@NotNull RenderType var1);

    @NotNull
    public List<RenderType> getBlockStateRenderTypes(@NotNull ClientLevel var1, @NotNull BlockState var2, @NotNull BlockPos var3);

    @ForceRuntimeInit
    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0096\u0001J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0096\u0001J\u0011\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0006H\u0096\u0001J\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0019H\u0096\u0001J\u0019\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u000eH\u0096\u0001\u00a8\u0006\u001c"}, d2={"Lnet/thebrokenscript/brokencore/api/platform/PlatformRendering$Companion;", "Lnet/thebrokenscript/brokencore/api/platform/PlatformRendering;", "<init>", "()V", "getBlockStateRenderTypes", "", "Lnet/minecraft/client/renderer/RenderType;", "level", "Lnet/minecraft/client/multiplayer/ClientLevel;", "blockState", "Lnet/minecraft/world/level/block/state/BlockState;", "pos", "Lnet/minecraft/core/BlockPos;", "getChunkLayerId", "", "rt", "isCustomShader", "", "shader", "Lnet/minecraft/client/renderer/ShaderInstance;", "registerChunkRenderType", "", "registerShader", "Lnet/thebrokenscript/brokencore/api/client/shader/ShaderInfo;", "consumer", "Ljava/util/function/Consumer;", "setChunkLayerId", "id", "brokencore-common"})
    public static final class Companion
    implements PlatformRendering {
        static final /* synthetic */ Companion $$INSTANCE;
        private final /* synthetic */ PlatformRendering $$delegate_0;

        private Companion() {
            ServiceLoader<PlatformRendering> serviceLoader = ServiceLoader.load(PlatformRendering.class);
            Intrinsics.checkNotNullExpressionValue(serviceLoader, (String)"load(...)");
            this.$$delegate_0 = (PlatformRendering)CollectionsKt.first((Iterable)serviceLoader);
        }

        @Override
        public void registerShader(@NotNull ShaderInfo shader, @NotNull Consumer<ShaderInstance> consumer) {
            Intrinsics.checkNotNullParameter((Object)shader, (String)"shader");
            Intrinsics.checkNotNullParameter(consumer, (String)"consumer");
            this.$$delegate_0.registerShader(shader, consumer);
        }

        @Override
        public boolean isCustomShader(@NotNull ShaderInstance shader) {
            Intrinsics.checkNotNullParameter((Object)shader, (String)"shader");
            return this.$$delegate_0.isCustomShader(shader);
        }

        @Override
        public void registerChunkRenderType(@NotNull RenderType rt) {
            Intrinsics.checkNotNullParameter((Object)rt, (String)"rt");
            this.$$delegate_0.registerChunkRenderType(rt);
        }

        @Override
        public void setChunkLayerId(@NotNull RenderType rt, int id) {
            Intrinsics.checkNotNullParameter((Object)rt, (String)"rt");
            this.$$delegate_0.setChunkLayerId(rt, id);
        }

        @Override
        public int getChunkLayerId(@NotNull RenderType rt) {
            Intrinsics.checkNotNullParameter((Object)rt, (String)"rt");
            return this.$$delegate_0.getChunkLayerId(rt);
        }

        @Override
        @NotNull
        public List<RenderType> getBlockStateRenderTypes(@NotNull ClientLevel level, @NotNull BlockState blockState, @NotNull BlockPos pos) {
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            Intrinsics.checkNotNullParameter((Object)blockState, (String)"blockState");
            Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
            return this.$$delegate_0.getBlockStateRenderTypes(level, blockState, pos);
        }

        static {
            $$INSTANCE = new Companion();
        }
    }
}

