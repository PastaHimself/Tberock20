/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.renderer.DimensionSpecialEffects
 *  net.minecraft.client.renderer.DimensionSpecialEffects$SkyType
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.world.dimension.nothing;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0016\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/world/dimension/nothing/NothingEffects;", "Lnet/minecraft/client/renderer/DimensionSpecialEffects;", "<init>", "()V", "getBrightnessDependentFogColor", "Lnet/minecraft/world/phys/Vec3;", "var1", "var2", "", "isFoggyAt", "", "x", "", "z", "getSunriseColor", "", "timeOfDay", "partialTicks", "thebrokenscript-common"})
public final class NothingEffects
extends DimensionSpecialEffects {
    public NothingEffects() {
        super(Float.NaN, false, DimensionSpecialEffects.SkyType.NONE, true, true);
    }

    @NotNull
    public Vec3 getBrightnessDependentFogColor(@NotNull Vec3 var1, float var2) {
        Intrinsics.checkNotNullParameter((Object)var1, (String)"var1");
        Vec3 vec3 = var1.scale(0.15);
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"scale(...)");
        return vec3;
    }

    public boolean isFoggyAt(int x, int z) {
        return false;
    }

    @Nullable
    public float[] getSunriseColor(float timeOfDay, float partialTicks) {
        return null;
    }
}

