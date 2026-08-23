/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.IntRange
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.components.Renderable
 *  net.minecraft.client.gui.navigation.ScreenRectangle
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector2i
 *  org.joml.Vector4i
 */
package net.thebrokenscript.brokencore.api.client.gui.abstr;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractGuiNode;
import net.thebrokenscript.brokencore.api.client.gui.container.ScrollableContainer;
import net.thebrokenscript.brokencore.api.client.gui.impl.GuiElement;
import net.thebrokenscript.brokencore.api.client.gui.impl.RectangleElement;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2i;
import org.joml.Vector4i;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B1\b\u0016\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\t\u0010\nJ\u001a\u0010A\u001a\u00020B2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020B0DJ.\u0010E\u001a\u00020B2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005J.\u0010F\u001a\u00020B2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005J\u0006\u0010G\u001a\u00020BJ\u0006\u0010H\u001a\u00020BJ\r\u0010I\u001a\u00020\u0005H\u0007\u00a2\u0006\u0002\bQJ\r\u0010K\u001a\u00020\u0005H\u0007\u00a2\u0006\u0002\bRJ\u0006\u0010S\u001a\u00020\u0005J\u0006\u0010T\u001a\u00020\u0005J\u0015\u0010J\u001a\u00020B2\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u00a2\u0006\u0002\bQJ\u0015\u0010L\u001a\u00020B2\u0006\u0010\u0006\u001a\u00020\u0005H\u0007\u00a2\u0006\u0002\bUJ\b\u0010V\u001a\u00020WH\u0016J\b\u0010X\u001a\u00020WH\u0016J\u0010\u0010Y\u001a\u00020B2\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010Z\u001a\u00020B2\u0006\u0010\b\u001a\u00020\u0005H\u0016J(\u0010[\u001a\u00020B2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020\u00052\u0006\u0010_\u001a\u00020\u00052\u0006\u0010`\u001a\u00020aH\u0002J&\u0010b\u001a\u00020B2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020\u00052\u0006\u0010_\u001a\u00020\u00052\u0006\u0010`\u001a\u00020aJ8\u0010b\u001a\u00020B2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020\u00052\u0006\u0010_\u001a\u00020\u00052\u0006\u0010`\u001a\u00020a2\u0006\u0010=\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u0005H\u0016J\u0018\u0010c\u001a\u00020\u001c2\u0006\u0010^\u001a\u00020d2\u0006\u0010_\u001a\u00020dH\u0016J\n\u0010e\u001a\u00020f*\u00020fJ\u0019\u0010=\u001a\u00020\u0005\"\b\b\u0000\u0010g*\u00020d*\u0002Hg\u00a2\u0006\u0002\u0010hJ\u0019\u0010?\u001a\u00020\u0005\"\b\b\u0000\u0010g*\u00020d*\u0002Hg\u00a2\u0006\u0002\u0010hJ\n\u0010i\u001a\u00020f*\u00020fJ\u0019\u0010j\u001a\u00020\u0005\"\b\b\u0000\u0010g*\u00020d*\u0002Hg\u00a2\u0006\u0002\u0010hJ\u0019\u0010k\u001a\u00020\u0005\"\b\b\u0000\u0010g*\u00020d*\u0002Hg\u00a2\u0006\u0002\u0010hR\u001e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@BX\u0084\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@BX\u0084\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u001e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@BX\u0084\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u001e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@BX\u0084\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u0016X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010'\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u001c@VX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R$\u0010*\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u001c@VX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010#\"\u0004\b,\u0010%R\u001a\u0010-\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000e\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u000e\"\u0004\b3\u00100R\u001a\u00104\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u000e\"\u0004\b6\u00100R\u001a\u00107\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u000e\"\u0004\b9\u00100R\u001a\u0010:\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u000e\"\u0004\b<\u00100R\u0011\u0010=\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b>\u0010\u000eR\u0011\u0010?\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b@\u0010\u000eR$\u0010\u0004\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00058V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\bI\u0010\u000e\"\u0004\bJ\u00100R$\u0010\u0006\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00058V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\bK\u0010\u000e\"\u0004\bL\u00100R$\u0010\u0007\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00058V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\bM\u0010\u000e\"\u0004\bN\u00100R$\u0010\b\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00058V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\bO\u0010\u000e\"\u0004\bP\u00100\u00a8\u0006l"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractGuiNode2D;", "Lnet/thebrokenscript/brokencore/api/client/gui/impl/RectangleElement;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractGuiNode;", "Lnet/minecraft/client/gui/components/Renderable;", "x", "", "y", "w", "h", "<init>", "(IIII)V", "value", "internalX", "getInternalX", "()I", "internalY", "getInternalY", "internalW", "getInternalW", "internalH", "getInternalH", "category", "", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "clipChildren", "", "childClipRect", "Lorg/joml/Vector4i;", "scissorRect", "scissor", "drawSelfLast", "getDrawSelfLast", "()Z", "setDrawSelfLast", "(Z)V", "v", "visible", "getVisible", "setVisible", "active", "getActive", "setActive", "xOffset", "getXOffset", "setXOffset", "(I)V", "yOffset", "getYOffset", "setYOffset", "minWidth", "getMinWidth", "setMinWidth", "minHeight", "getMinHeight", "setMinHeight", "zIndex", "getZIndex", "setZIndex", "globalX", "getGlobalX", "globalY", "getGlobalY", "forEachNode2d", "", "consumer", "Lkotlin/Function1;", "enableChildClipping", "enableScissor", "disableScissor", "disableChildClipping", "getX", "setX", "getY", "setY", "getW", "setW", "getH", "setH", "funSetX", "funGetY", "getWidth", "getHeight", "funSetY", "getRectangle", "Lnet/minecraft/client/gui/navigation/ScreenRectangle;", "getGlobalRectangle", "setWidth", "setHeight", "renderSelf", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "mouseX", "mouseY", "partialTick", "", "render", "isMouseOver", "", "globalize", "Lorg/joml/Vector2i;", "T", "(Ljava/lang/Number;)I", "localize", "localX", "localY", "brokencore-common"})
public abstract class AbstractGuiNode2D
extends AbstractGuiNode
implements RectangleElement,
Renderable {
    private int internalX;
    private int internalY;
    private int internalW;
    private int internalH;
    @NotNull
    private String category;
    private boolean clipChildren;
    @NotNull
    private final Vector4i childClipRect;
    @NotNull
    private final Vector4i scissorRect;
    private boolean scissor;
    private boolean drawSelfLast;
    private boolean visible;
    private boolean active;
    private int xOffset;
    private int yOffset;
    private int minWidth;
    private int minHeight;
    private int zIndex;

    protected final int getInternalX() {
        return this.internalX;
    }

    protected final int getInternalY() {
        return this.internalY;
    }

    protected final int getInternalW() {
        return this.internalW;
    }

    protected final int getInternalH() {
        return this.internalH;
    }

    @Override
    @NotNull
    public String getCategory() {
        return this.category;
    }

    public void setCategory(@NotNull String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<set-?>");
        this.category = string;
    }

    public final boolean getDrawSelfLast() {
        return this.drawSelfLast;
    }

    public final void setDrawSelfLast(boolean bl) {
        this.drawSelfLast = bl;
    }

    public boolean getVisible() {
        return this.visible;
    }

    public void setVisible(boolean v) {
        this.visible = v;
        this.forEachChildInTree((Function1<? super GuiElement, Unit>)((Function1)arg_0 -> AbstractGuiNode2D._set_visible_$lambda$0(v, arg_0)));
    }

    public boolean getActive() {
        return this.active;
    }

    public void setActive(boolean v) {
        this.active = v;
        this.forEachChildInTree((Function1<? super GuiElement, Unit>)((Function1)arg_0 -> AbstractGuiNode2D._set_active_$lambda$0(v, arg_0)));
    }

    public int getXOffset() {
        return this.xOffset;
    }

    public void setXOffset(int n) {
        this.xOffset = n;
    }

    public int getYOffset() {
        return this.yOffset;
    }

    public void setYOffset(int n) {
        this.yOffset = n;
    }

    public int getMinWidth() {
        return this.minWidth;
    }

    public void setMinWidth(int n) {
        this.minWidth = n;
    }

    public int getMinHeight() {
        return this.minHeight;
    }

    public void setMinHeight(int n) {
        this.minHeight = n;
    }

    public AbstractGuiNode2D(int x, int y, int w, int h) {
        this.category = "gui";
        this.childClipRect = new Vector4i(0, 0, 0, 0);
        this.scissorRect = new Vector4i(0, 0, 0, 0);
        this.visible = true;
        this.active = true;
        this.internalX = x;
        this.internalY = y;
        this.internalW = w;
        this.internalH = h;
    }

    public /* synthetic */ AbstractGuiNode2D(int n, int n2, int n3, int n4, int n5, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n5 & 1) != 0) {
            n = 0;
        }
        if ((n5 & 2) != 0) {
            n2 = 0;
        }
        if ((n5 & 4) != 0) {
            n3 = 16;
        }
        if ((n5 & 8) != 0) {
            n4 = 16;
        }
        this(n, n2, n3, n4);
    }

    public final int getZIndex() {
        return this.zIndex;
    }

    public final void setZIndex(int n) {
        this.zIndex = n;
    }

    public final int getGlobalX() {
        int v = this.getX();
        GuiElement parent = this.getParent();
        while (parent != null && parent instanceof AbstractGuiNode2D) {
            v += ((AbstractGuiNode2D)parent).getX();
            parent = ((AbstractGuiNode2D)parent).getParent();
        }
        return v;
    }

    public final int getGlobalY() {
        int v = this.getY();
        GuiElement parent = this.getParent();
        while (parent != null && parent instanceof AbstractGuiNode2D) {
            v += ((AbstractGuiNode2D)parent).getY();
            parent = ((AbstractGuiNode2D)parent).getParent();
        }
        return v;
    }

    public final void forEachNode2d(@NotNull Function1<? super AbstractGuiNode2D, Unit> consumer) {
        Intrinsics.checkNotNullParameter(consumer, (String)"consumer");
        this.forEachChild((Function1<? super GuiElement, Unit>)((Function1)arg_0 -> AbstractGuiNode2D.forEachNode2d$lambda$0(consumer, arg_0)));
    }

    public final void enableChildClipping(int x, int y, int w, int h) {
        this.clipChildren = true;
        this.childClipRect.x = x;
        this.childClipRect.y = y;
        this.childClipRect.z = x + w;
        this.childClipRect.w = y + h;
    }

    public static /* synthetic */ void enableChildClipping$default(AbstractGuiNode2D abstractGuiNode2D, int n, int n2, int n3, int n4, int n5, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enableChildClipping");
        }
        if ((n5 & 1) != 0) {
            n = abstractGuiNode2D.getGlobalX();
        }
        if ((n5 & 2) != 0) {
            n2 = abstractGuiNode2D.getGlobalY();
        }
        if ((n5 & 4) != 0) {
            n3 = abstractGuiNode2D.getW();
        }
        if ((n5 & 8) != 0) {
            n4 = abstractGuiNode2D.getH();
        }
        abstractGuiNode2D.enableChildClipping(n, n2, n3, n4);
    }

    public final void enableScissor(int x, int y, int w, int h) {
        this.scissorRect.x = x;
        this.scissorRect.y = y;
        this.scissorRect.z = x + w;
        this.scissorRect.w = y + h;
        this.scissor = true;
    }

    public static /* synthetic */ void enableScissor$default(AbstractGuiNode2D abstractGuiNode2D, int n, int n2, int n3, int n4, int n5, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enableScissor");
        }
        if ((n5 & 1) != 0) {
            n = abstractGuiNode2D.getGlobalX();
        }
        if ((n5 & 2) != 0) {
            n2 = abstractGuiNode2D.getGlobalY();
        }
        if ((n5 & 4) != 0) {
            n3 = abstractGuiNode2D.getW();
        }
        if ((n5 & 8) != 0) {
            n4 = abstractGuiNode2D.getH();
        }
        abstractGuiNode2D.enableScissor(n, n2, n3, n4);
    }

    public final void disableScissor() {
        this.scissor = false;
    }

    public final void disableChildClipping() {
        this.clipChildren = false;
    }

    @Override
    public int getX() {
        return this.funSetX() + this.getXOffset();
    }

    @Override
    public void setX(int v) {
        this.funSetX(v);
    }

    @Override
    public int getY() {
        return this.funGetY() + this.getYOffset();
    }

    @Override
    public void setY(int v) {
        this.funSetY(v);
    }

    @Override
    public int getW() {
        return this.getWidth();
    }

    @Override
    public void setW(int v) {
        this.setWidth(v);
    }

    @Override
    public int getH() {
        return this.getHeight();
    }

    @Override
    public void setH(int v) {
        this.setHeight(v);
    }

    @JvmName(name="funSetX")
    public final int funSetX() {
        return this.internalX;
    }

    @JvmName(name="funGetY")
    public final int funGetY() {
        return this.internalY;
    }

    public final int getWidth() {
        return Math.max(this.internalW, this.getMinWidth());
    }

    public final int getHeight() {
        return Math.max(this.internalH, this.getMinHeight());
    }

    @JvmName(name="funSetX")
    public final void funSetX(int x) {
        this.internalX = x;
    }

    @JvmName(name="funSetY")
    public final void funSetY(int y) {
        this.internalY = y;
    }

    @Override
    @NotNull
    public ScreenRectangle getRectangle() {
        return new ScreenRectangle(this.getX(), this.getY(), this.getW(), this.getH());
    }

    @NotNull
    public ScreenRectangle getGlobalRectangle() {
        return new ScreenRectangle(this.getGlobalX(), this.getGlobalY(), this.getW(), this.getH());
    }

    @Override
    public void setWidth(int w) {
        this.internalW = w;
    }

    @Override
    public void setHeight(int h) {
        this.internalH = h;
    }

    private final void renderSelf(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        if (this.scissor) {
            guiGraphics.enableScissor(this.scissorRect.x, this.scissorRect.y, this.scissorRect.z, this.scissorRect.w);
        }
        guiGraphics.pose().pushPose();
        this.render(guiGraphics, mouseX, mouseY, partialTick, this.getGlobalX(), this.getGlobalY());
        guiGraphics.pose().popPose();
        if (this.scissor) {
            guiGraphics.disableScissor();
        }
    }

    public final void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        if (!this.getVisible()) {
            return;
        }
        if (!this.drawSelfLast) {
            this.renderSelf(guiGraphics, mouseX, mouseY, partialTick);
        }
        if (this.clipChildren) {
            guiGraphics.enableScissor(this.childClipRect.x, this.childClipRect.y, this.childClipRect.z, this.childClipRect.w);
        }
        if (!(this instanceof ScrollableContainer) || this.childClipRect.z <= 0 || this.childClipRect.w <= 0 || this.clipChildren) {
            // empty if block
        }
        this.forEachChild((Function1<? super GuiElement, Unit>)((Function1)arg_0 -> AbstractGuiNode2D.render$lambda$0(guiGraphics, mouseX, mouseY, partialTick, arg_0)));
        if (this.clipChildren) {
            guiGraphics.disableScissor();
        }
        if (this.drawSelfLast) {
            this.renderSelf(guiGraphics, mouseX, mouseY, partialTick);
        }
    }

    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick, int globalX, int globalY) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isMouseOver(@NotNull Number mouseX, @NotNull Number mouseY) {
        Intrinsics.checkNotNullParameter((Object)mouseX, (String)"mouseX");
        Intrinsics.checkNotNullParameter((Object)mouseY, (String)"mouseY");
        if (!this.getActive()) {
            return false;
        }
        for (GuiElement parent = this.getParent(); parent != null; parent = parent.getParent()) {
            if (!(parent instanceof AbstractGuiNode2D) || !((AbstractGuiNode2D)parent).clipChildren) continue;
            Vector4i rect = ((AbstractGuiNode2D)parent).childClipRect;
            if (!CollectionsKt.contains((Iterable)((Iterable)new IntRange(rect.x, rect.z)), (Object)mouseX)) return false;
            if (CollectionsKt.contains((Iterable)((Iterable)new IntRange(rect.y, rect.w)), (Object)mouseY)) continue;
            return false;
        }
        int n = this.getGlobalX();
        int n2 = this.getGlobalX() + this.getW();
        int n3 = mouseX.intValue();
        if (n > n3) return false;
        if (n3 > n2) return false;
        boolean bl = true;
        if (!bl) return false;
        n = this.getGlobalY();
        n2 = this.getGlobalY() + this.getH();
        n3 = mouseY.intValue();
        if (n > n3) return false;
        if (n3 > n2) return false;
        return true;
    }

    @NotNull
    public final Vector2i globalize(@NotNull Vector2i $this$globalize) {
        Intrinsics.checkNotNullParameter((Object)$this$globalize, (String)"<this>");
        return new Vector2i($this$globalize.x + this.getGlobalX(), $this$globalize.y + this.getGlobalY());
    }

    public final <T extends Number> int globalX(@NotNull T $this$globalX) {
        Intrinsics.checkNotNullParameter($this$globalX, (String)"<this>");
        return $this$globalX.intValue() + this.getGlobalX();
    }

    public final <T extends Number> int globalY(@NotNull T $this$globalY) {
        Intrinsics.checkNotNullParameter($this$globalY, (String)"<this>");
        return $this$globalY.intValue() + this.getGlobalY();
    }

    @NotNull
    public final Vector2i localize(@NotNull Vector2i $this$localize) {
        Intrinsics.checkNotNullParameter((Object)$this$localize, (String)"<this>");
        return new Vector2i($this$localize.x - this.getGlobalX(), $this$localize.y - this.getGlobalY());
    }

    public final <T extends Number> int localX(@NotNull T $this$localX) {
        Intrinsics.checkNotNullParameter($this$localX, (String)"<this>");
        return $this$localX.intValue() - this.getGlobalX();
    }

    public final <T extends Number> int localY(@NotNull T $this$localY) {
        Intrinsics.checkNotNullParameter($this$localY, (String)"<this>");
        return $this$localY.intValue() - this.getGlobalY();
    }

    private static final Unit _set_visible_$lambda$0(boolean $v, GuiElement it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        if (it instanceof AbstractGuiNode2D) {
            ((AbstractGuiNode2D)it).setVisible($v);
        }
        return Unit.INSTANCE;
    }

    private static final Unit _set_active_$lambda$0(boolean $v, GuiElement it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        if (it instanceof AbstractGuiNode2D) {
            ((AbstractGuiNode2D)it).setActive($v);
        }
        return Unit.INSTANCE;
    }

    private static final Unit forEachNode2d$lambda$0(Function1 $consumer, GuiElement it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        if (it instanceof AbstractGuiNode2D) {
            $consumer.invoke((Object)it);
        }
        return Unit.INSTANCE;
    }

    private static final Unit render$lambda$0(GuiGraphics $guiGraphics, int $mouseX, int $mouseY, float $partialTick, GuiElement it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        $guiGraphics.pose().pushPose();
        if (it instanceof AbstractGuiNode2D) {
            ((AbstractGuiNode2D)it).render($guiGraphics, $mouseX, $mouseY, $partialTick);
        }
        $guiGraphics.pose().popPose();
        return Unit.INSTANCE;
    }
}

