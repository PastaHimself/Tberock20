/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.gui.Font
 *  net.minecraft.client.gui.components.Checkbox
 *  net.minecraft.client.gui.components.events.GuiEventListener
 *  net.minecraft.client.gui.screens.Screen
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.FormattedText
 *  net.minecraft.network.chat.MutableComponent
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.client.gui;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.MutableComponent;
import net.thebrokenscript.registry.TBSLang;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\tH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0016J \u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/client/gui/StartupScreen;", "Lnet/minecraft/client/gui/screens/Screen;", "title", "Lnet/minecraft/network/chat/Component;", "<init>", "(Lnet/minecraft/network/chat/Component;)V", "checkbox", "Lnet/minecraft/client/gui/components/Checkbox;", "setShowAgain", "", "value", "", "afterClose", "init", "shouldCloseOnEsc", "mouseClicked", "mouseX", "", "mouseY", "button", "", "thebrokenscript-common"})
public abstract class StartupScreen
extends Screen {
    private Checkbox checkbox;

    public StartupScreen(@NotNull Component title) {
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        super(title);
    }

    public abstract void setShowAgain(boolean var1);

    public abstract void afterClose();

    protected void init() {
        super.init();
        MutableComponent msg = TBSLang.INSTANCE.getTOGGLE_SHOW_AGAIN();
        int size = Checkbox.getBoxSize((Font)this.font) + 4 + this.font.width((FormattedText)msg);
        GuiEventListener guiEventListener = this.addRenderableWidget((GuiEventListener)new Checkbox(this.width / 2 - size / 2, this.height - 60, size, (Component)msg, this.font, false, (arg_0, arg_1) -> StartupScreen.init$lambda$0(this, arg_0, arg_1)));
        Intrinsics.checkNotNullExpressionValue((Object)guiEventListener, (String)"addRenderableWidget(...)");
        this.checkbox = (Checkbox)guiEventListener;
    }

    public boolean shouldCloseOnEsc() {
        return true;
    }

    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        Checkbox checkbox = this.checkbox;
        if (checkbox == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"checkbox");
            checkbox = null;
        }
        if (checkbox.mouseClicked(mouseX, mouseY, button)) {
            return true;
        }
        this.afterClose();
        return true;
    }

    private static final void init$lambda$0(StartupScreen this$0, Checkbox checkbox, boolean value) {
        this$0.setShowAgain(!value);
    }
}

