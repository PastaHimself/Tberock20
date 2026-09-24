/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.dsl;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\b \"(\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\"(\u0010\b\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007\"(\u0010\u000b\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007\"(\u0010\u000e\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007\"(\u0010\u0011\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0007\"(\u0010\u0014\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u0005\"\u0004\b\u0016\u0010\u0007\"(\u0010\u0017\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0018\u0010\u0005\"\u0004\b\u0019\u0010\u0007\"(\u0010\u001a\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001b\u0010\u0005\"\u0004\b\u001c\u0010\u0007\"(\u0010\u001d\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001e\u0010\u0005\"\u0004\b\u001f\u0010\u0007\"(\u0010 \u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b!\u0010\u0005\"\u0004\b\"\u0010\u0007\u00a8\u0006#"}, d2={"value", "", "movementSpeed", "Lnet/minecraft/world/entity/ai/attributes/AttributeSupplier$Builder;", "getMovementSpeed", "(Lnet/minecraft/world/entity/ai/attributes/AttributeSupplier$Builder;)Ljava/lang/Number;", "setMovementSpeed", "(Lnet/minecraft/world/entity/ai/attributes/AttributeSupplier$Builder;Ljava/lang/Number;)V", "maxHealth", "getMaxHealth", "setMaxHealth", "armor", "getArmor", "setArmor", "attackDamage", "getAttackDamage", "setAttackDamage", "followRange", "getFollowRange", "setFollowRange", "flyingSpeed", "getFlyingSpeed", "setFlyingSpeed", "stepHeight", "getStepHeight", "setStepHeight", "knockbackResistance", "getKnockbackResistance", "setKnockbackResistance", "attackKnockback", "getAttackKnockback", "setAttackKnockback", "gravity", "getGravity", "setGravity", "brokencore-common"})
@JvmName(name="AttributeUtil")
@SourceDebugExtension(value={"SMAP\nAttributeDSL.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AttributeDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/AttributeUtil\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,77:1\n1#2:78\n*E\n"})
public final class AttributeUtil {
    @NotNull
    public static final Number getMovementSpeed(@NotNull AttributeSupplier.Builder $this$movementSpeed) {
        Intrinsics.checkNotNullParameter((Object)$this$movementSpeed, (String)"<this>");
        return 0;
    }

    public static final void setMovementSpeed(@NotNull AttributeSupplier.Builder $this$movementSpeed, @NotNull Number value) {
        Intrinsics.checkNotNullParameter((Object)$this$movementSpeed, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        AttributeSupplier.Builder $this$_set_movementSpeed__u24lambda_u240 = $this$movementSpeed;
        boolean bl = false;
        $this$_set_movementSpeed__u24lambda_u240.add(Attributes.MOVEMENT_SPEED, value.doubleValue());
    }

    @NotNull
    public static final Number getMaxHealth(@NotNull AttributeSupplier.Builder $this$maxHealth) {
        Intrinsics.checkNotNullParameter((Object)$this$maxHealth, (String)"<this>");
        return 0;
    }

    public static final void setMaxHealth(@NotNull AttributeSupplier.Builder $this$maxHealth, @NotNull Number value) {
        Intrinsics.checkNotNullParameter((Object)$this$maxHealth, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        AttributeSupplier.Builder $this$_set_maxHealth__u24lambda_u240 = $this$maxHealth;
        boolean bl = false;
        $this$_set_maxHealth__u24lambda_u240.add(Attributes.MAX_HEALTH, value.doubleValue());
    }

    @NotNull
    public static final Number getArmor(@NotNull AttributeSupplier.Builder $this$armor) {
        Intrinsics.checkNotNullParameter((Object)$this$armor, (String)"<this>");
        return 0;
    }

    public static final void setArmor(@NotNull AttributeSupplier.Builder $this$armor, @NotNull Number value) {
        Intrinsics.checkNotNullParameter((Object)$this$armor, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        AttributeSupplier.Builder $this$_set_armor__u24lambda_u240 = $this$armor;
        boolean bl = false;
        $this$_set_armor__u24lambda_u240.add(Attributes.ARMOR, value.doubleValue());
    }

    @NotNull
    public static final Number getAttackDamage(@NotNull AttributeSupplier.Builder $this$attackDamage) {
        Intrinsics.checkNotNullParameter((Object)$this$attackDamage, (String)"<this>");
        return 0;
    }

    public static final void setAttackDamage(@NotNull AttributeSupplier.Builder $this$attackDamage, @NotNull Number value) {
        Intrinsics.checkNotNullParameter((Object)$this$attackDamage, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        AttributeSupplier.Builder $this$_set_attackDamage__u24lambda_u240 = $this$attackDamage;
        boolean bl = false;
        $this$_set_attackDamage__u24lambda_u240.add(Attributes.ATTACK_DAMAGE, value.doubleValue());
    }

    @NotNull
    public static final Number getFollowRange(@NotNull AttributeSupplier.Builder $this$followRange) {
        Intrinsics.checkNotNullParameter((Object)$this$followRange, (String)"<this>");
        return 0;
    }

    public static final void setFollowRange(@NotNull AttributeSupplier.Builder $this$followRange, @NotNull Number value) {
        Intrinsics.checkNotNullParameter((Object)$this$followRange, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        AttributeSupplier.Builder $this$_set_followRange__u24lambda_u240 = $this$followRange;
        boolean bl = false;
        $this$_set_followRange__u24lambda_u240.add(Attributes.FOLLOW_RANGE, value.doubleValue());
    }

    @NotNull
    public static final Number getFlyingSpeed(@NotNull AttributeSupplier.Builder $this$flyingSpeed) {
        Intrinsics.checkNotNullParameter((Object)$this$flyingSpeed, (String)"<this>");
        return 0;
    }

    public static final void setFlyingSpeed(@NotNull AttributeSupplier.Builder $this$flyingSpeed, @NotNull Number value) {
        Intrinsics.checkNotNullParameter((Object)$this$flyingSpeed, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        AttributeSupplier.Builder $this$_set_flyingSpeed__u24lambda_u240 = $this$flyingSpeed;
        boolean bl = false;
        $this$_set_flyingSpeed__u24lambda_u240.add(Attributes.FLYING_SPEED, value.doubleValue());
    }

    @NotNull
    public static final Number getStepHeight(@NotNull AttributeSupplier.Builder $this$stepHeight) {
        Intrinsics.checkNotNullParameter((Object)$this$stepHeight, (String)"<this>");
        return 0;
    }

    public static final void setStepHeight(@NotNull AttributeSupplier.Builder $this$stepHeight, @NotNull Number value) {
        Intrinsics.checkNotNullParameter((Object)$this$stepHeight, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        AttributeSupplier.Builder $this$_set_stepHeight__u24lambda_u240 = $this$stepHeight;
        boolean bl = false;
        $this$_set_stepHeight__u24lambda_u240.add(Attributes.STEP_HEIGHT, value.doubleValue());
    }

    @NotNull
    public static final Number getKnockbackResistance(@NotNull AttributeSupplier.Builder $this$knockbackResistance) {
        Intrinsics.checkNotNullParameter((Object)$this$knockbackResistance, (String)"<this>");
        return 0;
    }

    public static final void setKnockbackResistance(@NotNull AttributeSupplier.Builder $this$knockbackResistance, @NotNull Number value) {
        Intrinsics.checkNotNullParameter((Object)$this$knockbackResistance, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        AttributeSupplier.Builder $this$_set_knockbackResistance__u24lambda_u240 = $this$knockbackResistance;
        boolean bl = false;
        $this$_set_knockbackResistance__u24lambda_u240.add(Attributes.KNOCKBACK_RESISTANCE, value.doubleValue());
    }

    @NotNull
    public static final Number getAttackKnockback(@NotNull AttributeSupplier.Builder $this$attackKnockback) {
        Intrinsics.checkNotNullParameter((Object)$this$attackKnockback, (String)"<this>");
        return 0;
    }

    public static final void setAttackKnockback(@NotNull AttributeSupplier.Builder $this$attackKnockback, @NotNull Number value) {
        Intrinsics.checkNotNullParameter((Object)$this$attackKnockback, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        AttributeSupplier.Builder $this$_set_attackKnockback__u24lambda_u240 = $this$attackKnockback;
        boolean bl = false;
        $this$_set_attackKnockback__u24lambda_u240.add(Attributes.ATTACK_KNOCKBACK, value.doubleValue());
    }

    @NotNull
    public static final Number getGravity(@NotNull AttributeSupplier.Builder $this$gravity) {
        Intrinsics.checkNotNullParameter((Object)$this$gravity, (String)"<this>");
        return 0;
    }

    public static final void setGravity(@NotNull AttributeSupplier.Builder $this$gravity, @NotNull Number value) {
        Intrinsics.checkNotNullParameter((Object)$this$gravity, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        AttributeSupplier.Builder $this$_set_gravity__u24lambda_u240 = $this$gravity;
        boolean bl = false;
        $this$_set_gravity__u24lambda_u240.add(Attributes.GRAVITY, value.doubleValue());
    }
}

