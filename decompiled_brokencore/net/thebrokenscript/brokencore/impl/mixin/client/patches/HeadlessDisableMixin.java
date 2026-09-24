/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.main.Main
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package net.thebrokenscript.brokencore.impl.mixin.client.patches;

import java.util.Objects;
import net.minecraft.client.main.Main;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={Main.class})
public class HeadlessDisableMixin {
    @Redirect(method={"<clinit>"}, at=@At(value="INVOKE", target="Ljava/lang/System;setProperty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;"))
    private static String bc$disableHeadless(String key, String value) {
        if (Objects.equals(key, "java.awt.headless")) {
            return "";
        }
        return System.setProperty(key, value);
    }
}

