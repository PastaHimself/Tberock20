/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.components.Button
 *  net.minecraft.client.gui.components.events.GuiEventListener
 *  net.minecraft.client.gui.screens.inventory.AbstractContainerScreen
 *  net.minecraft.client.renderer.CubeMap
 *  net.minecraft.client.renderer.PanoramaRenderer
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.player.Inventory
 *  net.minecraft.world.inventory.AbstractContainerMenu
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.client.gui;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.CubeMap;
import net.minecraft.client.renderer.PanoramaRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.thebrokenscript.registry.TBSLang;
import net.thebrokenscript.world.inventory.FakeDisconnectMenu;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J(\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0011H\u0014J \u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J\b\u0010\u001b\u001a\u00020\u001cH\u0016J(\u0010\u001d\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u001e\u001a\u00020\rH\u0014J\b\u0010\u001f\u001a\u00020\u001cH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2={"Lnet/thebrokenscript/client/gui/FakeDisconnectScreen;", "Lnet/minecraft/client/gui/screens/inventory/AbstractContainerScreen;", "Lnet/thebrokenscript/world/inventory/FakeDisconnectMenu;", "container", "inventory", "Lnet/minecraft/world/entity/player/Inventory;", "text", "Lnet/minecraft/network/chat/Component;", "<init>", "(Lnet/thebrokenscript/world/inventory/FakeDisconnectMenu;Lnet/minecraft/world/entity/player/Inventory;Lnet/minecraft/network/chat/Component;)V", "panorama", "Lnet/minecraft/client/renderer/PanoramaRenderer;", "renderBackground", "", "graphics", "Lnet/minecraft/client/gui/GuiGraphics;", "mouseX", "", "mouseY", "partialTick", "", "renderBg", "p0", "p1", "p2", "p3", "renderLabels", "shouldCloseOnEsc", "", "render", "init", "isPauseScreen", "thebrokenscript-common"})
public final class FakeDisconnectScreen
extends AbstractContainerScreen<FakeDisconnectMenu> {
    @NotNull
    private final PanoramaRenderer panorama;

    public FakeDisconnectScreen(@NotNull FakeDisconnectMenu container, @NotNull Inventory inventory, @NotNull Component text) {
        Intrinsics.checkNotNullParameter((Object)((Object)container), (String)"container");
        Intrinsics.checkNotNullParameter((Object)inventory, (String)"inventory");
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        super((AbstractContainerMenu)container, inventory, text);
        this.panorama = new PanoramaRenderer(new CubeMap(ResourceLocation.withDefaultNamespace((String)"textures/gui/title/background/panorama")));
    }

    public void renderBackground(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        Intrinsics.checkNotNullParameter((Object)graphics, (String)"graphics");
        this.panorama.render(graphics, this.width, this.height, 1.0f, partialTick);
        graphics.blit(ResourceLocation.withDefaultNamespace((String)"textures/gui/title/background/panorama_overlay.png"), 0, 0, 0.0f, 0.0f, this.width, this.height, this.width, this.height);
    }

    protected void renderBg(@NotNull GuiGraphics p0, float p1, int p2, int p3) {
        Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
    }

    protected void renderLabels(@NotNull GuiGraphics graphics, int mouseX, int mouseY) {
        Intrinsics.checkNotNullParameter((Object)graphics, (String)"graphics");
    }

    public boolean shouldCloseOnEsc() {
        return false;
    }

    public void render(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        Intrinsics.checkNotNullParameter((Object)graphics, (String)"graphics");
        super.render(graphics, mouseX, mouseY, partialTick);
        graphics.drawCenteredString(this.font, (Component)TBSLang.INSTANCE.getDISCONNECTED_1(), this.width / 2, this.height / 2 - 50, 0xFFFFFF);
        graphics.drawCenteredString(this.font, this.title, this.width / 2, this.height / 2 - 20, 0xFFFFFF);
    }

    protected void init() {
        this.addRenderableWidget((GuiEventListener)Button.builder((Component)((Component)TBSLang.INSTANCE.getDISCONNECTED_3()), FakeDisconnectScreen::init$lambda$0).bounds(this.width / 2 - 100, this.height / 2 + 10, 200, 20).build());
    }

    public boolean isPauseScreen() {
        return false;
    }

    private static final void init$lambda$0(Button button) {
    }
}

