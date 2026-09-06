/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.seibel.distanthorizons.core.config.types.ConfigEntry
 *  com.seibel.distanthorizons.core.render.renderer.shaders.FogShader
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package net.thebrokenscript.mixins.compat.distanthorizons;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.seibel.distanthorizons.core.config.types.ConfigEntry;
import com.seibel.distanthorizons.core.render.renderer.shaders.FogShader;
import net.thebrokenscript.compat.distanthorizons.TBSDhCompat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value={FogShader.class})
public class FogShaderMixin {
    @WrapOperation(method={"onApplyUniforms"}, at={@At(value="INVOKE", target="Lcom/seibel/distanthorizons/core/config/types/ConfigEntry;get()Ljava/lang/Object;", ordinal=0)})
    private static <T> T tbs$modifyRenderDistance(ConfigEntry<T> instance, Operation<T> original) {
        return (T)Integer.valueOf(TBSDhCompat.INSTANCE.modifyRenderDistance(instance, original));
    }
}

