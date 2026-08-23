/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Camera
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.ClipContext
 *  net.minecraft.world.level.ClipContext$Block
 *  net.minecraft.world.level.ClipContext$Fluid
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.HitResult$Type
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Matrix4f
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 *  org.joml.Vector2f
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 *  org.joml.Vector4f
 */
package net.thebrokenscript.brokencore.api.render;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.ext.LevelExtKt;
import net.thebrokenscript.brokencore.api.platform.PlatformRendering;
import net.thebrokenscript.brokencore.impl.mixin.client.features.layers.RenderStateShardNameAccessor;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector4f;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\u0004\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\n2\b\b\u0002\u0010\b\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u001b\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0002\u00a2\u0006\u0002\u0010\u0011J8\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u001cJ\u0018\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0019H\u0002\u00a8\u0006 "}, d2={"Lnet/thebrokenscript/brokencore/api/render/CensorQuad;", "", "<init>", "()V", "projectPositionToScreen", "Lorg/joml/Vector2f;", "vec3", "Lnet/minecraft/world/phys/Vec3;", "tickDelta", "", "Lorg/joml/Vector3f;", "getBoundingBoxProjectedRect", "Lorg/joml/Vector4f;", "box", "Lnet/minecraft/world/phys/AABB;", "getBoxVerts", "", "(Lnet/minecraft/world/phys/AABB;)[Lorg/joml/Vector3f;", "render", "", "context", "Lnet/minecraft/client/gui/GuiGraphics;", "texture", "Lnet/minecraft/resources/ResourceLocation;", "snapSize", "", "padding", "distanceSnapScalar", "", "step", "x", "by", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nCensorQuad.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CensorQuad.kt\nnet/thebrokenscript/brokencore/api/render/CensorQuad\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,168:1\n1761#2,3:169\n*S KotlinDebug\n*F\n+ 1 CensorQuad.kt\nnet/thebrokenscript/brokencore/api/render/CensorQuad\n*L\n84#1:169,3\n*E\n"})
public final class CensorQuad {
    @NotNull
    public static final CensorQuad INSTANCE = new CensorQuad();

    private CensorQuad() {
    }

    @NotNull
    public final Vector2f projectPositionToScreen(@NotNull Vec3 vec3, float tickDelta) {
        Intrinsics.checkNotNullParameter((Object)vec3, (String)"vec3");
        Minecraft client = Minecraft.getInstance();
        LocalPlayer localPlayer = client.player;
        Intrinsics.checkNotNull((Object)localPlayer);
        LocalPlayer plr = localPlayer;
        Vector4f result = new Vector4f();
        Camera cam = client.gameRenderer.getMainCamera();
        int width = client.getWindow().getGuiScaledWidth();
        int height = client.getWindow().getGuiScaledHeight();
        Vec3 pPos = plr.getPosition(tickDelta).add(0.0, (double)plr.getEyeHeight(), 0.0);
        Vector3f vert = vec3.toVector3f().sub((Vector3fc)pPos.toVector3f());
        Quaternionf r = cam.rotation();
        Matrix4f projMat = client.gameRenderer.getProjectionMatrix((double)((Number)client.options.fov().get()).intValue());
        vert.rotate((Quaternionfc)new Quaternionf(-r.x, -r.y, -r.z, r.w));
        int[] nArray = new int[]{0, 0, width, height};
        projMat.project((Vector3fc)new Vector3f(vert.x, -vert.y, vert.z), nArray, result);
        return new Vector2f(result.x, result.y);
    }

    @NotNull
    public final Vector3f projectPositionToScreen(@NotNull Vector3f vec3, float tickDelta) {
        Intrinsics.checkNotNullParameter((Object)vec3, (String)"vec3");
        Minecraft client = Minecraft.getInstance();
        LocalPlayer localPlayer = client.player;
        Intrinsics.checkNotNull((Object)localPlayer);
        LocalPlayer plr = localPlayer;
        Vector4f result = new Vector4f();
        Camera cam = client.gameRenderer.getMainCamera();
        int width = client.getWindow().getGuiScaledWidth();
        int height = client.getWindow().getGuiScaledHeight();
        Vec3 pPos = plr.getPosition(tickDelta).add(0.0, (double)plr.getEyeHeight(), 0.0);
        Vector3f vert = vec3.sub((Vector3fc)pPos.toVector3f());
        Quaternionf r = cam.rotation();
        Matrix4f projMat = client.gameRenderer.getProjectionMatrix((double)((Number)client.options.fov().get()).intValue());
        vert.rotate((Quaternionfc)new Quaternionf(-r.x, -r.y, -r.z, r.w));
        int[] nArray = new int[]{0, 0, width, height};
        projMat.project((Vector3fc)new Vector3f(vert.x, -vert.y, vert.z), nArray, result);
        return new Vector3f(result.x, result.y, result.z);
    }

    public static /* synthetic */ Vector3f projectPositionToScreen$default(CensorQuad censorQuad, Vector3f vector3f, float f, int n, Object object) {
        if ((n & 2) != 0) {
            f = ClientDSLKt.getMC().getTimer().getGameTimeDeltaTicks();
        }
        return censorQuad.projectPositionToScreen(vector3f, f);
    }

    @NotNull
    public final Vector4f getBoundingBoxProjectedRect(@NotNull AABB box) {
        boolean pastHorizontalNegative;
        Intrinsics.checkNotNullParameter((Object)box, (String)"box");
        Minecraft client = Minecraft.getInstance();
        int width = client.getWindow().getGuiScaledWidth();
        int height = client.getWindow().getGuiScaledHeight();
        Camera cam = client.gameRenderer.getMainCamera();
        Vector3f[] verts = this.getBoxVerts(box);
        float minXPos = Float.MAX_VALUE;
        float minYPos = Float.MAX_VALUE;
        float maxXPos = Float.MIN_VALUE;
        float maxYPos = Float.MIN_VALUE;
        int failCount = 0;
        for (int i = 0; i < 8; ++i) {
            Vec3 ofs;
            Vec3 pPos;
            BlockHitResult raycast;
            Vector3f vert = verts[i];
            Vector4f screenVert = new Vector4f(0.0f);
            LocalPlayer plr = client.player;
            ClientLevel world = client.level;
            if (plr != null && world != null && (raycast = LevelExtKt.clip((Level)world, new ClipContext(pPos = plr.getEyePosition(), ofs = new Vec3(new Vector3f((Vector3fc)new Vector3f((Vector3fc)vert).mul(1.0f, -1.0f, 1.0f)).add((Vector3fc)pPos.toVector3f())), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, (Entity)plr), (Function2<? super BlockPos, ? super BlockState, Boolean>)((Function2)(arg_0, arg_1) -> CensorQuad.getBoundingBoxProjectedRect$lambda$0(world, arg_0, arg_1)))).getType() != HitResult.Type.MISS) {
                ++failCount;
            }
            Quaternionf r = cam.rotation();
            Matrix4f projMat = client.gameRenderer.getProjectionMatrix((double)((Number)client.options.fov().get()).intValue() + 6.0);
            vert.rotate((Quaternionfc)new Quaternionf(r.x, -r.y, r.z, r.w));
            int[] nArray = new int[]{0, 0, width, height};
            projMat.project((Vector3fc)vert, nArray, screenVert);
            if (screenVert.z > 1.0f) {
                return new Vector4f(0.0f);
            }
            minXPos = Math.min(minXPos, screenVert.x);
            minYPos = Math.min(minYPos, screenVert.y);
            maxXPos = Math.max(maxXPos, screenVert.x);
            maxYPos = Math.max(maxYPos, screenVert.y);
        }
        if (failCount == 8) {
            return new Vector4f(0.0f);
        }
        float ysize = Math.abs(maxYPos - minYPos);
        float xsize = Math.abs(maxXPos - minXPos);
        boolean pastVerticalPositive = minYPos >= (float)height;
        boolean pastHorizontalPositive = minXPos >= (float)width;
        boolean pastVerticalNegative = minYPos + ysize <= 0.0f;
        boolean bl = pastHorizontalNegative = minXPos + xsize <= 0.0f;
        if (pastVerticalPositive || pastHorizontalPositive || pastHorizontalNegative || pastVerticalNegative) {
            return new Vector4f(0.0f);
        }
        return new Vector4f(minXPos + xsize, minYPos + ysize, xsize + Math.min(0.0f, minXPos), ysize + Math.min(0.0f, minYPos));
    }

    private final Vector3f[] getBoxVerts(AABB box) {
        float x = (float)box.min(Direction.Axis.X);
        float y = (float)box.min(Direction.Axis.Y) * (float)-1;
        float z = (float)box.min(Direction.Axis.Z);
        float x1 = (float)box.max(Direction.Axis.X);
        float y1 = (float)box.max(Direction.Axis.Y) * (float)-1;
        float z1 = (float)box.max(Direction.Axis.Z);
        Vector3f[] vector3fArray = new Vector3f[]{new Vector3f(x, y, z), new Vector3f(x1, y1, z1), new Vector3f(x1, y, z), new Vector3f(x, y1, z), new Vector3f(x, y, z1), new Vector3f(x1, y1, z), new Vector3f(x, y1, z1), new Vector3f(x1, y, z1)};
        return vector3fArray;
    }

    public final void render(@NotNull GuiGraphics context, @NotNull AABB box, @NotNull ResourceLocation texture, int snapSize, int padding, double distanceSnapScalar) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)box, (String)"box");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        Vector4f coords = this.getBoundingBoxProjectedRect(box);
        if (coords.equals(0.0f, 0.0f, 0.0f, 0.0f)) {
            return;
        }
        int snapSize2 = Math.max((int)((double)snapSize * ((distanceSnapScalar - box.getCenter().distanceTo(new Vec3(0.0, 0.0, 0.0))) / distanceSnapScalar)), 1);
        int w = (int)coords.z + padding + snapSize2 / 2;
        int h = (int)coords.w + padding + snapSize2 / 2;
        int x = this.step((int)coords.x - w, snapSize2) + (coords.x - (float)w > 0.0f ? snapSize2 : 0);
        int y = this.step((int)coords.y - h, snapSize2) + (coords.y - (float)h > 0.0f ? snapSize2 : 0);
        if (x + w > 0 && y + h > 0) {
            context.blit(texture, x, y, 0.0f, 0.0f, w, h, 16, 16);
        }
    }

    public static /* synthetic */ void render$default(CensorQuad censorQuad, GuiGraphics guiGraphics, AABB aABB, ResourceLocation resourceLocation, int n, int n2, double d, int n3, Object object) {
        if ((n3 & 0x20) != 0) {
            d = 64.0;
        }
        censorQuad.render(guiGraphics, aABB, resourceLocation, n, n2, d);
    }

    private final int step(int x, int by) {
        return x - x % by;
    }

    private static final boolean getBoundingBoxProjectedRect$lambda$0(ClientLevel $world, BlockPos pos, BlockState state) {
        boolean bl;
        block3: {
            Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
            Intrinsics.checkNotNullParameter((Object)state, (String)"state");
            List<RenderType> types = PlatformRendering.Companion.getBlockStateRenderTypes($world, state, pos);
            Iterable $this$any$iv = types;
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    RenderType it = (RenderType)element$iv;
                    boolean bl2 = false;
                    Intrinsics.checkNotNull((Object)it, (String)"null cannot be cast to non-null type net.thebrokenscript.brokencore.impl.mixin.client.features.layers.RenderStateShardNameAccessor");
                    String self = ((RenderStateShardNameAccessor)it).bc$renderTypeName();
                    if (!(Intrinsics.areEqual((Object)self, (Object)"solid") ? state.isCollisionShapeFullBlock((BlockGetter)$world, pos) : false)) continue;
                    bl = true;
                    break block3;
                }
                bl = false;
            }
        }
        return bl;
    }
}

