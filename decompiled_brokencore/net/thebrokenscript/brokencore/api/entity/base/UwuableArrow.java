/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.projectile.AbstractArrow
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.animatable.GeoAnimatable
 */
package net.thebrokenscript.brokencore.api.entity.base;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.thebrokenscript.brokencore.api.entity.anim.GeckoAnimatedArrow;
import net.thebrokenscript.brokencore.api.entity.base.Uwuable;
import net.thebrokenscript.brokencore.api.misc.UwuManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u0000 \"2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\"B!\b\u0016\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nBM\b\u0014\u0012\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\t\u0010\u0013B=\b\u0014\u0012\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\t\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u0014\u0010\u001f\u001a\u00020 8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010!\u00a8\u0006#"}, d2={"Lnet/thebrokenscript/brokencore/api/entity/base/UwuableArrow;", "Lnet/thebrokenscript/brokencore/api/entity/anim/GeckoAnimatedArrow;", "Lsoftware/bernie/geckolib/animatable/GeoAnimatable;", "Lnet/thebrokenscript/brokencore/api/entity/base/Uwuable;", "type", "Lnet/minecraft/world/entity/EntityType;", "Lnet/minecraft/world/entity/projectile/AbstractArrow;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "entityType", "x", "", "y", "z", "pickupItemStack", "Lnet/minecraft/world/item/ItemStack;", "firedFromWeapon", "(Lnet/minecraft/world/entity/EntityType;DDDLnet/minecraft/world/level/Level;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemStack;)V", "owner", "Lnet/minecraft/world/entity/LivingEntity;", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/level/Level;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemStack;)V", "defineSynchedData", "", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "addAdditionalSaveData", "compound", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "isUwu", "", "()Z", "Companion", "brokencore-common"})
public abstract class UwuableArrow
extends GeckoAnimatedArrow
implements GeoAnimatable,
Uwuable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final EntityDataAccessor<Boolean> UWU;

    public UwuableArrow(@NotNull EntityType<? extends AbstractArrow> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        if (UwuManager.shouldBeUwu()) {
            this.entityData.set(UWU, (Object)true);
        }
    }

    protected UwuableArrow(@NotNull EntityType<? extends AbstractArrow> entityType, double x, double y, double z, @NotNull Level level, @Nullable ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        Intrinsics.checkNotNullParameter(entityType, (String)"entityType");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(entityType, x, y, z, level, pickupItemStack, firedFromWeapon);
        if (UwuManager.shouldBeUwu()) {
            this.entityData.set(UWU, (Object)true);
        }
    }

    protected UwuableArrow(@NotNull EntityType<? extends AbstractArrow> entityType, @NotNull LivingEntity owner, @NotNull Level level, @Nullable ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        Intrinsics.checkNotNullParameter(entityType, (String)"entityType");
        Intrinsics.checkNotNullParameter((Object)owner, (String)"owner");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(entityType, owner, level, pickupItemStack, firedFromWeapon);
        if (UwuManager.shouldBeUwu()) {
            this.entityData.set(UWU, (Object)true);
        }
    }

    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(UWU, (Object)false);
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        Object object = this.entityData.get(UWU);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"get(...)");
        compound.putBoolean("uwu", ((Boolean)object).booleanValue());
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        if (compound.contains("uwu")) {
            this.entityData.set(UWU, (Object)compound.getBoolean("uwu"));
        }
    }

    @Override
    public boolean isUwu() {
        Object object = this.entityData.get(UWU);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"get(...)");
        return (Boolean)object;
    }

    static {
        EntityDataAccessor entityDataAccessor = SynchedEntityData.defineId(UwuableArrow.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor, (String)"defineId(...)");
        UWU = entityDataAccessor;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/entity/base/UwuableArrow$Companion;", "", "<init>", "()V", "UWU", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "", "getUWU", "()Lnet/minecraft/network/syncher/EntityDataAccessor;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final EntityDataAccessor<Boolean> getUWU() {
            return UWU;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

