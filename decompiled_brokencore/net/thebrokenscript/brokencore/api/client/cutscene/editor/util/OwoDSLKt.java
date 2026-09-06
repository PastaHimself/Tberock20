/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.owo.ui.component.ButtonComponent
 *  io.wispforest.owo.ui.component.ButtonComponent$Renderer
 *  io.wispforest.owo.ui.component.Components
 *  io.wispforest.owo.ui.component.LabelComponent
 *  io.wispforest.owo.ui.container.Containers
 *  io.wispforest.owo.ui.container.DraggableContainer
 *  io.wispforest.owo.ui.container.FlowLayout
 *  io.wispforest.owo.ui.core.Color
 *  io.wispforest.owo.ui.core.Component
 *  io.wispforest.owo.ui.core.Sizing
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  net.minecraft.network.chat.Component
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.cutscene.editor.util;

import io.wispforest.owo.ui.component.ButtonComponent;
import io.wispforest.owo.ui.component.Components;
import io.wispforest.owo.ui.component.LabelComponent;
import io.wispforest.owo.ui.container.Containers;
import io.wispforest.owo.ui.container.DraggableContainer;
import io.wispforest.owo.ui.container.FlowLayout;
import io.wispforest.owo.ui.core.Color;
import io.wispforest.owo.ui.core.Sizing;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.minecraft.network.chat.Component;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\u001aA\u0010\n\u001a\u00020\u000b*\u00020\f2\n\u0010\r\u001a\u00060\u0001j\u0002`\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0019\b\u0002\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00110\u0013\u00a2\u0006\u0002\b\u0014H\u0007\u001a1\u0010\u0015\u001a\u00020\u000b*\u00020\f2\n\u0010\r\u001a\u00060\u0001j\u0002`\u000e2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00110\u0013\u00a2\u0006\u0002\b\u0014H\u0007\u001aJ\u0010\u0015\u001a\u00020\u000b*\u00020\f2\n\u0010\r\u001a\u00060\u0001j\u0002`\u000e2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00110\u0013\u00a2\u0006\u0002\b\u00142\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00110\u0013\u00a2\u0006\u0002\b\u0014H\u0007\u001a\u0018\u0010\r\u001a\u00020\u0016*\u00020\f2\n\u0010\r\u001a\u00060\u0001j\u0002`\u000eH\u0007\u001a\u0014\u0010\r\u001a\u00020\u0016*\u00020\f2\u0006\u0010\r\u001a\u00020\u0017H\u0007\u001a\u0016\u0010\u0018\u001a\u00020\u0011*\u00020\f2\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0007\u001a\u001c\u0010\u001b\u001a\u00020\u0011*\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aH\u0007\u001a$\u0010\u001e\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 H\u0007\".\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\b\b\u0000\u0010\u0004*\u00020\u0005*\u0002H\u00048FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t*\n\u0010\u0000\"\u00020\u00012\u00020\u0001\u00a8\u0006#"}, d2={"Text", "Lnet/minecraft/network/chat/Component;", "draggable", "Lio/wispforest/owo/ui/container/DraggableContainer;", "C", "Lio/wispforest/owo/ui/core/Component;", "getDraggable$annotations", "(Lio/wispforest/owo/ui/core/Component;)V", "getDraggable", "(Lio/wispforest/owo/ui/core/Component;)Lio/wispforest/owo/ui/container/DraggableContainer;", "simpleButton", "Lio/wispforest/owo/ui/component/ButtonComponent;", "Lio/wispforest/owo/ui/container/FlowLayout;", "text", "Lnet/thebrokenscript/brokencore/api/client/cutscene/editor/util/Text;", "callback", "Lkotlin/Function0;", "", "config", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "button", "Lio/wispforest/owo/ui/component/LabelComponent;", "", "space", "count", "", "spacer", "x", "y", "colored", "normal", "", "hover", "disabled", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nOwoDSL.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OwoDSL.kt\nnet/thebrokenscript/brokencore/api/client/cutscene/editor/util/OwoDSLKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,77:1\n1#2:78\n15#3:79\n*S KotlinDebug\n*F\n+ 1 OwoDSL.kt\nnet/thebrokenscript/brokencore/api/client/cutscene/editor/util/OwoDSLKt\n*L\n40#1:79\n*E\n"})
public final class OwoDSLKt {
    @NotNull
    public static final <C extends io.wispforest.owo.ui.core.Component> DraggableContainer<C> getDraggable(@NotNull C $this$draggable) {
        Intrinsics.checkNotNullParameter($this$draggable, (String)"<this>");
        DraggableContainer draggableContainer = Containers.draggable((Sizing)Sizing.content(), (Sizing)Sizing.content(), $this$draggable);
        Intrinsics.checkNotNullExpressionValue((Object)draggableContainer, (String)"draggable(...)");
        return draggableContainer;
    }

    @SideOnly(side=Side.CLIENT)
    public static /* synthetic */ void getDraggable$annotations(io.wispforest.owo.ui.core.Component component) {
    }

    @SideOnly(side=Side.CLIENT)
    @NotNull
    public static final ButtonComponent simpleButton(@NotNull FlowLayout $this$simpleButton, @NotNull Component text, @NotNull Function0<Unit> callback, @NotNull Function1<? super ButtonComponent, Unit> config) {
        Intrinsics.checkNotNullParameter((Object)$this$simpleButton, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        Intrinsics.checkNotNullParameter(callback, (String)"callback");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        ButtonComponent buttonComponent = Components.button((Component)text, arg_0 -> OwoDSLKt.simpleButton$lambda$1(callback, arg_0));
        config.invoke((Object)buttonComponent);
        io.wispforest.owo.ui.core.Component p0 = (io.wispforest.owo.ui.core.Component)buttonComponent;
        boolean bl = false;
        $this$simpleButton.child(p0);
        ButtonComponent buttonComponent2 = buttonComponent;
        Intrinsics.checkNotNullExpressionValue((Object)buttonComponent2, (String)"also(...)");
        return buttonComponent2;
    }

    public static /* synthetic */ ButtonComponent simpleButton$default(FlowLayout flowLayout, Component component, Function0 function0, Function1 function1, int n, Object object) {
        if ((n & 4) != 0) {
            function1 = OwoDSLKt::simpleButton$lambda$0;
        }
        return OwoDSLKt.simpleButton(flowLayout, component, (Function0<Unit>)function0, (Function1<? super ButtonComponent, Unit>)function1);
    }

    @SideOnly(side=Side.CLIENT)
    @NotNull
    public static final ButtonComponent button(@NotNull FlowLayout $this$button, @NotNull Component text, @NotNull Function1<? super ButtonComponent, Unit> callback) {
        Intrinsics.checkNotNullParameter((Object)$this$button, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        Intrinsics.checkNotNullParameter(callback, (String)"callback");
        ButtonComponent buttonComponent = Components.button((Component)text, arg_0 -> OwoDSLKt.button$lambda$0(callback, arg_0));
        io.wispforest.owo.ui.core.Component p0 = (io.wispforest.owo.ui.core.Component)buttonComponent;
        boolean bl = false;
        $this$button.child(p0);
        ButtonComponent buttonComponent2 = buttonComponent;
        Intrinsics.checkNotNullExpressionValue((Object)buttonComponent2, (String)"also(...)");
        return buttonComponent2;
    }

    @SideOnly(side=Side.CLIENT)
    @NotNull
    public static final ButtonComponent button(@NotNull FlowLayout $this$button, @NotNull Component text, @NotNull Function1<? super ButtonComponent, Unit> callback, @NotNull Function1<? super ButtonComponent, Unit> config) {
        Intrinsics.checkNotNullParameter((Object)$this$button, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        Intrinsics.checkNotNullParameter(callback, (String)"callback");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        ButtonComponent buttonComponent = Components.button((Component)text, arg_0 -> OwoDSLKt.button$lambda$1(callback, arg_0));
        config.invoke((Object)buttonComponent);
        io.wispforest.owo.ui.core.Component p0 = (io.wispforest.owo.ui.core.Component)buttonComponent;
        boolean bl = false;
        $this$button.child(p0);
        ButtonComponent buttonComponent2 = buttonComponent;
        Intrinsics.checkNotNullExpressionValue((Object)buttonComponent2, (String)"also(...)");
        return buttonComponent2;
    }

    @SideOnly(side=Side.CLIENT)
    @NotNull
    public static final LabelComponent text(@NotNull FlowLayout $this$text, @NotNull Component text) {
        Intrinsics.checkNotNullParameter((Object)$this$text, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        LabelComponent labelComponent = Components.label((Component)text);
        io.wispforest.owo.ui.core.Component p0 = (io.wispforest.owo.ui.core.Component)labelComponent;
        boolean bl = false;
        $this$text.child(p0);
        LabelComponent labelComponent2 = labelComponent;
        Intrinsics.checkNotNullExpressionValue((Object)labelComponent2, (String)"also(...)");
        return labelComponent2;
    }

    @SideOnly(side=Side.CLIENT)
    @NotNull
    public static final LabelComponent text(@NotNull FlowLayout $this$text, @NotNull String text) {
        Intrinsics.checkNotNullParameter((Object)$this$text, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        String $this$c$iv = text;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        LabelComponent labelComponent = Components.label((Component)component);
        io.wispforest.owo.ui.core.Component p0 = (io.wispforest.owo.ui.core.Component)labelComponent;
        boolean bl = false;
        $this$text.child(p0);
        LabelComponent labelComponent2 = labelComponent;
        Intrinsics.checkNotNullExpressionValue((Object)labelComponent2, (String)"also(...)");
        return labelComponent2;
    }

    @SideOnly(side=Side.CLIENT)
    public static final void space(@NotNull FlowLayout $this$space, int count) {
        Intrinsics.checkNotNullParameter((Object)$this$space, (String)"<this>");
        MiscExt.void(OwoDSLKt.text($this$space, StringsKt.repeat((CharSequence)" ", (int)count)));
    }

    public static /* synthetic */ void space$default(FlowLayout flowLayout, int n, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = 1;
        }
        OwoDSLKt.space(flowLayout, n);
    }

    @SideOnly(side=Side.CLIENT)
    public static final void spacer(@NotNull FlowLayout $this$spacer, int x, int y) {
        Intrinsics.checkNotNullParameter((Object)$this$spacer, (String)"<this>");
        MiscExt.void($this$spacer.child((io.wispforest.owo.ui.core.Component)Components.box((Sizing)Sizing.fixed((int)x), (Sizing)Sizing.fixed((int)y)).color(Color.ofArgb((int)0))));
    }

    @SideOnly(side=Side.CLIENT)
    @NotNull
    public static final ButtonComponent colored(@NotNull ButtonComponent $this$colored, long normal, long hover, long disabled) {
        Intrinsics.checkNotNullParameter((Object)$this$colored, (String)"<this>");
        ButtonComponent buttonComponent = $this$colored.renderer(ButtonComponent.Renderer.flat((int)((int)normal), (int)((int)hover), (int)((int)disabled)));
        Intrinsics.checkNotNullExpressionValue((Object)buttonComponent, (String)"renderer(...)");
        return buttonComponent;
    }

    private static final Unit simpleButton$lambda$0(ButtonComponent buttonComponent) {
        Intrinsics.checkNotNullParameter((Object)buttonComponent, (String)"<this>");
        return Unit.INSTANCE;
    }

    private static final void simpleButton$lambda$1(Function0 $callback, ButtonComponent it) {
        $callback.invoke();
    }

    private static final void button$lambda$0(Function1 $tmp0, ButtonComponent p0) {
        $tmp0.invoke((Object)p0);
    }

    private static final void button$lambda$1(Function1 $tmp0, ButtonComponent p0) {
        $tmp0.invoke((Object)p0);
    }
}

