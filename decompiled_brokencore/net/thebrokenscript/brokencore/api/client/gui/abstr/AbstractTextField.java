/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.components.EditBox
 *  net.minecraft.client.gui.components.Tooltip
 *  net.minecraft.client.gui.components.events.GuiEventListener
 *  net.minecraft.client.gui.navigation.ScreenRectangle
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.util.FastColor$ARGB32
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.gui.abstr;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractGuiNode2D;
import net.thebrokenscript.brokencore.api.client.gui.settings.NinePatchSettings;
import net.thebrokenscript.brokencore.api.client.gui.settings.SpriteScalingSettings;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001[B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010A\u001a\u00020BH\u0016J\u0010\u0010C\u001a\u00020\u00122\u0006\u0010D\u001a\u00020\fH\u0016J\u0018\u0010E\u001a\u00020\f2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u001fH\u0016J\u0018\u0010I\u001a\u00020\f2\u0006\u0010J\u001a\u00020G2\u0006\u0010 \u001a\u00020\u001fH&J\b\u0010K\u001a\u00020\fH\u0016J \u0010L\u001a\u00020\f2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020\u001fH\u0016J \u0010Q\u001a\u00020\f2\u0006\u0010R\u001a\u00020\u001f2\u0006\u0010S\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020\u001fH\u0016J8\u0010T\u001a\u00020\u00122\u0006\u0010U\u001a\u00020V2\u0006\u0010M\u001a\u00020\u001f2\u0006\u0010O\u001a\u00020\u001f2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u001f2\u0006\u0010Z\u001a\u00020\u001fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u0082\u000e\u00a2\u0006\b\n\u0000\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001a\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u00020\u001f2\u0006\u0010\u000b\u001a\u00020\u001f8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010\u001eR\u000e\u0010(\u001a\u00020)X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010+\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u001f8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b,\u0010\"\"\u0004\b-\u0010$R$\u0010.\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u001f8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b/\u0010\"\"\u0004\b0\u0010$R$\u00101\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u001f8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b2\u0010\"\"\u0004\b3\u0010$R$\u00104\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u001f8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b5\u0010\"\"\u0004\b6\u0010$R$\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b@VX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001c\"\u0004\b8\u0010\u001eR5\u00109\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00120:X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@\u00a8\u0006\\"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractTextField;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractGuiNode2D;", "Lnet/minecraft/client/gui/components/events/GuiEventListener;", "bgTexture", "Lnet/minecraft/resources/ResourceLocation;", "bgScaling", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;", "previewText", "", "<init>", "(Lnet/minecraft/resources/ResourceLocation;Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;Ljava/lang/String;)V", "v", "", "focus", "setFocus", "(Z)V", "unfocusedCallback", "Lkotlin/Function0;", "", "getUnfocusedCallback", "()Lkotlin/jvm/functions/Function0;", "setUnfocusedCallback", "(Lkotlin/jvm/functions/Function0;)V", "focusedCallback", "getFocusedCallback", "setFocusedCallback", "tooltip", "getTooltip", "()Ljava/lang/String;", "setTooltip", "(Ljava/lang/String;)V", "", "cursorPos", "getCursorPos", "()I", "setCursorPos", "(I)V", "text", "getText", "setText", "editBox", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractTextField$InnerEditBox;", "value", "x", "getX", "setX", "y", "getY", "setY", "w", "getW", "setW", "h", "getH", "setH", "getPreviewText", "setPreviewText", "changeCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "getChangeCallback", "()Lkotlin/jvm/functions/Function1;", "setChangeCallback", "(Lkotlin/jvm/functions/Function1;)V", "getRectangle", "Lnet/minecraft/client/gui/navigation/ScreenRectangle;", "setFocused", "focused", "charTyped", "codePoint", "", "modifiers", "isCharacterValid", "char", "isFocused", "mouseClicked", "mouseX", "", "mouseY", "button", "keyPressed", "keyCode", "scanCode", "render", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "partialTick", "", "globalX", "globalY", "InnerEditBox", "brokencore-common"})
public abstract class AbstractTextField
extends AbstractGuiNode2D
implements GuiEventListener {
    @NotNull
    private final ResourceLocation bgTexture;
    @NotNull
    private final SpriteScalingSettings bgScaling;
    private boolean focus;
    @NotNull
    private Function0<Unit> unfocusedCallback;
    @NotNull
    private Function0<Unit> focusedCallback;
    @NotNull
    private final InnerEditBox editBox;
    @NotNull
    private String previewText;
    @NotNull
    private Function1<? super String, Unit> changeCallback;

    public AbstractTextField(@NotNull ResourceLocation bgTexture, @NotNull SpriteScalingSettings bgScaling, @NotNull String previewText) {
        Intrinsics.checkNotNullParameter((Object)bgTexture, (String)"bgTexture");
        Intrinsics.checkNotNullParameter((Object)bgScaling, (String)"bgScaling");
        Intrinsics.checkNotNullParameter((Object)previewText, (String)"previewText");
        super(0, 0, 0, 0, 15, null);
        this.bgTexture = bgTexture;
        this.bgScaling = bgScaling;
        this.unfocusedCallback = AbstractTextField::unfocusedCallback$lambda$0;
        this.focusedCallback = AbstractTextField::focusedCallback$lambda$0;
        this.editBox = new InnerEditBox();
        this.previewText = previewText;
        this.changeCallback = AbstractTextField::changeCallback$lambda$0;
        this.setPreviewText(previewText);
        this.editBox.setBordered(true);
    }

    public /* synthetic */ AbstractTextField(ResourceLocation resourceLocation, SpriteScalingSettings spriteScalingSettings, String string, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            string = "";
        }
        this(resourceLocation, spriteScalingSettings, string);
    }

    private final void setFocus(boolean v) {
        this.editBox.setFocused(v);
        this.focus = v;
    }

    @NotNull
    public final Function0<Unit> getUnfocusedCallback() {
        return this.unfocusedCallback;
    }

    public final void setUnfocusedCallback(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, (String)"<set-?>");
        this.unfocusedCallback = function0;
    }

    @NotNull
    public final Function0<Unit> getFocusedCallback() {
        return this.focusedCallback;
    }

    public final void setFocusedCallback(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, (String)"<set-?>");
        this.focusedCallback = function0;
    }

    @NotNull
    public final String getTooltip() {
        Object object = this.editBox.getTooltip();
        if (object == null || (object = object.toString()) == null) {
            object = "";
        }
        return object;
    }

    public final void setTooltip(@NotNull String v) {
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        this.editBox.setTooltip(Tooltip.create((Component)((Component)Component.literal((String)v)), (Component)((Component)Component.literal((String)v))));
    }

    public final int getCursorPos() {
        return this.editBox.getCursorPosition();
    }

    public final void setCursorPos(int v) {
        this.editBox.setCursorPosition(v);
    }

    @NotNull
    public final String getText() {
        String string = this.editBox.getValue();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getValue(...)");
        return string;
    }

    public final void setText(@NotNull String v) {
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        this.editBox.setValue(v);
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public void setX(int value) {
        super.setX(value);
        this.editBox.setX(this.getGlobalX());
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public void setY(int value) {
        super.setY(value);
        this.editBox.setY(this.getGlobalY());
    }

    @Override
    public int getW() {
        return super.getW();
    }

    @Override
    public void setW(int value) {
        super.setW(value);
        this.editBox.setWidth(value);
    }

    @Override
    public int getH() {
        return super.getH();
    }

    @Override
    public void setH(int value) {
        super.setH(value);
        this.editBox.setHeight(value);
    }

    @NotNull
    public String getPreviewText() {
        return this.previewText;
    }

    public void setPreviewText(@NotNull String v) {
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        this.editBox.setHint((Component)Component.literal((String)v).withColor(FastColor.ARGB32.colorFromFloat((float)1.0f, (float)0.5f, (float)0.5f, (float)0.5f)));
        this.previewText = v;
    }

    @NotNull
    public final Function1<String, Unit> getChangeCallback() {
        return this.changeCallback;
    }

    public final void setChangeCallback(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, (String)"<set-?>");
        this.changeCallback = function1;
    }

    @Override
    @NotNull
    public ScreenRectangle getRectangle() {
        return super.getRectangle();
    }

    public void setFocused(boolean focused) {
        this.setFocus(focused);
    }

    public boolean charTyped(char codePoint, int modifiers) {
        if (this.focus && this.isCharacterValid(codePoint, this.getCursorPos())) {
            this.editBox.charTyped(codePoint, modifiers);
            String string = this.editBox.getValue();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getValue(...)");
            this.changeCallback.invoke((Object)string);
        }
        return this.focus;
    }

    public abstract boolean isCharacterValid(char var1, int var2);

    public boolean isFocused() {
        return this.focus;
    }

    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        boolean shouldFocus;
        boolean bl = shouldFocus = this.isMouseOver((int)mouseX, (int)mouseY) && button == 0;
        if (shouldFocus && !this.focus) {
            this.editBox.onClick(mouseX, mouseY);
            this.focusedCallback.invoke();
            this.setFocus(true);
        } else if (!shouldFocus && this.focus) {
            this.unfocusedCallback.invoke();
            this.setFocus(false);
        }
        return shouldFocus;
    }

    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        this.editBox.keyPressed(keyCode, scanCode, modifiers);
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick, int globalX, int globalY) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        this.bgScaling.render(guiGraphics, this.bgTexture, this);
        if (this.editBox.getX() != globalX) {
            this.editBox.setX(globalX);
        }
        if (this.editBox.getY() != globalY) {
            this.editBox.setY(globalY);
        }
        NinePatchSettings p = this.bgScaling.getNinePatchSettings();
        guiGraphics.enableScissor(globalX + p.getL(), globalY + p.getB(), globalX + this.getW() - p.getR(), globalY + this.getH() - p.getT());
        this.editBox.renderWidget(guiGraphics, mouseX, mouseY, partialTick);
        guiGraphics.disableScissor();
    }

    private static final Unit unfocusedCallback$lambda$0() {
        return Unit.INSTANCE;
    }

    private static final Unit focusedCallback$lambda$0() {
        return Unit.INSTANCE;
    }

    private static final Unit changeCallback$lambda$0(String it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractTextField$InnerEditBox;", "Lnet/minecraft/client/gui/components/EditBox;", "<init>", "()V", "brokencore-common"})
    public static final class InnerEditBox
    extends EditBox {
        public InnerEditBox() {
            super(ClientDSLKt.getMC().font, 0, 0, 16, 16, (Component)Component.literal((String)""));
        }
    }
}

