/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.damagesource.DamageEffects
 *  net.minecraft.world.damagesource.DamageScaling
 *  net.minecraft.world.damagesource.DamageType
 *  net.thebrokenscript.brokencore.api.registry.builders.DamageTypeBuilder
 *  net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;
import net.thebrokenscript.brokencore.api.registry.builders.DamageTypeBuilder;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSReg;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0017"}, d2={"Lnet/thebrokenscript/registry/TBSDamageTypes;", "", "<init>", "()V", "BAD_SUN", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "Lnet/minecraft/world/damagesource/DamageType;", "BITE", "FEVER_ATTACK", "CIRCUIT_ATTACK", "CHORD_LAZER", "INTEGRITY_BALL", "NULL_MAZE", "ROCK", "JIMMY_RISE", "SA1", "JIMMY_STOMP", "VOID_MASS", "INTEGRITY_SHIELD_BYPASS", "HAND_CANNON_DAMAGE", "SUB_ANOM_2", "getSUB_ANOM_2", "()Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "thebrokenscript-common"})
public final class TBSDamageTypes {
    @NotNull
    public static final TBSDamageTypes INSTANCE = new TBSDamageTypes();
    @JvmField
    @NotNull
    public static final RegistryEntry<DamageType, DamageType> BAD_SUN = TBSReg.INSTANCE.damageType("bad_sun", TBSDamageTypes::BAD_SUN$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<DamageType, DamageType> BITE = TBSReg.INSTANCE.damageType("bite", TBSDamageTypes::BITE$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<DamageType, DamageType> FEVER_ATTACK = TBSReg.INSTANCE.damageType("fever_attack", TBSDamageTypes::FEVER_ATTACK$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<DamageType, DamageType> CIRCUIT_ATTACK = TBSReg.INSTANCE.damageType("circuit_attack", TBSDamageTypes::CIRCUIT_ATTACK$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<DamageType, DamageType> CHORD_LAZER = TBSReg.INSTANCE.damageType("chord_lazer", TBSDamageTypes::CHORD_LAZER$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<DamageType, DamageType> INTEGRITY_BALL = TBSReg.INSTANCE.damageType("integrity_ball", TBSDamageTypes::INTEGRITY_BALL$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<DamageType, DamageType> NULL_MAZE = TBSReg.INSTANCE.damageType("null_maze", TBSDamageTypes::NULL_MAZE$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<DamageType, DamageType> ROCK = TBSReg.INSTANCE.damageType("rock", TBSDamageTypes::ROCK$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<DamageType, DamageType> JIMMY_RISE = TBSReg.INSTANCE.damageType("jimmy_rise", TBSDamageTypes::JIMMY_RISE$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<DamageType, DamageType> SA1 = TBSReg.INSTANCE.damageType("sa1", TBSDamageTypes::SA1$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<DamageType, DamageType> JIMMY_STOMP = TBSReg.INSTANCE.damageType("jimmy_stomp", TBSDamageTypes::JIMMY_STOMP$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<DamageType, DamageType> VOID_MASS = TBSReg.INSTANCE.damageType("void_mass", TBSDamageTypes::VOID_MASS$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<DamageType, DamageType> INTEGRITY_SHIELD_BYPASS = TBSReg.INSTANCE.damageType("integ_bypass", TBSDamageTypes::INTEGRITY_SHIELD_BYPASS$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<DamageType, DamageType> HAND_CANNON_DAMAGE = TBSReg.INSTANCE.damageType("hand_cannon_damage", TBSDamageTypes::HAND_CANNON_DAMAGE$lambda$0);
    @NotNull
    private static final RegistryEntry<DamageType, DamageType> SUB_ANOM_2 = TBSReg.INSTANCE.damageType("sub_anom_2", TBSDamageTypes::SUB_ANOM_2$lambda$0);

    private TBSDamageTypes() {
    }

    @NotNull
    public final RegistryEntry<DamageType, DamageType> getSUB_ANOM_2() {
        return SUB_ANOM_2;
    }

    private static final void BAD_SUN$lambda$0(DamageTypeBuilder $this$damageType) {
        Intrinsics.checkNotNullParameter((Object)$this$damageType, (String)"$this$damageType");
        $this$damageType.setScaling(DamageScaling.NEVER);
        $this$damageType.setExhaustion(0.0f);
        $this$damageType.setEffect(DamageEffects.BURNING);
        $this$damageType.setNoKnockback(true);
        $this$damageType.setBypassesTotem(true);
    }

    private static final void BITE$lambda$0(DamageTypeBuilder $this$damageType) {
        Intrinsics.checkNotNullParameter((Object)$this$damageType, (String)"$this$damageType");
        $this$damageType.setDeathMessage("%1$s lost their legs.");
        $this$damageType.setDeathByPlayerMessage("%1$s lost the lower half of their body whilst fighting %2$s");
        $this$damageType.setNoKnockback(true);
        $this$damageType.setBypassesTotem(true);
    }

    private static final void FEVER_ATTACK$lambda$0(DamageTypeBuilder $this$damageType) {
        Intrinsics.checkNotNullParameter((Object)$this$damageType, (String)"$this$damageType");
        $this$damageType.setDeathMessage("%1$s never saw it coming.");
        $this$damageType.setDeathByPlayerMessage("%1$s didn't look behind them while fighting %2$s");
        $this$damageType.setBypassesArmor(true);
        $this$damageType.setBypassesEffects(true);
        $this$damageType.setBypassesInvulnerability(true);
        $this$damageType.setBypassesTotem(true);
    }

    private static final void CIRCUIT_ATTACK$lambda$0(DamageTypeBuilder $this$damageType) {
        Intrinsics.checkNotNullParameter((Object)$this$damageType, (String)"$this$damageType");
        $this$damageType.setDeathMessage("%1$s couldn't hide.");
        $this$damageType.setDeathByPlayerMessage("%1$s got killed while fighting %2$s");
        $this$damageType.setBypassesArmor(true);
        $this$damageType.setBypassesEffects(true);
        $this$damageType.setBypassesInvulnerability(true);
        $this$damageType.setBypassesTotem(true);
    }

    private static final void CHORD_LAZER$lambda$0(DamageTypeBuilder $this$damageType) {
        Intrinsics.checkNotNullParameter((Object)$this$damageType, (String)"$this$damageType");
        $this$damageType.setDeathMessage("%1$s's voice joined the chorus.");
        $this$damageType.setDeathByPlayerMessage("%1$s was tranced by the symphony while fighting %2$s");
        $this$damageType.setNoKnockback(true);
    }

    private static final void INTEGRITY_BALL$lambda$0(DamageTypeBuilder $this$damageType) {
        Intrinsics.checkNotNullParameter((Object)$this$damageType, (String)"$this$damageType");
        $this$damageType.setDeathMessage("%1$s was amalgamated.");
        $this$damageType.setDeathByPlayerMessage("%1$s was amalgamated while fighting %2$s");
        $this$damageType.setBypassesArmor(true);
        $this$damageType.setBypassesEffects(true);
        $this$damageType.setBypassesInvulnerability(true);
        $this$damageType.setBypassesTotem(true);
    }

    private static final void NULL_MAZE$lambda$0(DamageTypeBuilder $this$damageType) {
        Intrinsics.checkNotNullParameter((Object)$this$damageType, (String)"$this$damageType");
        $this$damageType.setDeathMessage("%1$s was found.");
        $this$damageType.setDeathByPlayerMessage("%1$s was found while fighting %2$s");
        $this$damageType.setBypassesArmor(true);
        $this$damageType.setBypassesEffects(true);
        $this$damageType.setBypassesTotem(true);
    }

    private static final void ROCK$lambda$0(DamageTypeBuilder $this$damageType) {
        Intrinsics.checkNotNullParameter((Object)$this$damageType, (String)"$this$damageType");
        $this$damageType.setDeathMessage("%1$s got crushed.");
        $this$damageType.setDeathByPlayerMessage("%1$s got crushed while fighting %2$s");
    }

    private static final void JIMMY_RISE$lambda$0(DamageTypeBuilder $this$damageType) {
        Intrinsics.checkNotNullParameter((Object)$this$damageType, (String)"$this$damageType");
        $this$damageType.setDeathMessage("%1$s didn't feel the tremors.");
        $this$damageType.setDeathByPlayerMessage("%1$s didn't feel the tremors while fighting %2$s");
        $this$damageType.setBypassesArmor(true);
        $this$damageType.setBypassesEffects(true);
        $this$damageType.setBypassesTotem(true);
        $this$damageType.setNoKnockback(true);
    }

    private static final void SA1$lambda$0(DamageTypeBuilder $this$damageType) {
        Intrinsics.checkNotNullParameter((Object)$this$damageType, (String)"$this$damageType");
        $this$damageType.setDeathMessage("%1$s was disassembled.");
        $this$damageType.setDeathByPlayerMessage("%1$s was disassembled while fighting %2$s");
        $this$damageType.setNoKnockback(true);
        $this$damageType.setBypassesArmor(true);
        $this$damageType.setBypassesEffects(true);
        $this$damageType.setBypassesTotem(true);
    }

    private static final void JIMMY_STOMP$lambda$0(DamageTypeBuilder $this$damageType) {
        Intrinsics.checkNotNullParameter((Object)$this$damageType, (String)"$this$damageType");
        $this$damageType.setDeathMessage("%1$s was flattened.");
        $this$damageType.setDeathByPlayerMessage("%1$s was flattened while fighting %2$s");
        $this$damageType.setBypassesArmor(true);
        $this$damageType.setBypassesEffects(true);
        $this$damageType.setBypassesTotem(true);
    }

    private static final void VOID_MASS$lambda$0(DamageTypeBuilder $this$damageType) {
        Intrinsics.checkNotNullParameter((Object)$this$damageType, (String)"$this$damageType");
        $this$damageType.setDeathMessage("%1$s is no more.");
        $this$damageType.setDeathByPlayerMessage("%1$s became no more while fighting %2$s");
        $this$damageType.setBypassesArmor(true);
        $this$damageType.setBypassesEffects(true);
        $this$damageType.setBypassesTotem(true);
        $this$damageType.setBypassesInvulnerability(true);
        $this$damageType.setBypassesShield(true);
    }

    private static final void INTEGRITY_SHIELD_BYPASS$lambda$0(DamageTypeBuilder $this$damageType) {
        Intrinsics.checkNotNullParameter((Object)$this$damageType, (String)"$this$damageType");
        $this$damageType.setDeathMessage("%1$s has been killed");
        $this$damageType.setDeathByPlayerMessage("%1$s has been killed while fighting %2$s");
        $this$damageType.setBypassesArmor(true);
        $this$damageType.setBypassesEffects(true);
        $this$damageType.setBypassesTotem(true);
        $this$damageType.setBypassesInvulnerability(false);
        $this$damageType.setBypassesShield(true);
    }

    private static final void HAND_CANNON_DAMAGE$lambda$0(DamageTypeBuilder $this$damageType) {
        Intrinsics.checkNotNullParameter((Object)$this$damageType, (String)"$this$damageType");
        $this$damageType.setDeathMessage("%1$s was made whole");
        $this$damageType.setBypassesArmor(true);
        $this$damageType.setBypassesEffects(true);
        $this$damageType.setBypassesTotem(false);
        $this$damageType.setBypassesInvulnerability(true);
        $this$damageType.setBypassesShield(true);
    }

    private static final void SUB_ANOM_2$lambda$0(DamageTypeBuilder $this$damageType) {
        Intrinsics.checkNotNullParameter((Object)$this$damageType, (String)"$this$damageType");
        $this$damageType.setDeathMessage("%1$s has been killed");
        $this$damageType.setDeathByPlayerMessage("%1$s has been killed while fighting %2$s");
        $this$damageType.setBypassesTotem(true);
    }
}

