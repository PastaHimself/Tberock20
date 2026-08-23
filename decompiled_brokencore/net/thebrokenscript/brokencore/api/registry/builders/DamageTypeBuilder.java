/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonObject
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.Holder
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.data.PackOutput
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.damagesource.DamageEffects
 *  net.minecraft.world.damagesource.DamageScaling
 *  net.minecraft.world.damagesource.DamageType
 *  net.minecraft.world.damagesource.DeathMessageType
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.registry.builders;

import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DeathMessageType;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.builders.SimpleBuilder;
import net.thebrokenscript.brokencore.api.registry.dsl.RegistryDslMarker;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.brokencore.api.registry.util.BuiltInTagBuilder;
import net.thebrokenscript.brokencore.api.registry.util.VanillaTagBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RegistryDslMarker
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\bX\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0087\u0001\u001a\u00020\u0002H\u0014J\n\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0004J\u0016\u0010\u008a\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u008b\u0001H\u0016J3\u0010\u008c\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u008b\u00012\u001b\u0010\u008d\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0012\u0005\u0012\u00030\u008f\u00010\u008e\u0001\u00a2\u0006\u0003\b\u0090\u0001H\u0016J&\u0010\u0091\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u008b\u00012\u000e\u0010\u0092\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u0093\u0001H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00102\"\u0004\b7\u00104R\u001a\u00108\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u00102\"\u0004\b:\u00104R\u001a\u0010;\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u00102\"\u0004\b=\u00104R\u001a\u0010>\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u00102\"\u0004\b@\u00104R\u001a\u0010A\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u00102\"\u0004\bC\u00104R\u001a\u0010D\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u00102\"\u0004\bF\u00104R\u001a\u0010G\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u00102\"\u0004\bI\u00104R\u001a\u0010J\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u00102\"\u0004\bL\u00104R\u001a\u0010M\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u00102\"\u0004\bO\u00104R\u001a\u0010P\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u00102\"\u0004\bR\u00104R\u001a\u0010S\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u00102\"\u0004\bU\u00104R\u001a\u0010V\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bW\u00102\"\u0004\bX\u00104R\u001a\u0010Y\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bZ\u00102\"\u0004\b[\u00104R\u001a\u0010\\\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b]\u00102\"\u0004\b^\u00104R\u001a\u0010_\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b`\u00102\"\u0004\ba\u00104R\u001a\u0010b\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bc\u00102\"\u0004\bd\u00104R\u001a\u0010e\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\be\u00102\"\u0004\bf\u00104R\u001a\u0010g\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bg\u00102\"\u0004\bh\u00104R\u001a\u0010i\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bi\u00102\"\u0004\bj\u00104R\u001a\u0010k\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bk\u00102\"\u0004\bl\u00104R\u001a\u0010m\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bm\u00102\"\u0004\bn\u00104R\u001a\u0010o\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bo\u00102\"\u0004\bp\u00104R\u001a\u0010q\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bq\u00102\"\u0004\br\u00104R\u001a\u0010s\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bs\u00102\"\u0004\bt\u00104R\u001a\u0010u\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bv\u00102\"\u0004\bw\u00104R\u001a\u0010x\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\by\u00102\"\u0004\bz\u00104R\u001a\u0010{\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b|\u00102\"\u0004\b}\u00104R\u001b\u0010~\u001a\u000200X\u0086\u000e\u00a2\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u00102\"\u0005\b\u0080\u0001\u00104R\u001d\u0010\u0081\u0001\u001a\u000200X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u00102\"\u0005\b\u0083\u0001\u00104R\u001d\u0010\u0084\u0001\u001a\u000200X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u00102\"\u0005\b\u0086\u0001\u00104\u00a8\u0006\u0094\u0001"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/DamageTypeBuilder;", "Lnet/thebrokenscript/brokencore/api/registry/builders/SimpleBuilder;", "Lnet/minecraft/world/damagesource/DamageType;", "owner", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "name", "", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Ljava/lang/String;)V", "deathMessage", "getDeathMessage", "()Ljava/lang/String;", "setDeathMessage", "(Ljava/lang/String;)V", "deathByPlayerMessage", "getDeathByPlayerMessage", "setDeathByPlayerMessage", "deathByMobMessage", "getDeathByMobMessage", "setDeathByMobMessage", "deathByItemMessage", "getDeathByItemMessage", "setDeathByItemMessage", "deathMessageType", "Lnet/minecraft/world/damagesource/DeathMessageType;", "getDeathMessageType", "()Lnet/minecraft/world/damagesource/DeathMessageType;", "setDeathMessageType", "(Lnet/minecraft/world/damagesource/DeathMessageType;)V", "scaling", "Lnet/minecraft/world/damagesource/DamageScaling;", "getScaling", "()Lnet/minecraft/world/damagesource/DamageScaling;", "setScaling", "(Lnet/minecraft/world/damagesource/DamageScaling;)V", "effect", "Lnet/minecraft/world/damagesource/DamageEffects;", "getEffect", "()Lnet/minecraft/world/damagesource/DamageEffects;", "setEffect", "(Lnet/minecraft/world/damagesource/DamageEffects;)V", "exhaustion", "", "getExhaustion", "()F", "setExhaustion", "(F)V", "alwaysHurtsEnderDragons", "", "getAlwaysHurtsEnderDragons", "()Z", "setAlwaysHurtsEnderDragons", "(Z)V", "instakillsArmorStands", "getInstakillsArmorStands", "setInstakillsArmorStands", "prioritizeDeathMessage", "getPrioritizeDeathMessage", "setPrioritizeDeathMessage", "alwaysTriggersSilverfish", "getAlwaysTriggersSilverfish", "setAlwaysTriggersSilverfish", "avoidsGuardiansThorns", "getAvoidsGuardiansThorns", "setAvoidsGuardiansThorns", "burnsArmorStands", "getBurnsArmorStands", "setBurnsArmorStands", "ignoredByFrostWalker", "getIgnoredByFrostWalker", "setIgnoredByFrostWalker", "bypassesArmor", "getBypassesArmor", "setBypassesArmor", "bypassesEffects", "getBypassesEffects", "setBypassesEffects", "bypassesEnchantments", "getBypassesEnchantments", "setBypassesEnchantments", "bypassesInvulnerability", "getBypassesInvulnerability", "setBypassesInvulnerability", "bypassesResistance", "getBypassesResistance", "setBypassesResistance", "bypassesShield", "getBypassesShield", "setBypassesShield", "bypassesWolfArmor", "getBypassesWolfArmor", "setBypassesWolfArmor", "canBreakArmorStand", "getCanBreakArmorStand", "setCanBreakArmorStand", "damagesHelmet", "getDamagesHelmet", "setDamagesHelmet", "ignitesArmorStands", "getIgnitesArmorStands", "setIgnitesArmorStands", "isDrowning", "setDrowning", "isExplosion", "setExplosion", "isFall", "setFall", "isFire", "setFire", "isFreezing", "setFreezing", "isLightning", "setLightning", "isPlayerAttack", "setPlayerAttack", "isProjectile", "setProjectile", "noAnger", "getNoAnger", "setNoAnger", "noImpact", "getNoImpact", "setNoImpact", "noKnockback", "getNoKnockback", "setNoKnockback", "witchResistantTo", "getWitchResistantTo", "setWitchResistantTo", "witherImmuneTo", "getWitherImmuneTo", "setWitherImmuneTo", "bypassesTotem", "getBypassesTotem", "setBypassesTotem", "createObject", "createJson", "Lcom/google/gson/JsonObject;", "register", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "configure", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "createEntry", "key", "Lnet/minecraft/resources/ResourceKey;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nDamageTypeBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DamageTypeBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/DamageTypeBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,124:1\n1#2:125\n*E\n"})
public class DamageTypeBuilder
extends SimpleBuilder<DamageTypeBuilder, DamageType> {
    @NotNull
    private final BrokenReg owner;
    @Nullable
    private String deathMessage;
    @Nullable
    private String deathByPlayerMessage;
    @Nullable
    private String deathByMobMessage;
    @Nullable
    private String deathByItemMessage;
    @NotNull
    private DeathMessageType deathMessageType;
    @NotNull
    private DamageScaling scaling;
    @NotNull
    private DamageEffects effect;
    private float exhaustion;
    private boolean alwaysHurtsEnderDragons;
    private boolean instakillsArmorStands;
    private boolean prioritizeDeathMessage;
    private boolean alwaysTriggersSilverfish;
    private boolean avoidsGuardiansThorns;
    private boolean burnsArmorStands;
    private boolean ignoredByFrostWalker;
    private boolean bypassesArmor;
    private boolean bypassesEffects;
    private boolean bypassesEnchantments;
    private boolean bypassesInvulnerability;
    private boolean bypassesResistance;
    private boolean bypassesShield;
    private boolean bypassesWolfArmor;
    private boolean canBreakArmorStand;
    private boolean damagesHelmet;
    private boolean ignitesArmorStands;
    private boolean isDrowning;
    private boolean isExplosion;
    private boolean isFall;
    private boolean isFire;
    private boolean isFreezing;
    private boolean isLightning;
    private boolean isPlayerAttack;
    private boolean isProjectile;
    private boolean noAnger;
    private boolean noImpact;
    private boolean noKnockback;
    private boolean witchResistantTo;
    private boolean witherImmuneTo;
    private boolean bypassesTotem;

    public DamageTypeBuilder(@NotNull BrokenReg owner, @NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)owner, (String)"owner");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        ResourceKey resourceKey = Registries.DAMAGE_TYPE;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"DAMAGE_TYPE");
        super(owner, resourceKey, name);
        this.owner = owner;
        this.deathMessageType = DeathMessageType.DEFAULT;
        this.scaling = DamageScaling.ALWAYS;
        this.effect = DamageEffects.HURT;
        this.exhaustion = 0.1f;
    }

    @Nullable
    public final String getDeathMessage() {
        return this.deathMessage;
    }

    public final void setDeathMessage(@Nullable String string) {
        this.deathMessage = string;
    }

    @Nullable
    public final String getDeathByPlayerMessage() {
        return this.deathByPlayerMessage;
    }

    public final void setDeathByPlayerMessage(@Nullable String string) {
        this.deathByPlayerMessage = string;
    }

    @Nullable
    public final String getDeathByMobMessage() {
        return this.deathByMobMessage;
    }

    public final void setDeathByMobMessage(@Nullable String string) {
        this.deathByMobMessage = string;
    }

    @Nullable
    public final String getDeathByItemMessage() {
        return this.deathByItemMessage;
    }

    public final void setDeathByItemMessage(@Nullable String string) {
        this.deathByItemMessage = string;
    }

    @NotNull
    public final DeathMessageType getDeathMessageType() {
        return this.deathMessageType;
    }

    public final void setDeathMessageType(@NotNull DeathMessageType deathMessageType) {
        Intrinsics.checkNotNullParameter((Object)deathMessageType, (String)"<set-?>");
        this.deathMessageType = deathMessageType;
    }

    @NotNull
    public final DamageScaling getScaling() {
        return this.scaling;
    }

    public final void setScaling(@NotNull DamageScaling damageScaling) {
        Intrinsics.checkNotNullParameter((Object)damageScaling, (String)"<set-?>");
        this.scaling = damageScaling;
    }

    @NotNull
    public final DamageEffects getEffect() {
        return this.effect;
    }

    public final void setEffect(@NotNull DamageEffects damageEffects) {
        Intrinsics.checkNotNullParameter((Object)damageEffects, (String)"<set-?>");
        this.effect = damageEffects;
    }

    public final float getExhaustion() {
        return this.exhaustion;
    }

    public final void setExhaustion(float f) {
        this.exhaustion = f;
    }

    public final boolean getAlwaysHurtsEnderDragons() {
        return this.alwaysHurtsEnderDragons;
    }

    public final void setAlwaysHurtsEnderDragons(boolean bl) {
        this.alwaysHurtsEnderDragons = bl;
    }

    public final boolean getInstakillsArmorStands() {
        return this.instakillsArmorStands;
    }

    public final void setInstakillsArmorStands(boolean bl) {
        this.instakillsArmorStands = bl;
    }

    public final boolean getPrioritizeDeathMessage() {
        return this.prioritizeDeathMessage;
    }

    public final void setPrioritizeDeathMessage(boolean bl) {
        this.prioritizeDeathMessage = bl;
    }

    public final boolean getAlwaysTriggersSilverfish() {
        return this.alwaysTriggersSilverfish;
    }

    public final void setAlwaysTriggersSilverfish(boolean bl) {
        this.alwaysTriggersSilverfish = bl;
    }

    public final boolean getAvoidsGuardiansThorns() {
        return this.avoidsGuardiansThorns;
    }

    public final void setAvoidsGuardiansThorns(boolean bl) {
        this.avoidsGuardiansThorns = bl;
    }

    public final boolean getBurnsArmorStands() {
        return this.burnsArmorStands;
    }

    public final void setBurnsArmorStands(boolean bl) {
        this.burnsArmorStands = bl;
    }

    public final boolean getIgnoredByFrostWalker() {
        return this.ignoredByFrostWalker;
    }

    public final void setIgnoredByFrostWalker(boolean bl) {
        this.ignoredByFrostWalker = bl;
    }

    public final boolean getBypassesArmor() {
        return this.bypassesArmor;
    }

    public final void setBypassesArmor(boolean bl) {
        this.bypassesArmor = bl;
    }

    public final boolean getBypassesEffects() {
        return this.bypassesEffects;
    }

    public final void setBypassesEffects(boolean bl) {
        this.bypassesEffects = bl;
    }

    public final boolean getBypassesEnchantments() {
        return this.bypassesEnchantments;
    }

    public final void setBypassesEnchantments(boolean bl) {
        this.bypassesEnchantments = bl;
    }

    public final boolean getBypassesInvulnerability() {
        return this.bypassesInvulnerability;
    }

    public final void setBypassesInvulnerability(boolean bl) {
        this.bypassesInvulnerability = bl;
    }

    public final boolean getBypassesResistance() {
        return this.bypassesResistance;
    }

    public final void setBypassesResistance(boolean bl) {
        this.bypassesResistance = bl;
    }

    public final boolean getBypassesShield() {
        return this.bypassesShield;
    }

    public final void setBypassesShield(boolean bl) {
        this.bypassesShield = bl;
    }

    public final boolean getBypassesWolfArmor() {
        return this.bypassesWolfArmor;
    }

    public final void setBypassesWolfArmor(boolean bl) {
        this.bypassesWolfArmor = bl;
    }

    public final boolean getCanBreakArmorStand() {
        return this.canBreakArmorStand;
    }

    public final void setCanBreakArmorStand(boolean bl) {
        this.canBreakArmorStand = bl;
    }

    public final boolean getDamagesHelmet() {
        return this.damagesHelmet;
    }

    public final void setDamagesHelmet(boolean bl) {
        this.damagesHelmet = bl;
    }

    public final boolean getIgnitesArmorStands() {
        return this.ignitesArmorStands;
    }

    public final void setIgnitesArmorStands(boolean bl) {
        this.ignitesArmorStands = bl;
    }

    public final boolean isDrowning() {
        return this.isDrowning;
    }

    public final void setDrowning(boolean bl) {
        this.isDrowning = bl;
    }

    public final boolean isExplosion() {
        return this.isExplosion;
    }

    public final void setExplosion(boolean bl) {
        this.isExplosion = bl;
    }

    public final boolean isFall() {
        return this.isFall;
    }

    public final void setFall(boolean bl) {
        this.isFall = bl;
    }

    public final boolean isFire() {
        return this.isFire;
    }

    public final void setFire(boolean bl) {
        this.isFire = bl;
    }

    public final boolean isFreezing() {
        return this.isFreezing;
    }

    public final void setFreezing(boolean bl) {
        this.isFreezing = bl;
    }

    public final boolean isLightning() {
        return this.isLightning;
    }

    public final void setLightning(boolean bl) {
        this.isLightning = bl;
    }

    public final boolean isPlayerAttack() {
        return this.isPlayerAttack;
    }

    public final void setPlayerAttack(boolean bl) {
        this.isPlayerAttack = bl;
    }

    public final boolean isProjectile() {
        return this.isProjectile;
    }

    public final void setProjectile(boolean bl) {
        this.isProjectile = bl;
    }

    public final boolean getNoAnger() {
        return this.noAnger;
    }

    public final void setNoAnger(boolean bl) {
        this.noAnger = bl;
    }

    public final boolean getNoImpact() {
        return this.noImpact;
    }

    public final void setNoImpact(boolean bl) {
        this.noImpact = bl;
    }

    public final boolean getNoKnockback() {
        return this.noKnockback;
    }

    public final void setNoKnockback(boolean bl) {
        this.noKnockback = bl;
    }

    public final boolean getWitchResistantTo() {
        return this.witchResistantTo;
    }

    public final void setWitchResistantTo(boolean bl) {
        this.witchResistantTo = bl;
    }

    public final boolean getWitherImmuneTo() {
        return this.witherImmuneTo;
    }

    public final void setWitherImmuneTo(boolean bl) {
        this.witherImmuneTo = bl;
    }

    public final boolean getBypassesTotem() {
        return this.bypassesTotem;
    }

    public final void setBypassesTotem(boolean bl) {
        this.bypassesTotem = bl;
    }

    @Override
    @NotNull
    protected DamageType createObject() {
        return new DamageType(this.getName(), this.scaling, this.exhaustion, this.effect, this.deathMessageType);
    }

    @NotNull
    protected final JsonObject createJson() {
        JsonObject jsonObject;
        JsonObject $this$createJson_u24lambda_u240 = jsonObject = new JsonObject();
        boolean bl = false;
        $this$createJson_u24lambda_u240.addProperty("message_id", this.getId().getNamespace() + "." + this.getName());
        $this$createJson_u24lambda_u240.addProperty("exhaustion", (Number)Float.valueOf(this.exhaustion));
        $this$createJson_u24lambda_u240.addProperty("scaling", this.scaling.getSerializedName());
        $this$createJson_u24lambda_u240.addProperty("effects", this.effect.getSerializedName());
        $this$createJson_u24lambda_u240.addProperty("death_message_type", this.deathMessageType.getSerializedName());
        return jsonObject;
    }

    @Override
    @NotNull
    public RegistryEntry<DamageType, DamageType> register() {
        String it;
        Object e;
        Object it2 = e = super.register();
        boolean bl = false;
        String baseId = "death.attack." + this.getId().getNamespace() + "." + this.getName();
        String string = this.deathMessage;
        if (string != null) {
            it = string;
            boolean bl2 = false;
            this.getParent().getData().getLang().set(baseId, it);
        }
        String string2 = this.deathByMobMessage;
        if (string2 != null) {
            it = string2;
            boolean bl3 = false;
            this.getParent().getData().getLang().set(baseId + ".mob", it);
        }
        String string3 = this.deathByPlayerMessage;
        if (string3 != null) {
            it = string3;
            boolean bl4 = false;
            this.getParent().getData().getLang().set(baseId + ".player", it);
        }
        String string4 = this.deathByItemMessage;
        if (string4 != null) {
            it = string4;
            boolean bl5 = false;
            this.getParent().getData().getLang().set(baseId + ".item", it);
        }
        this.getParent().getData().getDamageTypes().register((Function1<? super PackOutput, Unit>)((Function1)arg_0 -> DamageTypeBuilder.register$lambda$0$4(this, arg_0)));
        return e;
    }

    @Override
    @NotNull
    public RegistryEntry<DamageType, DamageType> configure(@NotNull Function1<? super DamageTypeBuilder, Unit> block2) {
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        Object type = super.configure(block2);
        ResourceKey t = Registries.DAMAGE_TYPE;
        if (this.alwaysHurtsEnderDragons) {
            Intrinsics.checkNotNull((Object)t);
            this.owner.vanillaTag(t, "always_hurts_ender_dragons", arg_0 -> DamageTypeBuilder.configure$lambda$0(type, arg_0));
        }
        if (this.instakillsArmorStands) {
            Intrinsics.checkNotNull((Object)t);
            this.owner.vanillaTag(t, "always_kills_armor_stands", arg_0 -> DamageTypeBuilder.configure$lambda$1(type, arg_0));
        }
        if (this.prioritizeDeathMessage) {
            Intrinsics.checkNotNull((Object)t);
            this.owner.vanillaTag(t, "always_most_significant_fall", arg_0 -> DamageTypeBuilder.configure$lambda$2(type, arg_0));
        }
        if (this.alwaysTriggersSilverfish) {
            Intrinsics.checkNotNull((Object)t);
            this.owner.vanillaTag(t, "always_triggers_silverfish", arg_0 -> DamageTypeBuilder.configure$lambda$3(type, arg_0));
        }
        if (this.avoidsGuardiansThorns) {
            Intrinsics.checkNotNull((Object)t);
            this.owner.vanillaTag(t, "avoids_guardian_thorns", arg_0 -> DamageTypeBuilder.configure$lambda$4(type, arg_0));
        }
        if (this.ignoredByFrostWalker) {
            Intrinsics.checkNotNull((Object)t);
            this.owner.vanillaTag(t, "burn_from_stepping_on", arg_0 -> DamageTypeBuilder.configure$lambda$5(type, arg_0));
        }
        if (this.burnsArmorStands) {
            Intrinsics.checkNotNull((Object)t);
            this.owner.vanillaTag(t, "burns_armor_stands", arg_0 -> DamageTypeBuilder.configure$lambda$6(type, arg_0));
        }
        if (this.bypassesArmor) {
            Intrinsics.checkNotNull((Object)t);
            this.owner.vanillaTag(t, "bypasses_armor", arg_0 -> DamageTypeBuilder.configure$lambda$7(type, arg_0));
        }
        if (this.bypassesEffects) {
            Intrinsics.checkNotNull((Object)t);
            this.owner.vanillaTag(t, "bypasses_effects", arg_0 -> DamageTypeBuilder.configure$lambda$8(type, arg_0));
        }
        if (this.bypassesEnchantments) {
            Intrinsics.checkNotNull((Object)t);
            this.owner.vanillaTag(t, "bypasses_enchantments", arg_0 -> DamageTypeBuilder.configure$lambda$9(type, arg_0));
        }
        if (this.bypassesInvulnerability) {
            Intrinsics.checkNotNull((Object)t);
            this.owner.vanillaTag(t, "bypasses_invulnerability", arg_0 -> DamageTypeBuilder.configure$lambda$10(type, arg_0));
        }
        if (this.bypassesResistance) {
            Intrinsics.checkNotNull((Object)t);
            this.owner.vanillaTag(t, "bypasses_resistance", arg_0 -> DamageTypeBuilder.configure$lambda$11(type, arg_0));
        }
        if (this.bypassesShield) {
            Intrinsics.checkNotNull((Object)t);
            this.owner.vanillaTag(t, "bypasses_shield", arg_0 -> DamageTypeBuilder.configure$lambda$12(type, arg_0));
        }
        if (this.bypassesWolfArmor) {
            Intrinsics.checkNotNull((Object)t);
            this.owner.vanillaTag(t, "bypasses_wolf_armor", arg_0 -> DamageTypeBuilder.configure$lambda$13(type, arg_0));
        }
        if (this.canBreakArmorStand) {
            Intrinsics.checkNotNull((Object)t);
            this.owner.vanillaTag(t, "can_break_armor_stands", arg_0 -> DamageTypeBuilder.configure$lambda$14(type, arg_0));
        }
        if (this.damagesHelmet) {
            Intrinsics.checkNotNull((Object)t);
            this.owner.vanillaTag(t, "damages_helmet", arg_0 -> DamageTypeBuilder.configure$lambda$15(type, arg_0));
        }
        if (this.ignitesArmorStands) {
            Intrinsics.checkNotNull((Object)t);
            this.owner.vanillaTag(t, "ignites_armor_stands", arg_0 -> DamageTypeBuilder.configure$lambda$16(type, arg_0));
        }
        if (this.isDrowning) {
            Intrinsics.checkNotNull((Object)t);
            this.owner.vanillaTag(t, "is_drowning", arg_0 -> DamageTypeBuilder.configure$lambda$17(type, arg_0));
        }
        if (this.isExplosion) {
            Intrinsics.checkNotNull((Object)t);
            this.owner.vanillaTag(t, "is_explosion", arg_0 -> DamageTypeBuilder.configure$lambda$18(type, arg_0));
        }
        if (this.isFall) {
            Intrinsics.checkNotNull((Object)t);
            this.owner.vanillaTag(t, "is_fall", arg_0 -> DamageTypeBuilder.configure$lambda$19(type, arg_0));
        }
        if (this.isFire) {
            Intrinsics.checkNotNull((Object)t);
            this.owner.vanillaTag(t, "is_fire", arg_0 -> DamageTypeBuilder.configure$lambda$20(type, arg_0));
        }
        if (this.isFreezing) {
            Intrinsics.checkNotNull((Object)t);
            this.owner.vanillaTag(t, "is_freezing", arg_0 -> DamageTypeBuilder.configure$lambda$21(type, arg_0));
        }
        if (this.isLightning) {
            Intrinsics.checkNotNull((Object)t);
            this.owner.vanillaTag(t, "is_lightning", arg_0 -> DamageTypeBuilder.configure$lambda$22(type, arg_0));
        }
        if (this.isPlayerAttack) {
            Intrinsics.checkNotNull((Object)t);
            this.owner.vanillaTag(t, "is_player_attack", arg_0 -> DamageTypeBuilder.configure$lambda$23(type, arg_0));
        }
        if (this.isProjectile) {
            Intrinsics.checkNotNull((Object)t);
            this.owner.vanillaTag(t, "is_projectile", arg_0 -> DamageTypeBuilder.configure$lambda$24(type, arg_0));
        }
        if (this.noAnger) {
            Intrinsics.checkNotNull((Object)t);
            this.owner.vanillaTag(t, "no_anger", arg_0 -> DamageTypeBuilder.configure$lambda$25(type, arg_0));
        }
        if (this.noImpact) {
            Intrinsics.checkNotNull((Object)t);
            this.owner.vanillaTag(t, "no_impact", arg_0 -> DamageTypeBuilder.configure$lambda$26(type, arg_0));
        }
        if (this.noKnockback) {
            Intrinsics.checkNotNull((Object)t);
            this.owner.vanillaTag(t, "no_knockback", arg_0 -> DamageTypeBuilder.configure$lambda$27(type, arg_0));
        }
        if (this.witchResistantTo) {
            Intrinsics.checkNotNull((Object)t);
            this.owner.vanillaTag(t, "witch_resistant_to", arg_0 -> DamageTypeBuilder.configure$lambda$28(type, arg_0));
        }
        if (this.witherImmuneTo) {
            Intrinsics.checkNotNull((Object)t);
            this.owner.vanillaTag(t, "wither_immune_to", arg_0 -> DamageTypeBuilder.configure$lambda$29(type, arg_0));
        }
        if (this.bypassesTotem) {
            Intrinsics.checkNotNull((Object)t);
            this.owner.builtInTag(t, "bypasses_totem", arg_0 -> DamageTypeBuilder.configure$lambda$30(type, arg_0));
        }
        return type;
    }

    @Override
    @NotNull
    public RegistryEntry<DamageType, DamageType> createEntry(@NotNull ResourceKey<DamageType> key) {
        Intrinsics.checkNotNullParameter(key, (String)"key");
        return new RegistryEntry<DamageType, DamageType>(key);
    }

    private static final Unit register$lambda$0$4(DamageTypeBuilder this$0, PackOutput it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Pair[] pairArray = new Pair[]{TuplesKt.to((Object)("data/" + this$0.getId().getNamespace() + "/damage_type/" + this$0.getName() + ".json"), (Object)this$0.createJson())};
        this$0.getParent().getData().getDamageTypes().accept(pairArray);
        return Unit.INSTANCE;
    }

    private static final void configure$lambda$0(RegistryEntry $type, VanillaTagBuilder $this$vanillaTag) {
        Intrinsics.checkNotNullParameter((Object)$this$vanillaTag, (String)"$this$vanillaTag");
        Holder[] holderArray = new Holder[]{$type};
        $this$vanillaTag.add(holderArray);
    }

    private static final void configure$lambda$1(RegistryEntry $type, VanillaTagBuilder $this$vanillaTag) {
        Intrinsics.checkNotNullParameter((Object)$this$vanillaTag, (String)"$this$vanillaTag");
        Holder[] holderArray = new Holder[]{$type};
        $this$vanillaTag.add(holderArray);
    }

    private static final void configure$lambda$2(RegistryEntry $type, VanillaTagBuilder $this$vanillaTag) {
        Intrinsics.checkNotNullParameter((Object)$this$vanillaTag, (String)"$this$vanillaTag");
        Holder[] holderArray = new Holder[]{$type};
        $this$vanillaTag.add(holderArray);
    }

    private static final void configure$lambda$3(RegistryEntry $type, VanillaTagBuilder $this$vanillaTag) {
        Intrinsics.checkNotNullParameter((Object)$this$vanillaTag, (String)"$this$vanillaTag");
        Holder[] holderArray = new Holder[]{$type};
        $this$vanillaTag.add(holderArray);
    }

    private static final void configure$lambda$4(RegistryEntry $type, VanillaTagBuilder $this$vanillaTag) {
        Intrinsics.checkNotNullParameter((Object)$this$vanillaTag, (String)"$this$vanillaTag");
        Holder[] holderArray = new Holder[]{$type};
        $this$vanillaTag.add(holderArray);
    }

    private static final void configure$lambda$5(RegistryEntry $type, VanillaTagBuilder $this$vanillaTag) {
        Intrinsics.checkNotNullParameter((Object)$this$vanillaTag, (String)"$this$vanillaTag");
        Holder[] holderArray = new Holder[]{$type};
        $this$vanillaTag.add(holderArray);
    }

    private static final void configure$lambda$6(RegistryEntry $type, VanillaTagBuilder $this$vanillaTag) {
        Intrinsics.checkNotNullParameter((Object)$this$vanillaTag, (String)"$this$vanillaTag");
        Holder[] holderArray = new Holder[]{$type};
        $this$vanillaTag.add(holderArray);
    }

    private static final void configure$lambda$7(RegistryEntry $type, VanillaTagBuilder $this$vanillaTag) {
        Intrinsics.checkNotNullParameter((Object)$this$vanillaTag, (String)"$this$vanillaTag");
        Holder[] holderArray = new Holder[]{$type};
        $this$vanillaTag.add(holderArray);
    }

    private static final void configure$lambda$8(RegistryEntry $type, VanillaTagBuilder $this$vanillaTag) {
        Intrinsics.checkNotNullParameter((Object)$this$vanillaTag, (String)"$this$vanillaTag");
        Holder[] holderArray = new Holder[]{$type};
        $this$vanillaTag.add(holderArray);
    }

    private static final void configure$lambda$9(RegistryEntry $type, VanillaTagBuilder $this$vanillaTag) {
        Intrinsics.checkNotNullParameter((Object)$this$vanillaTag, (String)"$this$vanillaTag");
        Holder[] holderArray = new Holder[]{$type};
        $this$vanillaTag.add(holderArray);
    }

    private static final void configure$lambda$10(RegistryEntry $type, VanillaTagBuilder $this$vanillaTag) {
        Intrinsics.checkNotNullParameter((Object)$this$vanillaTag, (String)"$this$vanillaTag");
        Holder[] holderArray = new Holder[]{$type};
        $this$vanillaTag.add(holderArray);
    }

    private static final void configure$lambda$11(RegistryEntry $type, VanillaTagBuilder $this$vanillaTag) {
        Intrinsics.checkNotNullParameter((Object)$this$vanillaTag, (String)"$this$vanillaTag");
        Holder[] holderArray = new Holder[]{$type};
        $this$vanillaTag.add(holderArray);
    }

    private static final void configure$lambda$12(RegistryEntry $type, VanillaTagBuilder $this$vanillaTag) {
        Intrinsics.checkNotNullParameter((Object)$this$vanillaTag, (String)"$this$vanillaTag");
        Holder[] holderArray = new Holder[]{$type};
        $this$vanillaTag.add(holderArray);
    }

    private static final void configure$lambda$13(RegistryEntry $type, VanillaTagBuilder $this$vanillaTag) {
        Intrinsics.checkNotNullParameter((Object)$this$vanillaTag, (String)"$this$vanillaTag");
        Holder[] holderArray = new Holder[]{$type};
        $this$vanillaTag.add(holderArray);
    }

    private static final void configure$lambda$14(RegistryEntry $type, VanillaTagBuilder $this$vanillaTag) {
        Intrinsics.checkNotNullParameter((Object)$this$vanillaTag, (String)"$this$vanillaTag");
        Holder[] holderArray = new Holder[]{$type};
        $this$vanillaTag.add(holderArray);
    }

    private static final void configure$lambda$15(RegistryEntry $type, VanillaTagBuilder $this$vanillaTag) {
        Intrinsics.checkNotNullParameter((Object)$this$vanillaTag, (String)"$this$vanillaTag");
        Holder[] holderArray = new Holder[]{$type};
        $this$vanillaTag.add(holderArray);
    }

    private static final void configure$lambda$16(RegistryEntry $type, VanillaTagBuilder $this$vanillaTag) {
        Intrinsics.checkNotNullParameter((Object)$this$vanillaTag, (String)"$this$vanillaTag");
        Holder[] holderArray = new Holder[]{$type};
        $this$vanillaTag.add(holderArray);
    }

    private static final void configure$lambda$17(RegistryEntry $type, VanillaTagBuilder $this$vanillaTag) {
        Intrinsics.checkNotNullParameter((Object)$this$vanillaTag, (String)"$this$vanillaTag");
        Holder[] holderArray = new Holder[]{$type};
        $this$vanillaTag.add(holderArray);
    }

    private static final void configure$lambda$18(RegistryEntry $type, VanillaTagBuilder $this$vanillaTag) {
        Intrinsics.checkNotNullParameter((Object)$this$vanillaTag, (String)"$this$vanillaTag");
        Holder[] holderArray = new Holder[]{$type};
        $this$vanillaTag.add(holderArray);
    }

    private static final void configure$lambda$19(RegistryEntry $type, VanillaTagBuilder $this$vanillaTag) {
        Intrinsics.checkNotNullParameter((Object)$this$vanillaTag, (String)"$this$vanillaTag");
        Holder[] holderArray = new Holder[]{$type};
        $this$vanillaTag.add(holderArray);
    }

    private static final void configure$lambda$20(RegistryEntry $type, VanillaTagBuilder $this$vanillaTag) {
        Intrinsics.checkNotNullParameter((Object)$this$vanillaTag, (String)"$this$vanillaTag");
        Holder[] holderArray = new Holder[]{$type};
        $this$vanillaTag.add(holderArray);
    }

    private static final void configure$lambda$21(RegistryEntry $type, VanillaTagBuilder $this$vanillaTag) {
        Intrinsics.checkNotNullParameter((Object)$this$vanillaTag, (String)"$this$vanillaTag");
        Holder[] holderArray = new Holder[]{$type};
        $this$vanillaTag.add(holderArray);
    }

    private static final void configure$lambda$22(RegistryEntry $type, VanillaTagBuilder $this$vanillaTag) {
        Intrinsics.checkNotNullParameter((Object)$this$vanillaTag, (String)"$this$vanillaTag");
        Holder[] holderArray = new Holder[]{$type};
        $this$vanillaTag.add(holderArray);
    }

    private static final void configure$lambda$23(RegistryEntry $type, VanillaTagBuilder $this$vanillaTag) {
        Intrinsics.checkNotNullParameter((Object)$this$vanillaTag, (String)"$this$vanillaTag");
        Holder[] holderArray = new Holder[]{$type};
        $this$vanillaTag.add(holderArray);
    }

    private static final void configure$lambda$24(RegistryEntry $type, VanillaTagBuilder $this$vanillaTag) {
        Intrinsics.checkNotNullParameter((Object)$this$vanillaTag, (String)"$this$vanillaTag");
        Holder[] holderArray = new Holder[]{$type};
        $this$vanillaTag.add(holderArray);
    }

    private static final void configure$lambda$25(RegistryEntry $type, VanillaTagBuilder $this$vanillaTag) {
        Intrinsics.checkNotNullParameter((Object)$this$vanillaTag, (String)"$this$vanillaTag");
        Holder[] holderArray = new Holder[]{$type};
        $this$vanillaTag.add(holderArray);
    }

    private static final void configure$lambda$26(RegistryEntry $type, VanillaTagBuilder $this$vanillaTag) {
        Intrinsics.checkNotNullParameter((Object)$this$vanillaTag, (String)"$this$vanillaTag");
        Holder[] holderArray = new Holder[]{$type};
        $this$vanillaTag.add(holderArray);
    }

    private static final void configure$lambda$27(RegistryEntry $type, VanillaTagBuilder $this$vanillaTag) {
        Intrinsics.checkNotNullParameter((Object)$this$vanillaTag, (String)"$this$vanillaTag");
        Holder[] holderArray = new Holder[]{$type};
        $this$vanillaTag.add(holderArray);
    }

    private static final void configure$lambda$28(RegistryEntry $type, VanillaTagBuilder $this$vanillaTag) {
        Intrinsics.checkNotNullParameter((Object)$this$vanillaTag, (String)"$this$vanillaTag");
        Holder[] holderArray = new Holder[]{$type};
        $this$vanillaTag.add(holderArray);
    }

    private static final void configure$lambda$29(RegistryEntry $type, VanillaTagBuilder $this$vanillaTag) {
        Intrinsics.checkNotNullParameter((Object)$this$vanillaTag, (String)"$this$vanillaTag");
        Holder[] holderArray = new Holder[]{$type};
        $this$vanillaTag.add(holderArray);
    }

    private static final void configure$lambda$30(RegistryEntry $type, BuiltInTagBuilder $this$builtInTag) {
        Intrinsics.checkNotNullParameter((Object)$this$builtInTag, (String)"$this$builtInTag");
        Holder[] holderArray = new Holder[]{$type};
        $this$builtInTag.add(holderArray);
    }
}

