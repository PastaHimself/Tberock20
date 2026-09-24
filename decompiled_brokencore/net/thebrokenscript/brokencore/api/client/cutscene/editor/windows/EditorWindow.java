/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.owo.ui.component.ButtonComponent
 *  io.wispforest.owo.ui.component.ButtonComponent$Renderer
 *  io.wispforest.owo.ui.container.DraggableContainer
 *  io.wispforest.owo.ui.container.FlowLayout
 *  io.wispforest.owo.ui.core.Component
 *  io.wispforest.owo.ui.core.Insets
 *  io.wispforest.owo.ui.core.ParentComponent
 *  io.wispforest.owo.ui.core.Positioning
 *  io.wispforest.owo.ui.core.Sizing
 *  io.wispforest.owo.ui.core.Surface
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.ChatFormatting
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.client.cutscene.editor.windows;

import io.wispforest.owo.ui.component.ButtonComponent;
import io.wispforest.owo.ui.container.DraggableContainer;
import io.wispforest.owo.ui.container.FlowLayout;
import io.wispforest.owo.ui.core.Insets;
import io.wispforest.owo.ui.core.ParentComponent;
import io.wispforest.owo.ui.core.Positioning;
import io.wispforest.owo.ui.core.Sizing;
import io.wispforest.owo.ui.core.Surface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.util.Flows;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.util.OwoDSLKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\f\u0010\u0007\u001a\u00020\b*\u00020\u0002H&J\"\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\"\u0010\u000f\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0004J\"\u0010\u0014\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0004J\"\u0010\u0015\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0004J\b\u0010\u0016\u001a\u00020\bH\u0004R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lnet/thebrokenscript/brokencore/api/client/cutscene/editor/windows/EditorWindow;", "Lio/wispforest/owo/ui/container/DraggableContainer;", "Lio/wispforest/owo/ui/container/FlowLayout;", "<init>", "()V", "didInit", "", "build", "", "mount", "parent", "Lio/wispforest/owo/ui/core/ParentComponent;", "x", "", "y", "greenButton", "text", "", "callback", "Lkotlin/Function0;", "yellowButton", "redButton", "rerender", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nEditorWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EditorWindow.kt\nnet/thebrokenscript/brokencore/api/client/cutscene/editor/windows/EditorWindow\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,73:1\n75#2:74\n15#2:75\n52#2:76\n29#2:77\n24#2:78\n75#2:79\n15#2:80\n52#2:81\n29#2:82\n24#2:83\n75#2:84\n15#2:85\n52#2:86\n29#2:87\n24#2:88\n*S KotlinDebug\n*F\n+ 1 EditorWindow.kt\nnet/thebrokenscript/brokencore/api/client/cutscene/editor/windows/EditorWindow\n*L\n36#1:74\n36#1:75\n36#1:76\n36#1:77\n36#1:78\n46#1:79\n46#1:80\n46#1:81\n46#1:82\n46#1:83\n56#1:84\n56#1:85\n56#1:86\n56#1:87\n56#1:88\n*E\n"})
public abstract class EditorWindow
extends DraggableContainer<FlowLayout> {
    private boolean didInit;

    public EditorWindow() {
        super(Sizing.content(), Sizing.content(), (io.wispforest.owo.ui.core.Component)Flows.INSTANCE.vertical((Function1<? super FlowLayout, Unit>)((Function1)EditorWindow::_init_$lambda$0)));
        this.padding(Insets.none());
        this.surface(Surface.flat((int)-13421773));
        this.positioning(Positioning.absolute((int)0, (int)0));
    }

    public abstract void build(@NotNull FlowLayout var1);

    public void mount(@Nullable ParentComponent parent, int x, int y) {
        super.mount(parent, x, y);
        if (!this.didInit) {
            this.rerender();
            this.didInit = true;
        }
    }

    /*
     * WARNING - void declaration
     */
    protected final void greenButton(@NotNull FlowLayout $this$greenButton, @NotNull String text, @NotNull Function0<Unit> callback) {
        ButtonComponent buttonComponent;
        void $this$with$iv$iv$iv;
        void $this$white$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$greenButton, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        Intrinsics.checkNotNullParameter(callback, (String)"callback");
        String $this$white$iv = text;
        boolean $i$f$getWhite = false;
        String $this$c$iv$iv = $this$white$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getWhite2 = false;
        void var8_10 = $this$white$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.WHITE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        ButtonComponent $this$greenButton_u24lambda_u240 = buttonComponent = OwoDSLKt.simpleButton$default($this$greenButton, (Component)mutableComponent3, callback, null, 4, null);
        boolean bl = false;
        $this$greenButton_u24lambda_u240.renderer(ButtonComponent.Renderer.flat((int)-16742400, (int)-16733696, (int)-16768512));
    }

    /*
     * WARNING - void declaration
     */
    protected final void yellowButton(@NotNull FlowLayout $this$yellowButton, @NotNull String text, @NotNull Function0<Unit> callback) {
        ButtonComponent buttonComponent;
        void $this$with$iv$iv$iv;
        void $this$white$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$yellowButton, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        Intrinsics.checkNotNullParameter(callback, (String)"callback");
        String $this$white$iv = text;
        boolean $i$f$getWhite = false;
        String $this$c$iv$iv = $this$white$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getWhite2 = false;
        void var8_10 = $this$white$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.WHITE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        ButtonComponent $this$yellowButton_u24lambda_u240 = buttonComponent = OwoDSLKt.simpleButton$default($this$yellowButton, (Component)mutableComponent3, callback, null, 4, null);
        boolean bl = false;
        $this$yellowButton_u24lambda_u240.renderer(ButtonComponent.Renderer.flat((int)-7829504, (int)-5592576, (int)-14540288));
    }

    /*
     * WARNING - void declaration
     */
    protected final void redButton(@NotNull FlowLayout $this$redButton, @NotNull String text, @NotNull Function0<Unit> callback) {
        ButtonComponent buttonComponent;
        void $this$with$iv$iv$iv;
        void $this$white$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$redButton, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        Intrinsics.checkNotNullParameter(callback, (String)"callback");
        String $this$white$iv = text;
        boolean $i$f$getWhite = false;
        String $this$c$iv$iv = $this$white$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getWhite2 = false;
        void var8_10 = $this$white$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.WHITE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        ButtonComponent $this$redButton_u24lambda_u240 = buttonComponent = OwoDSLKt.simpleButton$default($this$redButton, (Component)mutableComponent3, callback, null, 4, null);
        boolean bl = false;
        $this$redButton_u24lambda_u240.renderer(ButtonComponent.Renderer.flat((int)-7864320, (int)-5636096, (int)-14548992));
    }

    protected final void rerender() {
        this.child((io.wispforest.owo.ui.core.Component)Flows.INSTANCE.vertical((Function1<? super FlowLayout, Unit>)((Function1)arg_0 -> EditorWindow.rerender$lambda$0(this, arg_0))));
    }

    private static final Unit _init_$lambda$0(FlowLayout $this$vertical) {
        Intrinsics.checkNotNullParameter((Object)$this$vertical, (String)"$this$vertical");
        return Unit.INSTANCE;
    }

    private static final Unit rerender$lambda$0(EditorWindow this$0, FlowLayout $this$vertical) {
        Intrinsics.checkNotNullParameter((Object)$this$vertical, (String)"$this$vertical");
        $this$vertical.padding(Insets.of((int)10));
        $this$vertical.surface(Surface.flat((int)-15658735));
        this$0.build($this$vertical);
        return Unit.INSTANCE;
    }
}

