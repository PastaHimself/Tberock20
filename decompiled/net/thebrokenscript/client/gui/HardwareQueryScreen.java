/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.platform.GlUtil
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.Regex
 *  kotlin.text.StringsKt
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.components.Button
 *  net.minecraft.client.gui.components.events.GuiEventListener
 *  net.minecraft.client.gui.screens.Screen
 *  net.minecraft.client.gui.screens.TitleScreen
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.FormattedText
 *  net.minecraft.network.chat.MutableComponent
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.client.gui;

import com.mojang.blaze3d.platform.GlUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.MutableComponent;
import net.thebrokenscript.client.data.ClientVariables;
import net.thebrokenscript.client.gui.StartupScreen;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.registry.TBSLang;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0014J\b\u0010\r\u001a\u00020\bH\u0002J(\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0016\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Lnet/thebrokenscript/client/gui/HardwareQueryScreen;", "Lnet/thebrokenscript/client/gui/StartupScreen;", "<init>", "()V", "leButton", "Lnet/minecraft/client/gui/components/Button;", "leOtherButton", "setShowAgain", "", "value", "", "afterClose", "init", "setAwesomeStuff", "render", "cx", "Lnet/minecraft/client/gui/GuiGraphics;", "mouseX", "", "mouseY", "delta", "", "mouseClicked", "", "button", "Companion", "thebrokenscript-common"})
public final class HardwareQueryScreen
extends StartupScreen {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private Button leButton;
    private Button leOtherButton;
    private static final String rawGpu;
    @NotNull
    private static final String USER_GPU;
    private static final char GPU_COLOR;

    public HardwareQueryScreen() {
        super((Component)TBSLang.INSTANCE.getHARDWARE_TITLE());
    }

    @Override
    public void setShowAgain(boolean value) {
    }

    @Override
    public void afterClose() {
        Minecraft minecraft = this.minecraft;
        if (minecraft != null) {
            minecraft.setScreen((Screen)new TitleScreen());
        }
        TBSConfigs.INSTANCE.getClient().getSpecification().save();
        ClientVariables.INSTANCE.set(16384L);
    }

    @Override
    protected void init() {
        MutableComponent msg = TBSConfigs.INSTANCE.getClient().getFancyRendering() ? TBSLang.INSTANCE.getHARDWARE_ENABLED() : TBSLang.INSTANCE.getHARDWARE_DISABLED();
        MutableComponent otherMsg = TBSLang.INSTANCE.getHARDWARE_CONTINUE();
        int width = this.font.width((FormattedText)msg) + 10;
        int height = 20;
        GuiEventListener guiEventListener = this.addRenderableWidget((GuiEventListener)Button.builder((Component)((Component)msg), arg_0 -> HardwareQueryScreen.init$lambda$0(this, arg_0)).bounds(this.width / 2 + 5, this.height / 2 + 35, width, height).build());
        Intrinsics.checkNotNullExpressionValue((Object)guiEventListener, (String)"addRenderableWidget(...)");
        this.leButton = (Button)guiEventListener;
        GuiEventListener guiEventListener2 = this.addRenderableWidget((GuiEventListener)Button.builder((Component)((Component)otherMsg), arg_0 -> HardwareQueryScreen.init$lambda$1(this, arg_0)).bounds(this.width / 2 - 120, this.height / 2 + 75, width * 5, height).build());
        Intrinsics.checkNotNullExpressionValue((Object)guiEventListener2, (String)"addRenderableWidget(...)");
        this.leOtherButton = (Button)guiEventListener2;
    }

    private final void setAwesomeStuff() {
        TBSConfigs.INSTANCE.getClient().setFancyRendering(!TBSConfigs.INSTANCE.getClient().getFancyRendering());
        TBSConfigs.INSTANCE.getClient().getSpecification().save();
        Button button = this.leButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"leButton");
            button = null;
        }
        button.setMessage(TBSConfigs.INSTANCE.getClient().getFancyRendering() ? (Component)TBSLang.INSTANCE.getHARDWARE_ENABLED() : (Component)TBSLang.INSTANCE.getHARDWARE_DISABLED());
    }

    public void render(@NotNull GuiGraphics cx, int mouseX, int mouseY, float delta) {
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        this.renderBackground(cx, mouseX, mouseY, delta);
        super.render(cx, mouseX, mouseY, delta);
        cx.drawCenteredString(this.font, (Component)TBSLang.INSTANCE.getHARDWARE_TITLE(), this.width / 2, this.height / 2 - 60, 0xFFFFFF);
        cx.drawCenteredString(this.font, (Component)TBSLang.INSTANCE.getHARDWARE_LINE_1(), this.width / 2, this.height / 2 - 40, 0xFFFFFF);
        cx.drawCenteredString(this.font, (Component)TBSLang.INSTANCE.getHARDWARE_LINE_2(), this.width / 2, this.height / 2 - 30, 0xFFFFFF);
        cx.drawCenteredString(this.font, (Component)TBSLang.INSTANCE.getHARDWARE_LINE_3(), this.width / 2, this.height / 2 - 20, 0xFFFFFF);
        cx.drawCenteredString(this.font, (Component)TBSLang.INSTANCE.getHARDWARE_LINE_4(), this.width / 2, this.height / 2 - 10, 0xFFFFFF);
        cx.drawCenteredString(this.font, (Component)TBSLang.INSTANCE.getHARDWARE_LINE_5(), this.width / 2, this.height / 2, 0xFFFFFF);
        cx.drawCenteredString(this.font, (Component)TBSLang.INSTANCE.getHARDWARE_LINE_6(), this.width / 2, this.height / 2 + 10, 0xFFFFFF);
        cx.drawCenteredString(this.font, (Component)TBSLang.INSTANCE.getHARDWARE_LINE_7(), this.width / 2 - 65, this.height / 2 + 25, 0xFFFFFF);
        cx.drawCenteredString(this.font, (Component)TBSLang.INSTANCE.getHARDWARE_CONFIRM(), this.width / 2 - 43, this.height / 2 + 42, 0xFFFFFF);
        cx.drawCenteredString(this.font, "\u00a7" + GPU_COLOR + USER_GPU, this.width / 2 + 65, this.height / 2 - -25, 0xFFFFFF);
        cx.drawCenteredString(this.font, (Component)TBSLang.INSTANCE.getHARDWARE_SHOW_ONCE(), this.width / 2, this.height - 60, 0xAAAAAA);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        Button button2 = this.leOtherButton;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"leOtherButton");
            button2 = null;
        }
        if (button2.mouseClicked(mouseX, mouseY, button)) {
            this.afterClose();
            return true;
        }
        Button button3 = this.leButton;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"leButton");
            button3 = null;
        }
        return button3.mouseClicked(mouseX, mouseY, button);
    }

    private static final void init$lambda$0(HardwareQueryScreen this$0, Button it) {
        this$0.setAwesomeStuff();
    }

    private static final void init$lambda$1(HardwareQueryScreen this$0, Button it) {
        block0: {
            Minecraft minecraft = this$0.minecraft;
            if (minecraft == null) break block0;
            minecraft.setScreen((Screen)new TitleScreen());
        }
    }

    static {
        String string = rawGpu = GlUtil.getRenderer();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"rawGpu");
        CharSequence charSequence = string;
        Regex regex = new Regex("[(/]");
        int n = 0;
        USER_GPU = ((Object)StringsKt.trim((CharSequence)((String)CollectionsKt.first((List)regex.split(charSequence, n))))).toString();
        GPU_COLOR = (char)(StringsKt.contains((CharSequence)USER_GPU, (CharSequence)"AMD", (boolean)true) ? 99 : (StringsKt.contains((CharSequence)USER_GPU, (CharSequence)"Intel", (boolean)true) ? 57 : (StringsKt.contains((CharSequence)USER_GPU, (CharSequence)"Nvidia", (boolean)true) ? 97 : 54)));
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\f\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/client/gui/HardwareQueryScreen$Companion;", "", "<init>", "()V", "rawGpu", "", "kotlin.jvm.PlatformType", "getRawGpu", "()Ljava/lang/String;", "USER_GPU", "getUSER_GPU", "GPU_COLOR", "", "getGPU_COLOR", "()C", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public final String getRawGpu() {
            return rawGpu;
        }

        @NotNull
        public final String getUSER_GPU() {
            return USER_GPU;
        }

        public final char getGPU_COLOR() {
            return GPU_COLOR;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

