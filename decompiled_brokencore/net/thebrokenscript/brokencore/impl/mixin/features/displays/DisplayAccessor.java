/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.util.Brightness
 *  net.minecraft.world.entity.Display
 *  net.minecraft.world.entity.Display$BillboardConstraints
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Quaternionf
 *  org.joml.Vector3f
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package net.thebrokenscript.brokencore.impl.mixin.features.displays;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.util.Brightness;
import net.minecraft.world.entity.Display;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={Display.class})
public interface DisplayAccessor {
    @Accessor(value="DATA_TRANSLATION_ID")
    public static EntityDataAccessor<Vector3f> bc$DATA_TRANSLATION_ID() {
        throw new AssertionError();
    }

    @Accessor(value="DATA_SCALE_ID")
    public static EntityDataAccessor<Vector3f> bc$DATA_SCALE_ID() {
        throw new AssertionError();
    }

    @Accessor(value="DATA_LEFT_ROTATION_ID")
    public static EntityDataAccessor<Quaternionf> bc$DATA_LEFT_ROTATION_ID() {
        throw new AssertionError();
    }

    @Accessor(value="DATA_RIGHT_ROTATION_ID")
    public static EntityDataAccessor<Quaternionf> bc$DATA_RIGHT_ROTATION_ID() {
        throw new AssertionError();
    }

    @Invoker(value="setTransformationInterpolationDuration")
    public void bc$setTransformationInterpolationDuration(int var1);

    @Invoker(value="getTransformationInterpolationDuration")
    public int bc$getTransformationInterpolationDuration();

    @Invoker(value="setTransformationInterpolationDelay")
    public void bc$setTransformationInterpolationDelay(int var1);

    @Invoker(value="getTransformationInterpolationDelay")
    public int bc$getTransformationInterpolationDelay();

    @Invoker(value="setPosRotInterpolationDuration")
    public void bc$setPosRotInterpolationDuration(int var1);

    @Invoker(value="getPosRotInterpolationDuration")
    public int bc$getPosRotInterpolationDuration();

    @Invoker(value="setBrightnessOverride")
    public void bc$setBrightnessOverride(@Nullable Brightness var1);

    @Invoker(value="getBrightnessOverride")
    @Nullable
    public Brightness bc$getBrightnessOverride();

    @Invoker(value="setBillboardConstraints")
    public void bc$setBillboardConstraints(Display.BillboardConstraints var1);

    @Invoker(value="getBillboardConstraints")
    public Display.BillboardConstraints bc$getBillboardConstraints();
}

