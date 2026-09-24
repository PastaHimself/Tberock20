/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.components.Renderable
 *  net.minecraft.client.gui.components.events.GuiEventListener
 *  net.minecraft.client.gui.screens.Screen
 *  net.minecraft.network.chat.Component
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Matrix4f
 *  org.joml.Quaternionf
 */
package net.thebrokenscript.brokencore.api.client.gui.util;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractGuiNode2D;
import net.thebrokenscript.brokencore.api.client.gui.impl.GuiElement;
import net.thebrokenscript.brokencore.api.client.util.ClientMixinBridge;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Quaternionf;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\f\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0013\u001a\u0002H\u0014\"\b\b\u0000\u0010\u0014*\u00020\u00062\u0006\u0010\u0015\u001a\u0002H\u0014\u00a2\u0006\u0002\u0010\u0016J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u001f\u0010\u001e\u001a\u0004\u0018\u0001H\u0014\"\b\b\u0000\u0010\u0014*\u00020\u00062\u0006\u0010\u0015\u001a\u0002H\u0014\u00a2\u0006\u0002\u0010\u0016J(\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%H\u0016J \u0010&\u001a\u00020'2\u0006\u0010\"\u001a\u00020(2\u0006\u0010#\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001cH\u0016J \u0010*\u001a\u00020'2\u0006\u0010\"\u001a\u00020(2\u0006\u0010#\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001cH\u0016J\u0018\u0010+\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020(2\u0006\u0010#\u001a\u00020(H\u0016J(\u0010,\u001a\u00020'2\u0006\u0010\"\u001a\u00020(2\u0006\u0010#\u001a\u00020(2\u0006\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020(H\u0016J\b\u0010/\u001a\u00020'H\u0016J \u00100\u001a\u00020'2\u0006\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\u001cH\u0016J \u00104\u001a\u00020'2\u0006\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\u001cH\u0016J\u0018\u00105\u001a\u00020'2\u0006\u00106\u001a\u0002072\u0006\u00103\u001a\u00020\u001cH\u0016J0\u00108\u001a\u00020'2\u0006\u0010\"\u001a\u00020(2\u0006\u0010#\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001c2\u0006\u00109\u001a\u00020(2\u0006\u0010:\u001a\u00020(H\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006;"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/util/HierarchyScreen;", "Lnet/minecraft/client/gui/screens/Screen;", "<init>", "()V", "children", "", "Lnet/thebrokenscript/brokencore/api/client/gui/impl/GuiElement;", "getChildren", "()Ljava/util/List;", "projMat", "Lorg/joml/Matrix4f;", "getProjMat", "()Lorg/joml/Matrix4f;", "modelMat", "getModelMat", "cameraQuaternion", "Lorg/joml/Quaternionf;", "getCameraQuaternion", "()Lorg/joml/Quaternionf;", "addChild", "T", "element", "(Lnet/thebrokenscript/brokencore/api/client/gui/impl/GuiElement;)Lnet/thebrokenscript/brokencore/api/client/gui/impl/GuiElement;", "resize", "", "minecraft", "Lnet/minecraft/client/Minecraft;", "width", "", "height", "removeChild", "render", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "mouseX", "mouseY", "partialTick", "", "mouseClicked", "", "", "button", "mouseReleased", "mouseMoved", "mouseScrolled", "scrollX", "scrollY", "isFocused", "keyPressed", "keyCode", "scanCode", "modifiers", "keyReleased", "charTyped", "codePoint", "", "mouseDragged", "dragX", "dragY", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nHierarchyScreen.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HierarchyScreen.kt\nnet/thebrokenscript/brokencore/api/client/gui/util/HierarchyScreen\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,134:1\n1869#2,2:135\n1869#2,2:137\n1869#2,2:139\n1869#2,2:141\n1869#2,2:143\n1869#2,2:145\n1869#2,2:147\n1869#2,2:149\n1869#2,2:151\n1869#2,2:153\n*S KotlinDebug\n*F\n+ 1 HierarchyScreen.kt\nnet/thebrokenscript/brokencore/api/client/gui/util/HierarchyScreen\n*L\n35#1:135,2\n47#1:137,2\n53#1:139,2\n64#1:141,2\n74#1:143,2\n83#1:145,2\n95#1:147,2\n107#1:149,2\n117#1:151,2\n126#1:153,2\n*E\n"})
public abstract class HierarchyScreen
extends Screen {
    @NotNull
    private final List<GuiElement> children = new ArrayList();

    public HierarchyScreen() {
        super((Component)Component.literal((String)""));
    }

    @NotNull
    protected final List<GuiElement> getChildren() {
        return this.children;
    }

    @NotNull
    public Matrix4f getProjMat() {
        return MiscExt.getProjectionMatrix(ClientDSLKt.getMC());
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public Matrix4f getModelMat() {
        void var3_3;
        HierarchyScreen $this$_get_modelMat__u24lambda_u240 = this;
        boolean bl = false;
        Matrix4f mat = new Matrix4f().identity();
        Vec3 pos = ClientDSLKt.getMC().gameRenderer.getMainCamera().getPosition();
        mat.translate((float)pos.x, (float)pos.y, (float)pos.z);
        void v0 = var3_3;
        Intrinsics.checkNotNullExpressionValue((Object)v0, (String)"run(...)");
        return v0;
    }

    @NotNull
    public Quaternionf getCameraQuaternion() {
        return ClientMixinBridge.INSTANCE.getCameraQuaternion(ClientDSLKt.getMC());
    }

    @NotNull
    public final <T extends GuiElement> T addChild(@NotNull T element) {
        Intrinsics.checkNotNullParameter(element, (String)"element");
        this.children.add(element);
        return element;
    }

    public void resize(@NotNull Minecraft minecraft, int width, int height) {
        Intrinsics.checkNotNullParameter((Object)minecraft, (String)"minecraft");
        Iterable $this$forEach$iv = this.children;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            GuiElement it = (GuiElement)element$iv;
            boolean bl = false;
            if (!(it instanceof AbstractGuiNode2D)) continue;
            ((AbstractGuiNode2D)it).setW(width);
            ((AbstractGuiNode2D)it).setH(height);
        }
        super.resize(minecraft, width, height);
    }

    @Nullable
    public final <T extends GuiElement> T removeChild(@NotNull T element) {
        Intrinsics.checkNotNullParameter(element, (String)"element");
        return (T)(this.children.remove(element) ? element : null);
    }

    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        Iterable $this$forEach$iv = this.children;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            GuiElement it = (GuiElement)element$iv;
            boolean bl = false;
            if (!(it instanceof Renderable)) continue;
            ((Renderable)it).render(guiGraphics, mouseX, mouseY, partialTick);
        }
    }

    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        Iterable $this$forEach$iv = this.children;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            GuiElement element = (GuiElement)element$iv;
            boolean bl = false;
            if (element instanceof GuiEventListener) {
                ((GuiEventListener)element).mouseClicked(mouseX, mouseY, button);
            }
            element.forEachChildInTree((Function1<? super GuiElement, Unit>)((Function1)arg_0 -> HierarchyScreen.mouseClicked$lambda$0$0(mouseX, mouseY, button, arg_0)));
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        Iterable $this$forEach$iv = this.children;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            GuiElement element = (GuiElement)element$iv;
            boolean bl = false;
            if (element instanceof GuiEventListener) {
                ((GuiEventListener)element).mouseReleased(mouseX, mouseY, button);
            }
            element.forEachChildInTree((Function1<? super GuiElement, Unit>)((Function1)arg_0 -> HierarchyScreen.mouseReleased$lambda$0$0(mouseX, mouseY, button, arg_0)));
        }
        return super.mouseReleased(mouseX, mouseY, button);
    }

    public void mouseMoved(double mouseX, double mouseY) {
        Iterable $this$forEach$iv = this.children;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            GuiElement element = (GuiElement)element$iv;
            boolean bl = false;
            if (element instanceof GuiEventListener) {
                ((GuiEventListener)element).mouseMoved(mouseX, mouseY);
            }
            element.forEachChildInTree((Function1<? super GuiElement, Unit>)((Function1)arg_0 -> HierarchyScreen.mouseMoved$lambda$0$0(mouseX, mouseY, arg_0)));
        }
    }

    public boolean mouseScrolled(double mouseX, double mouseY, double scrollX, double scrollY) {
        Iterable $this$forEach$iv = this.children;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            GuiElement element = (GuiElement)element$iv;
            boolean bl = false;
            if (element instanceof GuiEventListener) {
                ((GuiEventListener)element).mouseScrolled(mouseX, mouseY, scrollX, scrollY);
            }
            element.forEachChildInTree((Function1<? super GuiElement, Unit>)((Function1)arg_0 -> HierarchyScreen.mouseScrolled$lambda$0$0(mouseX, mouseY, scrollX, scrollY, arg_0)));
        }
        return super.mouseScrolled(mouseX, mouseY, scrollX, scrollY);
    }

    public boolean isFocused() {
        return true;
    }

    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        Iterable $this$forEach$iv = this.children;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            GuiElement element = (GuiElement)element$iv;
            boolean bl = false;
            if (element instanceof GuiEventListener) {
                ((GuiEventListener)element).keyPressed(keyCode, scanCode, modifiers);
            }
            element.forEachChildInTree((Function1<? super GuiElement, Unit>)((Function1)arg_0 -> HierarchyScreen.keyPressed$lambda$0$0(keyCode, scanCode, modifiers, arg_0)));
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
        Iterable $this$forEach$iv = this.children;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            GuiElement element = (GuiElement)element$iv;
            boolean bl = false;
            if (element instanceof GuiEventListener) {
                ((GuiEventListener)element).keyReleased(keyCode, scanCode, modifiers);
            }
            element.forEachChildInTree((Function1<? super GuiElement, Unit>)((Function1)arg_0 -> HierarchyScreen.keyReleased$lambda$0$0(keyCode, scanCode, modifiers, arg_0)));
        }
        return super.keyReleased(keyCode, scanCode, modifiers);
    }

    public boolean charTyped(char codePoint, int modifiers) {
        Iterable $this$forEach$iv = this.children;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            GuiElement element = (GuiElement)element$iv;
            boolean bl = false;
            if (element instanceof GuiEventListener) {
                ((GuiEventListener)element).charTyped(codePoint, modifiers);
            }
            element.forEachChildInTree((Function1<? super GuiElement, Unit>)((Function1)arg_0 -> HierarchyScreen.charTyped$lambda$0$0(codePoint, modifiers, arg_0)));
        }
        return super.charTyped(codePoint, modifiers);
    }

    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        Iterable $this$forEach$iv = this.children;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            GuiElement element = (GuiElement)element$iv;
            boolean bl = false;
            if (element instanceof GuiEventListener) {
                ((GuiEventListener)element).mouseDragged(mouseX, mouseY, button, dragX, dragY);
            }
            element.forEachChildInTree((Function1<? super GuiElement, Unit>)((Function1)arg_0 -> HierarchyScreen.mouseDragged$lambda$0$0(mouseX, mouseY, button, dragX, dragY, arg_0)));
        }
        return super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
    }

    private static final Unit mouseClicked$lambda$0$0(double $mouseX, double $mouseY, int $button, GuiElement it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        if (it instanceof GuiEventListener) {
            ((GuiEventListener)it).mouseClicked($mouseX, $mouseY, $button);
        }
        return Unit.INSTANCE;
    }

    private static final Unit mouseReleased$lambda$0$0(double $mouseX, double $mouseY, int $button, GuiElement it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        if (it instanceof GuiEventListener) {
            ((GuiEventListener)it).mouseReleased($mouseX, $mouseY, $button);
        }
        return Unit.INSTANCE;
    }

    private static final Unit mouseMoved$lambda$0$0(double $mouseX, double $mouseY, GuiElement it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        if (it instanceof GuiEventListener) {
            ((GuiEventListener)it).mouseMoved($mouseX, $mouseY);
        }
        return Unit.INSTANCE;
    }

    private static final Unit mouseScrolled$lambda$0$0(double $mouseX, double $mouseY, double $scrollX, double $scrollY, GuiElement it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        if (it instanceof GuiEventListener) {
            ((GuiEventListener)it).mouseScrolled($mouseX, $mouseY, $scrollX, $scrollY);
        }
        return Unit.INSTANCE;
    }

    private static final Unit keyPressed$lambda$0$0(int $keyCode, int $scanCode, int $modifiers, GuiElement it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        if (it instanceof GuiEventListener) {
            ((GuiEventListener)it).keyPressed($keyCode, $scanCode, $modifiers);
        }
        return Unit.INSTANCE;
    }

    private static final Unit keyReleased$lambda$0$0(int $keyCode, int $scanCode, int $modifiers, GuiElement it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        if (it instanceof GuiEventListener) {
            ((GuiEventListener)it).keyReleased($keyCode, $scanCode, $modifiers);
        }
        return Unit.INSTANCE;
    }

    private static final Unit charTyped$lambda$0$0(char $codePoint, int $modifiers, GuiElement it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        if (it instanceof GuiEventListener) {
            ((GuiEventListener)it).charTyped($codePoint, $modifiers);
        }
        return Unit.INSTANCE;
    }

    private static final Unit mouseDragged$lambda$0$0(double $mouseX, double $mouseY, int $button, double $dragX, double $dragY, GuiElement it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        if (it instanceof GuiEventListener) {
            ((GuiEventListener)it).mouseDragged($mouseX, $mouseY, $button, $dragX, $dragY);
        }
        return Unit.INSTANCE;
    }
}

