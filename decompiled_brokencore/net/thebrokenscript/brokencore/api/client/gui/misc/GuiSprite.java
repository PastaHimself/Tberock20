/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.gui.misc;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractGuiNode2D;
import net.thebrokenscript.brokencore.api.client.gui.settings.SpriteScalingSettings;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J8\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0013H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/misc/GuiSprite;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractGuiNode2D;", "sprite", "Lnet/minecraft/resources/ResourceLocation;", "scaling", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;", "<init>", "(Lnet/minecraft/resources/ResourceLocation;Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;)V", "getSprite", "()Lnet/minecraft/resources/ResourceLocation;", "setSprite", "(Lnet/minecraft/resources/ResourceLocation;)V", "getScaling", "()Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;", "render", "", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "mouseX", "", "mouseY", "partialTick", "", "globalX", "globalY", "brokencore-common"})
public final class GuiSprite
extends AbstractGuiNode2D {
    @NotNull
    private ResourceLocation sprite;
    @NotNull
    private final SpriteScalingSettings scaling;

    public GuiSprite(@NotNull ResourceLocation sprite, @NotNull SpriteScalingSettings scaling) {
        Intrinsics.checkNotNullParameter((Object)sprite, (String)"sprite");
        Intrinsics.checkNotNullParameter((Object)scaling, (String)"scaling");
        super(0, 0, 0, 0, 15, null);
        this.sprite = sprite;
        this.scaling = scaling;
    }

    public /* synthetic */ GuiSprite(ResourceLocation resourceLocation, SpriteScalingSettings spriteScalingSettings, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            spriteScalingSettings = SpriteScalingSettings.Companion.getSTRETCH();
        }
        this(resourceLocation, spriteScalingSettings);
    }

    @NotNull
    public final ResourceLocation getSprite() {
        return this.sprite;
    }

    public final void setSprite(@NotNull ResourceLocation resourceLocation) {
        Intrinsics.checkNotNullParameter((Object)resourceLocation, (String)"<set-?>");
        this.sprite = resourceLocation;
    }

    @NotNull
    public final SpriteScalingSettings getScaling() {
        return this.scaling;
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick, int globalX, int globalY) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        this.scaling.render(guiGraphics, this.sprite, this);
    }
}

