/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.BubbleColumnBlock
 *  net.minecraft.world.level.block.state.BlockState
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.mixins.features.misc;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BubbleColumnBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={BubbleColumnBlock.class})
public class BubbleColumnBlockMixin {
    @Inject(method={"entityInside"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;onAboveBubbleCol(Z)V")}, cancellable=true)
    private void tbs$cancelDrag(BlockState state, Level level, BlockPos pos, Entity entity, CallbackInfo ci) {
        String entityNamespace = BuiltInRegistries.ENTITY_TYPE.getKey((Object)entity.getType()).getNamespace();
        if (entityNamespace.equals("thebrokenscript")) {
            ci.cancel();
        }
    }

    @Inject(method={"entityInside"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;onInsideBubbleColumn(Z)V")}, cancellable=true)
    private void tbs$cancelDrag2(BlockState state, Level level, BlockPos pos, Entity entity, CallbackInfo ci) {
        String entityNamespace = BuiltInRegistries.ENTITY_TYPE.getKey((Object)entity.getType()).getNamespace();
        if (entityNamespace.equals("thebrokenscript")) {
            ci.cancel();
        }
    }
}

