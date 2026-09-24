/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.world.level.saveddata.SavedData
 *  net.minecraft.world.level.saveddata.SavedData$Factory
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.event;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.saveddata.SavedData;
import net.thebrokenscript.brokencore.api.ext.TagExt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0013\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/impl/event/StoryEventsData;", "Lnet/minecraft/world/level/saveddata/SavedData;", "time", "", "<init>", "(J)V", "getTime", "()J", "setTime", "save", "Lnet/minecraft/nbt/CompoundTag;", "tag", "registries", "Lnet/minecraft/core/HolderLookup$Provider;", "Companion", "brokencore-common"})
public final class StoryEventsData
extends SavedData {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private long time;
    @NotNull
    public static final String NAME = "brokencore$storyEventsData";
    @JvmField
    @NotNull
    public static final SavedData.Factory<StoryEventsData> FACTORY = new SavedData.Factory(() -> new StoryEventsData(0L, 1, null), Companion::load, null);

    @JvmOverloads
    public StoryEventsData(long time2) {
        this.time = time2;
    }

    public /* synthetic */ StoryEventsData(long l, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            l = 0L;
        }
        this(l);
    }

    public final long getTime() {
        return this.time;
    }

    public final void setTime(long l) {
        this.time = l;
    }

    @NotNull
    public CompoundTag save(@NotNull CompoundTag tag, @NotNull HolderLookup.Provider registries) {
        CompoundTag compoundTag;
        Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
        Intrinsics.checkNotNullParameter((Object)registries, (String)"registries");
        CompoundTag $this$save_u24lambda_u240 = compoundTag = tag;
        boolean bl = false;
        $this$save_u24lambda_u240.putLong("time", this.time);
        return compoundTag;
    }

    @JvmOverloads
    public StoryEventsData() {
        this(0L, 1, null);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R$\u0010\f\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00070\u00070\r8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0003\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/impl/event/StoryEventsData$Companion;", "", "<init>", "()V", "NAME", "", "load", "Lnet/thebrokenscript/brokencore/impl/event/StoryEventsData;", "tag", "Lnet/minecraft/nbt/CompoundTag;", "prov", "Lnet/minecraft/core/HolderLookup$Provider;", "FACTORY", "Lnet/minecraft/world/level/saveddata/SavedData$Factory;", "kotlin.jvm.PlatformType", "getFACTORY$annotations", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final StoryEventsData load(@NotNull CompoundTag tag, @NotNull HolderLookup.Provider prov) {
            Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
            Intrinsics.checkNotNullParameter((Object)prov, (String)"prov");
            Long l = TagExt.INSTANCE.getOptionalLong(tag, "time");
            return new StoryEventsData(l != null ? l : 0L);
        }

        public static /* synthetic */ void getFACTORY$annotations() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

