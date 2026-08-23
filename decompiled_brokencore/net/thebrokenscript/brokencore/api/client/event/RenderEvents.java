/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Camera
 *  net.minecraft.client.DeltaTracker
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.renderer.LevelRenderer
 *  net.minecraft.client.renderer.RenderBuffers
 *  net.minecraft.client.renderer.culling.Frustum
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Matrix4f
 *  org.joml.Vector3f
 */
package net.thebrokenscript.brokencore.api.client.event;

import com.mojang.blaze3d.vertex.PoseStack;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.RenderBuffers;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.thebrokenscript.brokencore.api.client.event.RenderStage;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.event.Cancelable;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.brokencore.impl.mixin.client.features.post.LevelRendererAccessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Vector3f;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0004\t\n\u000b\fB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents;", "", "<init>", "()V", "LEVEL_STAGE", "Lnet/thebrokenscript/brokencore/api/event/GameEvent;", "Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$LevelStageData;", "POST_RENDER", "Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$PostRender;", "PostRender", "PostRenderData", "LevelStageData", "Hud", "brokencore-common"})
public final class RenderEvents {
    @NotNull
    public static final RenderEvents INSTANCE = new RenderEvents();
    @JvmField
    @NotNull
    public static final GameEvent<LevelStageData> LEVEL_STAGE = new GameEvent();
    @JvmField
    @NotNull
    public static final GameEvent<PostRender> POST_RENDER = new GameEvent();

    private RenderEvents() {
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001:\t\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$Hud;", "", "<init>", "()V", "CROSSHAIR", "Lnet/thebrokenscript/brokencore/api/event/GameEvent;", "Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$Hud$CrosshairData;", "ATTACK_INDICATOR", "Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$Hud$AttackIndicatorData;", "ARMOR", "Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$Hud$ArmorData;", "Background", "Potion", "CrosshairData", "AttackIndicatorData", "Experience", "Heart", "HotbarItems", "ArmorData", "Hunger", "brokencore-common"})
    public static final class Hud {
        @NotNull
        public static final Hud INSTANCE = new Hud();
        @JvmField
        @NotNull
        public static final GameEvent<CrosshairData> CROSSHAIR = new GameEvent();
        @JvmField
        @NotNull
        public static final GameEvent<AttackIndicatorData> ATTACK_INDICATOR = new GameEvent();
        @JvmField
        @NotNull
        public static final GameEvent<ArmorData> ARMOR = new GameEvent();

        private Hud() {
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0016\u0018\u00002\u00020\u0001BK\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u001a\u0010\f\u001a\u00020\rX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006\u001e"}, d2={"Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$Hud$ArmorData;", "Lnet/thebrokenscript/brokencore/api/event/Cancelable;", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "player", "Lnet/minecraft/world/entity/player/Player;", "x", "", "y", "heartRows", "height", "index", "canceled", "", "<init>", "(Lnet/minecraft/client/gui/GuiGraphics;Lnet/minecraft/world/entity/player/Player;IIIIIZ)V", "getGuiGraphics", "()Lnet/minecraft/client/gui/GuiGraphics;", "getPlayer", "()Lnet/minecraft/world/entity/player/Player;", "getX", "()I", "getY", "getHeartRows", "getHeight", "getIndex", "getCanceled", "()Z", "setCanceled", "(Z)V", "brokencore-common"})
        public static class ArmorData
        implements Cancelable {
            @NotNull
            private final GuiGraphics guiGraphics;
            @NotNull
            private final Player player;
            private final int x;
            private final int y;
            private final int heartRows;
            private final int height;
            private final int index;
            private boolean canceled;

            @JvmOverloads
            public ArmorData(@NotNull GuiGraphics guiGraphics, @NotNull Player player, int x, int y, int heartRows, int height, int index, boolean canceled) {
                Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
                Intrinsics.checkNotNullParameter((Object)player, (String)"player");
                this.guiGraphics = guiGraphics;
                this.player = player;
                this.x = x;
                this.y = y;
                this.heartRows = heartRows;
                this.height = height;
                this.index = index;
                this.canceled = canceled;
            }

            public /* synthetic */ ArmorData(GuiGraphics guiGraphics, Player player, int n, int n2, int n3, int n4, int n5, boolean bl, int n6, DefaultConstructorMarker defaultConstructorMarker) {
                if ((n6 & 0x80) != 0) {
                    bl = false;
                }
                this(guiGraphics, player, n, n2, n3, n4, n5, bl);
            }

            @NotNull
            public final GuiGraphics getGuiGraphics() {
                return this.guiGraphics;
            }

            @NotNull
            public final Player getPlayer() {
                return this.player;
            }

            public final int getX() {
                return this.x;
            }

            public final int getY() {
                return this.y;
            }

            public final int getHeartRows() {
                return this.heartRows;
            }

            public final int getHeight() {
                return this.height;
            }

            public final int getIndex() {
                return this.index;
            }

            @Override
            public boolean getCanceled() {
                return this.canceled;
            }

            @Override
            public void setCanceled(boolean bl) {
                this.canceled = bl;
            }

            @JvmOverloads
            public ArmorData(@NotNull GuiGraphics guiGraphics, @NotNull Player player, int x, int y, int heartRows, int height, int index) {
                Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
                Intrinsics.checkNotNullParameter((Object)player, (String)"player");
                this(guiGraphics, player, x, y, heartRows, height, index, false, 128, null);
            }
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B3\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0011R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\n\u001a\u00020\u0007X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0017"}, d2={"Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$Hud$AttackIndicatorData;", "Lnet/thebrokenscript/brokencore/api/event/Cancelable;", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "deltaTracker", "Lnet/minecraft/client/DeltaTracker;", "isHotbar", "", "progress", "", "canceled", "<init>", "(Lnet/minecraft/client/gui/GuiGraphics;Lnet/minecraft/client/DeltaTracker;ZFZ)V", "getGuiGraphics", "()Lnet/minecraft/client/gui/GuiGraphics;", "getDeltaTracker", "()Lnet/minecraft/client/DeltaTracker;", "()Z", "getProgress", "()F", "getCanceled", "setCanceled", "(Z)V", "brokencore-common"})
        public static class AttackIndicatorData
        implements Cancelable {
            @NotNull
            private final GuiGraphics guiGraphics;
            @NotNull
            private final DeltaTracker deltaTracker;
            private final boolean isHotbar;
            private final float progress;
            private boolean canceled;

            @JvmOverloads
            public AttackIndicatorData(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker, boolean isHotbar, float progress, boolean canceled) {
                Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
                Intrinsics.checkNotNullParameter((Object)deltaTracker, (String)"deltaTracker");
                this.guiGraphics = guiGraphics;
                this.deltaTracker = deltaTracker;
                this.isHotbar = isHotbar;
                this.progress = progress;
                this.canceled = canceled;
            }

            public /* synthetic */ AttackIndicatorData(GuiGraphics guiGraphics, DeltaTracker deltaTracker, boolean bl, float f, boolean bl2, int n, DefaultConstructorMarker defaultConstructorMarker) {
                if ((n & 0x10) != 0) {
                    bl2 = false;
                }
                this(guiGraphics, deltaTracker, bl, f, bl2);
            }

            @NotNull
            public final GuiGraphics getGuiGraphics() {
                return this.guiGraphics;
            }

            @NotNull
            public final DeltaTracker getDeltaTracker() {
                return this.deltaTracker;
            }

            public final boolean isHotbar() {
                return this.isHotbar;
            }

            public final float getProgress() {
                return this.progress;
            }

            @Override
            public boolean getCanceled() {
                return this.canceled;
            }

            @Override
            public void setCanceled(boolean bl) {
                this.canceled = bl;
            }

            @JvmOverloads
            public AttackIndicatorData(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker, boolean isHotbar, float progress) {
                Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
                Intrinsics.checkNotNullParameter((Object)deltaTracker, (String)"deltaTracker");
                this(guiGraphics, deltaTracker, isHotbar, progress, false, 16, null);
            }
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$Hud$Background;", "", "<init>", "()V", "HOTBAR", "Lnet/thebrokenscript/brokencore/api/event/GameEvent;", "Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$Hud$Background$BackgroundData;", "HIGHLIGHT", "OFFHAND", "BackgroundData", "brokencore-common"})
        public static final class Background {
            @NotNull
            public static final Background INSTANCE = new Background();
            @JvmField
            @NotNull
            public static final GameEvent<BackgroundData> HOTBAR = new GameEvent();
            @JvmField
            @NotNull
            public static final GameEvent<BackgroundData> HIGHLIGHT = new GameEvent();
            @JvmField
            @NotNull
            public static final GameEvent<BackgroundData> OFFHAND = new GameEvent();

            private Background() {
            }

            @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\u0007X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0010\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$Hud$Background$BackgroundData;", "Lnet/thebrokenscript/brokencore/api/event/Cancelable;", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "highlightIndex", "", "offhandIsLeftHand", "", "canceled", "<init>", "(Lnet/minecraft/client/gui/GuiGraphics;IZZ)V", "getGuiGraphics", "()Lnet/minecraft/client/gui/GuiGraphics;", "getHighlightIndex", "()I", "getOffhandIsLeftHand", "()Z", "getCanceled", "setCanceled", "(Z)V", "brokencore-common"})
            public static class BackgroundData
            implements Cancelable {
                @NotNull
                private final GuiGraphics guiGraphics;
                private final int highlightIndex;
                private final boolean offhandIsLeftHand;
                private boolean canceled;

                @JvmOverloads
                public BackgroundData(@NotNull GuiGraphics guiGraphics, int highlightIndex, boolean offhandIsLeftHand, boolean canceled) {
                    Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
                    this.guiGraphics = guiGraphics;
                    this.highlightIndex = highlightIndex;
                    this.offhandIsLeftHand = offhandIsLeftHand;
                    this.canceled = canceled;
                }

                public /* synthetic */ BackgroundData(GuiGraphics guiGraphics, int n, boolean bl, boolean bl2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
                    if ((n2 & 8) != 0) {
                        bl2 = false;
                    }
                    this(guiGraphics, n, bl, bl2);
                }

                @NotNull
                public final GuiGraphics getGuiGraphics() {
                    return this.guiGraphics;
                }

                public final int getHighlightIndex() {
                    return this.highlightIndex;
                }

                public final boolean getOffhandIsLeftHand() {
                    return this.offhandIsLeftHand;
                }

                @Override
                public boolean getCanceled() {
                    return this.canceled;
                }

                @Override
                public void setCanceled(boolean bl) {
                    this.canceled = bl;
                }

                @JvmOverloads
                public BackgroundData(@NotNull GuiGraphics guiGraphics, int highlightIndex, boolean offhandIsLeftHand) {
                    Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
                    this(guiGraphics, highlightIndex, offhandIsLeftHand, false, 8, null);
                }
            }
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B3\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001a\u0010\t\u001a\u00020\nX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0018"}, d2={"Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$Hud$CrosshairData;", "Lnet/thebrokenscript/brokencore/api/event/Cancelable;", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "deltaTracker", "Lnet/minecraft/client/DeltaTracker;", "x", "", "y", "canceled", "", "<init>", "(Lnet/minecraft/client/gui/GuiGraphics;Lnet/minecraft/client/DeltaTracker;IIZ)V", "getGuiGraphics", "()Lnet/minecraft/client/gui/GuiGraphics;", "getDeltaTracker", "()Lnet/minecraft/client/DeltaTracker;", "getX", "()I", "getY", "getCanceled", "()Z", "setCanceled", "(Z)V", "brokencore-common"})
        public static class CrosshairData
        implements Cancelable {
            @NotNull
            private final GuiGraphics guiGraphics;
            @NotNull
            private final DeltaTracker deltaTracker;
            private final int x;
            private final int y;
            private boolean canceled;

            @JvmOverloads
            public CrosshairData(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker, int x, int y, boolean canceled) {
                Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
                Intrinsics.checkNotNullParameter((Object)deltaTracker, (String)"deltaTracker");
                this.guiGraphics = guiGraphics;
                this.deltaTracker = deltaTracker;
                this.x = x;
                this.y = y;
                this.canceled = canceled;
            }

            public /* synthetic */ CrosshairData(GuiGraphics guiGraphics, DeltaTracker deltaTracker, int n, int n2, boolean bl, int n3, DefaultConstructorMarker defaultConstructorMarker) {
                if ((n3 & 0x10) != 0) {
                    bl = false;
                }
                this(guiGraphics, deltaTracker, n, n2, bl);
            }

            @NotNull
            public final GuiGraphics getGuiGraphics() {
                return this.guiGraphics;
            }

            @NotNull
            public final DeltaTracker getDeltaTracker() {
                return this.deltaTracker;
            }

            public final int getX() {
                return this.x;
            }

            public final int getY() {
                return this.y;
            }

            @Override
            public boolean getCanceled() {
                return this.canceled;
            }

            @Override
            public void setCanceled(boolean bl) {
                this.canceled = bl;
            }

            @JvmOverloads
            public CrosshairData(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker, int x, int y) {
                Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
                Intrinsics.checkNotNullParameter((Object)deltaTracker, (String)"deltaTracker");
                this(guiGraphics, deltaTracker, x, y, false, 16, null);
            }
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$Hud$Experience;", "", "<init>", "()V", "LEVEL", "Lnet/thebrokenscript/brokencore/api/event/GameEvent;", "Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$Hud$Experience$ExperienceData;", "BAR", "ExperienceData", "brokencore-common"})
        public static final class Experience {
            @NotNull
            public static final Experience INSTANCE = new Experience();
            @JvmField
            @NotNull
            public static final GameEvent<ExperienceData> LEVEL = new GameEvent();
            @JvmField
            @NotNull
            public static final GameEvent<ExperienceData> BAR = new GameEvent();

            private Experience() {
            }

            @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u00020\tX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$Hud$Experience$ExperienceData;", "Lnet/thebrokenscript/brokencore/api/event/Cancelable;", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "level", "", "progress", "", "canceled", "", "<init>", "(Lnet/minecraft/client/gui/GuiGraphics;IFZ)V", "getGuiGraphics", "()Lnet/minecraft/client/gui/GuiGraphics;", "getLevel", "()I", "getProgress", "()F", "getCanceled", "()Z", "setCanceled", "(Z)V", "brokencore-common"})
            public static class ExperienceData
            implements Cancelable {
                @NotNull
                private final GuiGraphics guiGraphics;
                private final int level;
                private final float progress;
                private boolean canceled;

                @JvmOverloads
                public ExperienceData(@NotNull GuiGraphics guiGraphics, int level, float progress, boolean canceled) {
                    Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
                    this.guiGraphics = guiGraphics;
                    this.level = level;
                    this.progress = progress;
                    this.canceled = canceled;
                }

                public /* synthetic */ ExperienceData(GuiGraphics guiGraphics, int n, float f, boolean bl, int n2, DefaultConstructorMarker defaultConstructorMarker) {
                    if ((n2 & 8) != 0) {
                        bl = false;
                    }
                    this(guiGraphics, n, f, bl);
                }

                @NotNull
                public final GuiGraphics getGuiGraphics() {
                    return this.guiGraphics;
                }

                public final int getLevel() {
                    return this.level;
                }

                public final float getProgress() {
                    return this.progress;
                }

                @Override
                public boolean getCanceled() {
                    return this.canceled;
                }

                @Override
                public void setCanceled(boolean bl) {
                    this.canceled = bl;
                }

                @JvmOverloads
                public ExperienceData(@NotNull GuiGraphics guiGraphics, int level, float progress) {
                    Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
                    this(guiGraphics, level, progress, false, 8, null);
                }
            }
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$Hud$Heart;", "", "<init>", "()V", "CONTAINER", "Lnet/thebrokenscript/brokencore/api/event/GameEvent;", "Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$Hud$Heart$HeartData;", "ABSORPTION", "HEARTS", "HeartData", "brokencore-common"})
        public static final class Heart {
            @NotNull
            public static final Heart INSTANCE = new Heart();
            @JvmField
            @NotNull
            public static final GameEvent<HeartData> CONTAINER = new GameEvent();
            @JvmField
            @NotNull
            public static final GameEvent<HeartData> ABSORPTION = new GameEvent();
            @JvmField
            @NotNull
            public static final GameEvent<HeartData> HEARTS = new GameEvent();

            private Heart() {
            }

            @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0016\u0018\u00002\u00020\u0001Bs\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\u000f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001a\u0010\u0013\u001a\u00020\u0012X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010&\"\u0004\b(\u0010)\u00a8\u0006*"}, d2={"Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$Hud$Heart$HeartData;", "Lnet/thebrokenscript/brokencore/api/event/Cancelable;", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "heartIndex", "", "player", "Lnet/minecraft/world/entity/player/Player;", "x", "y", "height", "offsetHeartIndex", "maxHealth", "", "currentHealth", "displayHealth", "absorptionAmount", "renderHighlight", "", "canceled", "<init>", "(Lnet/minecraft/client/gui/GuiGraphics;ILnet/minecraft/world/entity/player/Player;IIIIFIIIZZ)V", "getGuiGraphics", "()Lnet/minecraft/client/gui/GuiGraphics;", "getHeartIndex", "()I", "getPlayer", "()Lnet/minecraft/world/entity/player/Player;", "getX", "getY", "getHeight", "getOffsetHeartIndex", "getMaxHealth", "()F", "getCurrentHealth", "getDisplayHealth", "getAbsorptionAmount", "getRenderHighlight", "()Z", "getCanceled", "setCanceled", "(Z)V", "brokencore-common"})
            public static class HeartData
            implements Cancelable {
                @NotNull
                private final GuiGraphics guiGraphics;
                private final int heartIndex;
                @NotNull
                private final Player player;
                private final int x;
                private final int y;
                private final int height;
                private final int offsetHeartIndex;
                private final float maxHealth;
                private final int currentHealth;
                private final int displayHealth;
                private final int absorptionAmount;
                private final boolean renderHighlight;
                private boolean canceled;

                @JvmOverloads
                public HeartData(@NotNull GuiGraphics guiGraphics, int heartIndex, @NotNull Player player, int x, int y, int height, int offsetHeartIndex, float maxHealth, int currentHealth, int displayHealth, int absorptionAmount, boolean renderHighlight, boolean canceled) {
                    Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
                    Intrinsics.checkNotNullParameter((Object)player, (String)"player");
                    this.guiGraphics = guiGraphics;
                    this.heartIndex = heartIndex;
                    this.player = player;
                    this.x = x;
                    this.y = y;
                    this.height = height;
                    this.offsetHeartIndex = offsetHeartIndex;
                    this.maxHealth = maxHealth;
                    this.currentHealth = currentHealth;
                    this.displayHealth = displayHealth;
                    this.absorptionAmount = absorptionAmount;
                    this.renderHighlight = renderHighlight;
                    this.canceled = canceled;
                }

                public /* synthetic */ HeartData(GuiGraphics guiGraphics, int n, Player player, int n2, int n3, int n4, int n5, float f, int n6, int n7, int n8, boolean bl, boolean bl2, int n9, DefaultConstructorMarker defaultConstructorMarker) {
                    if ((n9 & 0x1000) != 0) {
                        bl2 = false;
                    }
                    this(guiGraphics, n, player, n2, n3, n4, n5, f, n6, n7, n8, bl, bl2);
                }

                @NotNull
                public final GuiGraphics getGuiGraphics() {
                    return this.guiGraphics;
                }

                public final int getHeartIndex() {
                    return this.heartIndex;
                }

                @NotNull
                public final Player getPlayer() {
                    return this.player;
                }

                public final int getX() {
                    return this.x;
                }

                public final int getY() {
                    return this.y;
                }

                public final int getHeight() {
                    return this.height;
                }

                public final int getOffsetHeartIndex() {
                    return this.offsetHeartIndex;
                }

                public final float getMaxHealth() {
                    return this.maxHealth;
                }

                public final int getCurrentHealth() {
                    return this.currentHealth;
                }

                public final int getDisplayHealth() {
                    return this.displayHealth;
                }

                public final int getAbsorptionAmount() {
                    return this.absorptionAmount;
                }

                public final boolean getRenderHighlight() {
                    return this.renderHighlight;
                }

                @Override
                public boolean getCanceled() {
                    return this.canceled;
                }

                @Override
                public void setCanceled(boolean bl) {
                    this.canceled = bl;
                }

                @JvmOverloads
                public HeartData(@NotNull GuiGraphics guiGraphics, int heartIndex, @NotNull Player player, int x, int y, int height, int offsetHeartIndex, float maxHealth, int currentHealth, int displayHealth, int absorptionAmount, boolean renderHighlight) {
                    Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
                    Intrinsics.checkNotNullParameter((Object)player, (String)"player");
                    this(guiGraphics, heartIndex, player, x, y, height, offsetHeartIndex, maxHealth, currentHealth, displayHealth, absorptionAmount, renderHighlight, false, 4096, null);
                }
            }
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$Hud$HotbarItems;", "", "<init>", "()V", "MAIN_HAND_ITEM", "Lnet/thebrokenscript/brokencore/api/event/GameEvent;", "Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$Hud$HotbarItems$HotbarItemData;", "OFFHAND_ITEM", "HotbarItemData", "brokencore-common"})
        public static final class HotbarItems {
            @NotNull
            public static final HotbarItems INSTANCE = new HotbarItems();
            @JvmField
            @NotNull
            public static final GameEvent<HotbarItemData> MAIN_HAND_ITEM = new GameEvent();
            @JvmField
            @NotNull
            public static final GameEvent<HotbarItemData> OFFHAND_ITEM = new GameEvent();

            private HotbarItems() {
            }

            @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0016\u0018\u00002\u00020\u0001BK\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u000e\u001a\u00020\u000fX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006\""}, d2={"Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$Hud$HotbarItems$HotbarItemData;", "Lnet/thebrokenscript/brokencore/api/event/Cancelable;", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "player", "Lnet/minecraft/world/entity/player/Player;", "deltaTracker", "Lnet/minecraft/client/DeltaTracker;", "x", "", "y", "index", "itemStack", "Lnet/minecraft/world/item/ItemStack;", "canceled", "", "<init>", "(Lnet/minecraft/client/gui/GuiGraphics;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/client/DeltaTracker;IIILnet/minecraft/world/item/ItemStack;Z)V", "getGuiGraphics", "()Lnet/minecraft/client/gui/GuiGraphics;", "getPlayer", "()Lnet/minecraft/world/entity/player/Player;", "getDeltaTracker", "()Lnet/minecraft/client/DeltaTracker;", "getX", "()I", "getY", "getIndex", "getItemStack", "()Lnet/minecraft/world/item/ItemStack;", "getCanceled", "()Z", "setCanceled", "(Z)V", "brokencore-common"})
            public static class HotbarItemData
            implements Cancelable {
                @NotNull
                private final GuiGraphics guiGraphics;
                @NotNull
                private final Player player;
                @NotNull
                private final DeltaTracker deltaTracker;
                private final int x;
                private final int y;
                private final int index;
                @NotNull
                private final ItemStack itemStack;
                private boolean canceled;

                @JvmOverloads
                public HotbarItemData(@NotNull GuiGraphics guiGraphics, @NotNull Player player, @NotNull DeltaTracker deltaTracker, int x, int y, int index, @NotNull ItemStack itemStack, boolean canceled) {
                    Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
                    Intrinsics.checkNotNullParameter((Object)player, (String)"player");
                    Intrinsics.checkNotNullParameter((Object)deltaTracker, (String)"deltaTracker");
                    Intrinsics.checkNotNullParameter((Object)itemStack, (String)"itemStack");
                    this.guiGraphics = guiGraphics;
                    this.player = player;
                    this.deltaTracker = deltaTracker;
                    this.x = x;
                    this.y = y;
                    this.index = index;
                    this.itemStack = itemStack;
                    this.canceled = canceled;
                }

                public /* synthetic */ HotbarItemData(GuiGraphics guiGraphics, Player player, DeltaTracker deltaTracker, int n, int n2, int n3, ItemStack itemStack, boolean bl, int n4, DefaultConstructorMarker defaultConstructorMarker) {
                    if ((n4 & 0x80) != 0) {
                        bl = false;
                    }
                    this(guiGraphics, player, deltaTracker, n, n2, n3, itemStack, bl);
                }

                @NotNull
                public final GuiGraphics getGuiGraphics() {
                    return this.guiGraphics;
                }

                @NotNull
                public final Player getPlayer() {
                    return this.player;
                }

                @NotNull
                public final DeltaTracker getDeltaTracker() {
                    return this.deltaTracker;
                }

                public final int getX() {
                    return this.x;
                }

                public final int getY() {
                    return this.y;
                }

                public final int getIndex() {
                    return this.index;
                }

                @NotNull
                public final ItemStack getItemStack() {
                    return this.itemStack;
                }

                @Override
                public boolean getCanceled() {
                    return this.canceled;
                }

                @Override
                public void setCanceled(boolean bl) {
                    this.canceled = bl;
                }

                @JvmOverloads
                public HotbarItemData(@NotNull GuiGraphics guiGraphics, @NotNull Player player, @NotNull DeltaTracker deltaTracker, int x, int y, int index, @NotNull ItemStack itemStack) {
                    Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
                    Intrinsics.checkNotNullParameter((Object)player, (String)"player");
                    Intrinsics.checkNotNullParameter((Object)deltaTracker, (String)"deltaTracker");
                    Intrinsics.checkNotNullParameter((Object)itemStack, (String)"itemStack");
                    this(guiGraphics, player, deltaTracker, x, y, index, itemStack, false, 128, null);
                }
            }
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\b\tB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$Hud$Hunger;", "", "<init>", "()V", "CONTAINER", "Lnet/thebrokenscript/brokencore/api/event/GameEvent;", "Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$Hud$Hunger$HungerData;", "SHANK", "HungerData", "ShankType", "brokencore-common"})
        public static final class Hunger {
            @NotNull
            public static final Hunger INSTANCE = new Hunger();
            @JvmField
            @NotNull
            public static final GameEvent<HungerData> CONTAINER = new GameEvent();
            @JvmField
            @NotNull
            public static final GameEvent<HungerData> SHANK = new GameEvent();

            private Hunger() {
            }

            @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0016\u0018\u00002\u00020\u0001BC\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u00a2\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\f\u001a\u00020\nX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0017\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001c"}, d2={"Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$Hud$Hunger$HungerData;", "Lnet/thebrokenscript/brokencore/api/event/Cancelable;", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "x", "", "y", "type", "Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$Hud$Hunger$ShankType;", "hasHungerEffect", "", "index", "canceled", "<init>", "(Lnet/minecraft/client/gui/GuiGraphics;IILnet/thebrokenscript/brokencore/api/client/event/RenderEvents$Hud$Hunger$ShankType;ZIZ)V", "getGuiGraphics", "()Lnet/minecraft/client/gui/GuiGraphics;", "getX", "()I", "getY", "getType", "()Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$Hud$Hunger$ShankType;", "getHasHungerEffect", "()Z", "getIndex", "getCanceled", "setCanceled", "(Z)V", "brokencore-common"})
            public static class HungerData
            implements Cancelable {
                @NotNull
                private final GuiGraphics guiGraphics;
                private final int x;
                private final int y;
                @NotNull
                private final ShankType type;
                private final boolean hasHungerEffect;
                private final int index;
                private boolean canceled;

                @JvmOverloads
                public HungerData(@NotNull GuiGraphics guiGraphics, int x, int y, @NotNull ShankType type, boolean hasHungerEffect, int index, boolean canceled) {
                    Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
                    Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
                    this.guiGraphics = guiGraphics;
                    this.x = x;
                    this.y = y;
                    this.type = type;
                    this.hasHungerEffect = hasHungerEffect;
                    this.index = index;
                    this.canceled = canceled;
                }

                public /* synthetic */ HungerData(GuiGraphics guiGraphics, int n, int n2, ShankType shankType, boolean bl, int n3, boolean bl2, int n4, DefaultConstructorMarker defaultConstructorMarker) {
                    if ((n4 & 0x40) != 0) {
                        bl2 = false;
                    }
                    this(guiGraphics, n, n2, shankType, bl, n3, bl2);
                }

                @NotNull
                public final GuiGraphics getGuiGraphics() {
                    return this.guiGraphics;
                }

                public final int getX() {
                    return this.x;
                }

                public final int getY() {
                    return this.y;
                }

                @NotNull
                public final ShankType getType() {
                    return this.type;
                }

                public final boolean getHasHungerEffect() {
                    return this.hasHungerEffect;
                }

                public final int getIndex() {
                    return this.index;
                }

                @Override
                public boolean getCanceled() {
                    return this.canceled;
                }

                @Override
                public void setCanceled(boolean bl) {
                    this.canceled = bl;
                }

                @JvmOverloads
                public HungerData(@NotNull GuiGraphics guiGraphics, int x, int y, @NotNull ShankType type, boolean hasHungerEffect, int index) {
                    Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
                    Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
                    this(guiGraphics, x, y, type, hasHungerEffect, index, false, 64, null);
                }
            }

            @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$Hud$Hunger$ShankType;", "", "<init>", "(Ljava/lang/String;I)V", "CONTAINER", "HALF", "FULL", "brokencore-common"})
            public static final class ShankType
            extends Enum<ShankType> {
                public static final /* enum */ ShankType CONTAINER = new ShankType();
                public static final /* enum */ ShankType HALF = new ShankType();
                public static final /* enum */ ShankType FULL = new ShankType();
                private static final /* synthetic */ ShankType[] $VALUES;
                private static final /* synthetic */ EnumEntries $ENTRIES;

                public static ShankType[] values() {
                    return (ShankType[])$VALUES.clone();
                }

                public static ShankType valueOf(String value) {
                    return Enum.valueOf(ShankType.class, value);
                }

                @NotNull
                public static EnumEntries<ShankType> getEntries() {
                    return $ENTRIES;
                }

                static {
                    $VALUES = shankTypeArray = new ShankType[]{ShankType.CONTAINER, ShankType.HALF, ShankType.FULL};
                    $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
                }
            }
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$Hud$Potion;", "", "<init>", "()V", "BACKGROUND", "Lnet/thebrokenscript/brokencore/api/event/GameEvent;", "Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$Hud$Potion$PotionData;", "ICON", "PotionData", "brokencore-common"})
        public static final class Potion {
            @NotNull
            public static final Potion INSTANCE = new Potion();
            @JvmField
            @NotNull
            public static final GameEvent<PotionData> BACKGROUND = new GameEvent();
            @JvmField
            @NotNull
            public static final GameEvent<PotionData> ICON = new GameEvent();

            private Potion() {
            }

            @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001B-\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\u0007X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0010\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$Hud$Potion$PotionData;", "Lnet/thebrokenscript/brokencore/api/event/Cancelable;", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "effect", "Lnet/minecraft/world/effect/MobEffectInstance;", "ambient", "", "canceled", "<init>", "(Lnet/minecraft/client/gui/GuiGraphics;Lnet/minecraft/world/effect/MobEffectInstance;ZZ)V", "getGuiGraphics", "()Lnet/minecraft/client/gui/GuiGraphics;", "getEffect", "()Lnet/minecraft/world/effect/MobEffectInstance;", "getAmbient", "()Z", "getCanceled", "setCanceled", "(Z)V", "brokencore-common"})
            public static class PotionData
            implements Cancelable {
                @NotNull
                private final GuiGraphics guiGraphics;
                @Nullable
                private final MobEffectInstance effect;
                private final boolean ambient;
                private boolean canceled;

                @JvmOverloads
                public PotionData(@NotNull GuiGraphics guiGraphics, @Nullable MobEffectInstance effect, boolean ambient, boolean canceled) {
                    Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
                    this.guiGraphics = guiGraphics;
                    this.effect = effect;
                    this.ambient = ambient;
                    this.canceled = canceled;
                }

                public /* synthetic */ PotionData(GuiGraphics guiGraphics, MobEffectInstance mobEffectInstance, boolean bl, boolean bl2, int n, DefaultConstructorMarker defaultConstructorMarker) {
                    if ((n & 8) != 0) {
                        bl2 = false;
                    }
                    this(guiGraphics, mobEffectInstance, bl, bl2);
                }

                @NotNull
                public final GuiGraphics getGuiGraphics() {
                    return this.guiGraphics;
                }

                @Nullable
                public final MobEffectInstance getEffect() {
                    return this.effect;
                }

                public final boolean getAmbient() {
                    return this.ambient;
                }

                @Override
                public boolean getCanceled() {
                    return this.canceled;
                }

                @Override
                public void setCanceled(boolean bl) {
                    this.canceled = bl;
                }

                @JvmOverloads
                public PotionData(@NotNull GuiGraphics guiGraphics, @Nullable MobEffectInstance effect, boolean ambient) {
                    Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
                    this(guiGraphics, effect, ambient, false, 8, null);
                }
            }
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020'8F\u00a2\u0006\u0006\u001a\u0004\b(\u0010)\u00a8\u0006*"}, d2={"Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$LevelStageData;", "", "stage", "Lnet/thebrokenscript/brokencore/api/client/event/RenderStage;", "renderer", "Lnet/minecraft/client/renderer/LevelRenderer;", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "modelViewMat", "Lorg/joml/Matrix4f;", "projMat", "renderTick", "", "partialTick", "Lnet/minecraft/client/DeltaTracker;", "camera", "Lnet/minecraft/client/Camera;", "frustum", "Lnet/minecraft/client/renderer/culling/Frustum;", "<init>", "(Lnet/thebrokenscript/brokencore/api/client/event/RenderStage;Lnet/minecraft/client/renderer/LevelRenderer;Lcom/mojang/blaze3d/vertex/PoseStack;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;ILnet/minecraft/client/DeltaTracker;Lnet/minecraft/client/Camera;Lnet/minecraft/client/renderer/culling/Frustum;)V", "getStage", "()Lnet/thebrokenscript/brokencore/api/client/event/RenderStage;", "getRenderer", "()Lnet/minecraft/client/renderer/LevelRenderer;", "getPoseStack", "()Lcom/mojang/blaze3d/vertex/PoseStack;", "getModelViewMat", "()Lorg/joml/Matrix4f;", "getProjMat", "getRenderTick", "()I", "getPartialTick", "()Lnet/minecraft/client/DeltaTracker;", "getCamera", "()Lnet/minecraft/client/Camera;", "getFrustum", "()Lnet/minecraft/client/renderer/culling/Frustum;", "bufs", "Lnet/minecraft/client/renderer/RenderBuffers;", "getBufs", "()Lnet/minecraft/client/renderer/RenderBuffers;", "brokencore-common"})
    public static class LevelStageData {
        @NotNull
        private final RenderStage stage;
        @NotNull
        private final LevelRenderer renderer;
        @NotNull
        private final PoseStack poseStack;
        @NotNull
        private final Matrix4f modelViewMat;
        @NotNull
        private final Matrix4f projMat;
        private final int renderTick;
        @NotNull
        private final DeltaTracker partialTick;
        @NotNull
        private final Camera camera;
        @NotNull
        private final Frustum frustum;

        public LevelStageData(@NotNull RenderStage stage, @NotNull LevelRenderer renderer, @NotNull PoseStack poseStack, @NotNull Matrix4f modelViewMat, @NotNull Matrix4f projMat, int renderTick, @NotNull DeltaTracker partialTick, @NotNull Camera camera, @NotNull Frustum frustum) {
            Intrinsics.checkNotNullParameter((Object)((Object)stage), (String)"stage");
            Intrinsics.checkNotNullParameter((Object)renderer, (String)"renderer");
            Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
            Intrinsics.checkNotNullParameter((Object)modelViewMat, (String)"modelViewMat");
            Intrinsics.checkNotNullParameter((Object)projMat, (String)"projMat");
            Intrinsics.checkNotNullParameter((Object)partialTick, (String)"partialTick");
            Intrinsics.checkNotNullParameter((Object)camera, (String)"camera");
            Intrinsics.checkNotNullParameter((Object)frustum, (String)"frustum");
            this.stage = stage;
            this.renderer = renderer;
            this.poseStack = poseStack;
            this.modelViewMat = modelViewMat;
            this.projMat = projMat;
            this.renderTick = renderTick;
            this.partialTick = partialTick;
            this.camera = camera;
            this.frustum = frustum;
        }

        @NotNull
        public final RenderStage getStage() {
            return this.stage;
        }

        @NotNull
        public final LevelRenderer getRenderer() {
            return this.renderer;
        }

        @NotNull
        public final PoseStack getPoseStack() {
            return this.poseStack;
        }

        @NotNull
        public final Matrix4f getModelViewMat() {
            return this.modelViewMat;
        }

        @NotNull
        public final Matrix4f getProjMat() {
            return this.projMat;
        }

        public final int getRenderTick() {
            return this.renderTick;
        }

        @NotNull
        public final DeltaTracker getPartialTick() {
            return this.partialTick;
        }

        @NotNull
        public final Camera getCamera() {
            return this.camera;
        }

        @NotNull
        public final Frustum getFrustum() {
            return this.frustum;
        }

        @NotNull
        public final RenderBuffers getBufs() {
            LevelRenderer levelRenderer = this.renderer;
            Intrinsics.checkNotNull((Object)levelRenderer, (String)"null cannot be cast to non-null type net.thebrokenscript.brokencore.impl.mixin.client.features.post.LevelRendererAccessor");
            RenderBuffers renderBuffers = ((LevelRendererAccessor)levelRenderer).bc$renderBuffers();
            Intrinsics.checkNotNullExpressionValue((Object)renderBuffers, (String)"bc$renderBuffers(...)");
            return renderBuffers;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$PostRender;", "Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$PostRenderData;", "matrix4f", "Lorg/joml/Matrix4f;", "deltaTracker", "Lnet/minecraft/client/DeltaTracker;", "<init>", "(Lorg/joml/Matrix4f;Lnet/minecraft/client/DeltaTracker;)V", "brokencore-common"})
    public static final class PostRender
    extends PostRenderData {
        public PostRender(@NotNull Matrix4f matrix4f, @NotNull DeltaTracker deltaTracker) {
            Intrinsics.checkNotNullParameter((Object)matrix4f, (String)"matrix4f");
            Intrinsics.checkNotNullParameter((Object)deltaTracker, (String)"deltaTracker");
            Entity entity = ClientDSLKt.getMC().cameraEntity;
            if (entity == null || (entity = entity.position()) == null || (entity = entity.toVector3f()) == null) {
                entity = new Vector3f(0.0f);
            }
            super(matrix4f, deltaTracker, (Vector3f)entity);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$PostRenderData;", "", "matrix4f", "Lorg/joml/Matrix4f;", "deltaTracker", "Lnet/minecraft/client/DeltaTracker;", "cameraPosition", "Lorg/joml/Vector3f;", "<init>", "(Lorg/joml/Matrix4f;Lnet/minecraft/client/DeltaTracker;Lorg/joml/Vector3f;)V", "getMatrix4f", "()Lorg/joml/Matrix4f;", "getDeltaTracker", "()Lnet/minecraft/client/DeltaTracker;", "getCameraPosition", "()Lorg/joml/Vector3f;", "brokencore-common"})
    public static class PostRenderData {
        @NotNull
        private final Matrix4f matrix4f;
        @NotNull
        private final DeltaTracker deltaTracker;
        @NotNull
        private final Vector3f cameraPosition;

        public PostRenderData(@NotNull Matrix4f matrix4f, @NotNull DeltaTracker deltaTracker, @NotNull Vector3f cameraPosition) {
            Intrinsics.checkNotNullParameter((Object)matrix4f, (String)"matrix4f");
            Intrinsics.checkNotNullParameter((Object)deltaTracker, (String)"deltaTracker");
            Intrinsics.checkNotNullParameter((Object)cameraPosition, (String)"cameraPosition");
            this.matrix4f = matrix4f;
            this.deltaTracker = deltaTracker;
            this.cameraPosition = cameraPosition;
        }

        @NotNull
        public final Matrix4f getMatrix4f() {
            return this.matrix4f;
        }

        @NotNull
        public final DeltaTracker getDeltaTracker() {
            return this.deltaTracker;
        }

        @NotNull
        public final Vector3f getCameraPosition() {
            return this.cameraPosition;
        }
    }
}

