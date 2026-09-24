/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.math.Axis
 *  io.wispforest.endec.Endec
 *  io.wispforest.endec.StructEndec
 *  io.wispforest.endec.impl.StructEndecBuilder
 *  io.wispforest.endec.impl.StructField
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KMutableProperty1
 *  net.minecraft.client.Camera
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.debug.DebugRenderer
 *  net.minecraft.network.chat.Component
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 */
package net.thebrokenscript.brokencore.api.cutscene.nodes;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import io.wispforest.endec.Endec;
import io.wispforest.endec.StructEndec;
import io.wispforest.endec.impl.StructEndecBuilder;
import io.wispforest.endec.impl.StructField;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KMutableProperty1;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.debug.DebugRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.BCApi;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.nodes.TransformNodeEditor;
import net.thebrokenscript.brokencore.api.client.event.RenderEvents;
import net.thebrokenscript.brokencore.api.client.event.RenderStage;
import net.thebrokenscript.brokencore.api.cutscene.nodes.CutsceneNode;
import net.thebrokenscript.brokencore.api.cutscene.nodes.CutsceneNodeType;
import net.thebrokenscript.brokencore.api.cutscene.nodes.TransformNode;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.ext.RenderExtKt;
import net.thebrokenscript.brokencore.api.ext.miximpl.CameraExtImplKt;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.brokencore.api.util.math.MathUtilKt;
import net.thebrokenscript.brokencore.api.util.math.Rotation;
import net.thebrokenscript.brokencore.api.util.math.Transform;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;
import org.joml.Vector3fc;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0019B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\r\u001a\u00020\u0000H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0017J\b\u0010\u0010\u001a\u00020\u0011H\u0017J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J\b\u0010\u0016\u001a\u00020\u0011H\u0017J\b\u0010\u0017\u001a\u00020\u0011H\u0017J\b\u0010\u0018\u001a\u00020\u0011H\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u0018\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u001a"}, d2={"Lnet/thebrokenscript/brokencore/api/cutscene/nodes/TransformNode;", "Lnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNode;", "transform", "Lnet/thebrokenscript/brokencore/api/util/math/Transform;", "<init>", "(Lnet/thebrokenscript/brokencore/api/util/math/Transform;)V", "getTransform", "()Lnet/thebrokenscript/brokencore/api/util/math/Transform;", "setTransform", "type", "Lnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNodeType;", "getType", "()Lnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNodeType;", "copy", "createUI", "Lnet/thebrokenscript/brokencore/api/client/cutscene/editor/nodes/TransformNodeEditor;", "liveUpdate", "", "render", "event", "Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$LevelStageData;", "renderPreview", "setup", "cleanup", "applyEffects", "Type", "brokencore-common"})
public final class TransformNode
extends CutsceneNode {
    @NotNull
    private Transform transform;
    @NotNull
    private final CutsceneNodeType<?> type;

    public TransformNode(@NotNull Transform transform2) {
        Intrinsics.checkNotNullParameter((Object)transform2, (String)"transform");
        this.transform = transform2;
        this.type = Type.INSTANCE;
    }

    public /* synthetic */ TransformNode(Transform transform2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            transform2 = new Transform(null, null, 3, null);
        }
        this(transform2);
    }

    @NotNull
    public final Transform getTransform() {
        return this.transform;
    }

    public final void setTransform(@NotNull Transform transform2) {
        Intrinsics.checkNotNullParameter((Object)transform2, (String)"<set-?>");
        this.transform = transform2;
    }

    @Override
    @NotNull
    public CutsceneNodeType<?> getType() {
        return this.type;
    }

    @Override
    @NotNull
    public TransformNode copy() {
        return new TransformNode(this.transform.copy());
    }

    @SideOnly(side=Side.CLIENT)
    @NotNull
    public TransformNodeEditor createUI() {
        return new TransformNodeEditor(this);
    }

    @Override
    @SideOnly(side=Side.CLIENT)
    public void liveUpdate() {
    }

    @Override
    @SideOnly(side=Side.CLIENT)
    public void render(@NotNull RenderEvents.LevelStageData event) {
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
    }

    @Override
    @SideOnly(side=Side.CLIENT)
    public void renderPreview(@NotNull RenderEvents.LevelStageData event) {
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        if (event.getStage() != RenderStage.AFTER_SOLID_BLOCKS) {
            return;
        }
        Vec3 off = event.getCamera().getPosition().reverse();
        RenderExtKt.pushPop(event.getPoseStack(), () -> TransformNode.renderPreview$lambda$0(event, off, this));
    }

    @Override
    @SideOnly(side=Side.CLIENT)
    public void setup() {
        Camera camera = ClientDSLKt.getMC().gameRenderer.getMainCamera();
        Intrinsics.checkNotNullExpressionValue((Object)camera, (String)"getMainCamera(...)");
        CameraExtImplKt.getOverrides(camera).setActive(true);
    }

    @Override
    @SideOnly(side=Side.CLIENT)
    public void cleanup() {
        Camera camera = ClientDSLKt.getMC().gameRenderer.getMainCamera();
        Intrinsics.checkNotNullExpressionValue((Object)camera, (String)"getMainCamera(...)");
        CameraExtImplKt.getOverrides(camera).setActive(false);
    }

    @Override
    @SideOnly(side=Side.CLIENT)
    public void applyEffects() {
        Camera camera = ClientDSLKt.getMC().gameRenderer.getMainCamera();
        Intrinsics.checkNotNullExpressionValue((Object)camera, (String)"getMainCamera(...)");
        CameraExtImplKt.getOverrides(camera).setTransform(this.transform);
        Camera camera2 = ClientDSLKt.getMC().gameRenderer.getMainCamera();
        Intrinsics.checkNotNullExpressionValue((Object)camera2, (String)"getMainCamera(...)");
        CameraExtImplKt.updateOverrides(camera2);
    }

    private static final Unit renderPreview$lambda$0(RenderEvents.LevelStageData $event, Vec3 $off, TransformNode this$0) {
        PoseStack poseStack = $event.getPoseStack();
        Intrinsics.checkNotNull((Object)$off);
        RenderExtKt.translate(poseStack, $off);
        RenderExtKt.translate($event.getPoseStack(), new Vec3(this$0.transform.getPosition()));
        $event.getPoseStack().mulPose(Axis.XP.rotationDegrees(this$0.transform.getRotation().getPitch()));
        $event.getPoseStack().mulPose(Axis.YP.rotationDegrees(this$0.transform.getRotation().getYaw()));
        DebugRenderer.renderFilledBox((PoseStack)$event.getPoseStack(), (MultiBufferSource)((MultiBufferSource)$event.getBufs().bufferSource()), (AABB)AABB.unitCubeFromLowerCorner((Vec3)Vec3.ZERO), (float)0.0f, (float)0.0f, (float)1.0f, (float)0.5f);
        return Unit.INSTANCE;
    }

    public TransformNode() {
        this(null, 1, null);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\r\u001a\u00020\u0002H\u0016J \u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/brokencore/api/cutscene/nodes/TransformNode$Type;", "Lnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNodeType;", "Lnet/thebrokenscript/brokencore/api/cutscene/nodes/TransformNode;", "<init>", "()V", "endec", "Lio/wispforest/endec/Endec;", "getEndec", "()Lio/wispforest/endec/Endec;", "name", "Lnet/minecraft/network/chat/Component;", "getName", "()Lnet/minecraft/network/chat/Component;", "create", "interpolate", "delta", "", "a", "b", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nTransformNode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransformNode.kt\nnet/thebrokenscript/brokencore/api/cutscene/nodes/TransformNode$Type\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,96:1\n15#2:97\n*S KotlinDebug\n*F\n+ 1 TransformNode.kt\nnet/thebrokenscript/brokencore/api/cutscene/nodes/TransformNode$Type\n*L\n82#1:97\n*E\n"})
    public static final class Type
    extends CutsceneNodeType<TransformNode> {
        @NotNull
        public static final Type INSTANCE = new Type();
        @NotNull
        private static final Endec<TransformNode> endec;

        private Type() {
            super(BCApi.id("transform"));
        }

        @Override
        @NotNull
        public Endec<TransformNode> getEndec() {
            return endec;
        }

        @Override
        @NotNull
        public Component getName() {
            String $this$c$iv = "Transform";
            boolean $i$f$getC = false;
            Component component = Component.nullToEmpty((String)$this$c$iv);
            Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
            return component;
        }

        @Override
        @NotNull
        public TransformNode create() {
            return new TransformNode(null, 1, null);
        }

        @Override
        @NotNull
        public TransformNode interpolate(float delta, @NotNull TransformNode a, @NotNull TransformNode b) {
            Intrinsics.checkNotNullParameter((Object)a, (String)"a");
            Intrinsics.checkNotNullParameter((Object)b, (String)"b");
            Vector3f pos = a.getTransform().getPosition().lerp((Vector3fc)b.getTransform().getPosition(), delta, new Vector3f());
            float pitch = MathUtilKt.lerpf(delta, (Number)Float.valueOf(a.getTransform().getRotation().getPitch()), (Number)Float.valueOf(b.getTransform().getRotation().getPitch()));
            float yaw = MathUtilKt.lerpf(delta, (Number)Float.valueOf(a.getTransform().getRotation().getYaw()), (Number)Float.valueOf(b.getTransform().getRotation().getYaw()));
            Rotation rot = new Rotation(pitch, yaw);
            Intrinsics.checkNotNull((Object)pos);
            return new TransformNode(new Transform(pos, rot));
        }

        private static final Transform endec$lambda$0(KMutableProperty1 $tmp0, TransformNode p0) {
            return (Transform)((Function1)$tmp0).invoke((Object)p0);
        }

        static {
            StructEndec structEndec = StructEndecBuilder.of((StructField)Transform.Companion.getENDEC().fieldOf("transform", arg_0 -> Type.endec$lambda$0((KMutableProperty1)endec.1.INSTANCE, arg_0)), TransformNode::new);
            Intrinsics.checkNotNullExpressionValue((Object)structEndec, (String)"of(...)");
            endec = (Endec)structEndec;
        }
    }
}

