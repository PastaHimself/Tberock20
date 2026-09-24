/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.level.Level
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.brokencore.impl.mixin.features.targetsync;

import java.util.Optional;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import net.thebrokenscript.brokencore.api.mixinterfaces.ClientTargetAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Mob.class})
public class MobMixin
implements ClientTargetAccess {
    @Unique
    private static final EntityDataAccessor<Optional<UUID>> CLIENT_TARGET_ID = SynchedEntityData.defineId(Mob.class, (EntityDataSerializer)EntityDataSerializers.OPTIONAL_UUID);

    @Inject(method={"defineSynchedData"}, at={@At(value="TAIL")})
    private void addTargetSync(SynchedEntityData.Builder builder, CallbackInfo ci) {
        builder.define(CLIENT_TARGET_ID, Optional.empty());
    }

    @Inject(method={"setTarget"}, at={@At(value="TAIL")})
    private void syncTargetToClient(@Nullable LivingEntity target, CallbackInfo ci) {
        Mob mob = (Mob)this;
        Level level = mob.level();
        if (level != null && !level.isClientSide) {
            mob.getEntityData().set(CLIENT_TARGET_ID, Optional.ofNullable(target != null ? target.getUUID() : null));
        }
    }

    @Override
    @Unique
    public UUID bc$getClientTargetUUID() {
        return ((Optional)((Mob)this).getEntityData().get(CLIENT_TARGET_ID)).orElse(null);
    }
}

