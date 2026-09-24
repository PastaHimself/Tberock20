/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.components.DebugScreenOverlay
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.level.Level
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package net.thebrokenscript.mixins.features.misc;

import java.util.List;
import java.util.Locale;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.DebugScreenOverlay;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.thebrokenscript.registry.TBSDimensions;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={DebugScreenOverlay.class})
public class DebugScreenOverlayMixin {
    @Shadow
    @Final
    private Minecraft minecraft;

    @Unique
    private List<ResourceKey<Level>> tbs$inDims() {
        return List.of(TBSDimensions.LIBRARY, TBSDimensions.PROTECTED_VOID, TBSDimensions.LIMBO);
    }

    @Redirect(method={"getGameInformation"}, at=@At(value="INVOKE", target="Ljava/lang/String;format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;"))
    private String tbs$hideXYZ(Locale locale, String format, Object[] args) {
        LocalPlayer player = this.minecraft.player;
        if (player != null && !this.tbs$inDims().contains(player.clientLevel.dimension())) {
            return String.format(locale, format, args);
        }
        return switch (format) {
            case "XYZ: %.3f / %.5f / %.3f" -> "XYZ: ??? / ??? / ???";
            case "Block: %d %d %d [%d %d %d]" -> "Block: ? ? ? [? ? ?]";
            case "Chunk-relative: %d %d %d" -> "Chunk-relative: ? ? ?";
            case "Chunk: %d %d %d [%d %d in r.%d.%d.mca]" -> "Chunk: ? ? ? [? ? in r.?.?.mca]";
            default -> String.format(locale, format, args);
        };
    }
}

