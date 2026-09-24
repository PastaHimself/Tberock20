/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.font.FontManager
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.ext;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.font.FontManager;
import net.thebrokenscript.mixins.features.font.MinecraftAccessor;
import net.thebrokenscript.mixinterfaces.FontManagerExt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\"\u0015\u0010\u0005\u001a\u00020\u0002*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"resetBoxes", "", "Lnet/minecraft/client/gui/font/FontManager;", "chance", "", "fontManager", "Lnet/minecraft/client/Minecraft;", "getFontManager", "(Lnet/minecraft/client/Minecraft;)Lnet/minecraft/client/gui/font/FontManager;", "thebrokenscript-common"})
public final class FontManagerExtKt {
    public static final void resetBoxes(@NotNull FontManager $this$resetBoxes, @NotNull Number chance) {
        Intrinsics.checkNotNullParameter((Object)$this$resetBoxes, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)chance, (String)"chance");
        ((FontManagerExt)$this$resetBoxes).tbs$resetBoxes(chance.floatValue());
    }

    @NotNull
    public static final FontManager getFontManager(@NotNull Minecraft $this$fontManager) {
        Intrinsics.checkNotNullParameter((Object)$this$fontManager, (String)"<this>");
        FontManager fontManager = ((MinecraftAccessor)$this$fontManager).tbs$getFontManager();
        Intrinsics.checkNotNullExpressionValue((Object)fontManager, (String)"tbs$getFontManager(...)");
        return fontManager;
    }
}

