/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.client.Camera
 *  org.joml.Quaternionf
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 */
package net.thebrokenscript.mixins.client.features;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.Camera;
import net.thebrokenscript.mixinterfaces.CameraZAxis;
import org.joml.Quaternionf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value={Camera.class})
public class CameraShit
implements CameraZAxis {
    @Unique
    private float bc$angle = 0.0f;

    @WrapOperation(method={"setRotation(FFF)V", "setRotation(FF)V"}, at={@At(value="INVOKE", target="Lorg/joml/Quaternionf;rotationYXZ(FFF)Lorg/joml/Quaternionf;")})
    public Quaternionf tbs$cameraShit(Quaternionf instance, float angleY, float angleX, float angleZ, Operation<Quaternionf> original) {
        return (Quaternionf)original.call(new Object[]{instance, Float.valueOf(angleY), Float.valueOf(angleX), Float.valueOf(angleZ + this.bc$angle)});
    }

    @Override
    public float getBc$angle() {
        return this.bc$angle;
    }

    @Override
    public void setBc$angle(float v) {
        this.bc$angle = v;
    }
}

