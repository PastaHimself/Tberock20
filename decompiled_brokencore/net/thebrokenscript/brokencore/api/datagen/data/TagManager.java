/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.internal.markers.KMappedMarker
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.datagen.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import net.thebrokenscript.brokencore.api.registry.objects.TagObject;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0086\u0002J \u0010\t\u001a\u00020\n2\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\fH\u0086\u0002\u00a2\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u000fH\u0096\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011R\u001b\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/brokencore/api/datagen/data/TagManager;", "", "Lnet/thebrokenscript/brokencore/api/registry/objects/TagObject;", "<init>", "()V", "tags", "", "getTags", "()Ljava/util/List;", "plusAssign", "", "tag", "", "([Lnet/thebrokenscript/brokencore/api/registry/objects/TagObject;)V", "iterator", "", "isEmpty", "", "isNotEmpty", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nTagManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TagManager.kt\nnet/thebrokenscript/brokencore/api/datagen/data/TagManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,15:1\n1#2:16\n*E\n"})
public final class TagManager
implements Iterable<TagObject<?>>,
KMappedMarker {
    @NotNull
    private final List<TagObject<?>> tags = new ArrayList();

    @NotNull
    public final List<TagObject<?>> getTags() {
        return this.tags;
    }

    public final void plusAssign(@NotNull TagObject<?> tag) {
        Intrinsics.checkNotNullParameter(tag, (String)"tag");
        TagManager $this$plusAssign_u24lambda_u240 = this;
        boolean bl = false;
        $this$plusAssign_u24lambda_u240.tags.add(tag);
    }

    public final void plusAssign(@NotNull TagObject<?>[] tags2) {
        Intrinsics.checkNotNullParameter(tags2, (String)"tags");
        TagManager $this$plusAssign_u24lambda_u241 = this;
        boolean bl = false;
        CollectionsKt.addAll((Collection)$this$plusAssign_u24lambda_u241.tags, (Object[])tags2);
    }

    @Override
    @NotNull
    public Iterator<TagObject<?>> iterator() {
        return this.tags.iterator();
    }

    public final boolean isEmpty() {
        return this.tags.isEmpty();
    }

    public final boolean isNotEmpty() {
        return !((Collection)this.tags).isEmpty();
    }
}

