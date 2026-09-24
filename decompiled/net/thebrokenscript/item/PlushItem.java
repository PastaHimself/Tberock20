/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.Random
 *  net.minecraft.core.Holder
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.InteractionResultHolder
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.BlockItem
 *  net.minecraft.world.item.Equipable
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.item.context.UseOnContext
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.SoundUtil
 *  net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.animatable.GeoAnimatable
 *  software.bernie.geckolib.animatable.GeoItem
 *  software.bernie.geckolib.animatable.SingletonGeoAnimatable
 *  software.bernie.geckolib.animatable.client.GeoRenderProvider
 *  software.bernie.geckolib.animatable.instance.AnimatableInstanceCache
 *  software.bernie.geckolib.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.animation.AnimationController
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 *  software.bernie.geckolib.animation.RawAnimation
 *  software.bernie.geckolib.util.GeckoLibUtil
 */
package net.thebrokenscript.item;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.SoundUtil;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.client.renderer.item.PlushItemRenderer;
import net.thebrokenscript.item.PlushItem;
import net.thebrokenscript.registry.TBSPlushies;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 42\u00020\u00012\u00020\u00022\u00020\u0003:\u00014B5\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u0018J&\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00180!2\u0006\u0010\u001c\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020&2\u0006\u0010'\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u0010H\u0016J\u0016\u0010,\u001a\u00020\u00122\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.H\u0016J\b\u00100\u001a\u000201H\u0016J\u000e\u00102\u001a\b\u0012\u0004\u0012\u00020\f03H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2={"Lnet/thebrokenscript/item/PlushItem;", "Lnet/minecraft/world/item/BlockItem;", "Lsoftware/bernie/geckolib/animatable/GeoItem;", "Lnet/minecraft/world/item/Equipable;", "name", "", "block", "Lnet/minecraft/world/level/block/Block;", "properties", "Lnet/minecraft/world/item/Item$Properties;", "sound", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "Lnet/minecraft/sounds/SoundEvent;", "<init>", "(Ljava/lang/String;Lnet/minecraft/world/level/block/Block;Lnet/minecraft/world/item/Item$Properties;Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;)V", "cache", "Lsoftware/bernie/geckolib/animatable/instance/AnimatableInstanceCache;", "registerControllers", "", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "getUseDuration", "", "stack", "Lnet/minecraft/world/item/ItemStack;", "entity", "Lnet/minecraft/world/entity/LivingEntity;", "onUse", "level", "Lnet/minecraft/server/level/ServerLevel;", "player", "Lnet/minecraft/world/entity/player/Player;", "use", "Lnet/minecraft/world/InteractionResultHolder;", "Lnet/minecraft/world/level/Level;", "usedHand", "Lnet/minecraft/world/InteractionHand;", "useOn", "Lnet/minecraft/world/InteractionResult;", "context", "Lnet/minecraft/world/item/context/UseOnContext;", "place", "Lnet/minecraft/world/item/context/BlockPlaceContext;", "getAnimatableInstanceCache", "createGeoRenderer", "consumer", "Ljava/util/function/Consumer;", "Lsoftware/bernie/geckolib/animatable/client/GeoRenderProvider;", "getEquipmentSlot", "Lnet/minecraft/world/entity/EquipmentSlot;", "getEquipSound", "Lnet/minecraft/core/Holder;", "Companion", "thebrokenscript-common"})
public final class PlushItem
extends BlockItem
implements GeoItem,
Equipable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String name;
    @Nullable
    private final RegistryEntry<SoundEvent, SoundEvent> sound;
    @NotNull
    private final AnimatableInstanceCache cache;
    private static final RawAnimation SQUISH_ANIM = RawAnimation.begin().thenPlay("squish");

    public PlushItem(@NotNull String name, @NotNull Block block, @NotNull Item.Properties properties, @Nullable RegistryEntry<SoundEvent, SoundEvent> sound) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)block, (String)"block");
        Intrinsics.checkNotNullParameter((Object)properties, (String)"properties");
        super(block, properties);
        this.name = name;
        this.sound = sound;
        AnimatableInstanceCache animatableInstanceCache = GeckoLibUtil.createInstanceCache((GeoAnimatable)((GeoAnimatable)this));
        Intrinsics.checkNotNullExpressionValue((Object)animatableInstanceCache, (String)"createInstanceCache(...)");
        this.cache = animatableInstanceCache;
        SingletonGeoAnimatable.registerSyncedAnimatable((GeoAnimatable)((GeoAnimatable)this));
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        reg.add(new AnimationController((GeoAnimatable)this, "squish", 0, PlushItem::registerControllers$lambda$0).triggerableAnim("squish", SQUISH_ANIM));
    }

    public int getUseDuration(@NotNull ItemStack stack, @NotNull LivingEntity entity) {
        Intrinsics.checkNotNullParameter((Object)stack, (String)"stack");
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        return 40;
    }

    public final void onUse(@NotNull ServerLevel level, @NotNull Player player, @NotNull ItemStack stack) {
        block1: {
            block0: {
                Intrinsics.checkNotNullParameter((Object)level, (String)"level");
                Intrinsics.checkNotNullParameter((Object)player, (String)"player");
                Intrinsics.checkNotNullParameter((Object)stack, (String)"stack");
                long inst = GeoItem.getOrAssignId((ItemStack)stack, (ServerLevel)level);
                this.stopTriggeredAnim((Entity)player, inst, "squish", "squish");
                this.triggerAnim((Entity)player, inst, "squish", "squish");
                if (!Intrinsics.areEqual((Object)((Object)this), (Object)TBSPlushies.SHADOW.getBlock().getItem())) break block0;
                Level level2 = (Level)level;
                Vec3 vec3 = player.position();
                Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
                Set set = BuiltInRegistries.SOUND_EVENT.entrySet();
                Intrinsics.checkNotNullExpressionValue((Object)set, (String)"entrySet(...)");
                Object v = ((Map.Entry)CollectionsKt.random((Collection)set, (Random)((Random)Random.Default))).getValue();
                Intrinsics.checkNotNullExpressionValue(v, (String)"<get-value>(...)");
                SoundUtil.tryPlaySound$default((Level)level2, (Vec3)vec3, (SoundEvent)((SoundEvent)v), (float)1.0f, (float)Math.max((float)Math.random() * 1.5f, 0.005f), null, (int)16, null);
                break block1;
            }
            RegistryEntry<SoundEvent, SoundEvent> registryEntry = this.sound;
            if (registryEntry == null) break block1;
            RegistryEntry<SoundEvent, SoundEvent> it = registryEntry;
            boolean bl = false;
            Level level3 = (Level)level;
            Vec3 vec3 = player.position();
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
            SoundUtil.tryPlaySound$default((Level)level3, (Vec3)vec3, (SoundEvent)((SoundEvent)it.get()), (float)0.0f, (float)0.0f, null, (int)28, null);
        }
    }

    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand usedHand) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)usedHand, (String)"usedHand");
        if (player.isShiftKeyDown()) {
            if (level instanceof ServerLevel) {
                ServerLevel serverLevel = (ServerLevel)level;
                ItemStack itemStack = player.getItemInHand(usedHand);
                Intrinsics.checkNotNullExpressionValue((Object)itemStack, (String)"getItemInHand(...)");
                this.onUse(serverLevel, player, itemStack);
                player.startUsingItem(usedHand);
            }
        } else {
            InteractionResultHolder interactionResultHolder = this.swapWithEquipmentSlot((Item)this, level, player, usedHand);
            Intrinsics.checkNotNullExpressionValue((Object)interactionResultHolder, (String)"swapWithEquipmentSlot(...)");
            return interactionResultHolder;
        }
        InteractionResultHolder interactionResultHolder = super.use(level, player, usedHand);
        Intrinsics.checkNotNullExpressionValue((Object)interactionResultHolder, (String)"use(...)");
        return interactionResultHolder;
    }

    @NotNull
    public InteractionResult useOn(@NotNull UseOnContext context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Player player = context.getPlayer();
        if (!(player != null ? player.isShiftKeyDown() : false)) {
            Level level = context.getLevel();
            InteractionHand usedHand = context.getHand();
            Player player2 = context.getPlayer();
            Intrinsics.checkNotNull((Object)player2);
            Player player3 = player2;
            if (level instanceof ServerLevel) {
                ServerLevel serverLevel = (ServerLevel)level;
                ItemStack itemStack = player3.getItemInHand(usedHand);
                Intrinsics.checkNotNullExpressionValue((Object)itemStack, (String)"getItemInHand(...)");
                this.onUse(serverLevel, player3, itemStack);
                player3.startUsingItem(usedHand);
            }
        }
        InteractionResult interactionResult = super.useOn(context);
        Intrinsics.checkNotNullExpressionValue((Object)interactionResult, (String)"useOn(...)");
        return interactionResult;
    }

    @NotNull
    public InteractionResult place(@NotNull BlockPlaceContext context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Player player = context.getPlayer();
        if (!(player != null ? player.isShiftKeyDown() : false)) {
            return InteractionResult.FAIL;
        }
        InteractionResult interactionResult = super.place(context);
        Intrinsics.checkNotNullExpressionValue((Object)interactionResult, (String)"place(...)");
        return interactionResult;
    }

    @NotNull
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    public void createGeoRenderer(@NotNull Consumer<GeoRenderProvider> consumer) {
        Intrinsics.checkNotNullParameter(consumer, (String)"consumer");
        consumer.accept(new GeoRenderProvider(this){
            private final Lazy renderer$delegate;
            {
                this.renderer$delegate = LazyKt.lazy(() -> createGeoRenderer.1.renderer_delegate$lambda$0($receiver));
            }

            private final PlushItemRenderer getRenderer() {
                Lazy lazy = this.renderer$delegate;
                return (PlushItemRenderer)((Object)lazy.getValue());
            }

            public PlushItemRenderer getGeoItemRenderer() {
                return this.getRenderer();
            }

            private static final PlushItemRenderer renderer_delegate$lambda$0(PlushItem this$0) {
                return new PlushItemRenderer(PlushItem.access$getName$p(this$0));
            }
        });
    }

    @NotNull
    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }

    @NotNull
    public Holder<SoundEvent> getEquipSound() {
        Holder holder2 = SoundEvents.ARMOR_EQUIP_GENERIC;
        Intrinsics.checkNotNullExpressionValue((Object)holder2, (String)"ARMOR_EQUIP_GENERIC");
        return holder2;
    }

    private static final PlayState registerControllers$lambda$0(AnimationState it) {
        return PlayState.STOP;
    }

    public static final /* synthetic */ String access$getName$p(PlushItem $this) {
        return $this.name;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/item/PlushItem$Companion;", "", "<init>", "()V", "SQUISH_ANIM", "Lsoftware/bernie/geckolib/animation/RawAnimation;", "kotlin.jvm.PlatformType", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

