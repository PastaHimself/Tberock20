/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.CommandDispatcher
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.commands.CommandBuildContext
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.commands.Commands$CommandSelection
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.server.packs.PackType
 *  net.minecraft.server.packs.repository.Pack$Position
 *  net.minecraft.server.packs.repository.PackSource
 *  net.minecraft.world.Container
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EquipmentSlotGroup
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.attributes.Attribute
 *  net.minecraft.world.entity.ai.attributes.AttributeModifier
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.BlockHitResult
 *  net.neoforged.bus.api.EventPriority
 *  net.neoforged.bus.api.IEventBus
 *  net.neoforged.fml.common.Mod
 *  net.neoforged.neoforge.common.NeoForge
 *  net.neoforged.neoforge.event.AddPackFindersEvent
 *  net.neoforged.neoforge.event.ItemAttributeModifierEvent
 *  net.neoforged.neoforge.event.RegisterCommandsEvent
 *  net.neoforged.neoforge.event.ServerChatEvent
 *  net.neoforged.neoforge.event.entity.EntityJoinLevelEvent
 *  net.neoforged.neoforge.event.entity.living.LivingDeathEvent
 *  net.neoforged.neoforge.event.entity.living.LivingKnockBackEvent
 *  net.neoforged.neoforge.event.entity.player.AttackEntityEvent
 *  net.neoforged.neoforge.event.entity.player.PlayerEvent$Clone
 *  net.neoforged.neoforge.event.entity.player.PlayerEvent$ItemCraftedEvent
 *  net.neoforged.neoforge.event.entity.player.PlayerEvent$PlayerLoggedInEvent
 *  net.neoforged.neoforge.event.entity.player.PlayerEvent$PlayerLoggedOutEvent
 *  net.neoforged.neoforge.event.entity.player.PlayerEvent$PlayerRespawnEvent
 *  net.neoforged.neoforge.event.entity.player.PlayerInteractEvent$RightClickBlock
 *  net.neoforged.neoforge.event.level.BlockDropsEvent
 *  net.neoforged.neoforge.event.level.BlockEvent$EntityPlaceEvent
 *  net.neoforged.neoforge.event.level.LevelEvent$Load
 *  net.neoforged.neoforge.event.server.ServerStartedEvent
 *  net.neoforged.neoforge.event.server.ServerStoppedEvent
 *  net.neoforged.neoforge.event.tick.LevelTickEvent$Post
 *  net.neoforged.neoforge.event.tick.PlayerTickEvent$Post
 *  net.neoforged.neoforge.event.tick.ServerTickEvent$Post
 *  net.neoforged.neoforge.registries.RegisterEvent
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.neoforge;

import com.mojang.brigadier.CommandDispatcher;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforge.event.ItemAttributeModifierEvent;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.ServerChatEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingKnockBackEvent;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockDropsEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.level.LevelEvent;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import net.neoforged.neoforge.event.server.ServerStoppedEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import net.thebrokenscript.TheBrokenScript;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.engine.StructureEngine;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.command.TBSCommands;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.handlers.subs.AttackEntitySubscriber;
import net.thebrokenscript.handlers.subs.BlockBreakSubscriber;
import net.thebrokenscript.handlers.subs.EntityPlaceSubscriber;
import net.thebrokenscript.handlers.subs.EntitySpawnSubscriber;
import net.thebrokenscript.handlers.subs.ItemAttributeModifierSubscriber;
import net.thebrokenscript.handlers.subs.ItemCraftedSubscriber;
import net.thebrokenscript.handlers.subs.LevelLoadSubscriber;
import net.thebrokenscript.handlers.subs.LevelTickSubscriber;
import net.thebrokenscript.handlers.subs.LivingDeathSubscriber;
import net.thebrokenscript.handlers.subs.LivingKnockbackSubscriber;
import net.thebrokenscript.handlers.subs.PlayerCloneSubscriber;
import net.thebrokenscript.handlers.subs.PlayerLoggedInSubscriber;
import net.thebrokenscript.handlers.subs.PlayerLoggedOutSubscriber;
import net.thebrokenscript.handlers.subs.PlayerRespawnSubscriber;
import net.thebrokenscript.handlers.subs.PlayerRightClickInteractSubscriber;
import net.thebrokenscript.handlers.subs.PlayerTickSubscriber;
import net.thebrokenscript.handlers.subs.ServerChatSubscriber;
import net.thebrokenscript.handlers.subs.ServerStartSubscriber;
import net.thebrokenscript.handlers.subs.ServerStopSubscriber;
import net.thebrokenscript.handlers.subs.ServerTickSubscriber;
import net.thebrokenscript.registry.TBSLang;
import org.jetbrains.annotations.NotNull;

@Mod(value="thebrokenscript")
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/neoforge/TBSNeoForge;", "", "modBus", "Lnet/neoforged/bus/api/IEventBus;", "<init>", "(Lnet/neoforged/bus/api/IEventBus;)V", "initialized", "", "commonInit", "", "registerBuiltInPacks", "event", "Lnet/neoforged/neoforge/event/AddPackFindersEvent;", "Companion", "thebrokenscript-neoforge"})
public final class TBSNeoForge {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private boolean initialized;

    public TBSNeoForge(@NotNull IEventBus modBus) {
        Intrinsics.checkNotNullParameter((Object)modBus, (String)"modBus");
        modBus.addListener(RegisterEvent.class, arg_0 -> TBSNeoForge._init_$lambda$0(this, arg_0));
        modBus.addListener(this::registerBuiltInPacks);
        NeoForge.EVENT_BUS.addListener(ServerTickEvent.Post.class, TBSNeoForge::_init_$lambda$1);
        NeoForge.EVENT_BUS.addListener(PlayerEvent.ItemCraftedEvent.class, TBSNeoForge::_init_$lambda$2);
        NeoForge.EVENT_BUS.addListener(LevelTickEvent.Post.class, TBSNeoForge::_init_$lambda$3);
        NeoForge.EVENT_BUS.addListener(LevelEvent.Load.class, TBSNeoForge::_init_$lambda$4);
        NeoForge.EVENT_BUS.addListener(LivingKnockBackEvent.class, TBSNeoForge::_init_$lambda$5);
        NeoForge.EVENT_BUS.addListener(PlayerTickEvent.Post.class, TBSNeoForge::_init_$lambda$6);
        NeoForge.EVENT_BUS.addListener(PlayerEvent.PlayerLoggedInEvent.class, TBSNeoForge::_init_$lambda$7);
        NeoForge.EVENT_BUS.addListener(PlayerEvent.PlayerLoggedOutEvent.class, TBSNeoForge::_init_$lambda$8);
        NeoForge.EVENT_BUS.addListener(PlayerEvent.PlayerRespawnEvent.class, TBSNeoForge::_init_$lambda$9);
        NeoForge.EVENT_BUS.addListener(PlayerEvent.Clone.class, TBSNeoForge::_init_$lambda$10);
        NeoForge.EVENT_BUS.addListener(PlayerInteractEvent.RightClickBlock.class, TBSNeoForge::_init_$lambda$11);
        NeoForge.EVENT_BUS.addListener(ServerTickEvent.Post.class, TBSNeoForge::_init_$lambda$12);
        NeoForge.EVENT_BUS.addListener(ServerStartedEvent.class, TBSNeoForge::_init_$lambda$13);
        NeoForge.EVENT_BUS.addListener(EntityJoinLevelEvent.class, TBSNeoForge::_init_$lambda$14);
        NeoForge.EVENT_BUS.addListener(BlockEvent.EntityPlaceEvent.class, TBSNeoForge::_init_$lambda$15);
        NeoForge.EVENT_BUS.addListener(AttackEntityEvent.class, TBSNeoForge::_init_$lambda$16);
        NeoForge.EVENT_BUS.addListener(BlockDropsEvent.class, TBSNeoForge::_init_$lambda$17);
        NeoForge.EVENT_BUS.addListener(EventPriority.HIGHEST, ServerChatEvent.class, TBSNeoForge::_init_$lambda$18);
        NeoForge.EVENT_BUS.addListener(RegisterCommandsEvent.class, TBSNeoForge::_init_$lambda$19);
        NeoForge.EVENT_BUS.addListener(LivingDeathEvent.class, TBSNeoForge::_init_$lambda$20);
        NeoForge.EVENT_BUS.addListener(ServerStoppedEvent.class, TBSNeoForge::_init_$lambda$21);
        NeoForge.EVENT_BUS.addListener(ItemAttributeModifierEvent.class, TBSNeoForge::_init_$lambda$22);
    }

    private final void commonInit() {
        if (this.initialized) {
            return;
        }
        this.initialized = true;
        TheBrokenScript.INSTANCE.init();
    }

    private final void registerBuiltInPacks(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            event.addPackFinders(TBSConstants.id("nostalgia"), PackType.CLIENT_RESOURCES, (Component)TBSLang.INSTANCE.getNOSTALGIA_HELPER(), PackSource.BUILT_IN, false, Pack.Position.TOP);
        } else if (event.getPackType() == PackType.SERVER_DATA) {
            event.addPackFinders(TBSConstants.id("nostalgia_gen"), PackType.SERVER_DATA, (Component)TBSLang.INSTANCE.getNOSTALGIA_HELPER_DATA(), TBSNeoForge.Companion.nostalgiaGenSource(), false, Pack.Position.TOP);
        }
    }

    private static final void _init_$lambda$0(TBSNeoForge this$0, RegisterEvent it) {
        this$0.commonInit();
    }

    private static final void _init_$lambda$1(ServerTickEvent.Post it) {
        TheBrokenScript.serverWorkQueue.tick();
        MinecraftServer minecraftServer = it.getServer();
        Intrinsics.checkNotNullExpressionValue((Object)minecraftServer, (String)"getServer(...)");
        StructureEngine.INSTANCE.tick(minecraftServer);
    }

    private static final void _init_$lambda$2(PlayerEvent.ItemCraftedEvent it) {
        ItemStack itemStack = it.getCrafting();
        Intrinsics.checkNotNullExpressionValue((Object)itemStack, (String)"getCrafting(...)");
        Player player = it.getEntity();
        Intrinsics.checkNotNullExpressionValue((Object)player, (String)"getEntity(...)");
        Container container = it.getInventory();
        Intrinsics.checkNotNullExpressionValue((Object)container, (String)"getInventory(...)");
        ItemCraftedSubscriber.INSTANCE.call(itemStack, player, container);
    }

    private static final void _init_$lambda$3(LevelTickEvent.Post it) {
        Level level = it.getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)level, (String)"getLevel(...)");
        LevelTickSubscriber.INSTANCE.call(level);
    }

    private static final void _init_$lambda$4(LevelEvent.Load it) {
        LevelAccessor levelAccessor = it.getLevel();
        Level level = levelAccessor instanceof Level ? (Level)levelAccessor : null;
        if (level == null) {
            return;
        }
        LevelLoadSubscriber.INSTANCE.call(level);
    }

    private static final void _init_$lambda$5(LivingKnockBackEvent it) {
        LivingEntity livingEntity = it.getEntity();
        Intrinsics.checkNotNullExpressionValue((Object)livingEntity, (String)"getEntity(...)");
        Intrinsics.checkNotNull((Object)it);
        LivingKnockbackSubscriber.INSTANCE.call(livingEntity, new CancelProxy((Function1)new Function1<Boolean, Unit>((Object)it){

            public final void invoke(boolean p0) {
                ((LivingKnockBackEvent)this.receiver).setCanceled(p0);
            }
        }, (Function0)new Function0<Boolean>((Object)it){

            public final Boolean invoke() {
                return ((LivingKnockBackEvent)this.receiver).isCanceled();
            }
        }));
    }

    private static final void _init_$lambda$6(PlayerTickEvent.Post it) {
        Player player = it.getEntity();
        Intrinsics.checkNotNullExpressionValue((Object)player, (String)"getEntity(...)");
        PlayerTickSubscriber.INSTANCE.call(player);
    }

    private static final void _init_$lambda$7(PlayerEvent.PlayerLoggedInEvent it) {
        Player player = it.getEntity();
        Intrinsics.checkNotNullExpressionValue((Object)player, (String)"getEntity(...)");
        PlayerLoggedInSubscriber.INSTANCE.call(player);
    }

    private static final void _init_$lambda$8(PlayerEvent.PlayerLoggedOutEvent it) {
        Player player = it.getEntity();
        Intrinsics.checkNotNullExpressionValue((Object)player, (String)"getEntity(...)");
        PlayerLoggedOutSubscriber.INSTANCE.call(player);
    }

    private static final void _init_$lambda$9(PlayerEvent.PlayerRespawnEvent it) {
        Player player = it.getEntity();
        Intrinsics.checkNotNullExpressionValue((Object)player, (String)"getEntity(...)");
        PlayerRespawnSubscriber.INSTANCE.call(player);
    }

    private static final void _init_$lambda$10(PlayerEvent.Clone it) {
        Player player = it.getOriginal();
        Intrinsics.checkNotNullExpressionValue((Object)player, (String)"getOriginal(...)");
        Player player2 = it.getEntity();
        Intrinsics.checkNotNullExpressionValue((Object)player2, (String)"getEntity(...)");
        PlayerCloneSubscriber.INSTANCE.call(player, player2);
    }

    private static final void _init_$lambda$11(PlayerInteractEvent.RightClickBlock it) {
        Player player = it.getEntity();
        Intrinsics.checkNotNullExpressionValue((Object)player, (String)"getEntity(...)");
        Level level = it.getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)level, (String)"getLevel(...)");
        BlockPos blockPos = it.getPos();
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"getPos(...)");
        InteractionHand interactionHand = it.getHand();
        Intrinsics.checkNotNullExpressionValue((Object)interactionHand, (String)"getHand(...)");
        BlockHitResult blockHitResult = it.getHitVec();
        Intrinsics.checkNotNullExpressionValue((Object)blockHitResult, (String)"getHitVec(...)");
        PlayerRightClickInteractSubscriber.INSTANCE.call(player, level, blockPos, interactionHand, blockHitResult);
    }

    private static final void _init_$lambda$12(ServerTickEvent.Post it) {
        MinecraftServer minecraftServer = it.getServer();
        Intrinsics.checkNotNullExpressionValue((Object)minecraftServer, (String)"getServer(...)");
        ServerTickSubscriber.INSTANCE.call(minecraftServer);
    }

    private static final void _init_$lambda$13(ServerStartedEvent it) {
        MinecraftServer minecraftServer = it.getServer();
        Intrinsics.checkNotNullExpressionValue((Object)minecraftServer, (String)"getServer(...)");
        ServerStartSubscriber.INSTANCE.call(minecraftServer);
    }

    private static final void _init_$lambda$14(EntityJoinLevelEvent it) {
        Entity entity = it.getEntity();
        Intrinsics.checkNotNullExpressionValue((Object)entity, (String)"getEntity(...)");
        Intrinsics.checkNotNull((Object)it);
        EntitySpawnSubscriber.INSTANCE.call(entity, new CancelProxy((Function1)new Function1<Boolean, Unit>((Object)it){

            public final void invoke(boolean p0) {
                ((EntityJoinLevelEvent)this.receiver).setCanceled(p0);
            }
        }, (Function0)new Function0<Boolean>((Object)it){

            public final Boolean invoke() {
                return ((EntityJoinLevelEvent)this.receiver).isCanceled();
            }
        }));
    }

    private static final void _init_$lambda$15(BlockEvent.EntityPlaceEvent it) {
        BlockPos blockPos = it.getPos();
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"getPos(...)");
        LevelAccessor levelAccessor = it.getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)levelAccessor, (String)"getLevel(...)");
        Entity entity = it.getEntity();
        BlockState blockState = it.getState();
        Intrinsics.checkNotNullExpressionValue((Object)blockState, (String)"getState(...)");
        Intrinsics.checkNotNull((Object)it);
        EntityPlaceSubscriber.INSTANCE.call(blockPos, levelAccessor, entity, blockState, new CancelProxy((Function1)new Function1<Boolean, Unit>((Object)it){

            public final void invoke(boolean p0) {
                ((BlockEvent.EntityPlaceEvent)this.receiver).setCanceled(p0);
            }
        }, (Function0)new Function0<Boolean>((Object)it){

            public final Boolean invoke() {
                return ((BlockEvent.EntityPlaceEvent)this.receiver).isCanceled();
            }
        }));
    }

    private static final void _init_$lambda$16(AttackEntityEvent it) {
        Entity entity = it.getTarget();
        Intrinsics.checkNotNullExpressionValue((Object)entity, (String)"getTarget(...)");
        Player player = it.getEntity();
        Intrinsics.checkNotNullExpressionValue((Object)player, (String)"getEntity(...)");
        AttackEntitySubscriber.INSTANCE.call(entity, player);
    }

    private static final void _init_$lambda$17(BlockDropsEvent it) {
        ServerLevel serverLevel = it.getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
        Level level = (Level)serverLevel;
        BlockPos blockPos = it.getPos();
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"getPos(...)");
        BlockState blockState = it.getState();
        Intrinsics.checkNotNullExpressionValue((Object)blockState, (String)"getState(...)");
        BlockBreakSubscriber.INSTANCE.call(level, blockPos, blockState, it.getBreaker());
    }

    private static final void _init_$lambda$18(ServerChatEvent it) {
        ServerPlayer serverPlayer = it.getPlayer();
        Intrinsics.checkNotNullExpressionValue((Object)serverPlayer, (String)"getPlayer(...)");
        String string = it.getRawText();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getRawText(...)");
        Intrinsics.checkNotNull((Object)it);
        ServerChatSubscriber.INSTANCE.call(serverPlayer, string, new CancelProxy((Function1)new Function1<Boolean, Unit>((Object)it){

            public final void invoke(boolean p0) {
                ((ServerChatEvent)this.receiver).setCanceled(p0);
            }
        }, (Function0)new Function0<Boolean>((Object)it){

            public final Boolean invoke() {
                return ((ServerChatEvent)this.receiver).isCanceled();
            }
        }));
    }

    private static final void _init_$lambda$19(RegisterCommandsEvent it) {
        CommandDispatcher commandDispatcher = it.getDispatcher();
        Intrinsics.checkNotNullExpressionValue((Object)commandDispatcher, (String)"getDispatcher(...)");
        CommandBuildContext commandBuildContext = it.getBuildContext();
        Intrinsics.checkNotNullExpressionValue((Object)commandBuildContext, (String)"getBuildContext(...)");
        Commands.CommandSelection commandSelection = it.getCommandSelection();
        Intrinsics.checkNotNullExpressionValue((Object)commandSelection, (String)"getCommandSelection(...)");
        TBSCommands.INSTANCE.register((CommandDispatcher<CommandSourceStack>)commandDispatcher, commandBuildContext, commandSelection);
    }

    private static final void _init_$lambda$20(LivingDeathEvent it) {
        LivingEntity livingEntity = it.getEntity();
        Intrinsics.checkNotNullExpressionValue((Object)livingEntity, (String)"getEntity(...)");
        DamageSource damageSource = it.getSource();
        Intrinsics.checkNotNullExpressionValue((Object)damageSource, (String)"getSource(...)");
        LivingDeathSubscriber.INSTANCE.call(livingEntity, damageSource);
    }

    private static final void _init_$lambda$21(ServerStoppedEvent it) {
        MinecraftServer minecraftServer = it.getServer();
        Intrinsics.checkNotNullExpressionValue((Object)minecraftServer, (String)"getServer(...)");
        ServerStopSubscriber.INSTANCE.call(minecraftServer);
    }

    private static final void _init_$lambda$22(ItemAttributeModifierEvent it) {
        ItemStack itemStack = it.getItemStack();
        Intrinsics.checkNotNullExpressionValue((Object)itemStack, (String)"getItemStack(...)");
        Intrinsics.checkNotNull((Object)it);
        ItemAttributeModifierSubscriber.INSTANCE.call(itemStack, (Function2<? super Holder<Attribute>, ? super ResourceLocation, Unit>)((Function2)new Function2<Holder<Attribute>, ResourceLocation, Unit>((Object)it){

            public final void invoke(Holder<Attribute> p0, ResourceLocation p1) {
                ((ItemAttributeModifierEvent)this.receiver).removeModifier(p0, p1);
            }
        }), (Function3<? super Holder<Attribute>, ? super AttributeModifier, ? super EquipmentSlotGroup, Unit>)((Function3)new Function3<Holder<Attribute>, AttributeModifier, EquipmentSlotGroup, Unit>((Object)it){

            public final void invoke(Holder<Attribute> p0, AttributeModifier p1, EquipmentSlotGroup p2) {
                ((ItemAttributeModifierEvent)this.receiver).addModifier(p0, p1, p2);
            }
        }));
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\u0002\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/neoforge/TBSNeoForge$Companion;", "", "<init>", "()V", "nostalgiaGenSource", "Lnet/minecraft/server/packs/repository/PackSource;", "kotlin.jvm.PlatformType", "thebrokenscript-neoforge"})
    public static final class Companion {
        private Companion() {
        }

        private final PackSource nostalgiaGenSource() {
            return PackSource.create(UnaryOperator.identity(), (boolean)TBSConfigs.INSTANCE.getServer().getWorld().getAllowOldWorldGen());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

