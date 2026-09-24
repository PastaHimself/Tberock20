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
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference0Impl
 *  kotlin.reflect.KMutableProperty0
 *  net.thebrokenscript.brokencore.api.client.cutscene.editor.components.FloatBox
 *  net.thebrokenscript.brokencore.api.client.cutscene.editor.components.IntBox
 *  net.thebrokenscript.brokencore.api.client.cutscene.editor.components.Vector3fEditor
 *  net.thebrokenscript.brokencore.api.client.cutscene.editor.util.Flows
 *  net.thebrokenscript.brokencore.api.client.cutscene.editor.util.OwoDSLKt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.client.cutscene;

import io.wispforest.owo.ui.container.FlowLayout;
import io.wispforest.owo.ui.core.Component;
import io.wispforest.owo.ui.core.Sizing;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.reflect.KMutableProperty0;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.components.FloatBox;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.components.IntBox;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.components.Vector3fEditor;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.util.Flows;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.util.OwoDSLKt;
import net.thebrokenscript.client.tentacles.TentacleInfo;
import net.thebrokenscript.cutscene.TentacleNode;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/client/cutscene/TentacleNodeEditor;", "Lio/wispforest/owo/ui/container/FlowLayout;", "tentacle", "Lnet/thebrokenscript/cutscene/TentacleNode;", "<init>", "(Lnet/thebrokenscript/cutscene/TentacleNode;)V", "getTentacle", "()Lnet/thebrokenscript/cutscene/TentacleNode;", "thebrokenscript-common"})
public final class TentacleNodeEditor
extends FlowLayout {
    @NotNull
    private final TentacleNode tentacle;

    public TentacleNodeEditor(@NotNull TentacleNode tentacle) {
        Intrinsics.checkNotNullParameter((Object)((Object)tentacle), (String)"tentacle");
        super(Sizing.content(), Sizing.content(), FlowLayout.Algorithm.VERTICAL);
        this.tentacle = tentacle;
        OwoDSLKt.text((FlowLayout)this, (String)"Start");
        OwoDSLKt.spacer((FlowLayout)this, (int)1, (int)5);
        this.child((Component)new Vector3fEditor(this.tentacle.getInfo().getStart(), (Function0)new Function0<Unit>((Object)this.tentacle){

            public final void invoke() {
                ((TentacleNode)((Object)this.receiver)).liveUpdate();
            }
        }));
        OwoDSLKt.spacer((FlowLayout)this, (int)1, (int)15);
        OwoDSLKt.text((FlowLayout)this, (String)"End");
        OwoDSLKt.spacer((FlowLayout)this, (int)1, (int)5);
        this.child((Component)new Vector3fEditor(this.tentacle.getInfo().getEnd(), (Function0)new Function0<Unit>((Object)this.tentacle){

            public final void invoke() {
                ((TentacleNode)((Object)this.receiver)).liveUpdate();
            }
        }));
        OwoDSLKt.spacer((FlowLayout)this, (int)1, (int)15);
        OwoDSLKt.text((FlowLayout)this, (String)"Rotator");
        OwoDSLKt.spacer((FlowLayout)this, (int)1, (int)5);
        this.child((Component)new Vector3fEditor(this.tentacle.getInfo().getRotator(), (Function0)new Function0<Unit>((Object)this.tentacle){

            public final void invoke() {
                ((TentacleNode)((Object)this.receiver)).liveUpdate();
            }
        }));
        OwoDSLKt.spacer((FlowLayout)this, (int)1, (int)15);
        this.child((Component)Flows.INSTANCE.horizontal(arg_0 -> TentacleNodeEditor._init_$lambda$0(this, arg_0)));
        OwoDSLKt.spacer((FlowLayout)this, (int)1, (int)5);
        this.child((Component)Flows.INSTANCE.horizontal(arg_0 -> TentacleNodeEditor._init_$lambda$1(this, arg_0)));
        OwoDSLKt.spacer((FlowLayout)this, (int)1, (int)5);
        this.child((Component)Flows.INSTANCE.horizontal(arg_0 -> TentacleNodeEditor._init_$lambda$2(this, arg_0)));
    }

    @NotNull
    public final TentacleNode getTentacle() {
        return this.tentacle;
    }

    private static final Unit _init_$lambda$0(TentacleNodeEditor this$0, FlowLayout $this$horizontal) {
        Intrinsics.checkNotNullParameter((Object)$this$horizontal, (String)"$this$horizontal");
        OwoDSLKt.text((FlowLayout)$this$horizontal, (String)"Size:");
        OwoDSLKt.spacer((FlowLayout)$this$horizontal, (int)39, (int)1);
        Sizing sizing = Sizing.fixed((int)80);
        Intrinsics.checkNotNullExpressionValue((Object)sizing, (String)"fixed(...)");
        $this$horizontal.child((Component)new FloatBox(sizing, (KMutableProperty0)new MutablePropertyReference0Impl(this$0.tentacle.getInfo()){

            public Object get() {
                return Float.valueOf(((TentacleInfo)this.receiver).getSize());
            }

            public void set(Object value) {
                ((TentacleInfo)this.receiver).setSize(((Number)value).floatValue());
            }
        }, null, 4, null));
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$1(TentacleNodeEditor this$0, FlowLayout $this$horizontal) {
        Intrinsics.checkNotNullParameter((Object)$this$horizontal, (String)"$this$horizontal");
        OwoDSLKt.text((FlowLayout)$this$horizontal, (String)"Resolution:");
        OwoDSLKt.spacer((FlowLayout)$this$horizontal, (int)8, (int)1);
        Sizing sizing = Sizing.fixed((int)80);
        Intrinsics.checkNotNullExpressionValue((Object)sizing, (String)"fixed(...)");
        $this$horizontal.child((Component)new FloatBox(sizing, (KMutableProperty0)new MutablePropertyReference0Impl(this$0.tentacle.getInfo()){

            public Object get() {
                return Float.valueOf(((TentacleInfo)this.receiver).getResolution());
            }

            public void set(Object value) {
                ((TentacleInfo)this.receiver).setResolution(((Number)value).floatValue());
            }
        }, null, 4, null));
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$2(TentacleNodeEditor this$0, FlowLayout $this$horizontal) {
        Intrinsics.checkNotNullParameter((Object)$this$horizontal, (String)"$this$horizontal");
        OwoDSLKt.text((FlowLayout)$this$horizontal, (String)"Sides:");
        OwoDSLKt.spacer((FlowLayout)$this$horizontal, (int)33, (int)1);
        Sizing sizing = Sizing.fixed((int)80);
        Intrinsics.checkNotNullExpressionValue((Object)sizing, (String)"fixed(...)");
        $this$horizontal.child((Component)new IntBox(sizing, (KMutableProperty0)new MutablePropertyReference0Impl(this$0.tentacle.getInfo()){

            public Object get() {
                return ((TentacleInfo)this.receiver).getSideRes();
            }

            public void set(Object value) {
                ((TentacleInfo)this.receiver).setSideRes(((Number)value).intValue());
            }
        }, null, 4, null));
        return Unit.INSTANCE;
    }
}

