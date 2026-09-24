/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.math.Axis
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.DeltaTracker
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.LayeredDraw$Layer
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.AABB
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.misc.MorseCode
 *  net.thebrokenscript.brokencore.api.render.CensorQuad
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.boss.integrity.FinalCutsceneHandler;
import net.thebrokenscript.boss.integrity.SubtitleOverlay;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.misc.MorseCode;
import net.thebrokenscript.brokencore.api.render.CensorQuad;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.client.overlay.IntegBossBar;
import net.thebrokenscript.client.overlay.JimmyBossBar;
import net.thebrokenscript.client.overlay.NoWayOutOverlay;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.data.MapVariables;
import net.thebrokenscript.entity.niw.NothingIsWatchingEntity;
import net.thebrokenscript.registry.TBSDimensions;
import org.jetbrains.annotations.NotNull;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/client/TBSOverlayLayer;", "Lnet/minecraft/client/gui/LayeredDraw$Layer;", "<init>", "()V", "render", "", "gg", "Lnet/minecraft/client/gui/GuiGraphics;", "deltaTracker", "Lnet/minecraft/client/DeltaTracker;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nTBSOverlayLayer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TBSOverlayLayer.kt\nnet/thebrokenscript/client/TBSOverlayLayer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,106:1\n808#2,11:107\n*S KotlinDebug\n*F\n+ 1 TBSOverlayLayer.kt\nnet/thebrokenscript/client/TBSOverlayLayer\n*L\n52#1:107,11\n*E\n"})
public final class TBSOverlayLayer
implements LayeredDraw.Layer {
    @NotNull
    public static final TBSOverlayLayer INSTANCE = new TBSOverlayLayer();

    private TBSOverlayLayer() {
    }

    /*
     * WARNING - void declaration
     */
    public void render(@NotNull GuiGraphics gg, @NotNull DeltaTracker deltaTracker) {
        Intrinsics.checkNotNullParameter((Object)gg, (String)"gg");
        Intrinsics.checkNotNullParameter((Object)deltaTracker, (String)"deltaTracker");
        Minecraft mc = Minecraft.getInstance();
        int w = gg.guiWidth();
        int h = gg.guiHeight();
        SubtitleOverlay.INSTANCE.render(gg);
        RenderSystem.enableBlend();
        NoWayOutOverlay.INSTANCE.render(gg, w, h);
        IntegBossBar.INSTANCE.render(gg);
        JimmyBossBar.INSTANCE.render(gg);
        PoseStack pose = gg.pose();
        if (!mc.gui.getDebugOverlay().showDebugScreen() && !mc.options.hideGui && TBSConfigs.INSTANCE.getClient().getEnableHudText()) {
            pose.pushPose();
            pose.scale(0.5f, 0.5f, 0.5f);
            pose.translate(4.0f, (float)gg.guiWidth() - 60.0f, 0.0f);
            pose.mulPose(Axis.ZN.rotationDegrees(90.0f));
            gg.drawCenteredString(mc.font, MorseCode.INSTANCE.translate("NOWAYOUT"), 0, 0, 0x33333344);
            pose.popPose();
        }
        LocalPlayer localPlayer = mc.player;
        if (localPlayer != null) {
            void $this$filterIsInstanceTo$iv$iv;
            LocalPlayer it = localPlayer;
            boolean bl = false;
            Iterable iterable = it.clientLevel.entitiesForRendering();
            Intrinsics.checkNotNullExpressionValue((Object)iterable, (String)"entitiesForRendering(...)");
            Iterable $this$filterIsInstance$iv = iterable;
            boolean $i$f$filterIsInstance = false;
            Iterable iterable2 = $this$filterIsInstance$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterIsInstanceTo = false;
            for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
                if (!(element$iv$iv instanceof NothingIsWatchingEntity)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            List niws = (List)destination$iv$iv;
            for (NothingIsWatchingEntity entity : niws) {
                AABB aABB = entity.getBoundingBox().move(it.position().add(0.0, it.getBoundingBox().getYsize() - 0.5, 0.0).toVector3f().negate());
                Intrinsics.checkNotNullExpressionValue((Object)aABB, (String)"move(...)");
                CensorQuad.INSTANCE.render(gg, aABB, TBSConstants.id("textures/entities/null.png"), 16, 0, 80.0);
            }
            Object object = mc.level;
            if (object == null || (object = LevelExt.INSTANCE.getVars((LevelAccessor)object)) == null) {
                return;
            }
            Object vars = object;
            ClientLevel clientLevel = mc.level;
            if (clientLevel == null || (clientLevel = clientLevel.random) == null) {
                return;
            }
            ClientLevel random = clientLevel;
            if (!mc.gui.getDebugOverlay().showDebugScreen() && !mc.options.hideGui && TBSConfigs.INSTANCE.getClient().getEnableHudText()) {
                if (Intrinsics.areEqual((Object)it.level().dimension(), TBSDimensions.PROTECTED_VOID) && it.getY() > 102.0) {
                    v5 = gg.drawString(mc.font, "?", 5, 5, 0xFFFFFF);
                } else if (Intrinsics.areEqual((Object)it.level().dimension(), TBSDimensions.CORRUPTED_MOON)) {
                    v5 = gg.drawString(mc.font, "err.themoon", 5, 5, 0xFFFFFF);
                } else if (((MapVariables)((Object)vars)).getHasSiluetSpawned() && (double)random.nextFloat() < 0.85) {
                    v5 = gg.drawString(mc.font, "Here I am", 5, 5, 0xFFFFFF);
                } else if (((MapVariables)((Object)vars)).getHasNullSpawned()) {
                    v5 = gg.drawString(mc.font, "<o>", 5, 5, 0xFFFFFF);
                } else if (PlayerExt.INSTANCE.getVars((Player)it).getShowCoords()) {
                    ClientLevel clientLevel2 = ClientDSLKt.getMC().level;
                    Intrinsics.checkNotNull((Object)clientLevel2);
                    int fixedX = Math.floorDiv(LevelExt.INSTANCE.getVars((LevelAccessor)clientLevel2).getStoneFloorX(), 16) * 16 + 8;
                    ClientLevel clientLevel3 = ClientDSLKt.getMC().level;
                    Intrinsics.checkNotNull((Object)clientLevel3);
                    int fixedZ = Math.floorDiv(LevelExt.INSTANCE.getVars((LevelAccessor)clientLevel3).getStoneFloorZ(), 16) * 16 + 8;
                    String coords = fixedX + " 231 " + fixedZ;
                    v5 = gg.drawString(mc.font, "Clan_Void " + coords, 5, 5, 0xFFFFFF);
                } else {
                    v5 = gg.drawString(mc.font, "Minecraft 1.12.2", 5, 5, 0xFFFFFF);
                }
            }
        }
        if (FinalCutsceneHandler.CUTSCENE.getBlackout()) {
            gg.fill(0, 0, w, h, -16777216);
        }
        RenderSystem.disableBlend();
    }
}

