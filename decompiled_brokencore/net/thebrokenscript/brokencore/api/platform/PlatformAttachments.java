/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.world.entity.Entity
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.platform;

import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.thebrokenscript.brokencore.api.data.DataAttachment;
import net.thebrokenscript.brokencore.api.data.NbtSerializable;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J6\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00040\u000bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/brokencore/api/platform/PlatformAttachments;", "", "register", "Lnet/thebrokenscript/brokencore/api/data/DataAttachment;", "T", "Lnet/thebrokenscript/brokencore/api/data/NbtSerializable;", "reg", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "id", "", "ctor", "Lkotlin/Function0;", "getPersistentData", "Lnet/minecraft/nbt/CompoundTag;", "entity", "Lnet/minecraft/world/entity/Entity;", "Companion", "brokencore-common"})
public interface PlatformAttachments {
    @NotNull
    public static final Companion Companion = net.thebrokenscript.brokencore.api.platform.PlatformAttachments$Companion.$$INSTANCE;

    @NotNull
    public <T extends NbtSerializable> DataAttachment<T> register(@NotNull BrokenReg var1, @NotNull String var2, @NotNull Function0<? extends T> var3);

    @NotNull
    public CompoundTag getPersistentData(@NotNull Entity var1);

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J7\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\n0\u0011H\u0096\u0001\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/brokencore/api/platform/PlatformAttachments$Companion;", "Lnet/thebrokenscript/brokencore/api/platform/PlatformAttachments;", "<init>", "()V", "getPersistentData", "Lnet/minecraft/nbt/CompoundTag;", "entity", "Lnet/minecraft/world/entity/Entity;", "register", "Lnet/thebrokenscript/brokencore/api/data/DataAttachment;", "T", "Lnet/thebrokenscript/brokencore/api/data/NbtSerializable;", "reg", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "id", "", "ctor", "Lkotlin/Function0;", "brokencore-common"})
    public static final class Companion
    implements PlatformAttachments {
        static final /* synthetic */ Companion $$INSTANCE;
        private final /* synthetic */ PlatformAttachments $$delegate_0;

        private Companion() {
            ServiceLoader<PlatformAttachments> serviceLoader = ServiceLoader.load(PlatformAttachments.class);
            Intrinsics.checkNotNullExpressionValue(serviceLoader, (String)"load(...)");
            this.$$delegate_0 = (PlatformAttachments)CollectionsKt.first((Iterable)serviceLoader);
        }

        @Override
        @NotNull
        public <T extends NbtSerializable> DataAttachment<T> register(@NotNull BrokenReg reg, @NotNull String id, @NotNull Function0<? extends T> ctor) {
            Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
            Intrinsics.checkNotNullParameter((Object)id, (String)"id");
            Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
            return this.$$delegate_0.register(reg, id, ctor);
        }

        @Override
        @NotNull
        public CompoundTag getPersistentData(@NotNull Entity entity) {
            Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
            return this.$$delegate_0.getPersistentData(entity);
        }

        static {
            $$INSTANCE = new Companion();
        }
    }
}

