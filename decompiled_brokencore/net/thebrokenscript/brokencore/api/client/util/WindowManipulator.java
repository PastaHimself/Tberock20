/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.platform.Window
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.lwjgl.glfw.GLFW
 */
package net.thebrokenscript.brokencore.api.client.util;

import com.mojang.blaze3d.platform.Window;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.glfw.GLFW;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\nH\u0007J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u0016\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011J&\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0018"}, d2={"Lnet/thebrokenscript/brokencore/api/client/util/WindowManipulator;", "", "<init>", "()V", "window", "Lcom/mojang/blaze3d/platform/Window;", "getWindow$annotations", "getWindow", "()Lcom/mojang/blaze3d/platform/Window;", "showWindow", "", "hideWindow", "freezeFor", "milliseconds", "", "setPosition", "x", "", "y", "setSize", "w", "h", "setDimensions", "MightCauseSecurityControversyIdk", "brokencore-common"})
public final class WindowManipulator {
    @NotNull
    public static final WindowManipulator INSTANCE = new WindowManipulator();

    private WindowManipulator() {
    }

    @Nullable
    public static final Window getWindow() {
        return ClientDSLKt.getMC().getWindow();
    }

    @JvmStatic
    public static /* synthetic */ void getWindow$annotations() {
    }

    @JvmStatic
    public static final void showWindow() {
        Window window = WindowManipulator.getWindow();
        Intrinsics.checkNotNull((Object)window);
        GLFW.glfwShowWindow((long)window.getWindow());
    }

    @JvmStatic
    public static final void hideWindow() {
        Window window = WindowManipulator.getWindow();
        Intrinsics.checkNotNull((Object)window);
        GLFW.glfwHideWindow((long)window.getWindow());
    }

    @JvmStatic
    public static final void freezeFor(long milliseconds) {
        long prevTime = System.currentTimeMillis();
        while (prevTime - System.currentTimeMillis() >= -milliseconds) {
        }
    }

    public final void setPosition(int x, int y) {
        Window window = WindowManipulator.getWindow();
        Intrinsics.checkNotNull((Object)window);
        GLFW.glfwSetWindowPos((long)window.getWindow(), (int)x, (int)y);
    }

    public final void setSize(int w, int h) {
        Window window = WindowManipulator.getWindow();
        Intrinsics.checkNotNull((Object)window);
        GLFW.glfwSetWindowSize((long)window.getWindow(), (int)w, (int)h);
    }

    public final void setDimensions(int x, int y, int w, int h) {
        Window window = WindowManipulator.getWindow();
        Intrinsics.checkNotNull((Object)window);
        GLFW.glfwSetWindowSize((long)window.getWindow(), (int)w, (int)h);
        Window window2 = WindowManipulator.getWindow();
        Intrinsics.checkNotNull((Object)window2);
        GLFW.glfwSetWindowPos((long)window2.getWindow(), (int)x, (int)y);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u0005J\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/api/client/util/WindowManipulator$MightCauseSecurityControversyIdk;", "", "<init>", "()V", "pressKey", "", "k", "", "middleClick", "rightClick", "leftClick", "setCursorPos", "x", "", "y", "brokencore-common"})
    public static final class MightCauseSecurityControversyIdk {
        @NotNull
        public static final MightCauseSecurityControversyIdk INSTANCE = new MightCauseSecurityControversyIdk();

        private MightCauseSecurityControversyIdk() {
        }

        public final void pressKey(char k) {
            try {
                int key = KeyEvent.getExtendedKeyCodeForChar(k);
                Robot bot = new Robot();
                bot.keyPress(key);
                bot.keyRelease(key);
            }
            catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public final void middleClick() {
            try {
                Robot bot = new Robot();
                bot.mousePress(2048);
                bot.mouseRelease(2048);
            }
            catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public final void rightClick() {
            try {
                Robot bot = new Robot();
                bot.mousePress(2048);
                bot.mouseRelease(2048);
            }
            catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public final void leftClick() {
            try {
                Robot bot = new Robot();
                bot.mousePress(1024);
                bot.mouseRelease(1024);
            }
            catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public final void setCursorPos(int x, int y) {
            Window window = WindowManipulator.getWindow();
            Intrinsics.checkNotNull((Object)window);
            GLFW.glfwSetCursorPos((long)window.getWindow(), (double)x, (double)y);
        }
    }
}

