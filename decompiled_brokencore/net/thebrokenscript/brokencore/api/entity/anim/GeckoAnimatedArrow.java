/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.projectile.AbstractArrow
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.animatable.GeoAnimatable
 *  software.bernie.geckolib.animatable.GeoEntity
 *  software.bernie.geckolib.animatable.instance.AnimatableInstanceCache
 *  software.bernie.geckolib.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.util.GeckoLibUtil
 */
package net.thebrokenscript.brokencore.api.entity.anim;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.thebrokenscript.brokencore.api.entity.base.BaseArrow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0014\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tBM\b\u0014\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\b\u0010\u0011B=\b\u0014\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\b\u0010\u0014J\b\u0010\u0018\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH&R\u0016\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2={"Lnet/thebrokenscript/brokencore/api/entity/anim/GeckoAnimatedArrow;", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseArrow;", "Lsoftware/bernie/geckolib/animatable/GeoEntity;", "entityType", "Lnet/minecraft/world/entity/EntityType;", "Lnet/minecraft/world/entity/projectile/AbstractArrow;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "x", "", "y", "z", "pickupItemStack", "Lnet/minecraft/world/item/ItemStack;", "firedFromWeapon", "(Lnet/minecraft/world/entity/EntityType;DDDLnet/minecraft/world/level/Level;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemStack;)V", "owner", "Lnet/minecraft/world/entity/LivingEntity;", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/level/Level;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemStack;)V", "cache", "Lsoftware/bernie/geckolib/animatable/instance/AnimatableInstanceCache;", "kotlin.jvm.PlatformType", "getAnimatableInstanceCache", "registerControllers", "", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "brokencore-common"})
public abstract class GeckoAnimatedArrow
extends BaseArrow
implements GeoEntity {
    private final AnimatableInstanceCache cache;

    protected GeckoAnimatedArrow(@NotNull EntityType<? extends AbstractArrow> entityType, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(entityType, (String)"entityType");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(entityType, level);
        this.cache = GeckoLibUtil.createInstanceCache((GeoAnimatable)((GeoAnimatable)this));
    }

    protected GeckoAnimatedArrow(@NotNull EntityType<? extends AbstractArrow> entityType, double x, double y, double z, @NotNull Level level, @Nullable ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        Intrinsics.checkNotNullParameter(entityType, (String)"entityType");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(entityType, x, y, z, level, pickupItemStack, firedFromWeapon);
        this.cache = GeckoLibUtil.createInstanceCache((GeoAnimatable)((GeoAnimatable)this));
    }

    protected GeckoAnimatedArrow(@NotNull EntityType<? extends AbstractArrow> entityType, @NotNull LivingEntity owner, @NotNull Level level, @Nullable ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        Intrinsics.checkNotNullParameter(entityType, (String)"entityType");
        Intrinsics.checkNotNullParameter((Object)owner, (String)"owner");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(entityType, owner, level, pickupItemStack, firedFromWeapon);
        this.cache = GeckoLibUtil.createInstanceCache((GeoAnimatable)((GeoAnimatable)this));
    }

    @NotNull
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        AnimatableInstanceCache animatableInstanceCache = this.cache;
        Intrinsics.checkNotNullExpressionValue((Object)animatableInstanceCache, (String)"cache");
        return animatableInstanceCache;
    }

    public abstract void registerControllers(@NotNull AnimatableManager.ControllerRegistrar var1);
}

