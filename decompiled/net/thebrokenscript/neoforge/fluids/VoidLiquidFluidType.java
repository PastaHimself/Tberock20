/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.shaders.FogShape
 *  com.mojang.blaze3d.systems.RenderSystem
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Camera
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.renderer.FogRenderer$FogMode
 *  net.minecraft.resources.ResourceLocation
 *  net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions
 *  net.neoforged.neoforge.fluids.FluidType
 *  net.neoforged.neoforge.fluids.FluidType$Properties
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3f
 */
package net.thebrokenscript.neoforge.fluids;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidType;
import net.thebrokenscript.api.TBSConstants;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/neoforge/fluids/VoidLiquidFluidType;", "Lnet/neoforged/neoforge/fluids/FluidType;", "<init>", "()V", "clientFluidTypeExtensions", "Lnet/neoforged/neoforge/client/extensions/common/IClientFluidTypeExtensions;", "getClientFluidTypeExtensions", "()Lnet/neoforged/neoforge/client/extensions/common/IClientFluidTypeExtensions;", "thebrokenscript-neoforge"})
public final class VoidLiquidFluidType
extends FluidType {
    @NotNull
    private final IClientFluidTypeExtensions clientFluidTypeExtensions = new IClientFluidTypeExtensions(){

        public ResourceLocation getStillTexture() {
            return TBSConstants.id("block/void_goop_still");
        }

        public ResourceLocation getFlowingTexture() {
            return TBSConstants.id("block/void_goop_flow");
        }

        public ResourceLocation getOverlayTexture() {
            return null;
        }

        public int getTintColor() {
            return super.getTintColor();
        }

        public Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
            Intrinsics.checkNotNullParameter((Object)camera, (String)"camera");
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            Intrinsics.checkNotNullParameter((Object)fluidFogColor, (String)"fluidFogColor");
            Vector3f vector3f = super.modifyFogColor(camera, partialTick, level, renderDistance, darkenWorldAmount, fluidFogColor);
            Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"modifyFogColor(...)");
            return vector3f;
        }

        public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick, float nearDistance, float farDistance, FogShape shape) {
            Intrinsics.checkNotNullParameter((Object)camera, (String)"camera");
            Intrinsics.checkNotNullParameter((Object)mode, (String)"mode");
            Intrinsics.checkNotNullParameter((Object)shape, (String)"shape");
            RenderSystem.setShaderFogStart((float)1.0f);
            RenderSystem.setShaderFogEnd((float)6.0f);
        }
    };

    public VoidLiquidFluidType() {
        super(FluidType.Properties.create());
    }

    @NotNull
    public final IClientFluidTypeExtensions getClientFluidTypeExtensions() {
        return this.clientFluidTypeExtensions;
    }
}

