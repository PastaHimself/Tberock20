/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.descriptors.PrimitiveKind
 *  kotlinx.serialization.descriptors.PrimitiveKind$STRING
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.descriptors.SerialDescriptorsKt
 *  kotlinx.serialization.encoding.Decoder
 *  kotlinx.serialization.encoding.Encoder
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.serde;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/brokencore/api/serde/ResourceLocationSerializer;", "Lkotlinx/serialization/KSerializer;", "Lnet/minecraft/resources/ResourceLocation;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "brokencore-common"})
public final class ResourceLocationSerializer
implements KSerializer<ResourceLocation> {
    @NotNull
    public static final ResourceLocationSerializer INSTANCE = new ResourceLocationSerializer();
    @NotNull
    private static final SerialDescriptor descriptor;

    private ResourceLocationSerializer() {
    }

    @NotNull
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(@NotNull Encoder encoder, @NotNull ResourceLocation value) {
        Intrinsics.checkNotNullParameter((Object)encoder, (String)"encoder");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        String string = value.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        encoder.encodeString(string);
    }

    @NotNull
    public ResourceLocation deserialize(@NotNull Decoder decoder) {
        Intrinsics.checkNotNullParameter((Object)decoder, (String)"decoder");
        ResourceLocation resourceLocation = ResourceLocation.parse((String)decoder.decodeString());
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"parse(...)");
        return resourceLocation;
    }

    static {
        String string = Reflection.getOrCreateKotlinClass(ResourceLocation.class).getQualifiedName();
        Intrinsics.checkNotNull((Object)string);
        descriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor((String)string, (PrimitiveKind)((PrimitiveKind)PrimitiveKind.STRING.INSTANCE));
    }
}

