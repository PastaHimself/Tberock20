/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.SerialName
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  net.minecraft.ChatFormatting
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.misc;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.thebrokenscript.misc.CreditInfo;
import net.thebrokenscript.misc.CreditSubtitle$;
import org.jetbrains.annotations.NotNull;

@Serializable
@SerialName(value="subtitle")
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0004\u0010\nJ\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J%\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001\u00a2\u0006\u0002\b\u001aR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u001d"}, d2={"Lnet/thebrokenscript/misc/CreditSubtitle;", "Lnet/thebrokenscript/misc/CreditInfo;", "content", "", "<init>", "(Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getContent", "()Ljava/lang/String;", "render", "", "Lnet/minecraft/network/chat/MutableComponent;", "scale", "", "spacing", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$thebrokenscript_common", "$serializer", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nCreditClasses.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CreditClasses.kt\nnet/thebrokenscript/misc/CreditSubtitle\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,101:1\n15#2:102\n54#2:103\n29#2:104\n24#2:105\n49#2:106\n29#2:107\n24#2:108\n*S KotlinDebug\n*F\n+ 1 CreditClasses.kt\nnet/thebrokenscript/misc/CreditSubtitle\n*L\n37#1:102\n37#1:103\n37#1:104\n37#1:105\n37#1:106\n37#1:107\n37#1:108\n*E\n"})
public final class CreditSubtitle
extends CreditInfo {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String content;

    public CreditSubtitle(@NotNull String content) {
        Intrinsics.checkNotNullParameter((Object)content, (String)"content");
        this.content = content;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public List<MutableComponent> render() {
        Component $this$with$iv$iv;
        String $this$c$iv = this.content;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        Component $this$bold$iv = component;
        boolean $i$f$getBold = false;
        Component component2 = $this$bold$iv;
        ChatFormatting other$iv$iv = ChatFormatting.BOLD;
        boolean $i$f$with = false;
        Component $this$mut$iv$iv$iv = $this$with$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        Component $this$red$iv = (Component)mutableComponent3;
        boolean $i$f$getRed = false;
        $this$with$iv$iv = $this$red$iv;
        other$iv$iv = ChatFormatting.RED;
        $i$f$with = false;
        $this$mut$iv$iv$iv = $this$with$iv$iv;
        $i$f$mut = false;
        MutableComponent mutableComponent4 = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
        if (mutableComponent4 == null) {
            MutableComponent mutableComponent5 = $this$mut$iv$iv$iv.copy();
            mutableComponent4 = mutableComponent5;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent5, (String)"copy(...)");
        }
        MutableComponent mutableComponent6 = mutableComponent4.withStyle(other$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent6, (String)"withStyle(...)");
        return CollectionsKt.listOf((Object)mutableComponent6);
    }

    @Override
    public float scale() {
        return 1.0f;
    }

    @Override
    public int spacing() {
        return 10;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$thebrokenscript_common(CreditSubtitle self, CompositeEncoder output, SerialDescriptor serialDesc) {
        CreditInfo.write$Self(self, output, serialDesc);
        output.encodeStringElement(serialDesc, 0, self.content);
    }

    public /* synthetic */ CreditSubtitle(int seen0, String content, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (1 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)1, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        super(seen0, serializationConstructorMarker);
        this.content = content;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/misc/CreditSubtitle$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lnet/thebrokenscript/misc/CreditSubtitle;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KSerializer<CreditSubtitle> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

