/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.ChatFormatting
 *  net.minecraft.network.chat.ClickEvent
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.HoverEvent
 *  net.minecraft.network.chat.HoverEvent$Action
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.network.chat.Style
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.dsl;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2={"Lnet/thebrokenscript/brokencore/api/dsl/StyleConfigurator;", "", "<init>", "()V", "format", "", "Lnet/minecraft/ChatFormatting;", "getFormat", "()Ljava/util/Set;", "setFormat", "(Ljava/util/Set;)V", "hover", "Lnet/minecraft/network/chat/HoverEvent;", "getHover", "()Lnet/minecraft/network/chat/HoverEvent;", "setHover", "(Lnet/minecraft/network/chat/HoverEvent;)V", "click", "Lnet/minecraft/network/chat/ClickEvent;", "getClick", "()Lnet/minecraft/network/chat/ClickEvent;", "setClick", "(Lnet/minecraft/network/chat/ClickEvent;)V", "value", "Lnet/minecraft/network/chat/Component;", "hoverText", "getHoverText", "()Lnet/minecraft/network/chat/Component;", "setHoverText", "(Lnet/minecraft/network/chat/Component;)V", "apply", "Lnet/minecraft/network/chat/MutableComponent;", "comp", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nComponentDSL.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/StyleConfigurator\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,180:1\n37#2,2:181\n1#3:183\n*S KotlinDebug\n*F\n+ 1 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/StyleConfigurator\n*L\n163#1:181,2\n*E\n"})
public final class StyleConfigurator {
    @NotNull
    private Set<ChatFormatting> format = new LinkedHashSet();
    @Nullable
    private HoverEvent hover;
    @Nullable
    private ClickEvent click;

    @NotNull
    public final Set<ChatFormatting> getFormat() {
        return this.format;
    }

    public final void setFormat(@NotNull Set<ChatFormatting> set) {
        Intrinsics.checkNotNullParameter(set, (String)"<set-?>");
        this.format = set;
    }

    @Nullable
    public final HoverEvent getHover() {
        return this.hover;
    }

    public final void setHover(@Nullable HoverEvent hoverEvent) {
        this.hover = hoverEvent;
    }

    @Nullable
    public final ClickEvent getClick() {
        return this.click;
    }

    public final void setClick(@Nullable ClickEvent clickEvent) {
        this.click = clickEvent;
    }

    @Nullable
    public final Component getHoverText() {
        HoverEvent hoverEvent = this.hover;
        return hoverEvent != null ? (Component)hoverEvent.getValue(HoverEvent.Action.SHOW_TEXT) : null;
    }

    public final void setHoverText(@Nullable Component value) {
        this.hover = value != null ? new HoverEvent(HoverEvent.Action.SHOW_TEXT, (Object)value) : null;
    }

    @NotNull
    public final MutableComponent apply(@NotNull MutableComponent comp) {
        Intrinsics.checkNotNullParameter((Object)comp, (String)"comp");
        Collection $this$toTypedArray$iv = this.format;
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        ChatFormatting[] chatFormattingArray = thisCollection$iv.toArray(new ChatFormatting[0]);
        MutableComponent mutableComponent = comp.withStyle(Arrays.copyOf(chatFormattingArray, chatFormattingArray.length)).withStyle(arg_0 -> StyleConfigurator.apply$lambda$0(this, arg_0));
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"withStyle(...)");
        return mutableComponent;
    }

    private static final Style apply$lambda$0(StyleConfigurator this$0, Style it) {
        Style style;
        block1: {
            HoverEvent it2;
            style = null;
            style = it;
            HoverEvent hoverEvent = this$0.hover;
            if (hoverEvent != null) {
                it2 = hoverEvent;
                boolean bl = false;
                style = style.withHoverEvent(this$0.hover);
            }
            ClickEvent clickEvent = this$0.click;
            if (clickEvent == null) break block1;
            it2 = clickEvent;
            boolean bl = false;
            style = style.withClickEvent(this$0.click);
        }
        return style;
    }
}

