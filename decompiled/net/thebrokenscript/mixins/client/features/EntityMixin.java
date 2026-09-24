/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.world.entity.Entity
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package net.thebrokenscript.mixins.client.features;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Entity;
import net.thebrokenscript.mixinterfaces.CameraZAxis;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={Entity.class})
public class EntityMixin {
    @Unique
    private boolean tbs$dontApplyZ() {
        return !(this instanceof LocalPlayer);
    }

    @WrapMethod(method={"turn"})
    public void tbs$turnZ(double yRot, double xRot, Operation<Void> original) {
        if (this.tbs$dontApplyZ()) {
            original.call(new Object[]{yRot, xRot});
            return;
        }
        double angle = ((CameraZAxis)Minecraft.getInstance().gameRenderer.getMainCamera()).getBc$angle();
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        double rx = xRot * cos - yRot * sin;
        double ry = xRot * sin + yRot * cos;
        original.call(new Object[]{ry, rx});
    }
}

