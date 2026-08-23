/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.gui.GuiGraphics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.client.gui.misc;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.GuiGraphics;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractGuiNode2D;
import net.thebrokenscript.brokencore.api.client.gui.button.LabelButton;
import net.thebrokenscript.brokencore.api.client.gui.button.TextPanelButton;
import net.thebrokenscript.brokencore.api.client.gui.container.FoldingContainer;
import net.thebrokenscript.brokencore.api.client.gui.container.ScrollContainer;
import net.thebrokenscript.brokencore.api.client.gui.container.VListContainer;
import net.thebrokenscript.brokencore.api.client.gui.impl.GuiElement;
import net.thebrokenscript.brokencore.api.client.gui.settings.DropdownListSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B:\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0003J\u000e\u0010<\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0003J6\u0010=\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020'2\u0006\u0010A\u001a\u00020'2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020'2\u0006\u0010E\u001a\u00020'R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R)\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u0013X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001bX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001fX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R(\u0010#\u001a\u0004\u0018\u00010\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u0003@DX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000f\"\u0004\b%\u0010&R$\u0010(\u001a\u00020'2\u0006\u0010\"\u001a\u00020'8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010-\u001a\u00020'2\u0006\u0010\"\u001a\u00020'8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R0\u00100\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020201j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u000202`3X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u00105R$\u00106\u001a\u00020'2\u0006\u0010\"\u001a\u00020'8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b7\u0010*\"\u0004\b8\u0010,\u00a8\u0006F"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/misc/DropdownList;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractGuiNode2D;", "emptyPreviewText", "", "settings", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/DropdownListSettings;", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "selected", "", "<init>", "(Ljava/lang/String;Lnet/thebrokenscript/brokencore/api/client/gui/settings/DropdownListSettings;Lkotlin/jvm/functions/Function1;)V", "getEmptyPreviewText", "()Ljava/lang/String;", "getSettings", "()Lnet/thebrokenscript/brokencore/api/client/gui/settings/DropdownListSettings;", "previewButton", "Lnet/thebrokenscript/brokencore/api/client/gui/button/TextPanelButton;", "getPreviewButton", "()Lnet/thebrokenscript/brokencore/api/client/gui/button/TextPanelButton;", "foldingContainer", "Lnet/thebrokenscript/brokencore/api/client/gui/container/FoldingContainer;", "getFoldingContainer", "()Lnet/thebrokenscript/brokencore/api/client/gui/container/FoldingContainer;", "scrollContainer", "Lnet/thebrokenscript/brokencore/api/client/gui/container/ScrollContainer;", "getScrollContainer", "()Lnet/thebrokenscript/brokencore/api/client/gui/container/ScrollContainer;", "vBoxContainer", "Lnet/thebrokenscript/brokencore/api/client/gui/container/VListContainer;", "getVBoxContainer", "()Lnet/thebrokenscript/brokencore/api/client/gui/container/VListContainer;", "v", "selectedText", "getSelectedText", "setSelectedText", "(Ljava/lang/String;)V", "", "w", "getW", "()I", "setW", "(I)V", "h", "getH", "setH", "buttons", "Ljava/util/HashMap;", "Lnet/thebrokenscript/brokencore/api/client/gui/button/LabelButton;", "Lkotlin/collections/HashMap;", "getButtons", "()Ljava/util/HashMap;", "minHeight", "getMinHeight", "setMinHeight", "addEntry", "", "text", "removeEntry", "render", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "mouseX", "mouseY", "partialTick", "", "globalX", "globalY", "brokencore-common"})
public class DropdownList
extends AbstractGuiNode2D {
    @NotNull
    private final String emptyPreviewText;
    @NotNull
    private final DropdownListSettings settings;
    @NotNull
    private final Function1<String, Unit> callback;
    @NotNull
    private final TextPanelButton previewButton;
    @NotNull
    private final FoldingContainer foldingContainer;
    @NotNull
    private final ScrollContainer scrollContainer;
    @NotNull
    private final VListContainer vBoxContainer;
    @Nullable
    private String selectedText;
    @NotNull
    private final HashMap<String, LabelButton> buttons;

    public DropdownList(@NotNull String emptyPreviewText, @NotNull DropdownListSettings settings, @NotNull Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter((Object)emptyPreviewText, (String)"emptyPreviewText");
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        Intrinsics.checkNotNullParameter(callback, (String)"callback");
        super(0, 0, 0, 0, 15, null);
        this.emptyPreviewText = emptyPreviewText;
        this.settings = settings;
        this.callback = callback;
        this.previewButton = (TextPanelButton)this.addChild((GuiElement)this.settings.getPreviewSettings().create(this.emptyPreviewText, (Function0<Unit>)((Function0)() -> DropdownList.previewButton$lambda$0(this))));
        this.foldingContainer = (FoldingContainer)this.addChild((GuiElement)new FoldingContainer());
        this.scrollContainer = (ScrollContainer)this.foldingContainer.addChild((GuiElement)this.settings.getScrollContainerSettings().create());
        this.vBoxContainer = (VListContainer)this.scrollContainer.addChild((GuiElement)new VListContainer(0));
        this.foldingContainer.setFolded(true);
        this.foldingContainer.setY(this.settings.getBgHeight());
        this.scrollContainer.updateChildren();
        this.scrollContainer.setW(this.getW());
        this.scrollContainer.setH(this.getH() - this.settings.getBgHeight());
        this.vBoxContainer.setX(this.settings.getBgScaling().getL());
        this.buttons = new HashMap();
    }

    @NotNull
    public final String getEmptyPreviewText() {
        return this.emptyPreviewText;
    }

    @NotNull
    public final DropdownListSettings getSettings() {
        return this.settings;
    }

    @NotNull
    protected final TextPanelButton getPreviewButton() {
        return this.previewButton;
    }

    @NotNull
    protected final FoldingContainer getFoldingContainer() {
        return this.foldingContainer;
    }

    @NotNull
    protected final ScrollContainer getScrollContainer() {
        return this.scrollContainer;
    }

    @NotNull
    protected final VListContainer getVBoxContainer() {
        return this.vBoxContainer;
    }

    @Nullable
    protected final String getSelectedText() {
        return this.selectedText;
    }

    protected final void setSelectedText(@Nullable String v) {
        if (v != null) {
            this.previewButton.setText(v);
        } else {
            this.previewButton.setText(this.emptyPreviewText);
        }
        this.selectedText = v;
    }

    @Override
    public int getW() {
        return super.getW();
    }

    @Override
    public void setW(int v) {
        this.previewButton.setW(v);
        this.foldingContainer.setW(v);
        this.vBoxContainer.setW(v);
        this.scrollContainer.setW(v);
        this.vBoxContainer.forEachChild((Function1<? super GuiElement, Unit>)((Function1)arg_0 -> DropdownList._set_w_$lambda$0(v, arg_0)));
        this.scrollContainer.setW(this.getW());
        this.scrollContainer.setH(this.getH() - this.settings.getBgHeight());
        super.setW(v);
    }

    @Override
    public int getH() {
        return super.getH();
    }

    @Override
    public void setH(int v) {
        super.setH(v);
        this.foldingContainer.setH(v - this.settings.getBgHeight());
        this.vBoxContainer.setH(v - this.settings.getBgHeight());
        this.scrollContainer.setH(v - this.settings.getBgHeight());
        this.scrollContainer.setW(this.getW());
        this.scrollContainer.setH(this.getH() - this.settings.getBgHeight());
    }

    @NotNull
    protected final HashMap<String, LabelButton> getButtons() {
        return this.buttons;
    }

    @Override
    public final int getMinHeight() {
        return Math.max(super.getMinHeight(), this.settings.getBgHeight());
    }

    @Override
    public final void setMinHeight(int v) {
        super.setMinHeight(v);
    }

    public final boolean addEntry(@NotNull String text) {
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        LabelButton button = (LabelButton)this.vBoxContainer.addChild((GuiElement)this.settings.getEntrySettings().create(text, (Function0<Unit>)((Function0)() -> DropdownList.addEntry$lambda$0(this, text))));
        LabelButton prevButton = this.buttons.putIfAbsent(text, button);
        if (prevButton == null) {
            this.vBoxContainer.addChild((GuiElement)button);
            button.setH(7);
        }
        this.vBoxContainer.updateChildren();
        this.vBoxContainer.setH(this.vBoxContainer.getMinHeight());
        this.scrollContainer.setW(this.getW());
        this.scrollContainer.setH(this.getH() - this.settings.getBgHeight());
        return prevButton == null;
    }

    public final boolean removeEntry(@NotNull String text) {
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        LabelButton labelButton = this.buttons.get(text);
        if (labelButton != null) {
            LabelButton it = labelButton;
            boolean bl = false;
            this.buttons.remove(text);
            this.getChildren().remove(it);
            if (Intrinsics.areEqual((Object)this.selectedText, (Object)text)) {
                this.setSelectedText(null);
            }
        }
        this.vBoxContainer.updateChildren();
        this.vBoxContainer.setH(this.vBoxContainer.getMinHeight());
        this.scrollContainer.setW(this.getW());
        this.scrollContainer.setH(this.getH() - this.settings.getBgHeight());
        if (this.getChildren().isEmpty()) {
            this.setSelectedText(null);
        }
        return false;
    }

    @Override
    public final void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick, int globalX, int globalY) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        this.previewButton.setW(this.getW());
        if (this.foldingContainer.getVisible()) {
            this.settings.getBgScaling().render(guiGraphics, this.settings.getBgSprite(), globalX, globalY + this.settings.getBgHeight(), this.getZIndex(), this.getW(), Math.min(this.vBoxContainer.getH(), this.getH() - this.settings.getBgHeight()));
        }
    }

    private static final Unit previewButton$lambda$0(DropdownList this$0) {
        this$0.foldingContainer.setFolded(!this$0.foldingContainer.getFolded());
        return Unit.INSTANCE;
    }

    private static final Unit _set_w_$lambda$0(int $v, GuiElement it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        if (it instanceof AbstractGuiNode2D) {
            ((AbstractGuiNode2D)it).setW($v);
        }
        return Unit.INSTANCE;
    }

    private static final Unit addEntry$lambda$0(DropdownList this$0, String $text) {
        this$0.setSelectedText($text);
        this$0.foldingContainer.setFolded(true);
        this$0.callback.invoke((Object)$text);
        return Unit.INSTANCE;
    }
}

