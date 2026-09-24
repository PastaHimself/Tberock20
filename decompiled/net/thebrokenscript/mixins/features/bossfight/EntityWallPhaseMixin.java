/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.mixins.features.bossfight;

import java.util.List;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.entity.integrity.phase3.IntegrityPhase3Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={Entity.class})
public abstract class EntityWallPhaseMixin {
    @Inject(method={"collide(Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/phys/Vec3;"}, at={@At(value="HEAD")}, cancellable=true)
    private void tbs$noWallCollision(Vec3 vec, CallbackInfoReturnable<Vec3> cir) {
        if (!((Entity)this instanceof IntegrityPhase3Entity)) {
            return;
        }
        Entity self = (Entity)this;
        AABB box = self.getBoundingBox();
        Level level = self.level();
        Vec3 vertical = new Vec3(0.0, vec.y, 0.0);
        Vec3 resolvedY = vertical.lengthSqr() == 0.0 ? vertical : Entity.collideBoundingBox((Entity)self, (Vec3)vertical, (AABB)box, (Level)level, (List)level.getEntityCollisions(self, box.expandTowards(vertical)));
        cir.setReturnValue((Object)new Vec3(vec.x, resolvedY.y, vec.z));
    }
}

