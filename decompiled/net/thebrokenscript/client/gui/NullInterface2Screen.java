/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.screens.inventory.AbstractContainerScreen
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.player.Inventory
 *  net.minecraft.world.inventory.AbstractContainerMenu
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.client.gui;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.world.inventory.NullInterface2Menu;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J(\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0014J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000fH\u0016J \u0010\u001b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014\u00a8\u0006\u001d"}, d2={"Lnet/thebrokenscript/client/gui/NullInterface2Screen;", "Lnet/minecraft/client/gui/screens/inventory/AbstractContainerScreen;", "Lnet/thebrokenscript/world/inventory/NullInterface2Menu;", "container", "inventory", "Lnet/minecraft/world/entity/player/Inventory;", "text", "Lnet/minecraft/network/chat/Component;", "<init>", "(Lnet/thebrokenscript/world/inventory/NullInterface2Menu;Lnet/minecraft/world/entity/player/Inventory;Lnet/minecraft/network/chat/Component;)V", "render", "", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "mouseX", "", "mouseY", "partialTicks", "", "renderBg", "gx", "gy", "keyPressed", "", "key", "b", "c", "renderLabels", "Companion", "thebrokenscript-common"})
public final class NullInterface2Screen
extends AbstractContainerScreen<NullInterface2Menu> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final ResourceLocation texture = TBSConstants.id("textures/screens/null_interface_2.png");

    public NullInterface2Screen(@NotNull NullInterface2Menu container, @NotNull Inventory inventory, @NotNull Component text) {
        Intrinsics.checkNotNullParameter((Object)((Object)container), (String)"container");
        Intrinsics.checkNotNullParameter((Object)inventory, (String)"inventory");
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        super((AbstractContainerMenu)container, inventory, text);
        this.imageWidth = 176;
        this.imageHeight = 166;
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

    protected void renderLabels(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        MutableComponent nullText = Component.literal((String)"null");
        guiGraphics.drawString(this.font, (Component)nullText, 6, 7, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 42, 7, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 78, 7, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 114, 7, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 150, 7, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 6, 25, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 42, 25, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 78, 25, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 114, 25, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 150, 25, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 6, 43, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 42, 43, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 78, 43, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 114, 43, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 150, 43, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 6, 61, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 42, 61, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 78, 61, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 114, 61, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 150, 61, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 6, 79, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 42, 79, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 78, 79, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 114, 79, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 150, 79, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 6, 97, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 42, 97, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 78, 97, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 114, 97, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 150, 97, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 6, 115, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 42, 115, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 78, 115, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 114, 115, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 150, 115, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 6, 133, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 42, 133, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 78, 133, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 114, 133, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 150, 133, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 6, 151, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 42, 151, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 78, 151, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 114, 151, 12764100, false);
        guiGraphics.drawString(this.font, (Component)nullText, 150, 151, 12764100, false);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/client/gui/NullInterface2Screen$Companion;", "", "<init>", "()V", "texture", "Lnet/minecraft/resources/ResourceLocation;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

