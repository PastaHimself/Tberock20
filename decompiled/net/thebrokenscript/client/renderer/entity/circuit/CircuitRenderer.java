/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.core.Position
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.client.util.Billboarder
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Vector3f
 *  software.bernie.geckolib.model.GeoModel
 *  software.bernie.geckolib.renderer.GeoEntityRenderer
 */
package net.thebrokenscript.client.renderer.entity.circuit;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.Position;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.entity.BaseCircuitEntity;
import net.thebrokenscript.brokencore.api.client.util.Billboarder;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.client.model.entity.CircuitModel;
import net.thebrokenscript.entity.circuit.CircuitEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\rJ1\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016\u00a2\u0006\u0002\u0010\u0016J=\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0015H\u0014\u00a2\u0006\u0002\u0010\u001f\u00a8\u0006 "}, d2={"Lnet/thebrokenscript/client/renderer/entity/circuit/CircuitRenderer;", "T", "Lnet/thebrokenscript/api/entity/BaseCircuitEntity;", "Lsoftware/bernie/geckolib/renderer/GeoEntityRenderer;", "renderManager", "Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;", "model", "Lsoftware/bernie/geckolib/model/GeoModel;", "<init>", "(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;Lsoftware/bernie/geckolib/model/GeoModel;)V", "getTextureLocation", "Lnet/minecraft/resources/ResourceLocation;", "animatable", "(Lnet/thebrokenscript/api/entity/BaseCircuitEntity;)Lnet/minecraft/resources/ResourceLocation;", "getRenderType", "Lnet/minecraft/client/renderer/RenderType;", "entity", "tex", "buffers", "Lnet/minecraft/client/renderer/MultiBufferSource;", "partialTicks", "", "(Lnet/thebrokenscript/api/entity/BaseCircuitEntity;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/client/renderer/MultiBufferSource;F)Lnet/minecraft/client/renderer/RenderType;", "applyRotations", "", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "ageInTicks", "rotationYaw", "partialTick", "nativeScale", "(Lnet/thebrokenscript/api/entity/BaseCircuitEntity;Lcom/mojang/blaze3d/vertex/PoseStack;FFFF)V", "thebrokenscript-common"})
public class CircuitRenderer<T extends BaseCircuitEntity>
extends GeoEntityRenderer<T> {
    public CircuitRenderer(@NotNull EntityRendererProvider.Context renderManager, @NotNull GeoModel<T> model2) {
        Intrinsics.checkNotNullParameter((Object)renderManager, (String)"renderManager");
        Intrinsics.checkNotNullParameter(model2, (String)"model");
        super(renderManager, model2);
        this.shadowRadius = 0.5f;
    }

    public /* synthetic */ CircuitRenderer(EntityRendererProvider.Context context, GeoModel geoModel, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            geoModel = (GeoModel)new CircuitModel();
        }
        this(context, geoModel);
    }

    @NotNull
    public ResourceLocation getTextureLocation(@NotNull T animatable) {
        Intrinsics.checkNotNullParameter(animatable, (String)"animatable");
        return TBSConstants.id("textures/entities/circy.png");
    }

    @Nullable
    public RenderType getRenderType(@NotNull T entity, @NotNull ResourceLocation tex, @Nullable MultiBufferSource buffers, float partialTicks) {
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)tex, (String)"tex");
        return RenderType.entityTranslucent((ResourceLocation)this.getTextureLocation(entity));
    }

    protected void applyRotations(@NotNull T entity, @NotNull PoseStack poseStack, float ageInTicks, float rotationYaw, float partialTick, float nativeScale) {
        UUID targetUUID;
        CircuitEntity circuit;
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Vec3 vec3 = ((BaseMonster)entity).getPos().add(0.0, (double)this.entityRenderDispatcher.camera.getEntity().getEyeHeight(), 0.0);
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"add(...)");
        Vector3f entPos = PositionUtil.getJoml((Position)((Position)vec3));
        Vec3 vec32 = this.entityRenderDispatcher.camera.getPosition();
        Intrinsics.checkNotNullExpressionValue((Object)vec32, (String)"getPosition(...)");
        Vector3f ppos = PositionUtil.getJoml((Position)((Position)vec32));
        CircuitEntity circuitEntity = circuit = entity instanceof CircuitEntity ? (CircuitEntity)((Object)entity) : null;
        boolean isClimbing = circuitEntity != null ? circuitEntity.getClimbing() : false;
        CircuitEntity circuitEntity2 = circuit;
        UUID uUID = targetUUID = circuitEntity2 != null ? EntityUtil.clientTargetUUID((Entity)((Entity)circuitEntity2)) : null;
        if (circuit != null && !isClimbing && Intrinsics.areEqual((Object)targetUUID, (Object)this.entityRenderDispatcher.camera.getEntity().getUUID()) && entPos.distanceSquared(ppos.x, entPos.y, ppos.z) > 250.0f) {
            Billboarder.INSTANCE.withHorizRotationTo(poseStack, entPos, ppos);
        } else if (circuit != null && !isClimbing && targetUUID != null) {
            Player targetPlayer = ((BaseMonster)entity).getLevel().getPlayerByUUID(targetUUID);
            if (targetPlayer != null) {
                Vec3 vec33 = ((BaseMonster)entity).getPos().add(0.0, (double)targetPlayer.getEyeHeight(), 0.0);
                Intrinsics.checkNotNullExpressionValue((Object)vec33, (String)"add(...)");
                Vector3f targetPos = PositionUtil.getJoml((Position)((Position)vec33));
                Billboarder.INSTANCE.withHorizRotationTo(poseStack, targetPos, ppos);
            } else {
                super.applyRotations((Entity)entity, poseStack, ageInTicks, rotationYaw, partialTick, nativeScale);
            }
        } else {
            super.applyRotations((Entity)entity, poseStack, ageInTicks, rotationYaw, partialTick, nativeScale);
        }
    }
}

