/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.io.FilesKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.json.Json
 *  kotlinx.serialization.json.JsonObject
 *  net.minecraft.client.Camera
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.components.events.GuiEventListener
 *  net.minecraft.util.Mth
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Vector2f
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 *  org.lwjgl.glfw.GLFW
 */
package net.thebrokenscript.brokencore.api.client.cutscene_editor;

import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonObject;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.util.Mth;
import net.thebrokenscript.brokencore.api.client.cutscene.CameraOverrides;
import net.thebrokenscript.brokencore.api.client.cutscene_editor.CutsceneEditorConstants;
import net.thebrokenscript.brokencore.api.client.cutscene_editor.gui.CutsceneEditorRoot;
import net.thebrokenscript.brokencore.api.client.gui.button.TextPanelButton;
import net.thebrokenscript.brokencore.api.client.gui.container.HBoxContainer;
import net.thebrokenscript.brokencore.api.client.gui.container.VBoxContainer;
import net.thebrokenscript.brokencore.api.client.gui.impl.GuiElement;
import net.thebrokenscript.brokencore.api.client.gui.settings.LabelSettings;
import net.thebrokenscript.brokencore.api.client.gui.util.HierarchyScreen;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.ext.miximpl.CameraExtImplKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.lwjgl.glfw.GLFW;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\t\b\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010'\u001a\u00020(H\u0002J\r\u0010)\u001a\u00020(H\u0000\u00a2\u0006\u0002\b*J\b\u0010+\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020(H\u0002J\b\u0010-\u001a\u00020(H\u0002J(\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u0002002\u0006\u00103\u001a\u000200H\u0016J\u0018\u00104\u001a\u00020(2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000200H\u0016J \u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020=2\u0006\u0010?\u001a\u00020=H\u0016J \u0010@\u001a\u00020\u00052\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020=2\u0006\u0010?\u001a\u00020=H\u0016J\b\u0010A\u001a\u00020(H\u0016J \u0010B\u001a\u00020\u00052\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\u0006\u0010C\u001a\u00020=H\u0016J(\u0010D\u001a\u00020(2\u0006\u0010E\u001a\u00020F2\u0006\u0010/\u001a\u00020=2\u0006\u00101\u001a\u00020=2\u0006\u0010G\u001a\u00020\u0016H\u0016R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0080\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\bR\u000e\u0010#\u001a\u00020$X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006H"}, d2={"Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/CutsceneEditorScreen;", "Lnet/thebrokenscript/brokencore/api/client/gui/util/HierarchyScreen;", "<init>", "()V", "value", "", "freeCamera", "getFreeCamera$brokencore_common", "()Z", "freeCameraPos", "Lorg/joml/Vector3f;", "getFreeCameraPos$brokencore_common", "()Lorg/joml/Vector3f;", "setFreeCameraPos$brokencore_common", "(Lorg/joml/Vector3f;)V", "freeCameraRot", "Lorg/joml/Vector2f;", "getFreeCameraRot$brokencore_common", "()Lorg/joml/Vector2f;", "setFreeCameraRot$brokencore_common", "(Lorg/joml/Vector2f;)V", "freeCameraSpeed", "", "root", "Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/CutsceneEditorRoot;", "getRoot", "()Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/CutsceneEditorRoot;", "currentSavePath", "", "getCurrentSavePath$brokencore_common", "()Ljava/lang/String;", "setCurrentSavePath$brokencore_common", "(Ljava/lang/String;)V", "closeConfirmPromptOpen", "getCloseConfirmPromptOpen", "exitConfirmHBox", "Lnet/thebrokenscript/brokencore/api/client/gui/container/HBoxContainer;", "exitConfirmPrompt", "Lnet/thebrokenscript/brokencore/api/client/gui/container/VBoxContainer;", "updateFreeCamera", "", "toggleFreeCamera", "toggleFreeCamera$brokencore_common", "shouldCloseOnEsc", "openExitPrompt", "closeExitPrompt", "mouseScrolled", "mouseX", "", "mouseY", "scrollX", "scrollY", "mouseMoved", "forward", "backward", "left", "right", "up", "down", "keyReleased", "keyCode", "", "scanCode", "modifiers", "keyPressed", "onClose", "mouseClicked", "button", "render", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "partialTick", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nCutsceneEditorScreen.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CutsceneEditorScreen.kt\nnet/thebrokenscript/brokencore/api/client/cutscene_editor/CutsceneEditorScreen\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Json.kt\nkotlinx/serialization/json/Json\n*L\n1#1,216:1\n1869#2,2:217\n1869#2,2:219\n1869#2,2:222\n1869#2,2:224\n205#3:221\n*S KotlinDebug\n*F\n+ 1 CutsceneEditorScreen.kt\nnet/thebrokenscript/brokencore/api/client/cutscene_editor/CutsceneEditorScreen\n*L\n85#1:217,2\n106#1:219,2\n161#1:222,2\n179#1:224,2\n154#1:221\n*E\n"})
public final class CutsceneEditorScreen
extends HierarchyScreen {
    private boolean freeCamera;
    @NotNull
    private Vector3f freeCameraPos = new Vector3f(0.0f);
    @NotNull
    private Vector2f freeCameraRot = new Vector2f(0.0f);
    private float freeCameraSpeed = 0.5f;
    @NotNull
    private final CutsceneEditorRoot root = (CutsceneEditorRoot)this.addChild((GuiElement)new CutsceneEditorRoot(this));
    @Nullable
    private String currentSavePath;
    @NotNull
    private final HBoxContainer exitConfirmHBox = new HBoxContainer(16, false, 2, null);
    @NotNull
    private final VBoxContainer exitConfirmPrompt = (VBoxContainer)this.addChild((GuiElement)new VBoxContainer(0, false, 3, null));
    private boolean forward;
    private boolean backward;
    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;

    public CutsceneEditorScreen() {
        this.exitConfirmPrompt.addChildInit((GuiElement)LabelSettings.Companion.getDEFAULT().create("Exit without saving?"));
        this.exitConfirmPrompt.addChildInit((GuiElement)this.exitConfirmHBox);
        TextPanelButton yes2 = (TextPanelButton)this.exitConfirmHBox.addChildInit((GuiElement)CutsceneEditorConstants.INSTANCE.getTEXT_PANEL_SETTINGS().create("Yes", (Function0<Unit>)((Function0)new Function0<Unit>((Object)this){

            public final void invoke() {
                ((CutsceneEditorScreen)((Object)this.receiver)).onClose();
            }
        })));
        TextPanelButton no2 = (TextPanelButton)this.exitConfirmHBox.addChildInit((GuiElement)CutsceneEditorConstants.INSTANCE.getTEXT_PANEL_SETTINGS().create("No", (Function0<Unit>)((Function0)new Function0<Unit>((Object)this){

            public final void invoke() {
                CutsceneEditorScreen.access$closeExitPrompt((CutsceneEditorScreen)((Object)this.receiver));
            }
        })));
        this.exitConfirmPrompt.setH(16);
        yes2.setW(24);
        no2.setW(24);
        yes2.setH(16);
        no2.setH(16);
        this.exitConfirmPrompt.setVisible(false);
        this.exitConfirmPrompt.setActive(false);
    }

    public final boolean getFreeCamera$brokencore_common() {
        return this.freeCamera;
    }

    @NotNull
    public final Vector3f getFreeCameraPos$brokencore_common() {
        return this.freeCameraPos;
    }

    public final void setFreeCameraPos$brokencore_common(@NotNull Vector3f vector3f) {
        Intrinsics.checkNotNullParameter((Object)vector3f, (String)"<set-?>");
        this.freeCameraPos = vector3f;
    }

    @NotNull
    public final Vector2f getFreeCameraRot$brokencore_common() {
        return this.freeCameraRot;
    }

    public final void setFreeCameraRot$brokencore_common(@NotNull Vector2f vector2f) {
        Intrinsics.checkNotNullParameter((Object)vector2f, (String)"<set-?>");
        this.freeCameraRot = vector2f;
    }

    @NotNull
    public final CutsceneEditorRoot getRoot() {
        return this.root;
    }

    @Nullable
    public final String getCurrentSavePath$brokencore_common() {
        return this.currentSavePath;
    }

    public final void setCurrentSavePath$brokencore_common(@Nullable String string) {
        this.currentSavePath = string;
    }

    public final boolean getCloseConfirmPromptOpen() {
        return this.exitConfirmPrompt.getActive();
    }

    private final void updateFreeCamera() {
        Camera camera = ClientDSLKt.getMC().gameRenderer.getMainCamera();
        Intrinsics.checkNotNullExpressionValue((Object)camera, (String)"getMainCamera(...)");
        CameraOverrides overrides = CameraExtImplKt.getOverrides(camera);
        overrides.setActive(true);
        overrides.getTransform().getPosition().set((Vector3fc)this.freeCameraPos);
        overrides.getTransform().getRotation().setYaw(this.freeCameraRot.y);
        overrides.getTransform().getRotation().setPitch(this.freeCameraRot.x);
        Camera camera2 = ClientDSLKt.getMC().gameRenderer.getMainCamera();
        Intrinsics.checkNotNullExpressionValue((Object)camera2, (String)"getMainCamera(...)");
        CameraExtImplKt.updateOverrides(camera2);
    }

    public final void toggleFreeCamera$brokencore_common() {
        boolean bl = this.freeCamera = !this.freeCamera;
        if (this.freeCamera) {
            this.freeCameraPos.set((Vector3fc)ClientDSLKt.getMC().gameRenderer.getMainCamera().getPosition().toVector3f());
            this.freeCameraRot.x = Mth.wrapDegrees((float)ClientDSLKt.getMC().gameRenderer.getMainCamera().getXRot());
            this.freeCameraRot.y = ClientDSLKt.getMC().gameRenderer.getMainCamera().getYRot();
        }
    }

    public boolean shouldCloseOnEsc() {
        return false;
    }

    private final void openExitPrompt() {
        this.exitConfirmPrompt.setActive(true);
        this.exitConfirmPrompt.setVisible(true);
    }

    private final void closeExitPrompt() {
        this.exitConfirmPrompt.setActive(false);
        this.exitConfirmPrompt.setVisible(false);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double scrollX, double scrollY) {
        List children = this.getCloseConfirmPromptOpen() ? CollectionsKt.listOf((Object)this.exitConfirmPrompt) : this.getChildren();
        Iterable $this$forEach$iv = children;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            GuiElement element = (GuiElement)element$iv;
            boolean bl = false;
            if (element instanceof GuiEventListener) {
                ((GuiEventListener)element).mouseScrolled(mouseX, mouseY, scrollX, scrollY);
            }
            element.forEachChildInTree((Function1<? super GuiElement, Unit>)((Function1)arg_0 -> CutsceneEditorScreen.mouseScrolled$lambda$0$0(mouseX, mouseY, scrollX, scrollY, arg_0)));
        }
        this.freeCameraSpeed = Math.max(Math.min(this.freeCameraSpeed + (float)scrollY * 0.02f, 1.0f), 0.0f);
        return true;
    }

    @Override
    public void mouseMoved(double mouseX, double mouseY) {
        if (this.freeCamera) {
            double[] dArray = new double[]{0.0};
            double[] cX = dArray;
            double[] dArray2 = new double[]{0.0};
            double[] cY = dArray2;
            GLFW.glfwGetCursorPos((long)ClientDSLKt.getMC().getWindow().getWindow(), (double[])cX, (double[])cY);
            Minecraft minecraft = this.minecraft;
            Intrinsics.checkNotNull((Object)minecraft);
            float sens = (float)(((Number)minecraft.options.sensitivity().get()).doubleValue() * (double)8 + 0.2);
            Vector2f vector2f = this.freeCameraRot;
            vector2f.y += ((float)cX[0] - (float)ClientDSLKt.getMC().getWindow().getWidth() / 2.0f) / sens;
            this.freeCameraRot.x = Math.max(Math.min(this.freeCameraRot.x + ((float)cY[0] - (float)ClientDSLKt.getMC().getWindow().getHeight() / 2.0f) / sens, 90.0f), -90.0f);
            GLFW.glfwSetCursorPos((long)ClientDSLKt.getMC().getWindow().getWindow(), (double)((double)ClientDSLKt.getMC().getWindow().getWidth() / 2.0), (double)((double)ClientDSLKt.getMC().getWindow().getHeight() / 2.0));
        } else {
            List children = this.getCloseConfirmPromptOpen() ? CollectionsKt.listOf((Object)this.exitConfirmPrompt) : this.getChildren();
            Iterable $this$forEach$iv = children;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                GuiElement element = (GuiElement)element$iv;
                boolean bl = false;
                if (element instanceof GuiEventListener) {
                    ((GuiEventListener)element).mouseMoved(mouseX, mouseY);
                }
                element.forEachChildInTree((Function1<? super GuiElement, Unit>)((Function1)arg_0 -> CutsceneEditorScreen.mouseMoved$lambda$0$0(mouseX, mouseY, arg_0)));
            }
        }
    }

    @Override
    public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
        switch (keyCode) {
            case 87: {
                this.forward = false;
                break;
            }
            case 83: {
                this.backward = false;
                break;
            }
            case 65: {
                this.left = false;
                break;
            }
            case 68: {
                this.right = false;
                break;
            }
            case 32: {
                this.up = false;
                break;
            }
            case 340: {
                this.down = false;
            }
        }
        return super.keyReleased(keyCode, scanCode, modifiers);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == 70 && !this.getCloseConfirmPromptOpen()) {
            this.toggleFreeCamera$brokencore_common();
        }
        if (this.freeCamera) {
            switch (keyCode) {
                case 87: {
                    this.forward = true;
                    break;
                }
                case 83: {
                    this.backward = true;
                    break;
                }
                case 65: {
                    this.left = true;
                    break;
                }
                case 68: {
                    this.right = true;
                    break;
                }
                case 32: {
                    this.up = true;
                    break;
                }
                case 340: {
                    this.down = true;
                }
            }
        } else {
            if (keyCode == 256 && !this.getCloseConfirmPromptOpen()) {
                this.openExitPrompt();
            }
            if (keyCode == 83 && (modifiers & 2) != 0) {
                String path = this.currentSavePath;
                if (path != null) {
                    void this_$iv;
                    File file = new File(path);
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    Json json = (Json)Json.Default;
                    JsonObject value$iv = this.root.getTimeline$brokencore_common().toJson();
                    boolean $i$f$encodeToString = false;
                    this_$iv.getSerializersModule();
                    FilesKt.writeText$default((File)file, (String)this_$iv.encodeToString((SerializationStrategy)JsonObject.Companion.serializer(), (Object)value$iv), null, (int)2, null);
                } else {
                    this.root.getTimeline$brokencore_common().save((Function1<? super String, Unit>)((Function1)arg_0 -> CutsceneEditorScreen.keyPressed$lambda$0(this, arg_0)));
                }
            }
            List children = this.getCloseConfirmPromptOpen() ? CollectionsKt.listOf((Object)this.exitConfirmPrompt) : this.getChildren();
            Iterable $this$forEach$iv = children;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                GuiElement element = (GuiElement)element$iv;
                boolean bl = false;
                if (element instanceof GuiEventListener) {
                    ((GuiEventListener)element).keyPressed(keyCode, scanCode, modifiers);
                }
                element.forEachChildInTree((Function1<? super GuiElement, Unit>)((Function1)arg_0 -> CutsceneEditorScreen.keyPressed$lambda$1$0(keyCode, scanCode, modifiers, arg_0)));
            }
        }
        return true;
    }

    public void onClose() {
        Camera camera = ClientDSLKt.getMC().gameRenderer.getMainCamera();
        Intrinsics.checkNotNullExpressionValue((Object)camera, (String)"getMainCamera(...)");
        CameraExtImplKt.getOverrides(camera).setActive(false);
        super.onClose();
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        List children = this.getCloseConfirmPromptOpen() ? CollectionsKt.listOf((Object)this.exitConfirmPrompt) : this.getChildren();
        Iterable $this$forEach$iv = children;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            GuiElement element = (GuiElement)element$iv;
            boolean bl = false;
            if (element instanceof GuiEventListener) {
                ((GuiEventListener)element).mouseClicked(mouseX, mouseY, button);
            }
            element.forEachChildInTree((Function1<? super GuiElement, Unit>)((Function1)arg_0 -> CutsceneEditorScreen.mouseClicked$lambda$0$0(mouseX, mouseY, button, arg_0)));
        }
        return true;
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        this.exitConfirmPrompt.setX(guiGraphics.guiWidth() / 2 - this.exitConfirmPrompt.getW() / 2);
        this.exitConfirmPrompt.setY(guiGraphics.guiHeight() / 2 - this.exitConfirmPrompt.getH() / 2);
        if (this.freeCamera) {
            this.updateFreeCamera();
            this.root.render(guiGraphics, mouseX, mouseY, partialTick, 0, 0);
            ClientDSLKt.getMC().mouseHandler.isMouseGrabbed();
            GLFW.glfwSetInputMode((long)ClientDSLKt.getMC().getWindow().getWindow(), (int)208897, (int)212994);
            this.root.setVisible(false);
            this.root.setActive(false);
            Vector3f newVec = new Vector3f(0.0f);
            if (this.forward) {
                newVec.add((Vector3fc)new Vector3f((Vector3fc)ClientDSLKt.getMC().gameRenderer.getMainCamera().getLookVector()).mul(this.freeCameraSpeed, 0.0f, this.freeCameraSpeed));
            }
            if (this.backward) {
                newVec.add((Vector3fc)new Vector3f((Vector3fc)ClientDSLKt.getMC().gameRenderer.getMainCamera().getLookVector()).mul(-this.freeCameraSpeed, 0.0f, -this.freeCameraSpeed));
            }
            if (this.left) {
                newVec.add((Vector3fc)new Vector3f((Vector3fc)ClientDSLKt.getMC().gameRenderer.getMainCamera().getLeftVector()).mul(this.freeCameraSpeed, 0.0f, this.freeCameraSpeed));
            }
            if (this.right) {
                newVec.add((Vector3fc)new Vector3f((Vector3fc)ClientDSLKt.getMC().gameRenderer.getMainCamera().getLeftVector()).mul(-this.freeCameraSpeed, 0.0f, -this.freeCameraSpeed));
            }
            if (this.up) {
                newVec.add((Vector3fc)new Vector3f(0.0f, 1.0f, 0.0f).mul(this.freeCameraSpeed));
            }
            if (this.down) {
                newVec.add((Vector3fc)new Vector3f(0.0f, -1.0f, 0.0f).mul(this.freeCameraSpeed));
            }
            this.freeCameraPos.add((Vector3fc)newVec.mul(partialTick));
        } else {
            GLFW.glfwSetInputMode((long)ClientDSLKt.getMC().getWindow().getWindow(), (int)208897, (int)212993);
            this.root.setVisible(true);
            this.root.setActive(true);
        }
        super.render(guiGraphics, mouseX, mouseY, partialTick);
    }

    private static final Unit mouseScrolled$lambda$0$0(double $mouseX, double $mouseY, double $scrollX, double $scrollY, GuiElement it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        if (it instanceof GuiEventListener) {
            ((GuiEventListener)it).mouseScrolled($mouseX, $mouseY, $scrollX, $scrollY);
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

    private static final Unit keyPressed$lambda$0(CutsceneEditorScreen this$0, String it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        this$0.currentSavePath = it;
        return Unit.INSTANCE;
    }

    private static final Unit keyPressed$lambda$1$0(int $keyCode, int $scanCode, int $modifiers, GuiElement it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        if (it instanceof GuiEventListener) {
            ((GuiEventListener)it).keyPressed($keyCode, $scanCode, $modifiers);
        }
        return Unit.INSTANCE;
    }

    private static final Unit mouseClicked$lambda$0$0(double $mouseX, double $mouseY, int $button, GuiElement it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        if (it instanceof GuiEventListener) {
            ((GuiEventListener)it).mouseClicked($mouseX, $mouseY, $button);
        }
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void access$closeExitPrompt(CutsceneEditorScreen $this) {
        $this.closeExitPrompt();
    }
}

