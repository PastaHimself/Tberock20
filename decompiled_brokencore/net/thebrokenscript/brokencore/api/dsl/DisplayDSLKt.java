/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.math.Transformation
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.network.chat.Component
 *  net.minecraft.util.Brightness
 *  net.minecraft.world.entity.Display
 *  net.minecraft.world.entity.Display$BillboardConstraints
 *  net.minecraft.world.entity.Display$BlockDisplay
 *  net.minecraft.world.entity.Display$RenderState
 *  net.minecraft.world.entity.Display$TextDisplay
 *  net.minecraft.world.level.block.state.BlockState
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Quaternionf
 *  org.joml.Vector3f
 */
package net.thebrokenscript.brokencore.api.dsl;

import com.mojang.math.Transformation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Brightness;
import net.minecraft.world.entity.Display;
import net.minecraft.world.level.block.state.BlockState;
import net.thebrokenscript.brokencore.impl.mixin.features.displays.BlockDisplayAccessor;
import net.thebrokenscript.brokencore.impl.mixin.features.displays.DisplayAccessor;
import net.thebrokenscript.brokencore.impl.mixin.features.displays.TextDisplayAccessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;
import org.joml.Vector3f;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0002\"(\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\"(\u0010\f\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\"(\u0010\u0011\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010\"(\u0010\u0014\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010\"6\u0010\u0019\u001a\t\u0018\u00010\u0017\u00a2\u0006\u0002\b\u0018*\u00020\u00022\r\u0010\u0006\u001a\t\u0018\u00010\u0017\u00a2\u0006\u0002\b\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\"8\u0010 \u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e*\u00020\u00022\u000e\u0010\u0006\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\"(\u0010&\u001a\u00020%*\u00020'2\u0006\u0010\u0006\u001a\u00020%8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\"8\u0010-\u001a\n \u001f*\u0004\u0018\u00010,0,*\u00020.2\u000e\u0010\u0006\u001a\n \u001f*\u0004\u0018\u00010,0,8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u00102\u00a8\u00063"}, d2={"setTransformationServer", "", "Lnet/minecraft/world/entity/Display;", "transformation", "Lcom/mojang/math/Transformation;", "getTransformationServer", "value", "getTransformation", "(Lnet/minecraft/world/entity/Display;)Lcom/mojang/math/Transformation;", "setTransformation", "(Lnet/minecraft/world/entity/Display;Lcom/mojang/math/Transformation;)V", "", "interpolationDuration", "getInterpolationDuration", "(Lnet/minecraft/world/entity/Display;)I", "setInterpolationDuration", "(Lnet/minecraft/world/entity/Display;I)V", "interpolationDelay", "getInterpolationDelay", "setInterpolationDelay", "teleportDuration", "getTeleportDuration", "setTeleportDuration", "Lnet/minecraft/util/Brightness;", "Lorg/jetbrains/annotations/Nullable;", "brightness", "getBrightness", "(Lnet/minecraft/world/entity/Display;)Lnet/minecraft/util/Brightness;", "setBrightness", "(Lnet/minecraft/world/entity/Display;Lnet/minecraft/util/Brightness;)V", "Lnet/minecraft/world/entity/Display$BillboardConstraints;", "kotlin.jvm.PlatformType", "billboard", "getBillboard", "(Lnet/minecraft/world/entity/Display;)Lnet/minecraft/world/entity/Display$BillboardConstraints;", "setBillboard", "(Lnet/minecraft/world/entity/Display;Lnet/minecraft/world/entity/Display$BillboardConstraints;)V", "Lnet/minecraft/world/level/block/state/BlockState;", "block", "Lnet/minecraft/world/entity/Display$BlockDisplay;", "getBlock", "(Lnet/minecraft/world/entity/Display$BlockDisplay;)Lnet/minecraft/world/level/block/state/BlockState;", "setBlock", "(Lnet/minecraft/world/entity/Display$BlockDisplay;Lnet/minecraft/world/level/block/state/BlockState;)V", "Lnet/minecraft/network/chat/Component;", "text", "Lnet/minecraft/world/entity/Display$TextDisplay;", "getText", "(Lnet/minecraft/world/entity/Display$TextDisplay;)Lnet/minecraft/network/chat/Component;", "setText", "(Lnet/minecraft/world/entity/Display$TextDisplay;Lnet/minecraft/network/chat/Component;)V", "brokencore-common"})
public final class DisplayDSLKt {
    public static final void setTransformationServer(@NotNull Display $this$setTransformationServer, @NotNull Transformation transformation) {
        Intrinsics.checkNotNullParameter((Object)$this$setTransformationServer, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)transformation, (String)"transformation");
        $this$setTransformationServer.getEntityData().set(DisplayAccessor.bc$DATA_TRANSLATION_ID(), (Object)transformation.getTranslation());
        $this$setTransformationServer.getEntityData().set(DisplayAccessor.bc$DATA_LEFT_ROTATION_ID(), (Object)transformation.getLeftRotation());
        $this$setTransformationServer.getEntityData().set(DisplayAccessor.bc$DATA_SCALE_ID(), (Object)transformation.getScale());
        $this$setTransformationServer.getEntityData().set(DisplayAccessor.bc$DATA_RIGHT_ROTATION_ID(), (Object)transformation.getRightRotation());
    }

    @NotNull
    public static final Transformation getTransformationServer(@NotNull Display $this$getTransformationServer) {
        Intrinsics.checkNotNullParameter((Object)$this$getTransformationServer, (String)"<this>");
        Vector3f translation = (Vector3f)$this$getTransformationServer.getEntityData().get(DisplayAccessor.bc$DATA_TRANSLATION_ID());
        Quaternionf leftRotation = (Quaternionf)$this$getTransformationServer.getEntityData().get(DisplayAccessor.bc$DATA_LEFT_ROTATION_ID());
        Vector3f scale = (Vector3f)$this$getTransformationServer.getEntityData().get(DisplayAccessor.bc$DATA_SCALE_ID());
        Quaternionf rightRotation = (Quaternionf)$this$getTransformationServer.getEntityData().get(DisplayAccessor.bc$DATA_RIGHT_ROTATION_ID());
        return new Transformation(translation, leftRotation, scale, rightRotation);
    }

    @NotNull
    public static final Transformation getTransformation(@NotNull Display $this$transformation) {
        Intrinsics.checkNotNullParameter((Object)$this$transformation, (String)"<this>");
        Display.RenderState renderState = $this$transformation.renderState();
        if (renderState == null || (renderState = renderState.transformation()) == null || (renderState = (Transformation)renderState.get(0.0f)) == null) {
            renderState = DisplayDSLKt.getTransformationServer($this$transformation);
        }
        return renderState;
    }

    public static final void setTransformation(@NotNull Display $this$transformation, @NotNull Transformation value) {
        Intrinsics.checkNotNullParameter((Object)$this$transformation, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        DisplayDSLKt.setTransformationServer($this$transformation, value);
    }

    public static final int getInterpolationDuration(@NotNull Display $this$interpolationDuration) {
        Intrinsics.checkNotNullParameter((Object)$this$interpolationDuration, (String)"<this>");
        return ((DisplayAccessor)$this$interpolationDuration).bc$getTransformationInterpolationDuration();
    }

    public static final void setInterpolationDuration(@NotNull Display $this$interpolationDuration, int value) {
        Intrinsics.checkNotNullParameter((Object)$this$interpolationDuration, (String)"<this>");
        ((DisplayAccessor)$this$interpolationDuration).bc$setTransformationInterpolationDuration(value);
    }

    public static final int getInterpolationDelay(@NotNull Display $this$interpolationDelay) {
        Intrinsics.checkNotNullParameter((Object)$this$interpolationDelay, (String)"<this>");
        return ((DisplayAccessor)$this$interpolationDelay).bc$getTransformationInterpolationDelay();
    }

    public static final void setInterpolationDelay(@NotNull Display $this$interpolationDelay, int value) {
        Intrinsics.checkNotNullParameter((Object)$this$interpolationDelay, (String)"<this>");
        ((DisplayAccessor)$this$interpolationDelay).bc$setTransformationInterpolationDelay(value);
    }

    public static final int getTeleportDuration(@NotNull Display $this$teleportDuration) {
        Intrinsics.checkNotNullParameter((Object)$this$teleportDuration, (String)"<this>");
        return ((DisplayAccessor)$this$teleportDuration).bc$getPosRotInterpolationDuration();
    }

    public static final void setTeleportDuration(@NotNull Display $this$teleportDuration, int value) {
        Intrinsics.checkNotNullParameter((Object)$this$teleportDuration, (String)"<this>");
        ((DisplayAccessor)$this$teleportDuration).bc$setPosRotInterpolationDuration(value);
    }

    @Nullable
    public static final Brightness getBrightness(@NotNull Display $this$brightness) {
        Intrinsics.checkNotNullParameter((Object)$this$brightness, (String)"<this>");
        return ((DisplayAccessor)$this$brightness).bc$getBrightnessOverride();
    }

    public static final void setBrightness(@NotNull Display $this$brightness, @Nullable Brightness value) {
        Intrinsics.checkNotNullParameter((Object)$this$brightness, (String)"<this>");
        ((DisplayAccessor)$this$brightness).bc$setBrightnessOverride(value);
    }

    public static final Display.BillboardConstraints getBillboard(@NotNull Display $this$billboard) {
        Intrinsics.checkNotNullParameter((Object)$this$billboard, (String)"<this>");
        return ((DisplayAccessor)$this$billboard).bc$getBillboardConstraints();
    }

    public static final void setBillboard(@NotNull Display $this$billboard, Display.BillboardConstraints value) {
        Intrinsics.checkNotNullParameter((Object)$this$billboard, (String)"<this>");
        ((DisplayAccessor)$this$billboard).bc$setBillboardConstraints(value);
    }

    @NotNull
    public static final BlockState getBlock(@NotNull Display.BlockDisplay $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"<this>");
        BlockState blockState = ((BlockDisplayAccessor)$this$block).bc$getBlockState();
        Intrinsics.checkNotNullExpressionValue((Object)blockState, (String)"bc$getBlockState(...)");
        return blockState;
    }

    public static final void setBlock(@NotNull Display.BlockDisplay $this$block, @NotNull BlockState value) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        ((BlockDisplayAccessor)$this$block).bc$setBlockState(value);
    }

    public static final Component getText(@NotNull Display.TextDisplay $this$text) {
        Intrinsics.checkNotNullParameter((Object)$this$text, (String)"<this>");
        return ((TextDisplayAccessor)$this$text).bc$getText();
    }

    public static final void setText(@NotNull Display.TextDisplay $this$text, Component value) {
        Intrinsics.checkNotNullParameter((Object)$this$text, (String)"<this>");
        ((TextDisplayAccessor)$this$text).bc$setText(value);
    }
}

