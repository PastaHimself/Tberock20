/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function5
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.item.ItemStack
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.subs;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J2\u0010\r\u001a\u00020\u000e2*\u0010\u000f\u001a&\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0006J.\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u000bR8\u0010\u0004\u001a,\u0012(\u0012&\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/brokencore/api/subs/LivingUseTotemSubscriber;", "", "<init>", "()V", "listeners", "", "Lkotlin/Function5;", "Lnet/minecraft/world/entity/LivingEntity;", "Lnet/minecraft/world/damagesource/DamageSource;", "Lnet/minecraft/world/item/ItemStack;", "Lnet/minecraft/world/InteractionHand;", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "", "add", "", "listener", "call", "entity", "source", "totem", "hand", "cancelProxy", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nLivingUseTotemSubscriber.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LivingUseTotemSubscriber.kt\nnet/thebrokenscript/brokencore/api/subs/LivingUseTotemSubscriber\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,16:1\n1869#2,2:17\n*S KotlinDebug\n*F\n+ 1 LivingUseTotemSubscriber.kt\nnet/thebrokenscript/brokencore/api/subs/LivingUseTotemSubscriber\n*L\n15#1:17,2\n*E\n"})
public final class LivingUseTotemSubscriber {
    @NotNull
    public static final LivingUseTotemSubscriber INSTANCE = new LivingUseTotemSubscriber();
    @NotNull
    private static final Set<Function5<LivingEntity, DamageSource, ItemStack, InteractionHand, CancelProxy, Unit>> listeners = new LinkedHashSet();

    private LivingUseTotemSubscriber() {
    }

    public final boolean add(@NotNull Function5<? super LivingEntity, ? super DamageSource, ? super ItemStack, ? super InteractionHand, ? super CancelProxy, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, (String)"listener");
        return listeners.add(listener);
    }

    public final void call(@NotNull LivingEntity entity, @NotNull DamageSource source, @NotNull ItemStack totem, @NotNull InteractionHand hand, @NotNull CancelProxy cancelProxy) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Intrinsics.checkNotNullParameter((Object)totem, (String)"totem");
        Intrinsics.checkNotNullParameter((Object)hand, (String)"hand");
        Intrinsics.checkNotNullParameter((Object)cancelProxy, (String)"cancelProxy");
        Iterable $this$forEach$iv = listeners;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Function5 it = (Function5)element$iv;
            boolean bl = false;
            if (cancelProxy.isCanceled()) continue;
            it.invoke((Object)entity, (Object)source, (Object)totem, (Object)hand, (Object)cancelProxy);
        }
    }
}

