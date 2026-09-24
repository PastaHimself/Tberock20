/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.entity.projectile.ProjectileUtil
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.EntityHitResult
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.dsl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=5, xi=48, d1={"\u0000\u001a\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0012\u0010\u0007\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\n\u0010\b\u001a\u00020\u0003*\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"LOOK_MARGIN", "", "isLookingAt", "", "Lnet/minecraft/world/entity/player/Player;", "entity", "Lnet/minecraft/world/entity/Entity;", "isLookingAtEntityHitbox", "isMultiplayer", "brokencore-common"}, xs="net/thebrokenscript/brokencore/api/dsl/PlayerUtil")
final class PlayerUtil__PlayerCheckDSLKt {
    private static final double LOOK_MARGIN = 0.025;

    public static final boolean isLookingAt(@NotNull Player $this$isLookingAt, @NotNull Entity entity) {
        Intrinsics.checkNotNullParameter((Object)$this$isLookingAt, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Vec3 normalizedView = $this$isLookingAt.getViewVector(1.0f).normalize();
        Vec3 center = new Vec3(entity.getX() - $this$isLookingAt.getX(), entity.getEyeY() - $this$isLookingAt.getEyeY(), entity.getZ() - $this$isLookingAt.getZ());
        double distance = center.length();
        Vec3 vec3 = center.normalize();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"normalize(...)");
        center = vec3;
        double viewCenterDiff = normalizedView.dot(center);
        return viewCenterDiff > 1.0 - 0.025 / distance ? $this$isLookingAt.hasLineOfSight(entity) : false;
    }

    public static final boolean isLookingAtEntityHitbox(@NotNull Player $this$isLookingAtEntityHitbox, @NotNull Entity entity) {
        EntityHitResult result;
        Intrinsics.checkNotNullParameter((Object)$this$isLookingAtEntityHitbox, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Vec3 eyePos = $this$isLookingAtEntityHitbox.getEyePosition();
        Vec3 lookVec = $this$isLookingAtEntityHitbox.getViewVector(1.0f).scale(1024.0);
        Vec3 targetVec = eyePos.add(lookVec);
        EntityHitResult entityHitResult = result = ProjectileUtil.getEntityHitResult((Level)$this$isLookingAtEntityHitbox.level(), (Entity)((Entity)$this$isLookingAtEntityHitbox), (Vec3)eyePos, (Vec3)targetVec, (AABB)entity.getBoundingBox().inflate(0.25), arg_0 -> PlayerUtil__PlayerCheckDSLKt.isLookingAtEntityHitbox$lambda$0$PlayerUtil__PlayerCheckDSLKt(entity, arg_0));
        return (entityHitResult != null ? entityHitResult.getEntity() : null) == entity ? $this$isLookingAtEntityHitbox.hasLineOfSight(entity) : false;
    }

    public static final boolean isMultiplayer(@NotNull Player $this$isMultiplayer) {
        Intrinsics.checkNotNullParameter((Object)$this$isMultiplayer, (String)"<this>");
        MinecraftServer minecraftServer = $this$isMultiplayer.getServer();
        return minecraftServer != null ? !minecraftServer.isSingleplayer() : false;
    }

    private static final boolean isLookingAtEntityHitbox$lambda$0$PlayerUtil__PlayerCheckDSLKt(Entity $entity, Entity it) {
        return it == $entity && it.isPickable();
    }
}

