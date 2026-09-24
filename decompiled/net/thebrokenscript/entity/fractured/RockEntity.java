/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 *  net.minecraft.core.particles.BlockParticleOption
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.item.ElytraItem
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.EntityHitResult
 *  net.minecraft.world.phys.HitResult
 *  net.thebrokenscript.brokencore.api.dsl.SideUtil
 *  net.thebrokenscript.brokencore.api.entity.base.UwuableArrow
 *  org.jetbrains.annotations.NotNull
 *  software.bernie.geckolib.animation.AnimatableManager$ControllerRegistrar
 */
package net.thebrokenscript.entity.fractured;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.thebrokenscript.TheBrokenScript;
import net.thebrokenscript.brokencore.api.dsl.SideUtil;
import net.thebrokenscript.brokencore.api.entity.base.UwuableArrow;
import net.thebrokenscript.registry.TBSBlocks;
import net.thebrokenscript.registry.TBSDamageTypes;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animation.AnimatableManager;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0014J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016\u00a8\u0006\u0017"}, d2={"Lnet/thebrokenscript/entity/fractured/RockEntity;", "Lnet/thebrokenscript/brokencore/api/entity/base/UwuableArrow;", "entityType", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "registerControllers", "", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "getDefaultPickupItem", "Lnet/minecraft/world/item/ItemStack;", "onHit", "result", "Lnet/minecraft/world/phys/HitResult;", "onHitEntity", "Lnet/minecraft/world/phys/EntityHitResult;", "onHitBlock", "Lnet/minecraft/world/phys/BlockHitResult;", "isPushable", "", "thebrokenscript-common"})
public final class RockEntity
extends UwuableArrow {
    public RockEntity(@NotNull EntityType<RockEntity> entityType, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(entityType, (String)"entityType");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(entityType, level);
        this.setSoundEvent(SoundEvents.STONE_BREAK);
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
    }

    @NotNull
    protected ItemStack getDefaultPickupItem() {
        ItemStack itemStack = ItemStack.EMPTY;
        Intrinsics.checkNotNullExpressionValue((Object)itemStack, (String)"EMPTY");
        return itemStack;
    }

    protected void onHit(@NotNull HitResult result) {
        Intrinsics.checkNotNullParameter((Object)result, (String)"result");
        super.onHit(result);
        SideUtil.serverSide((Entity)((Entity)this), () -> RockEntity.onHit$lambda$0(this));
    }

    protected void onHitEntity(@NotNull EntityHitResult result) {
        Intrinsics.checkNotNullParameter((Object)result, (String)"result");
    }

    protected void onHitBlock(@NotNull BlockHitResult result) {
        Intrinsics.checkNotNullParameter((Object)result, (String)"result");
        super.onHitBlock(result);
        int n = 400;
        int n2 = 0;
        while (n2 < n) {
            int it = n2++;
            boolean bl = false;
            this.getLevel().addParticle((ParticleOptions)new BlockParticleOption(ParticleTypes.BLOCK, TBSBlocks.MOON_STONE.getDefaultState()), this.getPos().x + (Math.random() * (double)30 - (double)15), this.getPos().y + (Math.random() * (double)15 - 7.5), this.getPos().z + (Math.random() * (double)30 - (double)15), 0.0, 2.0, 0.0);
        }
        TheBrokenScript.serverWorkQueue.add(1L, () -> RockEntity.onHitBlock$lambda$1(this));
    }

    public boolean isPushable() {
        return false;
    }

    private static final Unit onHit$lambda$0(RockEntity this$0) {
        AABB box = this$0.getBoundingBox().inflate(4.0);
        List boxPeople = this$0.getLevel().getEntitiesOfClass(LivingEntity.class, box, arg_0 -> RockEntity.onHit$lambda$0$1(arg_0 -> RockEntity.onHit$lambda$0$0(this$0, box, arg_0), arg_0));
        for (LivingEntity people : boxPeople) {
            people.hurt(this$0.getLevel().damageSources().source(TBSDamageTypes.ROCK.getKey()), (float)this$0.getBaseDamage());
            people.setArrowCount(Math.max(0, people.getArrowCount() - 1));
            ItemStack chestSlot = people.getItemBySlot(EquipmentSlot.CHEST);
            int oneEighthOfYourElytraBecauseIAmEvilButNotEvilToThePointOfDestroyingTheItem = RangesKt.coerceAtMost((int)RangesKt.coerceAtLeast((int)(chestSlot.getMaxDamage() / 8), (int)1), (int)(chestSlot.getMaxDamage() - chestSlot.getDamageValue() - 1));
            if (!(chestSlot.getItem() instanceof ElytraItem)) continue;
            chestSlot.hurtAndBreak(oneEighthOfYourElytraBecauseIAmEvilButNotEvilToThePointOfDestroyingTheItem, people, EquipmentSlot.CHEST);
        }
        return Unit.INSTANCE;
    }

    private static final boolean onHit$lambda$0$0(RockEntity this$0, AABB $box, LivingEntity goober) {
        return !Intrinsics.areEqual((Object)goober, (Object)this$0.getOwner()) && goober.getBoundingBox().intersects($box);
    }

    private static final boolean onHit$lambda$0$1(Function1 $tmp0, Object p0) {
        return (Boolean)$tmp0.invoke(p0);
    }

    private static final Unit onHitBlock$lambda$1(RockEntity this$0) {
        this$0.discard();
        return Unit.INSTANCE;
    }
}

