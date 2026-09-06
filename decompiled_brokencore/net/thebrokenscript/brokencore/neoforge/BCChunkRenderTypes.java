/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.resources.ResourceLocation
 *  net.neoforged.neoforge.client.ChunkRenderTypeSet
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.neoforge;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.ChunkRenderTypeSet;
import net.thebrokenscript.brokencore.api.client.blocks.BlockRenderTypes;
import net.thebrokenscript.brokencore.neoforge.BCChunkRenderTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0087\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/brokencore/neoforge/BCChunkRenderTypes;", "", "<init>", "()V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "Lnet/minecraft/client/renderer/RenderType;", "Lnet/neoforged/neoforge/client/ChunkRenderTypeSet;", "get", "id", "Lnet/minecraft/resources/ResourceLocation;", "brokencore-neoforge"})
public final class BCChunkRenderTypes {
    @NotNull
    public static final BCChunkRenderTypes INSTANCE = new BCChunkRenderTypes();
    @NotNull
    private static final ConcurrentHashMap<RenderType, ChunkRenderTypeSet> cache = new ConcurrentHashMap();

    private BCChunkRenderTypes() {
    }

    @JvmStatic
    @Nullable
    public static final ChunkRenderTypeSet get(@NotNull ResourceLocation id) {
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        RenderType renderType = BlockRenderTypes.map.get(id);
        if (renderType == null) {
            return null;
        }
        return cache.computeIfAbsent(renderType, arg_0 -> BCChunkRenderTypes.get$lambda$0(get.1.INSTANCE, arg_0));
    }

    private static final ChunkRenderTypeSet get$lambda$0(Function1 $tmp0, Object p0) {
        return (ChunkRenderTypeSet)$tmp0.invoke(p0);
    }
}

