/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.entity.Entity
 *  net.neoforged.neoforge.attachment.AttachmentType
 *  net.neoforged.neoforge.registries.NeoForgeRegistries$Keys
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.neoforge;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.thebrokenscript.brokencore.api.data.DataAttachment;
import net.thebrokenscript.brokencore.api.data.NbtSerializable;
import net.thebrokenscript.brokencore.api.platform.PlatformAttachments;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.brokencore.neoforge.DataAttachmentImpl;
import net.thebrokenscript.brokencore.neoforge.NbtSerializableWrapper;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00060\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/brokencore/neoforge/PlatformAttachmentsImpl;", "Lnet/thebrokenscript/brokencore/api/platform/PlatformAttachments;", "<init>", "()V", "register", "Lnet/thebrokenscript/brokencore/api/data/DataAttachment;", "T", "Lnet/thebrokenscript/brokencore/api/data/NbtSerializable;", "reg", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "id", "", "ctor", "Lkotlin/Function0;", "getPersistentData", "Lnet/minecraft/nbt/CompoundTag;", "entity", "Lnet/minecraft/world/entity/Entity;", "brokencore-neoforge"})
public final class PlatformAttachmentsImpl
implements PlatformAttachments {
    @Override
    @NotNull
    public <T extends NbtSerializable> DataAttachment<T> register(@NotNull BrokenReg reg, @NotNull String id, @NotNull Function0<? extends T> ctor) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        ResourceKey resourceKey = NeoForgeRegistries.Keys.ATTACHMENT_TYPES;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"ATTACHMENT_TYPES");
        return new DataAttachmentImpl((Function0)new Function0<AttachmentType<NbtSerializableWrapper<T>>>(reg.generic(resourceKey, id, () -> PlatformAttachmentsImpl.register$lambda$0(ctor))){

            public final AttachmentType<NbtSerializableWrapper<T>> invoke() {
                return (AttachmentType)((RegistryEntry)this.receiver).get();
            }
        });
    }

    @Override
    @NotNull
    public CompoundTag getPersistentData(@NotNull Entity entity) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        CompoundTag compoundTag = entity.getPersistentData();
        Intrinsics.checkNotNullExpressionValue((Object)compoundTag, (String)"getPersistentData(...)");
        return compoundTag;
    }

    private static final AttachmentType register$lambda$0(Function0 $ctor) {
        return AttachmentType.serializable(() -> PlatformAttachmentsImpl.register$lambda$0$0($ctor)).copyOnDeath().build();
    }

    private static final NbtSerializableWrapper register$lambda$0$0(Function0 $ctor) {
        return new NbtSerializableWrapper<NbtSerializable>((NbtSerializable)$ctor.invoke());
    }
}

