/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.renderer.DimensionSpecialEffects
 *  net.minecraft.client.renderer.DimensionSpecialEffects$SkyType
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.client.level;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/brokencore/api/client/level/SimpleDimensionFX;", "Lnet/minecraft/client/renderer/DimensionSpecialEffects;", "cloudLevel", "", "hasGround", "", "skyType", "Lnet/minecraft/client/renderer/DimensionSpecialEffects$SkyType;", "forceBrightLightmap", "constantAmbientLight", "overrideFogColor", "Lnet/minecraft/world/phys/Vec3;", "isFoggyOverride", "<init>", "(FZLnet/minecraft/client/renderer/DimensionSpecialEffects$SkyType;ZZLnet/minecraft/world/phys/Vec3;Z)V", "getBrightnessDependentFogColor", "color", "sunHeight", "isFoggyAt", "x", "", "y", "brokencore-common"})
public class SimpleDimensionFX
extends DimensionSpecialEffects {
    @Nullable
    private final Vec3 overrideFogColor;
    private final boolean isFoggyOverride;

    public SimpleDimensionFX(float cloudLevel, boolean hasGround, @NotNull DimensionSpecialEffects.SkyType skyType, boolean forceBrightLightmap, boolean constantAmbientLight, @Nullable Vec3 overrideFogColor, boolean isFoggyOverride) {
        Intrinsics.checkNotNullParameter((Object)skyType, (String)"skyType");
        super(cloudLevel, hasGround, skyType, forceBrightLightmap, constantAmbientLight);
        this.overrideFogColor = overrideFogColor;
        this.isFoggyOverride = isFoggyOverride;
    }

    public /* synthetic */ SimpleDimensionFX(float f, boolean bl, DimensionSpecialEffects.SkyType skyType, boolean bl2, boolean bl3, Vec3 vec3, boolean bl4, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 0x20) != 0) {
            vec3 = null;
        }
        if ((n & 0x40) != 0) {
            bl4 = true;
        }
        this(f, bl, skyType, bl2, bl3, vec3, bl4);
    }

    @NotNull
    public Vec3 getBrightnessDependentFogColor(@NotNull Vec3 color, float sunHeight) {
        Intrinsics.checkNotNullParameter((Object)color, (String)"color");
        Vec3 vec3 = this.overrideFogColor;
        if (vec3 == null || (vec3 = vec3.multiply((double)sunHeight, (double)sunHeight, (double)sunHeight)) == null) {
            Vec3 vec32 = color.multiply((double)(sunHeight * 0.94f + 0.06f), (double)(sunHeight * 0.94f + 0.06f), (double)(sunHeight * 0.91f + 0.09f));
            vec3 = vec32;
            Intrinsics.checkNotNullExpressionValue((Object)vec32, (String)"multiply(...)");
        }
        return vec3;
    }

    public boolean isFoggyAt(int x, int y) {
        return this.isFoggyOverride;
    }
}

