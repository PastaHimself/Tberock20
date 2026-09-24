/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.owo.ui.container.FlowLayout
 *  io.wispforest.owo.ui.container.FlowLayout$Algorithm
 *  io.wispforest.owo.ui.core.Component
 *  io.wispforest.owo.ui.core.Sizing
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference0Impl
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KMutableProperty0
 *  net.minecraft.ChatFormatting
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.cutscene.editor.nodes;

import io.wispforest.owo.ui.container.FlowLayout;
import io.wispforest.owo.ui.core.Sizing;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KMutableProperty0;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.components.FloatBox;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.components.Vector3fEditor;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.util.Flows;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.util.OwoDSLKt;
import net.thebrokenscript.brokencore.api.cutscene.nodes.TransformNode;
import net.thebrokenscript.brokencore.api.util.math.Rotation;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/api/client/cutscene/editor/nodes/TransformNodeEditor;", "Lio/wispforest/owo/ui/container/FlowLayout;", "transform", "Lnet/thebrokenscript/brokencore/api/cutscene/nodes/TransformNode;", "<init>", "(Lnet/thebrokenscript/brokencore/api/cutscene/nodes/TransformNode;)V", "getTransform", "()Lnet/thebrokenscript/brokencore/api/cutscene/nodes/TransformNode;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nTransformNodeEditor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransformNodeEditor.kt\nnet/thebrokenscript/brokencore/api/client/cutscene/editor/nodes/TransformNodeEditor\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,42:1\n72#2:43\n15#2:44\n49#2:45\n29#2:46\n24#2:47\n70#2:48\n15#2:49\n47#2:50\n29#2:51\n24#2:52\n*S KotlinDebug\n*F\n+ 1 TransformNodeEditor.kt\nnet/thebrokenscript/brokencore/api/client/cutscene/editor/nodes/TransformNodeEditor\n*L\n29#1:43\n29#1:44\n29#1:45\n29#1:46\n29#1:47\n36#1:48\n36#1:49\n36#1:50\n36#1:51\n36#1:52\n*E\n"})
public final class TransformNodeEditor
extends FlowLayout {
    @NotNull
    private final TransformNode transform;

    public TransformNodeEditor(@NotNull TransformNode transform2) {
        Intrinsics.checkNotNullParameter((Object)transform2, (String)"transform");
        super(Sizing.content(), Sizing.content(), FlowLayout.Algorithm.VERTICAL);
        this.transform = transform2;
        OwoDSLKt.text((FlowLayout)this, "Position");
        OwoDSLKt.spacer(this, 1, 5);
        this.child((io.wispforest.owo.ui.core.Component)new Vector3fEditor(this.transform.getTransform().getPosition(), (Function0<Unit>)((Function0)new Function0<Unit>((Object)this.transform){

            public final void invoke() {
                ((TransformNode)this.receiver).liveUpdate();
            }
        })));
        OwoDSLKt.spacer(this, 1, 15);
        OwoDSLKt.text((FlowLayout)this, "Rotation");
        OwoDSLKt.spacer(this, 1, 5);
        this.child((io.wispforest.owo.ui.core.Component)Flows.INSTANCE.horizontal((Function1<? super FlowLayout, Unit>)((Function1)arg_0 -> TransformNodeEditor._init_$lambda$0(this, arg_0))));
        this.child((io.wispforest.owo.ui.core.Component)Flows.INSTANCE.horizontal((Function1<? super FlowLayout, Unit>)((Function1)arg_0 -> TransformNodeEditor._init_$lambda$1(this, arg_0))));
    }

    @NotNull
    public final TransformNode getTransform() {
        return this.transform;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit _init_$lambda$0(TransformNodeEditor this$0, FlowLayout $this$horizontal) {
        void $this$with$iv$iv$iv;
        void $this$red$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$horizontal, (String)"$this$horizontal");
        String $this$red$iv = "Pitch:";
        boolean $i$f$getRed = false;
        String $this$c$iv$iv = $this$red$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getRed2 = false;
        void var6_6 = $this$red$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.RED;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        OwoDSLKt.text($this$horizontal, (Component)mutableComponent3);
        OwoDSLKt.spacer($this$horizontal, 3, 1);
        Sizing sizing = Sizing.fixed((int)80);
        Intrinsics.checkNotNullExpressionValue((Object)sizing, (String)"fixed(...)");
        $this$horizontal.child((io.wispforest.owo.ui.core.Component)new FloatBox(sizing, (KMutableProperty0<Float>)((KMutableProperty0)new MutablePropertyReference0Impl(this$0.transform.getTransform().getRotation()){

            public Object get() {
                return Float.valueOf(((Rotation)this.receiver).getPitch());
            }

            public void set(Object value) {
                ((Rotation)this.receiver).setPitch(((Number)value).floatValue());
            }
        }), (Function0<Unit>)((Function0)new Function0<Unit>((Object)this$0.transform){

            public final void invoke() {
                ((TransformNode)this.receiver).liveUpdate();
            }
        })));
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit _init_$lambda$1(TransformNodeEditor this$0, FlowLayout $this$horizontal) {
        void $this$with$iv$iv$iv;
        void $this$green$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$horizontal, (String)"$this$horizontal");
        String $this$green$iv = "Yaw: ";
        boolean $i$f$getGreen = false;
        String $this$c$iv$iv = $this$green$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getGreen2 = false;
        void var6_6 = $this$green$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.GREEN;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        OwoDSLKt.text($this$horizontal, (Component)mutableComponent3);
        OwoDSLKt.spacer($this$horizontal, 5, 1);
        Sizing sizing = Sizing.fixed((int)80);
        Intrinsics.checkNotNullExpressionValue((Object)sizing, (String)"fixed(...)");
        $this$horizontal.child((io.wispforest.owo.ui.core.Component)new FloatBox(sizing, (KMutableProperty0<Float>)((KMutableProperty0)new MutablePropertyReference0Impl(this$0.transform.getTransform().getRotation()){

            public Object get() {
                return Float.valueOf(((Rotation)this.receiver).getYaw());
            }

            public void set(Object value) {
                ((Rotation)this.receiver).setYaw(((Number)value).floatValue());
            }
        }), (Function0<Unit>)((Function0)new Function0<Unit>((Object)this$0.transform){

            public final void invoke() {
                ((TransformNode)this.receiver).liveUpdate();
            }
        })));
        return Unit.INSTANCE;
    }
}

