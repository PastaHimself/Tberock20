/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.renderer.MultiBufferSource
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.client.gui.abstr;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.renderer.MultiBufferSource;
import net.thebrokenscript.brokencore.api.client.gui.impl.GuiElement;
import net.thebrokenscript.brokencore.api.debug.Debuggable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000f0\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000f0\u0011J\u001f\u0010\u0013\u001a\u0002H\u0014\"\b\b\u0000\u0010\u0014*\u00020\u00012\u0006\u0010\u0015\u001a\u0002H\u0014H\u0016\u00a2\u0006\u0002\u0010\u0016J\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00190\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u000fH\u0016J\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0001X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\""}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractGuiNode;", "Lnet/thebrokenscript/brokencore/api/client/gui/impl/GuiElement;", "Lnet/thebrokenscript/brokencore/api/debug/Debuggable;", "<init>", "()V", "parent", "getParent", "()Lnet/thebrokenscript/brokencore/api/client/gui/impl/GuiElement;", "setParent", "(Lnet/thebrokenscript/brokencore/api/client/gui/impl/GuiElement;)V", "children", "", "getChildren", "()Ljava/util/List;", "forEachChild", "", "consumer", "Lkotlin/Function1;", "forEachChildInTree", "addChild", "T", "child", "(Lnet/thebrokenscript/brokencore/api/client/gui/impl/GuiElement;)Lnet/thebrokenscript/brokencore/api/client/gui/impl/GuiElement;", "findChild", "cond", "", "childCount", "", "tickDebug", "renderDebug", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "buffer", "Lnet/minecraft/client/renderer/MultiBufferSource;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nAbstractGuiNode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractGuiNode.kt\nnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractGuiNode\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,44:1\n1869#2,2:45\n1869#2,2:47\n*S KotlinDebug\n*F\n+ 1 AbstractGuiNode.kt\nnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractGuiNode\n*L\n17#1:45,2\n25#1:47,2\n*E\n"})
public abstract class AbstractGuiNode
implements GuiElement,
Debuggable {
    @Nullable
    private GuiElement parent;
    @NotNull
    private final List<GuiElement> children = new ArrayList();

    @Override
    @Nullable
    public GuiElement getParent() {
        return this.parent;
    }

    @Override
    public void setParent(@Nullable GuiElement guiElement) {
        this.parent = guiElement;
    }

    @NotNull
    protected final List<GuiElement> getChildren() {
        return this.children;
    }

    @Override
    public void forEachChild(@NotNull Function1<? super GuiElement, Unit> consumer) {
        Intrinsics.checkNotNullParameter(consumer, (String)"consumer");
        Iterable $this$forEach$iv = this.children;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            GuiElement it = (GuiElement)element$iv;
            boolean bl = false;
            if (it == null) continue;
            consumer.invoke((Object)it);
        }
    }

    @Override
    public final void forEachChildInTree(@NotNull Function1<? super GuiElement, Unit> consumer) {
        Intrinsics.checkNotNullParameter(consumer, (String)"consumer");
        ArrayList copy = new ArrayList(this.children);
        Iterable $this$forEach$iv = copy;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            GuiElement it = (GuiElement)element$iv;
            boolean bl = false;
            if (it == null) continue;
            it.forEachChildInTree(consumer);
            consumer.invoke((Object)it);
        }
    }

    @Override
    @NotNull
    public <T extends GuiElement> T addChild(@NotNull T child) {
        Intrinsics.checkNotNullParameter(child, (String)"child");
        child.setParent(this);
        this.children.add(child);
        return child;
    }

    @Override
    @Nullable
    public GuiElement findChild(@NotNull Function1<? super GuiElement, Boolean> cond) {
        Object v0;
        block1: {
            Intrinsics.checkNotNullParameter(cond, (String)"cond");
            Iterable iterable = this.children;
            for (Object t : iterable) {
                if (!((Boolean)cond.invoke(t)).booleanValue()) continue;
                v0 = t;
                break block1;
            }
            v0 = null;
        }
        return v0;
    }

    @Override
    public int childCount() {
        return this.children.size();
    }

    @Override
    public void tickDebug() {
    }

    @Override
    public void renderDebug(@NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer) {
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
    }
}

