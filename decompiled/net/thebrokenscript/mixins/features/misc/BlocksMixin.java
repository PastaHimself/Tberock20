/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyExpressionValue
 *  net.minecraft.world.level.block.Blocks
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Slice
 */
package net.thebrokenscript.mixins.features.misc;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(value={Blocks.class})
public class BlocksMixin {
    @ModifyExpressionValue(method={"<clinit>"}, at={@At(value="CONSTANT", args={"floatValue=-1.0"}, ordinal=0)}, slice={@Slice(from=@At(value="CONSTANT", args={"stringValue=bedrock"}))})
    private static float changeBedrockDestroyTime(float original) {
        return 3.0f;
    }
}

