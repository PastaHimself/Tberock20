/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.state.BlockState
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.animatable.GeoAnimatable
 *  software.bernie.geckolib.animatable.GeoBlockEntity
 *  software.bernie.geckolib.animatable.instance.AnimatableInstanceCache
 *  software.bernie.geckolib.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.animation.AnimationController
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 *  software.bernie.geckolib.animation.RawAnimation
 *  software.bernie.geckolib.util.GeckoLibUtil
 */
package net.thebrokenscript.block.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB'\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\u0018\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0014R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001f"}, d2={"Lnet/thebrokenscript/block/entity/PlushBlockEntity;", "Lnet/minecraft/world/level/block/entity/BlockEntity;", "Lsoftware/bernie/geckolib/animatable/GeoBlockEntity;", "type", "Lnet/minecraft/world/level/block/entity/BlockEntityType;", "pos", "Lnet/minecraft/core/BlockPos;", "blockState", "Lnet/minecraft/world/level/block/state/BlockState;", "<init>", "(Lnet/minecraft/world/level/block/entity/BlockEntityType;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)V", "cache", "Lsoftware/bernie/geckolib/animatable/instance/AnimatableInstanceCache;", "registerControllers", "", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "getAnimatableInstanceCache", "mergedSide", "", "getMergedSide", "()Ljava/lang/String;", "setMergedSide", "(Ljava/lang/String;)V", "saveAdditional", "tag", "Lnet/minecraft/nbt/CompoundTag;", "registries", "Lnet/minecraft/core/HolderLookup$Provider;", "loadAdditional", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nPlushBlockEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlushBlockEntity.kt\nnet/thebrokenscript/block/entity/PlushBlockEntity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,52:1\n1#2:53\n*E\n"})
public class PlushBlockEntity
extends BlockEntity
implements GeoBlockEntity {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final AnimatableInstanceCache cache;
    @Nullable
    private String mergedSide;
    private static final RawAnimation SQUISH_ANIM = RawAnimation.begin().thenPlay("squish");
    private static final RawAnimation LEFT_START = RawAnimation.begin().thenPlay("leftstart");
    private static final RawAnimation LEFT_FINISH = RawAnimation.begin().thenPlay("leftfinish");
    private static final RawAnimation RIGHT_START = RawAnimation.begin().thenPlay("rightstart");
    private static final RawAnimation RIGHT_FINISH = RawAnimation.begin().thenPlay("rightfinish");

    public PlushBlockEntity(@NotNull BlockEntityType<? extends PlushBlockEntity> type, @NotNull BlockPos pos, @NotNull BlockState blockState) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)blockState, (String)"blockState");
        super(type, pos, blockState);
        AnimatableInstanceCache animatableInstanceCache = GeckoLibUtil.createInstanceCache((GeoAnimatable)((GeoAnimatable)this));
        Intrinsics.checkNotNullExpressionValue((Object)animatableInstanceCache, (String)"createInstanceCache(...)");
        this.cache = animatableInstanceCache;
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        reg.add(new AnimationController((GeoAnimatable)this, "squish", 0, PlushBlockEntity::registerControllers$lambda$0).triggerableAnim("squish", SQUISH_ANIM));
        reg.add(new AnimationController((GeoAnimatable)this, "leftstart", 0, PlushBlockEntity::registerControllers$lambda$1).triggerableAnim("leftstart", LEFT_START));
        reg.add(new AnimationController((GeoAnimatable)this, "leftfinish", 0, PlushBlockEntity::registerControllers$lambda$2).triggerableAnim("leftfinish", LEFT_FINISH));
        reg.add(new AnimationController((GeoAnimatable)this, "rightstart", 0, PlushBlockEntity::registerControllers$lambda$3).triggerableAnim("rightstart", RIGHT_START));
        reg.add(new AnimationController((GeoAnimatable)this, "rightfinish", 0, PlushBlockEntity::registerControllers$lambda$4).triggerableAnim("rightfinish", RIGHT_FINISH));
    }

    @NotNull
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Nullable
    public final String getMergedSide() {
        return this.mergedSide;
    }

    public final void setMergedSide(@Nullable String string) {
        this.mergedSide = string;
    }

    protected void saveAdditional(@NotNull CompoundTag tag, @NotNull HolderLookup.Provider registries) {
        block0: {
            Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
            Intrinsics.checkNotNullParameter((Object)registries, (String)"registries");
            super.saveAdditional(tag, registries);
            String string = this.mergedSide;
            if (string == null) break block0;
            String it = string;
            boolean bl = false;
            tag.putString("mergedSide", it);
        }
    }

    protected void loadAdditional(@NotNull CompoundTag tag, @NotNull HolderLookup.Provider registries) {
        Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
        Intrinsics.checkNotNullParameter((Object)registries, (String)"registries");
        super.loadAdditional(tag, registries);
        this.mergedSide = tag.contains("mergedSide") ? tag.getString("mergedSide") : null;
    }

    private static final PlayState registerControllers$lambda$0(AnimationState it) {
        return PlayState.STOP;
    }

    private static final PlayState registerControllers$lambda$1(AnimationState it) {
        return PlayState.STOP;
    }

    private static final PlayState registerControllers$lambda$2(AnimationState it) {
        return PlayState.STOP;
    }

    private static final PlayState registerControllers$lambda$3(AnimationState it) {
        return PlayState.STOP;
    }

    private static final PlayState registerControllers$lambda$4(AnimationState it) {
        return PlayState.STOP;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/block/entity/PlushBlockEntity$Companion;", "", "<init>", "()V", "SQUISH_ANIM", "Lsoftware/bernie/geckolib/animation/RawAnimation;", "kotlin.jvm.PlatformType", "LEFT_START", "LEFT_FINISH", "RIGHT_START", "RIGHT_FINISH", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

