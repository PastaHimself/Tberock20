/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.entity.LevelCallback
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.brokencore.impl.mixin.features.multipart;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.entity.LevelCallback;
import net.thebrokenscript.brokencore.api.entity.multipart.MultipartEntity;
import net.thebrokenscript.brokencore.api.entity.multipart.MultipartEntityPart;
import net.thebrokenscript.brokencore.impl.mixinterfaces.MultipartServerLevelState;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets={"net.minecraft.server.level.ServerLevel$EntityCallbacks"})
public abstract class EntityCallbacksMixin
implements LevelCallback<Entity> {
    @Shadow
    @Final
    ServerLevel this$0;

    @Inject(method={"onTrackingStart(Lnet/minecraft/world/entity/Entity;)V"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;updateDynamicGameEventListener(Ljava/util/function/BiConsumer;)V", shift=At.Shift.BY, by=-1)})
    public void bc$addMultipartsStart(Entity p_143371_, CallbackInfo ci) {
        if (p_143371_ instanceof MultipartEntity) {
            MultipartEntity entity = (MultipartEntity)p_143371_;
            for (MultipartEntityPart<?> part : entity.getParts()) {
                ((MultipartServerLevelState)this.this$0).bc$getMultipartEntities().put(part.getId(), part);
            }
        }
    }

    @Inject(method={"onTrackingEnd(Lnet/minecraft/world/entity/Entity;)V"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;updateDynamicGameEventListener(Ljava/util/function/BiConsumer;)V", shift=At.Shift.BY, by=-1)})
    public void bc$addMultipartsEnd(Entity p_143371_, CallbackInfo ci) {
        if (p_143371_ instanceof MultipartEntity) {
            MultipartEntity entity = (MultipartEntity)p_143371_;
            for (MultipartEntityPart<?> part : entity.getParts()) {
                ((MultipartServerLevelState)this.this$0).bc$getMultipartEntities().remove(part.getId());
            }
        }
    }
}

