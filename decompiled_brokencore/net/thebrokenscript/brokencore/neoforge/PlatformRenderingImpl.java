/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Pair
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.ShaderInstance
 *  net.minecraft.client.resources.model.BakedModel
 *  net.minecraft.core.BlockPos
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.BlockAndTintGetter
 *  net.minecraft.world.level.block.state.BlockState
 *  net.neoforged.neoforge.client.model.data.ModelData
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.neoforge;

import com.mojang.datafixers.util.Pair;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.data.ModelData;
import net.thebrokenscript.brokencore.api.client.shader.ShaderInfo;
import net.thebrokenscript.brokencore.api.platform.PlatformRendering;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.brokencore.neoforge.PlatformRenderingEvents;
import net.thebrokenscript.brokencore.neoforge.PlatformRenderingImplKt;
import org.jetbrains.annotations.NotNull;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J&\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016\u00a8\u0006\u001c"}, d2={"Lnet/thebrokenscript/brokencore/neoforge/PlatformRenderingImpl;", "Lnet/thebrokenscript/brokencore/api/platform/PlatformRendering;", "<init>", "()V", "registerShader", "", "shader", "Lnet/thebrokenscript/brokencore/api/client/shader/ShaderInfo;", "consumer", "Ljava/util/function/Consumer;", "Lnet/minecraft/client/renderer/ShaderInstance;", "isCustomShader", "", "registerChunkRenderType", "rt", "Lnet/minecraft/client/renderer/RenderType;", "setChunkLayerId", "id", "", "getChunkLayerId", "getBlockStateRenderTypes", "", "level", "Lnet/minecraft/client/multiplayer/ClientLevel;", "blockState", "Lnet/minecraft/world/level/block/state/BlockState;", "pos", "Lnet/minecraft/core/BlockPos;", "brokencore-neoforge"})
@SourceDebugExtension(value={"SMAP\nPlatformRenderingImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlatformRenderingImpl.kt\nnet/thebrokenscript/brokencore/neoforge/PlatformRenderingImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,76:1\n1#2:77\n*E\n"})
public final class PlatformRenderingImpl
implements PlatformRendering {
    @Override
    public void registerShader(@NotNull ShaderInfo shader, @NotNull Consumer<ShaderInstance> consumer) {
        Intrinsics.checkNotNullParameter((Object)shader, (String)"shader");
        Intrinsics.checkNotNullParameter(consumer, (String)"consumer");
        if (!(!PlatformRenderingEvents.INSTANCE.getRegisteredShaders$brokencore_neoforge())) {
            boolean bl = false;
            String string = "Shaders were already registered!";
            throw new IllegalStateException(string.toString());
        }
        ((Collection)PlatformRenderingEvents.INSTANCE.getShaderQueue$brokencore_neoforge()).add(Pair.of((Object)shader, consumer));
    }

    @Override
    public boolean isCustomShader(@NotNull ShaderInstance shader) {
        Intrinsics.checkNotNullParameter((Object)shader, (String)"shader");
        return PlatformRenderingEvents.INSTANCE.getCustomShaders$brokencore_neoforge().contains(shader);
    }

    @Override
    public void registerChunkRenderType(@NotNull RenderType rt) {
        Intrinsics.checkNotNullParameter((Object)rt, (String)"rt");
        int n = RenderType.CHUNK_BUFFER_LAYERS.size();
        int n2 = PlatformRenderingImplKt.access$getRenderTypeIndex$p();
        PlatformRenderingImplKt.access$setRenderTypeIndex$p(n2 + 1);
        rt.chunkLayerId = n + n2;
    }

    @Override
    public void setChunkLayerId(@NotNull RenderType rt, int id) {
        Intrinsics.checkNotNullParameter((Object)rt, (String)"rt");
        rt.chunkLayerId = id;
    }

    @Override
    public int getChunkLayerId(@NotNull RenderType rt) {
        Intrinsics.checkNotNullParameter((Object)rt, (String)"rt");
        return rt.chunkLayerId;
    }

    @Override
    @NotNull
    public List<RenderType> getBlockStateRenderTypes(@NotNull ClientLevel level, @NotNull BlockState blockState, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)blockState, (String)"blockState");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Minecraft mc = Minecraft.getInstance();
        BakedModel model = mc.getBlockRenderer().getBlockModel(blockState);
        ModelData data2 = model.getModelData((BlockAndTintGetter)level, pos, blockState, level.getModelData(pos));
        RandomSource rand = RandomSource.create((long)blockState.getSeed(pos));
        List list = model.getRenderTypes(blockState, rand, data2).asList();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"asList(...)");
        return list;
    }
}

