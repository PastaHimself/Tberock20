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
 *  net.minecraft.client.gui.components.EditBox
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
 *  net.minecraft.world.entity.player.Player
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
import net.minecraft.client.gui.components.EditBox;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.block.CorruptedCommandBlockPayload;
import net.thebrokenscript.brokencore.api.network.PacketSender;
import net.thebrokenscript.data.MapVariables;
import net.thebrokenscript.registry.TBSPackets;
import net.thebrokenscript.world.inventory.CommandBlockGuiMenu;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00018B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J(\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0016J(\u0010#\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u0011H\u0014J \u0010&\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0011H\u0014J2\u0010'\u001a\u00020\u001c*\u00020\u001e2\u0006\u0010(\u001a\u00020)2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u0011J\b\u0010-\u001a\u00020\u001cH\u0014J \u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u00112\u0006\u00101\u001a\u00020\u0011H\u0016J \u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u0011H\u0016J\b\u00107\u001a\u00020\u001cH\u0014R\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015\u00a8\u00069"}, d2={"Lnet/thebrokenscript/client/gui/CommandBlockGuiScreen;", "Lnet/minecraft/client/gui/screens/inventory/AbstractContainerScreen;", "Lnet/thebrokenscript/world/inventory/CommandBlockGuiMenu;", "container", "inventory", "Lnet/minecraft/world/entity/player/Inventory;", "text", "Lnet/minecraft/network/chat/Component;", "<init>", "(Lnet/thebrokenscript/world/inventory/CommandBlockGuiMenu;Lnet/minecraft/world/entity/player/Inventory;Lnet/minecraft/network/chat/Component;)V", "command", "Lnet/minecraft/client/gui/components/EditBox;", "getCommand", "()Lnet/minecraft/client/gui/components/EditBox;", "setCommand", "(Lnet/minecraft/client/gui/components/EditBox;)V", "timer", "", "getTimer", "()I", "setTimer", "(I)V", "glitchTicks", "getGlitchTicks", "setGlitchTicks", "isPauseScreen", "", "render", "", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "mouseX", "mouseY", "partialTicks", "", "renderBg", "gx", "gy", "renderLabels", "drawCenteredStringNoShadow", "font", "Lnet/minecraft/client/gui/Font;", "x", "y", "color", "containerTick", "keyPressed", "key", "b", "c", "resize", "minecraft", "Lnet/minecraft/client/Minecraft;", "width", "height", "init", "Companion", "thebrokenscript-common"})
public final class CommandBlockGuiScreen
extends AbstractContainerScreen<CommandBlockGuiMenu> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public EditBox command;
    private int timer;
    private int glitchTicks;
    @NotNull
    private static final ResourceLocation texture = TBSConstants.id("textures/screens/command_block_gui.png");
    public static final float GLITCH_CHANCE = 0.005f;
    public static final int GLITCH_DURATION = 35;
    public static final int GLITCH_SWAP_INTERVAL = 10;

    public CommandBlockGuiScreen(@NotNull CommandBlockGuiMenu container, @NotNull Inventory inventory, @NotNull Component text) {
        Intrinsics.checkNotNullParameter((Object)((Object)container), (String)"container");
        Intrinsics.checkNotNullParameter((Object)inventory, (String)"inventory");
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        super((AbstractContainerMenu)container, inventory, text);
        this.imageWidth = 300;
        this.imageHeight = 166;
    }

    @NotNull
    public final EditBox getCommand() {
        EditBox editBox = this.command;
        if (editBox != null) {
            return editBox;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"command");
        return null;
    }

    public final void setCommand(@NotNull EditBox editBox) {
        Intrinsics.checkNotNullParameter((Object)editBox, (String)"<set-?>");
        this.command = editBox;
    }

    public final int getTimer() {
        return this.timer;
    }

    public final void setTimer(int n) {
        this.timer = n;
    }

    public final int getGlitchTicks() {
        return this.glitchTicks;
    }

    public final void setGlitchTicks(int n) {
        this.glitchTicks = n;
    }

    public boolean isPauseScreen() {
        return false;
    }

    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.getCommand().render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    protected void renderBg(@NotNull GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        guiGraphics.blit(texture, this.leftPos, this.topPos, 0.0f, 0.0f, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
        MutableComponent text = this.timer > 0 ? (this.glitchTicks / (10 - this.font.random.nextInt(3, 6)) % 2 == 0 ? Component.translatable((String)"gui.thebrokenscript.command.header1") : Component.translatable((String)"gui.thebrokenscript.command.header2")) : Component.translatable((String)"gui.thebrokenscript.command.header");
        Font font = this.font;
        Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
        Intrinsics.checkNotNull((Object)text);
        this.drawCenteredStringNoShadow(guiGraphics, font, (Component)text, this.leftPos + 95, this.topPos + 100, -16777216);
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

    protected void containerTick() {
        super.containerTick();
        if (this.timer == 0 && this.font.random.nextFloat() < 0.005f) {
            this.timer = 35;
            this.glitchTicks = 0;
        }
        if (this.timer > 0) {
            int n = this.timer;
            this.timer = n + -1;
            n = this.glitchTicks;
            this.glitchTicks = n + 1;
        }
        this.getCommand().setSuggestion(Component.translatable((String)"gui.thebrokenscript.pc_gui.pcline1").getString());
        this.getCommand().setMaxLength(Short.MAX_VALUE);
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
        if (this.getCommand().isFocused()) {
            return this.getCommand().keyPressed(key, b, c);
        }
        return super.keyPressed(key, b, c);
    }

    public void resize(@NotNull Minecraft minecraft, int width, int height) {
        Intrinsics.checkNotNullParameter((Object)minecraft, (String)"minecraft");
        String pclineValue = this.getCommand().getValue();
        super.resize(minecraft, width, height);
        this.getCommand().setValue(pclineValue);
    }

    protected void init() {
        super.init();
        this.setCommand(new EditBox(this.font, this.leftPos + 100, this.topPos + 60, 118, 18, (Component)Component.translatable((String)"gui.thebrokenscript.pc_gui.pcline1")));
        this.getCommand().setSuggestion(Component.translatable((String)"gui.thebrokenscript.pc_gui.pcline1").getString());
        this.getCommand().setMaxLength(Short.MAX_VALUE);
        Level level = ((CommandBlockGuiMenu)this.menu).getInv().player.level();
        Intrinsics.checkNotNullExpressionValue((Object)level, (String)"level(...)");
        BlockPos blockPos = LevelExt.INSTANCE.getVars((LevelAccessor)level).getCommandBlockLocation();
        this.addWidget((GuiEventListener)this.getCommand());
        this.addRenderableWidget((GuiEventListener)Button.builder((Component)((Component)Component.translatable((String)"gui.thebrokenscript.pc_gui.button_execute")), arg_0 -> CommandBlockGuiScreen.init$lambda$0(this, blockPos, arg_0)).bounds(this.leftPos + 150, this.topPos + 20, 61, 20).build());
    }

    private static final void init$lambda$0(CommandBlockGuiScreen this$0, BlockPos $blockPos, Button it) {
        Object object;
        if (Intrinsics.areEqual((Object)this$0.getCommand().getValue(), (object = this$0.minecraft) != null && (object = ((Minecraft)object).level) != null && (object = LevelExt.INSTANCE.getVars((LevelAccessor)object)) != null ? ((MapVariables)((Object)object)).getCode() : null)) {
            String string = this$0.getCommand().getValue();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getValue(...)");
            PacketSender.INSTANCE.sendToServer((CustomPacketPayload)TBSPackets.CORRUPTED_COMMAND_PACKET.of(new CorruptedCommandBlockPayload(string, $blockPos)), new CustomPacketPayload[0]);
            PacketSender.INSTANCE.sendToServer((CustomPacketPayload)TBSPackets.INVENTORY_CORRUPTION_PROGRESS, new CustomPacketPayload[0]);
            Minecraft minecraft = this$0.minecraft;
            Intrinsics.checkNotNull((Object)minecraft);
            LocalPlayer localPlayer = minecraft.player;
            Intrinsics.checkNotNull((Object)localPlayer);
            localPlayer.closeContainer();
            Minecraft minecraft2 = this$0.minecraft;
            Intrinsics.checkNotNull((Object)minecraft2);
            LocalPlayer localPlayer2 = minecraft2.player;
            Intrinsics.checkNotNull((Object)localPlayer2);
            PlayerExt.INSTANCE.trySetWindowTitle((Player)localPlayer2, "success.command.applied");
        } else {
            this$0.getCommand().setValue("err.invalid.code");
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/client/gui/CommandBlockGuiScreen$Companion;", "", "<init>", "()V", "texture", "Lnet/minecraft/resources/ResourceLocation;", "GLITCH_CHANCE", "", "GLITCH_DURATION", "", "GLITCH_SWAP_INTERVAL", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

