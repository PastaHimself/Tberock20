/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyExpressionValue
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.renderer.LevelRenderer
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  org.jetbrains.annotations.Nullable
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.mixins.features.vfx;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.data.MapVariables;
import net.thebrokenscript.registry.TBSBlocks;
import net.thebrokenscript.registry.TBSDimensions;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={LevelRenderer.class})
public class LevelRendererMixin {
    @Unique
    private static final ResourceLocation[] tbs$animatedMoonPhases = new ResourceLocation[]{TBSConstants.id("textures/moonevent/animated/moon_phasesframe1.png"), TBSConstants.id("textures/moonevent/animated/moon_phasesframe2.png"), TBSConstants.id("textures/moonevent/animated/moon_phasesframe3.png"), TBSConstants.id("textures/moonevent/animated/moon_phasesframe4.png"), TBSConstants.id("textures/moonevent/animated/moon_phasesframe5.png"), TBSConstants.id("textures/moonevent/animated/moon_phasesframe6.png"), TBSConstants.id("textures/moonevent/animated/moon_phasesframe7.png"), TBSConstants.id("textures/moonevent/animated/moon_phasesframe8.png"), TBSConstants.id("textures/moonevent/animated/moon_phasesframe9.png")};
    @Unique
    private static final ResourceLocation tbs$moonPhase1 = TBSConstants.id("textures/moonevent/moon_phases1.png");
    @Unique
    private static final ResourceLocation tbs$moonPhase2 = TBSConstants.id("textures/moonevent/moon_phases2.png");
    @Unique
    private static final ResourceLocation tbs$earth = TBSConstants.id("textures/environment/earth.png");
    @Shadow
    @Nullable
    private ClientLevel level;
    @Unique
    private static final ResourceLocation tbs$EMPTY = ResourceLocation.withDefaultNamespace((String)"empty");
    @Unique
    private static final ResourceLocation tbs$CONCRETE_SUN = TBSConstants.id("textures/environment/concrete_sun.png");

    @ModifyExpressionValue(method={"renderSky"}, at={@At(value="FIELD", target="Lnet/minecraft/client/renderer/LevelRenderer;MOON_LOCATION:Lnet/minecraft/resources/ResourceLocation;", opcode=178)})
    private ResourceLocation tbs$redirectMoonLocationField(ResourceLocation original) {
        return this.tbs$getCustomMoonTexture(original);
    }

    @ModifyExpressionValue(method={"renderSky"}, at={@At(value="FIELD", target="Lnet/minecraft/client/renderer/LevelRenderer;SUN_LOCATION:Lnet/minecraft/resources/ResourceLocation;", opcode=178)})
    private ResourceLocation tbs$redirectSunLocationField(ResourceLocation original) {
        return this.tbs$getCustomSunTexture(original);
    }

    @Unique
    private ResourceLocation tbs$getCustomMoonTexture(ResourceLocation original) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.level != null) {
            if (minecraft.level.dimension() == TBSDimensions.CONCRETE) {
                return tbs$EMPTY;
            }
            if (minecraft.level.dimension() == TBSDimensions.CORRUPTED_MOON && !TBSConfigs.INSTANCE.getClient().getShaderBasedMoon()) {
                return tbs$earth;
            }
            MapVariables levelVars = LevelExt.INSTANCE.getVars((LevelAccessor)minecraft.level);
            int moonStage = levelVars.getMoonStage();
            int animationIndex = levelVars.getMoonTextureIndex();
            int crackIndex = levelVars.getMoonCrackIndex();
            int phase = minecraft.level.getMoonPhase() + 1;
            if (moonStage == 1 && phase == 4 && animationIndex >= 0 && animationIndex < tbs$animatedMoonPhases.length) {
                return tbs$animatedMoonPhases[animationIndex];
            }
            if (moonStage == 1 && phase == 1 && crackIndex >= 0 && crackIndex < tbs$animatedMoonPhases.length) {
                return tbs$animatedMoonPhases[crackIndex];
            }
            return switch (moonStage) {
                case 1 -> tbs$moonPhase1;
                case 2 -> tbs$moonPhase2;
                default -> original;
            };
        }
        return original;
    }

    @Unique
    private ResourceLocation tbs$getCustomSunTexture(ResourceLocation original) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.level != null && minecraft.level.dimension() == TBSDimensions.CONCRETE) {
            return tbs$CONCRETE_SUN;
        }
        return original;
    }

    @Inject(method={"renderHitOutline"}, at={@At(value="HEAD")}, cancellable=true)
    private void removeOutline(PoseStack poseStack, VertexConsumer consumer, Entity entity, double camX, double camY, double camZ, BlockPos pos, BlockState state, CallbackInfo ci) {
        if (state.is(TBSBlocks.NOWHERE_BLOCK)) {
            ci.cancel();
        }
        if (this.level != null && (state.is(Blocks.BARRIER) || state.is(TBSBlocks.FLESH)) && this.level.dimension().equals(TBSDimensions.PROTECTED_VOID)) {
            ci.cancel();
        }
    }
}

