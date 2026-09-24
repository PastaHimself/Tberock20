/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.platform.Window
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.Rect2i
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector2i
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.glfw.GLFW
 */
package net.thebrokenscript.brokencore.api.client.util;

import com.mojang.blaze3d.platform.Window;
import java.nio.IntBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Rect2i;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2i;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0001\u001a\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0001\u001a\n\u0010\u0007\u001a\u00020\u0005*\u00020\u0001\u001a\u0012\u0010\u0018\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001a\"\u0011\u0010\u0000\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"(\u0010\n\u001a\u00020\t*\u00020\u00012\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\"(\u0010\u000f\u001a\u00020\t*\u00020\u00012\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e\"(\u0010\u0013\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\b\u001a\u00020\u00128F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2={"window", "Lcom/mojang/blaze3d/platform/Window;", "getWindow", "()Lcom/mojang/blaze3d/platform/Window;", "show", "", "hide", "focus", "value", "Lorg/joml/Vector2i;", "position", "getPosition", "(Lcom/mojang/blaze3d/platform/Window;)Lorg/joml/Vector2i;", "setPosition", "(Lcom/mojang/blaze3d/platform/Window;Lorg/joml/Vector2i;)V", "size", "getSize", "setSize", "Lnet/minecraft/client/renderer/Rect2i;", "dimensions", "getDimensions", "(Lcom/mojang/blaze3d/platform/Window;)Lnet/minecraft/client/renderer/Rect2i;", "setDimensions", "(Lcom/mojang/blaze3d/platform/Window;Lnet/minecraft/client/renderer/Rect2i;)V", "freezeFor", "ms", "", "brokencore-common"})
public final class WindowExtKt {
    @NotNull
    private static final Window window;

    @NotNull
    public static final Window getWindow() {
        return window;
    }

    public static final void show(@NotNull Window $this$show) {
        Intrinsics.checkNotNullParameter((Object)$this$show, (String)"<this>");
        GLFW.glfwShowWindow((long)$this$show.getWindow());
    }

    public static final void hide(@NotNull Window $this$hide) {
        Intrinsics.checkNotNullParameter((Object)$this$hide, (String)"<this>");
        GLFW.glfwHideWindow((long)$this$hide.getWindow());
    }

    public static final void focus(@NotNull Window $this$focus) {
        Intrinsics.checkNotNullParameter((Object)$this$focus, (String)"<this>");
        GLFW.glfwFocusWindow((long)$this$focus.getWindow());
    }

    @NotNull
    public static final Vector2i getPosition(@NotNull Window $this$position) {
        Intrinsics.checkNotNullParameter((Object)$this$position, (String)"<this>");
        IntBuffer x = BufferUtils.createIntBuffer((int)1);
        IntBuffer y = BufferUtils.createIntBuffer((int)1);
        GLFW.glfwGetWindowPos((long)$this$position.getWindow(), (IntBuffer)x, (IntBuffer)y);
        return new Vector2i(x.get(0), y.get(0));
    }

    public static final void setPosition(@NotNull Window $this$position, @NotNull Vector2i value) {
        Intrinsics.checkNotNullParameter((Object)$this$position, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        GLFW.glfwSetWindowPos((long)$this$position.getWindow(), (int)value.x, (int)value.y);
    }

    @NotNull
    public static final Vector2i getSize(@NotNull Window $this$size) {
        Intrinsics.checkNotNullParameter((Object)$this$size, (String)"<this>");
        IntBuffer x = BufferUtils.createIntBuffer((int)1);
        IntBuffer y = BufferUtils.createIntBuffer((int)1);
        GLFW.glfwGetWindowSize((long)$this$size.getWindow(), (IntBuffer)x, (IntBuffer)y);
        return new Vector2i(x.get(0), y.get(0));
    }

    public static final void setSize(@NotNull Window $this$size, @NotNull Vector2i value) {
        Intrinsics.checkNotNullParameter((Object)$this$size, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        GLFW.glfwSetWindowSize((long)$this$size.getWindow(), (int)value.x, (int)value.y);
    }

    @NotNull
    public static final Rect2i getDimensions(@NotNull Window $this$dimensions) {
        Intrinsics.checkNotNullParameter((Object)$this$dimensions, (String)"<this>");
        Vector2i pos = WindowExtKt.getPosition($this$dimensions);
        Vector2i size = WindowExtKt.getSize($this$dimensions);
        return new Rect2i(pos.x, pos.y, size.x, size.y);
    }

    public static final void setDimensions(@NotNull Window $this$dimensions, @NotNull Rect2i value) {
        Intrinsics.checkNotNullParameter((Object)$this$dimensions, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        WindowExtKt.setPosition($this$dimensions, new Vector2i(value.getX(), value.getY()));
        WindowExtKt.setSize($this$dimensions, new Vector2i(value.getWidth(), value.getHeight()));
    }

    public static final void freezeFor(@NotNull Window $this$freezeFor, long ms) {
        Intrinsics.checkNotNullParameter((Object)$this$freezeFor, (String)"<this>");
        long prev = System.currentTimeMillis();
        while (prev - System.currentTimeMillis() >= -ms) {
        }
    }

    static {
        Window window = Minecraft.getInstance().getWindow();
        Intrinsics.checkNotNullExpressionValue((Object)window, (String)"getWindow(...)");
        WindowExtKt.window = window;
    }
}

