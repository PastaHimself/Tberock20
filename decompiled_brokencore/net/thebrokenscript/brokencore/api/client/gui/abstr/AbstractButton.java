/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.gui.components.events.GuiEventListener
 *  net.minecraft.client.gui.navigation.ScreenRectangle
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.gui.abstr;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractGuiNode2D;
import net.thebrokenscript.brokencore.api.client.gui.impl.Hoverable;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020 H\u0016J \u0010!\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u001bH\u0016J \u0010#\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u001bH\u0016J\b\u0010$\u001a\u00020\rH\u0016J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\rH\u0016R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\bR$\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@TX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\rX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\rX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012\u00a8\u0006'"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractButton;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractGuiNode2D;", "Lnet/thebrokenscript/brokencore/api/client/gui/impl/Hoverable;", "Lnet/minecraft/client/gui/components/events/GuiEventListener;", "callback", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "getCallback", "()Lkotlin/jvm/functions/Function0;", "setCallback", "value", "", "pressed", "getPressed", "()Z", "setPressed", "(Z)V", "toggleMode", "getToggleMode", "setToggleMode", "hovered", "getHovered", "setHovered", "canPress", "mouseX", "", "mouseY", "getRectangle", "Lnet/minecraft/client/gui/navigation/ScreenRectangle;", "mouseMoved", "", "mouseClicked", "button", "mouseReleased", "isFocused", "setFocused", "focused", "brokencore-common"})
public abstract class AbstractButton
extends AbstractGuiNode2D
implements Hoverable,
GuiEventListener {
    @NotNull
    private Function0<Unit> callback;
    private boolean pressed;
    private boolean toggleMode;
    private boolean hovered;

    public AbstractButton(@NotNull Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, (String)"callback");
        super(0, 0, 0, 0, 15, null);
        this.callback = callback;
    }

    @NotNull
    protected final Function0<Unit> getCallback() {
        return this.callback;
    }

    protected final void setCallback(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, (String)"<set-?>");
        this.callback = function0;
    }

    public boolean getPressed() {
        return this.pressed;
    }

    protected void setPressed(boolean bl) {
        this.pressed = bl;
    }

    public boolean getToggleMode() {
        return this.toggleMode;
    }

    public void setToggleMode(boolean bl) {
        this.toggleMode = bl;
    }

    @Override
    public boolean getHovered() {
        return this.hovered;
    }

    @Override
    public void setHovered(boolean bl) {
        this.hovered = bl;
    }

    public boolean canPress(int mouseX, int mouseY) {
        return this.isMouseOver(mouseX, mouseY);
    }

    @Override
    @NotNull
    public ScreenRectangle getRectangle() {
        return super.getRectangle();
    }

    public void mouseMoved(double mouseX, double mouseY) {
        if (!this.getActive()) {
            this.setHovered(false);
            this.setPressed(false);
            return;
        }
        boolean mouseOver = this.isMouseOver((int)mouseX, (int)mouseY);
        if (mouseOver && !this.getHovered()) {
            this.mouseEntered((int)mouseX, (int)mouseY);
        } else if (this.getHovered() && !mouseOver) {
            this.mouseExited((int)mouseX, (int)mouseY);
        }
    }

    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (this.getHovered() && this.getActive() && button == 0) {
            this.setPressed(this.getToggleMode() ? !this.getPressed() : true);
            if (this.getPressed()) {
                this.callback.invoke();
            }
        }
        return false;
    }

    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        if (!this.getToggleMode() && button == 0) {
            this.setPressed(false);
        }
        return false;
    }

    public boolean isFocused() {
        return false;
    }

    public void setFocused(boolean focused) {
    }
}

