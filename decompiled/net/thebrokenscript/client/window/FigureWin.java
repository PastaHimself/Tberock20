/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.platform.Window
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Minecraft
 *  net.thebrokenscript.brokencore.api.client.util.ClientTickTimer
 *  net.thebrokenscript.brokencore.api.client.util.WindowExtKt
 *  net.thebrokenscript.brokencore.api.client.util.WindowManipulator
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Vector2i
 *  org.lwjgl.glfw.GLFW
 *  org.lwjgl.glfw.GLFWVidMode
 */
package net.thebrokenscript.client.window;

import com.mojang.blaze3d.platform.Window;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.thebrokenscript.brokencore.api.client.util.ClientTickTimer;
import net.thebrokenscript.brokencore.api.client.util.WindowExtKt;
import net.thebrokenscript.brokencore.api.client.util.WindowManipulator;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.client.TBSClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector2i;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007J\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/client/window/FigureWin;", "Ljavax/swing/JFrame;", "<init>", "()V", "container", "Ljavax/swing/JPanel;", "frame", "", "wasFullScreen", "", "prevSize", "Lorg/joml/Vector2i;", "prevPos", "onMove", "", "x", "y", "render", "update", "Companion", "thebrokenscript-common"})
public final class FigureWin
extends JFrame {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final JPanel container;
    private int frame;
    private boolean wasFullScreen;
    @NotNull
    private final Vector2i prevSize = new Vector2i(0, 0);
    @NotNull
    private final Vector2i prevPos = new Vector2i(0, 0);
    private static final int DEFAULT_WIDTH = 854;
    private static final int DEFAULT_HEIGHT = 480;

    public FigureWin() {
        int w = 500;
        int h = 500;
        ClientTickTimer timer = new ClientTickTimer();
        Window window = WindowManipulator.getWindow();
        Intrinsics.checkNotNull((Object)window);
        Window window2 = window;
        this.wasFullScreen = window2.isFullscreen();
        if (this.wasFullScreen) {
            window2.toggleFullScreen();
        }
        GLFWVidMode gLFWVidMode = GLFW.glfwGetVideoMode((long)GLFW.glfwGetPrimaryMonitor());
        Intrinsics.checkNotNull((Object)gLFWVidMode);
        GLFWVidMode monitor = gLFWVidMode;
        int monitorSizeX = monitor.width();
        int monitorSizeY = monitor.height();
        this.prevSize.x = window2.getWidth();
        this.prevSize.y = window2.getHeight();
        this.prevPos.x = window2.getX();
        this.prevPos.y = window2.getY();
        Vector2i middle = new Vector2i(monitorSizeX / 2, monitorSizeY / 2).sub(427, 240);
        this.setDefaultCloseOperation(0);
        Window window3 = ClientDSLKt.getMC().getWindow();
        Intrinsics.checkNotNullExpressionValue((Object)window3, (String)"getWindow(...)");
        WindowExtKt.setSize((Window)window3, (Vector2i)new Vector2i(854, 480));
        GLFW.glfwSetWindowPos((long)window2.getWindow(), (int)middle.x, (int)middle.y);
        timer.start(5).doOnEnd(arg_0 -> FigureWin._init_$lambda$0(this, timer, arg_0));
        timer.loop = true;
        this.setLocation(middle.x - 157, middle.y - 129);
        this.setSize(1178, 708);
        this.setUndecorated(true);
        this.setAlwaysOnTop(true);
        this.setFocusable(false);
        this.setFocusableWindowState(false);
        this.setBackground(new Color(0, 0, 0, 0));
        this.container = new JPanel(){
            {
                this.setBackground(new Color(0, 0, 0, 0));
                this.setOpaque(false);
            }

            @Override
            public void paint(Graphics gfx) {
                Intrinsics.checkNotNullParameter((Object)gfx, (String)"gfx");
                try {
                    Graphics2D g = (Graphics2D)gfx;
                    g.setComposite(AlphaComposite.getInstance(1));
                    g.fillRect(0, 0, this.getWidth(), this.getHeight());
                    g.setComposite(AlphaComposite.getInstance(3));
                    String path = "/assets/thebrokenscript/textures/testing/infect_" + frame + ".png";
                    BufferedImage img = ImageIO.read(this.getClass().getResourceAsStream(path));
                    System.out.println((Object)path);
                    g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
                }
                catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
        this.add(this.container);
        (this.container).setSize(w, h);
        this.setContentPane(this.container);
        this.setVisible(true);
        this.paintComponents(this.getGraphics());
        this.requestFocus();
    }

    public final void onMove(int x, int y) {
        this.setLocation(x - 157, y - 129);
    }

    public final void render() {
    }

    public final void update() {
        if (this.container == null) {
            return;
        }
        GLFW.glfwFocusWindow((long)ClientDSLKt.getMC().getWindow().getWindow());
        ClientDSLKt.getMC().mouseHandler.grabMouse();
        ClientDSLKt.getMC().setWindowActive(true);
        this.container.paint(this.getGraphics());
        this.container.repaint();
    }

    private static final Unit _init_$lambda$0(FigureWin this$0, ClientTickTimer $timer, Minecraft it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        if (this$0.frame < 8) {
            this$0.update();
            ++this$0.frame;
        } else {
            WindowManipulator.hideWindow();
            TBSClient.INSTANCE.setWin(null);
            this$0.dispose();
            $timer.free();
            WindowManipulator.freezeFor((long)2000L);
            WindowManipulator.showWindow();
        }
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/client/window/FigureWin$Companion;", "", "<init>", "()V", "DEFAULT_WIDTH", "", "DEFAULT_HEIGHT", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

