/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.ClipContext
 *  net.minecraft.world.level.ClipContext$Block
 *  net.minecraft.world.level.ClipContext$Fluid
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.HitResult$Type
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/util/BadSunUtil;", "", "<init>", "()V", "getSunDirection", "Lnet/minecraft/world/phys/Vec3;", "level", "Lnet/minecraft/world/level/Level;", "partialTicks", "", "isInSun", "", "player", "Lnet/minecraft/server/level/ServerPlayer;", "thebrokenscript-common"})
public final class BadSunUtil {
    @NotNull
    public static final BadSunUtil INSTANCE = new BadSunUtil();

    private BadSunUtil() {
    }

    @NotNull
    public final Vec3 getSunDirection(@NotNull Level level, float partialTicks) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        float sunAngle = level.getSunAngle(partialTicks);
        double x = -Math.sin(sunAngle);
        double y = Math.cos(sunAngle);
        double z = 0.0;
        Vec3 vec3 = new Vec3(x, y, z).normalize();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"normalize(...)");
        return vec3;
    }

    public final boolean isInSun(@NotNull ServerPlayer player) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        if (player.isCreative() || player.isSpectator()) {
            return false;
        }
        if (!player.level().isDay()) {
            return false;
        }
        ServerLevel level = player.serverLevel();
        Intrinsics.checkNotNull((Object)level);
        Vec3 sunPos = this.getSunDirection((Level)level, 0.0f).scale(1000.0);
        return level.canSeeSky(player.blockPosition()) && level.clip(new ClipContext(player.position().add(new Vec3(0.0, 1.62, 0.0)), sunPos, ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, (Entity)player)).getType() == HitResult.Type.MISS;
    }
}

