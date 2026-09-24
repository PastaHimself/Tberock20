/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.math.Axis
 *  net.minecraft.client.gui.Font$DisplayMode
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.components.Button
 *  net.minecraft.client.gui.components.Button$Builder
 *  net.minecraft.client.gui.components.LogoRenderer
 *  net.minecraft.client.gui.components.PlainTextButton
 *  net.minecraft.client.gui.components.Renderable
 *  net.minecraft.client.gui.components.StringWidget
 *  net.minecraft.client.gui.components.events.GuiEventListener
 *  net.minecraft.client.gui.screens.Screen
 *  net.minecraft.client.gui.screens.TitleScreen
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.resources.language.I18n
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.FormattedText
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.util.RandomSource
 *  net.thebrokenscript.brokencore.api.platform.PlatformUtil
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyArg
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.mixins.features.screen;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.LogoRenderer;
import net.minecraft.client.gui.components.PlainTextButton;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.StringWidget;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.thebrokenscript.api.TBSMenuBackgrounds;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.config.client.MenuMode;
import net.thebrokenscript.mixins.features.screen.ScreenAccessor;
import net.thebrokenscript.registry.TBSLang;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={TitleScreen.class}, priority=900)
public class BaseTBSTitleScreenMixin
extends Screen {
    @Unique
    private static final ResourceLocation MINECRAFT_LOGO = ResourceLocation.parse((String)"textures/gui/title/minecraft.png");
    @Unique
    private static final Component theBrokenScript$VERSION = Component.translatable((String)TBSLang.INSTANCE.getTBS_VER().getString(), (Object[])new Object[]{PlatformUtil.Companion.getModVersion("thebrokenscript")});
    @Unique
    private final RandomSource tbs$random = RandomSource.create();
    @Unique
    private Button tbs$quitButton;
    @Unique
    private int tbs$quitButtonTimer;

    protected BaseTBSTitleScreenMixin(Component title) {
        super(title);
    }

    @WrapOperation(method={"init"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/components/Button$Builder;build()Lnet/minecraft/client/gui/components/Button;")})
    private Button tbs$disableQuitButton(Button.Builder instance, Operation<Button> original) {
        Button button = (Button)original.call(new Object[]{instance});
        String buttonText = button.getMessage().getString();
        if (buttonText.equals(I18n.get((String)"menu.quit", (Object[])new Object[0]))) {
            button.active = false;
            this.tbs$quitButton = button;
        }
        return button;
    }

    @Inject(method={"createNormalMenuOptions"}, at={@At(value="TAIL")})
    private void tbs$disableRealms(int y, int rowHeight, CallbackInfo ci) {
        for (GuiEventListener widget : this.children()) {
            Button button;
            if (!(widget instanceof Button) || !(button = (Button)widget).getMessage().getString().equals(I18n.get((String)"menu.online", (Object[])new Object[0]))) continue;
            button.active = false;
            break;
        }
    }

    @Inject(method={"<init>(ZLnet/minecraft/client/gui/components/LogoRenderer;)V"}, at={@At(value="TAIL")})
    private void tbs$refreshMenuBackground(CallbackInfo ci) {
        if (TBSConfigs.INSTANCE.getClient().getMainMenuMode() != MenuMode.FANART) {
            return;
        }
        TBSMenuBackgrounds.refreshMenuBackground();
    }

    @Inject(method={"init"}, at={@At(value="TAIL")})
    private void tbs$repositionButtons(CallbackInfo ci) {
        if (TBSConfigs.INSTANCE.getClient().getMainMenuMode() != MenuMode.FANART) {
            return;
        }
        TitleScreen screen = (TitleScreen)this;
        for (Renderable renderable : ((ScreenAccessor)screen).tbs$getRenderables()) {
            if (!(renderable instanceof Button)) continue;
            Button button = (Button)renderable;
            if (renderable instanceof PlainTextButton) continue;
            button.setX(button.getX() - this.width / 2 + 138);
        }
    }

    @Inject(method={"init"}, at={@At(value="TAIL")})
    private void tbs$addCredits(CallbackInfo ci) {
        int textHeight = 10;
        int verWidth = this.font.width((FormattedText)theBrokenScript$VERSION);
        int verPosX = this.width - verWidth - 2;
        int verPosY = this.height - 20;
        this.addRenderableWidget((GuiEventListener)new StringWidget(verPosX, verPosY, verWidth, 10, theBrokenScript$VERSION, this.font));
    }

    @Inject(method={"render"}, at={@At(value="RETURN")})
    private void tbs$ChangeQuitText(GuiGraphics graphics, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        if (TBSConfigs.INSTANCE.getClient().getMainMenuMode() != MenuMode.FANART) {
            return;
        }
        if ((double)this.tbs$random.nextFloat() <= 0.001 && this.tbs$quitButtonTimer == 0) {
            this.tbs$quitButtonTimer = this.tbs$random.nextInt(35, 51);
            this.tbs$quitButton.setMessage((Component)TBSLang.INSTANCE.getBUTTON_QUIT_ALT());
        }
        if (this.tbs$quitButtonTimer > 0) {
            --this.tbs$quitButtonTimer;
            PoseStack pose = graphics.pose();
            if (this.minecraft != null) {
                pose.pushPose();
                float guiScale = (float)this.minecraft.getWindow().getGuiScale();
                pose.scale(1.2f / guiScale, 1.2f / guiScale, 1.0f);
                int x = (int)((float)this.minecraft.getWindow().getGuiScaledWidth() * guiScale / 2.0f - 600.0f + (float)this.tbs$random.nextInt(-5, 5));
                int y = (int)((float)this.minecraft.getWindow().getGuiScaledHeight() * guiScale / 2.0f + 300.0f + (float)this.tbs$random.nextInt(-5, 5));
                pose.translate((float)x, (float)y, 0.0f);
                pose.mulPose(Axis.ZN.rotationDegrees((float)this.tbs$random.nextInt(20, 51)));
                MutableComponent text = TBSLang.INSTANCE.getBUTTON_QUIT_ALT_2();
                int textWidth = this.minecraft.font.width((FormattedText)text);
                this.minecraft.font.drawInBatch((Component)text, (float)(-textWidth) / 2.0f, 0.0f, 0xBBBBBB, false, pose.last().pose(), (MultiBufferSource)graphics.bufferSource(), Font.DisplayMode.NORMAL, 0, 0xF000F0);
                pose.popPose();
            }
            if (this.tbs$quitButtonTimer <= 0) {
                this.tbs$quitButton.setMessage((Component)Component.translatable((String)"menu.quit"));
                this.tbs$quitButtonTimer = 0;
            }
        }
    }

    @Inject(method={"render"}, at={@At(value="HEAD")})
    private void tbs$repositionMinecraftLogo(GuiGraphics graphics, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        if (TBSConfigs.INSTANCE.getClient().getMainMenuMode() != MenuMode.FANART) {
            return;
        }
        int logoX = 100;
        int logoY = 10;
        int width = 256;
        int height = 44;
        graphics.blit(MINECRAFT_LOGO, logoX, logoY, 50.0f, 10.0f, width, height, width, height);
    }

    @Redirect(method={"render"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/components/LogoRenderer;renderLogo(Lnet/minecraft/client/gui/GuiGraphics;IF)V"))
    private void tbs$redirectLogoRender(LogoRenderer instance, GuiGraphics guiGraphics, int screenWidth, float alpha) {
        MenuMode mode = TBSConfigs.INSTANCE.getClient().getMainMenuMode();
        int width = mode == MenuMode.FANART ? 290 : screenWidth;
        instance.renderLogo(guiGraphics, width, alpha);
    }

    @ModifyArg(method={"render"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/components/SplashRenderer;render(Lnet/minecraft/client/gui/GuiGraphics;ILnet/minecraft/client/gui/Font;I)V"), index=1)
    private int tbs$modifySplashPosition(int screenWidth) {
        if (TBSConfigs.INSTANCE.getClient().getMainMenuMode() != MenuMode.FANART) {
            return screenWidth;
        }
        return 290;
    }

    @Inject(method={"renderPanorama"}, at={@At(value="HEAD")}, cancellable=true)
    private void tbs$cancelPanorama(GuiGraphics guiGraphics, float partialTick, CallbackInfo ci) {
        if (TBSConfigs.INSTANCE.getClient().getMainMenuMode() != MenuMode.FANART) {
            return;
        }
        if (TBSMenuBackgrounds.getMenuBackground() == null) {
            return;
        }
        ci.cancel();
    }

    @Inject(method={"renderBackground"}, at={@At(value="HEAD")})
    private void tbs$renderCustomBackground(GuiGraphics cx, int mouseX, int mouseY, float partialTick, CallbackInfo ci) {
        if (TBSConfigs.INSTANCE.getClient().getMainMenuMode() != MenuMode.FANART) {
            return;
        }
        ResourceLocation bg = TBSMenuBackgrounds.getMenuBackground();
        if (bg == null) {
            return;
        }
        cx.blit(bg, 0, 0, 0.0f, 0.0f, this.width, this.height, this.width, this.height);
    }

    @Inject(method={"init"}, at={@At(value="TAIL")})
    private void tbs$addVideoTestButton(CallbackInfo ci) {
        if (PlatformUtil.Companion.isProduction()) {
            return;
        }
        int btnWidth = 120;
        int btnHeight = 20;
        this.addRenderableWidget((GuiEventListener)Button.builder((Component)Component.literal((String)"change background"), btn -> TBSMenuBackgrounds.refreshMenuBackground()).bounds(this.width - btnWidth - 4, 4, btnWidth, btnHeight).build());
    }
}

