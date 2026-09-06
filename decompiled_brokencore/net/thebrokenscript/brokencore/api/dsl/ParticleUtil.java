/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.dsl;

import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000(\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001aA\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\t\u00a2\u0006\u0002\u0010\f\u001aB\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\t\u00a8\u0006\u000e"}, d2={"sendParticles", "", "T", "Lnet/minecraft/core/particles/ParticleOptions;", "Lnet/minecraft/server/level/ServerLevel;", "type", "pos", "Lnet/minecraft/world/phys/Vec3;", "particleCount", "", "offset", "speed", "(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/particles/ParticleOptions;Lnet/minecraft/world/phys/Vec3;Ljava/lang/Number;Lnet/minecraft/world/phys/Vec3;Ljava/lang/Number;)I", "Ljava/util/function/Supplier;", "brokencore-common"})
@JvmName(name="ParticleUtil")
public final class ParticleUtil {
    public static final <T extends ParticleOptions> int sendParticles(@NotNull ServerLevel $this$sendParticles, @NotNull T type, @NotNull Vec3 pos, @NotNull Number particleCount, @NotNull Vec3 offset, @NotNull Number speed) {
        Intrinsics.checkNotNullParameter((Object)$this$sendParticles, (String)"<this>");
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)particleCount, (String)"particleCount");
        Intrinsics.checkNotNullParameter((Object)offset, (String)"offset");
        Intrinsics.checkNotNullParameter((Object)speed, (String)"speed");
        return $this$sendParticles.sendParticles(type, pos.x, pos.y, pos.z, particleCount.intValue(), offset.x, offset.y, offset.z, speed.doubleValue());
    }

    public static final <T extends ParticleOptions> int sendParticles(@NotNull ServerLevel $this$sendParticles, @NotNull Supplier<T> type, @NotNull Vec3 pos, @NotNull Number particleCount, @NotNull Vec3 offset, @NotNull Number speed) {
        Intrinsics.checkNotNullParameter((Object)$this$sendParticles, (String)"<this>");
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)particleCount, (String)"particleCount");
        Intrinsics.checkNotNullParameter((Object)offset, (String)"offset");
        Intrinsics.checkNotNullParameter((Object)speed, (String)"speed");
        T t = type.get();
        Intrinsics.checkNotNullExpressionValue(t, (String)"get(...)");
        return ParticleUtil.sendParticles($this$sendParticles, (ParticleOptions)t, pos, particleCount, offset, speed);
    }
}

