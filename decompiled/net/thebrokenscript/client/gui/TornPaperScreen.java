/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.math.Axis
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.screens.inventory.AbstractContainerScreen
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.player.Inventory
 *  net.minecraft.world.inventory.AbstractContainerMenu
 *  net.minecraft.world.level.LevelAccessor
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.client.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.LevelAccessor;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.world.inventory.TornPaperMenu;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J \u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011H\u0016\u00a8\u0006\u001a"}, d2={"Lnet/thebrokenscript/client/gui/TornPaperScreen;", "Lnet/minecraft/client/gui/screens/inventory/AbstractContainerScreen;", "Lnet/thebrokenscript/world/inventory/TornPaperMenu;", "container", "inventory", "Lnet/minecraft/world/entity/player/Inventory;", "text", "Lnet/minecraft/network/chat/Component;", "<init>", "(Lnet/thebrokenscript/world/inventory/TornPaperMenu;Lnet/minecraft/world/entity/player/Inventory;Lnet/minecraft/network/chat/Component;)V", "renderBg", "", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "mouseX", "", "mouseY", "", "partialTick", "renderLabels", "shouldCloseOnEsc", "", "mouseClicked", "", "button", "Companion", "thebrokenscript-common"})
public final class TornPaperScreen
extends AbstractContainerScreen<TornPaperMenu> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final ResourceLocation texture = TBSConstants.id("textures/screens/torn_paper.png");

    public TornPaperScreen(@NotNull TornPaperMenu container, @NotNull Inventory inventory, @NotNull Component text) {
        Intrinsics.checkNotNullParameter((Object)((Object)container), (String)"container");
        Intrinsics.checkNotNullParameter((Object)inventory, (String)"inventory");
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        super((AbstractContainerMenu)container, inventory, text);
        this.imageWidth = 942;
        this.imageHeight = 453;
    }

    protected void renderBg(@NotNull GuiGraphics guiGraphics, float mouseX, int mouseY, int partialTick) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        PoseStack pose = guiGraphics.pose();
        double guiScale = ClientDSLKt.getMC().getWindow().getGuiScale();
        float cx = (float)this.width / 2.0f;
        float cy = (float)this.height / 2.0f + (float)50;
        float scale = (float)((double)0.5f / guiScale);
        float textScale = (float)((double)2.15f / guiScale);
        pose.pushPose();
        pose.translate(cx, cy, 0.0f);
        pose.mulPose(Axis.ZP.rotationDegrees(15.0f));
        pose.scale(scale, scale, 1.0f);
        pose.translate(-471.0f, -471.0f, 0.0f);
        guiGraphics.blit(texture, 0, 0, 0.0f, 0.0f, 942, 453, this.imageWidth, this.imageHeight);
        pose.popPose();
        pose.pushPose();
        pose.translate(cx, cy, 0.0f);
        pose.mulPose(Axis.ZP.rotationDegrees(15.0f));
        pose.scale(textScale, textScale, 1.0f);
        if (ClientDSLKt.getMC().level != null) {
            ClientLevel clientLevel = ClientDSLKt.getMC().level;
            Intrinsics.checkNotNull((Object)clientLevel);
            int fixedX = Math.floorDiv(LevelExt.INSTANCE.getVars((LevelAccessor)clientLevel).getWoodenFloorX(), 16) * 16 + 8;
            ClientLevel clientLevel2 = ClientDSLKt.getMC().level;
            Intrinsics.checkNotNull((Object)clientLevel2);
            int fixedZ = Math.floorDiv(LevelExt.INSTANCE.getVars((LevelAccessor)clientLevel2).getWoodenFloorZ(), 16) * 16 + 8;
            String coords = "X: " + fixedX + "   Y: 216   Z: " + fixedZ;
            guiGraphics.drawString(this.font, coords, 0 - this.font.width(coords) / 2, -65, -16777216, false);
        }
        pose.popPose();
    }

    protected void renderLabels(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
    }

    public boolean shouldCloseOnEsc() {
        return true;
    }

    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 0) {
            this.onClose();
        }
        return true;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/client/gui/TornPaperScreen$Companion;", "", "<init>", "()V", "texture", "Lnet/minecraft/resources/ResourceLocation;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

