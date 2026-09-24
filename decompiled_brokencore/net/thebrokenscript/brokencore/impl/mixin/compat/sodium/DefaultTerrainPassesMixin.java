/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.expression.Definition
 *  com.llamalad7.mixinextras.expression.Expression
 *  com.llamalad7.mixinextras.injector.ModifyExpressionValue
 *  net.caffeinemc.mods.sodium.client.render.chunk.terrain.DefaultTerrainRenderPasses
 *  net.caffeinemc.mods.sodium.client.render.chunk.terrain.TerrainRenderPass
 *  org.apache.commons.lang3.ArrayUtils
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package net.thebrokenscript.brokencore.impl.mixin.compat.sodium;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.caffeinemc.mods.sodium.client.render.chunk.terrain.DefaultTerrainRenderPasses;
import net.caffeinemc.mods.sodium.client.render.chunk.terrain.TerrainRenderPass;
import net.thebrokenscript.brokencore.impl.compat.sodium.BCPasses;
import org.apache.commons.lang3.ArrayUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value={DefaultTerrainRenderPasses.class})
public class DefaultTerrainPassesMixin {
    @ModifyExpressionValue(method={"<clinit>"}, at={@At(value="MIXINEXTRAS:EXPRESSION")})
    @Definition(id="TerrainRenderPass", type={TerrainRenderPass.class})
    @Expression(value={"new TerrainRenderPass[]{?, ?, ?}"})
    private static TerrainRenderPass[] bc$addCustom(TerrainRenderPass[] original) {
        return (TerrainRenderPass[])ArrayUtils.addAll((Object[])original, (Object[])((TerrainRenderPass[])BCPasses.get().values().toArray(TerrainRenderPass[]::new)));
    }
}

