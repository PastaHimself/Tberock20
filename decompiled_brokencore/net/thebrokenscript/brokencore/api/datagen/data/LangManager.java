/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.internal.markers.KMappedMarker
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.datagen.data;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010'\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0003H\u0086\u0002J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0003J\u0019\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0086\u0002J(\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00120\u0011H\u0086\u0002\u00a2\u0006\u0002\u0010\u0013J\u001d\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0014H\u0086\u0002J\u001b\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0016H\u0096\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Lnet/thebrokenscript/brokencore/api/datagen/data/LangManager;", "", "", "", "<init>", "()V", "entries", "", "get", "Lnet/minecraft/network/chat/MutableComponent;", "key", "getString", "set", "value", "plusAssign", "", "pair", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)V", "", "iterator", "", "isEmpty", "", "isNotEmpty", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nLangManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LangManager.kt\nnet/thebrokenscript/brokencore/api/datagen/data/LangManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,31:1\n1#2:32\n*E\n"})
public final class LangManager
implements Iterable<Map.Entry<String, String>>,
KMappedMarker {
    @NotNull
    private final Map<String, String> entries = new LinkedHashMap();

    @Nullable
    public final MutableComponent get(@NotNull String key) {
        MutableComponent mutableComponent;
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        String string = this.entries.get(key);
        if (string != null) {
            String it = string;
            boolean bl = false;
            mutableComponent = Component.literal((String)it);
        } else {
            mutableComponent = null;
        }
        return mutableComponent;
    }

    @Nullable
    public final MutableComponent getString(@NotNull String key) {
        MutableComponent mutableComponent;
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        String string = this.entries.get(key);
        if (string != null) {
            String it = string;
            boolean bl = false;
            mutableComponent = Component.literal((String)it);
        } else {
            mutableComponent = null;
        }
        return mutableComponent;
    }

    @NotNull
    public final MutableComponent set(@NotNull String key, @NotNull String value) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        this.entries.put(key, value);
        MutableComponent mutableComponent = Component.translatable((String)key);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"translatable(...)");
        return mutableComponent;
    }

    public final void plusAssign(@NotNull Pair<String, String>[] pair) {
        Intrinsics.checkNotNullParameter(pair, (String)"pair");
        MapsKt.putAll(this.entries, pair);
    }

    public final void plusAssign(@NotNull Map<String, String> pair) {
        Intrinsics.checkNotNullParameter(pair, (String)"pair");
        this.entries.putAll(pair);
    }

    @Override
    @NotNull
    public Iterator<Map.Entry<String, String>> iterator() {
        return this.entries.entrySet().iterator();
    }

    public final boolean isEmpty() {
        return this.entries.isEmpty();
    }

    public final boolean isNotEmpty() {
        return !this.entries.isEmpty();
    }
}

