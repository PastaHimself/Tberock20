/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.client.Camera
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.BlockPos$MutableBlockPos
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.brokencore.impl.mixin.client.features.cutscene;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.Camera;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.client.cutscene.CameraOverrides;
import net.thebrokenscript.brokencore.api.mixinterfaces.CameraExt;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={Camera.class})
public class CameraMixin
implements CameraExt {
    @Shadow
    @Final
    private static Vector3f FORWARDS;
    @Shadow
    @Final
    private static Vector3f UP;
    @Shadow
    @Final
    private static Vector3f LEFT;
    @Unique
    private CameraOverrides bc$overrides = new CameraOverrides();
    @Unique
    private Vec3 bc$position = new Vec3(0.0, 0.0, 0.0);
    @Unique
    private final BlockPos.MutableBlockPos bc$blockPosition = new BlockPos.MutableBlockPos();
    @Unique
    private final Quaternionf bc$rotation = new Quaternionf();
    @Unique
    private final Vector3f bc$forwards = new Vector3f((Vector3fc)FORWARDS);
    @Unique
    private final Vector3f bc$up = new Vector3f((Vector3fc)UP);
    @Unique
    private final Vector3f bc$left = new Vector3f((Vector3fc)LEFT);

    @Override
    @NotNull
    public CameraOverrides getBc$overrides() {
        return this.bc$overrides;
    }

    @Override
    public void setBc$overrides(@NotNull CameraOverrides cameraOverrides) {
        this.bc$overrides = cameraOverrides;
    }

    @Override
    public void bc$updateOverrides() {
        float yRot = this.bc$overrides.getTransform().getRotation().getYaw();
        float xRot = this.bc$overrides.getTransform().getRotation().getPitch();
        this.bc$rotation.rotationYXZ((float)Math.PI - yRot * ((float)Math.PI / 180), -xRot * ((float)Math.PI / 180), 0.0f);
        FORWARDS.rotate((Quaternionfc)this.bc$rotation, this.bc$forwards);
        UP.rotate((Quaternionfc)this.bc$rotation, this.bc$up);
        LEFT.rotate((Quaternionfc)this.bc$rotation, this.bc$left);
        this.bc$position = new Vec3(this.bc$overrides.getTransform().getPosition());
        this.bc$blockPosition.set(this.bc$position.x, this.bc$position.y, this.bc$position.z);
    }

    @Inject(method={"getPosition"}, at={@At(value="HEAD")}, cancellable=true)
    public void bc$overridePosition(CallbackInfoReturnable<Vec3> cir) {
        if (this.bc$overrides.getActive()) {
            cir.setReturnValue((Object)this.bc$position);
        }
    }

    @Inject(method={"getBlockPosition"}, at={@At(value="HEAD")}, cancellable=true)
    public void bc$overrideBlockPosition(CallbackInfoReturnable<BlockPos> cir) {
        if (this.bc$overrides.getActive()) {
            cir.setReturnValue((Object)this.bc$blockPosition);
        }
    }

    @Inject(method={"getXRot"}, at={@At(value="HEAD")}, cancellable=true)
    public void bc$overrideXRot(CallbackInfoReturnable<Float> cir) {
        if (this.bc$overrides.getActive()) {
            cir.setReturnValue((Object)Float.valueOf(this.bc$overrides.getTransform().getRotation().getPitch()));
        }
    }

    @Inject(method={"getYRot"}, at={@At(value="HEAD")}, cancellable=true)
    public void bc$overrideYRot(CallbackInfoReturnable<Float> cir) {
        if (this.bc$overrides.getActive()) {
            cir.setReturnValue((Object)Float.valueOf(this.bc$overrides.getTransform().getRotation().getYaw()));
        }
    }

    @Inject(method={"rotation"}, at={@At(value="HEAD")}, cancellable=true)
    public void bc$overrideRotation(CallbackInfoReturnable<Quaternionf> cir) {
        if (this.bc$overrides.getActive()) {
            cir.setReturnValue((Object)this.bc$rotation);
        }
    }

    @WrapOperation(method={"getNearPlane"}, at={@At(value="FIELD", target="Lnet/minecraft/client/Camera;forwards:Lorg/joml/Vector3f;")})
    public Vector3f bc$fixNearPlaneForwards(Camera instance, Operation<Vector3f> original) {
        return this.bc$overrides.getActive() ? this.bc$forwards : (Vector3f)original.call(new Object[]{instance});
    }

    @WrapOperation(method={"getNearPlane"}, at={@At(value="FIELD", target="Lnet/minecraft/client/Camera;left:Lorg/joml/Vector3f;")})
    public Vector3f bc$fixNearPlaneLeft(Camera instance, Operation<Vector3f> original) {
        return this.bc$overrides.getActive() ? this.bc$left : (Vector3f)original.call(new Object[]{instance});
    }

    @WrapOperation(method={"getNearPlane"}, at={@At(value="FIELD", target="Lnet/minecraft/client/Camera;up:Lorg/joml/Vector3f;")})
    public Vector3f bc$fixNearPlaneUp(Camera instance, Operation<Vector3f> original) {
        return this.bc$overrides.getActive() ? this.bc$up : (Vector3f)original.call(new Object[]{instance});
    }

    @WrapOperation(method={"getFluidInCamera"}, at={@At(value="FIELD", target="Lnet/minecraft/client/Camera;position:Lnet/minecraft/world/phys/Vec3;")})
    public Vec3 bc$fixFluidCheckPos(Camera instance, Operation<Vec3> original) {
        return this.bc$overrides.getActive() ? this.bc$position : (Vec3)original.call(new Object[]{instance});
    }

    @WrapOperation(method={"getFluidInCamera"}, at={@At(value="FIELD", target="Lnet/minecraft/client/Camera;blockPosition:Lnet/minecraft/core/BlockPos$MutableBlockPos;")})
    public BlockPos.MutableBlockPos bc$fixFluidCheckBlockPos(Camera instance, Operation<BlockPos.MutableBlockPos> original) {
        return this.bc$overrides.getActive() ? this.bc$blockPosition : (BlockPos.MutableBlockPos)original.call(new Object[]{instance});
    }

    @Inject(method={"getLookVector"}, at={@At(value="HEAD")}, cancellable=true)
    public void bc$overrideLookVector(CallbackInfoReturnable<Vector3f> cir) {
        if (this.bc$overrides.getActive()) {
            cir.setReturnValue((Object)this.bc$forwards);
        }
    }

    @Inject(method={"getUpVector"}, at={@At(value="HEAD")}, cancellable=true)
    public void bc$overrideUpVector(CallbackInfoReturnable<Vector3f> cir) {
        if (this.bc$overrides.getActive()) {
            cir.setReturnValue((Object)this.bc$up);
        }
    }

    @Inject(method={"getLeftVector"}, at={@At(value="HEAD")}, cancellable=true)
    public void bc$overrideLeftVector(CallbackInfoReturnable<Vector3f> cir) {
        if (this.bc$overrides.getActive()) {
            cir.setReturnValue((Object)this.bc$left);
        }
    }

    @Inject(method={"isDetached"}, at={@At(value="HEAD")}, cancellable=true)
    public void bc$overrideDetached(CallbackInfoReturnable<Boolean> cir) {
        if (this.bc$overrides.getActive()) {
            cir.setReturnValue((Object)true);
        }
    }

    @Inject(method={"move"}, at={@At(value="HEAD")}, cancellable=true)
    public void bc$preventMove(float zoom, float dy, float dx, CallbackInfo ci) {
        if (this.bc$overrides.getActive()) {
            ci.cancel();
        }
    }

    @Inject(method={"setRotation"}, at={@At(value="HEAD")}, cancellable=true)
    public void bc$preventRotate(float yRot, float xRot, CallbackInfo ci) {
        if (this.bc$overrides.getActive()) {
            ci.cancel();
        }
    }

    @Inject(method={"setPosition(Lnet/minecraft/world/phys/Vec3;)V"}, at={@At(value="HEAD")}, cancellable=true)
    public void bc$preventChangePos(Vec3 pos, CallbackInfo ci) {
        if (this.bc$overrides.getActive()) {
            ci.cancel();
        }
    }
}

