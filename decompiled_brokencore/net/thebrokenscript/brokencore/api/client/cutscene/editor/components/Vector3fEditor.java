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
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference0Impl
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KMutableProperty0
 *  net.minecraft.ChatFormatting
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3f
 */
package net.thebrokenscript.brokencore.api.client.cutscene.editor.components;

import io.wispforest.owo.ui.container.FlowLayout;
import io.wispforest.owo.ui.core.Sizing;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KMutableProperty0;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.components.FloatBox;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.util.Flows;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.util.OwoDSLKt;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000f\u001a\u00020\u0006H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/api/client/cutscene/editor/components/Vector3fEditor;", "Lio/wispforest/owo/ui/container/FlowLayout;", "vector", "Lorg/joml/Vector3f;", "update", "Lkotlin/Function0;", "", "<init>", "(Lorg/joml/Vector3f;Lkotlin/jvm/functions/Function0;)V", "getVector", "()Lorg/joml/Vector3f;", "updateCallbacks", "", "getUpdateCallbacks", "()Ljava/util/List;", "triggerUpdate", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nVector3fEditor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Vector3fEditor.kt\nnet/thebrokenscript/brokencore/api/client/cutscene/editor/components/Vector3fEditor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,41:1\n1869#2,2:42\n72#3:44\n15#3:45\n49#3:46\n29#3:47\n24#3:48\n70#3:49\n15#3:50\n47#3:51\n29#3:52\n24#3:53\n69#3:54\n15#3:55\n46#3:56\n29#3:57\n24#3:58\n*S KotlinDebug\n*F\n+ 1 Vector3fEditor.kt\nnet/thebrokenscript/brokencore/api/client/cutscene/editor/components/Vector3fEditor\n*L\n19#1:42,2\n24#1:44\n24#1:45\n24#1:46\n24#1:47\n24#1:48\n30#1:49\n30#1:50\n30#1:51\n30#1:52\n30#1:53\n36#1:54\n36#1:55\n36#1:56\n36#1:57\n36#1:58\n*E\n"})
public final class Vector3fEditor
extends FlowLayout {
    @NotNull
    private final Vector3f vector;
    @NotNull
    private final List<Function0<Unit>> updateCallbacks;

    @JvmOverloads
    public Vector3fEditor(@NotNull Vector3f vector, @NotNull Function0<Unit> update) {
        Intrinsics.checkNotNullParameter((Object)vector, (String)"vector");
        Intrinsics.checkNotNullParameter(update, (String)"update");
        super(Sizing.content(), Sizing.content(), FlowLayout.Algorithm.VERTICAL);
        this.vector = vector;
        Object[] objectArray = new Function0[]{update};
        this.updateCallbacks = CollectionsKt.mutableListOf((Object[])objectArray);
        this.child((io.wispforest.owo.ui.core.Component)Flows.INSTANCE.horizontal((Function1<? super FlowLayout, Unit>)((Function1)arg_0 -> Vector3fEditor._init_$lambda$1(this, arg_0))));
        this.child((io.wispforest.owo.ui.core.Component)Flows.INSTANCE.horizontal((Function1<? super FlowLayout, Unit>)((Function1)arg_0 -> Vector3fEditor._init_$lambda$2(this, arg_0))));
        this.child((io.wispforest.owo.ui.core.Component)Flows.INSTANCE.horizontal((Function1<? super FlowLayout, Unit>)((Function1)arg_0 -> Vector3fEditor._init_$lambda$3(this, arg_0))));
    }

    public /* synthetic */ Vector3fEditor(Vector3f vector3f, Function0 function0, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            function0 = Vector3fEditor::_init_$lambda$0;
        }
        this(vector3f, (Function0<Unit>)function0);
    }

    @NotNull
    public final Vector3f getVector() {
        return this.vector;
    }

    @NotNull
    public final List<Function0<Unit>> getUpdateCallbacks() {
        return this.updateCallbacks;
    }

    private final void triggerUpdate() {
        Iterable $this$forEach$iv = this.updateCallbacks;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Function0 it = (Function0)element$iv;
            boolean bl = false;
            it.invoke();
        }
    }

    @JvmOverloads
    public Vector3fEditor(@NotNull Vector3f vector) {
        Intrinsics.checkNotNullParameter((Object)vector, (String)"vector");
        this(vector, null, 2, null);
    }

    private static final Unit _init_$lambda$0() {
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit _init_$lambda$1(Vector3fEditor this$0, FlowLayout $this$horizontal) {
        void $this$with$iv$iv$iv;
        void $this$red$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$horizontal, (String)"$this$horizontal");
        String $this$red$iv = "X:";
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
        $this$horizontal.child((io.wispforest.owo.ui.core.Component)new FloatBox(sizing, (KMutableProperty0<Float>)((KMutableProperty0)new MutablePropertyReference0Impl(this$0.vector){

            public Object get() {
                return Float.valueOf(((Vector3f)this.receiver).x);
            }

            public void set(Object value) {
                ((Vector3f)this.receiver).x = ((Number)value).floatValue();
            }
        }), (Function0<Unit>)((Function0)new Function0<Unit>((Object)this$0){

            public final void invoke() {
                Vector3fEditor.access$triggerUpdate((Vector3fEditor)((Object)this.receiver));
            }
        })));
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit _init_$lambda$2(Vector3fEditor this$0, FlowLayout $this$horizontal) {
        void $this$with$iv$iv$iv;
        void $this$green$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$horizontal, (String)"$this$horizontal");
        String $this$green$iv = "Y:";
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
        OwoDSLKt.spacer($this$horizontal, 3, 1);
        Sizing sizing = Sizing.fixed((int)80);
        Intrinsics.checkNotNullExpressionValue((Object)sizing, (String)"fixed(...)");
        $this$horizontal.child((io.wispforest.owo.ui.core.Component)new FloatBox(sizing, (KMutableProperty0<Float>)((KMutableProperty0)new MutablePropertyReference0Impl(this$0.vector){

            public Object get() {
                return Float.valueOf(((Vector3f)this.receiver).y);
            }

            public void set(Object value) {
                ((Vector3f)this.receiver).y = ((Number)value).floatValue();
            }
        }), (Function0<Unit>)((Function0)new Function0<Unit>((Object)this$0){

            public final void invoke() {
                Vector3fEditor.access$triggerUpdate((Vector3fEditor)((Object)this.receiver));
            }
        })));
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit _init_$lambda$3(Vector3fEditor this$0, FlowLayout $this$horizontal) {
        void $this$with$iv$iv$iv;
        void $this$blue$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$horizontal, (String)"$this$horizontal");
        String $this$blue$iv = "Z:";
        boolean $i$f$getBlue = false;
        String $this$c$iv$iv = $this$blue$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getBlue2 = false;
        void var6_6 = $this$blue$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.BLUE;
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
        $this$horizontal.child((io.wispforest.owo.ui.core.Component)new FloatBox(sizing, (KMutableProperty0<Float>)((KMutableProperty0)new MutablePropertyReference0Impl(this$0.vector){

            public Object get() {
                return Float.valueOf(((Vector3f)this.receiver).z);
            }

            public void set(Object value) {
                ((Vector3f)this.receiver).z = ((Number)value).floatValue();
            }
        }), (Function0<Unit>)((Function0)new Function0<Unit>((Object)this$0){

            public final void invoke() {
                Vector3fEditor.access$triggerUpdate((Vector3fEditor)((Object)this.receiver));
            }
        })));
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void access$triggerUpdate(Vector3fEditor $this) {
        $this.triggerUpdate();
    }
}

