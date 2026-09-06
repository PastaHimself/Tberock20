/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  net.caffeinemc.mods.sodium.client.render.chunk.terrain.TerrainRenderPass
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.compat.sodium;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.caffeinemc.mods.sodium.client.render.chunk.terrain.TerrainRenderPass;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.client.blocks.BlockRenderLayers;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\fH\u0007J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00060\fH\u0007R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/brokencore/impl/compat/sodium/BCPasses;", "", "<init>", "()V", "cache", "", "Lnet/minecraft/resources/ResourceLocation;", "Lnet/caffeinemc/mods/sodium/client/render/chunk/terrain/TerrainRenderPass;", "revCache", "cached", "", "get", "", "getReverse", "brokencore-common"})
public final class BCPasses {
    @NotNull
    public static final BCPasses INSTANCE = new BCPasses();
    @NotNull
    private static final Map<ResourceLocation, TerrainRenderPass> cache = new LinkedHashMap();
    @NotNull
    private static final Map<TerrainRenderPass, ResourceLocation> revCache = new LinkedHashMap();
    private static boolean cached;

    private BCPasses() {
    }

    @JvmStatic
    @NotNull
    public static final Map<ResourceLocation, TerrainRenderPass> get() {
        if (!cached) {
            cached = true;
            for (Map.Entry<ResourceLocation, RenderType> entry : BlockRenderLayers.layers.entrySet()) {
                ResourceLocation id = entry.getKey();
                RenderType rt = entry.getValue();
                cache.put(id, new TerrainRenderPass(rt, false, false));
                TerrainRenderPass terrainRenderPass = cache.get(id);
                Intrinsics.checkNotNull((Object)terrainRenderPass);
                revCache.put(terrainRenderPass, id);
            }
        }
        return cache;
    }

    @JvmStatic
    @NotNull
    public static final Map<TerrainRenderPass, ResourceLocation> getReverse() {
        BCPasses.get();
        return revCache;
    }
}

