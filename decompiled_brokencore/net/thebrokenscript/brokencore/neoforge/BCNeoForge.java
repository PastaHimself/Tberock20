/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.CommandDispatcher
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.commands.CommandBuildContext
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.commands.Commands$CommandSelection
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.data.DataProvider
 *  net.minecraft.data.PackOutput
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 *  net.neoforged.bus.api.EventPriority
 *  net.neoforged.bus.api.IEventBus
 *  net.neoforged.fml.ModContainer
 *  net.neoforged.fml.ModList
 *  net.neoforged.fml.common.Mod
 *  net.neoforged.neoforge.common.NeoForge
 *  net.neoforged.neoforge.data.event.GatherDataEvent
 *  net.neoforged.neoforge.event.RegisterCommandsEvent
 *  net.neoforged.neoforge.event.ServerChatEvent
 *  net.neoforged.neoforge.event.entity.EntityJoinLevelEvent
 *  net.neoforged.neoforge.event.entity.EntityMountEvent
 *  net.neoforged.neoforge.event.entity.living.LivingUseTotemEvent
 *  net.neoforged.neoforge.event.entity.player.PlayerInteractEvent$EntityInteract
 *  net.neoforged.neoforge.event.entity.player.PlayerInteractEvent$RightClickItem
 *  net.neoforged.neoforge.event.server.ServerStartedEvent
 *  net.neoforged.neoforge.event.server.ServerStoppingEvent
 *  net.neoforged.neoforge.event.tick.ServerTickEvent$Post
 *  net.neoforged.neoforge.event.tick.ServerTickEvent$Pre
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.neoforge;

import com.mojang.brigadier.CommandDispatcher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.ServerChatEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.EntityMountEvent;
import net.neoforged.neoforge.event.entity.living.LivingUseTotemEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import net.neoforged.neoforge.event.server.ServerStoppingEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.thebrokenscript.brokencore.api.event.Cancelable;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.EntityEvents;
import net.thebrokenscript.brokencore.api.event.game.PlayerEvents;
import net.thebrokenscript.brokencore.api.event.game.RegistryEvents;
import net.thebrokenscript.brokencore.api.event.game.ServerEvents;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.brokencore.api.subs.LivingUseTotemSubscriber;
import net.thebrokenscript.brokencore.impl.BrokenCore;
import net.thebrokenscript.brokencore.impl.datagen.BCDataGen;
import net.thebrokenscript.brokencore.impl.event.StoryEvents;
import net.thebrokenscript.brokencore.impl.handlers.ServerChatHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

@Mod(value="brokencore")
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/brokencore/neoforge/BCNeoForge;", "", "modBus", "Lnet/neoforged/bus/api/IEventBus;", "<init>", "(Lnet/neoforged/bus/api/IEventBus;)V", "initialized", "", "getInitialized", "()Z", "setInitialized", "(Z)V", "Companion", "brokencore-neoforge"})
public final class BCNeoForge {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private boolean initialized;
    @JvmField
    @NotNull
    public static final Logger LOGGER;

    public BCNeoForge(@NotNull IEventBus modBus) {
        Intrinsics.checkNotNullParameter((Object)modBus, (String)"modBus");
        Object t = ModList.get().getModContainerById("brokencore").get();
        Intrinsics.checkNotNullExpressionValue(t, (String)"get(...)");
        ModContainer mod = (ModContainer)t;
        LOGGER.info("Initializing BrokenCore v" + mod.getModInfo().getVersion() + "...");
        if (!this.initialized) {
            this.initialized = true;
            BrokenCore.INSTANCE.init();
        }
        NeoForge.EVENT_BUS.addListener(ServerTickEvent.Post.class, BCNeoForge::_init_$lambda$0);
        NeoForge.EVENT_BUS.addListener(EventPriority.HIGHEST, ServerChatEvent.class, BCNeoForge::_init_$lambda$1);
        NeoForge.EVENT_BUS.addListener(RegisterCommandsEvent.class, BCNeoForge::_init_$lambda$2);
        NeoForge.EVENT_BUS.addListener(LivingUseTotemEvent.class, BCNeoForge::_init_$lambda$3);
        NeoForge.EVENT_BUS.addListener(ServerStartedEvent.class, BCNeoForge::_init_$lambda$4);
        NeoForge.EVENT_BUS.addListener(ServerStartedEvent.class, BCNeoForge::_init_$lambda$5);
        NeoForge.EVENT_BUS.addListener(ServerStoppingEvent.class, BCNeoForge::_init_$lambda$6);
        NeoForge.EVENT_BUS.addListener(ServerTickEvent.Pre.class, BCNeoForge::_init_$lambda$7);
        NeoForge.EVENT_BUS.addListener(ServerTickEvent.Post.class, BCNeoForge::_init_$lambda$8);
        NeoForge.EVENT_BUS.addListener(EntityMountEvent.class, BCNeoForge::_init_$lambda$9);
        NeoForge.EVENT_BUS.addListener(PlayerInteractEvent.EntityInteract.class, BCNeoForge::_init_$lambda$10);
        NeoForge.EVENT_BUS.addListener(EntityJoinLevelEvent.class, BCNeoForge::_init_$lambda$11);
        NeoForge.EVENT_BUS.addListener(PlayerInteractEvent.RightClickItem.class, BCNeoForge::_init_$lambda$12);
        modBus.addListener(GatherDataEvent.class, BCNeoForge::_init_$lambda$13);
        LOGGER.info("Completed initialization!");
    }

    public final boolean getInitialized() {
        return this.initialized;
    }

    public final void setInitialized(boolean bl) {
        this.initialized = bl;
    }

    private static final void _init_$lambda$0(ServerTickEvent.Post it) {
        MinecraftServer minecraftServer = it.getServer();
        Intrinsics.checkNotNullExpressionValue((Object)minecraftServer, (String)"getServer(...)");
        BrokenCore.INSTANCE.tick(minecraftServer);
    }

    private static final void _init_$lambda$1(ServerChatEvent it) {
        ServerPlayer serverPlayer = it.getPlayer();
        Intrinsics.checkNotNullExpressionValue((Object)serverPlayer, (String)"getPlayer(...)");
        String string = it.getRawText();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getRawText(...)");
        ServerChatHandler.INSTANCE.handle(serverPlayer, string);
    }

    private static final void _init_$lambda$2(RegisterCommandsEvent it) {
        CommandDispatcher commandDispatcher = it.getDispatcher();
        Intrinsics.checkNotNullExpressionValue((Object)commandDispatcher, (String)"getDispatcher(...)");
        Commands.CommandSelection commandSelection = it.getCommandSelection();
        Intrinsics.checkNotNullExpressionValue((Object)commandSelection, (String)"getCommandSelection(...)");
        CommandBuildContext commandBuildContext = it.getBuildContext();
        Intrinsics.checkNotNullExpressionValue((Object)commandBuildContext, (String)"getBuildContext(...)");
        GameEvent.Companion.call(RegistryEvents.REGISTER_COMMANDS, new RegistryEvents.RegisterCommands((CommandDispatcher<CommandSourceStack>)commandDispatcher, commandSelection, commandBuildContext));
    }

    private static final void _init_$lambda$3(LivingUseTotemEvent it) {
        LivingEntity livingEntity = it.getEntity();
        Intrinsics.checkNotNullExpressionValue((Object)livingEntity, (String)"getEntity(...)");
        DamageSource damageSource = it.getSource();
        Intrinsics.checkNotNullExpressionValue((Object)damageSource, (String)"getSource(...)");
        ItemStack itemStack = it.getTotem();
        Intrinsics.checkNotNullExpressionValue((Object)itemStack, (String)"getTotem(...)");
        InteractionHand interactionHand = it.getHandHolding();
        Intrinsics.checkNotNullExpressionValue((Object)interactionHand, (String)"getHandHolding(...)");
        Intrinsics.checkNotNull((Object)it);
        LivingUseTotemSubscriber.INSTANCE.call(livingEntity, damageSource, itemStack, interactionHand, new CancelProxy((Function1<? super Boolean, Unit>)((Function1)new Function1<Boolean, Unit>((Object)it){

            public final void invoke(boolean p0) {
                ((LivingUseTotemEvent)this.receiver).setCanceled(p0);
            }
        }), (Function0<Boolean>)((Function0)new Function0<Boolean>((Object)it){

            public final Boolean invoke() {
                return ((LivingUseTotemEvent)this.receiver).isCanceled();
            }
        })));
    }

    private static final void _init_$lambda$4(ServerStartedEvent it) {
        MinecraftServer minecraftServer = it.getServer();
        Intrinsics.checkNotNullExpressionValue((Object)minecraftServer, (String)"getServer(...)");
        StoryEvents.INSTANCE.serverStarting(minecraftServer);
    }

    private static final void _init_$lambda$5(ServerStartedEvent it) {
        MinecraftServer minecraftServer = it.getServer();
        Intrinsics.checkNotNullExpressionValue((Object)minecraftServer, (String)"getServer(...)");
        GameEvent.Companion.call(ServerEvents.START, new ServerEvents.Data(minecraftServer));
    }

    private static final void _init_$lambda$6(ServerStoppingEvent it) {
        MinecraftServer minecraftServer = it.getServer();
        Intrinsics.checkNotNullExpressionValue((Object)minecraftServer, (String)"getServer(...)");
        GameEvent.Companion.call(ServerEvents.STOP, new ServerEvents.Data(minecraftServer));
    }

    private static final void _init_$lambda$7(ServerTickEvent.Pre it) {
        MinecraftServer minecraftServer = it.getServer();
        Intrinsics.checkNotNullExpressionValue((Object)minecraftServer, (String)"getServer(...)");
        GameEvent.Companion.call(ServerEvents.TICK_START, new ServerEvents.Data(minecraftServer));
    }

    private static final void _init_$lambda$8(ServerTickEvent.Post it) {
        MinecraftServer minecraftServer = it.getServer();
        Intrinsics.checkNotNullExpressionValue((Object)minecraftServer, (String)"getServer(...)");
        GameEvent.Companion.call(ServerEvents.TICK_END, new ServerEvents.Data(minecraftServer));
    }

    private static final void _init_$lambda$9(EntityMountEvent it) {
        Entity entity = it.getEntityMounting();
        Intrinsics.checkNotNullExpressionValue((Object)entity, (String)"getEntityMounting(...)");
        Entity entity2 = it.getEntityBeingMounted();
        Intrinsics.checkNotNullExpressionValue((Object)entity2, (String)"getEntityBeingMounted(...)");
        Level level = it.getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)level, (String)"getLevel(...)");
        boolean cancel = GameEvent.Companion.callCancelable(EntityEvents.MOUNT, (Cancelable)new EntityEvents.Mount(entity, entity2, level, it.isMounting(), false, false, 48, null));
        if (cancel) {
            it.setCanceled(true);
        }
    }

    private static final void _init_$lambda$10(PlayerInteractEvent.EntityInteract it) {
        Player player = it.getEntity();
        Intrinsics.checkNotNullExpressionValue((Object)player, (String)"getEntity(...)");
        InteractionHand interactionHand = it.getHand();
        Intrinsics.checkNotNullExpressionValue((Object)interactionHand, (String)"getHand(...)");
        BlockPos blockPos = it.getPos();
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"getPos(...)");
        Direction direction = it.getFace();
        Entity entity = it.getTarget();
        Intrinsics.checkNotNullExpressionValue((Object)entity, (String)"getTarget(...)");
        boolean cancel = GameEvent.Companion.callCancelable(PlayerEvents.INTERACT_ENTITY, (Cancelable)new PlayerEvents.InteractEntity(player, interactionHand, blockPos, direction, entity, false, 32, null));
        if (cancel) {
            it.setCancellationResult(InteractionResult.FAIL);
        }
    }

    private static final void _init_$lambda$11(EntityJoinLevelEvent it) {
        Entity entity = it.getEntity();
        Intrinsics.checkNotNullExpressionValue((Object)entity, (String)"getEntity(...)");
        GameEvent.Companion.call(EntityEvents.SPAWN, new EntityEvents.Spawn(entity));
    }

    private static final void _init_$lambda$12(PlayerInteractEvent.RightClickItem it) {
        Player player = it.getEntity();
        Intrinsics.checkNotNullExpressionValue((Object)player, (String)"getEntity(...)");
        ItemStack itemStack = it.getItemStack();
        Intrinsics.checkNotNullExpressionValue((Object)itemStack, (String)"getItemStack(...)");
        boolean cancel = GameEvent.Companion.callCancelable(PlayerEvents.USE_ITEM, (Cancelable)new PlayerEvents.UseItem(player, itemStack, false, 4, null));
        if (cancel) {
            it.setCanceled(true);
        }
    }

    private static final void _init_$lambda$13(GatherDataEvent event) {
        PackOutput packOutput = event.getGenerator().getPackOutput();
        Intrinsics.checkNotNullExpressionValue((Object)packOutput, (String)"getPackOutput(...)");
        Intrinsics.checkNotNull((Object)event);
        BCDataGen.INSTANCE.register(packOutput, (Function1<? super DataProvider, Unit>)((Function1)new Function1<DataProvider, Unit>((Object)event){

            public final void invoke(DataProvider p0) {
                ((GatherDataEvent)this.receiver).addProvider(p0);
            }
        }));
    }

    static {
        Logger logger = LogManager.getLogger(BCNeoForge.class);
        Intrinsics.checkNotNullExpressionValue((Object)logger, (String)"getLogger(...)");
        LOGGER = logger;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/brokencore/neoforge/BCNeoForge$Companion;", "", "<init>", "()V", "LOGGER", "Lorg/apache/logging/log4j/Logger;", "brokencore-neoforge"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

