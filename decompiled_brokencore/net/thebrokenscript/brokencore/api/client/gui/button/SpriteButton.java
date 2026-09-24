/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.gui.GuiGraphics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.gui.button;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.GuiGraphics;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractButton;
import net.thebrokenscript.brokencore.api.client.gui.settings.SpriteButtonSettings;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ8\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/button/SpriteButton;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractButton;", "spriteSettings", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteButtonSettings;", "callback", "Lkotlin/Function0;", "", "<init>", "(Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteButtonSettings;Lkotlin/jvm/functions/Function0;)V", "getSpriteSettings", "()Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteButtonSettings;", "render", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "mouseX", "", "mouseY", "partialTick", "", "globalX", "globalY", "brokencore-common"})
public class SpriteButton
extends AbstractButton {
    @NotNull
    private final SpriteButtonSettings spriteSettings;

    public SpriteButton(@NotNull SpriteButtonSettings spriteSettings, @NotNull Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter((Object)spriteSettings, (String)"spriteSettings");
        Intrinsics.checkNotNullParameter(callback, (String)"callback");
        super(callback);
        this.spriteSettings = spriteSettings;
    }

    @NotNull
    public final SpriteButtonSettings getSpriteSettings() {
        return this.spriteSettings;
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick, int globalX, int globalY) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        this.spriteSettings.getSpriteScalingSettings().render(guiGraphics, this.spriteSettings.getSprite(this.getHovered(), this.getPressed()), this);
    }
}

