/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.owo.ui.container.Containers
 *  io.wispforest.owo.ui.container.FlowLayout
 *  io.wispforest.owo.ui.container.ScrollContainer
 *  io.wispforest.owo.ui.container.ScrollContainer$Scrollbar
 *  io.wispforest.owo.ui.core.Color
 *  io.wispforest.owo.ui.core.Component
 *  io.wispforest.owo.ui.core.HorizontalAlignment
 *  io.wispforest.owo.ui.core.Insets
 *  io.wispforest.owo.ui.core.Sizing
 *  io.wispforest.owo.ui.core.VerticalAlignment
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.cutscene.editor.util;

import io.wispforest.owo.ui.container.Containers;
import io.wispforest.owo.ui.container.FlowLayout;
import io.wispforest.owo.ui.container.ScrollContainer;
import io.wispforest.owo.ui.core.Color;
import io.wispforest.owo.ui.core.Component;
import io.wispforest.owo.ui.core.HorizontalAlignment;
import io.wispforest.owo.ui.core.Insets;
import io.wispforest.owo.ui.core.Sizing;
import io.wispforest.owo.ui.core.VerticalAlignment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import org.jetbrains.annotations.NotNull;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\b\tJ\u001f\u0010\n\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\b\tJ-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\r\u001a\u00020\u000e2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\b\t\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/api/client/cutscene/editor/util/Flows;", "", "<init>", "()V", "vertical", "Lio/wispforest/owo/ui/container/FlowLayout;", "func", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "horizontal", "verticalScroll", "Lio/wispforest/owo/ui/container/ScrollContainer;", "size", "Lio/wispforest/owo/ui/core/Sizing;", "brokencore-common"})
public final class Flows {
    @NotNull
    public static final Flows INSTANCE = new Flows();

    private Flows() {
    }

    @NotNull
    public final FlowLayout vertical(@NotNull Function1<? super FlowLayout, Unit> func) {
        FlowLayout flowLayout;
        Intrinsics.checkNotNullParameter(func, (String)"func");
        FlowLayout $this$vertical_u24lambda_u240 = flowLayout = Containers.verticalFlow((Sizing)Sizing.content(), (Sizing)Sizing.content());
        boolean bl = false;
        $this$vertical_u24lambda_u240.verticalAlignment(VerticalAlignment.CENTER);
        $this$vertical_u24lambda_u240.horizontalAlignment(HorizontalAlignment.LEFT);
        func.invoke((Object)flowLayout);
        FlowLayout flowLayout2 = flowLayout;
        Intrinsics.checkNotNullExpressionValue((Object)flowLayout2, (String)"apply(...)");
        return flowLayout2;
    }

    @NotNull
    public final FlowLayout horizontal(@NotNull Function1<? super FlowLayout, Unit> func) {
        FlowLayout flowLayout;
        Intrinsics.checkNotNullParameter(func, (String)"func");
        FlowLayout $this$horizontal_u24lambda_u240 = flowLayout = Containers.horizontalFlow((Sizing)Sizing.content(), (Sizing)Sizing.content());
        boolean bl = false;
        $this$horizontal_u24lambda_u240.verticalAlignment(VerticalAlignment.CENTER);
        $this$horizontal_u24lambda_u240.horizontalAlignment(HorizontalAlignment.LEFT);
        func.invoke((Object)flowLayout);
        FlowLayout flowLayout2 = flowLayout;
        Intrinsics.checkNotNullExpressionValue((Object)flowLayout2, (String)"apply(...)");
        return flowLayout2;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final ScrollContainer<FlowLayout> verticalScroll(@NotNull Sizing size, @NotNull Function1<? super FlowLayout, Unit> func) {
        void $this$verticalScroll_u24lambda_u240;
        FlowLayout flowLayout;
        Intrinsics.checkNotNullParameter((Object)size, (String)"size");
        Intrinsics.checkNotNullParameter(func, (String)"func");
        FlowLayout flowLayout2 = flowLayout = this.vertical(func);
        Sizing sizing = size;
        Sizing sizing2 = Sizing.content();
        boolean bl = false;
        $this$verticalScroll_u24lambda_u240.padding(((Insets)$this$verticalScroll_u24lambda_u240.padding().get()).add(0, 0, 0, 8));
        Unit unit = Unit.INSTANCE;
        FlowLayout $this$verticalScroll_u24lambda_u241 = flowLayout = Containers.verticalScroll((Sizing)sizing2, (Sizing)sizing, (Component)((Component)flowLayout));
        boolean bl2 = false;
        $this$verticalScroll_u24lambda_u241.scrollbar(ScrollContainer.Scrollbar.flat((Color)Color.ofArgb((int)-1996488705)));
        FlowLayout flowLayout3 = flowLayout;
        Intrinsics.checkNotNullExpressionValue((Object)flowLayout3, (String)"apply(...)");
        return flowLayout3;
    }
}

