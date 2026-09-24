/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.gui.components.events.GuiEventListener
 *  net.minecraft.client.gui.navigation.ScreenRectangle
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector2i
 */
package net.thebrokenscript.brokencore.api.client.gui.misc;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractGuiNode2D;
import net.thebrokenscript.brokencore.api.client.gui.impl.GuiDraggable;
import net.thebrokenscript.brokencore.api.client.gui.impl.GuiElement;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2i;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BL\u0012C\b\u0002\u0010\u0004\u001a=\u0012\u0004\u0012\u00020\u0000\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005\u00a2\u0006\u0002\b\f\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0019H\u0016J\u0018\u0010$\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0019H\u0016J\u0018\u0010%\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020&2\u0006\u0010#\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020(H\u0016J0\u0010)\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020*2\u0006\u0010#\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*H\u0016J\u0018\u0010.\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020*2\u0006\u0010#\u001a\u00020*H\u0016J \u0010/\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020*2\u0006\u0010#\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0019H\u0016J\u0016\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0006J \u00103\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020*2\u0006\u0010#\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0019H\u0016J\b\u00104\u001a\u00020\u0010H\u0016J\u0010\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u0010H\u0016RI\u0010\u0004\u001a=\u0012\u0004\u0012\u00020\u0000\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005\u00a2\u0006\u0002\b\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0019X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0019X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001d\u00a8\u00067"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/misc/DragBox;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractGuiNode2D;", "Lnet/thebrokenscript/brokencore/api/client/gui/impl/GuiDraggable;", "Lnet/minecraft/client/gui/components/events/GuiEventListener;", "dragCallback", "Lkotlin/Function3;", "Lorg/joml/Vector2i;", "Lkotlin/ParameterName;", "name", "localClickPos", "localPos", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "dragging", "", "getDragging", "()Z", "setDragging", "(Z)V", "hovered", "getHovered", "setHovered", "clickX", "", "getClickX", "()I", "setClickX", "(I)V", "clickY", "getClickY", "setClickY", "mouseEntered", "mouseX", "mouseY", "mouseExited", "canDrag", "", "getRectangle", "Lnet/minecraft/client/gui/navigation/ScreenRectangle;", "mouseDragged", "", "button", "dragX", "dragY", "mouseMoved", "mouseClicked", "dragElement", "clickPos", "mousePos", "mouseReleased", "isFocused", "setFocused", "focused", "brokencore-common"})
public final class DragBox
extends AbstractGuiNode2D
implements GuiDraggable,
GuiEventListener {
    @NotNull
    private final Function3<DragBox, Vector2i, Vector2i, Unit> dragCallback;
    private boolean dragging;
    private boolean hovered;
    private int clickX;
    private int clickY;

    public DragBox(@NotNull Function3<? super DragBox, ? super Vector2i, ? super Vector2i, Unit> dragCallback) {
        Intrinsics.checkNotNullParameter(dragCallback, (String)"dragCallback");
        super(0, 0, 0, 0, 15, null);
        this.dragCallback = dragCallback;
    }

    public /* synthetic */ DragBox(Function3 function3, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            function3 = DragBox::_init_$lambda$0;
        }
        this((Function3<? super DragBox, ? super Vector2i, ? super Vector2i, Unit>)function3);
    }

    @Override
    public boolean getDragging() {
        return this.dragging;
    }

    @Override
    public void setDragging(boolean bl) {
        this.dragging = bl;
    }

    @Override
    public boolean getHovered() {
        return this.hovered;
    }

    @Override
    public void setHovered(boolean bl) {
        this.hovered = bl;
    }

    @Override
    public int getClickX() {
        return this.clickX;
    }

    @Override
    public void setClickX(int n) {
        this.clickX = n;
    }

    @Override
    public int getClickY() {
        return this.clickY;
    }

    @Override
    public void setClickY(int n) {
        this.clickY = n;
    }

    @Override
    public void mouseEntered(int mouseX, int mouseY) {
        this.setHovered(true);
    }

    @Override
    public void mouseExited(int mouseX, int mouseY) {
        this.setHovered(false);
    }

    @Override
    public boolean canDrag(@NotNull Number mouseX, @NotNull Number mouseY) {
        Intrinsics.checkNotNullParameter((Object)mouseX, (String)"mouseX");
        Intrinsics.checkNotNullParameter((Object)mouseY, (String)"mouseY");
        return this.isMouseOver(mouseX, mouseY);
    }

    @Override
    @NotNull
    public ScreenRectangle getRectangle() {
        return super.getRectangle();
    }

    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        return false;
    }

    public void mouseMoved(double mouseX, double mouseY) {
        if (this.getDragging()) {
            this.dragCallback.invoke((Object)this, (Object)new Vector2i(this.getClickX(), this.getClickY()), (Object)new Vector2i((int)mouseX, (int)mouseY));
        } else if (this.canDrag(mouseX, mouseY) && !this.getHovered()) {
            this.mouseEntered((int)mouseX, (int)mouseY);
        } else if (this.getHovered()) {
            this.mouseExited((int)mouseX, (int)mouseY);
        }
    }

    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        boolean canDrag;
        boolean bl = canDrag = this.canDrag(mouseX, mouseY) && button == 0;
        if (canDrag) {
            this.setClickX(this.localX(mouseX));
            this.setClickY(this.localY(mouseY));
        }
        this.setDragging(canDrag);
        return canDrag;
    }

    public final void dragElement(@NotNull Vector2i clickPos, @NotNull Vector2i mousePos) {
        Intrinsics.checkNotNullParameter((Object)clickPos, (String)"clickPos");
        Intrinsics.checkNotNullParameter((Object)mousePos, (String)"mousePos");
        GuiElement parent = this.getParent();
        if (!(parent instanceof AbstractGuiNode2D)) {
            return;
        }
        Vector2i clickPos2 = this.globalize(clickPos);
        int nodeX = ((AbstractGuiNode2D)parent).getGlobalX();
        int nodeY = ((AbstractGuiNode2D)parent).getGlobalY();
        int mouseX = nodeX - mousePos.x;
        int mouseY = nodeY - mousePos.y;
        int dragX = clickPos2.x - nodeX;
        int dragY = clickPos2.y - nodeY;
        ((AbstractGuiNode2D)parent).setX(mouseX + dragX);
        ((AbstractGuiNode2D)parent).setY(mouseY + dragY);
    }

    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        this.setDragging(false);
        return false;
    }

    public boolean isFocused() {
        return false;
    }

    public void setFocused(boolean focused) {
    }

    private static final Unit _init_$lambda$0(DragBox dragBox, Vector2i clickPos, Vector2i pos) {
        Intrinsics.checkNotNullParameter((Object)dragBox, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)clickPos, (String)"clickPos");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        dragBox.dragElement(clickPos, pos);
        return Unit.INSTANCE;
    }

    public DragBox() {
        this(null, 1, null);
    }
}

