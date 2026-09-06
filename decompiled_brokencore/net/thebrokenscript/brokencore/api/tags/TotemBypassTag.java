/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function5
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.item.ItemStack
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.tags;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.thebrokenscript.brokencore.api.BCApi;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.brokencore.api.subs.LivingUseTotemSubscriber;
import net.thebrokenscript.brokencore.impl.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J.\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R2\u0010\u0004\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/brokencore/api/tags/TotemBypassTag;", "", "<init>", "()V", "key", "Lnet/minecraft/resources/ResourceKey;", "Lnet/minecraft/world/damagesource/DamageType;", "kotlin.jvm.PlatformType", "bypass", "", "entity", "Lnet/minecraft/world/entity/LivingEntity;", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "totem", "Lnet/minecraft/world/item/ItemStack;", "hand", "Lnet/minecraft/world/InteractionHand;", "cancelProxy", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "brokencore-common"})
public final class TotemBypassTag {
    @NotNull
    public static final TotemBypassTag INSTANCE = new TotemBypassTag();
    private static final ResourceKey<DamageType> key = ResourceKey.create((ResourceKey)Registries.DAMAGE_TYPE, (ResourceLocation)BCApi.id("bypasses_totem"));

    private TotemBypassTag() {
    }

    public final void bypass(@NotNull LivingEntity entity, @NotNull DamageSource source, @NotNull ItemStack totem, @NotNull InteractionHand hand, @NotNull CancelProxy cancelProxy) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Intrinsics.checkNotNullParameter((Object)totem, (String)"totem");
        Intrinsics.checkNotNullParameter((Object)hand, (String)"hand");
        Intrinsics.checkNotNullParameter((Object)cancelProxy, (String)"cancelProxy");
        if (entity.level().registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).get(key) != null) {
            cancelProxy.setCanceled(true);
        }
    }

    static {
        LivingUseTotemSubscriber.INSTANCE.add((Function5<? super LivingEntity, ? super DamageSource, ? super ItemStack, ? super InteractionHand, ? super CancelProxy, Unit>)((Function5)new Function5<LivingEntity, DamageSource, ItemStack, InteractionHand, CancelProxy, Unit>((Object)INSTANCE){

            public final void invoke(LivingEntity p0, DamageSource p1, ItemStack p2, InteractionHand p3, CancelProxy p4) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                Intrinsics.checkNotNullParameter((Object)p1, (String)"p1");
                Intrinsics.checkNotNullParameter((Object)p2, (String)"p2");
                Intrinsics.checkNotNullParameter((Object)p3, (String)"p3");
                Intrinsics.checkNotNullParameter((Object)p4, (String)"p4");
                ((TotemBypassTag)this.receiver).bypass(p0, p1, p2, p3, p4);
            }
        }));
    }
}

