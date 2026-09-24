/*
 * Decompiled with CFR 0.152.
 */
package net.thebrokenscript.brokencore.impl.alert;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class AlertWindowInner {
    public static void main(String[] args) throws IOException {
        String title = args[0];
        String message = args[1];
        InputStream iconStream = AlertWindowInner.class.getClassLoader().getResourceAsStream("lwjgl.png");
        assert (iconStream != null);
        BufferedImage icon = ImageIO.read(iconStream);
        int negativeX = Math.random() <= 0.5 ? -1 : 1;
        int negativeY = Math.random() <= 0.5 ? -1 : 1;
        JFrame win = new JFrame(title);
        int width = 300;
        int height = 75;
        PointerInfo pi = MouseInfo.getPointerInfo();
        GraphicsDevice gd = pi.getDevice();
        Rectangle bounds = gd.getDefaultConfiguration().getBounds();
        int windowX = (int)((double)bounds.x + (double)(bounds.width - width) / 2.0 + Math.random() * 350.0 * (double)negativeX);
        int windowY = (int)((double)bounds.y + (double)(bounds.height - height) / 2.0 + Math.random() * 350.0 * (double)negativeY);
        win.setVisible(false);
        win.setMinimumSize(new Dimension(width, height));
        win.setLocationByPlatform(true);
        win.setDefaultCloseOperation(3);
        win.setResizable(false);
        win.setLocation(new Point(windowX, windowY));
        win.setIconImage(icon);
        JLabel text = new JLabel(message);
        text.setFont(text.getFont().deriveFont((float)text.getFont().getSize() * 1.25f));
        text.setHorizontalTextPosition(2);
        text.setBorder(new EmptyBorder(10, 10, 10, 10));
        win.getContentPane().add((Component)text, "Center");
        Toolkit.getDefaultToolkit().beep();
        win.pack();
        win.setVisible(true);
        win.requestFocus();
    }
}

