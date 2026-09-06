/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.projectile.AbstractArrow
 *  net.minecraft.world.entity.projectile.SpectralArrow
 *  net.thebrokenscript.brokencore.api.entity.multipart.MultipartEntity
 *  net.thebrokenscript.brokencore.api.entity.multipart.MultipartEntityPart
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.entity.fractured;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.SpectralArrow;
import net.thebrokenscript.api.entity.BaseFracturedEntity;
import net.thebrokenscript.brokencore.api.entity.multipart.MultipartEntity;
import net.thebrokenscript.brokencore.api.entity.multipart.MultipartEntityPart;
import net.thebrokenscript.entity.fractured.FracturedRoamEntity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/entity/fractured/FracturedPartEntity;", "Lnet/thebrokenscript/brokencore/api/entity/multipart/MultipartEntityPart;", "Lnet/thebrokenscript/api/entity/BaseFracturedEntity;", "parent", "name", "", "width", "", "height", "<init>", "(Lnet/thebrokenscript/api/entity/BaseFracturedEntity;Ljava/lang/String;FF)V", "hurt", "", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "amount", "is", "entity", "Lnet/minecraft/world/entity/Entity;", "thebrokenscript-common"})
public final class FracturedPartEntity
extends MultipartEntityPart<BaseFracturedEntity> {
    public FracturedPartEntity(@NotNull BaseFracturedEntity parent, @NotNull String name, float width, float height) {
        Intrinsics.checkNotNullParameter((Object)((Object)parent), (String)"parent");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        super((MultipartEntity)parent, name, width, height);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean hurt(@NotNull DamageSource source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        if (this.getParent() instanceof FracturedRoamEntity) {
            ((BaseFracturedEntity)this.getParent()).swap();
            return false;
        }
        if (source.getDirectEntity() instanceof AbstractArrow) {
            Entity entity = source.getDirectEntity();
            boolean bl = entity != null ? entity.isOnFire() : false;
            if (bl) {
                ((BaseFracturedEntity)this.getParent()).igniteForSeconds(20.0f);
            }
        }
        if (source.getDirectEntity() instanceof SpectralArrow) {
            ((BaseFracturedEntity)this.getParent()).addEffect(new MobEffectInstance(MobEffects.GLOWING, 400));
        }
        if (this.isInvulnerableTo(source)) {
            return false;
        }
        ((BaseFracturedEntity)this.getParent()).setHitViaPart(true);
        try {
            boolean bl = true;
            return bl;
        }
        finally {
            ((BaseFracturedEntity)this.getParent()).setHitViaPart(false);
        }
    }

    public boolean is(@NotNull Entity entity) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        return this == entity || this.getParent() == entity;
    }
}

