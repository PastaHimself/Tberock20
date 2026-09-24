/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.Direction
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.GameType
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.EntityHitResult
 *  net.minecraft.world.phys.Vec2
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.entity.base.UwuableArrow
 *  org.jetbrains.annotations.NotNull
 *  software.bernie.geckolib.animation.AnimatableManager$ControllerRegistrar
 */
package net.thebrokenscript.entity.boss;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.entity.base.UwuableArrow;
import net.thebrokenscript.registry.TBSEntities;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animation.AnimatableManager;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007B)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u00a2\u0006\u0004\b\u0006\u0010\fB\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0006\u0010\u000fJ\b\u0010\u001f\u001a\u00020\u0017H\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0014J\u0010\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020&H\u0014J\u0010\u0010'\u001a\u00020!2\u0006\u0010%\u001a\u00020(H\u0014J\u0010\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020+H\u0016R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006,"}, d2={"Lnet/thebrokenscript/entity/boss/ChordProjectileEntity;", "Lnet/thebrokenscript/brokencore/api/entity/base/UwuableArrow;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "x", "", "y", "z", "(Lnet/minecraft/world/level/Level;DDD)V", "owner", "Lnet/minecraft/world/entity/LivingEntity;", "(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/LivingEntity;)V", "groundedOffset", "Lnet/minecraft/world/phys/Vec2;", "getGroundedOffset", "()Lnet/minecraft/world/phys/Vec2;", "setGroundedOffset", "(Lnet/minecraft/world/phys/Vec2;)V", "isInGround", "", "()Z", "initialPos", "Lnet/minecraft/world/phys/Vec3;", "getInitialPos", "()Lnet/minecraft/world/phys/Vec3;", "setInitialPos", "(Lnet/minecraft/world/phys/Vec3;)V", "shouldBeSaved", "baseTick", "", "getDefaultPickupItem", "Lnet/minecraft/world/item/ItemStack;", "onHitEntity", "result", "Lnet/minecraft/world/phys/EntityHitResult;", "onHitBlock", "Lnet/minecraft/world/phys/BlockHitResult;", "registerControllers", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "thebrokenscript-common"})
public final class ChordProjectileEntity
extends UwuableArrow {
    @NotNull
    private Vec2 groundedOffset;
    @NotNull
    private Vec3 initialPos;

    public ChordProjectileEntity(@NotNull EntityType<ChordProjectileEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.groundedOffset = new Vec2(0.0f, 0.0f);
        this.initialPos = new Vec3(69.0, 420.0, 69.0);
        this.setNoGravity(true);
    }

    public ChordProjectileEntity(@NotNull Level level, double x, double y, double z) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super((EntityType)TBSEntities.CHORD_PROJECTILE.get(), x, y, z, level, ItemStack.EMPTY, null);
        this.groundedOffset = new Vec2(0.0f, 0.0f);
        this.initialPos = new Vec3(69.0, 420.0, 69.0);
        this.setNoGravity(true);
    }

    public ChordProjectileEntity(@NotNull Level level, @NotNull LivingEntity owner) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)owner, (String)"owner");
        super((EntityType)TBSEntities.CHORD_PROJECTILE.get(), owner, level, ItemStack.EMPTY, null);
        this.groundedOffset = new Vec2(0.0f, 0.0f);
        this.initialPos = new Vec3(69.0, 420.0, 69.0);
        this.setNoGravity(true);
    }

    @NotNull
    public final Vec2 getGroundedOffset() {
        return this.groundedOffset;
    }

    public final void setGroundedOffset(@NotNull Vec2 vec2) {
        Intrinsics.checkNotNullParameter((Object)vec2, (String)"<set-?>");
        this.groundedOffset = vec2;
    }

    public final boolean isInGround() {
        return this.inGround;
    }

    @NotNull
    public final Vec3 getInitialPos() {
        return this.initialPos;
    }

    public final void setInitialPos(@NotNull Vec3 vec3) {
        Intrinsics.checkNotNullParameter((Object)vec3, (String)"<set-?>");
        this.initialPos = vec3;
    }

    public boolean shouldBeSaved() {
        return false;
    }

    public void baseTick() {
        this.onServerTick(arg_0 -> ChordProjectileEntity.baseTick$lambda$0(this, arg_0));
    }

    @NotNull
    protected ItemStack getDefaultPickupItem() {
        ItemStack itemStack = ItemStack.EMPTY;
        Intrinsics.checkNotNullExpressionValue((Object)itemStack, (String)"EMPTY");
        return itemStack;
    }

    protected void onHitEntity(@NotNull EntityHitResult result) {
        LivingEntity entity;
        Intrinsics.checkNotNullParameter((Object)result, (String)"result");
        Entity entity2 = result.getEntity();
        LivingEntity livingEntity = entity = entity2 instanceof LivingEntity ? (LivingEntity)entity2 : null;
        if (Intrinsics.areEqual((Object)(livingEntity != null ? livingEntity.getType() : null), (Object)TBSEntities.CHORD.get())) {
            this.discard();
        } else {
            super.onHitEntity(result);
            if (entity instanceof Player) {
                GameType gameType = PlayerUtil.getGameMode((Player)((Player)entity));
                boolean bl = gameType != null ? gameType.isCreative() : false;
                if (bl) {
                    this.discard();
                }
            }
            LivingEntity livingEntity2 = entity;
            if (livingEntity2 != null) {
                livingEntity2.setArrowCount(Math.max(0, entity.getArrowCount() - 1));
            }
        }
        this.setNoGravity(false);
    }

    protected void onHitBlock(@NotNull BlockHitResult result) {
        Intrinsics.checkNotNullParameter((Object)result, (String)"result");
        super.onHitBlock(result);
        this.setNoGravity(false);
        Direction direction = result.getDirection();
        this.groundedOffset = switch (direction == null ? -1 : WhenMappings.$EnumSwitchMapping$0[direction.ordinal()]) {
            case 1 -> new Vec2(215.0f, 180.0f);
            case 2 -> new Vec2(215.0f, 0.0f);
            case 3 -> new Vec2(215.0f, -90.0f);
            case 4 -> new Vec2(215.0f, 90.0f);
            case 5 -> new Vec2(115.0f, 180.0f);
            case 6 -> new Vec2(185.0f, 180.0f);
            default -> throw new NoWhenBranchMatchedException();
        };
        if (this.getLevel() instanceof ServerLevel) {
            this.queueDiscard(20L);
        }
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
    }

    private static final Unit baseTick$lambda$0(ChordProjectileEntity this$0, ServerLevel it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        if (this$0.getPos().distanceTo(this$0.initialPos) >= 100.0) {
            this$0.discard();
        }
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[Direction.values().length];
            try {
                nArray[Direction.SOUTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.NORTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.EAST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.WEST.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.DOWN.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.UP.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

