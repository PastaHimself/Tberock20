/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.Holder
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.tags.TagKey
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.registry.objects;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002Bc\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0006\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u0006\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/objects/TagObject;", "T", "", "key", "Lnet/minecraft/tags/TagKey;", "entries", "", "Lnet/minecraft/core/Holder;", "tagEntries", "optionalEntries", "Lnet/minecraft/resources/ResourceLocation;", "keyEntries", "Lnet/minecraft/resources/ResourceKey;", "<init>", "(Lnet/minecraft/tags/TagKey;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getKey", "()Lnet/minecraft/tags/TagKey;", "getEntries", "()Ljava/util/List;", "getTagEntries", "getOptionalEntries", "getKeyEntries", "brokencore-common"})
public final class TagObject<T> {
    @NotNull
    private final TagKey<T> key;
    @NotNull
    private final List<Holder<T>> entries;
    @NotNull
    private final List<TagKey<T>> tagEntries;
    @NotNull
    private final List<ResourceLocation> optionalEntries;
    @NotNull
    private final List<ResourceKey<T>> keyEntries;

    public TagObject(@NotNull TagKey<T> key, @NotNull List<Holder<T>> entries2, @NotNull List<TagKey<T>> tagEntries, @NotNull List<ResourceLocation> optionalEntries, @NotNull List<ResourceKey<T>> keyEntries) {
        Intrinsics.checkNotNullParameter(key, (String)"key");
        Intrinsics.checkNotNullParameter(entries2, (String)"entries");
        Intrinsics.checkNotNullParameter(tagEntries, (String)"tagEntries");
        Intrinsics.checkNotNullParameter(optionalEntries, (String)"optionalEntries");
        Intrinsics.checkNotNullParameter(keyEntries, (String)"keyEntries");
        this.key = key;
        this.entries = entries2;
        this.tagEntries = tagEntries;
        this.optionalEntries = optionalEntries;
        this.keyEntries = keyEntries;
    }

    public /* synthetic */ TagObject(TagKey tagKey, List list, List list2, List list3, List list4, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 8) != 0) {
            list3 = new ArrayList();
        }
        if ((n & 0x10) != 0) {
            list4 = new ArrayList();
        }
        this(tagKey, list, list2, list3, list4);
    }

    @NotNull
    public final TagKey<T> getKey() {
        return this.key;
    }

    @NotNull
    public final List<Holder<T>> getEntries() {
        return this.entries;
    }

    @NotNull
    public final List<TagKey<T>> getTagEntries() {
        return this.tagEntries;
    }

    @NotNull
    public final List<ResourceLocation> getOptionalEntries() {
        return this.optionalEntries;
    }

    @NotNull
    public final List<ResourceKey<T>> getKeyEntries() {
        return this.keyEntries;
    }
}

