/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.client.gui.impl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\b0\nH&J\u001c\u0010\u000b\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\b0\nH&J\u001e\u0010\f\u001a\u0004\u0018\u00010\u00002\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000e0\nH&J\b\u0010\u000f\u001a\u00020\u0010H&J\u001f\u0010\u0011\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u00002\u0006\u0010\u0013\u001a\u0002H\u0012H&\u00a2\u0006\u0002\u0010\u0014R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0000X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/impl/GuiElement;", "", "parent", "getParent", "()Lnet/thebrokenscript/brokencore/api/client/gui/impl/GuiElement;", "setParent", "(Lnet/thebrokenscript/brokencore/api/client/gui/impl/GuiElement;)V", "forEachChild", "", "consumer", "Lkotlin/Function1;", "forEachChildInTree", "findChild", "cond", "", "childCount", "", "addChild", "T", "child", "(Lnet/thebrokenscript/brokencore/api/client/gui/impl/GuiElement;)Lnet/thebrokenscript/brokencore/api/client/gui/impl/GuiElement;", "brokencore-common"})
public interface GuiElement {
    @Nullable
    public GuiElement getParent();

    public void setParent(@Nullable GuiElement var1);

    public void forEachChild(@NotNull Function1<? super GuiElement, Unit> var1);

    public void forEachChildInTree(@NotNull Function1<? super GuiElement, Unit> var1);

    @Nullable
    public GuiElement findChild(@NotNull Function1<? super GuiElement, Boolean> var1);

    public int childCount();

    @NotNull
    public <T extends GuiElement> T addChild(@NotNull T var1);
}

