/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.block.model.BlockElement
 *  net.minecraft.core.Direction
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package compat.net.neoforged.neoforge.mixin;

import net.minecraft.client.renderer.block.model.BlockElement;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={BlockElement.class})
public interface BlockElementAccessor {
    @Invoker(value="uvsByFace")
    public float[] brokencore$uvsByFace(Direction var1);
}

