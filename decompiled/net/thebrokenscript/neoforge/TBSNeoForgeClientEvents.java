/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.LayeredDraw$Layer
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.multiplayer.MultiPlayerGameMode
 *  net.minecraft.client.particle.ParticleEngine$SpriteParticleRegistration
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.client.renderer.DimensionSpecialEffects
 *  net.minecraft.client.renderer.item.ItemProperties
 *  net.minecraft.core.Holder
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleType
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.FormattedText
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.util.FastColor$ARGB32
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.LevelAccessor
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.EventBusSubscriber
 *  net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
 *  net.neoforged.neoforge.client.event.ClientTickEvent$Post
 *  net.neoforged.neoforge.client.event.ClientTickEvent$Pre
 *  net.neoforged.neoforge.client.event.RegisterDimensionSpecialEffectsEvent
 *  net.neoforged.neoforge.client.event.RegisterGuiLayersEvent
 *  net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent
 *  net.neoforged.neoforge.client.event.RenderGuiLayerEvent$Pre
 *  net.neoforged.neoforge.client.gui.VanillaGuiLayers
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.neoforge;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.client.event.RenderGuiLayerEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.client.TBSClient;
import net.thebrokenscript.client.TBSOverlayLayer;
import net.thebrokenscript.client.debug.TBSDebugOverlays;
import net.thebrokenscript.client.overlay.HeartCorruptionOverlay;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.handlers.player.ClientPlayerChasingHandler;
import net.thebrokenscript.neoforge.TBSNeoDimensionEffects;
import net.thebrokenscript.registry.TBSDimensionFX;
import net.thebrokenscript.registry.TBSEffects;
import net.thebrokenscript.registry.TBSParticles;
import net.thebrokenscript.util.LimboSkyRenderer;
import net.thebrokenscript.util.MoonSkyRenderer;
import net.thebrokenscript.util.VoidSkyRenderer;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber(value={Dist.CLIENT})
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0011H\u0007J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0016H\u0007J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020#H\u0007J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\rH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00058@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006%"}, d2={"Lnet/thebrokenscript/neoforge/TBSNeoForgeClientEvents;", "", "<init>", "()V", "registeredLayers", "", "onClientTick", "", "event", "Lnet/neoforged/neoforge/client/event/ClientTickEvent$Post;", "registerGuiLayers", "Lnet/neoforged/neoforge/client/event/RegisterGuiLayersEvent;", "renderHeartCorruptionEffect", "Lnet/neoforged/neoforge/client/event/RenderGuiLayerEvent$Pre;", "registerDimensionFx", "Lnet/neoforged/neoforge/client/event/RegisterDimensionSpecialEffectsEvent;", "registerParticles", "Lnet/neoforged/neoforge/client/event/RegisterParticleProvidersEvent;", "isTargeted", "isTargeted$thebrokenscript_neoforge", "()Z", "onClientSetup", "Lnet/neoforged/fml/event/lifecycle/FMLClientSetupEvent;", "highlightTimer", "", "getHighlightTimer", "()I", "setHighlightTimer", "(I)V", "lastHighlightItem", "Lnet/minecraft/world/item/ItemStack;", "getLastHighlightItem", "()Lnet/minecraft/world/item/ItemStack;", "setLastHighlightItem", "(Lnet/minecraft/world/item/ItemStack;)V", "Lnet/neoforged/neoforge/client/event/ClientTickEvent$Pre;", "onRenderHotbarText", "thebrokenscript-neoforge"})
public final class TBSNeoForgeClientEvents {
    @NotNull
    public static final TBSNeoForgeClientEvents INSTANCE = new TBSNeoForgeClientEvents();
    private static boolean registeredLayers;
    private static int highlightTimer;
    @NotNull
    private static ItemStack lastHighlightItem;

    private TBSNeoForgeClientEvents() {
    }

    @JvmStatic
    @SubscribeEvent
    public static final void onClientTick(@NotNull ClientTickEvent.Post event) {
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        TBSClient.INSTANCE.getQueue().tick();
    }

    @JvmStatic
    @SubscribeEvent
    public static final void registerGuiLayers(@NotNull RegisterGuiLayersEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        if (registeredLayers) {
            return;
        }
        registeredLayers = true;
        event.registerAboveAll(TBSConstants.id("overlays"), (LayeredDraw.Layer)TBSOverlayLayer.INSTANCE);
        event.registerAboveAll(TBSConstants.id("debug_overlays"), (LayeredDraw.Layer)TBSDebugOverlays.INSTANCE);
    }

    @JvmStatic
    @SubscribeEvent
    public static final void renderHeartCorruptionEffect(@NotNull RenderGuiLayerEvent.Pre event) {
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        Player player = (Player)Minecraft.getInstance().player;
        if (Intrinsics.areEqual((Object)event.getName(), (Object)VanillaGuiLayers.PLAYER_HEALTH) && player != null && player.hasEffect((Holder)TBSEffects.HEART_CORRUPTION)) {
            event.setCanceled(true);
            GuiGraphics guiGraphics = event.getGuiGraphics();
            Intrinsics.checkNotNullExpressionValue((Object)guiGraphics, (String)"getGuiGraphics(...)");
            HeartCorruptionOverlay.INSTANCE.render(guiGraphics, player);
        }
    }

    @JvmStatic
    @SubscribeEvent
    public static final void registerDimensionFx(@NotNull RegisterDimensionSpecialEffectsEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        TBSDimensionFX.INSTANCE.register((Function2<? super ResourceLocation, ? super DimensionSpecialEffects, Unit>)((Function2)new Function2<ResourceLocation, DimensionSpecialEffects, Unit>((Object)event){

            public final void invoke(ResourceLocation p0, DimensionSpecialEffects p1) {
                ((RegisterDimensionSpecialEffectsEvent)this.receiver).register(p0, p1);
            }
        }), new TBSNeoDimensionEffects(new MoonSkyRenderer(), false, false, 6, null), new TBSNeoDimensionEffects(new LimboSkyRenderer(), true, false, 4, null), new TBSNeoDimensionEffects(new VoidSkyRenderer(), false, true, 2, null));
    }

    @JvmStatic
    @SubscribeEvent
    public static final void registerParticles(@NotNull RegisterParticleProvidersEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        TBSParticles.INSTANCE.register(new TBSParticles.Consumer(event){
            final /* synthetic */ RegisterParticleProvidersEvent $event;
            {
                this.$event = $event;
            }

            public <T extends ParticleOptions> void register(ParticleType<T> type, ParticleEngine.SpriteParticleRegistration<T> spriteSet) {
                Intrinsics.checkNotNullParameter(type, (String)"type");
                Intrinsics.checkNotNullParameter(spriteSet, (String)"spriteSet");
                this.$event.registerSpriteSet(type, spriteSet);
            }
        });
    }

    public final boolean isTargeted$thebrokenscript_neoforge() {
        return ClientPlayerChasingHandler.isBeingChased;
    }

    @JvmStatic
    @SubscribeEvent
    public static final void onClientSetup(@NotNull FMLClientSetupEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        event.enqueueWork(TBSNeoForgeClientEvents::onClientSetup$lambda$0);
    }

    public final int getHighlightTimer() {
        return highlightTimer;
    }

    public final void setHighlightTimer(int n) {
        highlightTimer = n;
    }

    @NotNull
    public final ItemStack getLastHighlightItem() {
        return lastHighlightItem;
    }

    public final void setLastHighlightItem(@NotNull ItemStack itemStack) {
        Intrinsics.checkNotNullParameter((Object)itemStack, (String)"<set-?>");
        lastHighlightItem = itemStack;
    }

    @JvmStatic
    @SubscribeEvent
    public static final void onClientTick(@NotNull ClientTickEvent.Pre event) {
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        LocalPlayer localPlayer = ClientDSLKt.getMC().player;
        if (localPlayer == null || (localPlayer = localPlayer.getMainHandItem()) == null) {
            return;
        }
        LocalPlayer held = localPlayer;
        if (!ItemStack.isSameItemSameComponents((ItemStack)held, (ItemStack)lastHighlightItem)) {
            if (!held.isEmpty()) {
                highlightTimer = 40;
            }
            ItemStack itemStack = held.copy();
            Intrinsics.checkNotNullExpressionValue((Object)itemStack, (String)"copy(...)");
            lastHighlightItem = itemStack;
        }
        if (highlightTimer > 0) {
            int n = highlightTimer;
            highlightTimer = n + -1;
        }
    }

    @JvmStatic
    @SubscribeEvent
    public static final void onRenderHotbarText(@NotNull RenderGuiLayerEvent.Pre event) {
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        if (!Intrinsics.areEqual((Object)event.getName(), (Object)VanillaGuiLayers.SELECTED_ITEM_NAME)) {
            return;
        }
        if (TBSConfigs.INSTANCE.getClient().getEnableHudText()) {
            return;
        }
        if (ClientDSLKt.getMC().options.hideGui) {
            return;
        }
        LocalPlayer localPlayer = ClientDSLKt.getMC().player;
        if (localPlayer == null) {
            return;
        }
        LocalPlayer player = localPlayer;
        if (!PlayerExt.INSTANCE.getVars((Player)player).getShowCoords()) {
            return;
        }
        event.setCanceled(true);
        if (highlightTimer <= 0) {
            return;
        }
        int alpha = RangesKt.coerceAtMost((int)((int)((float)highlightTimer * 256.0f / 10.0f)), (int)255);
        if (alpha <= 0) {
            return;
        }
        ClientLevel clientLevel = ClientDSLKt.getMC().level;
        if (clientLevel == null) {
            return;
        }
        ClientLevel level = clientLevel;
        int fixedX = Math.floorDiv(LevelExt.INSTANCE.getVars((LevelAccessor)level).getStoneFloorX(), 16) * 16 + 8;
        int fixedZ = Math.floorDiv(LevelExt.INSTANCE.getVars((LevelAccessor)level).getStoneFloorZ(), 16) * 16 + 8;
        MutableComponent coordText = Component.literal((String)(fixedX + " 231 " + fixedZ));
        GuiGraphics g = event.getGuiGraphics();
        int width = ClientDSLKt.getMC().font.width((FormattedText)coordText);
        int x = (g.guiWidth() - width) / 2;
        int n = g.guiHeight() - Math.max(Math.max(ClientDSLKt.getMC().gui.leftHeight, ClientDSLKt.getMC().gui.rightHeight), 59);
        MultiPlayerGameMode multiPlayerGameMode = ClientDSLKt.getMC().gameMode;
        Intrinsics.checkNotNull((Object)multiPlayerGameMode);
        int y = n + (!multiPlayerGameMode.canHurtPlayer() ? 14 : 0);
        g.drawStringWithBackdrop(ClientDSLKt.getMC().font, (Component)coordText, x, y, width, FastColor.ARGB32.color((int)alpha, (int)-1));
    }

    private static final void onClientSetup$lambda$0() {
        ItemProperties.register((Item)Items.TOTEM_OF_UNDYING, (ResourceLocation)TBSConstants.id("voided"), TBSNeoForgeClientEvents::onClientSetup$lambda$0$0);
    }

    private static final float onClientSetup$lambda$0$0(ItemStack itemStack, ClientLevel clientLevel, LivingEntity livingEntity, int n) {
        return INSTANCE.isTargeted$thebrokenscript_neoforge() ? 1.0f : 0.0f;
    }

    static {
        ItemStack itemStack = ItemStack.EMPTY;
        Intrinsics.checkNotNullExpressionValue((Object)itemStack, (String)"EMPTY");
        lastHighlightItem = itemStack;
    }
}

