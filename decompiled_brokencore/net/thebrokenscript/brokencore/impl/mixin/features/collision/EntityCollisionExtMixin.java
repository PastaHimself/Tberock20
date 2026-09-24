/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyReturnValue
 *  net.minecraft.world.entity.Entity
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 */
package net.thebrokenscript.brokencore.impl.mixin.features.collision;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.entity.Entity;
import net.thebrokenscript.brokencore.api.mixinterfaces.EntityCollisionExt;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value={Entity.class})
public class EntityCollisionExtMixin
implements EntityCollisionExt {
    @Unique
    private boolean bc$isCollidable = true;

    @ModifyReturnValue(method={"canBeCollidedWith"}, at={@At(value="RETURN")})
    public boolean bc$modifyCollidable(boolean original) {
        return original && this.bc$isCollidable;
    }

    @Override
    public boolean getBc$isCollidable() {
        return this.bc$isCollidable;
    }

    @Override
    public void setBc$isCollidable(boolean b) {
        this.bc$isCollidable = b;
    }
}

