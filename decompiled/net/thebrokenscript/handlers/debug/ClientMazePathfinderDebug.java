/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.brigadier.context.CommandContext
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.renderer.LevelRenderer
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.debug.Debuggable
 *  net.thebrokenscript.brokencore.api.debug.Debugger
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Matrix4f
 */
package net.thebrokenscript.handlers.debug;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.brigadier.context.CommandContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.debug.Debuggable;
import net.thebrokenscript.brokencore.api.debug.Debugger;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.misc.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;

@SideOnly(side=Side.CLIENT)
@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R#\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/handlers/debug/ClientMazePathfinderDebug;", "Lnet/thebrokenscript/brokencore/api/debug/Debuggable;", "<init>", "()V", "category", "", "getCategory", "()Ljava/lang/String;", "paths", "", "", "", "Lnet/minecraft/core/BlockPos;", "getPaths", "()Ljava/util/Map;", "updatePath", "", "entityId", "path", "tickDebug", "renderDebug", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "buffer", "Lnet/minecraft/client/renderer/MultiBufferSource;", "thebrokenscript-common"})
public final class ClientMazePathfinderDebug
implements Debuggable {
    @NotNull
    public static final ClientMazePathfinderDebug INSTANCE = new ClientMazePathfinderDebug();
    @NotNull
    private static final String category;
    @NotNull
    private static final Map<Integer, List<BlockPos>> paths;

    private ClientMazePathfinderDebug() {
    }

    @NotNull
    public String getCategory() {
        return category;
    }

    @NotNull
    public final Map<Integer, List<BlockPos>> getPaths() {
        return paths;
    }

    public final void updatePath(int entityId, @NotNull List<? extends BlockPos> path) {
        Intrinsics.checkNotNullParameter(path, (String)"path");
        if (path.isEmpty()) {
            paths.remove(entityId);
        } else {
            paths.put(entityId, path);
        }
    }

    public void tickDebug() {
    }

    public void renderDebug(@NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer) {
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
        if (paths.isEmpty()) {
            return;
        }
        VertexConsumer lineBuffer = buffer.getBuffer(RenderType.lines());
        Matrix4f matrix = poseStack.last().pose();
        for (List<BlockPos> path : paths.values()) {
            for (BlockPos node : path) {
                LevelRenderer.renderLineBox((PoseStack)poseStack, (VertexConsumer)lineBuffer, (AABB)new AABB((double)node.getX(), (double)node.getY(), (double)node.getZ(), (double)node.getX() + 1.0, (double)node.getY() + 1.0, (double)node.getZ() + 1.0), (float)1.0f, (float)0.4f, (float)0.1f, (float)1.0f);
            }
            int n = path.size() - 1;
            for (int i = 0; i < n; ++i) {
                Vec3 a = Vec3.atCenterOf((Vec3i)((Vec3i)path.get(i)));
                Vec3 b = Vec3.atCenterOf((Vec3i)((Vec3i)path.get(i + 1)));
                lineBuffer.addVertex(matrix, (float)a.x, (float)a.y, (float)a.z).setColor(0.1f, 1.0f, 0.3f, 1.0f).setNormal(poseStack.last(), (float)(b.x - a.x), (float)(b.y - a.y), (float)(b.z - a.z));
                lineBuffer.addVertex(matrix, (float)b.x, (float)b.y, (float)b.z).setColor(0.1f, 1.0f, 0.3f, 1.0f).setNormal(poseStack.last(), (float)(a.x - b.x), (float)(a.y - b.y), (float)(a.z - b.z));
            }
        }
    }

    private static final Unit _init_$lambda$0(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Debugger.INSTANCE.setEnabled(true);
        Debugger.INSTANCE.getDebuggables().add((Object)INSTANCE);
        Debugger.INSTANCE.getEnabledDebuggers().add(INSTANCE.getCategory());
        INSTANCE.debug();
        return Unit.INSTANCE;
    }

    static {
        Debugger.INSTANCE.getTests().put("pathfinder_test", ClientMazePathfinderDebug::_init_$lambda$0);
        category = "pathfinder";
        paths = new HashMap();
    }
}

