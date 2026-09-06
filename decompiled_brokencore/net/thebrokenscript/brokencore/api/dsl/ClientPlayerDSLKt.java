/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.network.chat.Component
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.dsl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0007\u001a%\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007\u00a2\u0006\u0002\u0010\f\u00a8\u0006\r"}, d2={"send", "", "Lnet/minecraft/client/player/LocalPlayer;", "msg", "Lnet/minecraft/network/chat/Component;", "", "isEntityInFovCone", "", "entity", "Lnet/minecraft/world/entity/Entity;", "fovDegrees", "", "(Lnet/minecraft/client/player/LocalPlayer;Lnet/minecraft/world/entity/Entity;Ljava/lang/Double;)Z", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nClientPlayerDSL.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClientPlayerDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ClientPlayerDSLKt\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,31:1\n15#2:32\n*S KotlinDebug\n*F\n+ 1 ClientPlayerDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ClientPlayerDSLKt\n*L\n11#1:32\n*E\n"})
public final class ClientPlayerDSLKt {
    @SideOnly(side=Side.CLIENT)
    public static final void send(@NotNull LocalPlayer $this$send, @NotNull Component msg) {
        Intrinsics.checkNotNullParameter((Object)$this$send, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)msg, (String)"msg");
        $this$send.sendSystemMessage(msg);
    }

    @SideOnly(side=Side.CLIENT)
    public static final void send(@NotNull LocalPlayer $this$send, @NotNull String msg) {
        Intrinsics.checkNotNullParameter((Object)$this$send, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)msg, (String)"msg");
        String $this$c$iv = msg;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        ClientPlayerDSLKt.send($this$send, component);
    }

    @SideOnly(side=Side.CLIENT)
    public static final boolean isEntityInFovCone(@NotNull LocalPlayer $this$isEntityInFovCone, @NotNull Entity entity, @Nullable Double fovDegrees) {
        Intrinsics.checkNotNullParameter((Object)$this$isEntityInFovCone, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        if (!Intrinsics.areEqual((Object)$this$isEntityInFovCone.level().dimension(), (Object)entity.level().dimension())) {
            return false;
        }
        double fovOptions = ((Number)ClientDSLKt.getMC().options.fov().get()).intValue();
        if (fovOptions == 0.0 && fovDegrees == null) {
            return false;
        }
        Double d = fovDegrees;
        double fov = d != null ? d : fovOptions;
        Vec3 eyePos = $this$isEntityInFovCone.getEyePosition();
        Vec3 toEntity = entity.position().subtract(eyePos).normalize();
        Vec3 lookVec = $this$isEntityInFovCone.getViewVector(1.0f).normalize();
        double dot = lookVec.dot(toEntity);
        double threshold = Math.cos(Math.toRadians(fov / 1.5));
        return dot >= threshold ? $this$isEntityInFovCone.hasLineOfSight(entity) : false;
    }

    public static /* synthetic */ boolean isEntityInFovCone$default(LocalPlayer localPlayer, Entity entity, Double d, int n, Object object) {
        if ((n & 2) != 0) {
            d = null;
        }
        return ClientPlayerDSLKt.isEntityInFovCone(localPlayer, entity, d);
    }
}

