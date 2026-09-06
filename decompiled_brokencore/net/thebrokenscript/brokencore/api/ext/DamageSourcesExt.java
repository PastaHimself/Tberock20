/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageSources
 *  net.minecraft.world.damagesource.DamageType
 *  net.minecraft.world.entity.Entity
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.ext;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.thebrokenscript.brokencore.impl.mixin.features.damage.DamageSourcesAccessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006J\"\u0010\u0007\u001a\u00020\u0005*\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ,\u0010\u0007\u001a\u00020\u0005*\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/api/ext/DamageSourcesExt;", "", "<init>", "()V", "player", "Lnet/minecraft/world/damagesource/DamageSource;", "Lnet/minecraft/world/damagesource/DamageSources;", "source", "damageTypeKey", "Lnet/minecraft/resources/ResourceKey;", "Lnet/minecraft/world/damagesource/DamageType;", "entity", "Lnet/minecraft/world/entity/Entity;", "causingEntity", "directEntity", "brokencore-common"})
public final class DamageSourcesExt {
    @NotNull
    public static final DamageSourcesExt INSTANCE = new DamageSourcesExt();

    private DamageSourcesExt() {
    }

    @NotNull
    public final DamageSource player(@NotNull DamageSources $this$player) {
        Intrinsics.checkNotNullParameter((Object)$this$player, (String)"<this>");
        DamageSource damageSource = $this$player.playerAttack(null);
        Intrinsics.checkNotNullExpressionValue((Object)damageSource, (String)"playerAttack(...)");
        return damageSource;
    }

    @NotNull
    public final DamageSource source(@NotNull DamageSources $this$source, @NotNull ResourceKey<DamageType> damageTypeKey, @Nullable Entity entity) {
        Intrinsics.checkNotNullParameter((Object)$this$source, (String)"<this>");
        Intrinsics.checkNotNullParameter(damageTypeKey, (String)"damageTypeKey");
        DamageSource damageSource = ((DamageSourcesAccessor)$this$source).bc$sourceWithCausing(damageTypeKey, entity);
        Intrinsics.checkNotNullExpressionValue((Object)damageSource, (String)"bc$sourceWithCausing(...)");
        return damageSource;
    }

    @NotNull
    public final DamageSource source(@NotNull DamageSources $this$source, @NotNull ResourceKey<DamageType> damageTypeKey, @Nullable Entity causingEntity, @Nullable Entity directEntity) {
        Intrinsics.checkNotNullParameter((Object)$this$source, (String)"<this>");
        Intrinsics.checkNotNullParameter(damageTypeKey, (String)"damageTypeKey");
        DamageSource damageSource = ((DamageSourcesAccessor)$this$source).bc$sourceWithCausingDirect(damageTypeKey, causingEntity, directEntity);
        Intrinsics.checkNotNullExpressionValue((Object)damageSource, (String)"bc$sourceWithCausingDirect(...)");
        return damageSource;
    }
}

