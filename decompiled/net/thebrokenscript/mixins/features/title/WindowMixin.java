/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.platform.Window
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.client.resources.language.I18n
 *  net.minecraft.world.entity.player.Player
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.ModifyArg
 */
package net.thebrokenscript.mixins.features.title;

import com.mojang.blaze3d.platform.Window;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.registry.TBSLang;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value={Window.class})
public class WindowMixin {
    @ModifyArg(method={"setTitle"}, at=@At(value="INVOKE", target="Lorg/lwjgl/glfw/GLFW;glfwSetWindowTitle(JLjava/lang/CharSequence;)V"), index=1)
    private CharSequence modifyTitle(CharSequence originalTitle) {
        LocalPlayer player = Minecraft.getInstance().player;
        String defaultTitle = I18n.get((String)TBSLang.INSTANCE.getDEFAULT_TITLE().getString(), (Object[])new Object[0]);
        if (player != null) {
            try {
                if (!PlayerExt.INSTANCE.getVars((Player)player).getTitleName().isEmpty()) {
                    return PlayerExt.INSTANCE.getVars((Player)player).getTitleName();
                }
                return defaultTitle;
            }
            catch (Exception e) {
                return defaultTitle;
            }
        }
        return I18n.get((String)TBSLang.INSTANCE.getALT_TITLE().getString(), (Object[])new Object[0]);
    }
}

