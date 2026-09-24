/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  net.caffeinemc.mods.sodium.client.render.chunk.terrain.TerrainRenderPass
 *  net.caffeinemc.mods.sodium.client.render.chunk.terrain.material.Material
 *  net.caffeinemc.mods.sodium.client.render.chunk.terrain.material.parameters.AlphaCutoffParameter
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.compat.sodium;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import net.caffeinemc.mods.sodium.client.render.chunk.terrain.TerrainRenderPass;
import net.caffeinemc.mods.sodium.client.render.chunk.terrain.material.Material;
import net.caffeinemc.mods.sodium.client.render.chunk.terrain.material.parameters.AlphaCutoffParameter;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.impl.compat.sodium.BCPasses;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u000bH\u0007R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/brokencore/impl/compat/sodium/BCMaterials;", "", "<init>", "()V", "cache", "", "Lnet/minecraft/resources/ResourceLocation;", "Lnet/caffeinemc/mods/sodium/client/render/chunk/terrain/material/Material;", "cached", "", "get", "", "brokencore-common"})
public final class BCMaterials {
    @NotNull
    public static final BCMaterials INSTANCE = new BCMaterials();
    @NotNull
    private static final Map<ResourceLocation, Material> cache = new LinkedHashMap();
    private static boolean cached;

    private BCMaterials() {
    }

    @JvmStatic
    @NotNull
    public static final Map<ResourceLocation, Material> get() {
        if (!cached) {
            cached = true;
            for (Map.Entry<ResourceLocation, TerrainRenderPass> entry : BCPasses.get().entrySet()) {
                ResourceLocation id = entry.getKey();
                TerrainRenderPass pass = entry.getValue();
                cache.put(id, new Material(pass, AlphaCutoffParameter.ZERO, true));
            }
        }
        return cache;
    }
}

