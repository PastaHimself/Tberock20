/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function5
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.item.ItemStack
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  net.thebrokenscript.brokencore.api.subs.LivingUseTotemSubscriber
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.bypass;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.brokencore.api.subs.LivingUseTotemSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSDamageTypes;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/handlers/bypass/BypassTotemsHandler;", "", "<init>", "()V", "bypass", "", "entity", "Lnet/minecraft/world/entity/LivingEntity;", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "totem", "Lnet/minecraft/world/item/ItemStack;", "hand", "Lnet/minecraft/world/InteractionHand;", "cancelProxy", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "thebrokenscript-common"})
public final class BypassTotemsHandler {
    @NotNull
    public static final BypassTotemsHandler INSTANCE = new BypassTotemsHandler();

    private BypassTotemsHandler() {
    }

    public final void bypass(@NotNull LivingEntity entity, @NotNull DamageSource source, @NotNull ItemStack totem, @NotNull InteractionHand hand, @NotNull CancelProxy cancelProxy) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Intrinsics.checkNotNullParameter((Object)totem, (String)"totem");
        Intrinsics.checkNotNullParameter((Object)hand, (String)"hand");
        Intrinsics.checkNotNullParameter((Object)cancelProxy, (String)"cancelProxy");
        Entity entity2 = source.getEntity();
        if (entity2 == null) {
            return;
        }
        Entity sourceEntity = entity2;
        ResourceLocation resourceLocation = BuiltInRegistries.ENTITY_TYPE.getKey((Object)sourceEntity.getType());
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"getKey(...)");
        ResourceLocation entityTypeKey = resourceLocation;
        String namespace = entityTypeKey.getNamespace();
        if (Intrinsics.areEqual((Object)namespace, (Object)"thebrokenscript") || Intrinsics.areEqual((Object)source.type(), TBSDamageTypes.SA1)) {
            cancelProxy.setCanceled(true);
        }
    }

    static {
        LivingUseTotemSubscriber.INSTANCE.add((Function5)new Function5<LivingEntity, DamageSource, ItemStack, InteractionHand, CancelProxy, Unit>((Object)INSTANCE){

            public final void invoke(LivingEntity p0, DamageSource p1, ItemStack p2, InteractionHand p3, CancelProxy p4) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                Intrinsics.checkNotNullParameter((Object)p1, (String)"p1");
                Intrinsics.checkNotNullParameter((Object)p2, (String)"p2");
                Intrinsics.checkNotNullParameter((Object)p3, (String)"p3");
                Intrinsics.checkNotNullParameter((Object)p4, (String)"p4");
                ((BypassTotemsHandler)this.receiver).bypass(p0, p1, p2, p3, p4);
            }
        });
    }
}

