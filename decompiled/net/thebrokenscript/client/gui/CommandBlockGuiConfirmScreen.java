/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Font
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.components.Button
 *  net.minecraft.client.gui.components.events.GuiEventListener
 *  net.minecraft.client.gui.screens.inventory.AbstractContainerScreen
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.core.BlockPos
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.FormattedText
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.player.Inventory
 *  net.minecraft.world.inventory.AbstractContainerMenu
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.thebrokenscript.brokencore.api.network.PacketSender
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.client.gui;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.block.CorruptedCommandBlockConfirmPayload;
import net.thebrokenscript.brokencore.api.network.PacketSender;
import net.thebrokenscript.registry.TBSPackets;
import net.thebrokenscript.world.inventory.CommandBlockGuiMenu;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J(\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0014J \u0010\u0018\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J2\u0010\u0019\u001a\u00020\r*\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011J \u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0016J\b\u0010#\u001a\u00020\rH\u0014\u00a8\u0006%"}, d2={"Lnet/thebrokenscript/client/gui/CommandBlockGuiConfirmScreen;", "Lnet/minecraft/client/gui/screens/inventory/AbstractContainerScreen;", "Lnet/thebrokenscript/world/inventory/CommandBlockGuiMenu;", "container", "inventory", "Lnet/minecraft/world/entity/player/Inventory;", "text", "Lnet/minecraft/network/chat/Component;", "<init>", "(Lnet/thebrokenscript/world/inventory/CommandBlockGuiMenu;Lnet/minecraft/world/entity/player/Inventory;Lnet/minecraft/network/chat/Component;)V", "isPauseScreen", "", "render", "", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "mouseX", "", "mouseY", "partialTicks", "", "renderBg", "gx", "gy", "renderLabels", "drawCenteredStringNoShadow", "font", "Lnet/minecraft/client/gui/Font;", "x", "y", "color", "keyPressed", "key", "b", "c", "init", "Companion", "thebrokenscript-common"})
public final class CommandBlockGuiConfirmScreen
extends AbstractContainerScreen<CommandBlockGuiMenu> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final ResourceLocation texture = TBSConstants.id("textures/screens/command_block_confirm_gui.png");

    public CommandBlockGuiConfirmScreen(@NotNull CommandBlockGuiMenu container, @NotNull Inventory inventory, @NotNull Component text) {
        Intrinsics.checkNotNullParameter((Object)((Object)container), (String)"container");
        Intrinsics.checkNotNullParameter((Object)inventory, (String)"inventory");
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        super((AbstractContainerMenu)container, inventory, text);
        this.imageWidth = 252;
        this.imageHeight = 252;
    }

    public boolean isPauseScreen() {
        return false;
    }

    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    protected void renderBg(@NotNull GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        guiGraphics.blit(texture, this.leftPos, this.topPos, 0.0f, 0.0f, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
        MutableComponent text1 = Component.translatable((String)"gui.thebrokenscript.command.confirm.header_1");
        MutableComponent text2 = Component.translatable((String)"gui.thebrokenscript.command.confirm.header_2");
        guiGraphics.drawCenteredString(this.font, (Component)text1, this.leftPos + 125, this.topPos + 100, -12451840);
        guiGraphics.drawCenteredString(this.font, (Component)text2, this.leftPos + 125, this.topPos + 110, -12451840);
    }

    protected void renderLabels(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
    }

    public final void drawCenteredStringNoShadow(@NotNull GuiGraphics $this$drawCenteredStringNoShadow, @NotNull Font font, @NotNull Component text, int x, int y, int color) {
        Intrinsics.checkNotNullParameter((Object)$this$drawCenteredStringNoShadow, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)font, (String)"font");
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        $this$drawCenteredStringNoShadow.drawString(font, text, x - font.width((FormattedText)text) / 2, y, color, false);
    }

    public boolean keyPressed(int key, int b, int c) {
        if (key == 256) {
            Minecraft minecraft = this.minecraft;
            Intrinsics.checkNotNull((Object)minecraft);
            LocalPlayer localPlayer = minecraft.player;
            Intrinsics.checkNotNull((Object)localPlayer);
            localPlayer.closeContainer();
            return true;
        }
        return super.keyPressed(key, b, c);
    }

    protected void init() {
        super.init();
        Level level = ((CommandBlockGuiMenu)this.menu).getInv().player.level();
        Intrinsics.checkNotNullExpressionValue((Object)level, (String)"level(...)");
        BlockPos blockPos = LevelExt.INSTANCE.getVars((LevelAccessor)level).getCommandBlockLocation();
        this.addRenderableWidget((GuiEventListener)Button.builder((Component)((Component)Component.translatable((String)"gui.thebrokenscript.pc_gui.button_confirm_execute")), arg_0 -> CommandBlockGuiConfirmScreen.init$lambda$0(blockPos, this, arg_0)).bounds(this.leftPos + 83, this.topPos + 150, 80, 27).build());
    }

    private static final void init$lambda$0(BlockPos $blockPos, CommandBlockGuiConfirmScreen this$0, Button it) {
        block0: {
            PacketSender.INSTANCE.sendToServer((CustomPacketPayload)TBSPackets.CORRUPTED_COMMAND_CONFIRM_PACKET.of(new CorruptedCommandBlockConfirmPayload($blockPos)), new CustomPacketPayload[0]);
            Minecraft minecraft = this$0.minecraft;
            if (minecraft == null || (minecraft = minecraft.player) == null) break block0;
            minecraft.closeContainer();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/client/gui/CommandBlockGuiConfirmScreen$Companion;", "", "<init>", "()V", "texture", "Lnet/minecraft/resources/ResourceLocation;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

