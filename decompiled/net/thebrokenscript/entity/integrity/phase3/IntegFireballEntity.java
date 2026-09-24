/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.projectile.LargeFireball
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.Level$ExplosionInteraction
 *  net.minecraft.world.phys.EntityHitResult
 *  net.minecraft.world.phys.HitResult
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.entity.integrity.phase3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.thebrokenscript.registry.TBSDamageTypes;
import net.thebrokenscript.registry.TBSItems;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0016\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/entity/integrity/phase3/IntegFireballEntity;", "Lnet/minecraft/world/entity/projectile/LargeFireball;", "entityType", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "onHit", "", "result", "Lnet/minecraft/world/phys/HitResult;", "onHitEntity", "Lnet/minecraft/world/phys/EntityHitResult;", "getItem", "Lnet/minecraft/world/item/ItemStack;", "thebrokenscript-common"})
public final class IntegFireballEntity
extends LargeFireball {
    public IntegFireballEntity(@NotNull EntityType<IntegFireballEntity> entityType, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(entityType, (String)"entityType");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(entityType, level);
    }

    protected void onHit(@NotNull HitResult result) {
        Intrinsics.checkNotNullParameter((Object)result, (String)"result");
        super.onHit(result);
        if (!this.level().isClientSide) {
            this.level().explode((Entity)this, this.getX(), this.getY(), this.getZ(), 5.0f, false, Level.ExplosionInteraction.NONE);
        }
    }

    protected void onHitEntity(@NotNull EntityHitResult result) {
        Intrinsics.checkNotNullParameter((Object)result, (String)"result");
        super.onHitEntity(result);
        if (this.level() instanceof ServerLevel) {
            result.getEntity().hurt(this.damageSources().source(TBSDamageTypes.INTEGRITY_BALL.getKey()), 6.0f);
        }
    }

    @NotNull
    public ItemStack getItem() {
        return TBSItems.INTEGRITY_FIREBALL.getStack();
    }
}

