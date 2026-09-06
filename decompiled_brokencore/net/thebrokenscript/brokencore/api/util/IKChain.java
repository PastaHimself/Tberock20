/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.elenterius.fabiko.core.FabrikBone3f
 *  com.github.elenterius.fabiko.core.FabrikChain3f
 *  com.github.elenterius.fabiko.core.FabrikChain3f$BaseBoneBuilder
 *  com.github.elenterius.fabiko.core.FabrikChain3f$ConsecutiveBoneBuilder
 *  com.github.elenterius.fabiko.core.FabrikSolver3f
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.server.level.ServerLevel
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Quaternionfc
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 */
package net.thebrokenscript.brokencore.api.util;

import com.github.elenterius.fabiko.core.FabrikBone3f;
import com.github.elenterius.fabiko.core.FabrikChain3f;
import com.github.elenterius.fabiko.core.FabrikSolver3f;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.server.level.ServerLevel;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.brokencore.api.ext.RenderExtKt;
import net.thebrokenscript.brokencore.api.global.GlobalMathKt;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionfc;
import org.joml.Vector3f;
import org.joml.Vector3fc;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 82\u00020\u0001:\u0003678B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u0015J\u0010\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$J\u0018\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0007J>\u0010*\u001a\u00020\u001f26\u0010+\u001a2\u0012\u0013\u0012\u00110-\u00a2\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0013\u0012\u00110-\u00a2\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u001f0,Jh\u00102\u001a\u00020\u001f2`\u0010+\u001a\\\u0012\u0013\u0012\u00110-\u00a2\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0013\u0012\u00110-\u00a2\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(1\u0012\u0013\u0012\u001104\u00a2\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(5\u0012\u0013\u0012\u00110$\u00a2\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u001f03R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0011\u0010\u0014\u001a\u00020\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00069"}, d2={"Lnet/thebrokenscript/brokencore/api/util/IKChain;", "", "chain", "Lcom/github/elenterius/fabiko/core/FabrikChain3f;", "<init>", "(Lcom/github/elenterius/fabiko/core/FabrikChain3f;)V", "getChain", "()Lcom/github/elenterius/fabiko/core/FabrikChain3f;", "target", "Lorg/joml/Vector3f;", "getTarget", "()Lorg/joml/Vector3f;", "level", "Lnet/minecraft/server/level/ServerLevel;", "getLevel", "()Lnet/minecraft/server/level/ServerLevel;", "setLevel", "(Lnet/minecraft/server/level/ServerLevel;)V", "position", "getPosition", "length", "", "getLength", "()F", "solver", "Lcom/github/elenterius/fabiko/core/FabrikSolver3f;", "getSolver", "()Lcom/github/elenterius/fabiko/core/FabrikSolver3f;", "reachableInternal", "", "update", "", "reachEpsilon", "getBoneQuaternion", "Lorg/joml/Quaternionfc;", "index", "", "renderDebug", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "buffer", "Lnet/minecraft/client/renderer/MultiBufferSource;", "forEachBone", "consumer", "Lkotlin/Function2;", "Lorg/joml/Vector3fc;", "Lkotlin/ParameterName;", "name", "start", "end", "forEachBoneIndexed", "Lkotlin/Function4;", "Lcom/github/elenterius/fabiko/core/FabrikBone3f;", "bone", "MultiRestraintBuilder", "SingleRestraintBuilder", "Companion", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nIKChain.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IKChain.kt\nnet/thebrokenscript/brokencore/api/util/IKChain\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,149:1\n13805#2,2:150\n13870#2,3:152\n*S KotlinDebug\n*F\n+ 1 IKChain.kt\nnet/thebrokenscript/brokencore/api/util/IKChain\n*L\n52#1:150,2\n58#1:152,3\n*E\n"})
public final class IKChain {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final FabrikChain3f chain;
    @NotNull
    private final Vector3f target;
    @Nullable
    private ServerLevel level;
    @NotNull
    private final Vector3f position;
    @NotNull
    private final FabrikSolver3f solver;
    private boolean reachableInternal;

    private IKChain(FabrikChain3f chain) {
        this.chain = chain;
        this.target = new Vector3f(0.0f);
        this.position = new Vector3f(0.0f);
        this.solver = new FabrikSolver3f();
    }

    @NotNull
    public final FabrikChain3f getChain() {
        return this.chain;
    }

    @NotNull
    public final Vector3f getTarget() {
        return this.target;
    }

    @Nullable
    public final ServerLevel getLevel() {
        return this.level;
    }

    public final void setLevel(@Nullable ServerLevel serverLevel) {
        this.level = serverLevel;
    }

    @NotNull
    public final Vector3f getPosition() {
        return this.position;
    }

    public final float getLength() {
        return this.chain.getLength();
    }

    @NotNull
    public final FabrikSolver3f getSolver() {
        return this.solver;
    }

    public final void update(float reachEpsilon) {
        Vector3f t = new Vector3f((Vector3fc)this.target).sub((Vector3fc)this.position);
        this.solver.solveForTarget(this.chain, (Vector3fc)t);
        this.reachableInternal = t.distance(this.chain.getEndEffectorBone().getEndLocation()) < reachEpsilon;
    }

    public static /* synthetic */ void update$default(IKChain iKChain, float f, int n, Object object) {
        if ((n & 1) != 0) {
            f = 0.01f;
        }
        iKChain.update(f);
    }

    @Nullable
    public final Quaternionfc getBoneQuaternion(int index) {
        FabrikBone3f fabrikBone3f = this.chain.getBone(index);
        return fabrikBone3f != null ? fabrikBone3f.getOrientation() : null;
    }

    @SideOnly(side=Side.CLIENT)
    public final void renderDebug(@NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer) {
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
        RenderExtKt.pushPop(poseStack, () -> IKChain.renderDebug$lambda$0(this, buffer, poseStack));
    }

    public final void forEachBone(@NotNull Function2<? super Vector3fc, ? super Vector3fc, Unit> consumer) {
        Intrinsics.checkNotNullParameter(consumer, (String)"consumer");
        FabrikBone3f[] fabrikBone3fArray = this.chain.getBones();
        Intrinsics.checkNotNullExpressionValue((Object)fabrikBone3fArray, (String)"getBones(...)");
        Object[] $this$forEach$iv = fabrikBone3fArray;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            FabrikBone3f it = (FabrikBone3f)element$iv;
            boolean bl = false;
            Vector3fc vector3fc = it.getStartLocation();
            Intrinsics.checkNotNullExpressionValue((Object)vector3fc, (String)"getStartLocation(...)");
            Vector3fc vector3fc2 = it.getEndLocation();
            Intrinsics.checkNotNullExpressionValue((Object)vector3fc2, (String)"getEndLocation(...)");
            consumer.invoke((Object)vector3fc, (Object)vector3fc2);
        }
    }

    /*
     * WARNING - void declaration
     */
    public final void forEachBoneIndexed(@NotNull Function4<? super Vector3fc, ? super Vector3fc, ? super FabrikBone3f, ? super Integer, Unit> consumer) {
        Intrinsics.checkNotNullParameter(consumer, (String)"consumer");
        FabrikBone3f[] fabrikBone3fArray = this.chain.getBones();
        Intrinsics.checkNotNullExpressionValue((Object)fabrikBone3fArray, (String)"getBones(...)");
        Object[] $this$forEachIndexed$iv = fabrikBone3fArray;
        boolean $i$f$forEachIndexed = false;
        int index$iv = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            void f;
            int n = index$iv++;
            FabrikBone3f fabrikBone3f = (FabrikBone3f)item$iv;
            int index = n;
            boolean bl = false;
            Vector3fc vector3fc = f.getStartLocation();
            Intrinsics.checkNotNullExpressionValue((Object)vector3fc, (String)"getStartLocation(...)");
            Vector3fc vector3fc2 = f.getEndLocation();
            Intrinsics.checkNotNullExpressionValue((Object)vector3fc2, (String)"getEndLocation(...)");
            FabrikBone3f fabrikBone3f2 = this.chain.getBone(index);
            Intrinsics.checkNotNullExpressionValue((Object)fabrikBone3f2, (String)"getBone(...)");
            consumer.invoke((Object)vector3fc, (Object)vector3fc2, (Object)fabrikBone3f2, (Object)index);
        }
    }

    private static final Unit renderDebug$lambda$0(IKChain this$0, MultiBufferSource $buffer, PoseStack $poseStack) {
        this$0.forEachBone((Function2<? super Vector3fc, ? super Vector3fc, Unit>)((Function2)(arg_0, arg_1) -> IKChain.renderDebug$lambda$0$0($buffer, $poseStack, arg_0, arg_1)));
        return Unit.INSTANCE;
    }

    private static final Unit renderDebug$lambda$0$0(MultiBufferSource $buffer, PoseStack $poseStack, Vector3fc startOrig, Vector3fc endOrig) {
        Intrinsics.checkNotNullParameter((Object)startOrig, (String)"startOrig");
        Intrinsics.checkNotNullParameter((Object)endOrig, (String)"endOrig");
        Vector3f start = new Vector3f(startOrig);
        Vector3f end = new Vector3f(endOrig);
        VertexConsumer buff = $buffer.getBuffer(RenderType.debugLineStrip((double)4.0));
        buff.addVertex($poseStack.last(), start).setColor(0.0f, 1.0f, 1.0f, 1.0f);
        buff.addVertex($poseStack.last(), end).setColor(0.0f, 1.0f, 1.0f, 1.0f);
        return Unit.INSTANCE;
    }

    public /* synthetic */ IKChain(FabrikChain3f chain, DefaultConstructorMarker $constructor_marker) {
        this(chain);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u00a2\u0006\u0002\b\fH\u0086\u0002J2\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\t\u00a2\u0006\u0002\b\fH\u0086\u0002\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/api/util/IKChain$Companion;", "", "<init>", "()V", "invoke", "Lnet/thebrokenscript/brokencore/api/util/IKChain;", "startPos", "Lorg/joml/Vector3fc;", "init", "Lkotlin/Function1;", "Lnet/thebrokenscript/brokencore/api/util/IKChain$MultiRestraintBuilder;", "", "Lkotlin/ExtensionFunctionType;", "angleDegrees", "", "Lnet/thebrokenscript/brokencore/api/util/IKChain$SingleRestraintBuilder;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final IKChain invoke(@NotNull Vector3fc startPos, @NotNull Function1<? super MultiRestraintBuilder, Unit> init) {
            Intrinsics.checkNotNullParameter((Object)startPos, (String)"startPos");
            Intrinsics.checkNotNullParameter(init, (String)"init");
            MultiRestraintBuilder multiRestraintBuilder = new MultiRestraintBuilder(new Vector3f(startPos));
            init.invoke((Object)multiRestraintBuilder);
            return multiRestraintBuilder.build();
        }

        @NotNull
        public final IKChain invoke(float angleDegrees, @NotNull Vector3fc startPos, @NotNull Function1<? super SingleRestraintBuilder, Unit> init) {
            Intrinsics.checkNotNullParameter((Object)startPos, (String)"startPos");
            Intrinsics.checkNotNullParameter(init, (String)"init");
            SingleRestraintBuilder singleRestraintBuilder = new SingleRestraintBuilder(GlobalMathKt.getToRadians(angleDegrees), new Vector3f(startPos));
            init.invoke((Object)singleRestraintBuilder);
            return singleRestraintBuilder.build();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u000bJ0\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lnet/thebrokenscript/brokencore/api/util/IKChain$MultiRestraintBuilder;", "", "currentPos", "Lorg/joml/Vector3f;", "<init>", "(Lorg/joml/Vector3f;)V", "chain", "Lcom/github/elenterius/fabiko/core/FabrikChain3f$BaseBoneBuilder;", "builder", "Lcom/github/elenterius/fabiko/core/FabrikChain3f$ConsecutiveBoneBuilder;", "baseAdded", "", "rotor", "", "pos", "restraintAngleDeg", "", "local", "hinge", "axis", "refAxis", "build", "Lnet/thebrokenscript/brokencore/api/util/IKChain;", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nIKChain.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IKChain.kt\nnet/thebrokenscript/brokencore/api/util/IKChain$MultiRestraintBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,149:1\n1#2:150\n*E\n"})
    public static final class MultiRestraintBuilder {
        @NotNull
        private Vector3f currentPos;
        @NotNull
        private final FabrikChain3f.BaseBoneBuilder chain;
        private FabrikChain3f.ConsecutiveBoneBuilder builder;
        private boolean baseAdded;

        public MultiRestraintBuilder(@NotNull Vector3f currentPos) {
            Intrinsics.checkNotNullParameter((Object)currentPos, (String)"currentPos");
            this.currentPos = currentPos;
            FabrikChain3f.BaseBoneBuilder baseBoneBuilder = FabrikChain3f.builder();
            Intrinsics.checkNotNullExpressionValue((Object)baseBoneBuilder, (String)"builder(...)");
            this.chain = baseBoneBuilder;
        }

        public final void rotor(@NotNull Vector3f pos, float restraintAngleDeg, boolean local) {
            Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
            Vector3f normal = PositionUtil.normalFacing(this.currentPos, pos);
            float distance = this.currentPos.distance((Vector3fc)pos);
            float angleRadians = GlobalMathKt.getToRadians(restraintAngleDeg);
            if (this.baseAdded) {
                FabrikChain3f.ConsecutiveBoneBuilder consecutiveBoneBuilder = this.builder;
                if (consecutiveBoneBuilder == null) {
                    Intrinsics.throwUninitializedPropertyAccessException((String)"builder");
                    consecutiveBoneBuilder = null;
                }
                FabrikChain3f.ConsecutiveBoneBuilder consecutiveBoneBuilder2 = consecutiveBoneBuilder.addRotorConstrainedBone((Vector3fc)normal, distance, angleRadians, local);
                Intrinsics.checkNotNull((Object)consecutiveBoneBuilder2);
            } else {
                FabrikChain3f.ConsecutiveBoneBuilder consecutiveBoneBuilder = this.chain.addRotorConstrainedBaseBone((Vector3fc)this.currentPos, (Vector3fc)normal, distance, angleRadians, false);
                Intrinsics.checkNotNullExpressionValue((Object)consecutiveBoneBuilder, (String)"addRotorConstrainedBaseBone(...)");
                this.builder = consecutiveBoneBuilder;
                this.baseAdded = true;
            }
            this.currentPos = pos;
        }

        public static /* synthetic */ void rotor$default(MultiRestraintBuilder multiRestraintBuilder, Vector3f vector3f, float f, boolean bl, int n, Object object) {
            if ((n & 4) != 0) {
                bl = true;
            }
            multiRestraintBuilder.rotor(vector3f, f, bl);
        }

        public final void hinge(@NotNull Vector3f pos, @NotNull Vector3f axis, @NotNull Vector3f refAxis, float restraintAngleDeg, boolean local) {
            Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
            Intrinsics.checkNotNullParameter((Object)axis, (String)"axis");
            Intrinsics.checkNotNullParameter((Object)refAxis, (String)"refAxis");
            Vector3f normal = PositionUtil.normalFacing(this.currentPos, pos);
            float distance = this.currentPos.distance((Vector3fc)pos);
            float angleRadians = GlobalMathKt.getToRadians(restraintAngleDeg);
            if (this.baseAdded) {
                FabrikChain3f.ConsecutiveBoneBuilder consecutiveBoneBuilder = this.builder;
                if (consecutiveBoneBuilder == null) {
                    Intrinsics.throwUninitializedPropertyAccessException((String)"builder");
                    consecutiveBoneBuilder = null;
                }
                FabrikChain3f.ConsecutiveBoneBuilder consecutiveBoneBuilder2 = consecutiveBoneBuilder.addHingeConstrainedBone((Vector3fc)normal, distance, (Vector3fc)axis, angleRadians, angleRadians, (Vector3fc)refAxis, local);
                Intrinsics.checkNotNull((Object)consecutiveBoneBuilder2);
            } else {
                FabrikChain3f.ConsecutiveBoneBuilder consecutiveBoneBuilder = this.chain.addHingeConstrainedBaseBone((Vector3fc)this.currentPos, (Vector3fc)normal, distance, (Vector3fc)axis, angleRadians, angleRadians, (Vector3fc)refAxis, false);
                Intrinsics.checkNotNullExpressionValue((Object)consecutiveBoneBuilder, (String)"addHingeConstrainedBaseBone(...)");
                this.builder = consecutiveBoneBuilder;
                this.baseAdded = true;
            }
            this.currentPos = pos;
        }

        public static /* synthetic */ void hinge$default(MultiRestraintBuilder multiRestraintBuilder, Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, float f, boolean bl, int n, Object object) {
            if ((n & 0x10) != 0) {
                bl = true;
            }
            multiRestraintBuilder.hinge(vector3f, vector3f2, vector3f3, f, bl);
        }

        @NotNull
        public final IKChain build() {
            FabrikChain3f.ConsecutiveBoneBuilder consecutiveBoneBuilder = this.builder;
            if (consecutiveBoneBuilder == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"builder");
                consecutiveBoneBuilder = null;
            }
            FabrikChain3f fabrikChain3f = consecutiveBoneBuilder.build();
            Intrinsics.checkNotNullExpressionValue((Object)fabrikChain3f, (String)"build(...)");
            FabrikChain3f chain = fabrikChain3f;
            if (!(chain.getBoneCount() >= 2)) {
                boolean bl = false;
                String string = "IKChain must have more than 1 bone or 3 joints";
                throw new IllegalStateException(string.toString());
            }
            return new IKChain(chain, null);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u0010\u001a\u00020\u00112\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00050\u0013\u00a2\u0006\u0002\b\u0014J\u0006\u0010\u0015\u001a\u00020\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lnet/thebrokenscript/brokencore/api/util/IKChain$SingleRestraintBuilder;", "", "angleRadians", "", "currentPos", "Lorg/joml/Vector3f;", "<init>", "(FLorg/joml/Vector3f;)V", "getAngleRadians", "()F", "chain", "Lcom/github/elenterius/fabiko/core/FabrikChain3f$BaseBoneBuilder;", "builder", "Lcom/github/elenterius/fabiko/core/FabrikChain3f$ConsecutiveBoneBuilder;", "baseAdded", "", "rotor", "", "init", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "build", "Lnet/thebrokenscript/brokencore/api/util/IKChain;", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nIKChain.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IKChain.kt\nnet/thebrokenscript/brokencore/api/util/IKChain$SingleRestraintBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,149:1\n1#2:150\n*E\n"})
    public static final class SingleRestraintBuilder {
        private final float angleRadians;
        @NotNull
        private Vector3f currentPos;
        @NotNull
        private final FabrikChain3f.BaseBoneBuilder chain;
        private FabrikChain3f.ConsecutiveBoneBuilder builder;
        private boolean baseAdded;

        public SingleRestraintBuilder(float angleRadians, @NotNull Vector3f currentPos) {
            Intrinsics.checkNotNullParameter((Object)currentPos, (String)"currentPos");
            this.angleRadians = angleRadians;
            this.currentPos = currentPos;
            FabrikChain3f.BaseBoneBuilder baseBoneBuilder = FabrikChain3f.builder();
            Intrinsics.checkNotNullExpressionValue((Object)baseBoneBuilder, (String)"builder(...)");
            this.chain = baseBoneBuilder;
        }

        public final float getAngleRadians() {
            return this.angleRadians;
        }

        public final void rotor(@NotNull Function1<? super SingleRestraintBuilder, ? extends Vector3f> init) {
            Intrinsics.checkNotNullParameter(init, (String)"init");
            Vector3f pos = (Vector3f)init.invoke((Object)this);
            Vector3f normal = PositionUtil.normalFacing(this.currentPos, pos);
            float distance = this.currentPos.distance((Vector3fc)pos);
            if (this.baseAdded) {
                FabrikChain3f.ConsecutiveBoneBuilder consecutiveBoneBuilder = this.builder;
                if (consecutiveBoneBuilder == null) {
                    Intrinsics.throwUninitializedPropertyAccessException((String)"builder");
                    consecutiveBoneBuilder = null;
                }
                FabrikChain3f.ConsecutiveBoneBuilder consecutiveBoneBuilder2 = consecutiveBoneBuilder.addRotorConstrainedBone((Vector3fc)normal, distance, this.angleRadians, true);
                Intrinsics.checkNotNull((Object)consecutiveBoneBuilder2);
            } else {
                FabrikChain3f.ConsecutiveBoneBuilder consecutiveBoneBuilder = this.chain.addRotorConstrainedBaseBone((Vector3fc)pos, (Vector3fc)normal, distance, this.angleRadians, false);
                Intrinsics.checkNotNullExpressionValue((Object)consecutiveBoneBuilder, (String)"addRotorConstrainedBaseBone(...)");
                this.builder = consecutiveBoneBuilder;
                this.baseAdded = true;
            }
            this.currentPos = pos;
        }

        @NotNull
        public final IKChain build() {
            FabrikChain3f.ConsecutiveBoneBuilder consecutiveBoneBuilder = this.builder;
            if (consecutiveBoneBuilder == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"builder");
                consecutiveBoneBuilder = null;
            }
            FabrikChain3f fabrikChain3f = consecutiveBoneBuilder.build();
            Intrinsics.checkNotNullExpressionValue((Object)fabrikChain3f, (String)"build(...)");
            FabrikChain3f chain = fabrikChain3f;
            if (!(chain.getBoneCount() >= 2)) {
                boolean bl = false;
                String string = "IKChain must have more than 1 bone or 3 joints";
                throw new IllegalStateException(string.toString());
            }
            return new IKChain(chain, null);
        }
    }
}

