/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  javax.annotation.Nullable
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.blockentity.SkullBlockRenderer
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.item.component.ResolvableProfile
 *  net.minecraft.world.level.block.SkullBlock$Type
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.mixins.features.skin;

import com.mojang.authlib.GameProfile;
import javax.annotation.Nullable;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.SkullBlockRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.component.ResolvableProfile;
import net.minecraft.world.level.block.SkullBlock;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.misc.GameProfiles;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={SkullBlockRenderer.class})
public class SkullBlockRendererMixin {
    @Inject(method={"getRenderType"}, at={@At(value="HEAD")}, cancellable=true)
    private static void tbs$replaceNullSkullTexture(SkullBlock.Type type, @Nullable ResolvableProfile profile, CallbackInfoReturnable<RenderType> cir) {
        GameProfile gameProfile;
        if (profile != null && (gameProfile = profile.gameProfile()).getName().equals(GameProfiles.NULL_GAME_PROFILE.getName().toLowerCase())) {
            cir.setReturnValue((Object)RenderType.entityTranslucent((ResourceLocation)TBSConstants.id("textures/entities/null.png")));
        }
    }
}

