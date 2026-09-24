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
 *  net.minecraft.network.chat.Component
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
import net.minecraft.network.chat.Component;
import net.thebrokenscript.misc.CreditDivider$;
import net.thebrokenscript.misc.CreditInfo;
import org.jetbrains.annotations.NotNull;

@Serializable
@SerialName(value="divider")
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003B\u001b\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\u0002\u0010\bJ\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J%\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0001\u00a2\u0006\u0002\b\u0013\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/misc/CreditDivider;", "Lnet/thebrokenscript/misc/CreditInfo;", "<init>", "()V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "render", "", "Lnet/minecraft/network/chat/Component;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$thebrokenscript_common", "$serializer", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nCreditClasses.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CreditClasses.kt\nnet/thebrokenscript/misc/CreditDivider\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,101:1\n15#2:102\n*S KotlinDebug\n*F\n+ 1 CreditClasses.kt\nnet/thebrokenscript/misc/CreditDivider\n*L\n76#1:102\n*E\n"})
public final class CreditDivider
extends CreditInfo {
    @NotNull
    public static final Companion Companion = new Companion(null);

    public CreditDivider() {
    }

    @Override
    @NotNull
    public List<Component> render() {
        String $this$c$iv = "------------------";
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        return CollectionsKt.listOf((Object)component);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$thebrokenscript_common(CreditDivider self, CompositeEncoder output, SerialDescriptor serialDesc) {
        CreditInfo.write$Self(self, output, serialDesc);
    }

    public /* synthetic */ CreditDivider(int seen0, SerializationConstructorMarker serializationConstructorMarker) {
        if ((0 & seen0) != 0) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)0, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        super(seen0, serializationConstructorMarker);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/misc/CreditDivider$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lnet/thebrokenscript/misc/CreditDivider;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KSerializer<CreditDivider> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

