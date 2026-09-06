/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.world.entity.Entity
 *  net.neoforged.neoforge.attachment.AttachmentType
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.neoforge;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.thebrokenscript.brokencore.api.data.DataAttachment;
import net.thebrokenscript.brokencore.api.data.NbtSerializable;
import net.thebrokenscript.brokencore.neoforge.NbtSerializableWrapper;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B!\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00060\u0005\u00a2\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0016\u00a2\u0006\u0002\u0010\rJ\u001d\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0011R \u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/brokencore/neoforge/DataAttachmentImpl;", "T", "Lnet/thebrokenscript/brokencore/api/data/NbtSerializable;", "Lnet/thebrokenscript/brokencore/api/data/DataAttachment;", "inner", "Lkotlin/Function0;", "Lnet/neoforged/neoforge/attachment/AttachmentType;", "Lnet/thebrokenscript/brokencore/neoforge/NbtSerializableWrapper;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "get", "entity", "Lnet/minecraft/world/entity/Entity;", "(Lnet/minecraft/world/entity/Entity;)Lnet/thebrokenscript/brokencore/api/data/NbtSerializable;", "set", "", "value", "(Lnet/minecraft/world/entity/Entity;Lnet/thebrokenscript/brokencore/api/data/NbtSerializable;)V", "brokencore-neoforge"})
@SourceDebugExtension(value={"SMAP\nDataAttachmentImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataAttachmentImpl.kt\nnet/thebrokenscript/brokencore/neoforge/DataAttachmentImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,12:1\n1#2:13\n*E\n"})
public final class DataAttachmentImpl<T extends NbtSerializable>
implements DataAttachment<T> {
    @NotNull
    private final Function0<AttachmentType<NbtSerializableWrapper<T>>> inner;

    public DataAttachmentImpl(@NotNull Function0<AttachmentType<NbtSerializableWrapper<T>>> inner) {
        Intrinsics.checkNotNullParameter(inner, (String)"inner");
        this.inner = inner;
    }

    @Override
    @NotNull
    public T get(@NotNull Entity entity) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        return ((NbtSerializableWrapper)entity.getData(() -> DataAttachmentImpl.get$lambda$0(this.inner))).getInner();
    }

    @Override
    public void set(@NotNull Entity entity, @NotNull T value) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter(value, (String)"value");
        DataAttachmentImpl $this$set_u24lambda_u240 = this;
        boolean bl = false;
        entity.setData(() -> DataAttachmentImpl.set$lambda$0$0($this$set_u24lambda_u240.inner), new NbtSerializableWrapper<T>(value));
    }

    private static final AttachmentType get$lambda$0(Function0 $tmp0) {
        return (AttachmentType)$tmp0.invoke();
    }

    private static final AttachmentType set$lambda$0$0(Function0 $tmp0) {
        return (AttachmentType)$tmp0.invoke();
    }
}

