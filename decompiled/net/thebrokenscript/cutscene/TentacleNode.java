/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  io.wispforest.endec.Endec
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KMutableProperty1
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.debug.DebugRenderer
 *  net.minecraft.network.chat.Component
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.client.event.RenderEvents$LevelStageData
 *  net.thebrokenscript.brokencore.api.client.event.RenderStage
 *  net.thebrokenscript.brokencore.api.cutscene.nodes.CutsceneNode
 *  net.thebrokenscript.brokencore.api.cutscene.nodes.CutsceneNodeType
 *  net.thebrokenscript.brokencore.api.ext.RenderExtKt
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 */
package net.thebrokenscript.cutscene;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import io.wispforest.endec.Endec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KMutableProperty1;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.debug.DebugRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.client.event.RenderEvents;
import net.thebrokenscript.brokencore.api.client.event.RenderStage;
import net.thebrokenscript.brokencore.api.cutscene.nodes.CutsceneNode;
import net.thebrokenscript.brokencore.api.cutscene.nodes.CutsceneNodeType;
import net.thebrokenscript.brokencore.api.ext.RenderExtKt;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.client.cutscene.TentacleNodeEditor;
import net.thebrokenscript.client.tentacles.TentacleInfo;
import net.thebrokenscript.client.tentacles.TentacleVertexBuilder;
import net.thebrokenscript.cutscene.TentacleNode;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;
import org.joml.Vector3fc;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001aB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0017J\b\u0010\u000f\u001a\u00020\u0010H\u0017J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0003J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\b\u0010\u0018\u001a\u00020\u0010H\u0017J\b\u0010\u0019\u001a\u00020\u0000H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u0018\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u001b"}, d2={"Lnet/thebrokenscript/cutscene/TentacleNode;", "Lnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNode;", "info", "Lnet/thebrokenscript/client/tentacles/TentacleInfo;", "<init>", "(Lnet/thebrokenscript/client/tentacles/TentacleInfo;)V", "getInfo", "()Lnet/thebrokenscript/client/tentacles/TentacleInfo;", "setInfo", "type", "Lnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNodeType;", "getType", "()Lnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNodeType;", "createUI", "Lnet/thebrokenscript/client/cutscene/TentacleNodeEditor;", "liveUpdate", "", "actuallyRender", "event", "Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$LevelStageData;", "preview", "", "render", "renderPreview", "applyEffects", "copy", "Type", "thebrokenscript-common"})
public final class TentacleNode
extends CutsceneNode {
    @NotNull
    private TentacleInfo info;
    @NotNull
    private final CutsceneNodeType<?> type;

    public TentacleNode(@NotNull TentacleInfo info) {
        Intrinsics.checkNotNullParameter((Object)info, (String)"info");
        this.info = info;
        this.type = Type.INSTANCE;
    }

    public /* synthetic */ TentacleNode(TentacleInfo tentacleInfo, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            tentacleInfo = new TentacleInfo(null, null, null, 0.0f, 0, 0.0f, 63, null);
        }
        this(tentacleInfo);
    }

    @NotNull
    public final TentacleInfo getInfo() {
        return this.info;
    }

    public final void setInfo(@NotNull TentacleInfo tentacleInfo) {
        Intrinsics.checkNotNullParameter((Object)tentacleInfo, (String)"<set-?>");
        this.info = tentacleInfo;
    }

    @NotNull
    public CutsceneNodeType<?> getType() {
        return this.type;
    }

    @SideOnly(side=Side.CLIENT)
    @NotNull
    public TentacleNodeEditor createUI() {
        return new TentacleNodeEditor(this);
    }

    @SideOnly(side=Side.CLIENT)
    public void liveUpdate() {
    }

    @SideOnly(side=Side.CLIENT)
    private final void actuallyRender(RenderEvents.LevelStageData event, boolean preview) {
        if (event.getStage() != RenderStage.AFTER_SOLID_BLOCKS) {
            return;
        }
        Vec3 off = event.getCamera().getPosition().reverse();
        RenderExtKt.pushPop((PoseStack)event.getPoseStack(), () -> TentacleNode.actuallyRender$lambda$0(event, off, preview, this));
    }

    @SideOnly(side=Side.CLIENT)
    public void render(@NotNull RenderEvents.LevelStageData event) {
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        this.actuallyRender(event, false);
    }

    @SideOnly(side=Side.CLIENT)
    public void renderPreview(@NotNull RenderEvents.LevelStageData event) {
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        this.actuallyRender(event, true);
    }

    @SideOnly(side=Side.CLIENT)
    public void applyEffects() {
    }

    @NotNull
    public TentacleNode copy() {
        return new TentacleNode(this.info.copy());
    }

    private static final Unit actuallyRender$lambda$0(RenderEvents.LevelStageData $event, Vec3 $off, boolean $preview, TentacleNode this$0) {
        PoseStack poseStack = $event.getPoseStack();
        Intrinsics.checkNotNull((Object)$off);
        RenderExtKt.translate((PoseStack)poseStack, (Vec3)$off);
        if ($preview) {
            DebugRenderer.renderFilledBox((PoseStack)$event.getPoseStack(), (MultiBufferSource)((MultiBufferSource)$event.getBufs().bufferSource()), (AABB)AABB.unitCubeFromLowerCorner((Vec3)new Vec3(this$0.info.getStart())), (float)1.0f, (float)0.0f, (float)0.0f, (float)1.0f);
            DebugRenderer.renderFilledBox((PoseStack)$event.getPoseStack(), (MultiBufferSource)((MultiBufferSource)$event.getBufs().bufferSource()), (AABB)AABB.unitCubeFromLowerCorner((Vec3)new Vec3(this$0.info.getEnd())), (float)0.0f, (float)0.0f, (float)1.0f, (float)1.0f);
        }
        $event.getPoseStack().translate(this$0.info.getStart().x, this$0.info.getStart().y, this$0.info.getStart().z);
        VertexConsumer cons = $event.getBufs().bufferSource().getBuffer(RenderType.debugQuads());
        Vector3f vector3f = this$0.info.getEnd().sub((Vector3fc)this$0.info.getStart(), new Vector3f());
        Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"sub(...)");
        for (Vector3f vertex : TentacleVertexBuilder.INSTANCE.build(vector3f, this$0.info.getRotator(), this$0.info.getResolution(), this$0.info.getSideRes(), this$0.info.getSize())) {
            cons.addVertex($event.getPoseStack().last(), vertex).setColor(-16777216);
        }
        return Unit.INSTANCE;
    }

    public TentacleNode() {
        this(null, 1, null);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\r\u001a\u00020\u0002H\u0016J \u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/cutscene/TentacleNode$Type;", "Lnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNodeType;", "Lnet/thebrokenscript/cutscene/TentacleNode;", "<init>", "()V", "endec", "Lio/wispforest/endec/Endec;", "getEndec", "()Lio/wispforest/endec/Endec;", "name", "Lnet/minecraft/network/chat/Component;", "getName", "()Lnet/minecraft/network/chat/Component;", "create", "interpolate", "delta", "", "a", "b", "thebrokenscript-common"})
    @SourceDebugExtension(value={"SMAP\nTentacleNode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TentacleNode.kt\nnet/thebrokenscript/cutscene/TentacleNode$Type\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,104:1\n15#2:105\n*S KotlinDebug\n*F\n+ 1 TentacleNode.kt\nnet/thebrokenscript/cutscene/TentacleNode$Type\n*L\n93#1:105\n*E\n"})
    public static final class Type
    extends CutsceneNodeType<TentacleNode> {
        @NotNull
        public static final Type INSTANCE = new Type();
        @NotNull
        private static final Endec<TentacleNode> endec;

        private Type() {
            super(TBSConstants.id("tentacle"));
        }

        @NotNull
        public Endec<TentacleNode> getEndec() {
            return endec;
        }

        @NotNull
        public Component getName() {
            String $this$c$iv = "Tentacle";
            boolean $i$f$getC = false;
            Component component = Component.nullToEmpty((String)$this$c$iv);
            Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
            return component;
        }

        @NotNull
        public TentacleNode create() {
            return new TentacleNode(null, 1, null);
        }

        @NotNull
        public TentacleNode interpolate(float delta, @NotNull TentacleNode a, @NotNull TentacleNode b) {
            Intrinsics.checkNotNullParameter((Object)((Object)a), (String)"a");
            Intrinsics.checkNotNullParameter((Object)((Object)b), (String)"b");
            Vector3f start = a.getInfo().getStart().lerp((Vector3fc)b.getInfo().getStart(), delta, new Vector3f());
            Vector3f end = a.getInfo().getEnd().lerp((Vector3fc)b.getInfo().getEnd(), delta, new Vector3f());
            Intrinsics.checkNotNull((Object)start);
            Intrinsics.checkNotNull((Object)end);
            return new TentacleNode(new TentacleInfo(start, end, null, 0.0f, 0, 0.0f, 60, null));
        }

        private static final TentacleInfo endec$lambda$0(KMutableProperty1 $tmp0, TentacleNode p0) {
            return (TentacleInfo)((Function1)$tmp0).invoke((Object)p0);
        }

        static {
            Endec endec2 = TentacleInfo.Companion.getENDEC().xmap(TentacleNode::new, arg_0 -> Type.endec$lambda$0((KMutableProperty1)endec.2.INSTANCE, arg_0));
            Intrinsics.checkNotNullExpressionValue((Object)endec2, (String)"xmap(...)");
            endec = endec2;
        }
    }
}

